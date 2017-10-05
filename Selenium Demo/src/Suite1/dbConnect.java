package Suite1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnect {

	/*public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		String databasename = "framework";
		String userid = "root";
		String password = "root";
		
		//DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/databasename", "userid", "pass");
	   Connection con =DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+ databasename , userid, password);
	
	   Statement s = con.createStatement();
	   s.executeUpdate("insert into test values(3, 'This is a sample insert3');");
	   System.out.println("insert query executed");
	   ResultSet res = s.executeQuery("Select * from test;");
	   
	   while(res.next())
	   {
	   System.out.println(res.getString("test_id"));
	   System.out.println(res.getString("test_desc"));
	   }	   
	}*/
	
	public static void main(String[] args) throws SQLException {
		
		dbConnect2 dbcon = new dbConnect2();
		
		String selQuery="select * from test;";
		
		dbcon.sqlselect(selQuery);
		
	}

}
