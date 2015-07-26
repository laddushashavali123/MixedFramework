package demoRC;
import com.thoughtworks.selenium.*;

public class rcDemo {
	public static void main(String[] args) throws InterruptedException 
	{
		// Instantiate the RC Server
		Selenium selenium = new DefaultSelenium("localhost", 4444, "firefox", "http://www.calculator.net");
		selenium.start(); //start
		selenium.open("/"); //open the url
		selenium.windowMaximize();
		
		//click on Link Math Calculator
		selenium.click("xpath=.//*[@id='part11']/table/tbody/tr[1]/td[5]/center/a/font");
		Thread.sleep(2500); //wait to load page
		
		//focus on text box
		selenium.focus("name=amount");
	}

}
