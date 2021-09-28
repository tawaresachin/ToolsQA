package com.cybage.assignment.page;

import com.cybage.assignment.objects.locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class toolsqaHomePage extends locators
{
    static Boolean status;

    @FindBy(xpath=HOME_PAGE_LOGO) private WebElement logo;
    @FindBy(xpath=homePageBanner) private WebElement banner;
    @FindBy(xpath=elementTab) private WebElement elements;
    @FindBy(xpath=formsTab) private WebElement forms;
    @FindBy(xpath=alertFrameWindowTab) private WebElement alertFrameWindow;
    @FindBy(xpath=widgetTab) private WebElement widget;
    @FindBy(xpath = interactionsTab) private WebElement interactions;
    @FindBy(xpath=bookStoreApplicationTab) private WebElement bookStoreApplication;

    public toolsqaHomePage(WebDriver driver)            //Initialize Elements using PageFactory

    {
        PageFactory.initElements(driver,this);
    }

    public Boolean checkPageTitle(WebDriver driver)
    {
        String title=driver.getTitle();
        return(title.equals(pageTitleText));
    }
    public Boolean isLogoPresent()
    {
        status=logo.isDisplayed();
        return status;
    }
    public Boolean isBannerPresent()
    {
        status=banner.isDisplayed();
        return status;
    }
    public Boolean isElementTabPresent()
    {
        status=elements.isDisplayed();
        return status;
    }
    public Boolean isFormsTabPresent() {
        status=forms.isDisplayed();
        return status;
    }
    public Boolean isAlertFrameWindowTabPresent() {
        status=alertFrameWindow.isDisplayed();
        return status;
    }
    public Boolean isWidgetTabPresent() {
        status=widget.isDisplayed();
        return status;
    }
    public Boolean isInteractionsTabPresent()
    {
        status=widget.isDisplayed();
        return status;
    }
    public Boolean isBookStoreApplicationTabPresent()
    {
        status=bookStoreApplication.isDisplayed();
        return status;
    }

}
