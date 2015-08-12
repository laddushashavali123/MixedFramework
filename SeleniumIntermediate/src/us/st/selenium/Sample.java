package us.st.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.Assert.*;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new FirefoxDriver();
	driver.get("http:/google.com");
	Thread.sleep(4000);
//	driver.findElements(By.xpath("//*[@id='gs_htif0']")).sendKeys("Selenium", Keys.TAB);
	driver.quit();
	}

}
