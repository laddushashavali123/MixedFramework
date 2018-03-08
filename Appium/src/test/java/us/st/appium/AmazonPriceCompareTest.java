package us.st.appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/*
 * 
 * 	•  Install a price comparison application on the test device.
	•  Select an electronics gadget
	• Output the site’s rating of the item.
	• Select the option to compare prices for the tablet.
	• Output the third lowest price reported for the tablet.
	
	====================================================================
	•  Test is running on Amazon Shopping app.
	•  Look for Samsung Galaxy S8
	•  Put in hashMap phones with prices from first 40 listings
	•  Out put 3rd minimum price from phones we have found
	
 * 
 */

public class AmazonPriceCompareTest extends TestBase {
  
	AppiumServerJava app;
	protected String appLocation = "resourses/apk/";
	protected String appName = "Amazon-Shopping.apk";
	protected final static String deviceName = "FA53RYJ17472";
	protected final static String searchPattern = "Samsung  Galaxy  S8";
	protected final static String platformName = "Android";
	protected final static String ip = "127.0.0.1";
	protected final static int defaultPort = 4725;
	protected final static String PROP_FILE = "/ObjectRepo.properties";
	public Map<String, Double> items = new HashMap<String, Double>();
	public List<Double> minPrices = new ArrayList<Double>();
	
  
  @BeforeTest
  public void beforeTest() throws MalformedURLException, InterruptedException {
	  
	  /*
	  app = new AppiumServerJava();
	  app.startServer(ip, defaultPort);
	  System.out.println("Server is started!!!");
	  */
	  
	  /*
	  AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
	  service.start();
	 
	  service.stop();
	   */ 
	  
	  
	  //load properties
	  try {
		OR.load(AmazonPriceCompareTest.class.getResourceAsStream(PROP_FILE));
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("deviceName", deviceName);
	  capabilities.setCapability("platformName", platformName);
	  capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
	  capabilities.setCapability("appActivity", "com.amazon.mShop.search.RetailSearchActivity");
	 // capabilities.setCapability("app", appLocation+appName);
	  capabilities.setCapability("fastReset", "true");
	  capabilities.setCapability("noReset", "true");
	  capabilities.setCapability("fullReset", "false");
	  capabilities.setCapability("unicodeKeyboard", "true");                                     
	  capabilities.setCapability("resetKeyboard", "true");
	  
	  
	  driver = new AndroidDriver(new URL("http://"+ip+":"+defaultPort+"/wd/hub") , capabilities);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  wait = new WebDriverWait(driver, defaultTimeout);
	  Map<String, String> params = new HashMap<String, String>();
	  
	  waitForElVisibility("LNK_MAIN_LOGO");
	  System.out.println("I have launched app");
	  
  }
   
   @Test
   public void searchForDeviceTest() throws Exception {
	  
	  //search for item
	  setText("TXT_MAIN_Search", searchPattern);
	  waitForElVisibility("SWCH_SEARCH_PRIME");
	  
	  if(getObject("SWCH_SEARCH_PRIME").getAttribute("text").toLowerCase().equals("off")){
		  
		  getObject("SWCH_SEARCH_PRIME").click();
		  waitForElVisibility("TXT_SEARCH_PRIMELABEL");
	  }
	  
	  
	  boolean isPrimeItemsExist = driver.findElementsByXPath("//*[@text='Prime Eligible']").size() > 1;
	  int scrollTimes=0;
	  //will scroll no more then 20 times
      while (isPrimeItemsExist && scrollTimes<=20){
    	  System.out.println(scrollTimes);
    	  List<MobileElement> products= driver.
    			  findElementsByXPath("//*[contains(@resource-id,'list_product_linear_layout')]");
    	 
    	  for (MobileElement prod : products){
    		  
    		  driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    		  if(!prod.isDisplayed()){
    			  System.out.println("Element is not fully displayed");
    			  continue;
    		  }
    		  
    		 //get rid from sponsored elements
    		 try{
    			 
    			 prod.findElement(By.xpath(".//*[@text='Sponsored']"));
    			 System.out.println("This element is sponsored");
    			 continue; 
    		 }catch(Exception e){
    			 
    		 }
    		 
    		 double price;
    		 String title;
    		 try{
    			
	    		 price = Double.parseDouble(prod.findElement(By.
	    				 xpath(".//*[starts-with(@text,'$')]")).getAttribute("text").split(" ")[0].replace("$", ""))/100;
	    		 
    		 }catch(Exception e){
    			 
    			 System.out.println("Caught exception because items price is not fully visible.");
    			 continue;
    		 }	 
    		 
    		 try{
     			
    			 title = prod.findElement(By.xpath(".//*[contains(@resource-id,'item_title')]")).getText();
    			
    		 }catch(Exception e){
    			 
    			 System.out.println("Caught exception because items title is not fully visible.");
    			 continue;
    		 }	 
    		 
    		 
    		 //String rating = prod.findElement(By.xpath(".//*[contains(@resource-id,'rs_results_ratings')]")).getText();
    		 //System.out.println("Our items rating is "+rating);
    		 
    		 //tracking list of minimum prices;
    		 if(price<300){
    			 continue;
    		 }else if(minPrices.isEmpty()){
    			 minPrices.add(price);
    		 } else if(price<minPrices.get(minPrices.size()-1)){
    			 
    			 minPrices.add(price);
    		 }
    		 
    		 
    		
			 System.out.println("Our items title is "+title);
    		 System.out.println("Parsed price is " +price);
    		 items.put(title,price);
    		 
    	  }
    	  
    	  
    	  
    	  
    	  
    	  
          swipeVertical(driver,0.9,0.35,0.5,2000);
          Thread.sleep(2000);
          isPrimeItemsExist  = driver.findElementsByXPath("//*[@text='Prime Eligible']").size() > 1;
          ++scrollTimes;
      }
	  if(minPrices.size()>3){
		  System.out.println("==========>3d minimum price in our list: $"+minPrices.get(2));
	  }
	}
  
   @AfterTest
   public void finish(){
	   
	   driver.quit();
	   //app.stopServer();

   }
   public static void swipeVertical(AppiumDriver driver, double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
	    Dimension size = driver.manage().window().getSize();
	    int anchor = (int) (size.width * anchorPercentage);
	    int startPoint = (int) (size.height * startPercentage);
	    int endPoint = (int) (size.height * finalPercentage);
	    new TouchAction(driver).press(anchor, startPoint).waitAction(duration).moveTo(anchor, endPoint).release().perform();
	  }
   
}
