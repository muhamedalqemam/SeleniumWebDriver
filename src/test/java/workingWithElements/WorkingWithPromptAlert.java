package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithPromptAlert {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");

	}


	@Test()

	public void AcceptAlert()  {
		WebElement BtnPrompt = driver.findElement(By.id("prompt"));
		BtnPrompt.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Mohamed");
		alert.accept();
		WebElement message = driver.findElement(By.id("prompt_demo"));
		assertEquals("Hello Mohamed! How are you today?", message.getText());


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
