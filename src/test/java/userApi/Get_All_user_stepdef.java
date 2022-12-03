package userApi;

import org.testng.Assert;

import baseclass.BaseClass;
import config.ConfigProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;



public class Get_All_user_stepdef extends BaseClass {
	String username;
	String password;

	@Given("User is on GET request with Users endpoint")
	public void get_all_user() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers");
		//RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmap");
		
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
		
	}
	
	@Given("User is on GET request with userskillmap endpoint")
	public void user_is_on_GET_request_with_userskillmap_endpoint() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		//RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmap");
		
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	   
	}
	
	@Given("User is on GET request with userskillmapgetapi endpoint")
	public void user_is_on_GET_request_with_userskillmapgetapi_endpoint() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		//RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmapget");
		
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	   
	}

	@Given("User is on GET request with skillapi endpoint")
	public void user_is_on_GET_request_with_skillapi_endpoint() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		//RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointskillapi");
		
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}
	
	@When("User sends GET request for all users")
	public void user_sends_get_request_for_all_users(){
		response=httpRequest.when().get();
		
	}
	
	@Then("User should be displayed success status code {int} with list of all users.")
	public void user_should_be_displayed_success_status_code_with_list_of_all_users(Integer code) {
		// StatusCode Validation
		int statusCode = response.getStatusCode();
		System.out.println("statusCode is : " + statusCode);
		System.out.println(response.asPrettyString());
		// response.then().assertThat().statusCode(statuscode.intValue());
		Assert.assertEquals(statusCode, code.intValue());
		
	}
	
	@Given("User is on GET request with Users endpoint with invalid Credential")
	public void user_is_on_GET_request_with_Users_endpoint_with_invalid_Credential() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers");
		username=ConfigProperties.prop.getProperty("username1");
		password=ConfigProperties.prop.getProperty("password1");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User sends GET request for all users with invalid credential")
	public void user_sends_GET_request_for_all_users_with_invalid_credential() {
		response=httpRequest.when().get();
	}

	@Then("User should be displayed unsuccess status code {int} .")
	public void user_should_be_displayed_unsuccess_status_code(Integer int1) {
		// StatusCode Validation
				int statusCode = response.getStatusCode();
				System.out.println("statusCode is : " + statusCode);
				System.out.println(response.asPrettyString());
				// response.then().assertThat().statusCode(statuscode.intValue());
				Assert.assertEquals(statusCode, int1.intValue());
	}


	
}