package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithSubmitMethod {

	FirefoxDriver driver;
	WebElement SearchBar;
	@BeforeTest
	public void OpenUrl () {
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.google.com/");
		
	}
	
	@Test
	public void Search () throws InterruptedException {
		WebElement SearchBar = driver.findElement(By.id("APjFqb"));
		SearchBar.clear();
		SearchBar.sendKeys("qtech");
		SearchBar.submit();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		
		WebElement SearchBar1 = driver.findElement(By.id("APjFqb"));
		SearchBar1.clear();
		SearchBar1.sendKeys("facebook");
		SearchBar1.submit();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());

	
	}
	
	@AfterTest
	public void Close() {
		driver.quit();
	}
}
