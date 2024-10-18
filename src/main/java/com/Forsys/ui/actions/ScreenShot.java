package com.Forsys.ui.actions;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * This class captures screenshot and html source from web page.
 */
public class ScreenShot {
    private final String HTMLS_DIR = "htmls/";
    private final String SCREENSHOTS_DIR = "screenshots/";
    private final String FORWARD_SLASH = "/";
    private final String HTML_EXTENSION = ".html";
    private final String SCREEN_SHOT_EXTENSION = ".png";
    private final String TEST_OUTPUT_DIR = "test-output/";
    private WebDriver driver;
    private String outputDirectory = TEST_OUTPUT_DIR;
    private String fileName;

    public ScreenShot(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;
    }

    /**
     * Using this means that that the screenshot is enabled by force for the current instance of
     * {@link ScreenShot} and it cannot be turned off via ci config.
     * 
     */
    public ScreenShot forceScreenshot() {
        return this;
    }

    /**
     * Captures the screenshot and html source of the current page when the SCREENSHOT system
     * property is set to 'on'. eg:SCREENSHOT=ON in bat and your pom.xml should have the SCREENSHOT
     * property defined.
     * <p>
     * This method is designed to work both on RemoteWebDriver and local driver.
     * </p>
     * <b>USAGE:</b>
     * <p>
     * To capture the screenshot explicitly for a step and show it in logs please use as below.
     * <b>If you are using SoftAssertor screenshots are captured automatically.</b> For any
     * assertions failures and automatically shown in the report you do not have to write the below
     * step.
     * 
     * <code><br>Reporter.log(new ScreenShot(driver).forceScreenshot().getLinkToScreenShot());</code>
     * </p>
     * 
     */
    public String getLinkToScreenShot() {
        try {
            // If the driver is RemoteWebDriver then augment it to enable
            // screenshots on it.
            if (driver instanceof RemoteWebDriver) {
                driver = new Augmenter().augment(driver);
            }

            if (Reporter.getCurrentTestResult() != null && Reporter.getCurrentTestResult().getTestContext() != null) {
                outputDirectory = Reporter.getCurrentTestResult().getTestContext().getOutputDirectory();
            }
            fileName = getRandomHashCode("web");

            saveScreenShot(driver);

            StringBuilder debugInfo = new StringBuilder();
            saveHtmlSource(driver.getPageSource());
            debugInfo.append("<a href='" + driver.getCurrentUrl() + "' target='url'>url</a>");
            debugInfo.append(" | <a href='" + HTMLS_DIR + fileName + HTML_EXTENSION + "' target='html'>html</a>|");

            debugInfo.append("  <a href='" + SCREENSHOTS_DIR + fileName + SCREEN_SHOT_EXTENSION +
                             "' target='screenshot'>screenshot</a>");
            return debugInfo.toString();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info("Could not capture screenshot due to:" + e);
        }
        return "";
    }

    private void saveHtmlSource(String htmlSource) {
        if (htmlSource != null) {
            try {
                FileUtils.writeStringToFile(new File(outputDirectory + FORWARD_SLASH + HTMLS_DIR + fileName +
                                                     HTML_EXTENSION), htmlSource, "UTF8");
            } catch (IOException e) {
                ExtentReportListener.extent_test.get().info("Could not save html source due to:" + e);
            }
        }
    }

    public File saveScreenShot(WebDriver driver) {
        File destFile = null;
        try {
            fileName = getRandomHashCode("web");
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            destFile = new File(System.getProperty("user.dir") + FORWARD_SLASH + outputDirectory + FORWARD_SLASH +
                                SCREENSHOTS_DIR +
                                fileName + SCREEN_SHOT_EXTENSION);
            FileUtils.copyFile(scrFile, destFile);
        } catch (IOException e) {
            ExtentReportListener.extent_test.get().info("Could not save screenshot due to:" + e);
        }
        return destFile;
    }

    private String getRandomHashCode(String seed) {
        byte[] data = (UUID.randomUUID().getLeastSignificantBits() + seed).getBytes();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, digest.digest(data)).toString(16);
        } catch (Exception e) {
            return new String(data);
        }
    }
}
