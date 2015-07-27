package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePageObject{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	By buttonRemove = By.xpath("//input[@value='Remove']");
	By divContent = By.cssSelector("div.entry-content");
	
	public ShippingPage clickContinue(){
		driver.findElement(By.linkText("Continue")).click();
		return new ShippingPage(driver);
	}
	
	public CartPage removeFirstProduct(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(buttonRemove)).click();
//		driver.findElement(buttonRemove).click();
		return this;
	}
	
	public String getCartPageContent() {
		return driver.findElement(divContent).getText();
	}
}
