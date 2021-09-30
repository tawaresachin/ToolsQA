package com.cybage.assignment.objects;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class utilities extends toolsqaBase
{
    static File source;
    static File dest;
    static File directory;
    static Sheet sheet;
    static Cell field;
    static Logger logger;
    static Actions act;
    static File dir;
    static DecimalFormat convert;
    static JavascriptExecutor js;
    static Iterator<String> iterator;
    static ArrayList<String> window;
    static Select select;
    static WebDriverWait wait;
    static LocalDateTime localDateTime;
    static String date;
    static SimpleDateFormat formatTime;
    static String time;
    static Alert alerts;
    static Workbook workbook;
    static boolean flag = true;
    static String st;
    static WebDriver.TargetLocator switchingTo;
    static Properties prop;

    public static void screenshot(WebDriver driver,String TCID) throws IOException                                    //Generic Screenshot utility
    {
       localDateTime= LocalDateTime.now();
       date=localDateTime.getMonthValue()+"_"+localDateTime.getDayOfWeek().getValue()+"_"+localDateTime.getYear();
       time=localDateTime.getHour()+"."+localDateTime.getMinute();
       directory = new File(genericProp(genPath,"screenshot")+date);
        if (! directory.exists())
        {
            directory.mkdir();
        }
       source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       dest=new File(genericProp(genPath,"screenshot")+date+"\\"+TCID+"_"+time+".jpeg");
       FileHandler.copy(source,dest);
    }

    public static String readWorkbook(String[] arr, int[] para) throws IOException                   //Generic Excel read utility
    {

        try {
            FileInputStream file = null;
            file = new FileInputStream(arr[0]);
            workbook = WorkbookFactory.create(file);
            sheet = workbook.getSheet(arr[1]);
            field = sheet.getRow(para[0]).getCell(para[1]);

            if ( field.getCellType() == CellType.NUMERIC )                                                  //check & convert Numeric to String
            {
                convert = new DecimalFormat("#");
                st = convert.format(field.getNumericCellValue());
            } else {
                st = field.getStringCellValue();                                                          //read String
            }
        } catch (FileNotFoundException e)
        {
            logs(e.toString());
        } catch (IOException e) {
            logs(e.toString());
        } catch (EncryptedDocumentException e)
        {
            logs(e.toString());
        } finally
        {
            workbook.close();
            file.close();
        }
             return st;
    }

    public static void logs(String str) throws IOException                                          //Logger for stdout & File
    {

        try {
            FileInputStream file=null;
            logger = Logger.getLogger(utilities.class);
            file = new FileInputStream(genericProp(genPath, "log4jFilePath"));
            PropertyConfigurator.configure(file);
            logger.info(str);
             }
        catch(Exception e)
        {
            logs(e.toString());
        }
    }

    public static Actions actOn(WebDriver driver)                                                   //Actions class object
    {
        act=new Actions(driver);
        return act;

    }

    public static WebElement Xpath(WebDriver driver, String locator)                                //xpath generic
    {
        return(driver.findElement(By.xpath(locator)));
    }

    public static List<WebElement> Xpaths(WebDriver driver, String locator)                                //xpath generic
    {
        return(driver.findElements(By.xpath(locator)));
    }

    public static void pageReadyWait(WebDriver driver)
    {
       wait=new WebDriverWait(driver,20);
       wait.until(webDriver
                -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
                    .equals("complete"));
    }

    public static void waitToBrowserMSEC(int time) throws InterruptedException                       //System wait
    {
        Thread.sleep(time);
    }
    public static Boolean waitForElementVisibilitySEC(WebDriver driver,WebElement element)                            //Wait until element is visible
    {
        wait=new WebDriverWait(driver,20);
        boolean displayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        return displayed;
    }
    public static boolean waitForElementToBeClickableSEC(WebDriver driver,WebElement element)                            //Wait until element is clickable
    {
        wait=new WebDriverWait(driver,20);
        return(wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled());
    }
    public static void implicitWaitSEC(WebDriver driver,int time)                                                     //Wait to load web-elements
    {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void scrollIntoView(WebDriver driver,WebElement ele)
    {
        js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",ele);
        return;
    }
    public static void scrollIntoWindow(WebDriver driver,int X, int Y)
    {
        js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(X,Y)");
        return;
    }

    public static WebDriver switchToWindow(WebDriver driver,int winNo)
    {
        window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(winNo));
        return driver;
    }
    public static Boolean checkDownload(String downloadPath, String fileName) throws FileNotFoundException
    {
        dir=new File(downloadPath);
        File[] dirContents = dir.listFiles();
        assert dirContents != null;
        for(File file:dirContents)
        {
            if(file.getName().contains(fileName))
            {
                flag=true;
                break;
            }
            else flag=false;
        }
        return flag;
    }

    public static Select selectElement(WebElement selElement)
    {
        select=new Select(selElement);
        return select;
    }

    public static String handleAlerts(WebDriver driver, String Action, String alertString)
    {
        String str=null;
        alerts=driver.switchTo().alert();
        switch(Action)
        {
            case "Accept":
                alerts.accept();
                break;
            case "Reject" :
                alerts.dismiss();
                break;
            case "sendMessageAccept" :
                alerts.sendKeys(alertString);
                alerts.accept();
                break;
            case "sendMessageReject" :
                alerts.sendKeys(alertString);
                alerts.dismiss();
                break;
            default:
                str=alerts.getText();
                break;
        }
        return str;
    }

    public static WebDriver.TargetLocator switchTo(WebDriver driver)
    {
        switchingTo = driver.switchTo();
        return switchingTo;
    }

    public static String genericProp(String path, String param) throws IOException       //Generic method to read properties file
    {
        file=new FileInputStream(path);
        prop=new Properties();
        prop.load(file);
        return (prop.getProperty(param));
    }

}
