import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DemoUiAutomator extends Appcapability{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Android UI Automaton --> river.findElementByAndroidUIAutomator("attribute("value")");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click(); // For double quote inside double quote use \ for java to understand
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

	}

}
