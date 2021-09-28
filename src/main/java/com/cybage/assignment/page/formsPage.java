package com.cybage.assignment.page;

import com.cybage.assignment.objects.locators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.cybage.assignment.objects.utilities.*;

public class formsPage extends locators
{
    static boolean status;

    @FindBy(xpath = formsTab) private WebElement formTab;
    @FindBy(xpath=practiceForm) private WebElement practiceFormOption;
    @FindBy(xpath=mainHeader) private WebElement header;
    @FindBy(xpath=firstName) private WebElement firstname;
    @FindBy(xpath=lastName) private WebElement lastname;
    @FindBy(xpath=userEmail) private WebElement useremail;
    @FindBy(xpath=genderList) private List<WebElement> genderlist;
    @FindBy(xpath=mobileNumber) private WebElement mobile;
    @FindBy(xpath=birthDayBox) private WebElement birthday;
    @FindBy(xpath=monthPicker) private WebElement month;
    @FindBy(xpath=yearPicker) private WebElement year;
    @FindBy(xpath=datePicker) private List<WebElement> date;
    @FindBy(xpath=selectSubject) private WebElement subject;
    @FindBy(xpath=selectFromInput) private WebElement subEntry;
    @FindBy(xpath=selectedSubjects) private List<WebElement> selectedSubs;
    @FindBy(xpath=listOfChckbox) private List<WebElement> hobbies;
    @FindBy(xpath = uploadPicture) private WebElement selectPicture;
    @FindBy(xpath=currentAddress) private WebElement currentAdd;
    @FindBy(xpath = selectState) private WebElement selState;
    @FindBy(xpath = selectCity) private WebElement selCity;
    @FindBy(xpath = submit) private WebElement submitForm;
    @FindBy(xpath = tableTitle ) private WebElement formTitle;
    @FindBy(xpath = tableHeader ) private List<WebElement> formHeader;
    @FindBy(xpath = tableRow) private List<WebElement> tableRows;
    @FindBy(xpath = closeForm) private WebElement closeButton;

    public formsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public boolean clickOnFormsTab(WebDriver driver)
    {
        if(waitForElementVisibilitySEC(driver,formTab))
        {
            scrollIntoView(driver,formTab);
            status=formTab.isEnabled();
            formTab.click();
            return status;
        }
        else return false;
    }

    public boolean checkPresenceOfPracticeFormOption(WebDriver driver)
    {
        waitForElementVisibilitySEC(driver,practiceFormOption);
        scrollIntoView(driver,practiceFormOption);
        status=practiceFormOption.isEnabled();
        practiceFormOption.click();
        return status;
    }

    public boolean checkHeaderOfPracticeForm()
    {
        return(header.getText().equals("Practice Form"));
    }

    public boolean enterFirstName(String fName)
    {
        status=firstname.isEnabled();
        firstname.sendKeys(fName);
        return status;
    }
    public boolean enterLastName(String lName)
    {
        status=lastname.isEnabled();
        lastname.sendKeys(lName);
        return status;
    }

    public boolean enterEmailID(String emailID)
    {
       status= useremail.isEnabled();
       useremail.sendKeys(emailID);
       return status;
    }

    public boolean selectGender(WebDriver driver,String gender)
    {
        switch(gender)
        {
            case "Male":
                status=genderlist.get(0).isEnabled();
                scrollIntoView(driver,genderlist.get(0));
                if(!genderlist.get(0).isSelected())
                {
                    actOn(driver).moveToElement(genderlist.get(0)).click().build().perform();
                }
                break;
            case "Female":
                status=genderlist.get(1).isEnabled();
                scrollIntoView(driver,genderlist.get(1));
                if(!genderlist.get(1).isSelected())
                {
                    actOn(driver).moveToElement(genderlist.get(1)).click().build().perform();
                }
                break;
            default:
                status=genderlist.get(2).isEnabled();
                scrollIntoView(driver,genderlist.get(2));
                if(!genderlist.get(2).isSelected())
                {
                    actOn(driver).moveToElement(genderlist.get(2)).click().build().perform();
                }
                break;
        }
        return status;
    }

