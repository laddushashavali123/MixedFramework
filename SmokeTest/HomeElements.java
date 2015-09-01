package wwwtest;

import org.junit.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Point;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  HomeElements {

	
	@Test	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();   //opens firefox
		driver.manage().window().maximize();    //maximizes window
		driver.get("http://www.famous-smoke.com");  //gets home page
		List<WebElement> list=driver.findElements(By.xpath("//*[@href or @src]"));
		WebElement Image = driver.findElement(By.cssSelector(".logo.desktop"));  //assign web element name to element for getting size
		int ImageHeight = Image.getSize().getHeight(); //assign height to integer name ImageHeight
		int ImageWidth = Image.getSize().getWidth();  //assign width to integer name ImageWidth
		
		
		
		//Count of the links on the entire page.
		System.out.println("Links on the page. Should be 255:");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer=driver.findElement(By.xpath(".//*[@id='top']/div[3]/div[5]/div"));
		System.out.println("Links in the footer. Should be 33.");
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		if( driver.findElement(By.cssSelector(".logo.desktop")).isDisplayed() && //site logo
		
		( driver.findElement(By.cssSelector(".topmenu")).isDisplayed() && // links on top of cartslider
				( driver.findElement(By.cssSelector(".headcart.menu.oswald>a")).isDisplayed() &&  //cartslider
						( driver.findElement(By.cssSelector(".promobanner>img")).isDisplayed() && //promo banner
								( driver.findElement(By.cssSelector(".headerright")).isDisplayed() ))))) //search box, start learning, your account, save up to 20%
						
			System.out.println("The header section of the site loads");
			

		if( driver.findElement(By.cssSelector(".homepageBanner")).isDisplayed() && //site logo
		( driver.findElement(By.cssSelector(".headmenu")).isDisplayed() )) // links on top of cartslider
		
			System.out.println("Middle of page and menu loads.");
		
		if( driver.findElement(By.cssSelector(".desktop.tablet>p")).isDisplayed() && //site logo
		( driver.findElement(By.cssSelector(".topbrands")).isDisplayed() && // links on top of cartslider
				( driver.findElement(By.cssSelector(".guarentee-text.triggertarget")).isDisplayed() &&  //cartslider
						( driver.findElement(By.cssSelector(".home-textblock")).isDisplayed() && //promo banner
								( driver.findElement(By.cssSelector(".footerbox.firstfooter")).isDisplayed() &&
										( driver.findElement(By.cssSelector(".minors-copy.eighty.left")).isDisplayed() && //search box, start learning, your account, save up to 20%
												( driver.findElement(By.cssSelector(".footerbottombox")).isDisplayed() )))))))
			System.out.println("Brands and footer load");
			

	       for(WebElement e : list){
	           String link = e.getAttribute("href");
	           if(null==link)
	               link=e.getAttribute("src");
	           System.out.println(e.getTagName() + "=" + link);
	       }
	     


	       }


