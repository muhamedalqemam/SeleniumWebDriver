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

public class FindLinksByLinkText {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/login");



	}

	@Test
	public void FindElements () {
		try {
			WebElement seleniumLink = driver.findElement(By.linkText("Elemental Selenium"));
			System.out.println(seleniumLink.getAttribute("href"));
			assertEquals("http://elementalselenium.com/", seleniumLink.getAttribute("href"));
			
			WebElement seleniumLink0 = driver.findElement(By.partialLinkText("Elemental"));
			System.out.println(seleniumLink0.getAttribute("href"));
			assertEquals("http://elementalselenium.com/", seleniumLink0.getAttribute("href"));
			
			WebElement seleniumLink1 = driver.findElement(By.cssSelector("img"));
			System.out.println(seleniumLink1.getAttribute("href"));
			
		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
