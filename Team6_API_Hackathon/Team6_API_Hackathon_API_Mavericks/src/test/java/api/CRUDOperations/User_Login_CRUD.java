package api.CRUDOperations;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;
import api.Payloads.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.GlobalVariables.*;

public class User_Login_CRUD {
	 static String token= Env_Var.token;

	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndPoints");
		return endurl;
	}

	// To perform User_POST Request
	
	public static Response User_Login(User_Login_POJO userpayload)
	{
		String Login_Post= getURL().getString("User_Login_Post");
		Response tkn= given().auth().none()
				 .contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userpayload)
				.when()
				.post(Login_Post);
		System.out.println(tkn);
		return tkn;
	}
	
	public static Response Logout_User()
	{
		String get_logout_url=getURL().getString("User_Logout_Get");
		Response response=given()
				.header("Authorization", "Bearer " +token)
				.contentType(ContentType.JSON)
				.when()
				.get(get_logout_url);
				
				return response;
	}
}
