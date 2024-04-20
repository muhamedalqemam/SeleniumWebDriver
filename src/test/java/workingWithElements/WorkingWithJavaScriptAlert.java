package workingWithElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithJavaScriptAlert {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");

	}


	@Test()

	public void AcceptAlert()  {
		WebElement BtnAlert = driver.findElement(By.id("simple"));
		BtnAlert.click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Hello! I am an alert box!", alert.getText());
		alert.accept();


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
