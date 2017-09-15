package actionLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationFramework.SelectBrowser;

public class ChildCareLogin extends SelectBrowser
{

	public static void  Login(String sUserName, String sPassword) throws Exception
	{
		// Login to the application
	    driver.findElement(By.id("cphBodyContent_txtUserName")).clear();
	    driver.findElement(By.id("cphBodyContent_txtUserName")).sendKeys(sUserName);
	    driver.findElement(By.id("cphBodyContent_txtPassword")).clear();
	    driver.findElement(By.id("cphBodyContent_txtPassword")).sendKeys(sPassword);
	    //driver.findElement(By.id("cphBodyContent_ddlEnvslist")).sendKeys("Change Integration");
	    driver.findElement(By.id("cphBodyContent_btnSubmit")).click();
	    Thread.sleep(2000);	    
	}
	
}
