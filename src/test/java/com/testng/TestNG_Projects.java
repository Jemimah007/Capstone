package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Projects {

	public static WebDriver driver;
	
	@Test(timeOut = 1 )
	private static void browser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Hp\\\\Desktop\\\\eclipse\\\\Selenium Concepts\\\\Driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(dependsOnMethods = "browser")
	private static void login() {

		driver.get("https://adactinhotelapp.com/");
		// saranya1697
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("colleen7");
		// 9AQ46H
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Jemimah7@");

		driver.findElement(By.xpath("//input[@class='login_button']")).click();

	}
	
	@Test(dependsOnMethods = "login")
	private static void page1() throws InterruptedException {

		WebElement location = driver.findElement(By.xpath("//select[@name='location']"));
		Select l = new Select(location);
		l.selectByValue("London");

		WebElement hotels = driver.findElement(By.xpath("(//select[@class='search_combobox'])[2]"));
		Select h = new Select(hotels);
		h.selectByVisibleText("Hotel Sunshine");

		WebElement roomType = driver.findElement(By.xpath("//select[@id='room_type']"));
		Select rt = new Select(roomType);
		rt.selectByIndex(4);

		WebElement rooms = driver.findElement(By.xpath("//select[@id='room_nos']"));
		Select r = new Select(rooms);
		r.selectByValue("1");

		driver.findElement(By.xpath("(//input[@class='date_pick'])[1]")).sendKeys("07/05/2025");

		driver.findElement(By.xpath("(//input[@class='date_pick'])[2]")).sendKeys("25/05/2025");

		WebElement adultNo = driver.findElement(By.xpath("//select[@name='adult_room']"));
		Select aN = new Select(adultNo);
		aN.selectByValue("1");

		driver.findElement(By.xpath("//input[@id='Submit']")).click();

	}

	private static void page2() {

		driver.findElement(By.xpath("//input[@name='radiobutton_0']")).click();

		driver.findElement(By.xpath("(//input[@class='reg_button'])[1]")).click();

	}

	private static void page3() {

		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("colleen");

		driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("jemimah");

		driver.findElement(By.xpath("//textarea[@class='txtarea']")).sendKeys("xxxx\nyyyy");

		driver.findElement(By.xpath("//input[@id='cc_num']")).sendKeys("1234567890123456");

		WebElement creditcard = driver.findElement(By.xpath("//select[@class='select_combobox']"));
		Select ccn = new Select(creditcard);
		ccn.selectByValue("AMEX");

		WebElement ccMonth = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
		Select ccm = new Select(ccMonth);
		ccm.selectByVisibleText("September");

		WebElement ccYear = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select ccy = new Select(ccYear);
		ccy.selectByValue("2027");

		driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys("123");

		driver.findElement(By.xpath("//input[@id='book_now']")).click();

	}

	private static void page4() throws InterruptedException {

		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='my_itinerary']")).click();

	}

	private static void Screenshot() throws IOException {

		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2500)");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\Hp\\Desktop\\eclipse\\Selenium Concepts\\Screenshot\\Adactin.png");
		// FileUtils.copyFile(source,target);
		FileHandler.copy(source, target);

	}
	
	@AfterSuite	
	private static void logout() {
		
		driver.findElement(By.xpath("//input[@name='logout']")).click();
		
		driver.close();

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		browser();
		login();
		page1();
		page2();
		page3();
		page4();
		Screenshot();
		logout();
	}

}
