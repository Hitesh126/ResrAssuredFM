package com.api.base;

import io.restassured.response.Response;

public class UserManagementService extends BaseService{

	private static final String BASE_BATH = "/api/users/";
	
	public Response getprofile(String token) {
		setAuthToken(token);
		return getRequest(BASE_BATH + "profile");		 
	}
	
}
