package com.cybage.assignment.page;

import com.cybage.assignment.objects.locators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.cybage.assignment.objects.utilities.*;

public class widgetsPage extends locators
{
    ArrayList<String> arrList;

    @FindBy(xpath = accordianOption) private WebElement accordian;
    @FindBy(xpath = autoCompleteOption) private WebElement autoComplete;
    @FindBy(xpath= datePickerOption ) private WebElement datePicker;
    @FindBy(xpath= sliderOption ) private WebElement slider;
    @FindBy(xpath= progressBarOption) private WebElement progressBar;
    @FindBy(xpath= tabsOption) private WebElement tabs;
    @FindBy(xpath= tooltipsOption) private WebElement toolTips;
    @FindBy(xpath= menuOption) private WebElement menu;
    @FindBy(xpath= selectMenuOption) private WebElement selectMenu;

    @FindBy(xpath=mainHeader) private WebElement header;
    @FindBy(xpath=accordianSimple1) private WebElement simpleAccordian1;
    @FindBy(xpath=accSimple1Body) private WebElement simpleAccordian1Contents;
    @FindBy(xpath=accordianSplitted) private WebElement splittedAccordian;
    @FindBy(xpath=accSplittedBody1) private WebElement splittedAccordianContents1;
    @FindBy(xpath=accSplittedBody2) private WebElement splittedAccordianContents2;
    @FindBy(xpath=accordianSimple2) private WebElement simpleAccordian2;
    @FindBy(xpath=accSimple2Body) private WebElement simpleAccordian2Contents;

    @FindBy(xpath = autoCompleteTextBox1) private WebElement multiValuedTextBox;
    @FindBy(xpath = autoCompleteTextBox2) private WebElement singleValuedTextBox;
    @FindBy(xpath= multipleSelectionList) private List<WebElement> listOfTextBoxValues;
    @FindBy(xpath = singleSelectedValue) private WebElement singleTextBoxValue;

    @FindBy(xpath = datePickerBox1) private WebElement dateInput;
    @FindBy(xpath = datePickerMonth) private WebElement monthSelect;
    @FindBy(xpath = datePickerYear) private WebElement yearSelect;
    @FindBy(xpath = datePickerWeeks) private WebElement weekSelect;
    @FindBy(xpath = datePickerDates) private List<WebElement> dateSelect;
    @FindBy(xpath = dateTimePickerMonthView) private WebElement monthListView;
    @FindBy(xpath = dateTimePickerMonth) private List<WebElement> monthListSelect;
    @FindBy(xpath = dateTimePickerYearView) private WebElement yearListView;
    @FindBy(xpath = dateTimePickerYear) private List<WebElement> yearListSelect;
    @FindBy(xpath = dateTimePickerDates) private List<WebElement> dateListSelect;
    @FindBy(xpath = datePickerBox2) private WebElement dateTimeInput;
    @FindBy(xpath = datePickerTime) private List<WebElement> timeSelect;


    public widgetsPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public boolean checkPresenceOfAccordianOption(WebDriver driver)
    {
        scrollIntoView(driver,accordian);
        return accordian.isEnabled();
    }
    public boolean checkPresenceOfAutoCompleteOption(WebDriver driver)
    {
        scrollIntoView(driver,autoComplete);
        return autoComplete.isEnabled();
    }
    public boolean checkPresenceOfDatePickerOption(WebDriver driver)
    {
        scrollIntoView(driver,datePicker);
        return datePicker.isEnabled();
    }
    public boolean checkPresenceOfSliderOption(WebDriver driver)
    {
        scrollIntoView(driver,slider);
        return slider.isEnabled();
    }
    public boolean checkPresenceOfProgressBarOption(WebDriver driver)
    {
        scrollIntoView(driver,progressBar);
        return progressBar.isEnabled();
    }
    public boolean checkPresenceOfTabsOption(WebDriver driver)
    {
        scrollIntoView(driver,tabs);
        return tabs.isEnabled();
    }
    public boolean checkPresenceOfToolTipsOption(WebDriver driver)
    {
        scrollIntoView(driver,toolTips);
        return toolTips.isEnabled();
    }
    public boolean checkPresenceOfMenuOption(WebDriver driver)
    {
        scrollIntoView(driver,menu);
        return menu.isEnabled();
    }
    public boolean checkPresenceOfselectMenuOption(WebDriver driver)
    {
        scrollIntoView(driver,selectMenu);
        return selectMenu.isEnabled();
    }



