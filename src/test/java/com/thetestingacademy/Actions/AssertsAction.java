package com.thetestingacademy.Actions;

import io.restassured.response.Response;
import junit.framework.Assert;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

public class AssertsAction {

    public void verifyResponseBody(String actual, String expected, String description) {
        Assert.assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(float actual, float expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(double actual, double expected, String description) {
        assertEquals(actual, expected, description);

    }

    public void verifyResponseBody(boolean actual, boolean expected, String description) {
        assertEquals(actual, expected, description);
    }



    public void verifyStatusCodeInvalidReq(Response response) {
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("50"), true,
                "value of status code is" + response.getStatusCode());
    }

    //public static void verifyStatusCode(Response response, Integer expected) {
    //  assertEquals(response.getStatusCode(),expected);

    public void verifyStatusCode(Response response, int i) {
        assertEquals(String.valueOf(response.getStatusCode()).startsWith("200"), true,
                "value of status code is" + response.getStatusCode());

    }

}

