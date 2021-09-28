package com.cybage.assignment.page;

import com.cybage.assignment.objects.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static com.cybage.assignment.objects.utilities.*;

public class elementsPage extends locators
{
    static boolean status;
    String str,xPath;
    boolean flag1,flag2,flag3;
    static int oddSize,evenSize;
    List<WebElement> ele;

    @FindBy(xpath=textbox) private WebElement textBox;
    @FindBy(xpath=checkbox) private WebElement checkBoxOption;
    @FindBy(xpath=radiobutton) private WebElement radioButton;
    @FindBy(xpath=webtables) private WebElement webTables;
    @FindBy(xpath=buttons) private WebElement button;
    @FindBy(xpath=links) private WebElement link;
    @FindBy(xpath=brokenLinksImages) private WebElement brokenLinkImage;
    @FindBy(xpath=uploadAndDownload) private WebElement uploadDownload;
    @FindBy(xpath=dynamicProperties) private WebElement dynamicProperty;
    @FindBy(xpath=mainHeader) private WebElement header;
    @FindBy(xpath=fullNameLabel) private WebElement fullnameLabel;
    @FindBy(xpath=fullNameInput) private WebElement fullnameText;
    @FindBy(xpath=emailLabel) private WebElement emailabel;
    @FindBy(xpath=emailInput) private WebElement emailText;
    @FindBy(xpath=currentAddressLabel) private WebElement currAddressLabel;
    @FindBy(xpath=currentAddressInput) private WebElement currAddressText;
    @FindBy(xpath=permanentAddressLabel) private WebElement perAddressLabel;
    @FindBy(xpath=permanentAddressInput) private WebElement perAddressText;
    @FindBy(xpath=submitButton) private WebElement submit;

    @FindBy(xpath=toggle) private WebElement toggleArrow;
    @FindBy(xpath=tickbox) private WebElement checkBox;
    @FindBy(xpath=expandButton) private WebElement expand;
    @FindBy(xpath=collapseButton) private WebElement collapse;
    @FindBy(xpath=yesRadio) private WebElement yesRdo;
    @FindBy(xpath=noRadio) private WebElement noRdo;
    @FindBy(xpath=impressiveRadio) private WebElement imprRdo;
    @FindBy(xpath = successText) private WebElement textSuccess;

    @FindBy(xpath=addButton) private WebElement addBttn;
    @FindBy(xpath=searchBox) private WebElement searchbox;
    @FindBy(xpath=oddRowList) private List<WebElement> oddRows;
    @FindBy(xpath=evenRowList) private List<WebElement> evenRows;
    @FindBy(xpath=cellData) private List<WebElement> celldata;
    @FindBy(xpath=registrationForm) private WebElement regForm;
    @FindBy(xpath=closeFormButton) private WebElement closeForm;

    @FindBy(xpath=doubleClickButton) private WebElement dblClick;
    @FindBy(xpath=rightClickButton) private WebElement rgtClick;
    @FindBy(xpath=dynamicClickButton) private WebElement dynamicClick;
    @FindBy(xpath=simpleLink) private WebElement smplClick;
    @FindBy(xpath=doubleClickMessage) private WebElement doubleClickMsg;
    @FindBy(xpath = rightClickMessage) private WebElement rightClickMsg;
    @FindBy(xpath = dynamicClickMessage) private WebElement dynamicClickMsg;

    @FindBy(xpath = simpleLink) private WebElement newTabLink;
    @FindBy(xpath=apiLink) private WebElement apiLnk;
    @FindBy(xpath=apiResponse) private WebElement apiRsp;

    @FindBy(xpath=validImage) private WebElement valImage;
    @FindBy(xpath=brokenImage) private WebElement brkImage;
    @FindBy(xpath=validLink) private WebElement valLink;
    @FindBy(xpath=brokenLink) private WebElement brkLink;

    @FindBy(xpath=downloadButton) private WebElement download;
    @FindBy(xpath=chooseFileButton) private WebElement chooseFile;
    @FindBy(xpath=uploadFFilePath) private WebElement uploadResult;

    @FindBy(xpath=enableAfterButton) private WebElement enableAfter;
    @FindBy(xpath=beforeColorChangeButton) private WebElement beforeColorChange;
    @FindBy(xpath=afterColorChangeButton) private WebElement afterColorChange;
    @FindBy(xpath=visibleAfterButton) private WebElement visibleAfter;

    public elementsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public Boolean checkElementsScreenHeader()
    {
        str=header.getText();
        status=str.equals(elementPageHeaderText);
        return status;
    }

    /*** Text Box Screen operations ***/

    public boolean checkPresenceOfTextBoxOption(WebDriver driver)
    {
        status=waitForElementVisibilitySEC(driver,textBox);
        textBox.click();
        return status;
    }
    public boolean extractHeaderOfTextBoxPage()
    {
        str=header.getText();
        status=str.equals(textBoxPageHeaderText);
        return status;
    }

