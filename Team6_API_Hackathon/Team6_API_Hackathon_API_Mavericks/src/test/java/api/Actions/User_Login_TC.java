package api.Actions;


import static io.restassured.RestAssured.given;

import api.CRUDOperations.*;
import api.Payloads.*;
import api.Utilities.Loggerload;
import api.GlobalVariables.*;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class User_Login_TC {

	Response response;
	String extractresponse;
	JsonPath jsonPathEvaluator;
	
	//Dietician Login
	public void TestPostUserLogin(String password,String userLoginEmail)
	{
		User_Login_POJO userpayload=new User_Login_POJO();
		userpayload.setUserLoginEmail(userLoginEmail);
		userpayload.setPassword(password);
		response= User_Login_CRUD.User_Login(userpayload);
		extractresponse=response.then().log().all().extract().response().asString();
		JsonPath js= new JsonPath(extractresponse);
		String tkn= js.getString("token");
		//System.out.println("Token is" +tkn);
		Env_Var.token=tkn;
		Loggerload.info("***************** Dietician has logged in Successfully***************");
		
		
	}
	
public int verify_post_UserLogin_status() {
		
		int code;
		code=response.getStatusCode();
		return code;

	}

//Patient Login

public void TestPostPatientLogin(String password)
{
	User_Login_POJO userpayload=new User_Login_POJO();
	userpayload.setUserLoginEmail(Env_Var.Email);
	userpayload.setPassword(password);
	response= User_Login_CRUD.User_Login(userpayload);
	extractresponse=response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(".\\Schema_Validators\\Login_Post.json")).log().all().extract().response().asString();
	JsonPath js= new JsonPath(extractresponse);
	String tkn= js.getString("token");
	//System.out.println("Token is" +tkn);
	Env_Var.token=tkn;
	Loggerload.info("***************** Patient has logged in Successfully***************");

	
	
}

public int verify_post_Patient_Login_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}


public void Get_Logout()
{
	
	response= User_Login_CRUD.Logout_User();
	response.then();
	Loggerload.info("***************** User has logged out Successfully***************");

}

public int verify_get_logout_status() {
	
	int code;
	code=response.getStatusCode();
	return code;

}
}
