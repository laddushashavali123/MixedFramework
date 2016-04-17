package us.st.selenium.browsers;

import org.junit.Test;
import java.io.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IESample {

	@Test
	public void simpleRun() {
		File file = new File("C:/auto_tools/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		InternetExplorerDriver driver = new InternetExplorerDriver();
		driver.get("http://google.com");
			
		
		
	}

	@Test
	public void runCustomized() throws InterruptedException{
		
		InternetExplorerDriverService service = new InternetExplorerDriverService.Builder()
		.usingDriverExecutable(new File("C:/auto_tools/IEDriverServer.exe"))
		.build();
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS , false);
		
		InternetExplorerDriver driver = new InternetExplorerDriver(service, caps);
		driver.get("http://google.com/");
		Thread.sleep(4000);
		driver.get("http://seleniumhq.org/");
		driver.quit();
		Thread.sleep(4000);
	}
}
