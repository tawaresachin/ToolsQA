package com.cybage.assignment.page;

import com.cybage.assignment.objects.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sample
{

    public static void main(String[] args) throws SQLException {

        String updateQuery="UPDATE \"testSchema1\".\"testTable1\" \n" +
                "\tSET  marks=89\n" +
                "\tWHERE student_Name='John Wick';";
        SqlUtility sql=new SqlUtility();
        sql.updateTable("CybageDB",updateQuery);
        sql.tableData("CybageDB","\"testSchema1\".\"testTable1\"",3);
    }
}
