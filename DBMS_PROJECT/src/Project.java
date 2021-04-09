import java.sql.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
public class Project {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/dbms_proj";
	static final String USER = "root";
	   static final String PASS = "";

	public static void main(String[] args)
	{
		Connection conn = null;
		   Statement stmt = null;
		   try {
		      Class.forName(JDBC_DRIVER);
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      String sql = "SELECT * FROM moviedetail;";
		      ResultSet val = stmt.executeQuery(sql);
		      while(val.next())
		      {
		    	  System.out.println(val.getString(1));
		      }
		   }
		   catch(Exception se)
		   {
			   se.printStackTrace();
		   }
		   //comment
	}
}