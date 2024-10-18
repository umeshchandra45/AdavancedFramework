package com.Forsys.ui.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Methods to get highlight element border with {@link Color}.
 * 
 */
public class Highlight {

    private WebDriver driver;
    private Waits wait;

    Highlight(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;
        wait = new Waits(driverInstance);
    }

    public enum Color {
        GREEN, RED, ORANGE;
    }

    public void border(By locator, Color color) {
        try {
            WebElement element = wait.waitUntilElementFound(locator, 5);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='2px solid " + color + "'", element);
        } catch (Exception e) {
            // This is a nice to have feature only hence ignore exception if
            // there is
            // any since,
            // the element will just not be highlighted. There could be
            // exceptions if
            // the browser
            // js is not permitting JavascriptExecutor from scripts.
        }
    }

    public void border(WebElement webElement, Color color) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='2px solid " + color + "'", webElement);
        } catch (Exception e) {
            // This is a nice to have feature only hence ignore exception if
            // there is
            // any since,
            // the element will just not be highlighted. There could be
            // exceptions if
            // the browser
            // js is not permitting JavascriptExecutor from scripts.
        }
    }
}
