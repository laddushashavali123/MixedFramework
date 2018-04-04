package com.docker.cucumber.steps;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;



public class BaseCucumberTest{

    private WebDriver driver;
    private Eyes eyes;
    
    public void setup() throws MalformedURLException {
    	if (SystemUtils.IS_OS_WINDOWS) {
    		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    	}
        if ((System.getenv("BROWSER") != null && System.getenv("BROWSER").equalsIgnoreCase("docker"))) {
            String hubUrl = System.getenv("HUB_URL") != null ? System.getenv("HUB_URL") : "http://localhost:4444/wd/hub";
            driver = new RemoteWebDriver(new URL(hubUrl), DesiredCapabilities.chrome());
        } else if ((System.getenv("BROWSER") != null && System.getenv("BROWSER").equalsIgnoreCase("browserstack"))) {
//            example config
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("browser", "Edge");
            desiredCapabilities.setCapability("browser_version", "16.0");
            desiredCapabilities.setCapability("os", "Windows");
            desiredCapabilities.setCapability("os_version", "10");
            desiredCapabilities.setCapability("browserstack.debug", "true");
            System.out.println(System.getenv());
            driver = new RemoteWebDriver(new URL("https://" + getEnvKey("BROWSERSTACK_USER") + ":" + getEnvKey("BROWSERSTACK_KEY") + "@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);

        } else {
        	
            driver = new ChromeDriver(new ChromeOptions().addArguments("headless"));
        	//driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (isEyesEnabled()) {
            eyes = new Eyes();
            eyes.setApiKey(getEnvKey("APPLITOOLS_KEY"));
            eyes.open(driver, "cucumber", "cucumber tests", new RectangleSize(800, 600));
        }
    }

    public void tearDown() {
        driver.quit();
        if (isEyesEnabled())
            eyes.close();
    }

    WebDriver getDriver() {
        return driver;
    }

    private Eyes getEyes() {
        return eyes;
    }

    private boolean isEyesEnabled() {
        return System.getenv("CHECK_IMAGE") != null && System.getenv("CHECK_IMAGE").equalsIgnoreCase("true");

    }

    void checkPage(String testTitle) {
        if (isEyesEnabled())
            getEyes().checkWindow(testTitle);
    }

    private String getEnvKey(String key) {
        if (System.getenv(key) == null)
            throw new IllegalArgumentException(key + " not set!");
        return System.getenv(key);
    }

}
