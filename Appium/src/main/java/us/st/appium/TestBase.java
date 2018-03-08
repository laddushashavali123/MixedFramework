package us.st.appium;

import java.security.Key;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

public class TestBase {
	
	protected AndroidDriver driver;
	protected final int defaultTimeout=15;
	protected Properties OR = new Properties();
	protected WebDriverWait wait;
	
	
	public void waitForElVisibility(String obj){
		   
		   for (int i=0;i<defaultTimeout;i++){
			   
			   try{
				   WebElement el = getObject(obj);
				   wait.until(ExpectedConditions.visibilityOf(el));
				   return;
			   }catch(Exception e){
				   
				   if(i==defaultTimeout-1){
					   throw new TimeoutException("TimeOut waiting for "+obj);
					   
				   }
				   System.out.println("caughtException " + i+" times");
				   try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				   
			   }
			   
			   
		   }
		   
	   }
	   
	   protected By getLocator(String strElement, Properties prop)
				throws Exception {
		   
		  
			// retrieve the specified object from the object list
			String locator = prop.getProperty(strElement);
			
			// extract the locator type and value from the object
			String locatorType = locator.split(":")[0];
			String locatorValue = locator.split(":")[1];

			// for testing and debugging purposes
			System.out.println("Retrieving object of type '" + locatorType
					+ "' and value '" + locatorValue + "' from the object map");

			// return a instance of the By class based on the type of the locator
			// this By can be used by the browser object in the actual test
			switch (locatorType.toLowerCase().trim()) {
			case "id":
				return By.id(locatorValue);
			case "name":
				return By.name(locatorValue);
			case "classname":
			case "class":
				return By.className(locatorValue);
			case "tagname":
			case "tag":
				return By.className(locatorValue);
			case "linktext":
			case "link":
				return By.linkText(locatorValue);
			case "partiallinktext":
				return By.partialLinkText(locatorValue);
			case "cssselector":
			case "css":
				return By.cssSelector(locatorValue);
			case "xpath":
				return By.xpath(locatorValue);
			default:
				throw new Exception("Unknown locator type '" + locatorType + "'");
			}
		}
	   
	   protected AndroidElement getObject(String pathKey, Properties prop) {

		   AndroidElement obj = null;
			
			try {
				obj = (AndroidElement) driver.findElement(getLocator(pathKey, prop));
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			return obj;
		}
		
		protected AndroidElement getObject(String pathKey)  {
			
			return getObject(pathKey, OR);
		}
		
		public void setText(String obj, String text){
			
			getObject(obj).click();
			getObject(obj).setValue(text);
			driver.pressKeyCode(66);
		}
}
