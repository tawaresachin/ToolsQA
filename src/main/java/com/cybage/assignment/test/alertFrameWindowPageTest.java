package com.cybage.assignment.test;

import com.cybage.assignment.objects.locators;
import com.cybage.assignment.page.alertsFrameWindowPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.cybage.assignment.objects.toolsqaBase.*;
import static com.cybage.assignment.objects.utilities.*;

public class alertFrameWindowPageTest extends locators
{

    static final String TC="Test Case ";
    alertsFrameWindowPage alertFrameWindow;
    private String tcID;
    String str;
    SoftAssert ass;
    private WebDriver driver;
    private final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    @BeforeClass
    public void testSetUp() throws IOException
    {
        initialize();
        webdriver.set(browserFactory());
        driver=webdriver.get();
        driver.get(genericProp(appPath,"url"));
        driver.manage().window().maximize();
        implicitWaitSEC(driver,20);
        scrollIntoView(driver,Xpath(driver,alertFrameWindowTab));
        Xpath(driver,alertFrameWindowTab).click();
        alertFrameWindow=new alertsFrameWindowPage(driver);
    }
    @BeforeMethod
    public void waitToLoadElements() throws InterruptedException {

        ass=new SoftAssert();
        waitToBrowserMSEC(3000);
    }
    @Test
    public void validatePresenceOfAlertFrameWindowOptions()
    {
        tcID="TC023";
        ass.assertTrue(alertFrameWindow.checkPresenceOfBrowserWindowOption(driver),"Browser Window oOption is not accessible");
        ass.assertTrue(alertFrameWindow.checkPresenceOfAlertsOption(driver),"Alert option is not accessible");
        ass.assertTrue(alertFrameWindow.checkPresenceOfFramesOption(driver),"Frames option is not accessible");
        ass.assertTrue(alertFrameWindow.checkPresenceOfNestedFramesOption(driver),"Nested Frames option is not accessible");
        ass.assertTrue(alertFrameWindow.checkPresenceOfModalDialogsOption(driver),"Modal Dialogs option is not accessible");
        ass.assertAll();
    }

    @Test (dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateBrowserWindowOptions() throws InterruptedException
    {
        tcID="TC024";
        str="Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        ass.assertEquals(alertFrameWindow.clickOnBrowserWindowOption(driver),"Browser Windows");
        ass.assertTrue(alertFrameWindow.clickOnNewTabButton(driver),"New Tab button is not accessible");
        ass.assertTrue(alertFrameWindow.clickOnNewWindowButton(driver),"New Window button is not accessible");
        ass.assertTrue(alertFrameWindow.clickOnNewWindowMessageButton(driver),"New Window Message is not accessible");
        ass.assertAll();
    }
    @Test(dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateAlertsOption() throws InterruptedException {
        tcID="TC025";
        boolean result;
        ass.assertEquals(alertFrameWindow.clickOnAlertOption(driver),"Alerts");
        ass.assertTrue(alertFrameWindow.clickOnSimpleAlertButton(driver),"Simple Alert is not accessible");
        ass.assertTrue(alertFrameWindow.clickOnTimerAlertButton(driver),"Timer Alert is not accessible");
        result=alertFrameWindow.clickOnConfirmationAlertButton(driver,"Accept").contains("Ok");
        ass.assertTrue(result,"Invalid action-Need accept confirmation");
        result=alertFrameWindow.clickOnConfirmationAlertButton(driver,"Reject").contains("Cancel");
        ass.assertTrue(result,"Invalid action-Need cancel confirmation");
        result=alertFrameWindow.clickOnPromtAlertButton(driver,"sendMessageAccept","Please Accept").contains("Accept");
        ass.assertTrue(result,"Invalid action-Need to accept after sending Message");
        result=alertFrameWindow.clickOnPromtAlertButton(driver,"sendMessageReject","Please Reject").contains("Reject");
        ass.assertTrue(result,"Invalid action-Need to Reject after sending Message");
        ass.assertAll();
    }

    @Test (dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateIFrameOperations() throws InterruptedException {
        tcID="TC026";
        ass.assertEquals(alertFrameWindow.clickOnFramesOption(driver),"Frames");
        ass.assertEquals(alertFrameWindow.switchToSimpleFrame(driver),"Simple Frame");
        ass.assertEquals(alertFrameWindow.switchToScrollableFrame(driver),"Scrollable Frame");
        ass.assertEquals(alertFrameWindow.switchToDefaultContent(driver),"Frames");
        ass.assertAll();
    }

    @Test (dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateNestedFramesOperation()
    {
        tcID="TC027";
        ass.assertEquals(alertFrameWindow.clickOnNestedFramesOption(driver),"Nested Frames");
        ass.assertEquals(alertFrameWindow.switchToParentFrame(driver),"Parent frame");
        ass.assertEquals(alertFrameWindow.switchToChildFrame(driver),"Child Iframe");
        ass.assertEquals(alertFrameWindow.switchToParent(driver),"Parent frame");
        ass.assertEquals(alertFrameWindow.switchToMainContent(driver),"Nested Frames");
        ass.assertAll();
    }

    @Test (dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateModalDialogsOperation() throws IOException {
        tcID="TC028";
        String[] arr1={genericProp(genPath,"excelpath"),"Sheet2"};
        int[] arr2={0,0};
        String paragraph=readWorkbook(arr1,arr2);
        ass.assertEquals(alertFrameWindow.clickOnModalDialogOption(driver),"Modal Dialogs");
        ass.assertEquals(alertFrameWindow.clickOnSmallModelButton(driver),"Small modal");
        ass.assertEquals(alertFrameWindow.checkSmallModelHeader(),"Small Modal");
        ass.assertEquals(alertFrameWindow.checkSmallModelText(),"This is a small modal. It has very less content");
        ass.assertTrue(alertFrameWindow.clickSmallModelCloseButton(driver),"Close button of Small Dialog not working");
        ass.assertEquals(alertFrameWindow.clickOnLargeModelButton(driver),"Large modal");
        ass.assertEquals(alertFrameWindow.checkLargeModelHeader(),"Large modal");
        ass.assertEquals(alertFrameWindow.checkLargeModelText(driver),paragraph);
        ass.assertTrue(alertFrameWindow.clickLargeModelCloseButton(driver),"Close button of Large Dialog not working");
        ass.assertAll();
    }


    @AfterMethod
    public void captureAndReport(ITestResult result) throws IOException
    {
        if(ITestResult.SUCCESS==result.getStatus())
        {
            str=TC+tcID+" is PASS";
            logs(str);
        }
        else if(ITestResult.FAILURE==result.getStatus())
        {
            screenshot(driver, tcID);
            str=TC+tcID+" is FAILED";
            logs(str);
        }
        else if(ITestResult.SKIP==result.getStatus())
        {
            str=TC+tcID+" is SKIPPED";
            logs(str);
        }
    }
    @AfterClass
    public void testCleanUp()
    {
        driver.close();
        driver.quit();
    }
    @AfterTest
    public void releaseDriver()
    {
        webdriver.remove();
        driver=null;
    }
}
