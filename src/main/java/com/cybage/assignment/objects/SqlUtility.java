package com.cybage.assignment.objects;
import javax.xml.transform.Result;
import java.sql.*;

public class SqlUtility extends utilities
{
    private Connection connect;
    private Statement stmt;
    public ResultSet result;

    private Connection connectDB(String dbName)
    {
        connect = null;
        try {
             connect = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/"+dbName,
                            genericProp(genPath,"sqlUser"), genericProp(genPath,"sqlPass"));
            System.out.println("DB Connection Successful...!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return connect;
    }

    public ResultSet readTable(String dbName, String query) throws SQLException {
        stmt=null;
        try
        {
            connect=connectDB(dbName);
            System.out.println("Connection Initiated for readTable operation");
            connect.setAutoCommit(false);
            stmt=connect.createStatement();
            result=stmt.executeQuery(query);
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        finally
        {
            connect.close();
        }
        return result;
    }

    public void updateTable(String dbName, String query) throws SQLException
    {
        stmt=null;
        try
        {   connect=connectDB(dbName);
            System.out.println("Connection Initiated for updateTable operation");
            connect.setAutoCommit(false);
            stmt=connect.createStatement();
            stmt.executeUpdate(query);
            connect.commit();
        }
        catch(Exception e)
        {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        finally
        {
            stmt.close();
            connect.close();
        }
    }

    public void tableData(String dbName,String tableName,int totalColumn) throws SQLException {
        String readQuery="SELECT * FROM "+tableName;
        result = readTable(dbName, readQuery);
        while(result.next())
        {
            for(int i=1;i<=totalColumn;i++)
            {
                System.out.print(result.getString(i)+" ");
            }
            System.out.println();
        }
        result.close();
    }

}
