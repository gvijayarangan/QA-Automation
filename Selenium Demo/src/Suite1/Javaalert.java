package Suite1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Javaalert {
   
	@Test
	public void fbtest()
	{
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\gvijayarangan\\Downloads\\setups\\IEDriverServer.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\gvijayarangan\\Downloads\\setups\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gvijayarangan\\Downloads\\setups\\chromedriver.exe");
		//WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dte.deloitte.com/te/TimeDetails.aspx");
		//driver.Manage().Window.Maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.manage().window().maximize();
		//driver.switchTo().frame("child");
		//driver.findElement(By.xpath("//*[@id=\"dialogContent_btnCertificateClose\"]")).click();
		driver.close();
		
	}


}
