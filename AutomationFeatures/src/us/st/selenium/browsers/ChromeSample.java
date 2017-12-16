package us.st.selenium.browsers;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.*;


public class ChromeSample {

	@Test
	public void simpleRun() {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:/auto_tools/chromedriver.exe"))
				.usingAnyFreePort()
				.withLogFile(new File("C:/auto_tools/chromeLog.log"))
				.build();
		ChromeDriver driver = new ChromeDriver(service);
			driver.get("http://google.com");
				}
	
	@Test
	public void runFromNonStandardLocation(){
		ChromeOptions options = new ChromeOptions();
		
				options.setBinary(new File("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"));
				
				ChromeDriver driver= new ChromeDriver(options);
						driver.get("http://google.com");
	}
	
	@Test
	public void runWithExistingProfile(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=/home/user/.a5", "--app=http://127.0.0.1");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://google.com");
	}

	@Test
	public void runWithExtension(){
		
		ChromeOptions options = new ChromeOptions();
		
		options.addExtensions(new File("C://auto_tools/extentsion.extz")); //here I have put wrong extension
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://google.com");
		driver.quit();	
	}
	
	@Test
	public void runThroughProxy(){
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--proxy-server=http://localhost:8080");
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("http://google.com");
	}
}
