package workingWithElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestExplicitWait {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com/");

	}


	@Test(priority = 1)

	public void TestWindowByTitle()  {
		WebElement search = driver.findElement(By.id("APjFqb"));
		search.sendKeys("selenium");
		search.submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("selenium"));



	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
