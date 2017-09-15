/**
 * 
 */
package errorHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 *
 */
public class ErrorHandler {

	/**
	 * Used to specify the type of message being logged.
	 *
	 */
	public enum LogTypes {
		Error, FatalProblem, Info, Debug, Warn
	}

	// private Logger Log = null; // Used to log the messages
	private static Logger Log = null;
	static final String LOG_PROPERTIES_FILE = "lib/Log4J.properties";

	/**
	 * 
	 * @param configFilePath
	 */
	private void InitializeCommonObjects(String configFilePath) {

		try {
			System.out.println();
			Log = Logger.getLogger(ErrorHandler.class.getName());
			Properties logProperties = new Properties();
			try {
				if (StringUtils.isNotEmpty(configFilePath))
					logProperties.load(new FileInputStream(configFilePath));
				else
					logProperties
							.load(new FileInputStream(LOG_PROPERTIES_FILE));

				PropertyConfigurator.configure(logProperties);

			} catch (IOException e) {
				throw new RuntimeException("Unable to load logging property "
						+ LOG_PROPERTIES_FILE);
			}

		} catch (Exception ex) {

		}

	}

	public ErrorHandler() {

		InitializeCommonObjects("");

	}

	/**
	 * 
	 * @param configFilePath
	 */
	public ErrorHandler(String configFilePath) {
		try {
			// Initialize the Log4j options
			InitializeCommonObjects(configFilePath);

		} catch (Exception ex) {
		}
	}

