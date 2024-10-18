package com.Forsys.ui.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Forsys.api.report.ExtentReportListener;

public class TextBox {
    private static final String TYPED = "<b>Typed</b> %s on %s";
    private static final String CLEARED = "<b>Cleared</b> %s";
    private Waits wait;

    TextBox(WebDriver driver) {
        this.wait = new Waits(driver);
    }

    /**
     * Types the 'textToBeTyped' in the specified webElement and logs the event.
     * 
     * @param webElement
     * @param textToBeTyped
     */
    public void sendKeys(final WebElement webElement, final String textToBeTyped) {
        webElement.sendKeys(textToBeTyped);
        ExtentReportListener.extent_test.get()
                                        .info(String.format(TYPED,
                                                            textToBeTyped,
                                                            "element at " + webElement.toString()));
    }

    /**
     * Types the 'textToBeTyped' in the specified webElement and logs the event.
     * 
     * @param locator
     * @param textToBeTyped
     */
    public void sendKeys(final By locator, final String textToBeTyped) {
        wait.waitUntilElementFound(locator, 5).sendKeys(textToBeTyped);
        ExtentReportListener.extent_test.get().info(String.format(TYPED, textToBeTyped, locator));
    }

    /**
     * Clears the value in webElement and logs the event.
     * 
     * @param webElement
     */
    public void clear(final WebElement webElement) {
        String text = webElement.getText();
        webElement.clear();
        ExtentReportListener.extent_test.get().info(String.format(CLEARED, text));
    }

    /**
     * Clears the value in locator and logs the event.
     * 
     * @param locator
     */
    public void clear(final By locator) {
        wait.waitUntilElementFound(locator, 5).clear();
        ExtentReportListener.extent_test.get().info(String.format(CLEARED, locator));
    }

    /**
     * Clears the value in textbox located by 'locator' and types the 'textToBeTyped' and logs the
     * event.
     * 
     * @param locator
     * @param textToBeTyped
     */
    public void clearAndSendKeys(final By locator, final String textToBeTyped) {
        clear(locator);
        sendKeys(locator, textToBeTyped);
    }

    public void sendKeys(By locator, Keys keytype) {
        wait.waitUntilElementFound(locator, 5).sendKeys(keytype);
        ExtentReportListener.extent_test.get().info("Used KeyType" + keytype);
    }

    public void sendKeys(WebElement locator, Keys keytype) {
        wait.waitUntilElementFound(locator, 10).sendKeys(keytype);
        ExtentReportListener.extent_test.get().info("Used KeyType" + keytype);
    }

    public void sendKeys(WebElement locator, Object keytype) {
        wait.waitUntilElementFound(locator, 10).sendKeys((CharSequence[]) keytype);
        ExtentReportListener.extent_test.get().info("Used KeyType" + keytype);
    }
}
