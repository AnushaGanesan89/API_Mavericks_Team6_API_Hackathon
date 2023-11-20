package api.StepDefinitions;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import api.Actions.*;
import api.CRUDOperations.*;
import api.Payloads.*;
import io.restassured.response.Response;
import api.Utilities.ExcelReader;
import api.GlobalVariables.*;



public class Dietician_Role_Steps {
	
	User_Login_TC utc= new User_Login_TC();
	Patient_TC ptc= new Patient_TC();
	Morbidity_TC mtc= new Morbidity_TC();
		
	@When("User sends HTTPS Request and  request Body with valid emailid and password from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_valid_emailid_and_password_from_the_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\API_MAVERICKS_RESTASSURED_DATA.xlsx", SheetName);
		String password=testData.get(RowNumber).get("password");
		String userLoginEmail=testData.get(RowNumber).get("userLoginEmail");
		utc.TestPostUserLogin(password, userLoginEmail);
		
	}
	@Then("User receives {int} Ok Status with response body and successfully logs in")
	public void user_receives_ok_status_with_response_body_and_successfully_logs_in(Integer int1) {
	    int1= utc.verify_post_UserLogin_status();
	    int Expected=200;
	    Assert.assertEquals(int1, Expected);
	}

	@When("User sends HTTPS Request and request Body with mandatory and additional  fields to create a patient records from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_to_create_a_patient_records_from_the_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, ParseException {
	   
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\API_MAVERICKS_RESTASSURED_DATA.xlsx", SheetName);
		
		String Allergy=testData.get(RowNumber).get("Allergy");
		String FoodCategory=testData.get(RowNumber).get("FoodCategory");
		
		ptc.TestPostPatient( Allergy, FoodCategory);
		
		
		
	}

	@Then("User receives {int} Created Status with response body and patient is successfully created")
	public void user_receives_created_status_with_response_body_and_patient_is_successfully_created(Integer int1) {
		    int1= ptc.verify_post_patient_status();
		    int Expected=201;
		    Assert.assertEquals(int1, Expected);
	    
	}

	@When("User sends HTTPS Request to retrieve all patients details")
	public void user_sends_https_request_to_retrieve_all_patients_details() {
		
		ptc.Get_All_Patient();
	   
	}

	@Then("User recieves {int} OK with response body")
	public void user_recieves_ok_with_response_body(Integer int1) {
		int1=ptc.verify_get_patient_status();
		int expected= 200;
		Assert.assertEquals(int1, expected);
	   
	}

	@When("User sends HTTPS Request and request Body with mandatory and additional  fields to update a patient records from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_to_update_a_patient_records_from_the_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException, ParseException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\API_MAVERICKS_RESTASSURED_DATA.xlsx", SheetName);
		
		String Allergy=testData.get(RowNumber).get("Allergy");
		String FoodCategory=testData.get(RowNumber).get("FoodCategory");
		
		
		
		ptc.Update_Patient(Allergy,FoodCategory);
	}

	@Then("User recieves {int} Ok with response body with response body and patient details are successfully updated")
	public void user_recieves_ok_with_response_body_with_response_body_and_patient_details_are_successfully_updated(Integer int1) {
		int1=ptc.verify_put_patient_status();
		int expected=200;
		Assert.assertEquals(int1, expected);
	   
	}

	@When("User sends HTTPS Request with valid patient id {int}")
	public void user_sends_https_request_with_valid_patient_id(Integer int1) {
		 int1= Env_Var.patientId;
		    ptc.Get_PatientDetails_UsingID(int1);
	    
	}

	@Then("User recieves {int} OK with patient test report details")
	public void user_recieves_ok_with_patient_test_report_details(Integer int1) {
		int1=ptc.verify_get_patient_usingid_status();
		int expected= 200;
		Assert.assertEquals(int1, expected);
	}

	@When("User sends HTTPS Request with valid fileid {string}")
	public void user_sends_https_request_with_valid_fileid(String string) {
		
		string= Env_Var.fileid;
		ptc.Get_PatientFiles_UsingFileID(string);
	   
	}

	@Then("User recieves {int} OK with patient test report files")
	public void user_recieves_ok_with_patient_test_report_files(Integer int1) {
		int1=ptc.verify_delete_patient_status();
		int expected= 200;
		Assert.assertEquals(int1, expected);
	}

	@When("User sends HTTPS Request to retrieve all morbidity details")
	public void user_sends_https_request_to_retrieve_all_morbidity_details() {
		mtc.Get_All_Morbidity();
	   
	}
	
	@Then("User recieves {int} OK with response body with all morbidities")
	public void user_recieves_ok_with_response_body_with_all_morbidities(Integer int1) {
		 int1=mtc.verify_get_All_morbidity_status();
		    int expected= 200;
			Assert.assertEquals(int1, expected);
	}

	


	@When("User sends HTTPS Request with morbidity test name {string}")
	public void user_sends_https_request_with_morbidity_test_name(String string) {
		string=Env_Var.morbiditytestname;
		mtc.Get_MorbidityDetails_UsingName(string);
	   
	}
	
	@Then("User recieves {int} OK with response body with the details of morbidity test name")
	public void user_recieves_ok_with_response_body_with_the_details_of_morbidity_test_name(Integer int1) {
		 int1=mtc.verify_get__morbiditybyName_status();
		    int expected= 200;
			Assert.assertEquals(int1, expected);
	}

	

	@When("User sends HTTPS GET Request to logout from the Dietician API")
	public void user_sends_https_get_request_to_logout_from_the_dietician_api() {
	   utc.Get_Logout();
	}

	@Then("User receives {int} OK Status with response body Logout successful")
	public void user_receives_ok_status_with_response_body_logout_successful(Integer int1) {
	utc.verify_get_logout_status();
	   
	}

}
