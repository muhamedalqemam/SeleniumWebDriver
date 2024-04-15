package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.Iterables;

public class TestCookies {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://magento-demo.lexiconn.com/");

	}


	@Test(priority = 1)

	public void TestWindowByTitle()  {
		WebElement LanguageSelect = driver.findElement(By.id("select-language"));
		Select select = new Select(LanguageSelect);

		assertEquals("English", select.getFirstSelectedOption().getText());
		
		Cookie store = driver.manage().getCookieNamed("store");
		assertEquals(null, store);
		
		select.selectByVisibleText("German");
		store = driver.manage().getCookieNamed("store");
		assertEquals("german", store.getValue());
		
		
		
		
		
	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
