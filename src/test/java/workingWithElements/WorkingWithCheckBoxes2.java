package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCheckBoxes2 {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");

	}


	@Test()

	public void IsElementPresent() {
		if (IsElementPresent(By.xpath("html/body/div[2]/div/div/form/input[1]"))) {
			WebElement check1 = driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[1]"));
			if (!check1.isSelected()) {
				check1.click();
			}
		}else {
			System.out.println("This Element doesn't exist!");
		}
	}


	private boolean IsElementPresent(By by)  {
		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
