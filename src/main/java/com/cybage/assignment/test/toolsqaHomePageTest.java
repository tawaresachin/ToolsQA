package com.cybage.assignment.test;
import com.cybage.assignment.page.toolsqaHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import static com.cybage.assignment.objects.utilities.*;


public class toolsqaHomePageTest
{
    static String path="C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\webAppGeneric.properties";
    toolsqaHomePage homePage;
    static Boolean result;
    String TCID;
    String str;
    static WebDriver driver;

    @BeforeClass
    public void testSetUp() throws IOException, InterruptedException
    {
        initialize();
        driver = browserFactory();
        driver.get(genericProp(path,"url"));
        driver.manage().window().maximize();
        waitToBrowserMSEC(2000);
        homePage=new toolsqaHomePage(driver);
    }
    @BeforeMethod
    public void waitToLoadElements()
    {
        implicitWaitSEC(driver,20);
    }

    @Test
    public void validatePageTitle()
    {
        TCID="TC001";
        Assert.assertTrue(homePage.checkPageTitle(driver));
    }

    @Test
    public void validateIfLogoPresent()
    {
        TCID="TC002";
        result=homePage.isLogoPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void validatePageBanner()
    {
        TCID="TC003";
        result=homePage.isBannerPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void validateIfElementsTabPresent()
    {
        TCID="TC004";
        result=homePage.isElementTabPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void validateIfFormsTabPresent()
    {
        TCID="TC005";
        result=homePage.isFormsTabPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void validateIfAlertTabPresent()
    {
        TCID="TC006";
        result=homePage.isAlertFrameWindowTabPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void validateIfWidgetTabPresent()
    {
        TCID="TC007";
        result=homePage.isWidgetTabPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void validateIfInteractionsTabPresent()
    {
        TCID="TC008";
        result=homePage.isInteractionsTabPresent();
        Assert.assertTrue(result);
    }

    @Test
    public void validateIfBookStoreTabPresent()
    {
        TCID="TC009";
        result=homePage.isBookStoreApplicationTabPresent();
        Assert.assertTrue(result);
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
