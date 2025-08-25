package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //static import ->classes which have all variable and method as static to improve readability
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
				
		Response response = given()
				.baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json")
				.body("{\"username\": \"hit126\",\"password\": \"hit126\"}")
				.post("/api/auth/login");
		
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
}
