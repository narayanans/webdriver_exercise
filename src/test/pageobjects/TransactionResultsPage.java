package test.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionResultsPage extends BasePageObject {

	public TransactionResultsPage(WebDriver driver) {
		super(driver);
		Assert.assertTrue("", driver.getTitle().contains("Transaction Results"));
	}

	public String getPriceOfTheFirstItem()
	{
		return driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
	}

}
