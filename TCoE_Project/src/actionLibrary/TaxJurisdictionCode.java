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

public class TaxJurisdictionCode extends SelectBrowser
{

	public static String CaptureTaxJurisdictionCode() throws Exception
	{
		String strTaxJurisdiction;
	    String strTaxJurisdictionCode;
	    
	    strTaxJurisdiction = driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div[1]/table/tbody/tr/td[3]/span/input")).getAttribute("value");
	    
	    //System.out.println("Message 1 : " + strTaxJurisdiction);
	    
	    int intTaxJurisdictionLength = strTaxJurisdiction.length();
	    int intTaxJurisdictionIndex = strTaxJurisdiction.indexOf("(");
	    strTaxJurisdictionCode = strTaxJurisdiction.substring(intTaxJurisdictionIndex +1, intTaxJurisdictionLength - 1);
	    
	    //System.out.println("Tax Jurisdiction Code : " + strTaxJurisdictionCode);
	    
	    return strTaxJurisdictionCode;
	}
	
}
