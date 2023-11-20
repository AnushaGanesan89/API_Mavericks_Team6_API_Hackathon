package api.CRUDOperations;


import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ResourceBundle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import api.Payloads.*;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.GlobalVariables.*;

public class Negative_Scenario_CRUD {
	
	static String token= Env_Var.token;

	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndPoints");
		return endurl;
	}

	// To perform User_Login Request
	
	public static Response User_Login(User_Login_POJO userpayload)
	{
		String Login_Post= getURL().getString("User_Login_Post");
		Response tkn= given().auth().none()
				 .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userpayload)
				.when()
				.post(Login_Post);
		//System.out.println(tkn);
		return tkn;
	}
	
	public static Response Patient_Creation(Patient_POJO patientpayload) throws JsonProcessingException
	{
		String Patient_Post= getURL().getString("Create_Patient_Post");
		File data=new File("C:\\Users\\Prasanna\\eclipse-workspace\\API_Mavericks\\Team6_API_Hackathon\\Team6_API_Hackathon_API_Mavericks\\TestData\\Hypo Thyroid-Report.pdf");
		
		Gson gson=new Gson();
		String data1=gson.toJson(patientpayload);
		System.out.println("My data:" +data1);
		Response ID= given()
				.header("Authorization", "Bearer " +Env_Var.token)
				.header("Content-Type","multipart/form-data")
				 .formParam("patientInfo",data1)
								 .multiPart("file", data,"application/pdf")
				.when().log().all().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
				.post(Patient_Post);
				
				
		//System.out.println(ID);
		return ID;
	}
	
	public static Response Patient_Creation_noPatientInfo(Patient_POJO patientpayload) throws JsonProcessingException
	{
		String Patient_Post= getURL().getString("Create_Patient_Post");
		File data=new File("C:\\Users\\Prasanna\\eclipse-workspace\\API_Mavericks\\Team6_API_Hackathon\\Team6_API_Hackathon_API_Mavericks\\TestData\\Hypo Thyroid-Report.pdf");
		
		Gson gson=new Gson();
		String data1=gson.toJson(patientpayload);
		System.out.println("My data:" +data1);
		Response ID= given()
				.header("Authorization", "Bearer " +Env_Var.token)
				.header("Content-Type","multipart/form-data")
				 
								 .multiPart("file", data,"application/pdf")
				.when().log().all().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
				.post(Patient_Post);
				
				
		//System.out.println(ID);
		return ID;
	}
	
	public static Response Update_Patient_Details(int pid,Patient_POJO patientpayload) throws JsonProcessingException
	{
		//Env_Var.patientId=pid;
	
		String Patient_Put= getURL().getString("Update_Patient_Put");
		
		File data=new File("C:\\Users\\Prasanna\\eclipse-workspace\\API_Mavericks\\Team6_API_Hackathon\\Team6_API_Hackathon_API_Mavericks\\TestData\\Hypo Thyroid-Report.pdf");

		Gson gson=new Gson();
		String data1=gson.toJson(patientpayload);
		System.out.println(data1);
		Response ID= given()
				.header("Authorization", "Bearer " +Env_Var.token)
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
				.header("Authorization", "Bearer " +Env_Var.token)
				.contentType("application/json")
				.pathParam("fileId", id)
				
				
				
				.when().config(RestAssured.config()
						.encoderConfig(EncoderConfig.encoderConfig()
								.encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
				.get(get_url_fid);
				
				return response;
		}
	public static Response get_Morbidity_Using_Name(String name)
	{
		
		String get_url_morbidity=getURL().getString("Retrieve_Morbidity_condition_by_Test_name");
		Response response=given()
				.header("Authorization", "Bearer " +Env_Var.token)
				.contentType(ContentType.JSON)
				.pathParam("morbidityName", name)
				
				
				
				.when()
				.get(get_url_morbidity);
				
				return response;
		}
	
	public static Response Delete_Patient_by_Id(int pid )
	{
		String del_patient_url=getURL().getString("Delete_Patient");
		pid=Env_Var.patientId;
		Response response=given().header("Authorization", "Bearer " +Env_Var.token)
				.contentType(ContentType.JSON)
				.pathParam("patientId", pid)
				
				.when()
				.delete(del_patient_url);
				
				return response;
	}
}
