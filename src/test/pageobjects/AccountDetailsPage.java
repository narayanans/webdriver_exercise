package test.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPage extends BasePageObject {

	public AccountDetailsPage(WebDriver driver) {
		super(driver);
		Assert.assertTrue("", driver.getTitle().contains("Your Account"));
	}
	
	By fieldAddress = By.xpath("//*[@title='billingaddress']");
	By buttonSave = By.xpath("//*[@value='Save Profile']");
	
	public void changeAddress(String string) {
		driver.findElement(fieldAddress).clear();
		driver.findElement(fieldAddress).sendKeys(string);
	}

	public void saveProfile()
	{
		driver.findElement(buttonSave);
	}

	public String getAddress() {
		return driver.findElement(fieldAddress).getText();
	}
}
