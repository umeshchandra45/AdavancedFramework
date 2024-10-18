package com.Forsys.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Forsys.ui.actions.ScreenShot;

/**
 * RuntimeException for cases where a element could not be located. Automatically takes screenshot
 * and logs in the report.
 */
public class ElementNotFoundException
    extends
    RuntimeException {

    private static final long serialVersionUID = -4818029531365715529L;

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
    public ElementNotFoundException(By locator, String failure) {
        super("\n" + failure + " \n Could not find element using " + locator);
    }

    /**
     * Constructs a failure reason like
     * <p>
     * Sign in button missing.
     * 
     * @param failure {@link String} eg:Sign in button missing.
     */
    public ElementNotFoundException(String failure) {
        super("\n" + failure);
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
     * @param ScreenShot
     */
    public ElementNotFoundException(By locator, String failure, ScreenShot screenShot) {
        super("\n" + failure + " \n Could not find element using " + locator + " \n" + screenShot
                                                                                                 .getLinkToScreenShot());
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
     * @param ScreenShot
     */
    public ElementNotFoundException(By locator,
                                    String failure,
                                    ScreenShot screenShot,
                                    boolean captureScreenOnException) {
        super("\n" + failure + " \n Could not find element using " + locator + " \n" + (captureScreenOnException
            ? screenShot.getLinkToScreenShot()
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
     * @param driver
     */
    public ElementNotFoundException(String failure, ScreenShot screenShot) {
        super("\n" + failure + " \n Could not find element.\n" + screenShot.getLinkToScreenShot());
    }

}
