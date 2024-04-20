package workingWithElements;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestContextMenu {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://swisnl.github.io/jQuery-contextMenu/demo/accesskeys.html");

	}


	@Test

	public void TestWindowByTitle() throws InterruptedException  {
		WebElement btn = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		WebElement Cmenu = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon-edit"));

		Actions builder = new Actions(driver);
		builder
		.contextClick(btn)
		.click(Cmenu)
		.perform();

		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();



	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
