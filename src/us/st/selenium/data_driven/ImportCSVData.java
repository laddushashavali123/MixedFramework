package us.st.selenium.data_driven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;


import java.io.*;
import java.util.*;


	@RunWith(value=Parameterized.class)
public class ImportCSVData {
	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	private String height;
	private String weight;
	private String bmi;
	
	
	@Parameters
	public static Collection testData() throws IOException{
		return getTestData("C:/testData.csv");
	}
	
	public ImportCSVData(String height, String weight, String bmi) {
		this.height=height;
		this.weight=weight;
		this.bmi=bmi;
	}
	
	public static Collection<String[]> getTestData(String fileName) throws IOException{
		List<String[]> records = new ArrayList<String[]>();
		int i=0;
		String record;
		
		
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		 
		while ((record=file.readLine())!=null){
		if (record.trim().length() == 0 ) {
		continue;  // Skip blank lines
		}
		if (record.contains("#")) {
			continue;  //Skip string if string contains #
			}
		//skip first string
		if (i!=0){
		String fields[] = record.split(",");
		records.add(fields);
			}
		i++;
		}
		file.close();
		
		return records;
	}
	
	
	
	@Before
	public void setUp(){
		driver = new ChromeDriver();
		driver.get("http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi-m.htm");
	}
	
	@Test
	public void testBMICalculator() throws Exception {
		try{
			
		WebElement heightField = driver.findElement(By.xpath("//input[@id='htc']"));
		heightField.clear();
		heightField.sendKeys(height);
		
		WebElement weightField = driver.findElement(By.xpath("//input[@id='kg']"));
		weightField.clear();
		weightField.sendKeys(weight);
		
		WebElement calculateButton = driver.findElement(By.xpath("//input[@type='button']"));
		calculateButton.click();
		
		WebElement bmiLabel = driver.findElement(By.xpath("//*[@id='yourbmi']"));
		assertEquals(bmi, bmiLabel.getAttribute("value"));
		
		driver.quit();
}
		
		catch (Error e){
			//Capture and append exception errors
		verificationErrors.append(e.toString());
		System.err.println("Assertion Fail " + verificationErrors.toString());
		}
	}
	
	@After
	public void tearDown(){
		//Close the browser
		driver.quit();
		
		String verificationErrorString=verificationErrors.toString(); 
		if(!"".equals(verificationErrorString)) {
		}
	}
	
}


