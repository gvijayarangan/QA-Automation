import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngapp {
	
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
