package com.cybage.assignment.objects;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import static com.cybage.assignment.objects.utilities.*;

public class ExcelUtility {
    private FileInputStream file;
    private FileOutputStream outputStream;
    private Workbook workbook;
    private Sheet sheet;
    private Row row;
    private Cell column;
    ExcelUtility field;
    String stringValue;
    String numericValue;
    int lastRow;
    int firstRow;
    int lastCol;
    int firstCol;
    String root;

    /* This method is to locate the required sheet by name from desired excel workbook */
    public ExcelUtility openExcel(String path, Object sheetRef)
    {   root = path;
        try
        {
            file=new FileInputStream(path);

            workbook = WorkbookFactory.create(file);
            if(sheetRef instanceof String) {
                sheet = workbook.getSheet((String)sheetRef);
            }
            else
            if(sheetRef instanceof Integer)
            {
                sheet = workbook.getSheetAt(((Integer) sheetRef).intValue());
            }
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return this;
    }

    /* This method is to locate the required row by index from desired sheet */
    public Row rowAt(int rowNum) {
        try {
            row = sheet.getRow(rowNum);
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return row;
    }

    /* This method is to locate the required column by index from against located row */
    public Cell columnAt(int colNum) {
        try {
            column = row.getCell(colNum);
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return column;
    }

    /* This method is to locate the required column by index from against located row */
    public ExcelUtility getField(int rowNum,int colNum) {
        try {
            column= sheet.getRow(rowNum).getCell(colNum);
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return this;
    }

    /* This method is to read String from desired cell */
    public String getString() {
        try {
            stringValue = column.getStringCellValue();
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return stringValue;
    }

    /* This method is to read Numeric value from desired cell */
    public String getNumeric() {
        try {
            DecimalFormat convert = new DecimalFormat("#");
            if(column.getCellType()==CellType.NUMERIC) {
                numericValue = convert.format(column.getNumericCellValue());
            }

        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return numericValue;
    }

    /* This method is to get the index of last available row number */
    public int getLastRow() {

        try {
            lastRow = sheet.getLastRowNum();
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return lastRow;
    }

    public int getFirstRow() {

        try {
            firstRow = sheet.getFirstRowNum();
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return firstRow;
    }

    /* This method is to get the index of last available column number */
    public int getLastColumn() {
        try {
            lastCol = row.getLastCellNum();
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return lastCol;
    }

    public int getFirstColumn() {
        try {
            firstCol= row.getFirstCellNum();
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return firstCol;
    }

    /* This method is to append the data into existing sheet of workbook */
    public ExcelUtility appendDataInSheet(Object[][]inputData)
    {
        try
        {
            int rowCount = sheet.getLastRowNum();

                for (Object[] obj : inputData)
                {
                    Row createdRow = sheet.createRow(++rowCount);
                    int columnCount = 0;

                    Cell cell = createdRow.createCell(columnCount);
                    cell.setCellValue(rowCount);

                    for (Object pos : obj)
                    {
                        cell = createdRow.createCell(columnCount++);
                        if ( pos instanceof String )
                        {
                            cell.setCellValue((String) pos);
                        } else if ( pos instanceof Integer )
                        {
                            cell.setCellValue((Integer) pos);
                        }
                    }
                }
            file.close();
        }

        catch(IOException e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }

    return this;
    }
    public ExcelUtility clearSheet()
    {
        try
        {
            for(int i=getLastRow();i>=getFirstRow();i--)
            {
                sheet.removeRow(rowAt(i));
            }
        }
        catch(Exception e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return this;
    }

    public ExcelUtility saveWorkbook()
    {
       try {
           outputStream = new FileOutputStream(root);
           workbook.write(outputStream);
       }
       catch(Exception e)
       {
           logs(e.getClass().getName() + ": " + e.getMessage());
       }
       return this;
    }

    public ExcelUtility saveAndClose()
    {
        try {
            outputStream = new FileOutputStream(root);
            workbook.write(outputStream);
            closeExcel();
        }
        catch(Exception e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return this;
    }

    public ExcelUtility closeExcel()
    {
        try{
            file.close();
            workbook.close();
            outputStream.close();
        }
        catch(Exception e)
        {
            logs(e.getClass().getName() + ": " + e.getMessage());
        }
        return this;

    }
}


