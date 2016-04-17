package us.st.selenium.protocols;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.logging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.st.selenium.protocols.TracingWebDriver;



public class JUnitTestBase {

	private static Logger Log = LoggerFactory.getLogger(JUnitTestBase.class);
	
	protected WebDriver driver;
	
	@Before
	public void initDriver(){
		Log.debug("Starting Firefox");
		//driver = new FirefoxDriver();
		driver = new TracingWebDriver(new FirefoxDriver());
		Log.debug("Firefox Started");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@After
	public void  stopDriver(){
		driver.quit();
	}
	
	@Rule
	public TestRule LogRule = new TestWatcher(){
		
	@Override
	protected void starting(Description description){
			super.starting(description);
			Log.info("<<< Test" + description);
	}
		
	@Override
	protected void finished(Description description){
			super.finished(description);
			Log.info("<<< Test" + description);
	}
	
	@Override
	protected void succeeded(Description description){
			super.succeeded(description);
			Log.info("<<< Test" + description);
	}
	
	@Override
	protected void failed(Throwable e, Description description){
		super.failed(e, description);
		Log.error("!!! Test failed" + description, e);
	}
	};
}
