package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*; //static import ->classes which have all variable and method as static to improve readability
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listners.TestListner.class)
public class LoginAPITest3 {

	@Test(description = "Verify if Login API is working...")
	public void loginTest() {
		// create opject of POJO class LoginRequest
		LoginRequest loginrequest = new LoginRequest("hit126", "hit126");

		// Create object of AuthService and use method login
		AuthService auth = new AuthService();
		Response response = auth.login(loginrequest);
		System.out.println(response.asPrettyString());

		// Deserialize Json response into object, first create pojo for response
		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println(loginResponse.getType());
		System.out.println(loginResponse.getId());
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getRoles());

		Assert.assertTrue(loginResponse.getType() != null);
		Assert.assertEquals(loginResponse.getType(), "Bearer");
		Assert.assertEquals(loginResponse.getId(), 2383);
		Assert.assertEquals(loginResponse.getUsername(), "hit126");
		Assert.assertEquals(loginResponse.getEmail(), "hit@gmail.com");
		// Assert.assertEquals(loginResponse.getRoles(), "ROLE_USER");
		response.jsonPath().getString("roles[0]");

		/*
		  int count = response.jsonPath().getInt("roles.size()");
		  System.out.println("roles array count --> "+count);
		   
		  // Loop through and print ID & Name 
		   for (int i = 0; i < count; i++) { 
		  		String id = js.getString("customers[" + i + "].id"); 
		  		String name = js.getString("customers[" + i + "].name"); 
		  		System.out.println("Customer ID: " + id + " | Name: " + name); 
		  	}
		 */
		
		// Other way to validate array data like ROLE_USER
		/*
		 ✅ Using RestAssured + Hamcrest (best for API tests)

				response.then()
        		.statusCode(200)
        		.body("roles", hasItem("ROLE_USER"));


				roles → refers to the JSON array.

				hasItem("ROLE_USER") → checks if "ROLE_USER" is one of the elements.

		 ✅ Using TestNG/JUnit Assert (if you extract as a List)
				
				List<String> roles = response.jsonPath().getList("roles");
				Assert.assertTrue(roles.contains("ROLE_USER"), "ROLE_USER not found in roles");


		 ✅ If you only want to check the first role
				
				String role = response.jsonPath().getString("roles[0]");
				Assert.assertEquals(role, "ROLE_USER");


		 ⚡ Recommended for flexibility (in case more roles get added later):

				response.then().body("roles", hasItem("ROLE_USER")); 
		 
		 * */

	}

}
