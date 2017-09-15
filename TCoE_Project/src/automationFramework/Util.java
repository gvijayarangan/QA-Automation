package automationFramework;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class Util extends SelectBrowser {

	public static final String folderScreenShoots = System.getProperty("user.dir") + "\\Smoketest-screenshots\\ChangeReporting\\";
	
	public static Properties OR = null;
	
	public static Properties config =null;
	
	static boolean local;

	

	public static void sleep(int number) {
		try {

			Thread.sleep(number);
			System.err.println("sleep done!: " + number);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void cleanDirectory(String folderScreenShoots) {

		try {
			FileUtils.cleanDirectory(new File(folderScreenShoots));

		} catch (Exception e) {
			System.err.println("Error to clean directory " + folderScreenShoots
					+ e.getMessage());
		}

	}

	public static void clickElement(String elementToClick) {
		try {
			driver.findElement(By.xpath(elementToClick)).click();
			System.out.println(".............................................."
					+ elementToClick + " clicked");
		} catch (Exception e) {
			System.err
					.println("\nElement does not exist or is not currently visible: "
							+ elementToClick);

		}

	}

	public static void clickElementByIdName(String elementToClick) {

		try {
			driver.findElement(By.id(elementToClick)).click();
			System.out.println(".............................................."
					+ elementToClick + " clicked");
		} catch (Exception e) {
			System.err
					.println("\nElement does not exist or is not currently visible: "
							+ elementToClick);

		}

	}
	
	public static WebElement getObject(String xpathKey){
		
		try{
			
			return driver.findElement(By.xpath(OR.getProperty(xpathKey)));
			
		}
		catch(Throwable t){
			System.err.println("Error came"+ t.getLocalizedMessage());
			return null;
		}
		
		
	}

	public static void clickElementByProperty(String elementToClick) {

		try {
			getObject(elementToClick).click();
		} catch (Exception e) {
			System.err.println("Something wrong with " + elementToClick + " "
					+ e.getLocalizedMessage());

		}

	}

	public static int selectLastElementFromArray(String elementName) {

		// String elementToClick = ".//*[@id='" + element + "']/a";
		int element = 0;
		int count = 0;
		try {
			// Thread.sleep(1000);
			java.util.List<WebElement> checkbox = driver.findElements(By
					.name(elementName));

			if (checkbox != null && checkbox.size() > 0) {

				synchronized (checkbox) {
					element = checkbox.size();
					checkbox.get(element - 1).click();
					System.out.println("Last element from " + elementName
							+ " selected, position: " + (element - 1));
					// Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			System.err.println(e + " " + elementName);
		}
		return element;

	}

	public static int sendTextLastElementFromArray(String elementName, int index,
			String value) {

		// String elementToClick = ".//*[@id='" + element + "']/a";
		int element = 0;
		try {
			java.util.List<WebElement> checkbox = driver.findElements(By
					.name(elementName));

			if (checkbox != null) {
				element = checkbox.size() - 1;
				checkbox.get(element).clear();
				checkbox.get(element).sendKeys(value);
				System.err.println("Last element from " + elementName
						+ " setted ");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage() + " " + elementName);
		}
		return element;

	}

	public static boolean existsElementByXpath(String xpath) {
	    try {
	        driver.findElement(By.xpath(xpath));
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
	
	public static void sendText(String element, String text) {
		try {
			if (existsElementByXpath(element)) {
				driver.findElement(By.xpath(element)).clear();
				driver.findElement(By.xpath(element)).sendKeys(text);

			}
		} catch (Exception e) {
			System.err.println("Error setting text :" + element + ": value"
					+ text);
		}
	}

	public static void sendTextByProperty(String element, String text) {
		try {
			getObject(element).clear();
			getObject(element).sendKeys(text);
		} catch (Exception e) {
			System.err.println("Error setting text :" + element + ": value"
					+ text);
		}
	}

	public static void homePageLocalLogin(String username, String password,
			boolean local) {

		if (local) {
			local = local;
			driver.get("http://localhost:7001/HBEWeb/TestLogin.action");
			sendText(".//*[@id='TestLogin_theUserName']", username);
			clickElement(".//*[@id='INDIVIDUAL']");
			clickElement(".//*[@id='TestLogin_doTestLogin']");

			completeApp();
		} else {
			clickElement(".//*[@id='homepageModal']/div[2]/div[2]/div/div/a");
			sendText(".//*[@id='username']", username);
			sendText(".//*[@id='password']", password);
			clickElement(".//*[@id='Annon_DisplayHomePage_0']");

			completeApp();
			// clickElement(".//*[@id='accounthome']/div/div[2]/ul/li[2]/a");
		}

	}

	public static void devLogin(String username) {

		// driver.get("http://localhost:7001/HBEWeb/TestLogin.action");
		sendText(".//*[@id='username']", username);
		sendText(".//*[@id='password']", "Deloitte.1");

		clickElement(".//*[@id='Annon_DisplayHomePage_0']");

		completeApp();

	}

	public static void completeApp() {
		// clickElement(".//*[@id='accounthome']/div/div[2]/ul/li[2]/a");
		clickByHrefText("Complete My Application");
	}

	public static boolean answerYES(String question) {
		Random rand = new Random();
		int value = rand.nextInt(2) + 1;
		if (value == 1) {
			System.out.println(question + "... YES ");
			return true;
		} else {
			System.out.println(question + "... NO ");
			return false;
		}

	}

	public static void printMessage(String msj) {
		System.out.println("*************************");
		System.out.println(msj + "\n\n\n");
	}

	public static List<WebElement> getArray(String name, int index) {
		List<WebElement> myarray = driver.findElements(By.name(name + "["
				+ (index) + "]"));

		return myarray;

	}

	public static int randomnum() {
		Random rand = new Random();
		int value = rand.nextInt(9) + 1;
		return value;
	}

	public static String getRandomNumberOfNDigits(int n) {
		String passport = "";

		for (int i = 0; i < n; i++) {
			passport += "" + randomnum();
		}
		return passport;
	}

	public static String getTextFrom(String id) {
		String value = "";
		try {
			value = driver.findElement(By.xpath(id)).getText();
		} catch (Exception e) {
			System.err.println("Cannot get value from " + id);
		}
		return value;
	}

	public static String getRandomBetween(int a, int b) {
		Random random = new Random();
		return "" + (random.nextInt(b - a + 1) + a);
	}

	public static String getDateFromSystem() {
		String date = getTextFrom(".//*[@id='wrapper']/div[5]/span[1]");
		System.out.println(date);
		date = date.replaceAll("/", "");
		return date;
	}

	public static String getDateNextYearWillBe19() {
		String date = getTextFrom(".//*[@id='wrapper']/div[5]");
		System.out.println(date);
		date = date.replaceAll("/", "");
		return date;
	}

	public static int selectFirstElementFromArray(String elementName) {

		// String elementToClick = ".//*[@id='" + element + "']/a";
		int element = 0;
		int count = 0;
		try {
			Thread.sleep(1000);
			java.util.List<WebElement> checkbox = driver.findElements(By
					.name(elementName));

			if (checkbox != null && checkbox.size() > 0) {

				element = checkbox.size();
				checkbox.get(0).click();
				System.out.println("Last element from " + elementName
						+ " selected, position: " + (0));
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			System.err.println(e + " " + elementName);
		}
		return element;

	}

	public static int selectFirstCheckBoxFromArray(String elementName) {

		String function = "var inputs = document.getElementsByTagName('input');var a=-1;var childName='';for (var i = 0; i < inputs.length; i++) {  if (inputs[i].type == 'checkbox'&& inputs[i].name.match('"
				+ elementName
				+ "')){ a=i;i=inputs.length;}}if(a>-1&&a<inputs.length){inputs[a].click();}";
		executeJavaScriptFunciotn(function);
		return 0;

	}

	public static int selectLastCheckBoxFromArray(String elementName) {

		String function = "var inputs = document.getElementsByTagName('input');var a=-1;var childName='';for (var i = 0; i < inputs.length; i++) {  if (inputs[i].type == 'checkbox'&& inputs[i].name.match('"
				+ elementName
				+ "')){ a=i;}}if(a>-1&&a<inputs.length){inputs[a].click();}";
		executeJavaScriptFunciotn(function);
		return 0;

	}

	public static String getRandomLetters(int n) {

		int Low = 98;
		int High = 122;
		Random rand = new Random();

		String passport = "";

		for (int i = 0; i < n; i++) {
			char value = (char) (rand.nextInt(High - Low) + Low);
			passport += "" + value;
		}
		return passport;
	}

	
	
	public static void enableChkBox(String elementToClick) {
		try {
			while (!driver.findElement(By.xpath(elementToClick)).isSelected()) {
				driver.findElement(By.xpath(elementToClick)).click();
				System.out
						.println(".............................................."
								+ elementToClick + " clicked");
				// Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.err
					.println("\nElement does not exist or is not currently visible: "
							+ elementToClick);
		}
	}

	public static void disableChkBox(String elementToClick) {
		try {
			while (driver.findElement(By.xpath(elementToClick)).isSelected()) {
				driver.findElement(By.xpath(elementToClick)).click();
				System.out
						.println(".............................................."
								+ elementToClick + " clicked");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.err
					.println("\nElement does not exist or is not currently visible: "
							+ elementToClick);
		}
	}

	public static boolean lookInSourceCode(String anyStringToLookInHTMLSource) {

		String source = driver.getPageSource();
		// System.out.println(source);
		if (source.toLowerCase().contains(
				anyStringToLookInHTMLSource.toLowerCase())) {
			return true;
		}
		return false;

	}

	
	public static ArrayList<String> LoadUsernames() {
		String fileName = "usernames.txt";
		BufferedReader reader = null;
		String sCurrentLine;
		ArrayList<String> names = new ArrayList<String>();

		try {

			reader = new BufferedReader(new FileReader(fileName));

			while ((sCurrentLine = reader.readLine()) != null) {
				if (sCurrentLine != null && !sCurrentLine.isEmpty()) {
					names.add(sCurrentLine);
				}
			}

			if (reader != null) {
				reader.close();
			}
			return names;
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	
	public static Timestamp getTimeStamp(String month, String day, String year)
			throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = dateFormat.parse(day + "/" + month + "/" + year);
		long time = date.getTime();
		return new Timestamp(time);

	}

	public static Timestamp getNDaysFromDate(Timestamp stamp, int ndays) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(stamp.getTime());
		calendar.add(Calendar.DATE, ndays);

		return new Timestamp(calendar.getTimeInMillis());
	}

	public static String formatTimeStampToString(Timestamp ts) {
		Date date = new Date(ts.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(date);
	}

	public static Timestamp getNYearsBeforeYear(Timestamp stamp, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(stamp.getTime());
		calendar.add(Calendar.YEAR, (n * -1));

		return new Timestamp(calendar.getTimeInMillis());

	}

	public static Timestamp putNmoths(Timestamp stamp, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(stamp.getTime());
		calendar.add(Calendar.MONTH, n);
		return new Timestamp(calendar.getTimeInMillis());

	}

	public static Timestamp formatStringToTimestamp(String date) {
		Timestamp resp = null;
		try {
			if (date != null && !StringUtils.isBlank(date)) {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				sdf.setLenient(false);
				Date dateObj = sdf.parse(date);
				resp = new Timestamp(dateObj.getTime());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return resp;
	}

	public static String getCurrentDate() {
		String date = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			date = sdf.format(new Date());
			System.out.println(date); // 15/10/2013

		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;
	}

	public static void executeJavaScriptFunciotn(String function) {

		try {
			if (driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) driver).executeScript(function);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void sendTextByJavascript(String id, String value) {

		try {
			String javascriptFunciton = "document.getElementById(\"" + id
					+ "\").value = \"" + value + "\";";

			executeJavaScriptFunciotn(javascriptFunciton);

		} catch (Exception e) {

			System.err.println("id:" + id + "\n" + e.getLocalizedMessage());
		}

	}

	public static void clickByIDJavascript(String id) {

		try {
			String javascriptFunciton = "if(document.getElementById('" + id
					+ "')!=null){document.getElementById('" + id
					+ "').click();}";

			executeJavaScriptFunciotn(javascriptFunciton);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public static void enableAllCheckBoxJavascript() {

		try {
			String javascriptFunciton = "var inputs = document.getElementsByTagName(\"input\");"
					+ "for (var i = 0; i < inputs.length; i++) {  "
					+ "if (inputs[i].type == \"checkbox\") { "
					+ "inputs[i].checked=true;      " + "}  " + "}  ";

			executeJavaScriptFunciotn(javascriptFunciton);

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

	}

	public static void clickByHrefText(String text) {
		String funtion = "var inputs = document.getElementsByTagName('a');var total=-1;for (var i = 0; i < inputs.length; i++) { var valueHref = new String(inputs[i].text);if(valueHref.match('"
				+ text + "')){total=i;}}if(total>-1){inputs[total].click();}";

		executeJavaScriptFunciotn(funtion);

	}

	public static void editLastMmember() {
		String funtion = "var inputs = document.getElementsByTagName('a');var total=-1;for (var i = 0; i < inputs.length; i++) { if(inputs[i].href.match('AboutYourHouseholdEditMember')){total=i;}}if(total>-1){inputs[total].click();}";

		executeJavaScriptFunciotn(funtion);
	}

	public static void updateSystemPropertyDate(String date) {
		driver.get("http://10.233.2.99:7005/HBEBulletin/modifyproperty?env=DEV1");

		sendTextByJavascript("datepicker", date);
		sendTextByJavascript("datepicker_t", date);

		String javascriptFunciton = "var inputs = document.getElementsByTagName('input');for (var i = 0; i < inputs.length; i++) {  if (inputs[i].type == 'submit') { if (inputs[i].value == 'Save') {inputs[i].click(); }}}";

		executeJavaScriptFunciotn(javascriptFunciton);
		
	}

	
	public static String getEndDatePeriod() {
		String result = "";
		// String function =
		// "function myFunction(){var inputs = document.getElementsByTagName('td');var result='';if(inputs!=null && inputs[4]!=null){result=inputs[4].innerHTML;}alert(result);return result;}return myFunction();";
		String function = "var getSessionId = function(){var inputs = document.getElementsByTagName('td');var result='';if(inputs!=null && inputs[4]!=null){result=inputs[4].innerHTML;}return result;}getSessionId();";
		// String function =
		// "return (var inputs = document.getElementsByTagName('td');var result='';if(inputs!=null && inputs[4]!=null){result=inputs[4].innerHTML;}alert(result);return result)";

		if (driver instanceof JavascriptExecutor) {

			result = (String) ((JavascriptExecutor) driver)
					.executeScript(function);
		}
		System.out.println("The end date coverage is " + result);
		return result;
	}

	
	public static void killDriver() {

		String osName = System.getProperty("os.name");
		String cmd = "";
		String processName = "chromedriver.exe";
		if (osName.toUpperCase().contains("WIN")) {// S.O. Windows
			cmd += "tskill " + processName;
		} else {// Solo ha sido probado en win y linux
			cmd += "killall " + processName;
		}
		Process hijo;
		try {
			hijo = Runtime.getRuntime().exec(cmd);
			hijo.waitFor();
			if (hijo.exitValue() == 0) {
				System.out.println(processName + " killed");
			} else {
				System.out.println("unable to kill " + processName
						+ ". Exit code: " + hijo.exitValue() + "");
			}
		} catch (IOException e) {
			System.out.println("unable to kill " + processName);
		} catch (InterruptedException e) {
			System.out.println("unable to kill " + processName);
		}

	}

	public static int getRandomUsrNumber() {
		Random generator = new Random();
		int randomInt = generator.nextInt(1000);
		return randomInt;
	}

	public static String getRenewalDate(String intakeDate) {
		String renwalDate = "";
		try {
			Timestamp aux = formatStringToTimestamp(intakeDate);
			aux = getNDaysFromDate(aux, -15);
			aux = putNmoths(aux, 11);
			renwalDate = formatTimeStampToString(aux);
		} catch (Exception e) {
			System.err.println(e);
		}
		return renwalDate;
	}

	public static void clickInputByValue(String value) {
		String funtion = "var inputs = document.getElementsByTagName('input');var d=-1;for (var i = 0; i < inputs.length; i++) {  if (inputs[i].value.match('"
				+ value
				+ "')){ d=i;}}if(d>-1&&d<inputs.length){inputs[d].click();}";

		executeJavaScriptFunciotn(funtion);
		System.out.println("............................................... "
				+ value + " clicked");
	}

	public static void selectElementFromList(String elementName,
			String valueToSelect) {
		String function = "var nameElement='"
				+ elementName
				+ "';var valueToLook='"
				+ valueToSelect
				+ "';var allOptions=null;if(document.getElementById(nameElement)!=null){allOptions=document.getElementById(nameElement).getElementsByTagName('option');}for (var i = 0; i < allOptions.length; i++) {  if (allOptions[i].text.match(valueToLook)){allOptions[i].selected='selected';} }";
		String funString = "var nameElement='"
				+ elementName
				+ "';var valueToLook='"
				+ valueToSelect
				+ "';var allOptions=null;if(document.getElementById(nameElement)!=null){allOptions=document.getElementById(nameElement).getElementsByTagName('option');}var selected=null;for (var i = 0; i < allOptions.length; i++) {  if (allOptions[i].text==valueToLook){allOptions[i].selected='selected';selected='selected';} };if(selected==null){for (var i = 0; i < allOptions.length; i++) {  if (allOptions[i].text.match(valueToLook)){allOptions[i].selected='selected';} };}";

		executeJavaScriptFunciotn(funString);
	}

	public static void enableCheckboxByValue(String valueToSelect) {
		String function = "var inputs = document.getElementsByTagName('input');"
				+ "var a=-1;"
				+ "for (var i = 0; i < inputs.length; i++) {  "
				+ "if (inputs[i].type == 'checkbox'&& inputs[i].value.match('"
				+ valueToSelect
				+ "')){ "
				+ "a=i;"
				+ "}"
				+ "}"
				+ "if(a>-1&&a<inputs.length){"
				+ "inputs[a].checked=true; "
				+ "} ";
		System.out.println(function);
		executeJavaScriptFunciotn(function);
	}

	public static void enableCheckboxById(String id) {
		String function = "var inputs = document.getElementsByTagName('input');"
				+ "var a=-1;"
				+ "for (var i = 0; i < inputs.length; i++) {  "
				+ "if (inputs[i].type == 'checkbox'&& inputs[i].id.match('"
				+ id
				+ "')){ "
				+ "a=i;"
				+ "}"
				+ "}"
				+ "if(a>-1&&a<inputs.length){" + "inputs[a].click(); " + "} ";
		System.out.println(function);
		executeJavaScriptFunciotn(function);
	}

	public static void clickElementByTagAndType(String tagName, String type,
			String value) {
		String function = "var inputs = document.getElementsByTagName('"
				+ tagName + "');" + "var a=-1;"
				+ "for (var i = 0; i < inputs.length; i++) {  "
				+ "if (inputs[i].type == '" + type
				+ "'&& inputs[i].innerHTML.match('" + value + "')){ " + "a=i;"
				+ "}" + "}" + "if(a>-1&&a<inputs.length){"
				+ "inputs[a].click(); " + "} ";
		System.out.println(function);
		executeJavaScriptFunciotn(function);
	}

	

}

