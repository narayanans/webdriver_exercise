package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePageObject {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	By currentPrice = By.cssSelector("span.currentprice");
	By oldPrice = By.cssSelector("span.oldprice");
	By addToCart = By.cssSelector("input.wpsc_buy_button");

	public String getCurrentPrice() {
		return driver.findElement(currentPrice).getText();
	}

	public String getOldPrice() {
		return driver.findElement(oldPrice).getText();
	}

	public ProductPage addToCart() {
		driver.findElement(addToCart).click();
		return this;
	}

	public CartPage goToCheckout() {
		driver.findElement(By.linkText("Go to Checkout")).click();
		return new CartPage(driver);
	}
}
