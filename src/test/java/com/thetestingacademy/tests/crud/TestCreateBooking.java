package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.Responsed;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCreateBooking extends BaseTest {

    @Test(groups= "smoke")

    public void testCreatebooking(){
        requestSpecification.basePath((APIConstants.BASE_PATH));
        response = requestSpecification.when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        //validatable response
        validatableResponse = validatableResponse.statusCode(200);

        //Deserilization
        Responsed bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //Assert that
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotEmpty();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Karam");

        // TestNG Assertions
        assertAction.verifyStatusCode(response,200);


    }
}
