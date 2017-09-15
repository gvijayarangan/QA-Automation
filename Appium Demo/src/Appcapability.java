//creator: Gopinath Vijayarangan
//Project: Appium demo and initial setup.
//This code connects to an emulator (Pixel_Demo) for an app called APIDEMOS
/* Steps to follow
1. Start appium server
2. Provide the *.apk file name in file section. Please also provide the file path
3. The URL http://127.0.0.1:4723/wd/hub is common for all windows machine and please note that 4723 is from Appium server.
*/

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appcapability {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		// file source to prevent hardcoding of file path
		File f = new File("src");
		File fs = new File(f,"ApiDemos-debug.apk");
		
      DesiredCapabilities dc = new DesiredCapabilities();
      System.out.println("inside Appcapability");
      // for setcapability  (capabilityname, value)
      dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_Demo");
      dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
      //AndroidDriver driver = new AndroidDriver(connectiontoserverlink,dc)
      AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
	  return driver;
	}

}
