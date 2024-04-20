package workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
