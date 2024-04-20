package workingWithElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropActions {

	FirefoxDriver driver;

	@BeforeTest
	public void OpenUrl() {
		driver = new FirefoxDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");

	}


	@Test()

	public void DoubleClick() throws InterruptedException {
	WebElement source = driver.findElement(By.id("draggable"));
	WebElement target = driver.findElement(By.id("droppable"));
	Actions builder = new Actions(driver);
	
	builder.dragAndDrop(source, target).perform();
	Thread.sleep(3000);
	
	assertEquals("Dropped!", target.getText());


	}

	@AfterTest
	public void CloseDriver() {
		driver.close();
	}


}
