package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
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
	
	@BeforeMethod
	public void Beforemethod()
	{
	System.out.println("before method");
	}
	
	@BeforeTest
	public void Beforetest()
	{
	System.out.println("before test");
	}
	
	@Test
	public void Openbrowser()
	{
	System.out.println("open browser");
	
	}
	
	@Test(dependsOnMethods= {"Openbrowser"}, timeOut=0)
	public void Closebrowser()
	{
	System.out.println("close browser");
	}
	
	@Test(enabled=false)
	public void skip()
	{
	System.out.println("skip");
	}
	
	@Test(groups= {"Priority1"})
	public void prior1()
	{
	System.out.println("priority1");
	}
	
	@Test(groups= {"Priority2"})
	public void prior2()
	{
	System.out.println("priority2");
	}
	
	@Test
	public void fbtest()
	{
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\gvijayarangan\\Downloads\\setups\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gvijayarangan\\Downloads\\setups\\chromedriver.exe");
		//Webdriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
	}

		
	@AfterMethod
	public void Aftermethod()
	{
	System.out.println("after method");
	}
	@AfterTest
	public void Aftertest()
	{
	System.out.println("after test");
	}
}
