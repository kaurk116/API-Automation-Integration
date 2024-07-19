package com.thetestingacademy.tests.extendDemo;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class TestNG_Listener implements ITestListener{


    @Override
    public void onTestStart(ITestResult result) {
        ExtendManager.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendManager.getInstance().flush();

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendManager.getInstance().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtendManager.getInstance().flush();
    }

    @Override
    public void onStart(ITestContext context) {
        ExtendManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtendManager.getInstance().flush();
    }
}