    /*-------- Accordian Option operations---------- */
    public String clickOnAccordianOption(WebDriver driver)
    {
        scrollIntoView(driver,accordian);
        accordian.click();
        return header.getText();
    }
    public String checkHeaderOfSimpleAccordian1(WebDriver driver) throws InterruptedException {
        String str=simpleAccordian1.getText();
        waitToBrowserMSEC(2000);
        return str;
    }
    public String checkBodyOfSimpleAccordian1(WebDriver driver)
    {
        scrollIntoView(driver,simpleAccordian1Contents);
        String str=simpleAccordian1Contents.getText();
        return str;
    }
    public String checkHeaderOfSplittedAccordian(WebDriver driver)
    {
        scrollIntoView(driver,splittedAccordian);
        splittedAccordian.click();
        return splittedAccordian.getText();
    }
    public String[] checkBodyOfSplittedAccordian(WebDriver driver)
    {
        String[] str1= {splittedAccordianContents1.getText(),splittedAccordianContents2.getText()};
        return str1;
    }
    public String checkHeaderOfSimpleAccordian2(WebDriver driver)
    {
        scrollIntoView(driver,simpleAccordian2);
        simpleAccordian2.click();
        return simpleAccordian2.getText();
    }
    public String checkBodyOfSimpleAccordian2(WebDriver driver)
    {
        scrollIntoView(driver,simpleAccordian2Contents);
        return simpleAccordian2Contents.getText();
    }

    /*-------- Auto-Complete Option operations---------- */
    public String clickOnAutoCompleteOption(WebDriver driver)
    {
        scrollIntoView(driver,autoComplete);
        autoComplete.click();
        return header.getText();
    }

    public String[] enterValuesInMultiValueBox(WebDriver driver, String searchChars) throws InterruptedException {
        arrList=new ArrayList<String>();
        if(multiValuedTextBox.isEnabled())
        {
            actOn(driver).moveToElement(multiValuedTextBox).click().sendKeys(searchChars).build().perform();
            actOn(driver).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
            waitToBrowserMSEC(1000);
            actOn(driver).moveToElement(multiValuedTextBox).sendKeys(searchChars).build().perform();
            actOn(driver).sendKeys(Keys.ENTER).build().perform();
            waitToBrowserMSEC(1000);

            int i=0;
            for(WebElement ele:listOfTextBoxValues)
            {
                arrList.add(ele.getText());
            }
             return arrList.toArray(new String[0]);
        }
        else return null;
    }

    public String enterValueInSingleValueBox(WebDriver driver,String searchChars) throws InterruptedException {
        if(singleValuedTextBox.isEnabled())
        {
            actOn(driver).moveToElement(singleValuedTextBox).click().sendKeys(searchChars).build().perform();
            actOn(driver).sendKeys(Keys.ENTER).build().perform();
            waitToBrowserMSEC(1000);
            return singleTextBoxValue.getText();
        }
        else return null;
    }

    /*-------- Date Picker Option operations---------- */
    public String clickOnDatePickerOption(WebDriver driver)
    {
        scrollIntoView(driver,datePicker);
        datePicker.click();
        return header.getText();
    }
    public String selectDateUsingDatePicker(WebDriver driver,String Day, String monthPick, String yearPick) {
        if ( dateInput.isEnabled() ) {
            actOn(driver).moveToElement(dateInput).click().build().perform();
            selectElement(monthSelect).selectByVisibleText(monthPick);
            selectElement(yearSelect).selectByValue(yearPick);
            for (WebElement ele : dateSelect) {
                if ( ele.getText().equals(Day) ) {
                    ele.click();
                    break;
                }
            }
            return dateInput.getAttribute("value");
        } else return null;
    }
    public String selectDateTimeUsingDatePicker(WebDriver driver,String Day, String monthPick, String yearPick,String timePick)
    {
       scrollIntoView(driver,dateTimeInput);
        if ( dateTimeInput.isEnabled() )
        {
            actOn(driver).moveToElement(dateTimeInput).click().build().perform();
            actOn(driver).moveToElement(monthListView).click().build().perform();

            for (WebElement ele : monthListSelect)          //for month selection
            {
                if(ele.getText().equals(monthPick))
                {
                    actOn(driver).moveToElement(ele).click().build().perform();
                    break;
                }
            }
            actOn(driver).moveToElement(yearListView).click().build().perform();

            if( yearListSelect.size()!=0)                   //for year selection
            {
                while(Integer.parseInt(yearListSelect.get(1).getText())<Integer.parseInt(yearPick))
                {
                    yearListSelect.get(0).click();
                    if(yearListSelect.get(1).getText().equals(yearPick))
                    {
                        yearListSelect.get(1).click();
                        break;
                    }
                }

                while(Integer.parseInt(yearListSelect.get(11).getText())>Integer.parseInt(yearPick))
                {
                    yearListSelect.get(12).click();
                    if(yearListSelect.get(11).getText().equals(yearPick))
                    {
                        yearListSelect.get(11).click();
                        break;
                    }
                }
            }

        for (WebElement ele : dateListSelect)   //for date selection
            {
                if ( ele.getText().equals(Day) )
                {
                    ele.click();
                    break;
                }
            }
            for(WebElement ele1:timeSelect)     //for time selection
            {
                if(ele1.getText().equals(timePick))
                {
                    scrollIntoView(driver,ele1);
                    actOn(driver).moveToElement(ele1).click().build().perform();
                    break;
                }
            }
            return dateTimeInput.getAttribute("value");
        } else return null;
    }
}
