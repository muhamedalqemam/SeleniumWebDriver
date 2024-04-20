package workingWithElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTables {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/tables");



	}

	@Test
	public void FinfElementByClass () throws InterruptedException {
		try {
			
			WebElement table2 = driver.findElement(By.id("table2"));
			List<WebElement> rows = table2.findElements(By.tagName("tr"));
			
			for (WebElement row : rows) {
				List<WebElement> cols = row.findElements(By.tagName("td"));
				
				for (WebElement col : cols) {
					System.out.println(col.getText() + "\t");
				}
				System.out.println();
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
