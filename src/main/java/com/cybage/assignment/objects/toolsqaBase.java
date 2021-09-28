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
import java.util.Properties;

public class toolsqaBase
{
  protected static WebDriver driver;
  protected static Properties prop;
  static FileInputStream file;
  static ChromeOptions options;
  static String path ="C:\\Users\\sachintaw\\IdeaProjects\\ToolsQA\\src\\main\\resources\\testData\\genericProperty.properties";
    public static String genericProp(String path, String param) throws IOException       //Generic method to read properties file
   {
       file=new FileInputStream(path);
       prop=new Properties();
       prop.load(file);
       return (prop.getProperty(param));
   }

   public static void initialize() throws IOException                                  //set browser specific property
    {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
       switch(genericProp(path,"browser"))
       {
           case "firefox":
               System.setProperty(genericProp(path,"geckoProperty"),genericProp(path,"geckoPath"));
               break;
           case "edge":
               System.setProperty(genericProp(path,"edgeProperty"),genericProp(path,"edgePath"));
               break;
           default :
               System.setProperty(genericProp(path,"chromeProperty"), genericProp(path,"chromePath"));
               options=new ChromeOptions();
               options.setExperimentalOption("prefs", prefs);
               break;
       }
    }
   public static WebDriver browserFactory() throws IOException                           //create browser specific webdriver
   {

       switch (genericProp(path,"browser"))
       {
           case "firefox":
               driver=new FirefoxDriver();
               break;
           case "edge":
               driver=new EdgeDriver();
               break;
           default:
               driver=new ChromeDriver(options);
               break;
       }
       return driver;
   }

}
