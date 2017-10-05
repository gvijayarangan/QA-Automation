package Suite1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.gargoylesoftware.htmlunit.javascript.host.Set;

public class WindowHandler {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gvijayarangan\\Downloads\\setups\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://my.dnet.deloitte.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		System.out.println(driver.getTitle());
		//Thread.sleep(6000);
		WebDriverWait d=new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/section/div/ng-view/div/div[1]/div/div[2]/div[1]/div/alert/div/div[2]/a")));
		driver.findElement(By.xpath("/html/body/div[3]/section/div/ng-view/div/div[1]/div/div[2]/div[1]/div/alert/div/div[2]/a")).click();
		Set<String>ids=driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String parentwin =itr.next();
		String childwin =itr.next();
		driver.switchTo().window(childwin);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		System.out.println("switched to window with title ->"+driver.getTitle());
		//driver.close();
		
	}
	
	

}
