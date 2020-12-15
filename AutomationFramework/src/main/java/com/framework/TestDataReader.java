package com.framework;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDataReader {

	public static Connection getConnection() throws Exception {
	    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	    //String url = "jdbc:odbc:excelDB";
	    String url = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xlsx)};DBQ="+System.getProperty("user.dir")+"\\TestData\\TestDataSheet.xlsx;"
        + "DriverID=22;READONLY=false";
	    String username = "yourName";
	    String password = "yourPass";
	    Class.forName(driver);
	    return DriverManager.getConnection(url, username, password);
	  }
	
	public static void main(String args[]) throws Exception {
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;

	    conn = getConnection();
	    stmt = conn.createStatement();
	    String excelQuery = "select * from [Sheet1$]";
	    rs = stmt.executeQuery(excelQuery);

	    while (rs.next()) {
	      System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
	    }
	    
	    rs.close();
	    stmt.close();
	    conn.close();
	}
	
}
