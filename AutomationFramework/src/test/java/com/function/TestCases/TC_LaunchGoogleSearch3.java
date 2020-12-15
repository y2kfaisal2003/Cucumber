package com.function.TestCases;

import org.testng.annotations.Test;

import com.pageObjects.GooglePage;
import com.testFactory.TestFactory;

public class TC_LaunchGoogleSearch3 extends TestFactory{ 

	@Test
	public void TestMethodThree(){
		
		GooglePage googlePage = new GooglePage();
		Repoter().Info("Open the Google Page");
		
		googlePage.EnterGoogleSearchText("Seleniumhq");
		Repoter().Info("Search for Seleniumhq site");
	}
}
