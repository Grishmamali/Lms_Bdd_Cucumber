package userApi;



import org.testng.Assert;

import baseclass.BaseClass;
import config.ConfigProperties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class GET_SingleUser_ValidId extends BaseClass {
	String username;
	String password;
	
	@Given("User is on GET request with Users endpoint by id")
	public void user_is_on_get_request_with_users_endpoint_by_id() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusersValidID");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
		
	}
	
	@When("User sends GET request for single Id users")
	public void user_sends_get_request_for_single_id_users() {
		response=httpRequest.when().get();
		
	}
	
	@Given("User is on GET request with userskillmap endpoint by id")
	public void user_is_on_GET_request_with_userskillmap_endpoint_by_id() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmapValidID");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User sends GET request for userskillmap Id")
	public void user_sends_GET_request_for_userskillmap_Id() {
		response=httpRequest.when().get();
		
	}
	
	@Given("User is on GET request with userskillmapgetuserid endpoint valid id")
	public void user_is_on_GET_request_with_userskillmapgetuserid_endpoint_valid_id() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmapgetvaliduserid");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User sends GET request for userskillmapgetuserid")
	public void user_sends_GET_request_for_userskillmapgetuserid() {
		response=httpRequest.when().get();
	}
	
	@Given("User is on GET request with userskillmapgetskillid endpoint valid id")
	public void user_is_on_GET_request_with_userskillmapgetskillid_endpoint_valid_id() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmapgetvalidskillid");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User sends GET request for userskillmapgetskillid")
	public void user_sends_GET_request_for_userskillmapgetskillid() {
		response=httpRequest.when().get();
	}

	@Given("User is on GET request with skillapiid endpoint by id")
	public void user_is_on_GET_request_with_skillapiid_endpoint_by_id() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointskillapivalidid");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().auth().basic(username, password);
	}

	@When("User sends GET request for skillapiid Id")
	public void user_sends_GET_request_for_skillapiid_Id() {
		response=httpRequest.when().get();
	}
	

	@Then("User should be displayed success status {int} with single users.")
	public void user_should_be_displayed_success_status_with_single_users(Integer status) {
   
	int statusCode = response.getStatusCode();
	System.out.println("statusCode is : " + statusCode);
	System.out.println(response.asPrettyString());
	// response.then().assertThat().statusCode(statuscode.intValue());
	Assert.assertEquals(statusCode, status.intValue());
	
}


	
	
@Given("User is on GET request with Users endpoint by InvalidId")
public void user_is_on_get_request_with_users_endpoint_by_invalid_id() {
	RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
	RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusersInValidID");
	username=ConfigProperties.prop.getProperty("username");
	password=ConfigProperties.prop.getProperty("password");
	httpRequest=RestAssured.given().auth().basic(username, password);
    
}

@Given("User is on GET request with Userskillmap endpoint by Invalid userskillmapid")
public void user_is_on_GET_request_with_Userskillmap_endpoint_by_Invalid_userskillmapid() {
	RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
	RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmapInValidID");
	username=ConfigProperties.prop.getProperty("username");
	password=ConfigProperties.prop.getProperty("password");
	httpRequest=RestAssured.given().auth().basic(username, password);
    
}

@When("User sends GET request for single User with endpoint")
public void user_sends_get_request_for_single_user_with_endpoint() {
	response=httpRequest.when().get();
  
}

@Given("User is on GET request with userskillmapgetid endpoint by Invalid userskillmapgetid")
public void user_is_on_GET_request_with_userskillmapgetid_endpoint_by_Invalid_userskillmapgetid() {
	RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
	RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmapgetinvalidskillid");
	username=ConfigProperties.prop.getProperty("username");
	password=ConfigProperties.prop.getProperty("password");
	httpRequest=RestAssured.given().auth().basic(username, password);
    
}

@When("User sends GET request for userskillmapgetid Id")
public void user_sends_GET_request_for_userskillmapgetid_Id() {
	response=httpRequest.when().get();
}

@Given("User is on GET request with skillapiid endpoint by Invalid skillapiid")
public void user_is_on_GET_request_with_skillapiid_endpoint_by_Invalid_skillapiid() {
	RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
	RestAssured.basePath = ConfigProperties.prop.getProperty("endpointskillapiinvalidid");
	username=ConfigProperties.prop.getProperty("username");
	password=ConfigProperties.prop.getProperty("password");
	httpRequest=RestAssured.given().auth().basic(username, password);
}

@When("User sends GET request for skillapiid")
public void user_sends_GET_request_for_skillapiid() {
	response=httpRequest.when().get();
}

@Then("User should be displayed unsuccess status {int} with not found message")
public void user_should_be_displayed_unsuccess_status_with_not_found_message(Integer int1) {
	
	System.out.println("****************************For Invalid Id********************************");
	int statusCode = response.getStatusCode();
	System.out.println("statusCode is : " + statusCode);
	System.out.println(response.asPrettyString());
	// response.then().assertThat().statusCode(statuscode.intValue());
	Assert.assertEquals(statusCode, int1.intValue());
   
}

}
