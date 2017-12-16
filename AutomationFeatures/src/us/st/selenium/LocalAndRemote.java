package us.st.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LocalAndRemote {

	@Test
	public void runInLocalBrowser() {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://www.msn.com/");
		driver.quit();
		
	}

/*	
	@Test
	public void runRemotelyOnLocalHost(){
		WebDriver driver = new RemoteWebDriver(DesiredCapabilities.firefox());
		driver.get("http://google.com/");
		driver.quit();
	}
*/	

/*
	@Test
	public void runRemotelyonRemoteHost() throws MalformedURLException{
	WebDriver driver = new RemoteWebDriver(
			new URL("http://192.168.1.2:4444/wd/hub/"),
			DesiredCapabilities.firefox());
	driver.get("http://google.com/");
	driver.quit();
	}
*/
	
	}

