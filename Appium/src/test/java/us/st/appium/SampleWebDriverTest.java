package us.st.appium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SampleWebDriverTest {
	
  @Test
  public void runInLocalBrowser() {
	  
	File file = new File ("C:/Users/yarkhypo/My_Software/drivers/IEDriverServer.exe");
	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	InternetExplorerDriver driver = new InternetExplorerDriver();
	//WebDriver driver = new FirefoxDriver();
	driver.get("http://www.msn.com/");
	driver.quit();
}
  
}
