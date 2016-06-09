package org.stories.assetmanager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/*##############################################################################################################################
# 																				
#  Script can be used run methods, functions for every test/Stories.
#
#
#
###############################################################################################################################*/

public class CommonFunction {

	// Creating instant to Wedbriver.
	public static WebDriver driver;

	// Initial setup to navigate to URL and browser.
	@BeforeClass
	@Parameters({ "browser", "url" })
	public static void setUp(String browser, String url) {
		if (browser.equalsIgnoreCase("Firefox")) {
			Reporter.log("Script runs in Firefox browser", true);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			Reporter.log("Script runs in ChromeBrowser");
			driver = new ChromeDriver();
		} else {
			Reporter.log("Script runs in default Firefox browser", true);
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// To check alert is available or not.
	public static boolean isAlertPresent() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// On alert present accept it.
	public static boolean isAlertPresent1() {
		try {
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				Reporter.log("Alert is present and accepted!");
				driver.switchTo().alert().accept();
				return true;
			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			Reporter.log("Alert isn't present!!");
			return false;
		}

	}

	// Common function for alert accept in the page.
	public static void alertAccept() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		Reporter.log("Alert - " + alertMsg, true);
		alert.accept();
	}

	// After completing all tests quit/close the browser.
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
