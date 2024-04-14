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

public class FindByElements {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/");



	}

	@Test
	public void FindElements () {
		try {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println(links.size());
			assertEquals(46, links.size());	
			
			for (WebElement link : links) {
				System.out.println(link.getAttribute("href"));
			}
			
			
		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
