package com.cybage.assignment.objects;

import org.apache.commons.csv.*;
import org.openqa.selenium.Keys;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

import static com.cybage.assignment.objects.utilities.*;

public class CsvUtility
{
    private FileInputStream file;
    private CSVPrinter fileOut;
    private BufferedReader reader;
    private BufferedWriter writer;
    private CSVParser csvParser;
    private String root;
    private Object[][] objArray;

    public CsvUtility openCSV(String path)
    {
        root = path;
        try {
            file=new FileInputStream(root);
            reader = Files.newBufferedReader(Paths.get(root));
            }
        catch (Exception e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
    return this;
    }

    public CsvUtility readContents()
    {
        String thisLine;

        try (DataInputStream data = new DataInputStream(new FileInputStream(root)))
        {
                ArrayList<String[]> lines = new ArrayList<>();
                while((thisLine=data.readLine()) != null)
                {
                    lines.add(thisLine.split(","));
                }
                String[][]csvData=new String[lines.size()][0];
                objArray=lines.toArray(csvData);

                for(String[] ar:lines)
                {
                    for(String arr:ar)
                    {
                        System.out.print(arr+" ");
                    }
                    System.out.println();
                }

        }
        catch (Exception e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return this;
    }

    public CsvUtility writeToCSV(String path, Object[][] inputData, boolean append)
    {
       root=path;

       try
       {
           if(!append) {
               writer = Files.newBufferedWriter(Paths.get(root),StandardOpenOption.CREATE_NEW);
               fileOut = new CSVPrinter(writer, CSVFormat.DEFAULT);

               for (Object[] obj : inputData) {
                   fileOut.printRecord(obj);
               }
               writer.flush();
               logs("CSV file created and data written successfully...!");
           }
           else
           {
               writer = Files.newBufferedWriter(Paths.get(path),StandardOpenOption.APPEND,StandardOpenOption.CREATE);
               fileOut = new CSVPrinter(writer, CSVFormat.DEFAULT);

               for (Object[] obj : inputData) {
                   fileOut.printRecord(obj);
               }
              logs("Data appended successfully...!");
           }
           writer.flush();
           writer.close();
           fileOut.close();
       } catch (FileAlreadyExistsException e1)
       {
           logs("This file is already exist, try with another filename...!");
       } catch (Exception e)
       {
           logs(e.getClass().getName() + ": " + e.getMessage());
       }
        return this;
    }
    public CsvUtility exportToExcel(String excelPath, String sheetName, boolean clearSheet)
    {
        ExcelUtility excel=new ExcelUtility();
        excel.openExcel(excelPath, sheetName);
        if(clearSheet)
        {
            excel.clearSheet();
        }
        excel.appendDataInSheet(objArray).saveAndClose();
        logs("Data is successfully Exported to worksheet "+sheetName+" at "+excelPath);
        return this;
    }

    public void closeCSV()
    {
        try{

            file.close();
            reader.close();
            csvParser.close();
        }
        catch(Exception e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
