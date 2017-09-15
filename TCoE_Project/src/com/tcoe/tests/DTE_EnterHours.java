package com.tcoe.tests;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.*;

import automationFramework.SelectBrowser;
import actionLibrary.TaxJurisdictionCode;
import automationFramework.ExcelUtils;


public class DTE_EnterHours extends SelectBrowser{

  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	automationFramework.SelectBrowser.WebBrowser();
	baseUrl = "https://dte.deloitte.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void dte_Test() throws Exception {
	  
	// Variable Declaration (Assigning values of test data from Excel File to variables)
	String strChargeCode = ExcelUtils.getCellData(1, 3);  
	String strHoursForSunday = ExcelUtils.getCellData(1, 4).toString();
	String strHoursForMonday = ExcelUtils.getCellData(1, 5).toString();
	String strHoursForTuesday = ExcelUtils.getCellData(1, 6).toString();
	String strHoursForWednesday = ExcelUtils.getCellData(1, 7).toString();
	String strHoursForThursday = ExcelUtils.getCellData(1, 8).toString();
	String strHoursForFriday = ExcelUtils.getCellData(1, 9).toString();
	String strHoursForSaturday = ExcelUtils.getCellData(1, 10).toString();
	
	// Launching the Application URL in web-browser and maximizing the browser
    driver.get(baseUrl + "/te/ExpenseSummary.aspx");
    Thread.sleep(2000);
    driver.manage().window().maximize();

    
    // Click on 'Time' tab in "Time & Expense" page
    driver.findElement(By.cssSelector("#mainMenu_btnTime")).click();
    Thread.sleep(2000);
    
    
    
    // Click on the "+" icon next to the Tax Jurisdiction combo box
    String strTaxJurisdictionCode = actionLibrary.TaxJurisdictionCode.CaptureTaxJurisdictionCode();
    driver.findElement(By.cssSelector("#HEADER-" + strTaxJurisdictionCode + " > div:nth-child(1) > table > tbody > tr > td:nth-child(1) > img")).click();
    //driver.findElement(By.cssSelector("#otjList > div:nth-child(2) > div > div > div > div > table > tbody > tr > td:nth-child(1) > img")).click();
    Thread.sleep(2000);
    
    
    // Check whether the intended WBS code exists in DTE page
      
    WebElement table = driver.findElement(By.id("CONTENT-" + strTaxJurisdictionCode));
    List<WebElement> tableRows = table.findElements(By.tagName("tr"));
    
    System.out.println("NUMBER OF ROWS IN THIS TABLE = " + tableRows.size());
    
    int row_num, col_num;
        
    row_num=1;
    for (WebElement row : tableRows)
    {
    	List<WebElement> cells = row.findElements(By.tagName("td"));
    	
    	col_num=1;
    	
    	for (WebElement cell : cells)
    	{
    		//System.out.println(cell.getText());
    		System.out.println("Row No : " + row_num+ ",   " + "Col No : " + col_num + ",   " + "Text = " + cell.getText());
    		
    		if (cell.getText().contains(strChargeCode))
    		{
    			System.out.println("Match Found");
    			cell.click();
    			Thread.sleep(1000);
    			
    			driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td > span > input")).sendKeys(strHoursForSunday);
    			Thread.sleep(1000);
                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(5) > span > input")).sendKeys(strHoursForMonday);
                Thread.sleep(1000);
                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(7) > span > input")).sendKeys(strHoursForTuesday);
                Thread.sleep(1000);
                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(9) > span > input")).sendKeys(strHoursForWednesday);
                Thread.sleep(1000);
                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(11) > span > input")).sendKeys(strHoursForThursday);
                Thread.sleep(1000);
                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(13) > span > input")).sendKeys(strHoursForFriday);
                Thread.sleep(1000);
                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(15) > span > input")).sendKeys(strHoursForSaturday);

    			
    			
    			break;
    		}
    		
    		else
    		{
    			System.out.println("Match Not Found");
    		}
            col_num++;
    	}
    	
    	row_num++;
    	
    }
    


    
    
//    //WebElement table = driver.findElement(By.id("CONTENT-PA9E")); 
//    WebElement table = driver.findElement(By.id("ROOT-" + strTaxJurisdictionCode));
//
//    // Now get all the TR elements from the table 
//    List<WebElement> allRows = table.findElements(By.tagName("tr")); 
//
//    // And iterate over them, getting the cells 
//    for (WebElement row : allRows) 
//    { 
//     List<WebElement> cells = row.findElements(By.tagName("td")); 
//
//     // Print the contents of each cell
//     	for (WebElement cell : cells) 
//     	{ 
//         System.out.println(cell.getText());
//     	}
//    }
    
    

    
    
    
//    WebElement htmldiv =driver.findElement(By.xpath("//*[@id='timeEntryCenter']"));
//    
//    List<WebElement> rows=htmldiv.findElements(By.tagName("span"));
//    
//    for(int rnum=0;rnum<rows.size();rnum++)
//    {
//    	List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
//    	System.out.println("Number of columns:"+columns.size());
//    	
//    	for(int cnum=0;cnum<columns.size();cnum++)
//    	{
//    		System.out.println(columns.get(cnum).getText());
//    	}
//    }
//    
    
    
    
//    // Check whether charge code exists or not
//    boolean strChargeCodeExists = driver.findElements(By.xpath("//*[@id='PA9E-WBSLIST']/div[4]/div/table/tbody/tr/td[2]/span[1]")).size()!= 0;
//
//    if (strChargeCodeExists == true)
//    {
//    	System.out.println("Charge Code Exists");
//    }
//    else
//    {
//    	System.out.println("Charge Code does not Exist");
//    }
    
    		
    
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

