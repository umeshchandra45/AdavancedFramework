
package com.Forsys.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.Forsys.enums.BrowserType;
import com.Forsys.enums.Classification;
import com.Forsys.enums.Priority;

/**
 * This annotation is to be used in test.
 * 
 */
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface Automate {

    public static final String NOT_SPECIFIED = "NOT_SPECIFIED";

    /**
     * Use to mark priorities for your automated test. <br>
     * <br>
     * <b>Sample: </b><code>priority=Priority.P1</code>
     */
    Priority priority() default Priority.NOT_SPECIFIED;

    /**
     * Use to group a test to a particular browser. <b>Sample:</b>
     * <code>browser=BrowserType.CHROME</code><br>
     * <b>Sample:</b> <code>browser={BrowserType.CHROME, BrowserType.FF}</code>
     */
    BrowserType[] browser() default BrowserType.NOT_SPECIFIED;

    /**
     * Use to group a test to a particular classification. eg:BVT, REGRESSION, FEATURE
     * <b>Sample:</b><code>classification=Classification.BVT</code><br>
     * <b>Sample:</b> <code>classification={Classification.BVT, Classification.REGRESSION}</code>
     * <br>
     */
    Classification[] classification() default Classification.NOT_SPECIFIED;

    /**
     * Set this to false, to write a non UI test method inside a class containing UI tests that
     * extend UIBaseTest or UIBaseTestWithData. When set to false, prevents the method from
     * pre-launching launching browser and launching on-demand drivers via UIListener.
     */
    boolean uiTest() default true;

    /**
     * Set this to false if, your test method is within a class that extends UIBaseTest or
     * UIBaseTestWithData and DOES NOT need a prelaunched driver. Note: If this is set to false, the
     * test method should not access UIListener.uiDriver.get(); however,
     * UIListener.getOnDemandDriver methods are ok to be used.
     */
    boolean prelaunchBrowser() default true;

    /**
     * Set this to false if, your test method is within a class that extends UIBaseTest or
     * UIBaseTestWithData and DOES NOT need driver clean up or quit. Note: If this is set to false,
     * the test method is expected to take care of browser cleanup/quits
     */
    boolean autoCleanDriver() default true;

}
