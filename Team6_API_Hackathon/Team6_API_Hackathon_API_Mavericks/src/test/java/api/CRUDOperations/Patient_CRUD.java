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
import io.restassured.parsing.Parser;
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
	
		
		public static Response Patient_Creation(Patient_POJO patientpayload) throws JsonProcessingException
		{
			String Patient_Post= getURL().getString("Create_Patient_Post");
			File data=new File(".\\TestData\\Hypo Thyroid-Report.pdf");
			Gson gson=new Gson();
			String data1=gson.toJson(patientpayload);
			System.out.println("My data:" +data1);
			Response ID= given()
					.header("Authorization", "Bearer " +token)
					.header("Content-Type","multipart/form-data")
					 .formParam("patientInfo",data1)
									 .multiPart("file", data,"application/pdf")
					.when().log().all().config(RestAssured.config()
							.encoderConfig(EncoderConfig.encoderConfig()
									.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
					.post(Patient_Post);			
				return ID;
		}
		
		public static Response getAll_Patient()
		{
			String get_url=getURL().getString("Get_All_Patients");
			Response response=given()
					.header("Authorization", "Bearer " +token)
					.contentType(ContentType.JSON)
					.when()
					.get(get_url);
					
					return response;
		}
		
		
		public static Response get_Using_PatientID(int id)
		{
			
			String get_url_pid=getURL().getString("Get_Patients_Test_Reports");
			Response response=given()
					.header("Authorization", "Bearer " +token)
					.contentType(ContentType.JSON)
					.pathParam("patientId", id)
					.when()
					.get(get_url_pid);
					
					return response;
			}
		
		public static Response get_Patient_Using_FileID(String id)
		{
			
			String get_url_fid=getURL().getString("Retrieve_Patient_file_by_FileId");
			Response response=given()
					.header("Authorization", "Bearer " +token)
					.contentType("application/json")
					.pathParam("fileId", id)
					.when().config(RestAssured.config()
							.encoderConfig(EncoderConfig.encoderConfig()
									.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
					.get(get_url_fid);
					
					return response;
			}
		
		
		public static Response Update_Patient_Details(int pid,Patient_POJO patientpayload) throws JsonProcessingException
		{
			
			String Patient_Put= getURL().getString("Update_Patient_Put");
			File data=new File(".\\TestData\\Hypo Thyroid-Report.pdf");
			Gson gson=new Gson();
			String data1=gson.toJson(patientpayload);
					Response ID= given()
					.header("Authorization", "Bearer " +token)
					.header("Content-Type","multipart/form-data")
					.pathParam("patientId", pid)
					 .formParam("patientInfo",data1)
									.multiPart("file", data,"application/pdf")
					 
					.when().log().all().config(RestAssured.config()
							.encoderConfig(EncoderConfig.encoderConfig()
									.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
					.put(Patient_Put);
					
					
			
			return ID;
		}
		
		
		public static Response Delete_Patient_by_Id(int pid )
		{
			String del_patient_url=getURL().getString("Delete_Patient");
			pid=Env_Var.patientId;
			Response response=given().header("Authorization", "Bearer " +token)
					.contentType(ContentType.JSON)
					.pathParam("patientId", pid)
					
					.when()
					.delete(del_patient_url);
					
					return response;
		}
		
		
}
