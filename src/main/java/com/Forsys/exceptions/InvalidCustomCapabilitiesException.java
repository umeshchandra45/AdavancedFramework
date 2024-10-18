package com.Forsys.exceptions;

import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * To surface issues with user input value for -Dcustomcapabilities.
 * 
 */
public class InvalidCustomCapabilitiesException
    extends
    RuntimeException {

    private static final long serialVersionUID = 1840935124292503023L;

    public InvalidCustomCapabilitiesException(ITestResult iTestResult, String msg) {
        super("-Dcustomcapabilities= " + msg);
    }

    public InvalidCustomCapabilitiesException(ITestContext iTestContext, String msg) {
        super("-Dcustomcapabilities=" + msg);
    }
}
