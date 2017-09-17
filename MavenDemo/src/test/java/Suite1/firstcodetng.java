package Suite1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class firstcodetng {
   
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


}
