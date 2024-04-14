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

public class TestBrowserCommands {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/");
		System.out.println(driver.getCurrentUrl());


	}

	@Test
	public void FindElements () {
		try {
			driver.navigate().to("http://the-internet.herokuapp.com/login");
			System.out.println(driver.getCurrentUrl());
			driver.manage().window().maximize();
			driver.navigate().back();
			System.out.println(driver.getCurrentUrl());
			driver.manage().window().minimize();
			driver.navigate().forward();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().refresh();
			System.out.println(driver.getCurrentUrl());
		
			
		} catch (NoSuchElementException e) {
			System.out.println("the element is not found.");
		}


	}

	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
