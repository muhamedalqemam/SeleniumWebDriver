package findingElemints;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindByCSSSelector {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/login");



	}

	@Test
	public void FindByCSSSelector () {
		try {
			WebElement LoginBtn = driver.findElement(By.cssSelector("button.radius"));
			LoginBtn.click();
			
			
		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
