package userApi;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.util.XLSUtility;


import baseclass.BaseClass;
import config.ConfigProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class POST_User extends BaseClass {
	
	String username;
	String password;
	String userid,skillid,monthsofexp;
	
	String excelPath=  ConfigProperties.prop.getProperty("postUsersExcelPath");
	XLSUtility excelUtil = new XLSUtility(excelPath);

	String comments,education_pg , skill_name,education_ug, linkedin_url, location, name, phone_number, time_zone, visa_status;

	@Given("authentication is sent for POST request with valid username and valid password")
	public void authentication_is_sent_for_post_request_with_valid_username_and_valid_password() {
		
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);
	    
	}

	//@SuppressWarnings("unchecked")
	@When("User send post request with valid user inputs")
	public void user_send_post_request_with_valid_user_inputs() throws IOException {
		
		
		int rowCount = excelUtil.getRowCount("Sheet1");
		System.out.println();
		
		System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			
			
			comments = excelUtil.getCellData("Sheet1", i, 0);
			if(StringUtils.isEmpty(comments))
				break;
			
			education_pg = excelUtil.getCellData("Sheet1", i, 1);
			education_ug = excelUtil.getCellData("Sheet1", i, 2);
			linkedin_url = excelUtil.getCellData("Sheet1", i, 3);
			location = excelUtil.getCellData("Sheet1", i, 4);
			name = excelUtil.getCellData("Sheet1", i, 5);
			phone_number = excelUtil.getCellData("Sheet1", i, 6);
			time_zone = excelUtil.getCellData("Sheet1", i, 7);
			visa_status = excelUtil.getCellData("Sheet1", i, 8);
			
	
		JSONObject requestparams = new JSONObject();
		requestparams.put("comments", comments);
		requestparams.put("education_pg", education_pg);
		requestparams.put("education_ug", education_ug);
		requestparams.put("linkedin_url",linkedin_url);
		requestparams.put("location", location);
		requestparams.put("name", name);
		requestparams.put("phone_number", phone_number);
		requestparams.put("time_zone", time_zone);
		requestparams.put("visa_status", visa_status);
		System.out.println("*******************"+requestparams.toString());
		response = httpRequest.body(requestparams).post();

		String userId = response.jsonPath().getString("user_id");

		System.out.println("Post response is : " + response.asPrettyString());

		}

		}
	@Given("authentication is sent for POST request with endpoint userSkillMap")
	public void authentication_is_sent_for_POST_request_with_endpoint_userSkillMap() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmap");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);
	}

	@When("User send post request with valid userSkillMap  inputs")
	public void user_send_post_request_with_valid_userSkillMap_inputs() throws IOException {
		int rowCount = excelUtil.getRowCount("Sheet2");
		System.out.println();
		
		System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			
			
			//comments = excelUtil.getCellData("Sheet2", i, 0);
			//if(StringUtils.isEmpty(comments))
				//break;
			
			monthsofexp = excelUtil.getCellData("Sheet2", i, 0);
			skillid = excelUtil.getCellData("Sheet2", i, 1);
			userid = excelUtil.getCellData("Sheet2", i, 2);
			
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("user_id", userid);
		requestparams.put("skill_id", skillid);
		requestparams.put("months_of_exp", monthsofexp);

		System.out.println("*******************"+requestparams.toString());
		response = httpRequest.body(requestparams).post();

		String userid = response.jsonPath().getString("user_skill_id");

		System.out.println("Post response is : " + response.asPrettyString());

		}


	    
	}
	
	@Given("authentication is sent for POST request with endpoint Skills")
	public void authentication_is_sent_for_POST_request_with_endpoint_Skills() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
		RestAssured.basePath = ConfigProperties.prop.getProperty("endpointskillapi");
		username=ConfigProperties.prop.getProperty("username");
		password=ConfigProperties.prop.getProperty("password");
		httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);
	}

	@When("User send post request with valid Skills   inputs")
	public void user_send_post_request_with_valid_Skills_inputs() throws IOException {
		int rowCount = excelUtil.getRowCount("Sheet3");
		System.out.println();
		
		System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			
			
			skill_name = excelUtil.getCellData("Sheet3", i, 0);
			
			
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("skill_name", skill_name);
		
		System.out.println("*******************"+requestparams.toString());
		response = httpRequest.body(requestparams).post();

		String skill_name = response.jsonPath().getString("skill_name");

		System.out.println("Post response is : " + response.asPrettyString());

	}
		}

	@Then("User should be displayed success status code {int} with message Successfully Created. with automatically generated userid")
	public void user_should_be_displayed_success_status_code_with_message_successfully_created_with_automatically_generated_userid(Integer int1) {
		// Response Body Validation
		Assert.assertNotNull(response);
		// StatusCode Validation
		response.then().assertThat().statusCode(int1.intValue());

	}
	
	
	

	@When("User send post request with invalid user inputs")
	public void user_send_post_request_with_invalid_user_inputs() {
	
		JSONObject requestparams = new JSONObject();
		requestparams.put("comments", "test");
		requestparams.put("education_pg", "test");
		requestparams.put("education_ug", "test");
		requestparams.put("linkedin_url","test");
		requestparams.put("location", "test");
		requestparams.put("name", "test");
		requestparams.put("phone_number", "test");
		requestparams.put("time_zone", "pst");
		requestparams.put("visa_status", "h1b");
		System.out.println("*******************"+requestparams.toString());
		response = httpRequest.body(requestparams).post();

		System.out.println("Post response is : " + response.asPrettyString());

	}

	@Then("User should be displayed success status code {int} for bad request.")
	public void user_should_be_displayed_success_status_code_for_bad_request(Integer int1) {
		Assert.assertNotNull(response);
		// StatusCode Validation
		System.out.println("Bad Request response is : " + response.asPrettyString());
		response.then().assertThat().statusCode(int1.intValue());
	}


}
