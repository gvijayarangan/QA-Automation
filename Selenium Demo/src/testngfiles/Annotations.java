package testngfiles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations  {

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
	
	@Test(dependsOnMethods= {"Openbrowser"})
	public void Closebrowser()
	{
	System.out.println("close browser");
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
