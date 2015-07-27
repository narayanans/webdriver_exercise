package test.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject{

	public HomePage(WebDriver driver) {
		super(driver);
		Assert.assertTrue("Am I at home page?", driver.getTitle().contains("ONLINE STORE"));
	}
	
}
