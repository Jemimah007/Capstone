package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static String value;

	// Browser-1
	public static WebDriver setUp(String type) {

		if (type.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (type.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (type.equalsIgnoreCase("Opera")) {

			WebDriverManager.operadriver().setup();

			driver = new OperaDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	// browser close -2
	public static WebDriver closeBrowser() {
		driver.close();
		return driver;
	}

	// browser quit -3
	public static WebDriver tearDown() {
		driver.quit();
		return driver;
	}

	// Url -4
	public static WebDriver navigateTo(String type) {
		driver.navigate().to(type);
		return driver;
	}

	// NavigateBack -5
	public static WebDriver navigateBack() {
		driver.navigate().back();
		return driver;

	}
	
	//NavigateForward -6
	public static WebDriver navigateForward() {
		driver.navigate().forward();
		return driver;

	}
	
	//refreshPage -7
	public static WebDriver refreshPage() {
		driver.navigate().refresh();
		return driver;

	}

	// Url -8
	public static WebDriver openUrl(String url) {
		driver.get(url);
		return driver;
	}
	
	//AlertsAccept -9
	public static WebDriver acceptAlert() {
		driver.switchTo().alert().accept();
		return driver;

	}
	
	//AlertDismiss -10
	public static WebDriver dismissAlert() {
		driver.switchTo().alert().dismiss();
		return driver;

	}
	
	//AlertInput -11
	public static WebDriver promptAlert(String input) {
		driver.switchTo().alert().sendKeys(input);
		return driver;

	}

	// Actions Class -12
	public static WebDriver actionsMethods(String input, WebElement element) {
		Actions act = new Actions(driver);

		if (input.equalsIgnoreCase("rightClick")) {
			act.contextClick().build().perform();
		}

		else if (input.equals("leftClick")) {
			act.click().build().perform();
		} 
		
		else if (input.equals("movetoElement")) {

			act.moveToElement(element).build().perform();

		}

		return driver;

	}
	
	//SelectClass -13
	public static void dropDown(WebElement element,String type,String value) {
		Select s = new Select(element);
		
		if (type.equalsIgnoreCase("selectValue")) {
			s.selectByValue(value);						
		}
		else if (type.equalsIgnoreCase("selectText")) {
			s.selectByVisibleText(value);
		}
		else if (type.equalsIgnoreCase("selectIndex")) {
			int a = Integer.parseInt(value);
			s.selectByIndex(a);
		}

	}
	
	//ISELementMultiple -14
	public static void isElementMultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();

	}
	

	// SwitchToWindows 15
	public static WebDriver switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
		return driver;
	}
	
	//GetPageTitle -16
	public static WebDriver getPageTitle() {
		driver.getTitle();
		return driver;
	}
	
	//SwitchToFrame -17
	 public static WebDriver switchToFrame(int index) {
	        driver.switchTo().frame(index);
	        return driver;
	    }
	  
	 //SendKeys -18
	 public static void inputValueElement(WebElement element,String value) {
		 element.sendKeys(value);
		 
	}
	 
	 //Click -19
	 public static void clickOnElement(WebElement element) {
		 element.click();
	}
	 
	 //IsEnabled -20
	 public static void isElementEnabled(WebElement element) {
		 element.isEnabled();
		 
	}
	 
	 //IsDisplayed -21
	 public static void isElementDisplayed(WebElement element) {
		 element.isDisplayed();
	}
	 
	 //IsSelected -22
	 public static boolean isElementSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	 
	 //GetCurrentURL -23
	 public static WebDriver getPageUrl() {
		driver.getCurrentUrl();
		return driver;
	}
	 
	 //GetPageAttribute -24
	 public static void getPageAttribute(WebElement element,String value) {
		 element.getAttribute(value);
	}
	 
	 //TakesScreenshot -25
	 public static void screenshot(String path) throws IOException {
		 TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(path);
			FileUtils.copyFile(source,target);
			//FileHandler.copy(source, target);

	}
	 
	 //CheckBox -26
	 public static void checkTheBox(WebElement element) {
		 element.click();
	}
	 
	 //RadioButton - 27
	 public static void radioButton(WebElement element) {
		 element.click();
	} 
	 //Is Multiple - 28
	 public static void isMultipleSelected(WebElement element) {
			Select s = new Select(element);
			boolean multiple = s.isMultiple();

		}
	 
	 public static String readData(String path,int sheetIndex, int rowIndex, int cellIndex) throws IOException {
		
		 File f = new File(path);
		 FileInputStream fis = new FileInputStream(f);
		 
		 Workbook wb = new XSSFWorkbook(fis);
		 
		 Sheet sheetAt = wb.getSheetAt(sheetIndex);
		 Row row = sheetAt.getRow(rowIndex);
		 Cell cell = row.getCell(cellIndex);
		 CellType cellType = cell.getCellType();
		 if (cellType.equals(CellType.STRING)){
				
				String stringCellValue = cell.getStringCellValue();
				
				value = cell.getStringCellValue();
				
				
			}
				else if (cellType.equals(CellType.NUMERIC)) {
					
					double numericCellValue = cell.getNumericCellValue();
					
					int data = (int) numericCellValue;
					
					value =  String.valueOf(data);
				}
		 wb.close();
		 return value;
		
		 
	}
	 

		 
	}
	 
	 
	 
	 


