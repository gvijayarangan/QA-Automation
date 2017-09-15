package com.tcoe.tests;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.CurrentDateAndMonth;
import utility.RandomCharacterGeneration;
import configuration.Constant;
import errorHandling.ErrorHandler;
import automationFramework.ExcelUtils;
import automationFramework.SelectBrowser;
import actionLibrary.PelicanLogin;
import actionLibrary.PelicanCcw;

public class Pelican_CCW_UpdateHouseholdInfo extends SelectBrowser
{
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	@BeforeMethod
	public void setUp(final ITestContext context) throws Exception 
	{
		automationFramework.SelectBrowser.WebBrowser();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	
	@Test
	public void testPelicanCcw() throws Exception
	{
		try
		{
			// Opening the Excel file and Reading Data from Excel
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "CcwUpdateHouseholdInfo");
			
			// Variable Declaration (Assigning values of test data from Excel File to variables)
			String sUserName = ExcelUtils.getCellData(1, 2);
			String sPassword = utility.PasswordDecrypter.PasswordDecrypt(ExcelUtils.getCellData(1, 3));     
			
			String sCounties = ExcelUtils.getCellData(1, 4);
			String sCounty = ExcelUtils.getCellData(1, 5);
			String sAddress = ExcelUtils.getCellData(1, 6);
			String sWorkPhone = ExcelUtils.getCellData(1, 7);
			String sMobilePhone = ExcelUtils.getCellData(1, 8);
			
			// ************************************************************************************************************ //
			
		    // Login to the application
		    PelicanLogin.Login(Constant.CCW_url, sUserName, sPassword);
		    
		    // Select the county from the landing page and click on <Go> button
		    new Select(driver.findElement(By.id("ContentPlaceHolder1_cbSelectCounty"))).selectByVisibleText(sCounties);
		    driver.findElement(By.id("ContentPlaceHolder1_btnGo")).click();
		    Thread.sleep(2000);
		    		    
		    // Click on "Case" menu in 'PELICAN Child Care Works Home' page
		    driver.findElement(By.xpath("/html/body/form/div[2]/div[2]/div/div/ul/li[3]/a")).click();
		    
		    // Click on "Client Search" submenu under "Case" menu
		    driver.findElement(By.id("sub_nav_link_Client Search")).click();
		    
		    // Search a client and update household info of the client
		    PelicanCcw.ClientSearchAndUpdateHouseholdInfo(sCounty, sAddress, sWorkPhone, sMobilePhone);
		    
		    
		    
			//driver.close();
		}
		  
				
		catch(Exception ex)
		  {
			  DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
			  Date date = new Date();
			  System.out.println(ex);
			  ErrorHandler.HandleException("", "", "", "", "ERRORED", ex, null, "", driver, "C:\\Temp", "Failure_Screenshot_" + dateFormat.format(date), ".jpg");
			  throw ex;
		  }  
	  
	  }
	
	
	
	@AfterMethod
	public void tearDown() throws Exception 
	{
	    //driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) 
	    {
	      fail(verificationErrorString);
	    }
	    
	}
 
	 

}
