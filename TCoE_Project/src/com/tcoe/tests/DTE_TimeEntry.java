package com.tcoe.tests;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestContext;

import errorHandling.ErrorHandler;
import automationFramework.SelectBrowser;
import automationFramework.ExcelUtils;

public class DTE_TimeEntry  extends SelectBrowser{
	private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
  
  @BeforeMethod
  
  public void setUp(final ITestContext context) throws Exception {
			automationFramework.SelectBrowser.WebBrowser();
			baseUrl = "https://dte.deloitte.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
  

  @Test
  public void dte_Test() throws Exception {
	  
	  try
	  {
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
	    
	    //System.out.println("NUMBER OF ROWS IN THIS TABLE = " + tableRows.size());
	    
	    int row_num, col_num;
	        
	    row_num=1;
	    
	    for (WebElement row : tableRows)
	    {
	    	List<WebElement> cells = row.findElements(By.tagName("td"));
	    	
	    	col_num=1;
	    	
	    	for (WebElement cell : cells)
	    	{
	    		//System.out.println("Row No : " + row_num+ ",   " + "Col No : " + col_num + ",   " + "Text = " + cell.getText());
	    		
	    		if (cell.getText().contains(strChargeCode))
	    		{
	    			//System.out.println("Match Found");
	    			cell.click();
	    			Thread.sleep(1000);
	    			
	    			
	    			driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td > span > input")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),strHoursForSunday);
	    			Thread.sleep(1000);
	    			
	    			driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(5) > span > input")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),strHoursForMonday);
	                Thread.sleep(1000);
	                
	                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(7) > span > input")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),strHoursForTuesday);
	                Thread.sleep(1000);
	                
	                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(9) > span > input")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),strHoursForWednesday);
	                Thread.sleep(1000);
	                
	                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(11) > span > input")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),strHoursForThursday);
	                Thread.sleep(1000);
	                
	                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(13) > span > input")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),strHoursForFriday);
	                Thread.sleep(1000);
	                
	                driver.findElement(By.cssSelector(".TimeDetailHoursTable > tbody > tr > td:nth-child(15) > span > input")).sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),strHoursForSaturday);
	                Thread.sleep(1000);
	                
//	                driver.findElement(By.cssSelector("abc")).sendKeys(strHoursForSaturday);
//	                Thread.sleep(1000);
	                
	                driver.findElement(By.cssSelector("#timeEntrySave > img")).click();
	                Thread.sleep(1000);
	                
	    			break;
	    		}
	    		
//	    		else
//	    		{
//	    			System.out.println("Match Not Found");
//	    		}
	            col_num++;
	    	}
	    	
	    	row_num++;
	    	
	    }
	    

	  }
	  
	  
	  catch(Exception ex)
	  {
		  System.out.println(ex);
		  ErrorHandler.HandleException("", "", "", "", "ERRORED", ex, null, "", driver, "C:\\Temp", "Failure", ".jpg");
		  throw ex;
	  }
	    
	    

	    
	    
//	    // Check whether charge code exists or not
//	    boolean strChargeCodeExists = driver.findElements(By.xpath("//*[@id='PA9E-WBSLIST']/div[4]/div/table/tbody/tr/td[2]/span[1]")).size()!= 0;
	//
//	    if (strChargeCodeExists == true)
//	    {
//	    	System.out.println("Charge Code Exists");
//	    }
//	    else
//	    {
//	    	System.out.println("Charge Code does not Exist");
//	    }
	    
	    		
	    
	  }
  
  @AfterMethod
  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
  }

}
