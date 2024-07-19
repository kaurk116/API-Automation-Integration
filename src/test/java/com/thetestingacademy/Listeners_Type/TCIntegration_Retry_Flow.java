package com.thetestingacademy.Listeners_Type;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.Responsed;
import com.thetestingacademy.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TCIntegration_Retry_Flow extends BaseTest {
    @Test(groups = "integration",priority = 1)
    @Owner("Karamjeet")
    @Description("TC Integration - TestCreateABooking")

    public void TestCreateABooking(ITestContext iTestContext){
        Assert.assertTrue(true);

        //Set token
        iTestContext.setAttribute("Token", getToken());

        //Post request for create booking
        requestSpecification.basePath(APIConstants.BASE_PATH);
        response = requestSpecification.when().body(payloadManager.createPayloadBookingAsString()).post();
        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);

        // DeSer
        Responsed bookingResponse = payloadManager.bookingResponseJava(response.asString());
        // System.out.println("bookingResponse is: " +bookingResponse);

        // AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Karam");

        //  Set the booking ID
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

    }
    @Test(groups = "integration",priority = 2)
    @Owner("Karamjeet")
    @Description("TC Integration - TestVerifyABooking")
    public void TestVerifyABooking(ITestContext iTestContext){
        Assert.assertTrue(true);
        //Get Token and Print
        System.out.println("Token2" + iTestContext.getAttribute("Token"));
        String Token =(String) iTestContext.getAttribute("Token");

        //get BookingId
        Integer Bookingid =(Integer) iTestContext.getAttribute("bookingid");

        //Set the  base  past of bookingID
        String basePathGET =APIConstants.BASE_PATH + "/" + Bookingid;
        System.out.println(basePathGET);

        //get the bookingId
        requestSpecification.basePath(basePathGET);
        response = requestSpecification.when().get();
        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getBookingFromJSON(response.asString());
        System.out.println("getBookingFromJSON" +booking);

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo(PropertyReader.readKey("booking.firstname"));

    }
    @Test(groups = "integration",priority = 3)
    @Owner("Karamjeet")
    @Description("TC Integration - TestUpdateABooking")
    public void TestUpdateABooking(ITestContext iTestContext){
        Assert.assertTrue(true);

        System.out.println("Token" +iTestContext.getAttribute("Token"));
        String Token =(String) iTestContext.getAttribute("Token");

        //Get BookingId
        Integer Bookingid =(Integer) iTestContext.getAttribute("bookingid");

        //set the booking Path  add the +bookingID
        String basePUTPathGET =APIConstants.BASE_PATH + "/" + Bookingid;
        System.out.println(basePUTPathGET);

        requestSpecification.basePath(basePUTPathGET);
        response = RestAssured
                .given(requestSpecification).cookie("token", Token)
                .when().body(payloadManager.UpdatePayloadBookingAsString()).put();
        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);


        Booking booking = payloadManager.getBookingFromJSON(response.asString());
        System.out.println("getBookingFromJSON PUT"  +booking);

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo(PropertyReader.readKey("booking.put.firstname"));
        assertThat(booking.getFirstname()).isEqualTo("Karamjeet");
        assertThat(booking.getLastname()).isEqualTo("Saini");


    }
    @Test(groups = "integration",priority = 4)
    @Owner("Karamjeet")
    @Description("TC Integration - TestDeleteABooking")
    public void TestDeleteABooking(ITestContext iTestContext)
    {
        System.out.println("Token" +iTestContext.getAttribute("Token"));
        String Token =(String) iTestContext.getAttribute("Token");
        Assert.assertTrue(true);

        //get bookingid set path +BookingId
        Integer Bookingid =(Integer) iTestContext.getAttribute("bookingid");
        String baseDeletePathGET =APIConstants.BASE_PATH + "/" + Bookingid;
        System.out.println(baseDeletePathGET);

        requestSpecification.basePath(baseDeletePathGET);
        response = (Response) requestSpecification.cookie("Token").when().delete();

        validatableResponse =response.then().log().all();

        validatableResponse.statusCode(403);


    }

}
