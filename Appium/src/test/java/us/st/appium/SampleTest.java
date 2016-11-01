package us.st.appium;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class SampleTest {
	
	protected AndroidDriver driver;
	protected String appLocation = "c://Users/yarkh/Desktop/Selenium_tests/Appium/resourses/apk/";
	protected String appName = "US_Citizenship_Test.apk";
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {

	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("deviceName", "FA53RYJ17472");
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability("appPackage", "net.gordons.uscitizenship2011Edition");
	  capabilities.setCapability("appActivity", "net.gordons.uscitizenship2011Edition.CitizenshipFlashCards");
	  capabilities.setCapability("app", appLocation+appName);
	  capabilities.setCapability("noReset", "true");
	  capabilities.setCapability("fullReset", "false");
	  
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub") , capabilities);
	  driver.pressKeyCode(AndroidKeyCode.HOME);
	  //driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
	  
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='All apps']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//android.widget.ImageButton")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//android.widget.ImageButton")).sendKeys("settings");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Settings']")).click();
	  //driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='All apps']")).click();
  }
  
  @Test
  public void f() {
	  
	  
  }
  
  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
