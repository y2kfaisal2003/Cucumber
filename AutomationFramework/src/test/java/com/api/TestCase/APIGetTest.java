package com.api.TestCase;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.apiClass.GETMethodCall;
import com.dataProivder.DataProviderSource;
import com.dataEntity.TestEntityAPI;
import com.testFactory.APITestFactory;

public class APIGetTest extends APITestFactory{
	@Test(dataProvider="TestMethodAPI", dataProviderClass=DataProviderSource.class)
	public void APITestsGETMethod(TestEntityAPI testData) throws Exception{
		
		GETMethodCall  getMethod = new GETMethodCall(testData.getEndPoint());
		Repoter().Info("Successfully register the Endpoint: "+testData.getEndPoint());
		
		Assert.assertEquals(getMethod.getResponceCode(testData.getURI()),testData.getStatusCode().trim());
		Repoter().Info("Successfully verify Status Code for URI: "+testData.getURI());
		
		Assert.assertTrue(getMethod.verifyBodyInfo(testData.getURI(),"City",testData.getURI().replace("/", "")));
		Repoter().Info("Successfully verify City "+testData.getURI().replace("/", "")+" for URI: "+testData.getURI());
	}
}