    public boolean extractLabelOfTextBoxes()
    {
        status=fullnameLabel.getText().equals("Full Name")
                & emailabel.getText().equals("Email")
                & currAddressLabel.getText().equals("Current Address")
                & perAddressLabel.getText().equals("Permanent Address");
        return status;
    }

    public boolean enterTextToFirstNameField(String fullName)
    {
        status=fullnameText.isEnabled();
        if( status)
        {
            fullnameText.sendKeys(fullName);
            return status;
        }
        else
            return false;
    }

    public boolean enterValidTextToEmailField(String email)
    {
        status=emailText.isEnabled();
        if( status)
        {
            emailText.sendKeys(email);
            return status;
        }
        else
            return false;
    }

    public  boolean enterInvalidTextToEmailField(String email)
    {
        status=emailText.isEnabled();
        if( status)
        {
            emailText.sendKeys(email);
            return status;
        }
        else
            return false;
    }

    public boolean enterTextToCurrentAddressField(String address)
    {
        status=currAddressText.isEnabled();
        if( status)
        {
            currAddressText.sendKeys(address);
            return status;
        }
        else
            return false;
    }

    public boolean enterTextToPermanantAddressField(String address)
    {
        status=perAddressText.isEnabled();
        if( status)
        {
            perAddressText.sendKeys(address);
            return status;
        }
        else
            return false;
    }
    public boolean clickSubmitButton(WebDriver driver)
    {
        scrollIntoView(driver,submit);
        if(submit.isEnabled())
        {
            submit.click();
            List<WebElement> ele=driver.findElements(By.xpath(outputList));
            return (ele.size()==4);
        }
        else
            return false;
    }

    /*** Check Box Screen operations ***/

    public boolean checkPresenceOfCheckBoxOption(WebDriver driver)
    {
        scrollIntoView(driver,checkBoxOption);
        status=checkBoxOption.isEnabled();
        checkBoxOption.click();
        return status;
    }
    public boolean extractHeaderOfCheckBoxPage()
    {
        str=header.getText();
        status=str.equals(checkBoxPageHeaderText);
        return status;
    }
    public boolean clickToggleArrowOnCheckBoxPage()
    {
        status=toggleArrow.isEnabled();
        toggleArrow.click();
        return status;
    }
    public boolean clickCheckBoxOnCheckBoxPage()
    {
        status=checkBox.isEnabled();
        if(!checkBox.isSelected())
        {
            checkBox.click();
        }
        return status;
    }

    public boolean clickExpandButtonOnCheckBoxPage()
    {
        status=expand.isEnabled();
        expand.click();
        return status;
    }
    public boolean clickCollapseButtonOnCheckBoxPage()
    {
        status=collapse.isEnabled();
        collapse.click();
        return status;
    }

    /*** Radio Button Screen operations ***/
    public boolean checkPresenceOfRadioButtonOption(WebDriver driver)
    {
        scrollIntoView(driver,radioButton);
        status=radioButton.isEnabled();
        radioButton.click();
        return status;
    }
    public boolean clickYesRadioOnRadioButtonPage(WebDriver driver)
    {
        status=yesRdo.isEnabled();
        if(!yesRdo.isSelected())
        {
            actOn(driver).moveToElement(yesRdo).click().build().perform();
        }
        if(textSuccess.getText().equals("Yes"))
        {
            return status;
        }
        else
            return false;
    }

    public boolean clickImpressiveRadioOnRadioButtonPage(WebDriver driver)
    {
        status=imprRdo.isEnabled();
        if(!imprRdo.isSelected())
        {
            actOn(driver).moveToElement(imprRdo).click().build().perform();
        }
        if(textSuccess.getText().equals("Impressive"))
        {
            return status;
        }
        else
            return false;
    }
    public boolean checkNoRadioOnRadioButtonPage()
    {
        return noRdo.isEnabled();
    }

    /*** WebTables Screen operations ***/

    public boolean checkPresenceOfWebTableOption(WebDriver driver)
    {
        scrollIntoView(driver,webTables);
        status=webTables.isEnabled();
        webTables.click();
        return status;
    }
    public boolean clickAddButtonOnWebTablesPage()
    {
        status=addBttn.isEnabled();
        addBttn.click();
        return status;
    }
    public boolean clickPreseceOfRegFormOnWebTablesPage()
    {
        status=regForm.isDisplayed();
        closeForm.click();
        return status;
    }
    public boolean searchOnWebTablesPage(WebDriver driver)
    {
        String strr="Kierra";
        flag1=searchbox.isEnabled();
        searchbox.sendKeys(strr);
        oddSize=oddRows.size();
        evenSize=evenRows.size();

        if(oddSize!=0)
        {
            flag2 = false;
            for (int i = 1; i <= oddSize; i++) {
                xPath = "(" + oddRowList + ")" + "["+i+"]" + cellData;
                ele = driver.findElements(By.xpath(xPath));
                for (int j = 0; j < ele.size(); j++) {
                        flag2 = flag2|ele.get(j).getText().contains(strr);
                 }
            }
        }

        if(evenSize!=0) {
            flag3=false;
            for (int i = 1; i <= evenSize; i++) {
                xPath = "(" + evenRowList + ")" + "["+i+"]" + cellData;
                ele = driver.findElements(By.xpath(xPath));
                for (int j = 0; j < ele.size(); j++) {
                    flag3 = flag3|ele.get(j).getText().contains(strr);
                }
            }
        }

        if(flag1) {
            status = (flag2 | flag3);
            return status;
        }
        else
            return false;
     }

