package com.tcoe.tests;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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
import actionLibrary.PelicanCls;

public class Pelican_CLS_Admin_WorkLoad_AddingStaff extends SelectBrowser
{
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	
	@BeforeMethod
	public void setUp(final ITestContext context) throws Exception 
	{
		automationFramework.SelectBrowser.WebBrowser();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	
	@Test
	public void testPelicanCls() throws Exception
	{
		try
		{
			// Opening the Excel file and Reading Data from Excel
			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "ClsOcdAdmin");
			
			// Variable Declaration (Assigning values of test data from Excel File to variables)
			String sUserName = ExcelUtils.getCellData(1, 2);
			String sPassword = utility.PasswordDecrypter.PasswordDecrypt(ExcelUtils.getCellData(1, 3));     
			
			String sOrganization = ExcelUtils.getCellData(1, 4);
			
			// ************************************************************************************************************ //
			
		    // Login to the application
		    PelicanLogin.Login(Constant.CLS_url, sUserName, sPassword);
		    
		    // Click on 'Administration' menu in the home page
		    driver.findElement(By.id("ctl00_lbtnAdministration")).click();
		    
		    // Click on <Go> button next to 'Workload' in "Administration Home" page
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ibtnWorkload")).click();
		    
		    // Click on <Go> button next to 'Staff Maintenance' in "Workload Home" page
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ibtnStaffMaintainance")).click();
		    
		    // Add a new staff in the workload
		    PelicanCls.AddNewStaff(sOrganization);
		    
		    // Check whether the confirmation message appears that "The information has been saved successfully"
		    String sConfirmationMessage = driver.findElement(By.xpath("//*[@id='ctl00_lblErrorMsg']")).getAttribute("textContent");
		    System.out.println("Message : " + sConfirmationMessage);
		    Reporter.log("Message : " + sConfirmationMessage);  
		    
			driver.close();
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
