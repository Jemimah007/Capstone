package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	private WebDriver driver;

	@FindBy(xpath="//input[@name='logout']")
	private WebElement logoutBtn;
	

	public LogoutPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2,this);
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;

}
	
}
