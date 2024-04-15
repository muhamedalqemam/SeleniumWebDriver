package workingWithElements;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMultipleWindows {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");

	}


	@Test(priority = 1)

	public void TestWindowByTitle()  {
		WebElement VistUsBtn = driver.findElement(By.id("visitbutton"));
		VistUsBtn.click();

		String CurrentWindowId = driver.getWindowHandle();

		for (String WindowId : driver.getWindowHandles()) {
			String Title = driver.switchTo().window(WindowId).getTitle();
			if(Title.equals("Visit Us")) {
				assertEquals("Visit Us", driver.getTitle());
				driver.close();
				break;
			}
			driver.switchTo().window(CurrentWindowId);
		}


	}


	@Test(priority = 2)

	public void TestWindowByName()  {
		String CurrentWindowId = driver.getWindowHandle();
		WebElement HelpBtn = driver.findElement(By.id("helpbutton"));
		HelpBtn.click();

		driver.switchTo().window("HelpWindow");
		System.out.println(driver.getTitle());
		driver.close();

		driver.switchTo().window(CurrentWindowId);

	}

	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
