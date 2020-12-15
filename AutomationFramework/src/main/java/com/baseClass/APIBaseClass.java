package com.baseClass;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APIBaseClass {
	protected RequestSpecification httpRequestObj;
	public APIBaseClass(){}
	public APIBaseClass(String uri){
		RestAssured.baseURI =	uri;
		httpRequestObj=RestAssured.given();
	}
}
