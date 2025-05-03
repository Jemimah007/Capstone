package com.runnerclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.baseclass.BaseClass;
import com.sdp.PageObjectManager;

public class RunnerClass extends BaseClass {
	
	public static WebDriver driver = BaseClass.setUp("chrome");
	
	public static PageObjectManager pom = new PageObjectManager(driver);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		driver =openUrl("https://adactinhotelapp.com/");
		
		
		//Login Page
		String userData = "colleen7";
		inputValueElement(pom.getInstanceLp().getUsername(),userData);
		String passData = "Jemimah7@";
		inputValueElement(pom.getInstanceLp().getPassword(),passData);
		clickOnElement(pom.getInstanceLp().getLoingbutton());
		
		//Select Hotel Page
		dropDown(pom.getInstanceShp().getLocation(),"selectvalue","London");
		dropDown(pom.getInstanceShp().getHotels(),"selectText","Hotel Sunshine"); 
		dropDown(pom.getInstanceShp().getRoomType(),"selectIndex","4");
		dropDown(pom.getInstanceShp().getRooms(),"selectvalue","1");
		inputValueElement(pom.getInstanceShp().getCheckInDate(),"07/05/2025");
		inputValueElement(pom.getInstanceShp().getCheckOutDate(),"25/05/2025");
		dropDown(pom.getInstanceShp().getAdultPerRoom(),"selectValue","1");
		clickOnElement(pom.getInstanceShp().getSearchHotel());
		
		//SearchHotelPage
		Thread.sleep(2000);
		radioButton(pom.getInstanceShp2().getRadioBtn());
		clickOnElement(pom.getInstanceShp2().getContinueBtn());
		
		//BookHotelPage
		inputValueElement(pom.getInstanceBhp().getFirstName(), "Colleen");
		inputValueElement(pom.getInstanceBhp().getLastName(),"Jemimah");
		inputValueElement(pom.getInstanceBhp().getAddressField(), "xxxx,yyyy");
		inputValueElement(pom.getInstanceBhp().getCcNumber(), "1234567890123456");
		dropDown(pom.getInstanceBhp().getCcType(),"selectvalue","AMEX");
		dropDown(pom.getInstanceBhp().getCcMonth(),"selecttext","September");
		dropDown(pom.getInstanceBhp().getCcYear(),"selectvalue","2027");
		inputValueElement(pom.getInstanceBhp().getCvvNumber(),"123");
		clickOnElement(pom.getInstanceBhp().getBookNowBtn());
		
		//MyIteneraryPage
		Thread.sleep(5000);
		clickOnElement(pom.getInstanceMip().getMyIteneraryBtn());
		
		
		//LogoutPage
		clickOnElement(pom.getInstanceLp2().getLogoutBtn());
		
		//Close
		tearDown();
		
		
		
	}
	
}
		
		