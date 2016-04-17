package us.st.selenium;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Sample {
	
	private static WebDriverWait wait;
	private static WebDriver driver;
	
	@Test
	public void loadTest(){
		
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 20);
			
		
	long startTime= System.currentTimeMillis();
	long endTime;
	driver.get("http://www.wallpaper.com/");
	//right ad;
		wait .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='google_ads_iframe_/18711560/wallpaper/home_1__container__']"))));
		endTime=System.currentTimeMillis()- startTime;
		System.out.println("Loading of right add is "+ endTime+" milisec");
	
		//bottom, same ad;
		wait .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//*[@id='google_ads_iframe_/18711560/wallpaper/home_2__container__']"))));
		endTime=System.currentTimeMillis()- startTime;
		System.out.println("Loading of bottom add is "+ endTime+" milisec");
			
	//load top add;
	wait .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("html/body/div[1]/a"))));
	endTime=System.currentTimeMillis()- startTime;
	System.out.println("Loading of top add is "+ endTime+" milisec");
	
	//load full page;
	wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		endTime=System.currentTimeMillis()- startTime;
		System.out.println("Loading of full page is "+ endTime+" milisec");
		
		
	driver.quit();
	}

}
