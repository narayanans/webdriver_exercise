package test.java;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	WebDriver driver;
	
	@Before
	public void setUp(){
		System.out.println("Base test set up");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\naray\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.navigate().to("http://store.demoqa.com/");
	}
	
	@After
	public void tearDown(){
		System.out.println("Base test tear down");
		driver.quit();
	}
	
}
