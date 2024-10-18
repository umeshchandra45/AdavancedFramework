package com.Forsys.ui.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.ElementNotFoundException;

/**
 * Methods to click. Any click action like actions.element().click.by(locator) will automatically be
 * transformed to tap action if the test is run on native app.So, it is NOT REQUIRED to change code
 * for native like actions.touchScreen().usingBy().tap(locator)
 * 
 */
public class Click {

    private static final String LINK_FOR_REPORT = " <a style='text-decoration:none;' href='#' title='%s'>%s</a>";
    private final String CLICK_EVENT = "<b>Clicked</b>" + LINK_FOR_REPORT;
    private final String CLICKED_POINT = "<b>Clicked At Point</b> %s,%s";
    private final String MOVED_CLICKED = "<b>Moved To and Clicked</b>" + LINK_FOR_REPORT;
    private final String MOVED_TO_CLICKED_AT = "<b>Moved To </b>" + LINK_FOR_REPORT + " and Clicked At %s";
    private ScreenShot screenShot;
    private WebDriver driver;
    private Waits wait;

    Click(WebDriver driver, ScreenShot screenShot) {
        this.driver = driver;
        this.screenShot = screenShot;
        this.wait = new Waits(driver);
    }

    /**
     * Locates and Clicks all elements located from the provided By {@link List}
     * 
     * @param locators {@link List}
     * @return {@link Click}
     */
    public Click multipleElementsUsingBy(List<By> locators) {
        for (By locator : locators) {
            by(locator);
        }
        return this;
    }

    /**
     * Clicks all elements from the provided WebElement {@link List}
     * 
     * @param webElements {@link List}
     * @return {@link Click}
     */
    public Click multipleElements(List<WebElement> webElements) {
        for (WebElement webElement : webElements) {
            webElement(webElement);
        }
        return this;
    }

    /**
     * Clicks on a element and logs the event.
     * 
     * @param webElement
     */
    public Click webElement(final WebElement webElement) {
        try {
            String text = webElement.getText();
            String tagName = webElement.getTagName();
            if (tagName.contains("input")) {
                text = webElement.getAttribute("value");
            }
            ExtentReportListener.extent_test.get().info(String.format(CLICK_EVENT, tagName, text));
            webElement.click();
        } catch (ElementNotVisibleException e) {
            String fail = "ElementNotVisibleException thrown at click " + e.toString();
            ExtentReportListener.extent_test.get().error(fail);
            throw new ElementNotFoundException(fail, screenShot);
        } catch (StaleElementReferenceException e) {
            String fail = "StaleElementReferenceException thrown at click " + e.toString();
            ExtentReportListener.extent_test.get().info(fail);
            throw new ElementNotFoundException(fail, screenShot);
        }
        return this;
    }

    /**
     * Locates all elements with locator and clicks one element whose text contains
     * textOfElementToClick
     * 
     * @param locator
     * @param textOfElementToClick
     */
    public Click oneFromManyWithSameLocatorContainingText(By locator, String textOfElementToClick) {
        if (textOfElementToClick == null || textOfElementToClick.trim().length() == 0) {
            ExtentReportListener.extent_test.get()
                                            .info(textOfElementToClick +
                                                  " cannot be clicked.'textOfElementToClick' cannot be empty or null.");
            throw new ElementNotFoundException(
                                               "Cannot click one from many containing null or empty text for " + locator
                                                                                                                        .toString());
        }
        List<WebElement> elementsWithSameLocator = getAllElementsWithSameLocator(locator,
                                                                                 " text '" + textOfElementToClick +
                                                                                          "'");

        for (WebElement element : elementsWithSameLocator) {
            String elemText = element.getText();
            if ((elemText != null) && (elemText.contains(textOfElementToClick))) {
                clickAndLog(locator, element);
                return this;
            }
        }
        return this;
    }

    /**
     * Locates all elements with locator and clicks one element whose text matches
     * textOfElementToClick.
     * 
     * @param locator
     * @param textOfElementToClick
     */
    public Click oneFromManyWithSameLocator(By locator, String textOfElementToClick) {

        if (textOfElementToClick == null || textOfElementToClick.trim().length() == 0) {
            ExtentReportListener.extent_test.get()
                                            .info(textOfElementToClick +
                                                  " cannot be clicked.'textOfElementToClick' cannot be empty or null.");
        }
        List<WebElement> elementsWithSameLocator = getAllElementsWithSameLocator(locator,
                                                                                 " text '" + textOfElementToClick +
                                                                                          "'");

        for (WebElement element : elementsWithSameLocator) {
            String elemText = element.getText();
            if ((elemText != null) && (elemText.equals(textOfElementToClick))) {
                clickAndLog(locator, element);
                return this;
            }
        }
        return this;
    }

