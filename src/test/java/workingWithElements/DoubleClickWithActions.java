package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithActions {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

	}


	@Test()

	public void DoubleClick() {
	WebElement message = driver.findElement(By.id("message"));
	Actions builder = new Actions(driver);
	assertEquals("rgb(0, 0, 255)", message.getCssValue("background-color"));
	
	builder.doubleClick(message).perform();
	
	assertEquals("rgb(255, 255, 0)", message.getCssValue("background-color"));


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
