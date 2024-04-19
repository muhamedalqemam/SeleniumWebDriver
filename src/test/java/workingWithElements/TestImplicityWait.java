package workingWithElements;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.network.SetCookieHeader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.collections.Sets;

import com.google.common.collect.Iterables;

public class TestImplicityWait {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");

	}


	@Test(priority = 1)

	public void TestWindowByTitle()  {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement BtnPage = driver.findElement(By.linkText("Page 4"));
		BtnPage.click();
		
		WebElement MessagePage = driver.findElement(By.id("page4"));
		assertTrue(MessagePage.getText().contains("Nunc nibh "));
		
		
	}



	@AfterTest
	public void CloseDriver() {
		driver.quit();
	}


}
