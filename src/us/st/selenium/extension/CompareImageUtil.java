package us.st.selenium.extension;


import org.junit.After;
import org.junit.Assert.*;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;




public class CompareImageUtil {
	
	private StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver;
	private enum Result {Matched, SizeMismatch, PixelMismatch};
	//enum - this is data type to declare constants in Java
	
	
	private static Result CompareImage(String baseFile, String actualFile){
		
		Result compareResult = Result.PixelMismatch;
		Image baseImage = Toolkit.getDefaultToolkit().getImage(baseFile);
		Image actualImage = Toolkit.getDefaultToolkit().getImage(actualFile);
		
	try{
		PixelGrabber baseImageGrab = new PixelGrabber(baseImage, 0, 0, -1, -1, false);
		PixelGrabber actualImageGrab = new PixelGrabber(actualImage, 0, 0, -1, -1, false);
		
		int [] baseImageData = null;
		int [] actualImageData = null;
		
		if (baseImageGrab.grabPixels()){
			int width = baseImageGrab.getWidth();
			int height = baseImageGrab.getHeight();
			baseImageData = new int [ width * height ];
			baseImageData = (int[])baseImageGrab.getPixels();
		}
		
		if (actualImageGrab.grabPixels()){
			int width = actualImageGrab.getWidth();
			int height = actualImageGrab.getHeight();
			actualImageData = new int [width * height];
			actualImageData = (int[])baseImageGrab.getPixels();
		}
		
		System.out.println(baseImageGrab.getHeight() + "<>" +actualImageGrab.getHeight());
		
		System.out.println(baseImageGrab.getWidth() + "<>" +actualImageGrab.getWidth());
		
		if 	(baseImageGrab.getHeight() != actualImageGrab.getHeight()
			|| 	baseImageGrab.getWidth() != actualImageGrab.getWidth())
		{
			compareResult = Result.SizeMismatch;
		} else if (Arrays.equals(baseImageData, actualImageData)){
			compareResult = Result.Matched;
		}
		
	}catch(Exception e){
		
	}
	return compareResult;
}
	private static void TakeScreenshot(){
		  try{
			  BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			  ImageIO.write(image, "JPG", new File("C:/Users/yarkh/Desktop/Selenium_tests/SeleniumIntermediate/resources/googleBase.jpg"));
		  }
		  catch(Exception e){
			  e.printStackTrace();
		  }
	  }
	
	@Before
	public void setUp() throws Exception{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void testGoogleImage() throws IOException, InterruptedException{
		driver.get("https://www.google.com/?gws_rd=ssl");
		//TakeScreenshot();
		String srcFile = "C:/Users/yarkh/Desktop/Selenium_tests/SeleniumIntermediate/resources/googleSrc.jpg";
		String baseFile = "C:/Users/yarkh/Desktop/Selenium_tests/SeleniumIntermediate/resources/googleBase.jpg";
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(srcFile));
		
		try{
			assertEquals(Result.Matched,CompareImage(baseFile, srcFile));
		}
		catch (Error e){
			Thread.sleep(2000);
			System.out.println("images are not equal");
			verificationErrors.append(e.toString());
		}
	}
	
	@After
	public void tearDown() throws Exception{
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)){
			fail(verificationErrorString);
		}
		
	}
}
