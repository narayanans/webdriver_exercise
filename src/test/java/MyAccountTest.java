package test.java;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import test.pageobjects.AccountDetailsPage;
import test.pageobjects.HomePage;
import test.pageobjects.MyAccountPage;

public class MyAccountTest extends BaseTest{

	
	@Test
	public void myAccount() throws InterruptedException{
		HomePage homePage = new HomePage(driver);
		
		MyAccountPage myAccountPage = homePage.clickMyAccount();
		myAccountPage = myAccountPage.loginWith("narayans", "0fqxURblweVY");
		
		AccountDetailsPage accountDetailsPage = myAccountPage.clickYourDetails();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMddYYHHmmss");
		String strUniqueAddress = sdf.format(new Date())  + " actor drive";
		
		accountDetailsPage.changeAddress(strUniqueAddress);
		accountDetailsPage.saveProfile();
		
		accountDetailsPage.logout();
		
		myAccountPage = myAccountPage.loginWith("narayans", "0fqxURblweVY");
		accountDetailsPage = myAccountPage.clickYourDetails();
		
		Assert.assertEquals("Address needs to be updated", strUniqueAddress, accountDetailsPage.getAddress());
		
	}
	
}
