package Suite1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class dbConnect2 {
	// TODO Auto-generated method stub
	/*
	 * public void sqlconnection(String host, String port, String DBname, String
	 * userid, String password) throws SQLException {
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	private static Connection con;

	static {

		System.out.println("Inside static block");

		String host = "localhost";
		String port = "3306";
		String databasename = "framework";
		String userid = "root";
		String password = "root";

		try {
			con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databasename, userid,
					password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RetrunVal sqlselect(String selQuery) throws SQLException {

		Statement s = con.createStatement();
		ResultSet res = s.executeQuery(selQuery);
		RetrunVal rs = null;
		List<RetrunVal> rsList = new ArrayList<RetrunVal>();

		while (res.next()) {
			rs = new RetrunVal();
			rs.setId(res.getString("test_id"));
			rs.setDesc(res.getString("test_desc"));
			System.out.println("testid -->" + rs.getId());
			System.out.println("test_desc-->" + rs.getDesc());
			rsList.add(rs);

		}
		System.out.println(rsList.size());

		for (RetrunVal rsLi : rsList) {

			System.out.println(rsLi.getDesc());
		}
		return rs;
	}

}