    /**
     * Use to click one element(whose attribute 'attributeName' has value 'attributeValue') from a
     * group of elements identified by same locator(By).
     * 
     * @param locator
     * @param attributeName
     * @param attributeValue
     */
    public Click oneFromManyWithSameLocator(By locator, String attributeName, String attributeValue) {
        if (attributeName == null || attributeName.trim().length() == 0) {
            throw new ElementNotFoundException(
                                               "Cannot click one from many with null attribute for " + locator
                                                                                                              .toString());
        }
        String msg = String.format("attribute %s with value %s", attributeName, attributeValue);
        List<WebElement> elementsWithSameLocator = getAllElementsWithSameLocator(locator, msg);

        for (WebElement element : elementsWithSameLocator) {
            String actualAttributeValue = element.getAttribute(attributeName);
            if ((actualAttributeValue != null) && (actualAttributeValue.equals(attributeValue))) {
                clickAndLog(locator, element);
                return this;
            }
        }
        return this;
    }

    /**
     * Use to click one element(using the index position) from a group of elements identified by
     * same locator(By).
     * 
     * @param locator
     * @param index
     */
    public Click oneFromManyWithSameLocator(By locator, int index) {
        String msg = String.format("position '%s'", index);
        List<WebElement> elementsWithSameLocator = getAllElementsWithSameLocator(locator, msg);
        if (elementsWithSameLocator.size() > index) {
            WebElement element = elementsWithSameLocator.get(index);
            clickAndLog(locator, element);
            return this;
        }
        // throw exception if the method did not return earlier.
        String clickFailure = " position " + index;
        failIfNotExitedAlready(locator, clickFailure);
        return this;
    }

    /**
     * <p>
     * Polls for a element and clicks it.
     * </p>
     * 
     * @param locator to locate the element.
     */
    public Click by(final WebElement locator) throws RuntimeException {
        WebElement element = wait.waitUntilElementFound(locator, 5);
        ExtentReportListener.extent_test.get().info(String.format(CLICK_EVENT, locator));
        element.click();
        return this;
    }

    /**
     * <p>
     * Polls for a element and clicks it.
     * </p>
     * 
     * @param locator to locate the element.
     */
    public Click by(final By locator) throws RuntimeException {
        WebElement element = wait.waitUntilElementFound(locator, 5);
        element.click();
        return this;
    }

