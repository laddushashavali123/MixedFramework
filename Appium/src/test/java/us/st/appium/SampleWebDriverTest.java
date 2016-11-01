package us.st.appium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SampleWebDriverTest {
	
  @Test
  public void runInLocalBrowser() {
  WebDriver driver = new FirefoxDriver();
	driver.get("http://www.msn.com/");
	driver.quit();
}
  
}
