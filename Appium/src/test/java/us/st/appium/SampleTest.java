package us.st.appium;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SampleTest {
	
	protected AndroidDriver driver;
	protected String appLocation = "c://Users/yarkh/Desktop/Selenium_tests/Appium/resourses/apk/";
	protected String appName = "US_Citizenship_Test.apk";
	protected WebDriverWait wait=null;
  
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
	  wait = new WebDriverWait (driver, 10);
	  Map<String, String> params = new HashMap<String, String>();
	  //driver.pressKeyCode(AndroidKeyCode.HOME);
	  TouchAction action = new TouchAction(driver);
	  driver.pressKeyCode(AndroidKeyCode.KEYCODE_SEARCH);
	  
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(
			  By.xpath("//android.widget.TextView[@content-desc='All apps']")));
	  
  	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Phone']")).click();
  	  wait.until(ExpectedConditions.visibilityOfElementLocated(
			  By.xpath("//android.widget.TextView[@text='Call History']")));
  	  
  	  driver.findElement(By.xpath("//android.widget.TextView[@text='Call History']")).click();
  	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
			  By.xpath("//android.widget.TextView[@content-desc='Check contact card']")));
  	  
  	 // driver.scrollToExact("Voicemail");
  	  
  	  Thread.sleep(4000);
	  
	  
  
  }
  @Test
  public void f() {
	  
	  /*
	   * Attempt to scroll 
	   * 	  
	  
	  
	  driver.findElement(By.xpath("//android.widget.TextView[@content-desc='All apps']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton")));
	  
	  
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  System.out.println("I will scroll");
	  params.put("direction", "down");
	  params.put("text", "YouTube");
	  js.executeScript("mobile: scrollTo", params);
	  
	  
	  //driver.swipe(1016, 1423, 1016, 536, 4);
	  driver.findElement(By.xpath("//android.widget.ImageButton")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton")));
	  driver.findElement(By.xpath("//android.widget.ImageButton")).sendKeys("settings");
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Settings")));
	  driver.findElement(By.name("Settings")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Airplane mode']")));
	  driver.findElement(By.xpath("//android.widget.TextView[@text='Airplane mode']")).click();
	  //driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Wi\").textContains(\"Fi\")").click();
	  Thread.sleep(1000);
	  //driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='All apps']")).click();
	  
	  if (driver.findElement(By.xpath("//android.widget.Switch[@index='2']")).getAttribute("checkable").equals("true")){
		  
		  System.out.println("Connected to " + driver.findElement(By.xpath("//*[@text='Connected']")));
*/		  
	  
	  
  }
  
  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
	  
  }

}
