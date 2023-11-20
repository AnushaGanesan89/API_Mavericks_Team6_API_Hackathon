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
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Morbidity_TC {
	Response response;
	String extractresponse;
	
	public void Get_All_Morbidity()
	{
		
		response= Morbidity_CRUD.getAll_morbidity();
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(".\\Schema_Validators\\Get_All_Morbidity.json"));
		Loggerload.info("********You have retrieved ALL Morbidity details in the system*************");

	}
	
	public int verify_get_All_morbidity_status() {
		
		int code;
		code=response.getStatusCode();
		return code;

	}
	
	public void Get_MorbidityDetails_UsingName(String name)
	{
		
			
			response= Morbidity_CRUD.get_Morbidity_Using_Name(name);
			response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(".\\Schema_Validators\\Get_Morbidity_ByName.json"));
			Loggerload.info("You have retrieved the morbidity details associated with this Morbidity name:"+Env_Var.morbiditytestname);

			
			

		}
	
public int verify_get__morbiditybyName_status() {
		
		int code;
		code=response.getStatusCode();
		return code;

	}

}
