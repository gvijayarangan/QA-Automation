package utility;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.VelocityContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.uncommons.reportng.HTMLReporter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Listener extends HTMLReporter implements ITestListener, IInvokedMethodListener {
	public static final String DRIVER_ATTRIBUTE = "driver";
    private static final String UTILS_KEY = "utils";

    private static final ReportUtils REPORT_UTILS = new ReportUtils();

    protected VelocityContext createContext() {
        final VelocityContext context = super.createContext();
        context.put(UTILS_KEY, REPORT_UTILS);
        return context;
    }

    private void createScreenshot(final ITestResult result, final WebDriver driver) {
        final DateFormat timeFormat = new SimpleDateFormat("MM.dd.yyyy HH-mm-ss");
        final String fileName = result.getMethod().getMethodName() + "_" + timeFormat.format(new Date());

        try {
            File scrFile;

            if (driver.getClass().equals(RemoteWebDriver.class)) {
                scrFile = ((TakesScreenshot) new Augmenter().augment(driver))
                        .getScreenshotAs(OutputType.FILE);
            } else {
                scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            }

            String outputDir = result.getTestContext().getOutputDirectory();
            outputDir = outputDir.substring(0, outputDir.lastIndexOf('\\')) + "\\html";

            final File saved = new File(outputDir, fileName + ".png");
            FileUtils.copyFile(scrFile, saved);

            result.setAttribute("screenshot", saved.getName());
        } catch (IOException e) {
            result.setAttribute("reportGeneratingException", e);
        }

        result.setAttribute("screenshotURL", driver.getCurrentUrl());
        result.removeAttribute(DRIVER_ATTRIBUTE);
    }

    @Override
    public void onTestFailure(final ITestResult result) {
        final WebDriver driver = (WebDriver) result.getTestContext().getAttribute(DRIVER_ATTRIBUTE);
        printTestResults(result);
        if (driver != null) {
            createScreenshot(result, driver);
            Reporter.log("Test failed " + result.getName(), true);
            driver.quit();
        }
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        final WebDriver driver = (WebDriver) result.getTestContext().getAttribute(DRIVER_ATTRIBUTE);
        printTestResults(result);
        if (driver != null) {
            createScreenshot(result, driver);
            driver.quit();
        }
    }

   

	public void onFinish(ITestContext arg0) {
		Reporter.log("Completed executing test " + arg0.getName(), true);
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("About to begin executing test " + arg0.getName(), true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

//	public void onTestFailure(ITestResult arg0) {
//		printTestResults(arg0);
//	}

	private void printTestResults(ITestResult result) {
		Reporter.log("TestName = " + result.getTestName(), true);
		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
		if (result.getParameters().length != 0) {
			String params = null;
			for (Object parameter : result.getParameters()) {
				params += parameter.toString() + ",";
			}
			Reporter.log("Test Method had the following parameters : " + params, true);
		}
		String status = null;
		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			status = "Pass";
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
		}
		Reporter.log("Test Status: " + status, true);
	}

	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void onTestStart(ITestResult arg0) {
	}

//	public void onTestSuccess(ITestResult arg0) {
//		printTestResults(arg0);
//	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "Completed executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);

	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "About to begin executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);
	}

	private String returnMethodName(ITestNGMethod method) {
		return method.getRealClass().getSimpleName() + "." + method.getMethodName();
	}

}


