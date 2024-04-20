package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTextBoxAndButtons {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/login");

		

	}

	@Test
	public void FinfElementByClass () {
		try {
			WebElement TxtUserName = driver.findElement(By.id("username"));
			WebElement TxtPassword = driver.findElement(By.id("password"));
			WebElement BtnLogin = driver.findElement(By.className("radius"));
			TxtUserName.clear();
			TxtUserName.sendKeys("tomsmith");
			TxtPassword.clear();
			TxtPassword.sendKeys("SuperSecretPassword!");
			BtnLogin.click();
			
			WebElement SuccessNotification = driver.findElement(By.id("flash"));
			assertTrue(SuccessNotification.getText().contains("You logged into a secure area!"));
			assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/secure");


		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
