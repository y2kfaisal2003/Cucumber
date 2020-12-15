package com.function.TestCases;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.dataEntity.TestEntity;
import com.pageObjects.EquityTradeHomePage;
import com.pageObjects.GooglePage;
import com.pageObjects.LoginPage;
import com.testFactory.TestFactory;


public class LoginToEquityTradeTest extends TestFactory{
	
@Test
public void GoogleSearchValidation() throws Exception{
		
		LoginPage loginPage = new LoginPage();
		Repoter().Info("Open the Google Page");
		
		Assert.assertTrue(loginPage.AT("Login Page"));
		Repoter().FinalPass("At Google Page");
		
		EquityTradeHomePage entityTradePage=loginPage.loginToEquityTradApplication("User", "pwd");
		Assert.assertTrue(entityTradePage.AT("Equity Trade Home Page"));
	}
}
