package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.saucedemo.tests.BaseTest;

public class ReportListener implements ITestListener {

    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Case: " + result.getMethod().getMethodName() + " completed successfully.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Case: " + result.getName() + " failed.");
        extentTest.log(Status.FAIL, result.getThrowable());

        // Safely grab the driver instance from the specific class currently executing the test
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();

        if (driver != null) {
            String timestamp = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 1. Saves physical screenshot inside target/reports/screenshots/
            File destFile = new File("./target/reports/screenshots/" + result.getName() + "_" + timestamp + ".png");
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 2. Links the screenshot relatively from the index.html viewpoint
            extentTest.addScreenCaptureFromPath(
                    "./screenshots/" + result.getName() + "_" + timestamp + ".png",
                    "Failure Context Screen Capture");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentSetup.setUpExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}