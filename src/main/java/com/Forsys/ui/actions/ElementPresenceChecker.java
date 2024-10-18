package com.Forsys.ui.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Handles various scenarios of element presence checks.
 * 
 */
public class ElementPresenceChecker {
    private WebDriver driver;
    private Waits wait;

    ElementPresenceChecker(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;
        this.wait = new Waits(driverInstance);
    }

    /**
     * Returns true if element is present. Note:This does not poll. Use this if your element should
     * be present immediately.
     * 
     * @param locator to find the element
     * @return true if element is present(displayed).
     */
    public boolean now(By locator) {
        try {
            wait.waitUntilElementTobeDisplayed(locator, 5);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Poll for the maximum timeout of 30 secs to find the element. Returns true if the element is
     * found any time on or before timeout.
     * 
     * @param locator to find the element
     * @return true if element is present.
     */
    public boolean byPolling(By locator) {
        try {
            wait.waitUntilElementTobeDisplayed(locator, 5);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 
     * Pool for an element and refresh after the buffer time if element is not found. Note: Does not
     * apply for native mobile app
     * 
     * @param locator
     * @param noOfSecondsBeforeEachRefresh
     * @param maxWaitTime to wait
     * @return
     */
    public boolean byPollingWithPageRefresh(By locator, int noOfSecondsBeforeEachRefresh, int maxWaitTime) {
        try {
            while ((!byCustomPolling(locator, noOfSecondsBeforeEachRefresh)) && (maxWaitTime > 0)) {
                maxWaitTime = maxWaitTime - noOfSecondsBeforeEachRefresh;
                driver.navigate().refresh();
                byCustomPolling(locator, noOfSecondsBeforeEachRefresh);
            }
            if (maxWaitTime > 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if element is present.Polls for the specified timeout.
     * 
     * @param locator {@link By}
     * @param timeOutInSeconds {@link Long}
     * @return
     */
    public boolean byCustomPolling(By locator, long timeOutInSeconds) {
        try {
            wait.waitUntilElementTobeDisplayed(locator, 5);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Locates a element or several elements by locator(eg:xpath-&gt; //input or css -&gt; input)
     * and iterates through all elements then gets the attribute and checks if the containingString
     * is a part of the attribute. If so returns true.
     * 
     * <b>USAGE: containingAttributePartly(driver, "class", "qnty", LOCATOR)</b>
     */
    public boolean containingAttributePartly(String attribute, String containingString, By locator)
        throws RuntimeException {
        List<WebElement> elementsContainingAttribute = wait.waitUntilElementsFound(locator, 5);
        for (WebElement webElement : elementsContainingAttribute) {
            String value = webElement.getAttribute(attribute);
            if ((value != null) && (value.length() != 0) && (value.contains(containingString))) {
                return true;
            }
        }
        return false;
    }

}
