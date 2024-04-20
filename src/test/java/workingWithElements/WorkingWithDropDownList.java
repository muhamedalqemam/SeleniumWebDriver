package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDropDownList {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/dropdown");



	}

	@Test
	public void FinfElementByClass () {
		try {
			
			WebElement options = driver.findElement(By.id("dropdown"));
			Select dp1 = new Select(options);
			assertFalse(dp1.isMultiple());
			
			assertEquals(3, dp1.getOptions().size());
			//dp1.selectByVisibleText("Option 1");
			//dp1.selectByValue("1");
			dp1.selectByIndex(2);
			
		assertEquals("Option 1", dp1.getOptions().get(1).getText());


		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
