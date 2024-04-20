package workingWithElements;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestTakeScreenshot {

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
		
		WebElement BugToTestScreenShot = driver.findElement(By.cssSelector("li.context-menu-item.context-menu-icon.context-menu-icon"));

		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();

	}
	
	@AfterMethod
	public void TakeScreenshot(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			org.apache.commons.io.FileUtils.copyFile(source, new File("./screenshots/"+ result.getName()+".png"));
			
			
		}
	}


	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
