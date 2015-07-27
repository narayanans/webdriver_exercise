package test.java;


import org.junit.Assert;
import org.junit.Test;

import test.pageobjects.CartPage;
import test.pageobjects.HomePage;
import test.pageobjects.ProductPage;
import test.pageobjects.SearchResultsPage;

public class CartClearTest extends BaseTest{

	
	@Test
	public void cartClear() throws InterruptedException{
		HomePage homePage = new HomePage(driver);
		
		SearchResultsPage searchResultsPage = homePage.searchWithText("Apple iPhone");
		
		ProductPage productPage = searchResultsPage.goToProductPage("Apple iPhone 4S 16GB SIM-Free – Black");
		
		CartPage cartPage = productPage.addToCart().goToCheckout();
		cartPage = cartPage.removeFirstProduct();

		Assert.assertEquals("Prices should match", "Oops, there is nothing in your cart.", cartPage.getCartPageContent());
	}
	
}
