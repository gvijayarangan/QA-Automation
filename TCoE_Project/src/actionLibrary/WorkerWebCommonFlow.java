package actionLibrary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import utility.RandomCharacterGeneration;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.sun.media.jfxmedia.logging.Logger;
import org.apache.log4j.Logger;

import automationFramework.SelectBrowser;




public class WorkerWebCommonFlow extends SelectBrowser
{
	    
	private static Logger Log = Logger.getLogger(WorkerWebCommonFlow.class.getName());
	
	public static void applicationCommonFlow(String sSearchLastName, String sSearchGender, String sParentFirstName, String sParentLastName, String sAddressType, String sAddressLine1, String sAddressLine2, String sCity, String sState, String sZip, String sRfaType, String sContactMethod, String sFilingDate, int iParentSsn, String sParentGender, String sParentDoB, String sParentRace, String sParentEthnicity, String sPool, String sWorker, String sAddressVerification, String sChildFirstName, String sChildLastName, String sChildDoB, String sDobVerifiedBy, int iChildSsn, String sSsnVerifiedBy, String sChildGender, String sChildRace, String sChildEthnicity) throws Exception 
	{
		try 
		{

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			// Click on "Home" -> "Case and Clients"
		    driver.findElement(By.cssSelector("#ctl00_ctl00_ctl00_HtmlHead_Menubar_mnuMain_DXI0_T > div > span")).click();
		    driver.findElement(By.cssSelector("#ctl00_ctl00_ctl00_HtmlHead_Menubar_mnuMain_DXI0i1_T > div > span")).click();
		    
		    // Enter "Last Name" and "Gender" and click <Search> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_NavigationBar_NavigationBar_txtLastName_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_NavigationBar_NavigationBar_txtLastName_I")).sendKeys(sSearchLastName);
		    //driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_NavigationBar_NavigationBar_cbGender_I")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_NavigationBar_NavigationBar_cbGender_I")).sendKeys(sSearchGender);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_NavigationBar_NavigationBar_BtnNameSearch_CD")).click();
		    
		    // Click on "Create New RFA" link
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnCreateNewRFA")).click();
		    
		    // Populate data in 'RFA Information' page (Sections : Information Provider Name and Applicant Household Address )
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_InformationProvider_txtFirstName_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_InformationProvider_txtFirstName_I")).sendKeys(sParentFirstName);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_InformationProvider_txtLastName_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_InformationProvider_txtLastName_I")).sendKeys(sParentLastName);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_cbAddressType_I")).sendKeys(sAddressType);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtAddressLine1_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtAddressLine1_I")).sendKeys(sAddressLine1);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtAddressLine2_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtAddressLine2_I")).sendKeys(sAddressLine2);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtCity_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtCity_I")).sendKeys(sCity);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_cbState_I")).sendKeys(sState);

		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtZipCodeNumber_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_txtZipCodeNumber_I")).sendKeys(sZip);
		    
		    // Click on <Validated Address> button and click on <Use Address As Matched> button in the 'Address Confirmation' pop-up
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvClientRegistration_Address_btnValidateAddress_B")).click();
		    Thread.sleep(10000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/div[2]/table/tbody/tr[1]/td[1]")).click();
		    driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/div[2]/table/tbody/tr[1]/td[1]")).sendKeys(Keys.TAB, Keys.TAB, Keys.SPACE);
		    Thread.sleep(4000);
		    		    
		    // Answer the questions
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_RFA_cbDoesTheInformationProviderLiveIn_I")).sendKeys("Yes");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_RFA_cbIsAlternateAddressIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_RFA_cbIsFoodBenefitsIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_RFA_cbIRefugeeServicesIndicator_I")).sendKeys("No");
		    
		    // Populate data in RFA Details section
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_RFA_cbRFATypeCode_I")).sendKeys(sRfaType);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_RFA_cbRFAContactMethodCode_I")).sendKeys(sContactMethod);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_RFA_dtRFAFilingDate_I")).sendKeys(sFilingDate);
		    
		    // Click on <Next> button 
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_CD")).click();
		    
		    
		    // Populate data in 'Individual Demographics Details ' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_Person_txtFirstName_I")).click();
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_PersonAdditionalAttributes_txtSocialSecurityNumber1_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_PersonAdditionalAttributes_txtSocialSecurityNumber1_I")).sendKeys("1" + iParentSsn);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_PersonAdditionalAttributes_cbGenderCode_I")).sendKeys(sParentGender);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_PersonAdditionalAttributes_dtDateOfBirth1_I")).clear();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_PersonAdditionalAttributes_dtDateOfBirth1_I")).sendKeys(sParentDoB);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_PersonAdditionalAttributes_cbRaceCode_I")).sendKeys(sParentRace);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvClientRegistration_PersonAdditionalAttributes_cbEthnicityCode_I")).sendKeys(sParentEthnicity);
		    
		    // Click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    

		    // Click on <Next> button in 'Individual Clearance Results' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Click on <Next> button in 'Establish Individual' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Click on <Next> button in 'Final Clearance Status' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Click on <Next> button in 'Voter Registration Summary' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(9000);
		       
		    // Populate data in 'Worker Assignment' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_cbPool_I")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_cbPool_I")).sendKeys(sPool, Keys.ENTER);
		    Thread.sleep(5000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_cbWorker_I")).sendKeys(sWorker);
		    
		    // Click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Click on <Next> button in 'Print Request for Assistance' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Click on <Initiate> button in 'Client Registration Completion' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageInitiate_B")).click();
		    
		    
		    // Capture the Case No.
		    String varCaseNumber = driver.findElement(By.name("ctl00$ctl00$ctl00$dxpnlMain$HtmlBody$PageContent$PageBodyContent$PageBodyContent$txtRFACaseNumber")).getAttribute("value");
		    System.out.println("Case No. : " + varCaseNumber);
		    Reporter.log("Case No. : " + varCaseNumber);
		    
		    // Click on <Initiate> button in 'Initiate Interview Options' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageInitiate_B")).click();
		    
		    
		    // Click on <Next> button in 'Case Household Summary' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Populate [Address Verification] in 'Case Household Details' page and then click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_txtFirstName_I")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_pnlCallback_fvInitiateInterview_Address_cbVerificationAddress_I")).sendKeys(sAddressVerification);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Click on [Add New] link in 'Individual Demographics and Alias Summary' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnAddNew")).click();
		    
		    
		    // Populate data in 'Individual Demographics and Alias Details' page and then click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInititateInterview_Person_txtFirstName_I")).sendKeys(sChildFirstName);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInititateInterview_Person_txtLastName_I")).sendKeys(sChildLastName);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_dtDateOfBirth_I")).sendKeys(sChildDoB);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_cbDOBVerifiedBy_I")).sendKeys(sDobVerifiedBy, Keys.TAB);
		    Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_txtSocialSecurityNumber1_I")).sendKeys("1" + iChildSsn);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_txtSSNVerificationCode_I")).sendKeys(sSsnVerifiedBy, Keys.TAB);
		    Thread.sleep(8000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_cbGenderCode_I")).sendKeys(sChildGender);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_cbRaceCode_I")).sendKeys(sChildRace);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_cbEthnicityCode_I")).sendKeys(sChildEthnicity);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Populate data in 'Unestablished Individuals' page and then click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInititateInterview_Person_txtFirstName_I")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_cbDOBVerifiedBy_I")).sendKeys(sDobVerifiedBy);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvInitiateInterview_Entity_txtSSNVerificationCode_I")).sendKeys(sSsnVerifiedBy, Keys.TAB);
		    Thread.sleep(10000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    
		    
		    // Click on <Next> button in 'Individual Clearance Results' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // Click on <Next> button in 'Matched Individual Demographics Summary' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // Click on <Next> button in 'Establish Individual' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    		        
		    // Capture MCI Number both for the Parent and Child and then click on <Next> button in 'Final Clearance Status' page
		    String varParentMciNumber = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[2]/td/table/tbody/tr/td/table[1]/tbody/tr[2]/td[1]")).getAttribute("textContent");
		    String varChildMciNumber = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[2]/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td[1]")).getAttribute("textContent");
		    System.out.println("Parent MCI No. : " + varParentMciNumber);
		    Reporter.log("Parent MCI No. : " + varParentMciNumber);  
		    System.out.println("Child MCI No. : " + varChildMciNumber);
		    Reporter.log("Child MCI No. : " + varChildMciNumber);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // Click on <Next> button in 'Primary Person Assignment' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		}
		
		catch (Exception e)
		{
			throw (e);
			 
		}
	
	}

	
	
}
