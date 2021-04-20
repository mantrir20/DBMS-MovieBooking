import java.sql.*;
import javax.swing.JOptionPane;


public class databaseConnect{
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/dbms_proj";
	static final String USER = "root";
	static final String PASS = "Rao22042000*";
    
	public static Connection dbconnect(){ 
	
		Connection conn=null;
	    try{
	    	Class.forName(JDBC_DRIVER);
	    	System.out.println("Connecting to a selected database\n");
	    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    	System.out.println("Connected database successfully\n");
	        return conn;
	    
	    }catch(Exception e){
	    	
	        JOptionPane.showMessageDialog(null ,e);
	        System.out.println("Error Connecting to database\n");
	        return null;
	    	}
	    }
}