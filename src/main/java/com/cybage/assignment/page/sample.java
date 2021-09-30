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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import static com.cybage.assignment.objects.locators.*;

import static com.cybage.assignment.objects.toolsqaBase.*;
import static com.cybage.assignment.objects.utilities.*;

public class sample
{

    public static void main(String[] args)
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        String date=localDateTime.getMonthValue()+"_"+localDateTime.getDayOfWeek().getValue()+"_"+localDateTime.getYear();
        System.out.println(date);
        String time=localDateTime.getHour()+"_"+localDateTime.getMinute();
        System.out.println(time);
     }

}