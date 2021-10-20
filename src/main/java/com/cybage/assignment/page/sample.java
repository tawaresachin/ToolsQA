package com.cybage.assignment.page;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cybage.assignment.gurock.APIException;
import com.cybage.assignment.objects.Allure_Listener;
import com.cybage.assignment.objects.TestRailUtility;
import com.cybage.assignment.objects.toolsqaBase;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.testng.Assert;
//import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

import static com.cybage.assignment.objects.toolsqaBase.browserFactory;
import static com.cybage.assignment.objects.utilities.*;

/*Allure Report annotations*/
@Epic("Epic_001")
@Feature("Feature_001")
@Listeners({Allure_Listener.class})
/*--------------------------*/
public class sample
{
    private TestRailUtility testRail;
    private String tcID;
    private WebDriver driver;
    static final String TC="Test Case ";
    String testRun;
    private final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    private ExtentReports extent;
    private ExtentSparkReporter spark;

    @BeforeTest
    public void beforeClassMethod() throws IOException {
        webdriver.set(browserFactory());
        driver=webdriver.get();

        driver.get("https://www.google.com/");

        /*-------------------Extent Report Instances-----------------------------*/
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(genericProp(genPath,"extentReport"));
        extent.attachReporter(spark);
        /*------------------------------------------------------------------------*/

        /*-------------------Test Rail instance-----------------------------*/
        testRun=genericProp(genPath,"testRun");
        testRail=new TestRailUtility();
        /*------------------------------------------------------------------------*/
    }
    @BeforeMethod
    public void beforeMethod() throws IOException {

    }

    /*----------------------Allure Report annotations---------------*/
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate all 08 option tabs on Home Page")
    @Story("Story_001")
    /*----------------------Allure Report annotations---------------*/

    @Test (description = "T1 -Validate all options on Home Page")
    public void testMethod1()
    {
        tcID="1";
        System.out.println("Executing Test Method-1");
        WebElement ele = driver.findElement(By.xpath("//*[@title='Search']"));
        highlightElement(driver,ele);
        ele.sendKeys("Google");
        Assert.assertTrue(true, "Method-1 failure");
    }

    @Test(description = "T2- Validate Home Page Logo")
    public void testMethod2()
    {
        tcID="2";
        System.out.println("Executing Test Method-2");
        Assert.assertTrue(true, "Method-2 failure");
    }

    @AfterMethod
    @Attachment(value="Page screenshot",type = "image/png")                 //Allure annotation
    public void afterMethod(ITestResult result) throws IOException, APIException {
        String str;
        String screenshotPath = null;

        if ( ITestResult.FAILURE == result.getStatus() )
        {       str = TC + tcID + " is FAILED";
                logs(str);

            screenshotPath=screenshot(driver, tcID);

            testRail.addResult(testRun, tcID, 5, result.getThrowable().toString(),screenshotPath); //test rail result

            ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);                                 // Allure screenshot

            extent.createTest(tcID)
                    .log(Status.FAIL, str+": "+result.getThrowable().toString())                      //extent reporting
                    .addScreenCaptureFromPath(screenshotPath);
            extent.flush();
        }
        else if ( ITestResult.SKIP == result.getStatus() )
        {
                str = TC + tcID + " is SKIPPED";
                logs(str);

                testRail.addResult(testRun, tcID, 2, result.getThrowable().toString(),null);

                extent.createTest(tcID)
                        .log(Status.SKIP, str+": "+result.getThrowable().toString());
                extent.flush();
        }
        else if ( ITestResult.SUCCESS == result.getStatus() )
        {
            str = TC + tcID + " is PASS";
            testRail.addResult(testRun, tcID, 1, null, null);
            logs(str);

            extent.createTest(tcID)
                    .log(Status.PASS, str);
            extent.flush();
        }
    }

    @AfterTest
    public void testCleanUp() throws IOException {
        driver.close();
        driver.quit();
        driver=null;
    }
}