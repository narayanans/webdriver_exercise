package test.java;

import org.junit.Assert;
import org.junit.Test;

import test.pageobjects.CartPage;
import test.pageobjects.HomePage;
import test.pageobjects.ProductPage;
import test.pageobjects.SearchResultsPage;
import test.pageobjects.ShippingPage;
import test.pageobjects.TransactionResultsPage;

public class OrderSubmissionTest extends BaseTest{

	
	@Test
	public void orderSubmission() throws InterruptedException{
		HomePage homePage = new HomePage(driver);
		
		SearchResultsPage searchResultsPage = homePage.searchWithText("Apple iPhone");
		
		ProductPage productPage = searchResultsPage.goToProductPage("Apple iPhone 4S 16GB SIM-Free – Black");
		
		String currentPrice = productPage.getCurrentPrice();
		
		CartPage cartPage = productPage.addToCart().goToCheckout();
		ShippingPage shippingPage = cartPage.clickContinue();


		shippingPage.selectCountry("USA");
		shippingPage.clickCalculate();
		shippingPage.enterEmail("kevin@blablabla.com");
		shippingPage.fillBillingForm("Kevin", "Bacon", "701 Actor Drive", "Los Angeles", "CA", "USA", "5125125125");
		
		shippingPage.shippingSameBilling();
		
		TransactionResultsPage transactionResultsPage = shippingPage.clickPurchase();
		Assert.assertEquals("Prices should match", currentPrice, transactionResultsPage.getPriceOfTheFirstItem());
	}
	
}
