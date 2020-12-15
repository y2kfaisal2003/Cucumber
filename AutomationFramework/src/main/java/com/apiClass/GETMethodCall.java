package com.apiClass;

import java.util.List;

import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.baseClass.APIBaseClass;

public class GETMethodCall extends APIBaseClass {
	Response response=null;
	public GETMethodCall(String endPoint) {
		super(endPoint);
	}
	
	public String getResponceCode(String strURI){
		if(response==null)
			response = httpRequestObj.request(Method.GET,strURI);
		return String.valueOf(response.getStatusCode());
	}
	
	public String getResponceStatusLine(String strURI){
		if(response==null)
			response = httpRequestObj.request(Method.GET,strURI);
		return response.getStatusLine();
	}
	
	private String getResponceBody(String strURI, String jsonKey){
		if(response==null)
			response = httpRequestObj.request(Method.GET,strURI);
		JsonPath resPayLoad = response.getBody().jsonPath();
		System.out.println(response.getBody().toString());
		System.out.println(resPayLoad.get().toString());
		return resPayLoad.get(jsonKey);
		//return resPayLoad.get();
	}
	
	public Boolean verifyBodyInfo(String strURI, String jsonKey, String strExpectedValue){
		if(strExpectedValue.equalsIgnoreCase(getResponceBody(strURI, jsonKey)))
			return true;
		else
			return false;
	}
	
	
	public void getHeaderInformation(String strURI){
		if(response==null)
			response = httpRequestObj.request(Method.GET,strURI);
		List<Header> headers=response.headers().asList();
		  for(Header h:headers){
			  System.out.println(h.getName()+"=="+h.getValue());
		  }
	}
}
