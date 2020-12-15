package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.baseClass.BasePage;
import com.utilities.HelperClass;

public class EquityTradeHomePage  extends BasePage {
	public EquityTradeHomePage() {
		super(driver);
	}
	
	// Web Elements
			@FindBy(id ="//input[@name='q']")
			@CacheLookup
			WebElement fromDate;
			
			@FindBy(id ="//input[@name='q']")
			@CacheLookup
			WebElement toDate;

			@FindBy(xpath ="//img[@id='hplogo']")
			@CacheLookup
			WebElement dateRange;;

			@FindBy(xpath="//input[@value='Google Search']")
			@CacheLookup
			WebElement dataTable;
			
			

	public Boolean AT(String strPageTitle) throws Exception{
		try{
			if(driver.getTitle().trim().equals(strPageTitle.trim()))
				return true;
			else
				throw new Exception("Failed to Launch Login Page");	
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	public Boolean selectTheDateAndSearch(String strfromDate, String strToDate){
		if(HelperClass.EnterElementValues(fromDate, strfromDate) &&
		HelperClass.EnterElementValues(toDate, strfromDate))
			return true;
		else
			return false;
	}
	
	
	
}
