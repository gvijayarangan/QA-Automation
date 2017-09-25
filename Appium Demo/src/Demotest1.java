import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demotest1 extends Appcapability{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		
		//id, Xpath, classname, android UI automator
		//xpath -> //tagname[@attribute =‘value’] - >tagname is class name most of times 
		//attribute: needs to be unique.here its id or text
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		//driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementByXPath("//android.widget.TextView[@index='2']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
		//Note difference between element and elements. With plural you cannot use sendKeys 
		driver.findElementByClassName("android.widget.EditText").sendKeys("gopitest");
		//driver.findElementsByClassName("android.widget.Button").get(1).click();
		//Note in above get(1) means 2nd index i.e 0,1  
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();

	}

}
