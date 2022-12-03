package userApi;

import org.testng.Assert;

import baseclass.BaseClass;
import config.ConfigProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class DELETE_User extends BaseClass {
	String username;
	String password;
	
	@Given("User is on delete request call endpoint with valid credential")
	public void user_is_on_delete_request_call_endpoint_with_valid_credential() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("deleteusersValidID");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User send delete request with valid userId")
	public void user_send_delete_request_with_valid_user_id() {
		response=httpRequest.when().delete();
		

		
	
	}
	
	@Given("User is on delete request call userskillmap endpoint with valid credential")
	public void user_is_on_delete_request_call_userskillmap_endpoint_with_valid_credential() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("deleteuserskillmapvalidid");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User send delete request with valid userskillmap")
	public void user_send_delete_request_with_valid_userskillmap() {
		response=httpRequest.when().delete();
		
	}


	@Given("User is on delete request call skill endpoint with valid credential")
	public void user_is_on_delete_request_call_skill_endpoint_with_valid_credential() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("deleteskillvalidid");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User send delete request with valid skill")
	public void user_send_delete_request_with_valid_skill() {
		response=httpRequest.when().delete();
		
	}



	@Then("Status code {int} successfully deleted should be displayed with record has been deleted message")
	public void status_code_successfully_deleted_should_be_displayed_with_record_has_been_deleted_message(Integer int1) {
		 
		    int statuscode = response.getStatusCode();
		    System.out.println(response.asPrettyString());
		    response.then().assertThat().statusCode(int1.intValue());
			System.out.println("status code is:" +int1);
		    
		    
	}
	
	@Given("User is on delete request call endpoint with valid credential with invalid userid")
	public void user_is_on_delete_request_call_endpoint_with_valid_credential_with_invalid_userid() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("deleteusersInValidID");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User send delete request with Invalid userId")
	public void user_send_delete_request_with_invalid_user_id() {
		response=httpRequest.when().delete();
		
	}

	@Then("Status code {int} with not found message")
	public void status_code_with_not_found_message(Integer int1) {

	    int statuscode = response.getStatusCode();
	    System.out.println(response.asPrettyString());
	    response.then().assertThat().statusCode(int1.intValue());
		System.out.println("status code is:" +int1);
	}




}
