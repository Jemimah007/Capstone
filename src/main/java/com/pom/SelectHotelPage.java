package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
	
	public static WebDriver driver;
	
	public SelectHotelPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	@FindBy(xpath="//input[@name='radiobutton_0']")
	private WebElement radioBtn;
	
	@FindBy(xpath="//input[@class='reg_button'][1]")
	private WebElement continueBtn;
	
	

}
