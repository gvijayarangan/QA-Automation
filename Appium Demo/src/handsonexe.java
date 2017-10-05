import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class handsonexe extends Appcapability{

	public static void main(String[] args) throws MalformedURLException,InterruptedException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction t = new TouchAction(driver);
		//Android UI Automaton --> river.findElementByAndroidUIAutomator("attribute(\"value\")");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		//driver.findElementByAndroidUIAutomator("text(\"Views\")").click(); // For double quote inside double quote use \ for java to understand
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lists\"));");
		driver.findElementByAndroidUIAutomator("text(\"Lists\")").click();
		System.out.println(driver.getOrientation());
		System.out.println(driver.getContext());
		driver.findElementByAndroidUIAutomator("text(\"09. Array (Overlay)\")").click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).flingToBeginning();");
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Expandable Lists\"));");
		//driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
//to use property(clickable is a property) instead of attribute(text is attribute) we need to use new
// driver.findElementByAndroidUIAutomator("new UiSelector().property(value)").size();		
//int a = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
	//System.out.println(a);
	//Tap
	//t.tap(driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']")).perform();
	//driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
	//t.press(driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"))).waitAction(Duration.ofSeconds(3000)).release().perform();
	//t.press(driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"))).waitAction(Duration.ofSeconds(3000)).moveTo(driver.findElementByXPath("//")).release().perform();
	}

}
