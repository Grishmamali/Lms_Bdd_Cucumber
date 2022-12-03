package userApi;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.message.BasicStatusLine;
import org.json.simple.JSONObject;
import org.testng.Assert;

import com.util.XLSUtility;

import baseclass.BaseClass;
import config.ConfigProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class PUT_User extends BaseClass {

	String userid,skillid,monthsofexp,skill_name,skill_id1;
	String userskillid;
	String username;
	String password;

	String excelPath=  ConfigProperties.prop.getProperty("PutUsersExcelPath");

	XLSUtility excelUtil = new XLSUtility(excelPath);
	String id,comments,education_pg , education_ug, linkedin_url, location, name, phone_number, time_zone, visa_status;


	@Given("User is on put user request with endpoint")
	public void user_is_on_put_user_request_with_endpoint() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
	}

	@When("User sends put request with all valid parameter values in request body")
	public void user_sends_put_request_with_all_valid_parameter_values_in_request_body() throws IOException{
		int rowCount = excelUtil.getRowCount("Sheet1");
		System.out.println();

		//System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			id = excelUtil.getCellData("Sheet1", i, 0);
			if(StringUtils.isEmpty(id))
				break;
			RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers")+"/"+id;
			username=ConfigProperties.prop.getProperty("username");
			password=ConfigProperties.prop.getProperty("password");
			httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);

			comments = excelUtil.getCellData("Sheet1", i, 1);

			education_pg = excelUtil.getCellData("Sheet1", i, 2);
			education_ug = excelUtil.getCellData("Sheet1", i, 3);
			linkedin_url = excelUtil.getCellData("Sheet1", i, 4);
			location = excelUtil.getCellData("Sheet1", i, 5);
			name = excelUtil.getCellData("Sheet1", i, 6);
			phone_number = excelUtil.getCellData("Sheet1", i, 7);
			time_zone = excelUtil.getCellData("Sheet1", i, 8);
			visa_status = excelUtil.getCellData("Sheet1", i, 9);


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
			response = httpRequest.body(requestparams).put();

			System.out.println("Post response is : " + response.asPrettyString());


		}
	}
	
	
	@Given("User is on put userskillmap request with endpoint")
	public void user_is_on_put_userskillmap_request_with_endpoint() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
	}

	@When("User sends put request with all valid userskillmap values in request body")
	public void user_sends_put_request_with_all_valid_userskillmap_values_in_request_body() throws IOException {
		int rowCount = excelUtil.getRowCount("Sheet4");
		System.out.println();
		
		System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			
			monthsofexp = excelUtil.getCellData("Sheet4", i, 0);
			skillid = excelUtil.getCellData("Sheet4", i, 1);
			userid = excelUtil.getCellData("Sheet4", i, 2);
			userskillid=excelUtil.getCellData("Sheet4", i, 3);
			
			RestAssured.basePath = ConfigProperties.prop.getProperty("endpointuserskillmap")+"/"+userskillid;
			username=ConfigProperties.prop.getProperty("username");
			password=ConfigProperties.prop.getProperty("password");
			httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);

			
			
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("user_id", userid);
		requestparams.put("skill_id", skillid);
		requestparams.put("months_of_exp", monthsofexp);
		requestparams.put("user_skill_id", userskillid);


		System.out.println("*******************"+requestparams.toString());
		response = httpRequest.body(requestparams).put();

		String userskillid = response.jsonPath().getString("userskillid");

		System.out.println("Post response is : " + response.asPrettyString());

		}


	    
	}

	@Given("User is on put skill request with endpoint")
	public void user_is_on_put_skill_request_with_endpoint() {
		RestAssured.baseURI = ConfigProperties.prop.getProperty("baseURI");
	    
	}

	@When("User sends put request with all valid skill values in request body")
	public void user_sends_put_request_with_all_valid_skill_values_in_request_body() throws IOException {
		int rowCount = excelUtil.getRowCount("Sheet5");
		System.out.println();
		
		System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			
			skill_name = excelUtil.getCellData("Sheet5", i, 0);
			skill_id1 = excelUtil.getCellData("Sheet5", i, 1);
			
			RestAssured.basePath = ConfigProperties.prop.getProperty("endpointskillapi")+"/"+skill_id1;
			username=ConfigProperties.prop.getProperty("username");
			password=ConfigProperties.prop.getProperty("password");
			httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);

			
			
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("skill_name", skill_name);
		requestparams.put("skill_id1", skill_id1);
		

		System.out.println("*******************"+requestparams.toString());
		response = httpRequest.body(requestparams).put();

		//String userskillid = response.jsonPath().getString("userskillid");

		System.out.println("Post response is : " + response.asPrettyString());

		}
	   
	}




	@Then("Status code {int} record updated should be displayed")
	public void status_code_record_updated_should_be_displayed(Integer int1) {
		// Response Body Validation
		Assert.assertNotNull(response);
		// StatusCode Validation
		response.then().assertThat().statusCode(int1.intValue());
		System.out.println("status code is:" +int1);
	}


	@When("User sends put request with non existing user with all valid parameter in request body")
	public void user_sends_put_request_with_non_existing_user_with_all_valid_parameter_in_request_body() throws IOException {
		int rowCount = excelUtil.getRowCount("Sheet2");
		System.out.println();

		//System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			id = excelUtil.getCellData("Sheet2", i, 0);
			if(StringUtils.isEmpty(id))
				break;
			RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers")+"/"+id;
			username=ConfigProperties.prop.getProperty("username");
			password=ConfigProperties.prop.getProperty("password");
			httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);

			comments = excelUtil.getCellData("Sheet2", i, 1);

			education_pg = excelUtil.getCellData("Sheet2", i, 2);
			education_ug = excelUtil.getCellData("Sheet2", i, 3);
			linkedin_url = excelUtil.getCellData("Sheet2", i, 4);
			location = excelUtil.getCellData("Sheet2", i, 5);
			name = excelUtil.getCellData("Sheet2", i, 6);
			phone_number = excelUtil.getCellData("Sheet2", i, 7);
			time_zone = excelUtil.getCellData("Sheet2", i, 8);
			visa_status = excelUtil.getCellData("Sheet2", i, 9);


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
			response = httpRequest.body(requestparams).put();

			System.out.println("Post response is : " + response.asPrettyString());


		}
	}

	@Then("Status code {int} record with Not found message")
	public void status_code_record_with_not_found_message(Integer int1) {
		// Response Body Validation
		Assert.assertNotNull(response);
		// StatusCode Validation
		response.then().assertThat().statusCode(int1.intValue());
		System.out.println("status code is:" +int1);
	}

	@When("User sends put request with existing user with all valid parameter with invalid input in request body")
	public void user_sends_put_request_with_existing_user_with_all_valid_parameter_with_invalid_input_in_request_body() throws IOException {
		int rowCount = excelUtil.getRowCount("Sheet3");
		System.out.println();

		//System.out.println("********************"+rowCount);
		for (int i = 1; i <= rowCount; i++) {
			id = excelUtil.getCellData("Sheet3", i, 0);
			if(StringUtils.isEmpty(id))
				break;
			RestAssured.basePath = ConfigProperties.prop.getProperty("endpointusers")+"/"+id;
			username=ConfigProperties.prop.getProperty("username");
			password=ConfigProperties.prop.getProperty("password");
			httpRequest=RestAssured.given().contentType("application/json").auth().basic(username, password);

			comments = excelUtil.getCellData("Sheet3", i, 1);

			education_pg = excelUtil.getCellData("Sheet3", i, 2);
			education_ug = excelUtil.getCellData("Sheet3", i, 3);
			linkedin_url = excelUtil.getCellData("Sheet3", i, 4);
			location = excelUtil.getCellData("Sheet3", i, 5);
			name = excelUtil.getCellData("Sheet3", i, 6);
			phone_number = excelUtil.getCellData("Sheet3", i, 7);
			time_zone = excelUtil.getCellData("Sheet3", i, 8);
			visa_status = excelUtil.getCellData("Sheet3", i, 9);


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
			response = httpRequest.body(requestparams).put();

			System.out.println("Post response is : " + response.asPrettyString());

		}
	}

	@Then("Status code {int} record with Bad request message")
	public void status_code_record_with_bad_request_message(Integer int1) {
		// Response Body Validation
		Assert.assertNotNull(response);
		// StatusCode Validation
		response.then().assertThat().statusCode(int1.intValue());
		System.out.println("status code is:" +int1);
	}



}
