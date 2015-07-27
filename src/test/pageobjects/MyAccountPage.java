package test.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePageObject {

	By fieldUsername = By.id("log");
	By fieldPassword = By.id("pwd");
	By buttonLogin = By.id("login");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		Assert.assertTrue("", driver.getTitle().contains("Your Account"));
	}

	public MyAccountPage loginWith(String username, String password) {
		driver.findElement(fieldUsername).sendKeys(username);
		driver.findElement(fieldPassword).sendKeys(password);
		driver.findElement(buttonLogin).click();
		return this;
	}

	public AccountDetailsPage clickYourDetails() {
	driver.findElement(By.linkText("Your Details")).click();
		return new AccountDetailsPage(driver);
	}


}
