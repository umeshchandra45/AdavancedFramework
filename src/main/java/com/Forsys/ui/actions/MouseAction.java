package com.Forsys.ui.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Methods to get Element(s) their texts and count.
 * 
 */
public class MouseAction {
    private final String HOVERED = "<b>MouseOver</b> (via Actions moveToElement) ";
    private WebDriver driver;
    private Waits wait;

    MouseAction(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }

        this.driver = driverInstance;
        this.wait = new Waits(driver);
    }

    public void moveTo(int x, int y) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(x, y);
        actions.perform();
        ExtentReportListener.extent_test.get().info(HOVERED + " co-ordinates " + x + "," + y);
    }

    /**
     * Hover mouse over the {@link WebElement} 'elementToHoverOn' and polls for
     * 'locatorToFindOnPageAfterHovering' and logs the event.
     * 
     * @param elementToHoverOn {@link WebElement}
     * @param locatorToFindOnPageAfterHovering
     * @param failMsg
     */
    public void hoverOn(final By locatorToHover) {
        WebElement element = wait.waitUntilElementFound(locatorToHover, 5);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        ExtentReportListener.extent_test.get().info(HOVERED + " onto  " + locatorToHover);
    }

    /**
     * Hover mouse over the {@link WebElement} 'elementToHoverOn' and polls for
     * 'locatorToFindOnPageAfterHovering' and logs the event.
     * 
     * @param elementToHoverOn {@link WebElement}
     * @param locatorToFindOnPageAfterHovering
     * @param failMsg
     */
    public void hoverOn(final WebElement ElementToHover) {
        Actions actions = new Actions(driver);
        actions.moveToElement(ElementToHover);
        actions.perform();
        ExtentReportListener.extent_test.get().info(HOVERED + " onto  " + ElementToHover);
    }

}
