package test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePageObject{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductPage goToProductPage(String string) {
		driver.findElement(By.linkText(string)).click();
		return new ProductPage(driver);
	}

	
}
