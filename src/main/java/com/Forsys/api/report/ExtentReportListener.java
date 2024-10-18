package com.Forsys.api.report;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNG;

import com.Forsys.exceptions.ReportConfigException;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentReportListener
    implements
    ITestListener {
    private static String outdir;

    public static ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();

    @SuppressWarnings("deprecation")
    @Override
    public synchronized void onStart(ITestContext context) {
        String strHostName = context.getCurrentXmlTest().getParameter("confiance.report.host");
        String strReportHeader = context.getCurrentXmlTest().getParameter("confiance.report.reportheader");
        String strEnv = context.getCurrentXmlTest().getParameter("confiance.report.env");
        String archive_report = context.getCurrentXmlTest().getParameter("archive.confiance.report");
        if (archive_report == null) {
            archive_report = "false";
        }
        Method f;
        outdir = "";
        if (archive_report.equalsIgnoreCase("yes") || archive_report.equalsIgnoreCase("true")) {
            String archivePath = "";
            try {
                f = TestNG.class.getMethod("setOutputDirectory", String.class);
                archivePath = System.getProperty("user.dir") + File.separator + "EAAutomationExecutionReports/" +
                              context.getName();
                try {
                    if (new File(archivePath).mkdirs()) {
                        // if success, just ignore
                    } else {
                        FileUtils.deleteDirectory(new File(archivePath));
                    }
                } catch (Exception e) {
                    throw new ReportConfigException(e.getMessage(), e);
                }
                outdir = archivePath;
                Object a[] = {outdir};
                f.invoke(TestNG.getDefault(), a);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        } else {
            try {
                f = TestNG.class.getMethod("getOutputDirectory");
                Object a[] = {};
                outdir = (String) f.invoke(TestNG.getDefault(), a);
            } catch (Exception e) {
                throw new ReportConfigException("Unable to read report directory", e);
            }
        }
        ExtentReportUtil.intiateReport(outdir + "/EAAutomationExecutionReport.html",
                                       strHostName,
                                       strEnv,
                                       strReportHeader);
    }

    @SuppressWarnings("deprecation")
    @Override
    public synchronized void onFinish(ITestContext context) {
        Method f;
        try {
            f = TestNG.class.getMethod("getOutputDirectory");
            Object a[] = {};
            outdir = (String) f.invoke(TestNG.getDefault(), a);
            ExtentReportUtil.closeReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        List<String> listeners = new ArrayList<String>();
        listeners = result.getTestContext().getSuite().getXmlSuite().getListeners();
        if (listeners.contains("com.Forsys.api.report.ExtentReportListener")) {
            ExtentTest extentTest = ExtentReportUtil.extent.createTest(result.getMethod().getMethodName());
            extent_test.set(extentTest);
        }
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        extent_test.get().pass(MarkupHelper.createLabel(result.getName() + " - Test Case PASSED", ExtentColor.GREEN));
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        extent_test.get().fail(MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
        extent_test.get()
                   .fail(
                         MarkupHelper.createLabel(result.getThrowable().toString() + " - Test Case Failed",
                                                  ExtentColor.RED));
        try {
            extent_test.get()
                       .fail(result.getThrowable().toString() + " - Failed screenshot",
                             MediaEntityBuilder
                                               .createScreenCaptureFromBase64String(ExtentReportUtil.encodeFileToBase64Binary(
                                                                                                                              getLatestFilefromDir(System.getProperty("user.dir") +
                                                                                                                                                   "/test-output/screenshots/")))
                                               .build());
        } catch (IOException e) {
            System.out.println("Failed to take screenshot in onTestFailure");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        extent_test.get().skip(MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    public static String getOutdir() {
        return outdir;
    }

    private File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }

        return lastModifiedFile;
    }

}
