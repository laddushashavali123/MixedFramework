package us.st.selenium.extension;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

public class WebElementExtender {

	private static WebDriver driver;
	
	public static void setAttribute(WebElement element, String attributeName, String value){
		WrapsDriver wrappedElement = (WrapsDriver) element;
		JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attributeName, value);
	}
	
	private static void highlightElement(WebElement element) throws InterruptedException{
		for (int i=0; i<5; i++){
		Thread.sleep(1000);
		WrapsDriver wrappedElement = (WrapsDriver) element;
		JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		driver.executeScript("arguments[0].setAttribute('style', arguments[1])", 
			element, "color: green; border:10px; solid yellow");
		driver.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: green; border:10px; solid yellow" );
		}
	}
	
	
	
	@Test
	public void test() {
		
		// invoke driver, go to url
		WebElement username = driver.findElement(By.id("username"));
		WebElement email = driver.findElement(By.id("email"));
		setAttribute(username, "value", "");
		username.sendKeys("testuser.com");
		
	}

}
