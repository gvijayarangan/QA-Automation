package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;

import errorHandling.ErrorHandler;
import errorHandling.ErrorHandler.LogTypes;

public class Utils {
	public static WebDriver driver = null;

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			ErrorHandler.WriteToLog(LogTypes.Error, "", "", "", "",
					"Class Utils | Method getTestCaseName |", e, null);
			throw (e);
		}
	}

	public static WebDriver OpenBrowser(String browserName, String URL, ITestContext context ) {

		try {

			if (browserName.equals("Mozilla")) {
				driver = new FirefoxDriver();
				context.setAttribute(Listener.DRIVER_ATTRIBUTE, driver);
				ErrorHandler.WriteToLog(LogTypes.Info,
						"New driver instantiated");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				ErrorHandler.WriteToLog(LogTypes.Info,
						"Implicit wait applied on the driver for 10 seconds");
				driver.get(URL);
				ErrorHandler.WriteToLog(LogTypes.Info,
						"Web application launched successfully");
			}
		} catch (Exception e) {
			ErrorHandler.WriteToLog(LogTypes.Error, "", "", "", "",
					"Class Utils | Method OpenBrowser |", e, null);
		}

		return driver;
	}

}
