package com.api.stepDefinitions;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import java.net.URI;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.api.transformClasses.ExcelDataToDataTable;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APIGetMethodStepDef {
	int statusCode=0;
	List<List<String>> dataList=null;
	@Given("^Weather API Endpoint and URI for different Cities from Excel$")
	public void weather_API_Endpoint_and_URI_for_different_Cities_from_Excel() throws Throwable {

	}

	@When("^Reading Endpoint and URI from Excel Sheet \"([^\"]*)\"\\.$")
	public void reading_Endpoint_and_URI_from_Excel_Sheet(@Transform(ExcelDataToDataTable.class) DataTable table) throws Throwable {
		//List<String> dataList = table.asList(String.class);
		dataList = table.cells(1);
//		for(List<String> str : dataList){
//			String endPoint = str.get(4);
//			String uri = str.get(5);()
//			//System.out.println(endPoint+uri);
//			int code =given()
//					.accept(ContentType.JSON)
//					.when()
//					.get(new URI(endPoint+uri))
//					.thenReturn()
//					.statusCode();
//			System.out.println("Status Code for URI: "+statusCode+ " "+ code);
//		}
		//System.out.println(table.toString());
		//		
		//		List<String> dataList = table.asList(String.class);
		//		
		//		for(String str : dataList){
		//			System.out.println(str);
		//		}
	}


	@Then("^Verify Status Code (\\d+)$")
	public void verify_Status_Code(int statusCode) throws Throwable {
		for(List<String> str : dataList){
			String endPoint = str.get(4);
			String uri = str.get(5);
			int code =given()
					.accept(ContentType.JSON)
					.when()
					.get(new URI(endPoint+uri))
					.thenReturn()
					.statusCode();
			System.out.println("Expected Status Code:"+statusCode + " and Actual Status Code "+ code +" for URI: "+endPoint+uri);
			Assert.assertEquals(statusCode, code);
			
//			given()
//			.accept(ContentType.JSON)
//			.when()
//			.get(new URI(endPoint+uri))
//			.then()
//			.assertThat()
//			.statusCode(HttpStatus.SC_OK);
			
//			given()
//			.accept(ContentType.JSON)
//			.when()
//			.get(new URI(endPoint+uri))
//			.then()
//			.body("City",equalToIgnoringCase(uri.replace("/", "")));
			
		}
	}

}
