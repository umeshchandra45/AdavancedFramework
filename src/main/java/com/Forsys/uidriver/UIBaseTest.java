package com.Forsys.uidriver;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Class to be inherited by UI Automation Tests that do not need to create testdata via
 * TestDataListener.
 * 
 */
public class UIBaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(ITestContext context) {

    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest(ITestContext context) {

    }

    public void captureScreen(WebDriver driver) {

    }
}
