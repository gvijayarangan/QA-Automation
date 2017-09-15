package automationFramework;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ie.InternetExplorerDriver;

import automationFramework.ExcelUtils;
import configuration.Constant;

public class SelectBrowser 
{
	public static WebDriver driver;
	
	public static void WebBrowser() throws Exception 
	{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Browser");
		
		String browser = ExcelUtils.getCellData(1, 1);
		
		try 
		{

			if(browser.equals("Firefox"))
			{
				ProfilesIni profile = new ProfilesIni();
			    FirefoxProfile ffprofile = profile.getProfile("default");
			    driver = new FirefoxDriver(ffprofile);
			}
			              
			else if(browser.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C://Selenium//Drivers//Chrome Driver//chromedriver.exe");
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--test-type");
//				driver = new ChromeDriver(options);
				driver = new ChromeDriver();
			}
			
			else if (browser.equals("IE"))
			{
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				System.setProperty("webdriver.ie.driver", "C://Selenium//Drivers//IE Driver//IEDriverServer.exe");    
				driver = new InternetExplorerDriver(capabilities);
			}
			
		}
		
		catch (Exception e)
		{
			throw (e);
			 
		}
		
	
	}

}

