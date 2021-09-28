package com.cybage.assignment.objects;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class testsample extends toolsqaBase
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        initialize();
        WebDriver driver=browserFactory();
        driver.get("https://demoqa.com/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
    }

}
