package com.tcoe.tests;


import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import configuration.Constant;
import errorHandling.ErrorHandler;
import automationFramework.ExcelUtils;
import automationFramework.SelectBrowser;
import utility.RandomCharacterGeneration;
import utility.CurrentDateAndMonth;
import utility.PasswordDecrypter;
import actionLibrary.WorkerWebCommonFlow; 



public class CaseCreationWithCashBenefitProgram extends SelectBrowser
{
  
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
  public void setUp(final ITestContext context) throws Exception 
  {
	  automationFramework.SelectBrowser.WebBrowser();
      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testDelaware() throws Exception {
	  
	try
	{
	  //Opening the Excel file and Reading Data from Excel
//		FileInputStream file = new FileInputStream(new File("C://Selenium//workspace//TCoE_Project//src//testData//TestData_Delaware.xlsx"));   
//		XSSFWorkbook workbook = new XSSFWorkbook(file);	 
//		XSSFSheet worksheet = workbook.getSheet("CashBenefitProgram");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "CashBenefitProgram");
		
	// Variable Declaration (Assigning values of test data from Excel File to variables)
	String sUserName = ExcelUtils.getCellData(2, 2);
	//String sPassword = utility.PasswordDecrypter.PasswordDecrypt(ExcelUtils.getCellData(2, 3));     
	String sPassword = ExcelUtils.getCellData(2, 3);
	
	String sSearchLastName = ExcelUtils.getCellData(2, 4);
	String sSearchGender = ExcelUtils.getCellData(2, 5);
	
	String sAddressType = ExcelUtils.getCellData(2, 6);
	String sAddressLine1 = ExcelUtils.getCellData(2, 7);
	String sAddressLine2 = ExcelUtils.getCellData(2, 8);
	String sCity = ExcelUtils.getCellData(2, 9);
	String sState = ExcelUtils.getCellData(2, 10);
	String sZip = ExcelUtils.getCellData(2, 11);
	String sRfaType = ExcelUtils.getCellData(2, 12);
	String sFilingDate = CurrentDateAndMonth.CurrentDate();
	String sContactMethod = ExcelUtils.getCellData(2, 13);		
	
	String sParentGender = ExcelUtils.getCellData(2, 14);
	String sParentDoB = ExcelUtils.getCellData(2, 15);
	String sParentRace = ExcelUtils.getCellData(2, 16);
	String sParentEthnicity = ExcelUtils.getCellData(2, 17);
	
	String sPool = ExcelUtils.getCellData(2, 18);
	String sWorker = ExcelUtils.getCellData(2, 19);

	String sAddressVerification = ExcelUtils.getCellData(2, 20);

	String sChildDoB = ExcelUtils.getCellData(2, 21);
	String sDobVerifiedBy = ExcelUtils.getCellData(2, 22);
	
	String sSsnVerifiedBy = ExcelUtils.getCellData(2, 23);
	String sChildGender = ExcelUtils.getCellData(2, 24);
	String sChildRace = ExcelUtils.getCellData(2, 25);
	String sChildEthnicity = ExcelUtils.getCellData(2, 26);
	
	String sBeginDate = CurrentDateAndMonth.CurrentMonth();
	String sLivingType = ExcelUtils.getCellData(2, 27);
	String sVerifiedBy = ExcelUtils.getCellData(2, 28);
	String sVerificationDate = CurrentDateAndMonth.CurrentDate();

	String sParentChildRelationship = ExcelUtils.getCellData(2, 29);
	String sChildParentRelationship = ExcelUtils.getCellData(2, 30);
	
	String sCitizen =  ExcelUtils.getCellData(2, 31);
	String sCitizenshipVerifiedBy = ExcelUtils.getCellData(2, 32);
	String sBirthCountry = ExcelUtils.getCellData(2, 33);
	String sMaritalStatus = ExcelUtils.getCellData(2, 34);
	String sSsnCooperation = ExcelUtils.getCellData(2, 35);
	String sDelawareResidenceIntended = ExcelUtils.getCellData(2, 36);
	String sLanguageIndicator = ExcelUtils.getCellData(2, 37);
	String sTanfParticipationRequirement = ExcelUtils.getCellData(2, 38);
	String sTanfBeginDate = CurrentDateAndMonth.CurrentDate();
	
	String sGraduationStatus = ExcelUtils.getCellData(2, 39);
	String sEnrollmentStatus = ExcelUtils.getCellData(2, 40);
	String sHighestGradeCompletedParent = ExcelUtils.getCellData(2, 41);
	String sHighestGradeCompletedChild = ExcelUtils.getCellData(2, 42);
	

	
	
	// ************************************************************************************************************ //
	
	// Launching the Application URL in web-browser and maximizing the browser  
    //driver.get(baseUrl + "DSS_Workerweb_INT/Default.aspx ");
	driver.get("http://devcr.dhss.state.de.us/DSS_Workerweb_INTCR/Default.aspx");
    driver.manage().window().maximize();
    
    // Login to the application
    driver.findElement(By.id("cphBodyContent_txtUserName")).clear();
    driver.findElement(By.id("cphBodyContent_txtUserName")).sendKeys(sUserName);
    driver.findElement(By.id("cphBodyContent_txtPassword")).clear();
    driver.findElement(By.id("cphBodyContent_txtPassword")).sendKeys(sPassword);
    
    driver.findElement(By.id("cphBodyContent_ddlEnvslist")).sendKeys("Change Integration");
    
    driver.findElement(By.id("cphBodyContent_btnSubmit")).click();
    
    for (int i=0; i<1; i++)
	{
    	
    // Variable declarations for random characters and numbers
    String sParentFirstName = RandomCharacterGeneration.randomString();
    String sParentLastName = RandomCharacterGeneration.randomString();
    
    int iParentSsn = RandomCharacterGeneration.randomNumber();
    
	String sChildFirstName = RandomCharacterGeneration.randomString();
	String sChildLastName = RandomCharacterGeneration.randomString();
	
	int iChildSsn = RandomCharacterGeneration.randomNumber();
	
	
    // Call the function "applicationCommonFlow" to perform operations from 'Home' page through 'Primary Person Assignment' page	
	actionLibrary.WorkerWebCommonFlow.applicationCommonFlow(sSearchLastName, sSearchGender, sParentFirstName, sParentLastName, sAddressType, sAddressLine1, sAddressLine2, sCity, sState, sZip, sRfaType, sContactMethod, sFilingDate, iParentSsn, sParentGender, sParentDoB, sParentRace, sParentEthnicity, sPool, sWorker, sAddressVerification, sChildFirstName, sChildLastName, sChildDoB, sDobVerifiedBy, iChildSsn, sSsnVerifiedBy, sChildGender, sChildRace, sChildEthnicity);
    
    // Call the function "cashBenefitProgram" to perform operations on pages specific to Cash Benefit
	//actionLibrary.CashBenefitProgram.cashBen	efitProgram(sBeginDate, sLivingType, sVerifiedBy, sVerificationDate, sCitizen, sCitizenshipVerifiedBy, sBirthCountry, sState, sMaritalStatus, sSsnCooperation, sDelawareResidenceIntended, sLanguageIndicator, sTanfParticipationRequirement, sTanfBeginDate, sParentChildRelationship, sChildParentRelationship, sGraduationStatus, sEnrollmentStatus, sHighestGradeCompletedParent, sHighestGradeCompletedChild, sParentFirstName);
    

    System.out.println("***********************************************");
    
	}
    
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
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
  
}

  