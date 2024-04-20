package workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScrollToBottomOfPage {


	WebDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.jumia.com.eg/ar/");
	}


	@Test
	public void TestScroll() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 8000)");

		Thread.sleep(3000);
		WebElement jumiaLogo = driver.findElement(By.cssSelector("svg.ic"));
		assertTrue(jumiaLogo.isDisplayed());

	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}

}
