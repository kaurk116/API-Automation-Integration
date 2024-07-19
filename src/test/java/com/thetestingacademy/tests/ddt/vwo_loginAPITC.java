package com.thetestingacademy.tests.ddt;

import com.thetestingacademy.utils.utilsExcel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class vwo_loginAPITC {
    RequestSpecification requestSpecification;
    Response responsed;
    ValidatableResponse validatableResponse;
    Integer ID;

    @Test(dataProvider = "getData", dataProviderClass = utilsExcel.class)
    public void testVWoLoginTC(String username,String Password){
        System.out.println("-----Login the API Testing----");
        System.out.println(username);
        System.out.println(Password);


        //Payload
        vwo_pojo vwoPojo =new vwo_pojo();
        vwoPojo.setUsername(username);
        vwoPojo.setPassword(Password);
        vwoPojo.setRemember(Boolean.valueOf("false"));
        vwoPojo.getRecaptchaResponseField();

        //RestAssured code
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://app.vwo.com");
        requestSpecification.basePath("/login");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(vwoPojo).log().all();

        responsed = requestSpecification.when().post();
        validatableResponse=responsed.then();

        String RequesrString =responsed.toString();
        System.out.println(RequesrString);
        validatableResponse.statusCode(401);

    }
}

