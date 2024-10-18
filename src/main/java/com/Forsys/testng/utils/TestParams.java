package com.Forsys.testng.utils;

import org.testng.ITestResult;

public class TestParams {

    public static String getBrowser(ITestResult iTestResult) {
        return new TestParamsHelper(iTestResult, "CHROME").getValue("Browser");
    }

    public static String getGrid(ITestResult iTestResult) {
        return new TestParamsHelper(iTestResult, "").getValue("SeleniumGrid");
    }

    public static String isHeadless(ITestResult iTestResult) {
        return new TestParamsHelper(iTestResult, null).getValue("Headless");
    }

    public static String getDriverExePath(ITestResult iTestResult) {
        return new TestParamsHelper(iTestResult, null).getValue("DriverExePath");
    }
}
