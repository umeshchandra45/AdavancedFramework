package com.Forsys.api.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentReportUtil {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static Map<Long, String> threadToExtentTestMap = new HashMap<Long, String>();
    public static Map<String, ExtentTest> nameToTestMap = new HashMap<String, ExtentTest>();

    public synchronized static ExtentReports intiateReport(String reportPath,
                                                           String strHost,
                                                           String strEnv,
                                                           String strReportName) {
        htmlReporter = new ExtentHtmlReporter(reportPath);
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        strHost = (strHost != null) ? strHost : "Your Host Info Here";
        extent.setSystemInfo("Host Name", strHost);
        strEnv = (strEnv != null) ? strEnv : "Your Env Info Here";
        extent.setSystemInfo("Environment", strEnv);
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        strReportName = (strReportName != null) ? strReportName : "Confiance Test Execution Report";
        htmlReporter.config().setDocumentTitle(strReportName);
        // Name of the report
        htmlReporter.config().setReportName(strReportName);
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);
        return extent;
    }

    public synchronized static ExtentTest getTest(String testName) {
        // if this test has already been created return
        if (!nameToTestMap.containsKey(testName)) {
            Long threadID = Thread.currentThread().getId();
            ExtentTest test = extent.createTest(testName);
            nameToTestMap.put(testName, test);
            threadToExtentTestMap.put(threadID, testName);
        }
        return nameToTestMap.get(testName);
    }

    public synchronized static ExtentTest getTest() {
        Long threadID = Thread.currentThread().getId();

        if (threadToExtentTestMap.containsKey(threadID)) {
            String testName = threadToExtentTestMap.get(threadID);
            return nameToTestMap.get(testName);
        }
        // system log, this shouldnt happen but in this crazy times if it did happen log it.
        return null;
    }

    public static void closeReport() {
        extent.flush();
    }

    public static void logFail(ExtentTest extent, String strMenthodName, String strThrowable) {
        extent.log(Status.FAIL,
                   MarkupHelper.createLabel(strMenthodName + " - Test Case Failed", ExtentColor.RED));
        extent.log(Status.FAIL,
                   MarkupHelper.createLabel(strThrowable + " - Test Case Failed", ExtentColor.RED));
    }

    public static void logSkip(ExtentTest extent, String strMethodName) {
        extent.log(Status.SKIP,
                   MarkupHelper.createLabel(strMethodName + " - Test Case Skipped", ExtentColor.ORANGE));
    }

    public static void logSuccess(ExtentTest extent, String strMethodName) {
        extent.log(Status.PASS,
                   MarkupHelper.createLabel(strMethodName + " - Test Case PASSED", ExtentColor.GREEN));
    }
    
    public static String encodeFileToBase64Binary(File file) {
        String encodedfile = "";

        try (FileInputStream fileInputStreamReader = new FileInputStream(file);) {
            byte[] bytes = new byte[(int) file.length()];
            fileInputStreamReader.read(bytes);
            encodedfile = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {
            System.out.println("Screenshot not found");
            e.printStackTrace(System.out);
        } catch (IOException e) {
            System.out.println("Failed to read screenshot");
            e.printStackTrace(System.out);
        }

        return encodedfile;
    }

}
