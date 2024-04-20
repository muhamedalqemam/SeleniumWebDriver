package workingWithElements;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
		System.out.println(store.getValue());

		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		Iterator<Cookie> itr = cookies.iterator();

		while (itr.hasNext()) {
			Cookie cookie = itr.next();
			System.out.println(cookie.getDomain());
		}

	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
