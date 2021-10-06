package com.cybage.assignment.objects;


import java.sql.*;


public class SqlUtility extends utilities {
    private Connection connect;
    private CallableStatement stmt;
    private ResultSet result;


    /* This method establish the connection with provided database*/
    public SqlUtility connectDB(String database) {
        String dbName=database;
        connect = null;
        try {

            connect = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + dbName,
                            genericProp(genPath, "sqlUser"), genericProp(genPath, "sqlPass"));
            logs("DB Connection Successful...!");
        } catch (Exception e) {
            e.printStackTrace();
            logs(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return this;
    }

    /* This method reads database table as per given query & provided database*/
    public SqlUtility readTable(String readQuery, boolean display) {
        stmt = null;
        try {
            logs("Connection Initiated for readTable operation");
            connect.setAutoCommit(false);
            stmt=connect.prepareCall(readQuery,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_FORWARD_ONLY);
            this.result = stmt.executeQuery();
            if(display)
            {   while (result.next()) {
                    for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
                        System.out.print(result.getString(i) + " ");
                    }
                    System.out.println();
                }
            }

        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return this;
    }

    /* This method updates the database table as per given query & provided database*/
    public SqlUtility updateTable(String updateQuery) {

        try {
            connect.setAutoCommit(false);
            logs("Connection Initiated for updateTable operation");
            stmt=connect.prepareCall(updateQuery);
            stmt.executeUpdate();
            connect.commit();
        } catch (Exception e) {
            logs(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        logs("Database Table update Successful...!");
    return this;
    }

    public SqlUtility exportToExcel(String excelPath, String sheetName, boolean clearSheet) throws SQLException{
         ExcelUtility excel=new ExcelUtility();
        excel.openExcel(excelPath, sheetName);
        if(clearSheet)
        {
            excel.clearSheet();
        }

            int totalColumn = result.getMetaData().getColumnCount();
            result.last();
            int size = result.getRow();
            result.beforeFirst();
            Object[][] data = new Object[size][totalColumn];
            int count = 0;
            while (result.next()) {
                for (int j = 1; j <= totalColumn; j++) {
                    Object obj = result.getObject(j);
                    if ( obj != null ) {
                        data[count][j - 1] = obj;
                    }
                }
                count++;
            }
            excel.appendDataInSheet(data).saveAndClose();
        logs("Data is successfully Exported to worksheet "+sheetName+" at "+excelPath);
        return this;
        }

        public SqlUtility closeConnection()
        {
            try {
                stmt.close();
                connect.close();
            }
            catch(Exception e)
            {
                logs(e.getClass().getName() + ": " + e.getMessage());
            }
            return this;
        }


    }


