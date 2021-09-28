package com.cybage.assignment.page;

import com.cybage.assignment.objects.locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.cybage.assignment.objects.utilities.*;

public class alertsFrameWindowPage extends locators
{
    @FindBy(xpath=browserWindowOption) private WebElement browserWindow;
    @FindBy(xpath=alertsOption) private WebElement alert;
    @FindBy(xpath = framesOption) private WebElement frames;
    @FindBy(xpath = nestedFramesOption) private WebElement nestedFrames;
    @FindBy(xpath = modalDialogsOption) private WebElement modalDialogs;

    @FindBy(xpath=mainHeader) private WebElement header;
    @FindBy(xpath=newTabButton) private WebElement newTab;
    @FindBy(xpath =newWindowButton) private WebElement newWindow;
    @FindBy(xpath = newWindowMessageButton) private WebElement newWindowMessage;

    @FindBy(xpath=simpelAlert) private WebElement simpleAlertButton;
    @FindBy(xpath=timerAlert) private WebElement timerAlertButton;
    @FindBy(xpath=confirmationAlert) private WebElement confirmationAlertButton;
    @FindBy(xpath=sendMessagePromptAlert) private WebElement messagePromptAlert;
    @FindBy(xpath=confirmResult) private WebElement confirmationResult;
    @FindBy(xpath=promptResult) private WebElement promptMessageResult;

    @FindBy(id=simpleFrameID) private WebElement simpleFrame;
    @FindBy(id=scollableFrameID) private WebElement scrollableFrame;
    @FindBy(xpath=headerOfSimpleFrame) private WebElement simpleFrameHeading;
    @FindBy(xpath=headerOfScrollableFrame) private WebElement scrollableFrameHeading;

    @FindBy(id=parentFrameID) private WebElement parentFrame;

    @FindBy(xpath = smallModelButton) private WebElement smallModel;
    @FindBy(xpath = smallModelHeader) private WebElement sModelHeader;
    @FindBy(xpath = smallModelText) private WebElement sModelText;
    @FindBy(xpath = smallModelCloseButton) private WebElement smallModelClose;
    @FindBy(xpath = largeModelButton) private WebElement largeModel;
    @FindBy(xpath = largeModelHeader) private WebElement lModelHeader;
    @FindBy(xpath = largeModelText) private WebElement lModelText;
    @FindBy(xpath = largeModelCloseButton) private WebElement largeModelClose;


    public alertsFrameWindowPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public boolean checkPresenceOfBrowserWindowOption(WebDriver driver)
    {
        scrollIntoView(driver,browserWindow);
        return browserWindow.isEnabled();
    }

    public boolean checkPresenceOfAlertsOption(WebDriver driver)
    {
        scrollIntoView(driver,alert);
        return alert.isEnabled();
    }
    public boolean checkPresenceOfFramesOption(WebDriver driver)
    {
        scrollIntoView(driver,frames);
        return frames.isEnabled();
    }

    public boolean checkPresenceOfNestedFramesOption(WebDriver driver)
    {
        scrollIntoView(driver,nestedFrames);
        return nestedFrames.isEnabled();
    }
    public boolean checkPresenceOfModalDialogsOption(WebDriver driver)
    {
        scrollIntoView(driver,modalDialogs);
        return modalDialogs.isEnabled();
    }

    /*-------- Browser Window Option operations---------- */
    public String clickOnBrowserWindowOption(WebDriver driver)
    {
        scrollIntoView(driver,browserWindow);
        browserWindow.click();
        return header.getText();
    }
    public boolean clickOnNewTabButton(WebDriver driver) throws InterruptedException {
        scrollIntoView(driver,newTab);
        if(newTab.isEnabled())
        {
            newTab.click();
            waitToBrowserMSEC(2000);
            switchToWindow(driver,1).close();
            switchToWindow(driver,0);
            return true;
        }
        else return false;
    }
    public boolean clickOnNewWindowButton(WebDriver driver) throws InterruptedException {
        scrollIntoView(driver,newWindow);
        if(newWindow.isEnabled())
        {
            newWindow.click();
            waitToBrowserMSEC(2000);
            switchToWindow(driver,1).close();
            switchToWindow(driver,0);
            return true;
        }
        else return false;
    }
    public boolean clickOnNewWindowMessageButton(WebDriver driver) throws InterruptedException {
        scrollIntoView(driver,newWindowMessage);
        if(newWindowMessage.isEnabled())
        {
            newWindowMessage.click();
            switchToWindow(driver,1).close();
            switchToWindow(driver,0);
            return true;
        }
        else return false;
    }

    /*-------- Alerts Option operations---------- */
    public String clickOnAlertOption(WebDriver driver)
    {
        scrollIntoView(driver,alert);
        alert.click();
        return header.getText();
    }

