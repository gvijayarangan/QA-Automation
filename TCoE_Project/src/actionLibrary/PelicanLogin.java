package actionLibrary;

import org.openqa.selenium.By;

import automationFramework.SelectBrowser;


public class PelicanLogin extends SelectBrowser 
{
	public static void Login(String sUrl, String sUserName, String sPassword)
	{
		// Invoke the web browser, enter the url and maximize the browser
		driver.get(sUrl);
	    driver.manage().window().maximize();
	    
	    // Enter Userid, Password in the login screen and click on <Login> button
	    driver.findElement(By.id("USER")).clear();
	    driver.findElement(By.id("USER")).sendKeys(sUserName);
	    
	    driver.findElement(By.id("PASSWORD")).clear();
	    driver.findElement(By.id("PASSWORD")).sendKeys(sPassword);
	    
	    driver.findElement(By.id("loginBtn")).click();	    
	    
	}


}
