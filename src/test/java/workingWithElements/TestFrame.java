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

public class TestFrame {

	WebDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");

	}


	@Test

	public void TestFrameWithIdAndName()  {
		driver.switchTo().frame("left");
		WebElement message = driver.findElement(By.tagName("P"));
		assertTrue(message.getText().contains("Left Frame"));
		System.out.println(message.getText().contains("Left Frame"));
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		WebElement message1 = driver.findElement(By.tagName("P"));
		assertTrue(message1.getText().contains("doesn't have id "));
		System.out.println(message1.getText().contains("doesn't have id "));
		System.out.println(message1.getText().contains("Left Frame"));
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("right");
		WebElement message2 = driver.findElement(By.tagName("P"));
		assertTrue(message2.getText().contains("Right Frame"));
		System.out.println(message2.getText().contains("doesn't have id "));
		System.out.println(message2.getText().contains("Right Frame"));
		driver.switchTo().defaultContent();

	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
