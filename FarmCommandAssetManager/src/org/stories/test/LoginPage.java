package org.stories.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.stories.assetmanager.CommonFunction;
import org.testng.annotations.BeforeTest;

public class LoginPage extends CommonFunction {

	// Login for every story.
	@BeforeTest
	public static void loginTest() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("#id_username")).sendKeys("siva");
		driver.findElement(By.cssSelector("#id_password")).sendKeys("siva123456");
		driver.findElement(By.cssSelector(".submit-login")).click();

		// LoginPage loginP = new LoginPage();
	}

}
