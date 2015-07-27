package test.java;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	WebDriver driver;

	@Before
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\naray\\chromedriver_win32\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.navigate().to("http://store.demoqa.com/");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
