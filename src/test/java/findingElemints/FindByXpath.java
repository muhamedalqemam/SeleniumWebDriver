package findingElemints;

import static org.testng.Assert.assertEquals;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class FindByXpath {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/login");



	}

	@Test
	public void FindElements () {
		try {
			//WebElement seleniumLink = driver.findElement(By.xpath("html/body/div[3]/div/div/a"));
			//System.out.println(seleniumLink.getAttribute("href"));
			//assertEquals("http://elementalselenium.com/", seleniumLink.getAttribute("href"));
			
			WebElement userName = driver.findElement(By.xpath("//input['0']"));
			System.out.println(userName.getTagName());
		
			
		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
