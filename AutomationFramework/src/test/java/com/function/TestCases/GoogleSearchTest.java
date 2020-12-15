package com.function.TestCases;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.dataProivder.DataProviderSource;
import com.dataEntity.TestEntity;
import com.pageObjects.GooglePage;
import com.testFactory.TestFactory;

public class GoogleSearchTest extends TestFactory{ 

	@Test(dataProvider="TestMethod", dataProviderClass=DataProviderSource.class)
	public void GoogleSearchValidation(TestEntity testData) throws Exception{
		
		GooglePage googlePage = new GooglePage();
		Repoter().Info("Open the Google Page");
		
		Assert.assertTrue(googlePage.AT(testData.getPageTitle()));
		Repoter().FinalPass("At Google Page");
		
		googlePage.EnterGoogleSearchText(testData.getSearchText());
		Repoter().FinalPass("Search for Seleniumhq site: "+testData.getSearchText());
	}
}
