package com.thetestingacademy.tests.extendDemo;

import com.thetestingacademy.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TCIntegrationFlowExtend extends BaseTest {
    @Test(groups = "integration",priority = 1)
    @Owner("Karamjeet")
    @Description("TC Integration - TestCreateABooking")
    public void TestCreateABooking(ITestContext iTestContext){
        iTestContext.setAttribute("Token",getToken());
        Assert.assertTrue(true);
    }

    @Test(groups = "integration",priority = 2)
    @Owner("Karamjeet")
    @Description("TC Integration - TestVerifyABooking")
    public void TestVerifyABooking(ITestContext iTestContext){
        System.out.println("Token Booking" +iTestContext.getAttribute("Token"));
        Assert.assertTrue(true);

    }
    @Test(groups = "integration",priority = 3)
    @Owner("Karamjeet")
    @Description("TC Integration - TestUpdateABooking")
    public void TestUpdateABooking(ITestContext iTestContext){
        System.out.println("Token" + iTestContext.getAttribute("Token"));

        Assert.assertTrue(true);

    }
    @Test(groups = "integration",priority = 4)
    @Owner("Karamjeet")
    @Description("TC Integration - TestDeleteABooking")
    public void TestDeleteABooking(ITestContext iTestContext){
        System.out.println("TokenDelete"  +iTestContext.getAttribute("Token"));
        Assert.assertTrue(true);
    }

}

