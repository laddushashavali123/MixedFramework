package us.st.selenium.extension;


import org.junit.After;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.junit.Assert;

import org.apache.commons.io.FileUtils;




public class CompareImageUtil {
	
	private StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver;

	public static BufferedImage getDifferenceImage(BufferedImage img1, BufferedImage img2){
		
		int width1 = img1.getWidth(); // Change - getWidth() and getHeight() for BufferedImage
	    int width2 = img2.getWidth(); // take no arguments
	    int height1 = img1.getHeight();
	    int height2 = img2.getHeight();
	    if ((width1 != width2) || (height1 != height2)) {
	        System.err.println("Error: Images dimensions mismatch");
	        System.exit(1);
	    }
	    
	 // NEW - Create output Buffered image of type RGB
	    BufferedImage outImg = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_RGB);
	    
	 // Modified - Changed to int as pixels are ints
	    int diff;
		int result;
	    
	    for (int i = 0; i < height1; i++) {
	        for (int j = 0; j < width1; j++) {
	            int rgb1 = img1.getRGB(j, i);
	            int rgb2 = img2.getRGB(j, i);
	            int r1 = (rgb1 >> 16) & 0xff;
	            int g1 = (rgb1 >> 8) & 0xff;
	            int b1 = (rgb1) & 0xff;
	            int r2 = (rgb2 >> 16) & 0xff;
	            int g2 = (rgb2 >> 8) & 0xff;
	            int b2 = (rgb2) & 0xff;
	            diff = Math.abs(r1 - r2); // Change
	            diff += Math.abs(g1 - g2);
	            diff += Math.abs(b1 - b2);
	            diff /= 3; // Change - Ensure result is between 0 - 255
	            // Make the difference image gray scale
	            // The RGB components are all the same
	            result = (diff << 16) | (diff << 8) | diff;
	            outImg.setRGB(j, i, result); // Set result
	        }
	    }
	    // Now return
	    return outImg;
	}
	public boolean ShoudICreateFile(BufferedImage img) throws IOException{
		boolean result=false;
		ByteArrayOutputStream tmp = new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", tmp);
		tmp.close();
		Integer contentLength = tmp.size();
		
		if (contentLength.intValue() > 20000){
			result=true;
		}
		return result;
	}
	
	
	@Before
	public void setUp() throws Exception{
		driver= new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGoogleImage() throws IOException, InterruptedException{
		driver.get("https://www.google.com/?gws_rd=ssl");
		Thread.sleep(2000);
		
		try {
		File srcFile = new File("resources/googleSrc.jpg");
		File baseFile = new File("resources/googleBase.jpg");
		File diffFile = new File("resources/googlediff.jpg");
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, srcFile);
		BufferedImage buFileSrc = ImageIO.read(srcFile);
		BufferedImage buFileBase = ImageIO.read(baseFile);
		BufferedImage buFilediff = getDifferenceImage(buFileSrc, buFileBase);
		
		if (buFileSrc.getHeight()!=buFileBase.getHeight() || 
			buFileSrc.getWidth()!=buFileBase.getWidth()){
			System.out.println("Dimensions of images are different");
			System.out.println("Size of SRC Image: "+buFileSrc.getHeight()+" x " + buFileSrc.getWidth());
	        System.out.println("Size of Base Image: "+buFileBase.getHeight()+" x " + buFileBase.getWidth());
	        Assert.fail("Images have different size");
		}
		//check if diff file is not empty
		//System.out.println(buFilediff.toString().split(BufferedImage@));

		if (ShoudICreateFile(buFilediff)){
		
			ImageIO.write(buFilediff, "jpg", diffFile);
			System.out.println("See diff image here: "+ diffFile.getAbsolutePath());
			Assert.fail("Images are different see diffImage");
			
		}
		} catch (IOException e) {
			e.printStackTrace();
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

	/*
	 * implementation using buffer compare image and dimension of image
	 *  		
	        BufferedImage bufileInput = ImageIO.read(srcFile);
	        DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
	        int sizefileInput = dafileInput.getSize();  
	        
	        BufferedImage bufileOutPut = ImageIO.read(baseFile);
	        DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();
	        int sizefileOutPut = dafileOutPut.getSize();
	                
	        Boolean matchFlag = true;
	        if(sizefileInput == sizefileOutPut) {                         
	           for(int j=0; j<sizefileInput; j++) {
	                 if(dafileInput.getElem(j) != dafileOutPut.getElem(j)) {
	                       matchFlag = false;
	                       Assert.assertTrue("Images are not equal", matchFlag);
	                       break;
	                 }
	            }
	        } else{                           
	           matchFlag = false;
	           
	        System.out.println("Size of Base Image: "+bufileInput.getHeight()+" x " + bufileInput.getWidth());
	        System.out.println("Size of Base Image: "+bufileOutPut.getHeight()+" x "+ bufileOutPut.getWidth());
	        Assert.assertTrue("Images have different size", matchFlag);
	        
	        }
	*/