	/**
	 * 
	 * @param driver
	 * @param screenShotPath
	 * @param screenShotName
	 * @param screenShotExtension
	 */
	public void captureScreenShot(WebDriver driver, String screenShotPath,
			String screenShotName, String screenShotExtension) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(screenShotPath + "\\"
					+ screenShotName + "." + screenShotExtension));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param TypeOfMessage
	 *            : The type of message being logged.
	 * @param ObjectName
	 *            : The object that requested this message be logged.
	 * @param MethodName
	 *            : The method of ObjectName that requested this message be
	 *            logged.
	 * @param Message
	 *            : The message to log (optional; either Message or Error are
	 *            required).
	 * @param Error
	 *            : The Exception to log (optional; either Message or Error are
	 *            required).
	 * @return A Boolean indicating if the message was logged.
	 */
	public boolean LogMessage(LogTypes TypeOfMessage, String ObjectName,
			String testCaseName, String testStepName, String Message,
			Exception Error) {
		boolean ret_bMsgLogged = false;
		// String newLine = "\n";
		StringBuilder sbMessage = null;
		boolean bHasSourceInfo = false;

		try {

			// Make sure a message or exception are provided, one of the 2 are
			// required to log
			if ((StringUtils.isNotEmpty(Message) && StringUtils
					.isNotBlank(Message)) || (Error != null)) {
				bHasSourceInfo = ((StringUtils.isNotEmpty(ObjectName) && StringUtils
						.isNotBlank(ObjectName)) && (StringUtils
						.isNotEmpty(testCaseName) && StringUtils
						.isNotBlank(testStepName)));
				sbMessage = new StringBuilder();

				// Format the message to log
				if (StringUtils.isNotEmpty(ObjectName))
					sbMessage.append(ObjectName);

				if ((StringUtils.isNotEmpty(Message) && StringUtils
						.isNotBlank(Message))) {
					if (bHasSourceInfo)
						sbMessage.append(":  ");

					sbMessage.append(Message);
				}
				if (StringUtils.isNotEmpty(testCaseName)) {
					// sbMessage.append("TEST CASE :  ");
					// sbMessage.append(testCaseName).append("\n");;
					// sbMessage.append(newLine);
					MDC.put("TestCase", "TEST CASE : " + testCaseName);

				}
				if (StringUtils.isNotEmpty(testStepName)) {
					// sbMessage.append("TEST STEP :  ");
					// sbMessage.append(testStepName);
					// sbMessage.append(newLine);
					MDC.put("TestStep", "TEST STEP : " + testStepName);
				}
				if (Error != null) {
					sbMessage.append(StringUtils.isNotEmpty(Message) ? "\t"
							: " - ");
					sbMessage.append("Error:  ");
					sbMessage.append(Error.getMessage());
					// sbMessage.append(newLine);
					// sbMessage.append("Stack trace:");
					// sbMessage.append(Error.getStackTrace());
					MDC.put("StackTrace",
							"StackTrace : " + Error.getStackTrace());
				}

				// Check if the current type of message logging is enabled and
				// then log it if enabled
				switch (TypeOfMessage) {
				case FatalProblem:
					if (Log.isEnabledFor(Level.FATAL)) {
						Log.fatal(sbMessage.toString());
						ret_bMsgLogged = true;
					}

					break;

				case Error:
					if (Log.isEnabledFor(Level.ERROR)) {
						Log.error(sbMessage.toString());
						ret_bMsgLogged = true;
					}

					break;

				case Warn:
					if (Log.isEnabledFor(Level.WARN)) {
						Log.warn(sbMessage.toString());
						ret_bMsgLogged = true;
					}

					break;

				// These are merged since most people use Info and Debug
				// interchangeably
				case Info:
				case Debug:
					if ((TypeOfMessage == LogTypes.Debug)
							&& (Log.isDebugEnabled())) {
						Log.debug(sbMessage.toString());
						ret_bMsgLogged = true;
					} else if (Log.isInfoEnabled()) {
						Log.info(sbMessage.toString());
						ret_bMsgLogged = true;
					}

					break;

				default:
					ret_bMsgLogged = true;

					if (Log.isInfoEnabled())
						Log.info(sbMessage.toString());
					else if (Log.isDebugEnabled())
						Log.debug(sbMessage.toString());
					else if (Log.isEnabledFor(Level.WARN))
						Log.warn(sbMessage.toString());
					else if (Log.isEnabledFor(Level.ERROR))
						Log.error(sbMessage.toString());
					else if (Log.isEnabledFor(Level.FATAL))
						Log.fatal(sbMessage.toString());
					else
						ret_bMsgLogged = false;

					break;
				}
			}
		} catch (Exception ex) {
			MDC.clear();
			ret_bMsgLogged = false;

		}

		return ret_bMsgLogged;
	}

	/**
	 * 
	 * @param client
	 * @param testCaseName
	 * @param testStepName
	 * @param objectName
	 * @param details
	 * @param error
	 * @param callingClass
	 * @param configFilePath
	 * @param driver
	 * @param screenShotPath
	 * @param screenShotName
	 * @param screenShotExtension
	 */
	public static void HandleException(String client, String testCaseName,
			String testStepName, String objectName, String details,
			Exception error, Object callingClass, String configFilePath,
			WebDriver driver, String screenShotPath, String screenShotName,
			String screenShotExtension) {
		// boolean ret_bExceptionLogged = false;

		ErrorHandler errHandler = null;

		try {
			errHandler = new ErrorHandler();

			errHandler.LogMessage(LogTypes.Error, objectName, testCaseName,
					testStepName, details, error);
			errHandler.captureScreenShot(driver, screenShotPath,
					screenShotName, screenShotExtension);
		} catch (Exception ex) {
		} finally {
			// Clean up
			if (errHandler != null) {
				// errHandler.Dispose();
				errHandler = null;
			}
		}

		// return ret_bExceptionLogged;
	}

	/**
	 * 
	 * @param client
	 * @param testCaseName
	 * @param testStepName
	 * @param objectName
	 * @param details
	 * @param error
	 * @param callingClass
	 * @return
	 */
	public static boolean WriteToLog(LogTypes logType, String client,
			String testCaseName, String testStepName, String objectName,
			String details, Exception error, Object callingClass) {
		boolean ret_bMsgLogged = false;

		ErrorHandler errHandler = null;

		try {
			errHandler = new ErrorHandler();
			ret_bMsgLogged = errHandler.LogMessage(logType, objectName,
					testCaseName, testStepName, details, error);
		} catch (Exception ex) {
		} finally {
			// Clean up
			if (errHandler != null) {
				// /errHandler.Dispose();
				errHandler = null;
			}
		}

		return ret_bMsgLogged;
	}

	public static boolean WriteToLog(LogTypes logType, String details) {
		boolean ret_bMsgLogged = false;

		ErrorHandler errHandler = null;

		try {
			errHandler = new ErrorHandler();
			ret_bMsgLogged = errHandler.LogMessage(logType, "", "", "",
					details, null);
		} catch (Exception ex) {
		} finally {
			// Clean up
			if (errHandler != null) {
				// /errHandler.Dispose();
				errHandler = null;
			}
		}

		return ret_bMsgLogged;
	}
}
