package us.st.selenium.protocols;

import static org.junit.Assert.*;
import java.lang.System;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ConsoleOutputToMySql extends JUnitTestBase {

	private static final Logger LOG = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ConsoleOutputToMySql.class);

	private RemoteWebDriver driver;
	
	static {
System.setProperty("logback.configurationFile", "D:/Selenium_2.0/Selenium_tests/SeleniumIntermediate/src/logback.xml");
}

	public void main (String[] args) {

}
	
	
	@Before
	
	public void initDriver(){
		LOG.debug("Starting Firefox");
		driver = new FirefoxDriver();
		LOG.debug("Firefox started");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void sampletest() throws Exception {
		LOG.info("Started sampletest");
		LOG.info("Go to main page");
		driver.get("http://php4dvd.com.ua");
		LOG.info("login as admin / admin");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).sendKeys(Keys.RETURN);
		Thread.sleep(4000);
		
		LOG.info("logout");
		driver.findElement(By.xpath("//header//li[4]/a")).click();
		driver.switchTo().alert().accept();	
		LOG.info("Finished sampleTest");
	}
	
	@After
	
	public void stopDriver(){
		LOG.debug("Firefox finished");
		driver.quit();
	}

}
