package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pom.BookHotelPage;
import com.pom.LoginPage;
import com.pom.LogoutPage;
import com.pom.MyItineraryPage;
import com.pom.SearchHotelPage;
import com.pom.SelectHotelPage;

public class PageObjectManager {
	
	public WebDriver driver;
	public PageObjectManager(WebDriver driver2) {
		this.driver=driver2;
	}
	
	//Login Page Object
	private LoginPage lp;
	public LoginPage getInstanceLp() {
		lp = new LoginPage(driver);
		return lp;
	}
	
	//Search Hotel Page Object
	private SearchHotelPage shp;
		public SearchHotelPage getInstanceShp() {
		shp = new SearchHotelPage(driver);
		return shp;	
	}
	
	//Select Hotel Page Object
	private SelectHotelPage shp2;
	public SelectHotelPage getInstanceShp2() {
		shp2 = new SelectHotelPage(driver);
		return shp2;
	}
	
	//Book Hotel Page Object
	private BookHotelPage bhp;
	public BookHotelPage getInstanceBhp() {
		bhp = new BookHotelPage(driver);
		return bhp;
	}
	
	//My Itinerary Page
	private MyItineraryPage mip;
	public MyItineraryPage getInstanceMip() {
		mip = new MyItineraryPage(driver);
		return mip;
	}
	
	//Logout Page
	private LogoutPage lp2;
	public LogoutPage getInstanceLp2() {
		lp2 = new LogoutPage(driver);
		return lp2;
	}
	
	
	
	public MyItineraryPage getMip() {
		return mip;
	}
	
	public LogoutPage getLp2() {
		return lp2;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public LoginPage getLp() {
		return lp;
	}

	public SearchHotelPage getShp() {
		return shp;
	}

	public SelectHotelPage getShp2() {
		return shp2;
	}

	public BookHotelPage getBhp() {
		return bhp;
	}
	
		
	}
