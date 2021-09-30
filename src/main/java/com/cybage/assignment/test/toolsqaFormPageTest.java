package com.cybage.assignment.test;

import com.cybage.assignment.objects.locators;
import com.cybage.assignment.page.elementsPage;
import com.cybage.assignment.page.formsPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.cybage.assignment.objects.toolsqaBase.*;
import static com.cybage.assignment.objects.utilities.*;
import static com.cybage.assignment.objects.utilities.Xpath;

public class toolsqaFormPageTest extends locators
{
    formsPage formPage;
    String TCID;
    String str;
    static final String TC="Test Case ";
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
        scrollIntoView(driver,Xpath(driver,formsTab));
        Xpath(driver,formsTab).click();
        formPage=new formsPage(driver);
    }

    @BeforeMethod
    public void waitToLoadElements() throws InterruptedException {

        ass=new SoftAssert();
        waitToBrowserMSEC(3000);
    }

    @Test
    public void validatePracticeFormOption()
    {
        TCID="TC020";
        ass.assertTrue(formPage.checkPresenceOfPracticeFormOption(driver));
        ass.assertTrue(formPage.checkHeaderOfPracticeForm(),"Practice Form screen is not opened");
        ass.assertAll();
    }

    @Test (dependsOnMethods ="validatePracticeFormOption",priority = 1)
    public void validateFormFilling()
    {
        TCID="TC021";
        ass.assertTrue(formPage.enterFirstName("Sachin"),"First Name field is disabled");
        ass.assertTrue(formPage.enterLastName("Taware"),"Last Name Field is disabled");
        ass.assertTrue(formPage.enterEmailID("test@test.com"),"Email field is disabled");
        ass.assertTrue(formPage.selectGender(driver, "Male"),"Gender selection (Radio) is disabled");
        ass.assertTrue(formPage.enterMobileNumber("9096349923"),"Mobile number field is disabled");
        ass.assertTrue(formPage.enterDateOfBirth(driver,"25","May","1988"),"Calendar is disabled");
        ass.assertTrue(formPage.selectSubjects(driver,"Hindi","Maths"),"Invalid subject selection");
        ass.assertTrue(formPage.selectHobbiesFromList(driver),"Hobbies selection (checkbox) is disabled");
        ass.assertTrue(formPage.uploadPicture(driver), "Upload link is not working");
        ass.assertTrue(formPage.enterCurrentAddress("Pune-412307"), "Address field is disabled");
        ass.assertTrue(formPage.selectState(driver,"NCR"),"State selection is not working");
        ass.assertTrue(formPage.selectCity(driver,"Delhi"), "City selection is not working");
        ass.assertTrue(formPage.clickOnSubmitButton(driver), "Submit button is not working");
        ass.assertAll();
    }

    @Test (dependsOnMethods ="validatePracticeFormOption",priority = 2)
    public void validateFormAfterSubmit()
    {
        TCID="TC022";
        ass.assertTrue(formPage.checkTableTitle(),"Form title is invalid");
        ass.assertTrue(formPage.checkTableHeaders(),"Form headers are invalid");
        ass.assertTrue(formPage.checkTableEntries(),"Incorrect number of table entries");
        ass.assertTrue(formPage.closeFormTable(driver),"Close button is not displayed");
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
