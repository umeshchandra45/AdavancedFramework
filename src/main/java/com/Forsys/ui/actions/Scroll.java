package com.Forsys.ui.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Helps in scrolling to top, bottom and to a point by x,y co-ords.
 */
public class Scroll {
    private WebDriver driver;
    private Waits wait;

    Scroll(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;
        this.wait = new Waits(driver);
    }

    /**
     * Scrolls the page to the specifed pixel position in xAxis and yAxis.
     * <p>
     * <b>USAGE:</b><br>
     * 1.To scroll down to a position at pixel 1000 : {@code scrollPage(0,
     * 1000)}<br>
     * 2.To scroll right to a position at pixel 500 : {@code scrollPage(
     * 500, 0)}<br>
     * 3.To scroll right to a position at pixel 500 and scroll down to a position at pixel 2500 :
     * {@code scrollPage(500, 2500)}
     * </p>
     * 
     * @param xAxis String
     * @param yAxis String
     */
    public void scrollPage(String xAxis, String yAxis) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + xAxis + "," + yAxis + ")");
        ExtentReportListener.extent_test.get().info("<b>Scrolled the page by </b> X:" + xAxis + " Y:" + yAxis);
    }

    /**
     * DEPRECATED: Use scrollToTop instead of this.
     * 
     * @return
     */
    @Deprecated
    public Long scrollTop() {
        Long l = (Long) ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollTop");
        ExtentReportListener.extent_test.get().info("<b>Scrolled to the Top of the page.</b>");
        return l;
    }

    public void scrollintoview(By ele) {
        try {
            JavascriptExecutor je = ((JavascriptExecutor) driver);
            je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ele));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollintoview(WebElement ele) {
        try {
            JavascriptExecutor je = ((JavascriptExecutor) driver);
            je.executeScript("arguments[0].scrollIntoView(true);", ele);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollToElement(By locator) {
        scrollToElement(wait.waitUntilElementFound(locator, 10));
    }

    public void scrollToElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();
    }

    /**
     * Scroll to the top of the page
     * 
     * @return
     */
    public Long scrollToTop() {
        Long l = (Long) ((JavascriptExecutor) driver).executeScript("return document.documentElement.scrollTop");
        scrollPage("0", Long.toString(l * -1)); // scroll up the distance till top of page
        ExtentReportListener.extent_test.get().info("<b>Scrolled to the Top of the page.</b>");
        return l;
    }

    /**
     * Scroll to bottom of the page
     */
    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript(
                                                    "window.scrollTo(0,Math.max(" +
                                                    "document.documentElement.scrollHeight,document.body.scrollHeight," +
                                                    "document.documentElement.clientHeight));");
        ExtentReportListener.extent_test.get().info("<b>Scrolled to the Bottom of the page.</b>");
    }
}
