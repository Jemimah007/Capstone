package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
	
	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRooms() {
		return rooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getAdultPerRoom() {
		return adultPerRoom;
	}

	public WebElement getSearchHotel() {
		return searchHotel;
	}
	
	public SearchHotelPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver2, this);
	}
	
	@FindBy(xpath="//select[@name='location']")
	private WebElement location;
	
	@FindBy(xpath="(//select[@class='search_combobox'])[2]")
	private WebElement hotels;
	
	@FindBy(xpath="//select[@id='room_type']")
	private WebElement roomType;
	
	@FindBy(xpath="//select[@id='room_nos']")
	private WebElement rooms;
	
	@FindBy(xpath="(//input[@class='date_pick'])[1]")
	private WebElement checkInDate;
	
	@FindBy (xpath="(//input[@class='date_pick'])[2]")
	private WebElement checkOutDate;
	
	@FindBy(xpath="//select[@name='adult_room']")
	private WebElement adultPerRoom;
	
	@FindBy (xpath="//input[@id='Submit']")
	private WebElement searchHotel;
	
	
	

}
