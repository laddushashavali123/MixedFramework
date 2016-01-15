package us.st.selenium.data_driven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.util.*;



@RunWith(value=Parameterized.class)
public class ImportExelData {

	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	private String height;
	private String weight;
	private String bmi;
	
	
@Parameters
public static Collection testData() throws Exception{
	InputStream spreadsheet = new FileInputStream("C:/Users/Zodiactester/Desktop/Selenium_tests/SeleniumIntermediate/resources/Data.xls");
	return new SpreadsheetData(spreadsheet).getData();
	
}
public ImportExelData(String height, String weight, String bmi){
	this.height=height;
	this.weight=weight;
	this.bmi=bmi;
}

@Before
public void setUp() throws Exception{
	driver = new FirefoxDriver();
	driver.get("http://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi-m.htm");	
}
	@Test
	public void test() {
	try{
		WebElement heightField = driver.findElement(By.xpath("//input[@id='htc']"));
		heightField.clear();
		if(!height.equals(null)){
		heightField.sendKeys(height);
		}
		
		WebElement weightField = driver.findElement(By.xpath("//input[@id='kg']"));
		weightField.clear();
		if(!weight.equals(null)){
		weightField.sendKeys(weight);
		}
		
		WebElement calculateButton = driver.findElement(By.xpath("//input[@type='button']"));
		calculateButton.click();
		
		WebElement bmiLabel = driver.findElement(By.xpath("//*[@id='yourbmi']"));
		
		if(!bmi.equals(null)){
		assertEquals(bmi, bmiLabel.getAttribute("value"));
		}
	}
	catch (Error e){
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

class SpreadsheetData{
	
	private transient Collection data = null;
	public SpreadsheetData(final InputStream exelInputStream) throws IOException{
		this.data=loadFromSpreadSheet(exelInputStream);
	}
	
public Collection getData(){
		return data;
	}
	
private Collection loadFromSpreadSheet(final InputStream excelFile) throws IOException{
		HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
		data = new ArrayList();
		Sheet sheet = workbook.getSheetAt(0);
		int numberofColums = countNonEmptyColumns(sheet);
		List rows = new ArrayList();
		List rowData = new ArrayList();
		for (Row row: sheet){
			if(isEmpty(row)){
				break;
			} else {
				rowData.clear();
				for (int column =0; column< numberofColums; column++){
					Cell cell = row.getCell(column);
					rowData.add(objectFrom(workbook,cell));
				}
				rows.add(rowData.toArray());
			}
		}
		return rows;
	}
private boolean isEmpty(final Row row) {
    Cell firstCell = row.getCell(0);
    boolean rowIsEmpty = (firstCell == null)
                    || (firstCell.getCellType() == Cell.CELL_TYPE_BLANK);
    return rowIsEmpty;
}

/**
* Count the number of columns, using the number of non-empty cells in the
* first row.
*/

private int countNonEmptyColumns(final Sheet sheet) {
    	Row firstRow = sheet.getRow(0);
		return firstEmptyCellPosition(firstRow);
	}
private int firstEmptyCellPosition(final Row cells) {
         int columnCount = 0;
         for (Cell cell : cells) {
                 if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                         break;
                 }
                 columnCount++;
         }
         return columnCount;
 }

 private String objectFrom(final HSSFWorkbook workbook, final Cell cell) {
         String cellValue = null;

         if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                 cellValue = cell.getRichStringCellValue().getString();
         } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                 cellValue = getNumericCellValue(cell).toString();
         } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                 cellValue = String.valueOf(cell.getBooleanCellValue());
         } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                 cellValue = String.valueOf(evaluateCellFormula(workbook, cell));
         }

         return cellValue;

 }

 private Object getNumericCellValue(final Cell cell) {
         Object cellValue;
         if (DateUtil.isCellDateFormatted(cell)) {
                 cellValue = new Date(cell.getDateCellValue().getTime());
         } else {
                 cellValue = cell.getNumericCellValue();
         }
         return cellValue;
 }

 private Object evaluateCellFormula(final HSSFWorkbook workbook,
                 final Cell cell) {
         FormulaEvaluator evaluator = workbook.getCreationHelper()
                         .createFormulaEvaluator();
         CellValue cellValue = evaluator.evaluate(cell);
         Object result = null;

         if (cellValue.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                 result = cellValue.getBooleanValue();
         } else if (cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                 result = cellValue.getNumberValue();
         } else if (cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
                 result = cellValue.getStringValue();
         }

         return result;
 }
}

	


