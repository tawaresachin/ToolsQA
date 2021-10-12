package com.cybage.assignment.objects;

import org.apache.commons.csv.*;

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
    private BufferedReader reader;
    private CSVParser parser;
    private BufferedWriter writer;
    private CSVPrinter fileOut;
    private String root;
    private Object[][] objArray;
    private boolean readFlag;

    /* This method opens the CSV file stored at provided location */
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

    /* This method reads the CSV file stored at provided location & display contents in console */
    public CsvUtility readContents()
    {
        try {
            parser = new CSVParser(reader, CSVFormat.DEFAULT);
            readFlag=true;
            for(CSVRecord csvRecord:parser)
                {
                Iterator<String> itr = csvRecord.iterator();
                while(itr.hasNext())
                 {
                    System.out.print(itr.next()+" ");
                 }
                System.out.println();
                }
            }
        catch(Exception e)
            {
             logs(e.getClass().getName() + ": " + e.getMessage());
            }
     return this;
    }

    /* This method write the desired data to CSV file stored at provided location*/
    public CsvUtility writeToCSV(String path, Object[][] inputData, boolean append)
    {
         root=path;
         fileOut=null;
         writer=null;
         try {
             if(!append)
                { writer = Files.newBufferedWriter(Paths.get(root), StandardOpenOption.CREATE_NEW);}
             else
                {writer = Files.newBufferedWriter(Paths.get(path), StandardOpenOption.APPEND, StandardOpenOption.CREATE);}

             fileOut = new CSVPrinter(writer, CSVFormat.DEFAULT);
             for (Object[] obj : inputData) {
                       fileOut.printRecord(obj);
                   }
                   logs("CSV file created and data written successfully...!");
             }

         catch (FileAlreadyExistsException e1)
               {
                   logs("This file is already exist, try with another filename...!");
               } catch (Exception e)
               {
                   logs(e.getClass().getName() + ": " + e.getMessage());
               }
    return this;
    }

    /* This method exports (append or clear-Write) the desired teh CSV data stored to the Excel file*/
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
    /* This method close the existing CSV file opened to read or newly created for desired data*/
    public void closeCSV()
    {
        try{
            if(readFlag) {
                parser.close();
                reader.close();
                file.close();
            }
            else{
                writer.flush();
                writer.close();
                fileOut.close();
            }
        }
        catch(Exception e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}
