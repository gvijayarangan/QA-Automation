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

public class AddContractorPage extends SelectBrowser
{

	public static void  AddContractor(String sContractorName, int sContractorSSN, String sContractEffectiveDate, String sContractExpirationDate, String sAddressLine1, String sAddressLine2, String sCity, String sZip, String sEmail, int sContractorTelephone, int sContractorAlternateTelephone, String sPocFirstName, String sPocLastName, String sPocEmail, int sPocTelephone, int sPocAlternateTelephone) throws Exception
	{
		// Populate data in 'Add Contractor' page and then click on <Save> button
	    // Enter value in 'Name' field
	    driver.findElement(By.id("txtContName")).sendKeys(sContractorName);
	    
	    // Enter value in 'EIN/SSN' field
	    driver.findElement(By.id("txtContEin")).sendKeys("1" + sContractorSSN);
	    
	    // Enter date in 'Contract Effective Date' field
	    driver.findElement(By.id("txtContEffStartDate")).sendKeys(sContractEffectiveDate );
	    
	    // Enter date in 'Contract Expiration Date' field
	    driver.findElement(By.id("txtContExpdate")).sendKeys(sContractExpirationDate);
	    
	    // Enter Value in 'Address Line 1" field
	    driver.findElement(By.id("txtAddressLine1")).sendKeys(sAddressLine1);
	    
	    // Enter value in "Address Line 2" field
	    driver.findElement(By.id("txtAddressLine2")).sendKeys(sAddressLine2);
	    Thread.sleep(1000);
	    
	    // Enter value in "City" field
	    driver.findElement(By.id("txtCity")).sendKeys(sCity);
	    
	    // Enter value in "Zip" field
	    driver.findElement(By.id("cphBodyContent_txtZipCode")).sendKeys(sZip);
	    
	    // Enter value in "Email" field
	    driver.findElement(By.id("txtContractorEmail")).sendKeys(sEmail);
	    
	    // Enter value in "Telephone" field
	    driver.findElement(By.id("txtContractorPrimaryPhone")).sendKeys("71" + sContractorTelephone);
	    
	    // Enter value in "Alternate Telephone" field
	    driver.findElement(By.id("txtContractorAlternatePhone")).sendKeys("71" + sContractorAlternateTelephone);
	    
	    // Enter value in Point of Contact "First Name" field
	    driver.findElement(By.id("txtPocFirstName")).sendKeys(sPocFirstName);
	    
	    // Enter value in Point of Contact "Last Name" field
	    driver.findElement(By.id("txtPocLastName")).sendKeys(sPocLastName);
	    
	    // Enter value in Point of Contact "Email" field
	    driver.findElement(By.id("txtPocEmail")).sendKeys(sPocEmail);
	    
	    // Enter value in Point of Contact "Telephone" field
	    driver.findElement(By.id("txtPocPrimaryPhone")).sendKeys("71" + sPocTelephone);
	    
	    // Enter value in Point of Contact "Alternate Telephone" field
	    driver.findElement(By.id("txtPocAlternatePhone")).sendKeys("71" + sPocAlternateTelephone);
	    
	    // Click on <Save> button
	    driver.findElement(By.id("cphBodyContent_BtnSaveContractor")).click();
	    Thread.sleep(15000);
	}
	
}
