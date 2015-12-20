package us.st.selenium.data_driven;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class TestDataDriven {

	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	
	@Parameters
	//array with data
	public static Collection testData() {
		return Arrays.asList(
				new Object [] []{
					{"160", "45", "17.6", "Underweight"},
					{"168", "70", "24.8", "Normal"},
					{"181", "89", "27.2", "Overweight"},
					{"178", "100", "31.6", "Obesity"}
				});
	}
	//created a constructor
	public TestDataDriven(String height, String weight, String bmi, String bmiCategory ) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}

	@Test
	public void testBMICalculator() throws Exception {
		driver.get("http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi-m.htm");
		
		WebElement heightField = driver.findElement(By.xpath("//input[@id='htc']"));
		heightField.clear();
		heightField.sendKeys(height);
		
		WebElement weightField = driver.findElement(By.xpath("//input[@id='kg']"));
		weightField.clear();
		weightField.sendKeys(weight);
		
		WebElement calculateButton = driver.findElement(By.xpath("//input[@type='button']"));
		calculateButton.click();
		
		try{
			WebElement bmiLabel = driver.findElement(By.xpath("//*[@id='yourbmi']"));
			assertEquals(bmi, bmiLabel.getAttribute("value"));
		//finish it
		
		
		}
		catch (Error e){
			
		}
	}

}
