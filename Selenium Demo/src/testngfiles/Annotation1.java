package testngfiles;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//this runs first when the entire suite runs
public class Annotation1 {
	@BeforeSuite
	public void Beforesuite()
	{
	System.out.println("before Suite");
	}
	
	@AfterSuite
	public void Aftersuite()
	{
	System.out.println("after Suite");
	}
	
	
	@Test(dataProvider="getData")
	public void dataprov(String userid, String password, String id)
	{
	System.out.println("data provider test");
	System.out.println("username "+userid);
	System.out.println("password "+password);
	System.out.println("id "+id);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// Object[i][j] ->i is total test cases and j is total values
		Object[][] data = new Object[3][3];
		data[0][0] = "Gopi";
		data[0][1] = "Test";
		data[0][2] = "idq";
		data[1][0] = "Gopi1";
		data[1][1] = "Test1";
		data[1][2] = "idq1";
		data[2][0] = "Gopi2";
		data[2][1] = "Test2";
		data[2][2] = "idq2";
		return data;
	}
	
}
