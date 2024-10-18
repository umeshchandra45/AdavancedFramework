package com.Forsys.ui.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Methods to handle keyboard interactions.
 * 
 */
public class KeyboardActions {
    private final String PRESSED = "<b>Pressed Key</b> ";
    private final String FOCUSED = "<b>Focused On</b> ";
    private final String RELEASED = "<b>Released Key</b> ";
    private WebDriver driver;
    private Waits wait;

    public KeyboardActions(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        }
        this.wait = new Waits(driver);
        this.driver = driver;
    }

    public void press(Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key);
        actions.perform();
        ExtentReportListener.extent_test.get().info(PRESSED + key);
    }

    public void focusOnElementAndPress(By by, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(wait.waitUntilElementFound(by, 5), key);
        actions.perform();
        ExtentReportListener.extent_test.get().info(FOCUSED + by + PRESSED + key);
    }

    public void focusOnElementAndRelease(By by, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyUp(wait.waitUntilElementFound(by, 5), key);
        actions.perform();
        ExtentReportListener.extent_test.get().info(FOCUSED + by + RELEASED + key);
    }

    public void release(Keys key) {
        Actions actions = new Actions(driver);
        actions.keyUp(key);
        actions.perform();
        ExtentReportListener.extent_test.get().info(RELEASED + key);
    }

    public void keyActionPreform(WebElement element, Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(element, key);
        actions.perform();
        ExtentReportListener.extent_test.get().info(PRESSED + key);
    }

    public void focusOnElementAndClick(By by, Keys key) {
        Actions actions = new Actions(driver);
        actions.keyDown(wait.waitUntilElementFound(by, 5), key);
        actions.perform();
        ExtentReportListener.extent_test.get().info(FOCUSED + by + RELEASED + key);
    }

}
