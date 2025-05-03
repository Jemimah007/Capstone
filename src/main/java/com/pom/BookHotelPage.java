package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage {
	
	public static WebDriver driver;
	
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	private WebElement lastName;
	
	@FindBy(xpath="//textarea[@class='txtarea']")
	private WebElement addressField;
	
	@FindBy(xpath="//input[@id='cc_num']")
	private WebElement ccNumber;
	
	@FindBy(xpath="//select[@class='select_combobox']")
	private WebElement ccType;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	private WebElement ccMonth;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
	private WebElement ccYear;
	
	@FindBy(xpath="//input[@name='cc_cvv']")
	private WebElement cvvNumber;
	
	@FindBy(xpath="//input[@id='book_now']")
	private WebElement bookNowBtn;


	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddressField() {
		return addressField;
	}

	public WebElement getCcNumber() {
		return ccNumber;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcMonth() {
		return ccMonth;
	}

	public WebElement getCcYear() {
		return ccYear;
	}

	public WebElement getCvvNumber() {
		return cvvNumber;
	}

	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}
	
	public BookHotelPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	

}
