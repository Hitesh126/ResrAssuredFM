package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import static io.restassured.RestAssured.*; //static import ->classes which have all variable and method as static to improve readability
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest2 {

	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
				
		AuthService auth = new AuthService();
		/*Response response = auth.login("{\"username\": \"hit126\",\"password\": \"hit126\"}");
		
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		*/
		
	}
	
}
