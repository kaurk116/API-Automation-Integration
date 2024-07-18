package com.thetestingacademy.base;

import com.thetestingacademy.Actions.AssertsAction;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modulers.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseTest extends PayloadManager{
    public RequestSpecification requestSpecification;
    public AssertsAction assertAction;
    public  PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


   @Test
    public void setUp(){
        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertAction = new AssertsAction();
        /*requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();*/

        requestSpecification = RestAssured.
                given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON)
                .log().all();

    }
    public String getToken(){
        //set up the url
        requestSpecification  = RestAssured.given().baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);

        String Payload =PayloadManager.setPayloadAuth();
        //set Up the payload and set the response
        response = requestSpecification
                .contentType(ContentType.JSON)
                .body(setPayloadAuth())
                .when().post();

        // Extracting of the Token via Deserialization.
        String token = getTokenFromJSON(response.asString()).toString();
        //verify
        return token;

    }

}
