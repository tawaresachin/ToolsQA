package com.cybage.assignment.objects;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Waits
{
    long timeout = 5000;
    long interval = 500;

    public WebElement waitedElement(WebDriver driver, By locator)
    {
         Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofMillis(timeout))
                .pollingEvery(Duration.ofMillis(interval))
                .withMessage("Timeout occured...!")
                .ignoring(NoSuchElementException.class);
        WebElement element = (WebElement)wait.until(

                new Function<WebDriver, WebElement>()
                {
                    public WebElement apply(WebDriver driver)
                    {
                        return driver.findElement(locator);
                    }
                }
        );
        return element;
    }
}
