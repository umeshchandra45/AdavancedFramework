package com.Forsys.ui.actions;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Helps to set, clear or delete cookies.
 *
 */
public class Cookies {
    private final String CLEARED = "<b>Cleared</b>";
    private final String COOKIES = " <b>cookies</b> ";
    private final String ADDED = "<b>Added</b>";
    private WebDriver driver;

    // prevents instantiation of class from outside the package.
    Cookies(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;
    }

    /**
     * Sets cookie to the current browser instance.
     * 
     * @param cookieName cookie that has to be added.
     * @param cookieValue value of the cookie to be added.
     */
    public void setCookie(String cookieName,
                          String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        driver.manage().addCookie(cookie);
        ExtentReportListener.extent_test.get().info(ADDED + COOKIES + cookieName + "|" + cookieValue);
    }

    /**
     * Gets cookie from name for the current browser
     * 
     * @param cookieName cookie that has to be added.
     */
    public Cookie getCookie(String cookieName) {
        return driver.manage().getCookieNamed(cookieName);
    }

    /**
     * Gets all the cookie from name for the current browser
     */
    public Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }

    /**
     * Clear all cookies.
     * 
     */
    public void clearAllCookies() {
        driver.manage().deleteAllCookies();
        ExtentReportListener.extent_test.get().info(CLEARED + COOKIES);
    }

    /**
     * Deletes the specified cookiesName.
     * 
     * @param cookieName
     * @param cookieValue
     */
    public void deleteCookie(String cookieName,
                             String cookieValue) {
        driver.manage().deleteCookie(new Cookie(cookieName, cookieValue));
        ExtentReportListener.extent_test.get().info(CLEARED + COOKIES + cookieName);
    }

}
