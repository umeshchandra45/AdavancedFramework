package com.Forsys.testng.utils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlTest;

/**
 * Helper class to extract config/test params.DO NOT USE IN TEST
 * 
 */
public class TestParamsHelper {

    private ITestContext tc;
    private ITestResult tr;
    public static Map<String, String> testParamsMap = new ConcurrentHashMap<String, String>();
    public static List<String> notSpecifiedList = new CopyOnWriteArrayList<String>();
    public static final String ON = "ON";
    public static final String TRUE = "TRUE";
    public String defaultValue;
    public static final String NO_DEFAULT = "NA";
    public boolean userDefinedParam = false;

    TestParamsHelper(ITestContext tc, String defaultValue) {
        this.tc = tc;
        this.defaultValue = defaultValue;
        userDefinedParam = true;
    }

    public TestParamsHelper(ITestResult tr, String defaultValue) {
        this.tr = tr;
        this.defaultValue = defaultValue;
        userDefinedParam = true;
    }

    private synchronized String getParamNameWithTest(XmlTest xmlTest, String paramName) {
        return ((xmlTest == null) ? "-D" : xmlTest.getName()) + paramName;
    }

    /**
     * @param paramName
     * @return
     */
    public synchronized String getValue(String paramName) {
        String paramNameWithTestTag;
        XmlTest xmlTest = getXmlTest();
        paramNameWithTestTag = getParamNameWithTest(xmlTest, paramName);
        // IF THE VALUE IS ALREADY SET FOR THE PARAM AT CURRENT TEST USE IT AND SAVE
        // LOOK UP.
        if (testParamsMap.containsKey(paramNameWithTestTag)) {
            return testParamsMap.get(paramNameWithTestTag);
        }
        // READ FROM SYS PROP FIRST TO ADDRESS mvn -D params.
        String paramValue = System.getProperty(paramName);
        if ((paramValue == null || paramValue.contains("$" + paramName) || paramValue.contains("%" + paramName))) {
            try {
                // get from <parameter> withing <test> tag.
                paramValue = xmlTest.getLocalParameters().get(paramName);
                if (paramValue == null) {
                    // if <parameter> is not seen inside <test> tag, use from within
                    // <suite>
                    paramValue = xmlTest.getParameter(paramName);
                }
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("'" + paramName);
                sb.append("' was not specified as -D arg and also Unable to get ");
                sb.append(paramName + " from xmlTest so default is set to '");
                sb.append(defaultValue + "'. If you specify the param in testNg xml");
                sb.append(" and are trying to read it, read as ");
                sb.append("TestParams.YourParamEnv.yourparam.from(iTestResult).get() OR");
                sb.append(" TestParams.YourParamEnv.yourparam.from(iTestContext).get()");
                for (StackTraceElement stack : Thread.currentThread().getStackTrace()) {
                    sb.append("\n" + stack.getClassName() + "." + stack.getMethodName() + " Line:");
                    sb.append(stack.getLineNumber());
                }
            }

        }
        if (paramValue == null || paramValue.contains("$" + paramName) || paramValue.contains("%" + paramName)) {
            notSpecifiedList.add(paramNameWithTestTag);
            paramValue = defaultValue;
        }
        testParamsMap.put(paramNameWithTestTag, paramValue);
        return paramValue;
    }

    /**
     * @return
     */
    private XmlTest getXmlTest() {
        XmlTest xmlTest = null;
        if (tc != null) {
            xmlTest = tc.getCurrentXmlTest();
        } else if (tr != null) {
            xmlTest = tr.getTestContext().getCurrentXmlTest();
        } else {
            xmlTest = getCurrentXmlTestFromReporter();
        }
        return xmlTest;
    }

    /**
     * Gets context from Reporter.
     * 
     * @return {@link ITestContext}
     */
    private synchronized ITestContext getCurrentTestContextFromReporter() {
        ITestResult tr = Reporter.getCurrentTestResult();
        ITestContext iTestContext = tr == null ? null : tr.getTestContext();
        return iTestContext;
    }

    /**
     * Gets {@link XmlTest} from {@link ITestContext}
     * 
     * @return {@link XmlTest}
     */
    private synchronized XmlTest getCurrentXmlTestFromReporter() {
        ITestContext itc = getCurrentTestContextFromReporter();
        return itc == null ? null : itc.getCurrentXmlTest();
    }
}
