package api.Actions;

import static io.restassured.RestAssured.given;

import java.text.ParseException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.javafaker.Faker;

import api.CRUDOperations.*;
import api.Payloads.*;
import api.Utilities.Loggerload;
import api.GlobalVariables.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Negative_Scenarios_TC {
	
	Response response;
	String extractresponse;
	JsonPath jsonPathEvaluator;
	Faker faker;

	
	public void TestPostUserLogin(String password,String userLoginEmail)
	{
		User_Login_POJO userpayload=new User_Login_POJO();
		userpayload.setUserLoginEmail(userLoginEmail);
		userpayload.setPassword(password);
		response= Negative_Scenario_CRUD.User_Login(userpayload);
		extractresponse=response.then().log().all().extract().response().asString();
		JsonPath js= new JsonPath(extractresponse);
		String tkn= js.getString("token");
		//System.out.println("Token is" +tkn);
		Env_Var.token=tkn;
		Loggerload.info("Login failue: Invalid Credetials!Please enter your valid email address and password*************");

		
		
	}
	
public int verify_post_UserLogin_status() {
		
		int code;
		code=response.getStatusCode();
		return code;

	}

public void TestPostPatient(String Allergy,String FoodCategory) throws ParseException, JsonProcessingException
{
	Patient_POJO patientpayload=new Patient_POJO();
	faker=new Faker();
	
	patientpayload.setAllergy(Allergy);
	patientpayload.setFoodCategory(FoodCategory);
	
	response= Negative_Scenario_CRUD.Patient_Creation(patientpayload);
	response.then().log().all();
	
	Loggerload.info("Action failed: Please provide all mandatory details to create a new patient");

	
	
}

public int verify_post_patient_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}

public void TestPostPatient_noPatientInfo(String Allergy,String FoodCategory) throws ParseException, JsonProcessingException
{
	Patient_POJO patientpayload=new Patient_POJO();
	faker=new Faker();
	
	patientpayload.setAllergy(Allergy);
	patientpayload.setFoodCategory(FoodCategory);
	
	response= Negative_Scenario_CRUD.Patient_Creation_noPatientInfo(patientpayload);
	response.then().log().all();
	Loggerload.info("Action failed:No Patient Info Found !!!");

	
	
	
	
}
public int verify_post_nopatientinfo_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}

public void Update_Patient(String Allergy,String FoodCategory) throws ParseException, JsonProcessingException
{
	Patient_POJO patientpayload=new Patient_POJO();
	faker=new Faker();
	
	patientpayload.setFirstName(faker.name().firstName());
	patientpayload.setLastName(faker.name().lastName());
	patientpayload.setContactNumber(faker.number().numberBetween(1000000000L, 9999999999L));
	patientpayload.setEmail(faker.internet().emailAddress());
	patientpayload.setAllergy(Allergy);
	patientpayload.setFoodCategory(FoodCategory);
	LocalDateTime currentDate = LocalDateTime.now();
	String DateOfBirth= currentDate.minusYears(20).toString();
	patientpayload.setDateOfBirth(DateOfBirth);
	response= Negative_Scenario_CRUD.Update_Patient_Details(Env_Var.invalid_patientId,patientpayload);
	response.then().log().all();
	Loggerload.info("Action failed: Please Provide the correct patient Id to update the records");

		
}
public int verify_put_patient_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}

public void Get_PatientDetails_UsingID(int id)
{
	
		
		response= Negative_Scenario_CRUD.get_Using_PatientID(id);
		response.then();
		Loggerload.info("Action failed: Incorrect patientId!Records cannot be viewed");

		

	}
public int verify_get_patient_usingid_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}

public void Get_PatientFiles_UsingFileID(String id)
{
	
		
		response= Negative_Scenario_CRUD.get_Patient_Using_FileID(id);
		response.then();
		Loggerload.info("Action failed: Incorrect FileId!Records cannot be viewed");

		

	}

public int verify_get_patient_file_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}

public void Get_MorbidityDetails_UsingName(String name)
{
	
		
		response= Negative_Scenario_CRUD.get_Morbidity_Using_Name(name);
		response.then();
		Loggerload.info("Action failed: Morbidity Name doesnt match!Records cannot be viewed");

		
		

	}

public int verify_get__morbiditybyName_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}

public void TestDeletePatient(int id )
{
	

	response= Negative_Scenario_CRUD.Delete_Patient_by_Id(id);
	response.then();
	Loggerload.info("Action failed: Patient Id doesnt exists to perform delete actions!!");

	

}

public int verify_delete_patient_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}


}
