package com.cybage.assignment.page;

import com.cybage.assignment.objects.utilities;
import com.cybage.assignment.test.toolsqaElementPageTest;
import com.cybage.assignment.test.toolsqaFormPageTest;
import org.bouncycastle.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static com.cybage.assignment.objects.locators.*;

import static com.cybage.assignment.objects.toolsqaBase.*;
import static com.cybage.assignment.objects.utilities.*;

public class sample
{
    static String path = "C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\genericProperty.properties";
    static SoftAssert ass;
    static widgetsPage widgetPage;

    public static void main(String[] args)
            throws IOException, InterruptedException {
        ass=new SoftAssert();
        initialize();
        WebDriver driver=browserFactory();
        driver.get("https://demoqa.com/date-picker");
        widgetPage=new widgetsPage(driver);

      String str=widgetPage.selectDateTimeUsingDatePicker(driver,"25","May","1988","00:15");
      System.out.println(str);
      driver.quit();
     }

}