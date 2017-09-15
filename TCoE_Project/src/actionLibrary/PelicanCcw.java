package actionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import automationFramework.SelectBrowser;

public class PelicanCcw extends SelectBrowser
{
	
	public static void ClientSearchAndUpdateHouseholdInfo(String sCounty, String sAddress, String sWorkPhone, String sMobilePhone) throws Exception
	{
		// In 'Subsidy Client Search' page, select a county from "County" dropdown and then click on <Search> button
		new Select(driver.findElement(By.id("refCounty_ddlDropDownList"))).selectByVisibleText(sCounty);
	    driver.findElement(By.id("imgSearch")).click();
		Thread.sleep(1000);
		
		// Click on the first Client Name
		driver.findElement(By.id("dgClientSearch_btnIndivNumber_0")).click();
		
		// In the 'Case Summary' page, select "Household Information" from the drop-down at the right side of the page and click on <GO> button
		new Select(driver.findElement(By.id("ddGoTo"))).selectByVisibleText("Household Information");
	    driver.findElement(By.id("imgBtnGoTo")).click();
	    
	    // Update few fields in 'Household Information Detail' page and then click on <Save> button
	    driver.findElement(By.id("txtAddressLine1_txtTextbox")).clear();
	    driver.findElement(By.id("txtAddressLine1_txtTextbox")).sendKeys(sAddress);
	    
	    driver.findElement(By.id("phnWorkPhone_txtPhoneNumber")).clear();
	    driver.findElement(By.id("phnWorkPhone_txtPhoneNumber")).sendKeys(sWorkPhone);
	    
	    driver.findElement(By.id("phnMobilePhone_txtPhoneNumber")).clear();
	    driver.findElement(By.id("phnMobilePhone_txtPhoneNumber")).sendKeys(sMobilePhone);
	    
	    driver.findElement(By.id("btnCommit_btnSave")).click();

	}
	 

}
