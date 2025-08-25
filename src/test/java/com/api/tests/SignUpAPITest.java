package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import static io.restassured.RestAssured.*; //static import ->classes which have all variable and method as static to improve readability

import java.util.Random;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SignUpAPITest {

	@Test(description = "Varify SignUp API working fine ....")
	public void signupTest()
	{
		//SignUpRequest signupRequest = new SignUpRequest(baseURI, basePath, DEFAULT_URI, DEFAULT_SESSION_ID_VALUE, DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH)
		// To solve above large parameters in constructor we create Builder Design in resp. POJO
		SignUpRequest signuprequest=new SignUpRequest.Builder().username("maple"+new Random().nextInt(100))
		.firstName("maple"+new Random().nextInt(100))
		.lastName("caple"+new Random().nextInt(100))
		.email("maple"+new Random().nextInt(100)+"@gmail.com")
		.password("maple"+new Random().nextInt(100))
		.mobileNumber("15986547"+new Random().nextInt(100))
		.build();
		
		
		AuthService service =  new AuthService();
		Response response = service.signUp(signuprequest);
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.prettyPrint(), "User registered successfully!");
		
		
	}
	
}
