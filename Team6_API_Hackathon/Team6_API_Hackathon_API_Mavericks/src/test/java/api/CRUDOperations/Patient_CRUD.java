package api.CRUDOperations;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;

import api.Payloads.*;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import api.GlobalVariables.*;

public class Patient_CRUD {
 static String token= Env_Var.token;
	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndPoints");
		return endurl;
	}
	
	// To perform Patient_POST Request
	
		@SuppressWarnings("deprecation")
		public static Response Patient_Creation(Patient_POJO patientpayload) throws JsonProcessingException
		{
			String Patient_Post= getURL().getString("Create_Patient_Post");
			File data=new File("C:\\Users\\Prasanna\\eclipse-workspace\\API_Mavericks\\Team6_API_Hackathon\\Team6_API_Hackathon_API_Mavericks\\TestData\\Hypo Thyroid-Report.pdf");
			// String payload = "{\"FirstName\":\"Anki\", \"LastName\":\"Abcde\", \"ContactNumber\":\"1234504590\",\"Email\":\"abc.124@gmail.com\", \"Allergy\":\"None\", \"FoodCategory\":\"Vegan\", \"DateOfBirth\":\"1983-02-01\"}";
//System.out.println(patientpayload);
//System.out.println("My non data" +payload);
//ObjectMapper mapper= new ObjectMapper();
//mapper.enable(SerializationFeature.INDENT_OUTPUT);
//mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES , false);
//String data1=mapper.writeValueAsString(patientpayload);
Gson gson=new Gson();
String data1=gson.toJson(patientpayload);
System.out.println("My data:" +data1);
			//HashMap<String,Object> data1= mapper.convertValue(patientpayload, HashMap.class);
			Response ID= given()
					.header("Authorization", "Bearer " +token)
					.header("Content-Type","multipart/form-data")
					 .formParam("patientInfo",data1)
									 .multiPart("file", data,"application/pdf")
					 //.contentType(("multipart/form-data"))
					.when().log().all().config(RestAssured.config()
							.encoderConfig(EncoderConfig.encoderConfig()
									.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
					.post(Patient_Post);
					
					
			//System.out.println(ID);
			return ID;
		}
}
