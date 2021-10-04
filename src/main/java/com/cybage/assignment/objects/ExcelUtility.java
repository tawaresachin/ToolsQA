package com.cybage.assignment.objects;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class ExcelUtility {
        private Workbook workbook;
        private Sheet sheet;
        private Row row;
        private Cell column;
        String stringValue;
        String numericValue;
        int lastRow;
        int lastCol;

        /* This method is to locate the required sheet by name from desired excel workbook */
        public ExcelUtility openExcel(String path, String sheetName) throws IOException {


            try(FileInputStream file=new FileInputStream(path))
            {

                workbook = WorkbookFactory.create(file);
                this.sheet=workbook.getSheet(sheetName);
            }
            catch(Exception e)
            {
                throw (e);
            }
            finally {
                workbook.close();
            }
            return this;
        }

    /* This method is to locate the required row by index from desired sheet */
        public ExcelUtility Row(int rowNum)
        {
            try
            {     this.row=sheet.getRow(rowNum);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            return this;
        }

    /* This method is to locate the required column by index from against located row */
        public ExcelUtility Column(int colNum)
        {
            try
            {  this.column=row.getCell(colNum);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            return this;
        }

    /* This method is to read String from desired cell */
        public String getString()
        {
            try
            {
                stringValue=column.getStringCellValue();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            return stringValue;
        }

    /* This method is to read Numeric value from desired cell */
        public String getNumeric()
        {
            try
            {       DecimalFormat convert = new DecimalFormat("#");
                numericValue= convert.format(column.getNumericCellValue());
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            return numericValue;
        }

    /* This method is to get the index of last available row number */
        public int getLastRow()
        {

            try
            {    lastRow=sheet.getLastRowNum();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            return lastRow;
        }

    /* This method is to get the index of last available column number */
        public int getLastColumn()
        {
            try
            {
                lastCol=row.getLastCellNum();

            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
            return lastCol;
        }

    }

