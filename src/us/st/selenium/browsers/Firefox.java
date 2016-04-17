package us.st.selenium.browsers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;




import org.junit.Test;

public class Firefox {

	@Test
	public void simpleRun() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.quit();
	}
	
	@Test
	public void runFromNonStandartLocation(){
		FirefoxBinary binary = new FirefoxBinary(
				new File("C:/Program Files/Mozilla Firefox/firefox.exe")); //specify here location for custom browser
		
		FirefoxProfile profile = new FirefoxProfile();
		
		FirefoxDriver driver = new FirefoxDriver(binary, profile);
		driver.get("http://google.com/");
		//driver.quit();
		
	}

	@Test
	public void runWithLongerTimeout(){
		
		FirefoxBinary binary = new FirefoxBinary();
		binary.setTimeout(900000); //default is 45000
		
		FirefoxProfile profile = new FirefoxProfile();
		
		FirefoxDriver driver = new FirefoxDriver(binary, profile);
		driver.get("http://google.com");
		driver.quit();
		
	}

	@Test
	public void runWithCustomProfile() throws InterruptedException{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en-us, en");
		profile.setPreference("browser.download.dir","C:/temp");
		profile.setPreference("browser.download.folderList", 2);
		
		profile.setAssumeUntrustedCertificateIssuer(false);
		profile.setAcceptUntrustedCertificates(true);
		
		FirefoxDriver driver = new FirefoxDriver(profile);
		driver.get("http://ci.seleniumhq.org:8080/");
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		driver.quit();
	}

	@Test
	public void runWithExtensions() throws IOException{
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.addExtension(new File("C:/auto_tools/firebug@software.joehewitt.com.xpi"));
		profile.setPreference("extensions.firebug.currentVersion", "8.8.8");
		profile.setPreference("extensions.firebug.allPagesActivation", "on");
		profile.setPreference("extensions.firebug.defaultPanelName", "net");
		
		FirefoxDriver driver = new FirefoxDriver(profile);
		driver.get("http://google.com");
	}

	@Test
	public void runWithExistingProfile(){
		
	FirefoxProfile profile = new FirefoxProfile(new File("C:/Users/R_O_Y/AppData/Roaming/Mozilla/Firefox/Profiles/70qlsh9s.Selenium"));
		
	
	FirefoxDriver driver = new FirefoxDriver(profile);
		driver.get("http://facebook.com");
	}

	@Test
	public void runWithSynchroniezedEvents(){
	
		FirefoxProfile profile = new FirefoxProfile();
	
		//profile.setEnableNativeEvents(false); //default for Linux
		profile.setEnableNativeEvents(true); //default for Windows
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("nativeEvents", true);
		
		FirefoxDriver driver = new FirefoxDriver(caps);
		driver.get("http://google.com");
		System.out.println(driver.getCapabilities());
		driver.quit();
		
	}
}