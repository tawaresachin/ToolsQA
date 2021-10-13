package com.cybage.assignment.test;

import com.cybage.assignment.objects.locators;
import com.cybage.assignment.page.widgetsPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.cybage.assignment.objects.toolsqaBase.*;
import static com.cybage.assignment.objects.utilities.*;

public class widgetsPageTest extends locators
{
    widgetsPage widgetPage;
    String TCID;
    String str;
    static final String TC="Test Case ";
    SoftAssert ass;
    private WebDriver driver;
    private final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();
    @BeforeClass
    public void testSetUp() throws IOException
    {
        webdriver.set(browserFactory());
        driver = webdriver.get();
        driver.get(genericProp(appPath,"url"));
        driver.manage().window().maximize();
        implicitWaitSEC(driver,20);
        scrollIntoView(driver,Xpath(driver,widgetTab));
        Xpath(driver,widgetTab).click();
        widgetPage=new widgetsPage(driver);
    }
    @BeforeMethod
    public void waitToLoadElements() throws InterruptedException {

        ass=new SoftAssert();
        waitToBrowserMSEC(3000);
    }

    @Test
    public void validatePresenceOfWidgetOptions()
    {
        TCID="TC029";
        ass.assertTrue(widgetPage.checkPresenceOfAccordianOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfAutoCompleteOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfDatePickerOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfSliderOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfProgressBarOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfTabsOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfToolTipsOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfMenuOption(driver));
        ass.assertTrue(widgetPage.checkPresenceOfselectMenuOption(driver));
        ass.assertAll();
    }
    @Test(dependsOnMethods ="validatePresenceOfWidgetOptions")
    public void validateAccordianPageOperations() throws IOException, InterruptedException {
        TCID="TC030";
        String[] arr1={genericProp(genPath,"excelpath"),"Sheet2"};
        int[] arr2={1,0};
        int[] arr3={2,0};
        int[] arr4={3,0};
        int[] arr5={4,0};
        String[] arr6={readWorkbook(arr1,arr3),readWorkbook(arr1,arr4)};

        ass.assertEquals(widgetPage.clickOnAccordianOption(driver),"Accordian");
        ass.assertEquals(widgetPage.checkHeaderOfSimpleAccordian1(driver),"What is Lorem Ipsum?");
        ass.assertEquals(widgetPage.checkBodyOfSimpleAccordian1(driver),readWorkbook(arr1,arr2));
        ass.assertEquals(widgetPage.checkHeaderOfSplittedAccordian(driver),"Where does it come from?");
        ass.assertEquals(widgetPage.checkBodyOfSplittedAccordian(driver),arr6);
        ass.assertEquals(widgetPage.checkHeaderOfSimpleAccordian2(driver),"Why do we use it?");
        ass.assertEquals(widgetPage.checkBodyOfSimpleAccordian2(driver),readWorkbook(arr1,arr5));
        ass.assertAll();
    }

    @Test(dependsOnMethods ="validatePresenceOfWidgetOptions")
    public void validateAutoCompleteTextBoxes() throws InterruptedException {
        TCID="TC031";
        ass.assertEquals(widgetPage.clickOnAutoCompleteOption(driver),"Auto Complete");
        String[] arr=widgetPage.enterValuesInMultiValueBox(driver,"R");
        ass.assertEquals(arr[0],"Purple");
        ass.assertEquals(arr[1],"Red");
        ass.assertEquals(widgetPage.enterValueInSingleValueBox(driver,"Pu"),"Purple");
        ass.assertAll();
    }

    @Test(dependsOnMethods ="validatePresenceOfWidgetOptions")
    public void validateDatePickerOperation()
    {
        TCID="TC031";
        ass.assertEquals(widgetPage.clickOnDatePickerOption(driver),"Date Picker");
        ass.assertEquals(widgetPage.selectDateUsingDatePicker(driver,"25","May","1988"),"05/25/1988");
        ass.assertEquals(widgetPage.selectDateTimeUsingDatePicker(driver,"25","May","1988","00:15"),"May 25, 1988 12:15 AM");
        ass.assertAll();
    }
    @AfterMethod
    public void captureAndReport(ITestResult result) throws IOException
    {
        if(ITestResult.SUCCESS==result.getStatus())
        {
            str=TC+TCID+" is PASS";
            logs(str);
        }
        else if(ITestResult.FAILURE==result.getStatus())
        {
            screenshot(driver,TCID);
            str=TC+TCID+" is FAILED";
            logs(str);
        }
        else if(ITestResult.SKIP==result.getStatus())
        {
            str=TC+TCID+" is SKIPPED";
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
        driver=null;
        webdriver.remove();
    }
}
