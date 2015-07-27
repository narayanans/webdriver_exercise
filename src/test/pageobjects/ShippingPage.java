package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage extends BasePageObject {

	public ShippingPage(WebDriver driver) {
		super(driver);
	}

	By selectCountry = By.id("current_country");
	By buttonCalculate = By.xpath("//input[@value='Calculate']");

	By billingEmail = By.xpath("//input[@title='billingemail']");
	
	By billingFirstName = By.xpath("//input[@title='billingfirstname']");
	By billingLastName = By.xpath("//input[@title='billinglastname']");
	By billingAddress = By.xpath("//textarea[@title='billingaddress']");
	By billingCity = By.xpath("//input[@title='billingcity']");
	By billingState = By.xpath("//input[@title='billingstate']");
	By billingCountry = By.xpath("//select[@title='billingcountry']");
	By billingPhone = By.xpath("//input[@title='billingphone']");

	By checkBoxShippingSameBilling = By.id("shippingSameBilling");
	By buttonPurchase = By.cssSelector("input.make_purchase");
	
	public void selectCountry(String country) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCalculate));
		new Select(driver.findElement(selectCountry))
				.selectByVisibleText(country);
	}

	public void clickCalculate() {
		driver.findElement(buttonCalculate).click();
	}

	public void fillBillingForm(String firstName, String lastName,
			String address, String city, String state, String country,
			String phone) {
		driver.findElement(billingFirstName).sendKeys(firstName);
		driver.findElement(billingLastName).sendKeys(lastName);
		driver.findElement(billingAddress).sendKeys(address);
		driver.findElement(billingCity).sendKeys(city);
		driver.findElement(billingState).sendKeys(state);
		new Select(driver.findElement(billingCountry))
				.selectByVisibleText(country);
		driver.findElement(billingPhone).sendKeys(phone);
	}

	public void enterEmail(String email) {
		driver.findElement(billingEmail).sendKeys(email);
	}

	public void shippingSameBilling(){
		driver.findElement(checkBoxShippingSameBilling).click();
	}
	
	public TransactionResultsPage clickPurchase() {
		driver.findElement(buttonPurchase).click();
		return new TransactionResultsPage(driver);
	}
	
}
