package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {

    public static ExtentReports setUpExtentReport() {
        // Enforces static naming inside target to guarantee automated clean clearing cycles
        String reportPath = "./target/reports/index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        // Updated branding details for your portfolio MVP
        extentSparkReporter.config().setDocumentTitle("SauceDemo Automation MVP");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Core UI Regression Suite");

        return extentReports;
    }
}