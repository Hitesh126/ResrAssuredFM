package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import static io.restassured.RestAssured.*; //static import ->classes which have all variable and method as static to improve readability
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ForgotPasswordAPITest {

	@Test(description = "Verify forgot password api is working fine...")

	public void forgotPasswordTest() {
		AuthService auth = new AuthService();
		Response response = auth.forgotPassword("deb@gmail.com");
		System.out.println(response.prettyPrint());

//		response.then().assertThat().statusCode(200)
//		.body("message", equalTo(response)); --> equalTo method not comming not working for me
		
		String actualResponse = response.jsonPath().getString("message");
		System.out.println("actual response --> " + actualResponse);
		Assert.assertEquals(actualResponse, "If your email exists in our system, you will receive reset instructions.");

		// Assert.assertEquals(response.prettyPrint(), "If your email exists in our
		// system, you will receive reset instructions.");
	}

}
