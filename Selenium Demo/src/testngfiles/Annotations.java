package testngfiles;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations extends firstcode {

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
	firstcode fc = new firstcode();
	
	}
	
	@Test
	public void Closebrowser()
	{
	System.out.println("close browser");
	}
	
	@AfterTest
	public void Aftertest()
	{
	System.out.println("after test");
	}


}