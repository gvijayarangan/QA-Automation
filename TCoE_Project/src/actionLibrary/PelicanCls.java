package actionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import automationFramework.SelectBrowser;

public class PelicanCls extends SelectBrowser
{
	
	public static void AddNewStaff(String sOrganization) throws Exception
	{
		// Click on <New> button from "Staff Maintenance List/View" page
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ibtnNew")).click();
		
		// In "New Staff" page, select appropriate value from 'Organization' drop-down field
		// Select a staff id from "Staff Id" drop-down list
		// Select a county-zipcode from 'Zip-County' list box and Click on <Add> button
		// Click on <Submit> button
		new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_cbOrganization"))).selectByVisibleText(sOrganization);
		Thread.sleep(1000);
		
		new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_cbStaff"))).selectByIndex(1);
		Thread.sleep(1000);
		
		new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_lstZipCountySource"))).selectByIndex(1);
		Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ibtnAdd")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_ibtnSubmit")).click();
	}
	 

}
