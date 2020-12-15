package com.function.TestCases;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.dataEntity.TestEntity;
import com.pageObjects.EquityTradeHomePage;
import com.pageObjects.GooglePage;
import com.pageObjects.LoginPage;
import com.testFactory.TestFactory;
import com.utilities.FileUtility;


public class EquityTradeTest extends TestFactory{
	
@Test
public void GoogleSearchValidation() throws Exception{
		
	// Copy the file from  the file
	FileUtility.copyFile("/resources/SourceFolder/TestData.xlsx", "/resources/InputFolder/TestData.xlsx");
	Repoter().Info("Successfully Copied the file");

//	LoginPage loginPage = new LoginPage();
//	Repoter().Info("Open the Google Page");
//		
//	Assert.assertTrue(loginPage.AT("Login Page"));
//	Repoter().FinalPass("At Google Page");
//		
//	EquityTradeHomePage entityTradePage=loginPage.loginToEquityTradApplication("User", "pwd");
//	Assert.assertTrue(entityTradePage.AT("Equity Trade Home Page"));
	
	Assert.assertTrue(FileUtility.compareFiles("/resources/SourceFolder/TestData.xlsx","TRADE DATA FROM EXT Day 1", "/resources/InputFolder/TestData.xlsx","TRADE DATA FROM EXT Day 1"));
	Repoter().Info("Successfully verified the file");
}
}
