package com.api.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listners.TestListner.class)
public class ProfileAPITest {

	@Test(description = "Verify user profile API working fine ...")
	public void profileTest(){
		// to generate token first we need to login using authservise
		AuthService auth = new AuthService();
		Response response = auth.login(new LoginRequest("hit126", "hit126"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		System.out.println(loginResponse.getToken());
		
		UserManagementService ums = new UserManagementService();
		 response=ums.getprofile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
	}
}
