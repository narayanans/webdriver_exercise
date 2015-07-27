package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * All the page objects extend the BasePageObject.
 * Allows for keeping initiliazing and boiler plate code in one place.	
 * Will also contain the Header/Footer/Menu elements.
 */
public class BasePageObject {

	WebDriver driver;
	WebDriverWait wait;
	
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	By fieldSearch = By.cssSelector("input.search");
	By linkMyAccount = By.xpath("//a[@title='My Account']");

	public SearchResultsPage searchWithText(String text) {
		driver.findElement(fieldSearch).sendKeys(text);
		driver.findElement(fieldSearch).sendKeys(Keys.ENTER);

		return new SearchResultsPage(driver);
	}

	public MyAccountPage clickMyAccount() {
		driver.findElement(linkMyAccount).click();
		return new MyAccountPage(driver);
	}
	
	public BasePageObject logout() {
		driver.findElement(By.linkText("(Logout)")).click();
		return this;
	}
}
