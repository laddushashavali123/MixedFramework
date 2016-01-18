package us.ebay.revise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.Submit;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class EbayRevise extends TestCase
{
	private static StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static Select dropdwn;
	private boolean acceptNextAlert = true;
	private static ArrayList<String> idArr;
	private String login;
	private String password;
	private String id;
	
@Parameters
public static Collection testCredentials(){
	return Arrays.asList(
			new Object[][]{
				{"XXXXXX", "XXXXXXX"}
			}
			);
}

public EbayRevise (String login, String password){
	this.login=login;
	this.password=password;
}

@Before
public void setUp() throws InterruptedException{
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	idArr = new ArrayList<String>();
	wait = new WebDriverWait(driver,20);
	driver.get("https://www.australianvaporizers.com.au/store/index.php/austral1a_adm1n");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='username']")));
}

@Test
    public void EbayReviseTest() throws InterruptedException{
	
	try{
	System.out.println("Login");
	driver.findElement(By.xpath("//*[@id='username']")).sendKeys(login);
	driver.findElement(By.xpath(".//*[@id='login']")).sendKeys(password);
	driver.findElement(By.xpath("//*[@id='loginForm']/div/div[5]/input")).submit();
	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id='ebayListingGrid_table']//tr//td[3]/span"))));
	System.out.println("Open each link except 'Don't List On eBay'");
	for (WebElement listing : driver.findElements(By.xpath("//*[@id='ebayListingGrid_table']//tr//td[3]/span"))){
	if (listing.getText()!="Don't List On eBay"){
		idArr.add(listing.findElement(By.xpath("../../td[2]")).getText());
	}
	}
	System.out.println(idArr.toString());
		
	for (int j =0; j<=idArr.size();j++){
		id=idArr.get(j).toString();
		System.out.println("current id: "+id);
		System.out.println("open #"+j+" listing");
		driver.findElement(By.xpath("//*[@id='listing_title_"+id+"']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"_table']//td[3]"))));
		Thread.sleep(2000);
		
		if(isElementPresent(By.xpath("//*[@id='block_notice_ebay_listings_view_grid']"))){
		driver.findElement(By.xpath("//*[@id='block_notice_ebay_listings_view_grid']//div[2]/a")).click();
		closeAlertAndGetItsText();
		}
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"_table']//td[3]"))));
		
	
		int num= Integer.parseInt(driver.findElement(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"']/table/tbody/tr/td[1]")).getText().split("Page of ")[1].split(" pages")[0]);
	
		for (int i=1; i<=num;i++){
			if(i>1){
		driver.findElement(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"']/table//input")).clear();
		driver.findElement(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"']/table//input")).sendKeys(Integer.toString(i) + Keys.ENTER);
		Thread.sleep(5500);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"_massaction']/table/tbody/tr/td[1]/a[3]")));
			}
			
		System.out.println("Revise items on ebay for " + i + " page");
		driver.findElement(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"_massaction']/table/tbody/tr/td[1]/a[3]")).click();
		dropdwn = new Select(driver.findElement(By.xpath("//*[@id='ebayListingViewGridEbay"+id+"_massaction-select']")));
		dropdwn.selectByValue("revise");
		driver.findElement(By.xpath("//fieldset//button")).click();
		wait = new WebDriverWait(driver, 5);
		if(wait.until(ExpectedConditions.alertIsPresent())!=null){
		closeAlertAndGetItsText();
		}
		wait =new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='listing_view_progress_bar']")));
		Thread.sleep(2500);
	}
		driver.findElement(By.xpath("//*[@id='html-body']/div[1]/div[1]/div[1]/a/img")).click();
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//*[@id='ebayListingGrid_table']//tr//td[3]/span"))));
	}
	}
	
    catch(Error e){
		//Capture and append exception errors
	verificationErrors.append(e.toString());
	System.err.println("Assertion Fail " + verificationErrors.toString());
	}
	
	}

@After
public void tearDown(){
		driver.quit();
		System.out.println("EbayRevise is completed");
}


private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
}

private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }



}
