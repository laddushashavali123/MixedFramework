package wwwtest;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;


	
public class placeorderwspecialofferitems {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://testing.famous-smoke.com"); 
	  driver.findElement(By.xpath("//*[@id='top']/div[3]/div[1]/div[6]/div[5]/div/a/div[1]/span[1]")).click();           //Clicks login
	   	
	   	
	   	 Thread.sleep(3000); //waits 3 seconds before continuing.
	   	Actions abc=new Actions(driver);
	   	WebElement xyz=driver.findElement(By.xpath("//*[@id='loginform']/div[1]/input"));
	   	abc.click(xyz).sendKeys("abrocker@gmail.com").build().perform(); //inputs email 

	   	WebElement xyz1=driver.findElement(By.xpath("//*[@id='loginform']/div[2]/input[3]"));
	   	abc.click(xyz1).sendKeys("hiaslpix1").build().perform(); //inputs password using lower case letters.

	   	
	   	driver.findElement(By.xpath("//*[@id='login-submit']/span[1]")).click(); //click submit button
	   	Thread.sleep(5000);

	   	WebElement element=driver.findElement(By.xpath(".//*[@id='top']/div[3]/div[1]/div[5]/div[2]/div/a/span[2]")); //hovers over the menu to display it
	   	abc.moveToElement(element).build().perform();
		 Thread.sleep(3000);
		   	WebElement element2=driver.findElement(By.xpath(".//*[@id='top']/div[3]/div[1]/div[5]/div[2]/div/ul/li[2]/a")); //hovers over the cigars menu to display it
		   	abc.moveToElement(element2).build().perform();

	   	driver.findElement(By.xpath(".//*[@id='top']/div[3]/div[1]/div[5]/div[2]/div/ul/li[2]/ul/li/ul[1]/li[2]/a")).click(); //Clicks Cigar Search
		 Thread.sleep(3000);
		if( driver.findElement(By.cssSelector(".logo.desktop")).isDisplayed() && //site logo
				
		( driver.findElement(By.cssSelector(".topmenu")).isDisplayed() && // links on top of cartslider
				( driver.findElement(By.cssSelector(".headcart.menu.oswald>a")).isDisplayed() &&  //cartslider
						( driver.findElement(By.cssSelector(".promobanner>img")).isDisplayed() && //promo banner
								( driver.findElement(By.cssSelector(".headerright")).isDisplayed() ))))) //search box, start learning, your account, save up to 20%
						
			System.out.println("The header section of the cigar search page loads");
		if( driver.findElement(By.cssSelector(".title.oswald")).isDisplayed() && //h1
				
		( driver.findElement(By.cssSelector(".page-copy.smallfont")).isDisplayed() && // seo
				( driver.findElement(By.cssSelector(".headcart.menu.oswald>a")).isDisplayed() &&  //menu
						( driver.findElement(By.cssSelector(".filterbox")).isDisplayed() ))))//filters

						
			System.out.println("H1, SEO, Filters present.");
	   	driver.findElement(By.xpath(".//*[@id='top']/div[3]/div[3]/div[5]/div[3]/a[3]/div/img")).click(); //clicks acid blondie picture to load slideview
	   	Thread.sleep(3000);
	   	driver.findElement(By.xpath(".//*[@id='top']/div[3]/div[3]/div[5]/div[3]/div/div[3]/div[1]/div[1]/div[2]/a/span[1]")).click();
		 Thread.sleep(3000);
		   	driver.findElement(By.xpath(".//*[@id='top']/div[5]/div/div[7]/div[3]/a/div/div[1]/div[1]/span[1]")).click();
			 Thread.sleep(3000);
		   	if( driver.findElement(By.cssSelector(".cart_title")).isDisplayed() && //cart amt
					
		   			( driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[2]/a[2]")).isDisplayed() && // seo
		   					( driver.findElement(By.xpath(".//*[@id='main']/div/div[1]/div[3]/a[2]")).isDisplayed() &&  //menu
		   							( driver.findElement(By.cssSelector(".//*[@id='main']/div/div[2]/div[1]")).isDisplayed() ))))//cart buttons

		   							
		   				System.out.println("H1, SEO, Filters present.");
	}
}
