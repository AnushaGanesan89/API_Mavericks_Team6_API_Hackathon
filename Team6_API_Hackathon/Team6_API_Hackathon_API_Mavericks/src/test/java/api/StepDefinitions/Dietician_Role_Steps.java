package api.StepDefinitions;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;




public class Dietician_Role_Steps {
	
	@When("User sends HTTPS Request and  request Body with valid emailid and password from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_valid_emailid_and_password_from_the_excel_sheet_and(String string, Integer int1) {
	    
	}
	@Then("User receives {int} Ok Status with response body and successfully logs in")
	public void user_receives_ok_status_with_response_body_and_successfully_logs_in(Integer int1) {
	    
	}

	@When("User sends HTTPS Request and request Body with mandatory and additional  fields to create a patient records from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_to_create_a_patient_records_from_the_excel_sheet_and(String string, Integer int1) {
	   
	}

	@Then("User receives {int} Created Status with response body and patient is successfully created")
	public void user_receives_created_status_with_response_body_and_patient_is_successfully_created(Integer int1) {
	    
	}

	@When("User sends HTTPS Request to retrieve all patients details")
	public void user_sends_https_request_to_retrieve_all_patients_details() {
	   
	}

	@Then("User recieves {int} OK with response body")
	public void user_recieves_ok_with_response_body(Integer int1) {
	   
	}

	@When("User sends HTTPS Request and request Body with mandatory and additional  fields to update a patient records from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_to_update_a_patient_records_from_the_excel_sheet_and(String string, Integer int1) {
	   
	}

	@Then("User recieves {int} Ok with response body with response body and patient details are successfully updated")
	public void user_recieves_ok_with_response_body_with_response_body_and_patient_details_are_successfully_updated(Integer int1) {
	   
	}

	@When("User sends HTTPS Request with valid patient id {int}")
	public void user_sends_https_request_with_valid_patient_id(Integer int1) {
	    
	}

	@Then("User recieves {int} OK with patient test report details")
	public void user_recieves_ok_with_patient_test_report_details(Integer int1) {
	    
	}

	@When("User sends HTTPS Request with valid fileid {string}")
	public void user_sends_https_request_with_valid_fileid(String string) {
	   
	}


	@When("User sends HTTPS Request to retrieve all morbidity details")
	public void user_sends_https_request_to_retrieve_all_morbidity_details() {
	   
	}

	@When("User sends HTTPS Request with morbidity test name {string}")
	public void user_sends_https_request_with_morbidity_test_name(String string) {
	   
	}

	@Then("User receives {int} OK Status with response body")
	public void user_receives_ok_status_with_response_body(Integer int1) {
	   
	}

	@When("User sends HTTPS GET Request to logout from the Dietician API")
	public void user_sends_https_get_request_to_logout_from_the_dietician_api() {
	   
	}

	@Then("User receives {int} OK Status with response body Logout successful")
	public void user_receives_ok_status_with_response_body_logout_successful(Integer int1) {
	   
	}

}