    public boolean clickOnSimpleAlertButton(WebDriver driver) throws InterruptedException {
        scrollIntoView(driver,simpleAlertButton);
        if(simpleAlertButton.isEnabled())
        {
            simpleAlertButton.click();
            waitToBrowserMSEC(2000);
            handleAlerts(driver,"Accept","");
            return true;
        }
        return false;
    }

    public boolean clickOnTimerAlertButton(WebDriver driver) throws InterruptedException {
        scrollIntoView(driver,timerAlertButton);
        if(timerAlertButton.isEnabled())
        {
            timerAlertButton.click();
            waitToBrowserMSEC(6000);
            handleAlerts(driver,"Accept","");
            return true;
        }
        return false;
    }

    public String clickOnConfirmationAlertButton(WebDriver driver,String confirmation) throws InterruptedException {
        scrollIntoView(driver,confirmationAlertButton);
        if(confirmationAlertButton.isEnabled())
        {
            confirmationAlertButton.click();
            waitToBrowserMSEC(2000);
            handleAlerts(driver,confirmation,"");
            return confirmationResult.getText();
        }
        return null;
    }

    public String clickOnPromtAlertButton(WebDriver driver,String confirmation,String message) throws InterruptedException {
        scrollIntoView(driver,messagePromptAlert);
        if(messagePromptAlert.isEnabled())
        {
            messagePromptAlert.click();
            waitToBrowserMSEC(2000);
            handleAlerts(driver,confirmation,message);
            if(!confirmation.equals("sendMessageAccept"))
            {return "Reject";
            }
            else
            {
                waitToBrowserMSEC(1000);
                return promptMessageResult.getText();
            }
        }
        return null;
    }

    /*-------- Frames Option operations---------- */

    public String clickOnFramesOption(WebDriver driver)
    {
        scrollIntoView(driver,frames);
        frames.click();
        return header.getText();
    }

    public String switchToSimpleFrame(WebDriver driver) throws InterruptedException {
        scrollIntoView(driver,simpleFrame);
        driver.switchTo().frame(simpleFrame);
        waitToBrowserMSEC(2000);
        driver.switchTo().defaultContent();
        return "Simple Frame";
    }

    public String switchToScrollableFrame(WebDriver driver) throws InterruptedException
    {
        scrollIntoView(driver,scrollableFrame);
        driver.switchTo().frame(scrollableFrame);
        waitToBrowserMSEC(2000);
        return "Scrollable Frame";
    }
    public String switchToDefaultContent(WebDriver driver)
    {
        driver.switchTo().defaultContent();
        return header.getText();
    }

    /*-------- Nested Frames Option operations---------- */
    public String clickOnNestedFramesOption(WebDriver driver)
    {
        scrollIntoView(driver,nestedFrames);
        nestedFrames.click();
        return header.getText();
    }

    public String switchToParentFrame(WebDriver driver)
    {
        scrollIntoView(driver,parentFrame);
        switchTo(driver).frame(parentFrame);
        return  Xpath(driver,frameText).getText();
    }
    public String switchToChildFrame(WebDriver driver)
    {
        switchTo(driver).frame(0);
        return Xpath(driver,frameText).getText();
    }
    public String switchToParent(WebDriver driver)
    {
        switchTo(driver).parentFrame();
        return Xpath(driver,frameText).getText();
    }
  public String switchToMainContent(WebDriver driver)
  {
      switchTo(driver).defaultContent();
      return header.getText();
  }

    /*-------- Modal Dialogs Option operations---------- */
  public String clickOnModalDialogOption(WebDriver driver)
  {
      scrollIntoView(driver,modalDialogs);
      modalDialogs.click();
      return header.getText();
  }
  public String clickOnSmallModelButton(WebDriver driver)
  {
      scrollIntoView(driver,smallModel);
      String str=smallModel.getText();
      smallModel.click();
      return str;
  }
    public String checkSmallModelHeader()
    {
        return sModelHeader.getText();
    }
    public String checkSmallModelText()
    {
        return sModelText.getText();
    }
    public boolean clickSmallModelCloseButton(WebDriver driver)
    {
        scrollIntoView(driver,smallModelClose);
        boolean status=smallModelClose.isEnabled();
        smallModelClose.click();
        return status;
    }
    public String clickOnLargeModelButton(WebDriver driver)
    {
        scrollIntoView(driver,largeModel);
        String str=largeModel.getText();
        largeModel.click();
        return str;
    }
    public String checkLargeModelHeader()
    {
        return largeModel.getText();
    }
    public String checkLargeModelText(WebDriver driver)
    {
       scrollIntoView(driver,lModelText);
        return lModelText.getText();
    }
    public boolean clickLargeModelCloseButton(WebDriver driver)
    {
        scrollIntoView(driver,largeModelClose);
        boolean status=largeModelClose.isEnabled();
        largeModelClose.click();
        return status;
    }






}
