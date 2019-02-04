
package com.allica.test.stepdefs;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.hamcrest.core.Every;

import com.allica.read.config.Root_PropertyLoader;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;

import java.io.IOException;
import java.lang.Character.Subset;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ExpAPIStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private Properties props;

	private String Validate_companyName = "https://ab-e-mobile-interface-v1-sit.uk-e1.cloudhub.io/api/ab-e-mobile-interface/v1/companies";


	@Given("a valid companyName (.*) with valid headers")
	public void a_valid_companyName(String companyName) throws IOException{
		 props=new Root_PropertyLoader().load("system");
		System.out.println("Loading done.......");
		request = given().queryParam("companyName", companyName).header("X-TRANSACTION-ID", "3F2504E0-4F89-11D3-9A0C-0305E82C3303").header("X-REQUEST-ID" , "3F2504E0-4F89-11D3-9A0C-0305E82C3303").header("client_id","10f17ccb2ed44baeac09e852f0835c68").header("client_secret", "2C5f53cDd3c845F596C305884bfFc0B0");
			
	}

	@When("I validate companyName")
	public void I_validate_companyName(){
		response = request.when().get(Validate_companyName);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("the status code is (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode).log().all();
		
	}

	@And("response includes the following$")
	public void response_equals(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
				
				json.body(field.getKey(), hasItem(field.getValue()));		
		}
	}

}

