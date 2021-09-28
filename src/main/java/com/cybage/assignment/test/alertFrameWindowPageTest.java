package com.cybage.assignment.test;

import com.cybage.assignment.objects.locators;
import com.cybage.assignment.page.alertsFrameWindowPage;
import com.cybage.assignment.page.formsPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.cybage.assignment.objects.toolsqaBase.*;
import static com.cybage.assignment.objects.utilities.*;
import static com.cybage.assignment.objects.utilities.Xpath;

public class alertFrameWindowPageTest extends locators
{
    static String appPath="C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\webAppGeneric.properties";
    static String genPath="C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\genericProperty.properties";
    static alertsFrameWindowPage alertFrameWindow;
    String TCID;
    String str;
    SoftAssert ass;
    WebDriver driver;

    @BeforeClass
    public void testSetUp() throws IOException
    {
        initialize();
        driver = browserFactory();
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
        TCID="TC023";
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
        TCID="TC024";
        str="Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
        ass.assertEquals(alertFrameWindow.clickOnBrowserWindowOption(driver),"Browser Windows");
        ass.assertTrue(alertFrameWindow.clickOnNewTabButton(driver),"New Tab button is not accessible");
        ass.assertTrue(alertFrameWindow.clickOnNewWindowButton(driver),"New Window button is not accessible");
        ass.assertTrue(alertFrameWindow.clickOnNewWindowMessageButton(driver),"New Window Message is not accessible");
        ass.assertAll();
    }
    @Test(dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateAlertsOption() throws InterruptedException {
        TCID="TC025";
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
        TCID="TC026";
        ass.assertEquals(alertFrameWindow.clickOnFramesOption(driver),"Frames");
        ass.assertEquals(alertFrameWindow.switchToSimpleFrame(driver),"Simple Frame");
        ass.assertEquals(alertFrameWindow.switchToScrollableFrame(driver),"Scrollable Frame");
        ass.assertEquals(alertFrameWindow.switchToDefaultContent(driver),"Frames");
        ass.assertAll();
    }

    @Test (dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateNestedFramesOperation()
    {
        TCID="TC027";
        ass.assertEquals(alertFrameWindow.clickOnNestedFramesOption(driver),"Nested Frames");
        ass.assertEquals(alertFrameWindow.switchToParentFrame(driver),"Parent frame");
        ass.assertEquals(alertFrameWindow.switchToChildFrame(driver),"Child Iframe");
        ass.assertEquals(alertFrameWindow.switchToParent(driver),"Parent frame");
        ass.assertEquals(alertFrameWindow.switchToMainContent(driver),"Nested Frames");
        ass.assertAll();
    }

    @Test (dependsOnMethods = "validatePresenceOfAlertFrameWindowOptions")
    public void validateModalDialogsOperation() throws IOException {
        TCID="TC028";
        String arr1[]={genericProp(genPath,"excelpath"),"Sheet2"};
        int arr2[]={0,0};
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
            str="Test Case "+TCID+" is PASS";
            logs(str);
        }
        else if(ITestResult.FAILURE==result.getStatus())
        {
            screenshot(TCID);
            str="Test Case "+TCID+" is FAILED";
            logs(str);
        }
        else if(ITestResult.SKIP==result.getStatus())
        {
            str="Test Case "+TCID+" is SKIPPED";
            logs(str);
        }
    }
    @AfterClass
    public void testCleanUp()
    {
        driver.quit();
        driver=null;
    }
}
