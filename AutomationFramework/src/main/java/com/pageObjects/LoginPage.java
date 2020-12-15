package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.baseClass.BasePage;

public class LoginPage  extends BasePage{

	public LoginPage() {
		super(driver);
	}
	
	// Web Elements
		@FindBy(id ="//input[@name='q']")
		@CacheLookup
		WebElement loginUserIDTextBox;

		@FindBy(xpath ="//img[@id='hplogo']")
		@CacheLookup
		WebElement loginUserPasswordTextBox;;

		@FindBy(xpath="//input[@value='Google Search']")
		@CacheLookup
		WebElement submitButton;
		
		@FindBy(xpath="//input[@value='Google Search']")
		@CacheLookup
		WebElement cancelButton;
		
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
		
		public EquityTradeHomePage loginToEquityTradApplication(String userId, String userPwd) throws Exception{
			try{
				loginUserIDTextBox.sendKeys(userId);
				loginUserPasswordTextBox.sendKeys(userPwd);
				submitButton.click();
				return new EquityTradeHomePage();
			}catch(Exception e){
				throw new Exception("Failed to login to Equity Trade Application"+e.getMessage());
				}
			}

}
