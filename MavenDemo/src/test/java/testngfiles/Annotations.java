package testngfiles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

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
