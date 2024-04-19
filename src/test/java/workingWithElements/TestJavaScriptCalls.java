package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.collections.Sets;

import com.google.common.collect.Iterables;

public class TestJavaScriptCalls {

	WebDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com/");

	}


	@Test

	public void TestJavaScript()  {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript( "return document.title");
		System.out.println(title);
		assertTrue(title.contains("Google"));
		
		long links = (long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
		System.out.println(links);

	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
