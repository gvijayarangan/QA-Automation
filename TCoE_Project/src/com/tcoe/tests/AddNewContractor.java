package com.tcoe.tests;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestContext;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;

import sun.util.logging.resources.logging;
import utility.CurrentDateAndMonth;
import utility.RandomCharacterGeneration;
import errorHandling.ErrorHandler;
import automationFramework.SelectBrowser;
import automationFramework.ExcelUtils;
import configuration.Constant;
import actionLibrary.ChildCareLogin;


public class AddNewContractor  extends SelectBrowser
{

	private StringBuffer verificationErrors = new StringBuffer();
	  
  
  @BeforeMethod
  
  public void setUp(final ITestContext context) throws Exception 
  {
	  automationFramework.SelectBrowser.WebBrowser();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
  

  @Test
  public void NewContractor() throws Exception {
	  
	  try
	  {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "AddNewContractor");
		
		// Variable Declaration (Assigning values of test data from Excel File to variables)
		String sUserName = ExcelUtils.getCellData(2, 2);	
		String sPassword = ExcelUtils.getCellData(2, 3).toString();
			
		String sContractorName = RandomCharacterGeneration.randomString();
		int sContractorSSN = RandomCharacterGeneration.randomNumber();
		String sContractEffectiveDate = CurrentDateAndMonth.CurrentDate();
		String sContractExpirationDate = CurrentDateAndMonth.CurrentDate();
		String sAddressLine1 = ExcelUtils.getCellData(2, 4);
		String sAddressLine2 = ExcelUtils.getCellData(2, 5);
		String sCity = ExcelUtils.getCellData(2, 6);
		String sZip = ExcelUtils.getCellData(2, 7);
		String sEmail = ExcelUtils.getCellData(2, 8);
		int sContractorTelephone = RandomCharacterGeneration.randomNumber(); 
		int sContractorAlternateTelephone = RandomCharacterGeneration.randomNumber();
		String sPocFirstName = RandomCharacterGeneration.randomString();
		String sPocLastName = RandomCharacterGeneration.randomString();
		String sPocEmail = ExcelUtils.getCellData(2, 9);
		int sPocTelephone = RandomCharacterGeneration.randomNumber();
		int sPocAlternateTelephone = RandomCharacterGeneration.randomNumber();
			
		
		// Launching the Application URL in web-browser and maximizing the browser
		driver.get(Constant.ChildCare_url);
		Thread.sleep(2000);
	    driver.manage().window().maximize();

	    
	 // ********************************************************************************************* //
	    
	    // Login to the application
	    ChildCareLogin.Login(sUserName, sPassword);
    
	    
	    // ********************************************************************************************* //

	    // Click on 'Contractor' option under "Menu" panel at the left panel of the Home page
	    driver.findElement(By.linkText("Contractor")).click();
	    
	    // Click on 'Contractor Search' option under "Contractor" menu
	    driver.findElement(By.linkText("Contractor Search")).click();
	    
	    // Click on 'Add Contractor' link under "Search Results" section
	    driver.findElement(By.id("lnkAddContractor")).click();
	    Thread.sleep(3000);
	    
	    // Select Contractor Type in 'Add Contractor' pop-up and then click on <OK> button in the pop-up
	    driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div/div/div/div[2]/div[2]/div/div[1]/div[7]/div[2]/div/div[1]")).click();
	    //driver.findElement(By.id("rblContractorType_0")).click();
	    
	    driver.findElement(By.id("cphBodyContent_btnProceedContractor")).click();
	    Thread.sleep(3000);
	    
	    
	    // ********************************************************************************************* //
	    
	    String sContractorStatusBefore = driver.findElement(By.id("cphBodyContent_lblStatusText")).getText();
	    System.out.println("Contractor Status Before: " + sContractorStatusBefore);
	    
	    String sContractorTypeBefore = driver.findElement(By.id("cphBodyContent_lblContractorType")).getText();
	    System.out.println("Contractor Status Before: " + sContractorTypeBefore);
	    
	    
	    // ********************************************************************************************* //
	    
	    // Populate data in 'Add Contractor' page and then click on <Save> button
	    actionLibrary.AddContractorPage.AddContractor(sContractorName, sContractorSSN, sContractEffectiveDate, sContractExpirationDate, sAddressLine1, sAddressLine2, sCity, sZip, sEmail, sContractorTelephone, sContractorAlternateTelephone, sPocFirstName, sPocLastName, sPocEmail, sPocTelephone, sPocAlternateTelephone);
	    
	    // ************************************************************************************************** //
	    
	    // Click on <Use Address As Entered> button from 'Address Confirmation' pop-up
	    driver.findElement(By.xpath("/html/body/div[1]/form/div[4]/div/div/div/div[2]/div[2]/div/div[1]/div[16]/div/div/div[2]/div/div[1]")).click();
	    driver.findElement(By.id("btnUseEnteredAddress")).click();
	    Thread.sleep(10000);
	    
	    // ************************************************************************************************** //
	    
	    String sContractorStatusAfter = driver.findElement(By.id("cphBodyContent_lblStatusText")).getText();
	    System.out.println("Contractor Status After: " + sContractorStatusAfter);
	    
	    String sContractorTypeAfter = driver.findElement(By.id("lblContractorType")).getText();
	    System.out.println("Contractor Status After: " + sContractorTypeAfter);
	    
	    // ************************************************************************************************** //
	    
	    // Click on <Log Out> button at the top of the page
	    driver.findElement(By.linkText("Log Out")).click();
	  
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
  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
  }

}
