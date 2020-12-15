package com.api.TestCase;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.apiClass.GETMethodCall;
import com.apiClass.POSTMethodCall;
import com.dataProivder.DataProviderSource;
import com.dataEntity.TestEntityAPI;
import com.testFactory.APITestFactory;

public class APIPostTest extends APITestFactory{
	@Test(dataProvider="TestMethodAPI", dataProviderClass=DataProviderSource.class)
	public void APITestsPOSTMethod(TestEntityAPI testData) throws Exception{
		
		POSTMethodCall  postMethod = new POSTMethodCall(testData.getEndPoint());
		Repoter().Info("Successfully register the Endpoint: "+testData.getEndPoint());
		
		String strRespBody=postMethod.posteRequestCustomerRegistration(testData.getURI(), testData.getBody());
		Repoter().Info("Successfully post the Customer Request: "+strRespBody);
		
		Assert.assertEquals(postMethod.getResponceCode(testData.getURI()),testData.getStatusCode().trim());
		Repoter().FinalPass("Successfully verify Status Code:"+testData.getStatusCode()+" for URI: "+testData.getURI());
	}
}
