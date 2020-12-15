package com.apiClass;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

import org.json.simple.JSONObject;

import io.restassured.http.Method;
import io.restassured.response.Response;

import com.baseClass.APIBaseClass;

public class POSTMethodCall extends APIBaseClass{
	Response response=null;
	public POSTMethodCall(String endPoint) {
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
	
	public String posteRequestCustomerRegistration(String strURI, String strBody){
		if(response==null){ 
			JSONObject requestParam = new JSONObject();
			requestParam.putAll(getCustomerBody(strBody));
			httpRequestObj.header("Content-Type","application/json");
			httpRequestObj.body(requestParam.toJSONString());
			response = httpRequestObj.request(Method.POST,"/register");		
		}
		System.out.println(response.getBody().asString());
		return response.getBody().asString();
	}
	
	@SuppressWarnings("unchecked")
	private Map<String, String> getCustomerBody(String strBody){
		JSONObject requestParam = new JSONObject();
		Map<String, String> mapBody = new LinkedHashMap<String, String>();
		String[] strBodyComponent=strBody.replace("[", "").replace("]", "").replace("{", "").replace("}", "").split(",");
		for(int i=0;i<strBodyComponent.length;i++){
			//requestParam.put(strBodyComponent[i].split(":")[0].replace("\\n", "").replace("\"", "").trim(), strBodyComponent[i].split(":")[1].replace("\\n", "").replace("\"", "").trim());
			mapBody.put(strBodyComponent[i].split(":")[0], strBodyComponent[i].split(":")[1]);
		}
		System.out.println(mapBody.toString());
	return mapBody;
	}
	
}
