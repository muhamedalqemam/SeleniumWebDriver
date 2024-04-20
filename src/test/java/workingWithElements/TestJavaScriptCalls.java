package workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