    /*** Buttons Screen operations ***/
    public boolean checkPresenceOfButtonsOption(WebDriver driver)
    {
        scrollIntoView(driver,button);
        status=button.isEnabled();
        button.click();
        return status;
    }

    public boolean doubleClickButtonCheck(WebDriver driver)
    {
        actOn(driver).moveToElement(dblClick).doubleClick().build().perform();
        return doubleClickMsg.getText().equals("You have done a double click");
    }

    public boolean rightClickButtonCheck(WebDriver driver)
    {
        actOn(driver).moveToElement(rgtClick).contextClick().build().perform();
        return rightClickMsg.getText().equals("You have done a right click");
    }

    public boolean singleClickButtonCheck(WebDriver driver)
    {
        actOn(driver).moveToElement(dynamicClick).click().build().perform();
        return dynamicClickMsg.getText().equals("You have done a dynamic click");
    }

    /*** Links Screen operations ***/

    public boolean checkPresenceOfLinkOption(WebDriver driver)
    {
        scrollIntoView(driver,link);
        status=link.isEnabled();
        link.click();
        return status;
    }

    public boolean clickLinkToOpenNewTab(WebDriver driver) throws InterruptedException {
        if(newTabLink.isEnabled())
        {
            newTabLink.click();
            waitToBrowserMSEC(2000);
            switchToWindow(driver,1).close();
            switchToWindow(driver,0);
            status=true;
        }
        else status=false;
        return status;
    }
    public boolean clickApiLinkToCheckResponse()
    {
        if(apiLnk.isEnabled())
        {
            apiLnk.click();
            str=apiRsp.getText();
            status= (str != null);
        }
        else status=false;
        return status;
    }

    /*** BrokenLinksImages Screen operations ***/

    public boolean checkPresenceOfBrokenLinkImagesOption(WebDriver driver)
    {
        scrollIntoView(driver,brokenLinkImage);
        status=brokenLinkImage.isEnabled();
        actOn(driver).moveToElement(brokenLinkImage).click().build().perform();
        return status;
    }
    public boolean checkValidImage()
    {
        return(valImage.isDisplayed());
    }
    public  boolean checkBrokenImage(WebDriver driver)
    {
        scrollIntoView(driver,brkLink);
        return (brkImage.isDisplayed());
    }
    public boolean checkValidLink(WebDriver driver)
    {
        scrollIntoView(driver,valLink);
       if(valLink.isEnabled())
       {   valLink.click();
           if(driver.getCurrentUrl().equals("https://demoqa.com/"))
           {   driver.navigate().back();
               return true;}
       }
       return false;
    }

    public boolean checkBrokenLink(WebDriver driver)
    {
        scrollIntoView(driver,brkLink);
        status=brkLink.isDisplayed();
        brkLink.click();
        driver.navigate().back();
        return status;
    }

    /*** UploadDownload Screen operations ***/
    public boolean checkPresenceOfUploadDownloadOption(WebDriver driver)
    {
        scrollIntoView(driver,uploadDownload);
        status=uploadDownload.isEnabled();
        uploadDownload.click();
        return status;
    }
    public boolean clickDownloadButton(String path) throws IOException {

        if(download.isEnabled())
        {
            download.click();
            return (checkDownload(genericProp(path,"downloadPath"),"sampleFile"));
        }
        else return false;
    }

    public boolean clickUploadButton() throws InterruptedException {
        if(chooseFile.isEnabled())
        {
            chooseFile.sendKeys("D:\\SachinShivajiTaware\\Atlassian Jira & Confluence.txt");
            waitToBrowserMSEC(2000);
            return (uploadResult.getText().equals("C:\\fakepath\\Atlassian Jira & Confluence.txt"));
        }
        else return false;
    }
    /*** Dynamic Property Screen operations ***/
    public boolean checkPresenceOfDynamicPropertyOption(WebDriver driver)
    {
        scrollIntoView(driver,dynamicProperty);
        status=dynamicProperty.isEnabled();
        dynamicProperty.click();
        return status;
    }

    public boolean checkOperationOfDynamicButtonBeforeTime()
    {
        if(!enableAfter.isEnabled())
        {
            return(beforeColorChange.isDisplayed()&(!visibleAfter.isDisplayed()));
        }
        else return false;
    }

    public boolean checkOperationOfDynamicButtonAfterTime() throws InterruptedException {
        if(!enableAfter.isEnabled())
        {
            waitToBrowserMSEC(5000);
            return(afterColorChange.isDisplayed()&(visibleAfter.isDisplayed()));
        }
        else return false;
    }









}
