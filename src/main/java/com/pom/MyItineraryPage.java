package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyItineraryPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//input[@id='my_itinerary']")
	private WebElement myIteneraryBtn;

	public MyItineraryPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2,this);
	}

	public WebElement getMyIteneraryBtn() {
		return myIteneraryBtn;
	}
	
	

}
