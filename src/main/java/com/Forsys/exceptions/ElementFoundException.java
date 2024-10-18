package com.Forsys.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Forsys.ui.actions.ScreenShot;

/**
 * Exception for cases where a element was located.This is normally thrown in cases a element should
 * not be seen but is stil seen. Automatically takes screenshot and logs in the report.
 * 
 */
public class ElementFoundException
    extends
    RuntimeException {

    private static final long serialVersionUID = -5990132942450564703L;

    /**
     * Constructs a failure reason like
     * <p>
     * Sign in button missing. <br>
     * Could not find element using By.id(#sgnBtn)
     * </p>
     * 
     * @param locator {@link By} eg:By.id(#sgnBtn)
     * @param failure {@link String} eg:Sign in button missing.
     */
    public ElementFoundException(By locator, String failure) {
        super("\n" + failure + " \n Element was seen using " + locator);
    }

    /**
     * Constructs a failure reason like below and also takes a screenshot at the time of failure.
     * <p>
     * Sign in button missing. <br>
     * Could not find element using By.id(#sgnBtn)
     * </p>
     * 
     * @param locator {@link By} eg:By.id(#sgnBtn)
     * @param failure {@link String} eg:Sign in button missing.
     * @param screenShot screenshot
     */
    public ElementFoundException(By locator, String failure, ScreenShot screenShot) {
        super("\n" + failure + " \n Element was seen using " + locator + " \n" + screenShot.getLinkToScreenShot());
    }

    /**
     * Constructs a failure reason like below and also takes a screenshot at the time of failure.
     * <p>
     * Sign in button missing. <br>
     * Could not find element using By.id(#sgnBtn)
     * </p>
     * 
     * @param locator {@link By} eg:By.id(#sgnBtn)
     * @param failure {@link String} eg:Sign in button missing.
     * @param screenShot screenshot
     */
    public ElementFoundException(By locator,
                                 String failure,
                                 ScreenShot screenShot,
                                 boolean captureScreenOnException) {
        super("\n" + failure + " \n Element was seen using " + locator + " \n" + (captureScreenOnException ? screenShot
                                                                                                                       .getLinkToScreenShot()
            : ""));
    }

    /**
     * Constructs a failure reason like below and also takes a screenshot at the time of failure.
     * Use this only if you DO NOT know the {@link By} and you know only the {@link WebElement}. If
     * you know the {@link By} for the element please use the variants of this exception that
     * accepts the {@link By} as a param.
     * <p>
     * Sign in button missing. <br>
     * Could not find element.
     * </p>
     * 
     * @param failure {@link String} eg:Sign in button missing.
     * @param screenShot screenshot
     */
    public ElementFoundException(String failure, ScreenShot screenShot) {
        super("\n" + failure + " \n Element was seen using.\n" + screenShot.getLinkToScreenShot());
    }

}
