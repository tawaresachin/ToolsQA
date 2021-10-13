package com.cybage.assignment.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.cybage.assignment.objects.utilities.genericProp;

public class toolsqaBase {
    static FileInputStream file;
    private static ChromeOptions options;
    public static final String appPath = "C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\webAppGeneric.properties";
    public static final String genPath = "C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\genericProperty.properties";

    private static void initialize() throws IOException                                  //set browser specific property
    {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);       //to turn off browser notifications
        switch (genericProp(genPath, "browser")) {
            case "firefox":
                System.setProperty(genericProp(genPath, "geckoProperty"), genericProp(genPath, "geckoPath"));
                break;
            case "edge":
                System.setProperty(genericProp(genPath, "edgeProperty"), genericProp(genPath, "edgePath"));
                break;
            default:
                System.setProperty(genericProp(genPath, "chromeProperty"), genericProp(genPath, "chromePath"));
                options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);       //to handle browser notification
                options.setAcceptInsecureCerts(true);                      // to handle SSL certificates
                break;
        }
    }

    public static WebDriver browserFactory() throws IOException                           //create browser specific webdriver
    {
        initialize();
        WebDriver driver;
        switch (genericProp(genPath, "browser")) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }
}