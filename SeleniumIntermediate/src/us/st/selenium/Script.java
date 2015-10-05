package us.st.selenium;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.lang.System;
import java.util.Arrays;
import java.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.junit.Test;

public class Script {

	public static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException{

		driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }

	
	@Test
	public void test() throws InterruptedException {
		driver = new FirefoxDriver();
		Actions act = new Actions(driver);
		driver.get("http://mygirlfund.com");
		driver.findElement(By.id("email")).sendKeys("R_O_Y@list.ru");
		driver.findElement(By.id("password")).sendKeys("725671sqripT");
		driver.findElement(By.id("btn-submit")).submit();
		//driver.findElement(By.xpath(".//*[@id='btn-2i']/a")).click();
//navigation through pages
		for(int i=1;i<=3; i++){
		driver.get("http://mygirlfund.com/boys/thegirls.paging.page/"+i);
		for(WebElement link : driver.findElements(By.xpath("//img[@alt='Online Now!']/../..//a"))){
				
				String originalWindow =driver.getWindowHandle();
				System.out.println("Original handle is: "+ originalWindow);
//open link in new window
				act.contextClick(link).perform();
				act.sendKeys("w").perform();
				
				Thread.sleep(4000);
				for (String newWindow : driver.getWindowHandles())
				{
				driver.switchTo().window(newWindow); 
				System.out.println("NOW THE CURRENT Handle is: "+ newWindow);
				}
				Thread.sleep(2000);
//here write a message
/*
				driver.findElement(By.xpath("//*[@id='messageForm']/input[1]")).sendKeys("new mail");
				driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='messageForm']//tr[2]/td/iframe")));
				WebElement textarea = driver.findElement(By.id("tinymce"));
				textarea.click();
				textarea.sendKeys("Hi, how are you?");
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath("//div[@id='send-message']//button")).submit();
*/				
				
				driver.close();
				driver.switchTo().window(originalWindow);
				//i++;
		}
		}
	}
	}




/*Working window handling
 * 
for(String newWindow : driver.getWindowHandles()) {
				       if(!newWindow.equals(originalWindow)){
				                System.out.println("Child handle is: "+ newWindow);
				              //Sleeping for 4 seconds for detecting Child window
				Thread.sleep(2000);
								
				try{
                    Thread.sleep(4000);
                   }catch(InterruptedException e){
                    System.out.println("Caught exception related to sleep:"+e.getMessage());
                   }
                driver.switchTo().window(newWindow);
                break;
            }
    } 

    System.out.println("AFTER SWITCHING, Handle is: "+driver.getWindowHandle());

    driver.close();
  //Sleeping for 4 seconds for detecting Parent window
    try{
        Thread.sleep(4000);
       }catch(InterruptedException e){
        System.out.println("Caught exception related to sleep:"+e.getMessage());
       }

    driver.switchTo().window(originalWindow); // Switching back to parent window

     System.out.println("NOW THE CURRENT Handle is: "+driver.getWindowHandle());

     //Now perform some user action here with respect to parent window to assert that the window has switched properly


} 

 */


