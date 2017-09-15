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

import java.io.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import utility.RandomCharacterGeneration;
import utility.CurrentDateAndMonth;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import automationFramework.SelectBrowser;



public class CashBenefitProgram extends SelectBrowser
{
	
	public static void cashBenefitProgram(String sBeginDate, String sLivingType, String sVerifiedBy, String sVerificationDate, String sCitizen, String sCitizenshipVerifiedBy, String sBirthCountry, String sState, String sMaritalStatus, String sSsnCooperation, String sDelawareResidenceIntended, String sLanguageIndicator, String sTanfParticipationRequirement, String sTanfBeginDate, String sParentChildRelationship, String sChildParentRelationship, String sParentFirstName, String sGraduationStatus, String sEnrollmentStatus, String sHighestGradeCompletedParent, String sHighestGradeCompletedChild) throws Exception
	{
		
		try 
		{

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			// In 'Program of Assistance Summary' page, click on the [Edit] image (pencil icon) next to 'Cash' benefit, select "Yes" from 'Request' drop-down field under 'Cash' section and click on <Save> button. 
			driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[4]/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td[6]/img")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor3_I")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor3_I")).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[4]/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td/table/tbody/tr[2]/td/img[1]")).click();
			Thread.sleep(5000);
			
			// Click on <Next> button at the bottom of 'Program of Assistance Summary' page
			driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
			Thread.sleep(3000);
			
			// In 'Program of Assistance Details' page, click on "All" link, then click on <Next> button at the bottom of the page
			driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnAll")).click();
			driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
			Thread.sleep(3000);
			
			// Click on <Next> button in 'Additional Program Details Summary' page
			driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
			Thread.sleep(3000);
			
			// Click on <Next> button in 'Additional Program Details' page
			driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
			Thread.sleep(3000);
			
			// In 'Individual Living Arrangement' page, click on [Edit] icon next to the parent member, populate data and click on <Save> button
		    driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/table[1]/tbody/tr[3]/td[8]/img")).click();
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor2_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor3_I")).sendKeys(sLivingType);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor4_I")).sendKeys(sVerifiedBy);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor5_I")).sendKeys(sVerificationDate);
		    
		    driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td/table/tbody/tr[4]/td/img[1]")).click();
		    Thread.sleep(5000);
		    
		    
		    // In 'Individual Living Arrangement' page, click on [Edit] icon next to the child member, populate data and click on <Save> button
		    driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/table[1]/tbody/tr[4]/td[8]/img")).click();
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor2_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor3_I")).sendKeys(sLivingType);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor4_I")).sendKeys(sVerifiedBy);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_DXEditor5_I")).sendKeys(sVerificationDate);
		    
		    driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/table/tbody/tr[2]/td[3]/table/tbody/tr/td/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/table[1]/tbody/tr[5]/td/table/tbody/tr[4]/td/img[1]")).click();
		    
		    // Click on <Next> button in 'Individual Living Arrangement' page
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(3000);
		    
		    // In 'Additional Individual Demographics Summary' page, click on [Show Details] icon next to the parent member, populate data and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_cell0_5_btnShowDetails_CD")).click();
		    Thread.sleep(3000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_ddeBeginDate_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbUSCitizenNationalIndicator_I")).sendKeys(sCitizen);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbUSCitizenNationalVerificationCode_I")).sendKeys(sCitizenshipVerifiedBy, Keys.TAB);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbBirthCountryCode_I")).sendKeys(sBirthCountry, Keys.TAB);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbBirthStateCode_I")).sendKeys(sState);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbMaritalStatusCode_I")).sendKeys(sMaritalStatus);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbMaritalStatusVerificationCode_I")).sendKeys(sVerifiedBy);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbSSNCooperationIndicator_I")).sendKeys(sSsnCooperation);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbDelawareResidenceIndicator_I")).sendKeys(sDelawareResidenceIntended);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbLanguageIndicator_I")).sendKeys(sLanguageIndicator);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbTANFParticipationIndicator_I")).sendKeys(sTanfParticipationRequirement);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_dtTANFParticipationBeginDate_I")).sendKeys(sTanfBeginDate);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbParoleViolationIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbProbationViolationIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbFugitiveFelonIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbConvictedOfAFelonyForUsingHaving_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbWelfareFraudIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbFBCashDisqualificationIndicator_I")).sendKeys("No");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);  
		    
		    // In 'Additional Individual Demographics Details' page, populate data for child member and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_ddeBeginDate_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbUSCitizenNationalIndicator_I")).sendKeys(sCitizen);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbUSCitizenNationalVerificationCode_I")).sendKeys(sCitizenshipVerifiedBy, Keys.TAB);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbBirthCountryCode_I")).sendKeys(sBirthCountry, Keys.TAB);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbBirthStateCode_I")).sendKeys(sState);

		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbSSNCooperationIndicator_I")).sendKeys(sSsnCooperation);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbDelawareResidenceIndicator_I")).sendKeys(sDelawareResidenceIntended);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbLanguageIndicator_I")).sendKeys(sLanguageIndicator);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbParoleViolationIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbProbationViolationIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbFugitiveFelonIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbConvictedOfAFelonyForUsingHaving_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbWelfareFraudIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonDemographics_cbFBCashDisqualificationIndicator_I")).sendKeys("No");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);  
		    
		    // In 'Household Relationships Summary' page, click on [Show Details] icon, populate data for parent member and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_cell0_3_btnShowDetails_CD")).click();
		    Thread.sleep(4000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonRelation_dtBeginDate_I")).sendKeys(sBeginDate);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_rpTechnical_PersonRelation_ctl00_cbRelationName_I")).sendKeys(sParentChildRelationship);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_rpTechnical_PersonRelation_ctl00_cbVerifiedBy_I")).sendKeys(sVerifiedBy);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone1")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone2")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone3")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone4")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone5")).click();
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Household Relationships Details' page, populate data for child member and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_PersonRelation_dtBeginDate_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_rpTechnical_PersonRelation_ctl00_cbRelationName_I")).sendKeys(sChildParentRelationship);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_rpTechnical_PersonRelation_ctl00_cbVerifiedBy_I")).sendKeys(sVerifiedBy);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone1")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone2")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone3")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone4")).click();
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_btnNone5")).click();
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Individual Benefits Received Summary' page, click on [Show Details] icon, populate data for parent member and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_cell0_7_btnShowDetails_CD")).click();
		    Thread.sleep(4000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_ddeBeginDate_I")).sendKeys(sBeginDate);
		    Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_cbRcvCashOtherStateIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_cbFosterCareOrAdoptionIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_cbExploreOtherBenefitsCode_I")).sendKeys("Yes");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Individual Benefits Received Details' page, populate data for child member and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_ddeBeginDate_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_cbRcvCashOtherStateIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_cbFosterCareOrAdoptionIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_IndividualBenefits_cbExploreOtherBenefitsCode_I")).sendKeys("Yes");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(4000);
		    
		    // In 'School Enrollment Summary' page, click on [Show Details] icon, populate data for parent member and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_gvASPxGridView_cell0_4_btnViewDetails_CD")).click();
		    Thread.sleep(3000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_ddeBeginDate_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbHighSchoolGraduationStatusCode_I")).sendKeys(sGraduationStatus, Keys.TAB);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbEnrollmentStatus_I")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbEnrollmentStatus_I")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);			// sendKeys(sEnrollmentStatus, Keys.TAB);
		    Thread.sleep(5000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbIndividualHighestGradeCode_I")).sendKeys(sHighestGradeCompletedParent);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'School Enrollment Summary' page, populate data for child member and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_ddeBeginDate_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbHighSchoolGraduationStatusCode_I")).sendKeys(sGraduationStatus, Keys.TAB);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbEnrollmentStatus_I")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbEnrollmentStatus_I")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);			// sendKeys(sEnrollmentStatus, Keys.TAB);
		    Thread.sleep(5000);
		    //driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvTechnical_SchoolEnrollment_cbIndividualHighestGradeCode_I")).sendKeys(sHighestGradeCompletedChild);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Technical Questions' page, populate data and then click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsTechnical_HouseholdGeneralInfo_cbIsAnyoneInYourHouseholdPregnant_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsTechnical_HouseholdGeneralInfo_cbDoesAnyoneInTheHouseholdReceiveS_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsTechnical_HouseholdGeneralInfo_cbIsAnyoneInYourHouseholdNoLongerA_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsTechnical_HouseholdGeneralInfo_cbIsAnyoneInYourHouseholdApplyingF_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsTechnical_HouseholdGeneralInfo_cbDoesAnyoneInYourHouseholdWhoIsAp_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsTechnical_HouseholdGeneralInfo_cbIsAnyoneInYourHouseholdApplyingF1_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsTechnical_HouseholdGeneralInfo_cbHasAnyoneInYourHouseholdBeenRefe_I")).sendKeys("No");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Benefit Cap' screen, click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Absent Parent Demographics Details' page, populate data and then click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvAbsentParent_AbsentParentInfo_cbIsUnknownIndicator_I")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvAbsentParent_AbsentParentInfo_cbIsUnknownIndicator_I")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.TAB);
		    Thread.sleep(2000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Absent Parent General Summary' page, click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Absent Parent General Details' page, click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Match Absent Parent With Children' page, populate data and then click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_cbAbsentParent1_I")).sendKeys("UNKNOWN", Keys.TAB);
		    Thread.sleep(4000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Absent Parent Court Order Summary' page, click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Absent Parent Employment Summary' page, click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Absent Parent Cooperation Child Support Summary' page, click on <Next> button, populate data and then click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvAbsentParent_AbsentParentChildSupportFailureReason_ddeBeginDate_I")).sendKeys(sBeginDate);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvAbsentParent_AbsentParentChildSupportFailureReason_cbName_I")).sendKeys(sParentFirstName);
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvAbsentParent_AbsentParentChildSupportFailureReason_cbCooperation_I")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvAbsentParent_AbsentParentChildSupportFailureReason_cbCooperation_I")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.TAB);
		    Thread.sleep(4000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Resource Questions' page, Populate data for the question and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasVehicleResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasLiquidResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasRealPropertyResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasPersonalPropertyResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasLifeInsuranceResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasBurialResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasTransferredResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasAnnuityResourceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsResource_HouseholdGeneralInfo_cbHasTrustResourceIndicator_I")).sendKeys("No");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Income Questions' page, Populate data for the question and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsIncome_HouseholdGeneralInfo_cbOnStrikeIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsIncome_HouseholdGeneralInfo_cbHasRefusedEmploymentIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsIncome_HouseholdGeneralInfo_cbDoesAnyoneInYourHouseholdReceive_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsIncome_HouseholdGeneralInfo_cbIsAnyoneInYourHouseholdCurrently_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsIncome_HouseholdGeneralInfo_cbReceiveUnearnedIncomeIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvdsIncome_HouseholdGeneralInfo_cbHasLumpSumResourceIndicator_I")).sendKeys("No");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Expense Questions' page, Populate data for the question and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbDoesAnyoneInTheHouseholdReceiveE_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbDoesAnyoneInYourHouseholdPayAnyo_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbDoesAnyoneInYourHouseholdHaveAny_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbHasHealthCareIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbIsDisabledWithWorkExpenseIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbIsAnyoneInYourHouseholdEntitledT_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbDoesAnyoneInYourHouseholdPayForS_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_HouseholdGeneralInfo_cbDoesAnyoneInYourHouseholdMakeASu_I")).sendKeys("No");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'Shelter & Utility Questions' page, Populate data for the question and click on <Next> button
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_ShelterUtilityQuestions_cbHasUtilityCostIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_ShelterUtilityQuestions_cbLiveInPublicHousingIndicator_I")).sendKeys("No", Keys.TAB);
		    Thread.sleep(5000);
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_ShelterUtilityQuestions_cbHasShelterCostIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_ShelterUtilityQuestions_cbElectStandardUtilityAllowanceIndicator_I")).sendKeys("No");
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_PageContent_PageBodyContent_PageBodyContent_fvExpanse_ShelterUtilityQuestions_cbReceiveLIHEAPPaymentIndicator_I")).sendKeys("No");
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(2000);
		    
		    // In 'SFU Composition Determination' page, click on <Run SFU> button and then click on <Next> button twice
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageRunSFU_B")).click();
		    Thread.sleep(5000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(4000);
		    
		    driver.findElement(By.id("ctl00_ctl00_ctl00_dxpnlMain_HtmlBody_BodyActionBar_btnPageNext_B")).click();
		    Thread.sleep(4000);
			
		}
		
		catch (Exception e)
		{
			throw (e);
			 
		}

	}

}
