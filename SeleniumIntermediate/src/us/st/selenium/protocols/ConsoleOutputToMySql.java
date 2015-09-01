package us.st.selenium.protocols;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import ch.qos.logback.core.db.ConnectionSource;
import ch.qos.logback.classic.db.DBAppender;

public class ConsoleOutputToMySql {

private RemoteWebDriver driver;
	
	private static Logger LOG = LoggerFactory.getLogger(ConsoleOutputToMySql.class);
	
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
