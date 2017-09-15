package com.tcoe.tests;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import errorHandling.ErrorHandler;
import automationFramework.SelectBrowser;
import automationFramework.ExcelUtils;

import objectRepository.*;


public class Test1  extends SelectBrowser{
	private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
  
  @BeforeMethod
  
	  public void setUp() throws Exception {
			automationFramework.SelectBrowser.WebBrowser();
			baseUrl = "http://www.ebay.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
  

  @Test
  public void ebay() throws Exception {
	  
	  // Initialize the objects
	  ObjectMap homeMap = new ObjectMap("maps\\home.repository");
	  
	  try
	  {
			
		// Launching the Application URL in web-browser and maximizing the browser
	    driver.get(baseUrl);
	    Thread.sleep(2000);
	    
	    driver.manage().window().maximize();

	    
	    // Click on Help & Contact link
	    driver.findElement(homeMap.getLocator("LINK_Help&Contact")).click();
	   
	    Thread.sleep(2000);
	
	  }
	  
	  
	  catch(Exception ex)
	  {
		  System.out.println(ex);
		  ErrorHandler.HandleException("", "", "", "", "ERRORED", new Exception("THIS IS A CUSTOM ERROR"), null, "", driver, "C:\\Temp", "googleScreen", ".jpg");
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
