package api.CRUDOperations;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.GlobalVariables.Env_Var;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Morbidity_CRUD {
	static String token= Env_Var.token;
	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndPoints");
		return endurl;
	}
	
	
	public static Response getAll_morbidity()
	{
		String get_url_allmorbidity=getURL().getString("Get_All_Morbidities");
		Response response=given()
				.header("Authorization", "Bearer " +token)
				.contentType(ContentType.JSON)
				.when()
				.get(get_url_allmorbidity);
				
				return response;
	}
	
	public static Response get_Morbidity_Using_Name(String name)
	{
		
		String get_url_morbidity=getURL().getString("Retrieve_Morbidity_condition_by_Test_name");
		Response response=given()
				.header("Authorization", "Bearer " +token)
				.contentType(ContentType.JSON)
				.pathParam("morbidityName", name)
				
				
				
				.when()
				.get(get_url_morbidity);
				
				return response;
		}

}