    public boolean enterMobileNumber(String mobileNo)
    {
        status= mobile.isEnabled();
        mobile.sendKeys(mobileNo);
        return status;
    }

    public boolean enterDateOfBirth(WebDriver driver,String Day, String monthPick, String yearPick)
    {
        status= birthday.isEnabled();
        actOn(driver).moveToElement(birthday).click().build().perform();
        selectElement(month).selectByVisibleText(monthPick);
        selectElement(year).selectByValue(yearPick);
        for(WebElement ele:date)
        {
            if(ele.getText().equals(Day))
            {
                ele.click();
                break;
            }
        }
        return status;
    }

    public boolean selectSubjects(WebDriver driver, String subject1, String subject2)
    {
        scrollIntoView(driver,subject);
        if(subject.isEnabled())
        {
            subEntry.sendKeys(subject1);
            actOn(driver).moveToElement(subEntry).sendKeys(Keys.ENTER).build().perform();
            subEntry.sendKeys(subject2);
            actOn(driver).moveToElement(subEntry).sendKeys(Keys.ENTER).build().perform();
            String[] subs={subject1,subject2};
            status=true;
            for(int i=0;i<selectedSubs.size();i++)
            {
                status=status & selectedSubs.get(i).getText().contains(subs[i]);
                i++;
            }
            return status;
        }
        else return false;
    }

    public boolean selectHobbiesFromList(WebDriver driver)
    {
        status=true;
        for(int i=0;i<hobbies.size();i++)
        {
            status=status & hobbies.get(i).isEnabled();
            scrollIntoView(driver,hobbies.get(i));
            actOn(driver).moveToElement(hobbies.get(i)).click().build().perform();
        }
        return status;
    }

    public boolean uploadPicture(WebDriver driver)
    {
        scrollIntoView(driver,selectPicture);
        status=selectPicture.isEnabled();
        selectPicture.sendKeys("C:\\Users\\sachintaw\\Downloads\\sampleFile.jpeg");
        return status;
    }

    public boolean enterCurrentAddress(String address)
    {
        status=currentAdd.isEnabled();
        currentAdd.sendKeys(address);
        return status;
    }

    public boolean selectState(WebDriver driver,String state)
    {
        scrollIntoView(driver,selState);
        status=selState.isEnabled();
        actOn(driver).moveToElement(selState).click().sendKeys(state).sendKeys(Keys.ENTER).build().perform();
        return status;
    }
    public boolean selectCity(WebDriver driver,String city)
    {
        scrollIntoView(driver,selCity);
        status=selCity.isEnabled();
        actOn(driver).moveToElement(selCity).click().sendKeys(city).sendKeys(Keys.ENTER).build().perform();
        return status;
    }
    public boolean clickOnSubmitButton(WebDriver driver)
    {
        scrollIntoView(driver,submitForm);
        status=submitForm.isEnabled();
        submitForm.click();
        return status;
    }

    public boolean checkTableTitle()
    {
        if(formTitle.isDisplayed())
        {
            status = formTitle.getText().equals("Thanks for submitting the form");
            return status;
        }
        return false;
    }

    public boolean checkTableHeaders()
    {
        status=formHeader.get(0).getText().equals("Label")
                & formHeader.get(1).getText().equals("Values");
        return status;
    }
    public boolean checkTableEntries()
    {
       return (tableRows.size()==10);
    }

    public boolean closeFormTable(WebDriver driver)
    {
        actOn(driver).moveToElement(Xpath(driver,"//a[@id='close-fixedban']")).click().build().perform();
        scrollIntoView(driver,closeButton);
        status=closeButton.isEnabled();
        closeButton.click();
        return status;
    }

}