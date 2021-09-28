package com.cybage.assignment.test;

import com.cybage.assignment.objects.locators;
import com.cybage.assignment.page.elementsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static com.cybage.assignment.objects.toolsqaBase.*;
import static com.cybage.assignment.objects.utilities.*;

public class toolsqaElementPageTest extends locators
{
    static String appPath="C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\webAppGeneric.properties";
    static String genPath="C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\genericProperty.properties";
    elementsPage elementPage;
    static Boolean result;
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
        scrollIntoView(driver,Xpath(driver,elementTab));
        Xpath(driver,elementTab).click();
        elementPage=new elementsPage(driver);
    }

    @BeforeMethod
    public void waitToLoadElements() throws InterruptedException {

        ass=new SoftAssert();
        waitToBrowserMSEC(3000);
    }

    @Test
    public void validateElementScreen()
    {
        TCID="TC010";
        result=elementPage.checkElementsScreenHeader();
        ass.assertTrue(result);
        ass.assertTrue(Xpath(driver,textbox).isDisplayed());
        ass.assertTrue(Xpath(driver,checkbox).isDisplayed());
        ass.assertTrue(Xpath(driver,radiobutton).isDisplayed());
        ass.assertTrue(Xpath(driver,webtables).isDisplayed());
        ass.assertTrue(Xpath(driver,buttons).isDisplayed());
        ass.assertTrue(Xpath(driver,links).isDisplayed());
        ass.assertTrue(Xpath(driver,brokenLinksImages).isDisplayed());
        ass.assertTrue(Xpath(driver,uploadAndDownload).isDisplayed());
        ass.assertTrue(Xpath(driver,dynamicProperties).isDisplayed());
        ass.assertAll();
    }

    @Test(dependsOnMethods = "validateElementScreen")
    public void validateTextBoxOnSubmission() throws IOException
    {
        String[] excelPath= {genericProp(genPath,"excelpath"),"sheet1"};
        int[] FName={1,0};
        int[] Email={1,1};
        int[] CAddress={1,2};
        int[] PAddress={1,3};

        TCID="TC011";
        ass.assertTrue(elementPage.checkPresenceOfTextBoxOption(driver));
        ass.assertTrue(elementPage.extractHeaderOfTextBoxPage());
        ass.assertTrue(elementPage.extractLabelOfTextBoxes());
        ass.assertTrue(elementPage.enterTextToFirstNameField(readWorkbook(excelPath,FName)));
        ass.assertTrue(elementPage.enterValidTextToEmailField(readWorkbook(excelPath,Email)));
        ass.assertTrue(elementPage.enterTextToCurrentAddressField(readWorkbook(excelPath,CAddress)));
        ass.assertTrue(elementPage.enterTextToPermanantAddressField(readWorkbook(excelPath,PAddress)));
        result=elementPage.clickSubmitButton(driver);
        ass.assertTrue(result);
        ass.assertAll();
    }

    @Test(dependsOnMethods = "validateElementScreen")
    public void validateCheckBoxOperation()
    {
        TCID="TC012";
        ass.assertTrue(elementPage.checkPresenceOfCheckBoxOption(driver));
        ass.assertTrue(elementPage.extractHeaderOfCheckBoxPage());
        ass.assertTrue(elementPage.clickToggleArrowOnCheckBoxPage());
        result=elementPage.clickCheckBoxOnCheckBoxPage();
        ass.assertTrue(result);
        ass.assertTrue(elementPage.clickExpandButtonOnCheckBoxPage());
        ass.assertTrue(elementPage.clickCollapseButtonOnCheckBoxPage());
        ass.assertAll();
    }

    @Test(dependsOnMethods = "validateElementScreen")
    public void validateRadioButtonOperations()
    {
        TCID="TC013";
        ass.assertTrue(elementPage.checkPresenceOfRadioButtonOption(driver));
        boolean yCheck=elementPage.clickYesRadioOnRadioButtonPage(driver);
        ass.assertTrue(yCheck);
        boolean iCheck=elementPage.clickImpressiveRadioOnRadioButtonPage(driver);
        ass.assertTrue(iCheck);
        boolean nCheck=elementPage.checkNoRadioOnRadioButtonPage();
        ass.assertTrue(nCheck,"Button is disabled or not working");
        result=yCheck & iCheck & nCheck;
        ass.assertAll();
    }
    @Test(dependsOnMethods = "validateElementScreen")
    public void validateWebTablesOperations() throws InterruptedException {
        TCID="TC014";
        ass.assertTrue(elementPage.checkPresenceOfWebTableOption(driver));
        ass.assertTrue(elementPage.clickAddButtonOnWebTablesPage());
        ass.assertTrue(elementPage.clickPreseceOfRegFormOnWebTablesPage());
        result=elementPage.searchOnWebTablesPage(driver);
        ass.assertTrue(result);
        ass.assertAll();
    }
    @Test(dependsOnMethods = "validateElementScreen")
    public void validateButtonsOperations()
    {
        TCID="TC015";
        ass.assertTrue(elementPage.checkPresenceOfButtonsOption(driver));
        ass.assertTrue(elementPage.doubleClickButtonCheck(driver));
        ass.assertTrue(elementPage.rightClickButtonCheck(driver));
        result=elementPage.singleClickButtonCheck(driver);
        ass.assertTrue(result);
        ass.assertAll();
    }
    @Test(dependsOnMethods = "validateElementScreen")
    public void validateLinksOperations() throws InterruptedException {
        TCID="TC016";
        ass.assertTrue(elementPage.checkPresenceOfLinkOption(driver));
        ass.assertTrue(elementPage.clickLinkToOpenNewTab(driver));
        result=elementPage.clickApiLinkToCheckResponse();
        ass.assertTrue(result);
        ass.assertAll();
    }
    @Test(dependsOnMethods = "validateElementScreen")
    public void validateBrokenLinkImagesOperations() throws InterruptedException {
        TCID="TC017";
        ass.assertTrue(elementPage.checkPresenceOfBrokenLinkImagesOption(driver));
        ass.assertTrue(elementPage.checkValidImage(),"Image is not Displayed");
        ass.assertTrue(elementPage.checkBrokenImage(driver),"Image is broken");
        ass.assertTrue(elementPage.checkValidLink(driver),"Link is not valid");
        result=elementPage.checkBrokenLink(driver);
        ass.assertTrue(result,"Link is broken");
        ass.assertAll();
    }

    @Test(dependsOnMethods = "validateElementScreen")
    public void validateUploadDownloadOperations() throws InterruptedException, IOException {
        TCID = "TC018";
        ass.assertTrue(elementPage.checkPresenceOfUploadDownloadOption(driver));
        ass.assertTrue(elementPage.clickDownloadButton(genPath),"Download button is not functional");
        result=elementPage.clickUploadButton();
        ass.assertTrue(result,"Upload button is not functional");
    }

    @Test(dependsOnMethods = "validateElementScreen")
    public void validateDynamicButtonsOperations() throws InterruptedException, IOException {
        TCID = "TC019";
        ass.assertTrue(elementPage.checkPresenceOfDynamicPropertyOption(driver));
        ass.assertTrue(elementPage.checkOperationOfDynamicButtonBeforeTime(),"Incorrect button is shown");
        driver.navigate().refresh();
        result=elementPage.checkOperationOfDynamicButtonAfterTime();
        ass.assertTrue(result,"Button is expected to be shown");
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
