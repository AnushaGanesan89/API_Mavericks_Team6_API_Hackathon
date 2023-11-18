package api.Actions;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import api.CRUDOperations.*;
import api.Payloads.*;
import api.Utilities.Loggerload;
import api.GlobalVariables.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Patient_TC {

	Response response;
	String extractresponse;
	JsonPath jsonPathEvaluator;
	Faker faker;
	
	public void TestPostPatient(String FirstName,String LastName,String Email,String Allergy,
			String FoodCategory,String DateOfBirth) throws ParseException, JsonProcessingException
	{
		Patient_POJO patientpayload=new Patient_POJO();
		faker=new Faker();
		patientpayload.setFirstName(FirstName);
		patientpayload.setLastName(LastName);
		patientpayload.setContactNumber(faker.number().numberBetween(1000000000L, 9999999999L));
		patientpayload.setEmail(Email);
		patientpayload.setAllergy(Allergy);
		patientpayload.setFoodCategory(FoodCategory);
//		SimpleDateFormat sf = new  SimpleDateFormat("yyyy-MM-dd");
//		
//		
//		
//		
//		String input =DateOfBirth;
//		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
//		Date date = originalFormat.parse(input.toString());
//		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String formatedDate = newFormat.format(date);
		
		//System.out.println(formatedDate);
		LocalDateTime currentDate = LocalDateTime.now();
		DateOfBirth= currentDate.minusYears(20).toString();
		
		patientpayload.setDateOfBirth(DateOfBirth);
		
		response= Patient_CRUD.Patient_Creation(patientpayload);
		extractresponse=response.then().log().all().extract().response().asString();
		JsonPath js= new JsonPath(extractresponse);
		String email= js.getString("Email");
		int pid= js.getInt("patientId");
		System.out.println("email is" +email);
		System.out.println("pid is" +pid);
		Env_Var.Email=email;
		Env_Var.patientId=pid;
		
		
	}
	
public int verify_post_patient_status() {
		
		int code;
		code=response.getStatusCode();
		return code;

	}
}
