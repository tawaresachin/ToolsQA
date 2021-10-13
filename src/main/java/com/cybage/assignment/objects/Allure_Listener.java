package com.cybage.assignment.objects;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.cybage.assignment.objects.toolsqaBase.browserFactory;

public  class Allure_Listener implements ITestListener
{
    ITestResult result;
    @Override
    public void onStart(ITestContext context) {
//        System.out.println("Method Execution is started ");
    }

    @Override
    public void onFinish(ITestContext context) {
//        System.out.println("Method Execution is Finished ");
    }

    @Override
    public void onTestStart(ITestResult result) {
//        System.out.println("New Test is Started: " +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        System.out.println("Test is PASSED: " +result.getName());
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("Test is FAILED: " +result.getName());
//        ITestContext context = result.getTestContext();
//        WebDriver driver = (WebDriver) context.getAttribute("driver");
//        allureSnap(driver);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        System.out.println("Test is SKIPPED: " +result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test is FAILED with success percentage: " +result.getName());
    }

    private static String getTestMethodName(ITestResult result)
    {
        return result.getMethod().getConstructorOrMethod().getName();
    }

}
