package com.genericmethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.MakeExtentReport;
import utils.Reports_utils;

public class GenericMethods extends MakeExtentReport {
	public static WebDriver driver;
	public static ChromeOptions options;
	public static Properties prop;
	static FileInputStream ip;

	// ****************************************GENERICMETHODS**********************//
	/*
	 * Method Name 			:= load_properties() 
	 * Input Parameter 		:= NA 
	 * Output Parameters	:= NA 
	 * Designer 			:= SHASHEER KHAN 
	 * Sprint 				:=#
	 */
	// *********************************************************************************//
	public static void load_properties() {
		prop = new Properties();

		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\config\\configuration.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// *******************************************************************************//
	/*
	 * Method Name 		:= hoverAndClick()
	 * 
	 * Input Parameter 	:= WebElement
	 * 
	 * OutPut Parameter := Boolean
	 * 
	 * Designer #		:= shamsheer
	 * 
	 * Sprint #			:=NA
	 */
	// ********************************************************************************//
	public static void hoverAndClick(WebElement element) {

		try {
			// Wait till the WebElement is Displayed

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
			element.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// **************************************************************//
	// *******************************************************************************//
	/*
	 * Method Name 		:= hoverAndSendkeys()
	 * 
	 * Input Parameter 	:= WebElement,  String keys
	 * 
	 * OutPut Parameter := Boolean
	 * 
	 * Designer #		:= shamsheer
	 * 
	 * Sprint #			:=
	 */
	// ********************************************************************************//
	public static void hoverAndSendkeys(WebElement element, String keys) {

		try {
			// Wait till the WebElement is Displayed
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(keys);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// **************************************************************//
	/*
	 * Method Name 		:= lanunchBowser()
	 * 
	 * Input Parameter 	:= NA
	 * 
	 * OutPut Parameter := Launching Browser
	 * 
	 * Designer #		:= shamsheer
	 * 
	 * Sprint #			:=NA
	 */
	// ********************************************************************************//
	public static void lanunchBowser() {
		load_properties();
		String browsername = prop.getProperty("browsername");
		String url = prop.getProperty("URL");
		if (browsername.equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.addArguments("window-size=1400,800");

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("cDriverpah"));
			driver = new ChromeDriver(options);
		} else if (browsername.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else
			driver = new FirefoxDriver();
		driver.manage().window().maximize();
		new WebDriverWait(driver, 5);
		driver.get(url);
	}
	// *******************************************************************************//
	/*
	 * Method Name 		:= single_child_tab_close()
	 * 
	 * Input Parameter 	:= NA
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #		:= shamsheer
	 * 
	 * Sprint #			:=NA
	 */
	// ********************************************************************************//
	public static void single_child_tab_close()   {
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentwindow_id = it.next();
		String childwindow_id = it.next();
		driver.switchTo().window(childwindow_id);
		driver.close();
		driver.switchTo().window(parentwindow_id);

	}

	// ***********************************************************************************//

	// **************************************************************//
	/*
	 * Method Name := tearDownBrowser()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := Quit Browser
	 * 
	 * Designer #:= shamsheer
	 * 
	 * Sprint #:=
	 */
	// ********************************************************************************//

	public static void tearDownBrowser() {
		driver.close();
	}

	// *******************************************************************************//
	/*
	 * Method Name := hoverElement()
	 * 
	 * Input Parameter := WebElement
	 * 
	 * OutPut Parameter := Boolean
	 * 
	 * Designer # := shamsheer
	 * 
	 * Sprint # :=NA
	 */
	// ********************************************************************************//
	public static void hoverElement(WebElement element) {

		try {
			// Wait till the WebElement is Displayed
			new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
			element.submit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ***************************************************************************************//
	/*
	 * Method Name := getTaodaydateArray()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := Today Date
	 * 
	 * Designer # := shamsheer
	 * 
	 * Sprint # :=NA
	 */	
	//***************************************************************************************//
	public static String[] getTaodaydateArray() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String TodayDate = sdf.format(date);
		String date_arr[] = TodayDate.split("-");
		return date_arr;
	}
	//*******************************************************************************************//
}
