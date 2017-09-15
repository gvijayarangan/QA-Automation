package testngfiles;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
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
}
