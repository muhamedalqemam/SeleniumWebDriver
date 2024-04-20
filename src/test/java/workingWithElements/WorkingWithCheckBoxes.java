package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCheckBoxes {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");



	}

	@Test(enabled = false)
	public void FinfElementByClass () throws InterruptedException {
		try {
			
			WebElement check1 = driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[1]"));
			WebElement check2 = driver.findElement(By.xpath("html/body/div[2]/div/div/form/input[2]"));
			
			check1.click();
			
			if(!check2.isSelected()) {
				check2.click();
			}
			
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}


	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
