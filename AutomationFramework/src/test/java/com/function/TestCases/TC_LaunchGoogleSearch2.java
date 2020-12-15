package com.function.TestCases;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.pageObjects.GooglePage;
import com.testFactory.TestFactory;

public class TC_LaunchGoogleSearch2 extends TestFactory{ 

	@Test
	public void TestMethodTwo() throws Exception{
		
		GooglePage googlePage = new GooglePage();
		Repoter().Info("Open the Google Page");
		
		Assert.assertTrue("Failed to Verify Google Title", googlePage.AT("Googl"));
		Repoter().FinalPass("At Google Page");
		
		googlePage.EnterGoogleSearchText("Seleniumhq");
		Repoter().Info("Search Seleniumhq site");
	}
}
