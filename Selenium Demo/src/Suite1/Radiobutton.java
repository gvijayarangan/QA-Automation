package Suite1;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Radiobutton  {

	static WebDriver driver = new ChromeDriver();
	public Properties prop;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gvijayarangan\\Downloads\\setups\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");	
		driver.findElement(By.xpath("//input[@value='Milk']")).click();
	System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).size());
	
	
	//explicit wait logic
	WebDriverWait d=new WebDriverWait(driver,20);
	d.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/section/div/ng-view/div/div[1]/div/div[2]/div[1]/div/alert/div/div[2]/a")));
	//d.until(ExpectedConditions.titleIs(title));	
		
	}
	
	public List<WebElement> getElements(String locatorkey){
		List<WebElement> e = null;
		try{
			if(locatorkey.endsWith("id")){
				e=driver.findElements(By.id(prop.getProperty(locatorkey)));
			}
			if(locatorkey.endsWith("name")){
				e=driver.findElements(By.name(prop.getProperty(locatorkey)));
			}
			if(locatorkey.endsWith("xpath")){
				e=driver.findElements(By.xpath(prop.getProperty(locatorkey)));
			}
			if(locatorkey.endsWith("cssSelector")){
				e=driver.findElements(By.cssSelector(prop.getProperty(locatorkey)));
			}
		}catch(Exception exception){
			Assert.fail("failure in finding element" + locatorkey);
			exception.printStackTrace();
			
		}
		return e;
	}

}
