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

public class WorkingWithConfirmAlert {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");

	}


	@Test()

	public void AcceptAlert()  {
		WebElement BtnConfirm = driver.findElement(By.id("confirm"));
		BtnConfirm.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement message = driver.findElement(By.id("demo"));
		assertEquals("You Accepted Alert!", message.getText());

	}


	@Test()

	public void DismissAlert()  {
		WebElement BtnConfirm = driver.findElement(By.id("confirm"));
		BtnConfirm.click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		WebElement message = driver.findElement(By.id("demo"));
		assertEquals("You Dismissed Alert!", message.getText());

	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
