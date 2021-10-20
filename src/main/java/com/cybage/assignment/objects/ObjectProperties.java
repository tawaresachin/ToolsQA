package com.cybage.assignment.objects;

import org.yaml.snakeyaml.Yaml;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

public class ObjectProperties
{
    private static String ymlFilePath;
    private static Map<?,?> map;

    /* To initialize yaml file reader at specified path  & load data into map*/
    private static String initialize(String objectCall)
    {
        try(Reader rd = new FileReader(ymlFilePath);)
        {
            Yaml yaml = new Yaml();
            Map<?,?>property = (Map<?, ?>) yaml.load(rd);
            map =(Map<?,?>)property.get(objectCall.split("\\.")[0]);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return map.get(objectCall.split("\\.")[1].trim()).toString();
    }

    /* To set path of desired yaml file to be used */
    public static void initializeObjectProperties(String yamlPtah)
    {
        ymlFilePath=yamlPtah;
    }

    /* To get object called by specified key */
    public static String getProperty(String objectCall)
    {
       return initialize(objectCall);
    }
}
