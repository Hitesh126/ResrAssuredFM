package com.api.base;

import static io.restassured.RestAssured.*;

import org.codehaus.groovy.transform.sc.transformers.StaticCompilationTransformer;

import com.api.filters.LoggingFilters;
import com.api.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	/*
	 * Design pattern - SOM(Service Object Pattern) Wrapper for Rest Assured (Here
	 * Abstraction starts to come into picture) Base URI Creating Request Handling
	 * the Response
	 */

	/*
	 * Constant are always come in uppercase If its constant it will be marked with
	 * Final keyword if something become final it should be static for variables not
	 * for methods
	 */
	private static final String BASE_URL = "http://64.227.160.186:8080";

	// Create an instance variable for requestSpecification interface
	private RequestSpecification requestSpecification;

	// Introducing filter in static block because we want to execute it only once
	static {
		RestAssured.filters(new LoggingFilters());
	}
	
	
	
	
	// create default constructor to initialize the instance variable
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		 requestSpecification.header("Authorization: ","Bearer "+ token);
	}
	
	/* Create a Post method */
	protected Response postRequest(Object payload , String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	
	/* Create a Get method*/
	protected Response getRequest(String endPoint) {
		return requestSpecification.get(endPoint);
	}

}