    /**
     * <p>
     * Polls for a element and clicks it using js.
     * </p>
     * 
     * @param locator to locate the element.
     */
    public Click jsClick(final By locator) {
        WebElement element = wait.waitUntilElementFound(locator, 10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        ExtentReportListener.extent_test.get().info(String.format(CLICK_EVENT, locator, element));
        return this;
    }

    /**
     * Polls for a element and clicks it. If the element is not available, the failure msg is shown
     * along with the screenshot.
     * 
     * @param locator to locate the element.
     * @param failureMsgToShowIfEmntNotFound
     */
    public Click by(final By locator, String failureMsgToShowIfEmntNotFound) throws RuntimeException {
        try {
            by(locator);
        } catch (Exception e) {
            String msg = e.getMessage();
            String timeOutException = "Exception:org.openqa.selenium.TimeoutException";
            if (msg != null && msg.contains(timeOutException)) {
                msg = msg.substring(0, msg.indexOf(timeOutException));
            }
            ExtentReportListener.extent_test.get().error(failureMsgToShowIfEmntNotFound);
            ExtentReportListener.extent_test.get().error("Could not click " + locator);
            throw new ElementNotFoundException(locator, failureMsgToShowIfEmntNotFound + "\n" + msg);
        }
        return this;
    }

    /**
     * Polls for an element, moves the mouse to it and clicks on it.Used when the element to be
     * clicked comes into display only when scrolled to or only when it is is view port. Does new
     * Actions(driver).moveToElement(element).click().perform();
     * 
     * @param locator
     * @param failMsg
     * @throws Exception
     */
    public Click byAfterMovingToIt(By locator, String failMsg) throws Exception {
        try {
            WebElement element = driver.findElement(locator);
            ExtentReportListener.extent_test.get().info(String.format(MOVED_CLICKED, locator, element));
            new Actions(driver).moveToElement(element).click().perform();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().fail(failMsg + ":" + e.toString());
            throw e;
        }
        return this;
    }

    /**
     * Polls for element identified by 'locator' and clicks at an offset of xCoord,yCoord.
     * 
     * @param locator
     * @param xCoord
     * @param yCoord
     * @param failMsg
     * @throws RuntimeException
     */
    public Click byAtOffset(final By locator, final int xCoord, final int yCoord, String failMsg)
        throws RuntimeException {
        WebElement element = wait.waitUntilElementFound(locator, 5);
        String elementName = extractReadableTextForElement(locator, element);
        try {
            ExtentReportListener.extent_test.get()
                                            .info(String.format(MOVED_TO_CLICKED_AT,
                                                                locator,
                                                                elementName,
                                                                xCoord + "," + yCoord));
            new Actions(driver).moveToElement(element, xCoord, yCoord).click().perform();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info(screenShot.getLinkToScreenShot());
            throw new RuntimeException(
                                       failMsg + "\nCould not click " + locator + "  at point:" + xCoord + "," +
                                       yCoord);
        }
        return this;
    }

    /**
     * Clicks at the specified point using xCoord,yCoord.
     * 
     * @param xCoord
     * @param yCoord
     * @param failMsg
     * @throws RuntimeException
     */
    public Click atPoint(final int xCoord, final int yCoord, final String failMsg) throws RuntimeException {
        try {
            ExtentReportListener.extent_test.get().info(String.format(CLICKED_POINT, xCoord, yCoord));
            new Actions(driver).moveByOffset(xCoord, yCoord).click().build().perform();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info(screenShot.getLinkToScreenShot());
            throw new RuntimeException(failMsg + "\nCould not click at point:" + xCoord + "," + yCoord);
        }
        return this;
    }

    /**
     * Clicks the element and logs the action.
     * 
     * @param locator
     * @param element
     */
    private void clickAndLog(By locator, WebElement element) {
        ExtentReportListener.extent_test.get()
                                        .info(String.format(CLICK_EVENT,
                                                            locator,
                                                            extractReadableTextForElement(locator, element)));
        element.click();
    }

    /**
     * @param locator
     * @param element
     * @return
     */
    private String extractReadableTextForElement(By locator, WebElement element) {
        try {
            String text = element.getText();
            String elementName = ((text == null || text.trim().length() == 0) && element.getAttribute("value") != null)
                ? element.getAttribute("value")
                : text;
            if ((elementName == null || elementName.trim().length() == 0) && element.getTagName() != null && (element
                                                                                                                     .getTagName()
                                                                                                                     .toLowerCase()
                                                                                                                     .equals("img") ||
                                                                                                              element.getTagName()
                                                                                                                     .toLowerCase()
                                                                                                                     .equals("a"))) {
                elementName = (element.getAttribute("title") != null) ? element.getAttribute("title")
                    : element.getAttribute("alt");
            }
            if (elementName == null || elementName.trim().length() == 0) {
                elementName = locator.toString();
            }
            return elementName;
        } catch (Exception e) {
            return locator.toString();
        }

    }

    /**
     * @param clickFailure
     */
    private void failIfNotExitedAlready(By locator, String reason) {
        String failReason = String.format("Located %s but, could not find element with %s to click.", locator, reason);
        ExtentReportListener.extent_test.get().info(failReason);
        throw new ElementNotFoundException(failReason, screenShot);
    }

    /**
     * @param locator
     * @param textOfElementToClick
     * @param elementsWithSameLocator
     * @return
     */
    private List<WebElement> getAllElementsWithSameLocator(By locator, String msg) {
        try {
            return wait.waitUntilElementsFound(locator, 5);
        } catch (Exception e) {
            ExtentReportListener.extent_test.get()
                                            .info(
                                                  String.format("Could not click element by %s since it was not located via '%s'.",
                                                                msg,
                                                                locator));
            throw new ElementNotFoundException(locator, msg, screenShot);
        }
    }

}
