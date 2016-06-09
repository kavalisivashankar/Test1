package org.stories.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.stories.assetmanager.CommonFunction;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Story829 extends CommonFunction {

	@Test
	public static void asset_Delete_Test() throws InterruptedException {
		// To test sign-in and sign-off.
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		// Login setup.
		LoginPage.loginTest();

		// Initial alert accepting to proceed into application.
		isAlertPresent1();
		Thread.sleep(50000);

		// Elements to trigger each steps as given in the Stories - Story#829.

		// Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='navbar-logoDropDown']/a/img")));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='navbar-logoDropDown']/a/img")));

		driver.findElement(By.xpath(".//*[@id='navbar-logoDropDown']/a/img")).click();
		driver.findElement(By.cssSelector("#navbar-logoMenu > li:nth-child(8) > div.menu-text")).click();
		driver.findElement(By.cssSelector("a.nav-toggle > span")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[5]/div[2]/div[2]/div/div[1]/ul/li[2]/ul/li[1]/a")).click();

		driver.findElement(By.xpath("//div[contains(@class,'assets-btn-group')]/button[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(@title,'Add Asset')]/img")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[contains(@name,'label')]")).sendKeys("sample");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(@class,'assets-panel active')]/div/form/div/fieldset/input"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(@title,'Filter Assets by selected asset in navigation bar.')]"))
				.click();
		Thread.sleep(5000);
		WebElement assetCheck = driver
				.findElement(By.xpath("//table[contains(@class,'table-component')]/tbody/tr/td[1]/input"));
		assetCheck.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(@title,'Delete Asset(s)')]")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[contains(@class,'assets-panel active')]/div/div[2]/input[1]")).click();
		Thread.sleep(5000);

		// Looking for asset is deleted or not.
		driver.findElement(By.xpath("//div[contains(@class,'assets-btn-group')]/button[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Label']")).sendKeys("sample");
		Thread.sleep(5000);

		List<WebElement> check = driver
				.findElements(By.xpath("//table[contains(@class,'table-component')]/tbody/tr/td[1]/input"));
		int noOfAssets = check.size();
		if (noOfAssets == 0) {
			Reporter.log("Asset deleted Sucssessfully!", true);
		} else {
			Reporter.log("Asset still exists even after Deleting It!", true);
		}

	}

}
