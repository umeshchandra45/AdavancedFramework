
package com.Forsys.ui.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Provides methods to interact with browser. Can be accessed via {@link WebActions}
 * 
 */
public class BrowserAction {

    private static final String OPEN = "<b>Loaded </b>";
    private static final String CURRENT_URL = "<b>Current url is </b>";
    private static final String CURRENT_TITLE = "<b>Current title is </b>";
    private static final String SWITCHED_TO_IFRAME = "<b>Switched to iframe </b>";
    private static final String SWITCHED_TO_HANDLE = "<b>Switched to window handle </b>";
    private static final String SWITCHED_TO_WINDOW_URL = "<b>Switched to window with url </b>";
    private static final String SWITCHED_TO_WINDOW_PART_URL = "<b>Switched to window with part of url </b>";
    private static final String SWITCHED_TO_WINDOW_LOCATOR = "<b>Switched to window with locator </b>";
    private static final String SWITCHED_TO_WINDOW_TITLE = "<b>Switched to window with title </b>";
    private static final String REFRESHED_PAGE = "Refreshed page";

    private Scroll scroll;
    private Cookies cookies;
    private WebDriver driver;
    private AlertDialog alertDialog;
    private Waits wait;
    private ElementPresenceChecker elementPresent;

    BrowserAction(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;
        this.wait = new Waits(driverInstance);
    }

    /**
     * Provides instance of {@link Cookies} which helps with setting, clearing or deleting cookies.
     * 
     * @return {@link Cookies}
     */
    public Cookies cookies() {
        if (cookies == null) {
            cookies = new Cookies(driver);
        }
        return cookies;
    }

    /**
     * Provides instance of {@link Scroll} which helps with scrolling to top, bottom or simply
     * scrolling the page by x.y coords.
     * 
     * @return {@link Scroll}
     */
    public Scroll scroll() {
        if (scroll == null) {
            scroll = new Scroll(driver);
        }
        return scroll;
    }

    /**
     * Provides instance of {@link AlertDialog} which helps with handling application thrown alerts,
     * dialogs.
     * 
     * @return {@link AlertDialog}
     */
    public AlertDialog alertDialog() {
        if (alertDialog == null) {
            alertDialog = new AlertDialog(driver);
        }
        return alertDialog;
    }

    /**
     * Loads the url on the browser's address bar.
     * 
     * @param url {@link String}
     */
    public void goToUrl(String url) {
        ExtentReportListener.extent_test.get().info(OPEN + url);
        driver.get(url);
    }

    /**
     * Returns the current url in the active window for the given driver.
     * 
     * @return currenturl
     */
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        ExtentReportListener.extent_test.get().info(CURRENT_URL + currentUrl);
        return currentUrl;
    }

    /**
     * Returns a list of browser console logs entry in CHROME
     * 
     * @return browserConsoleLogs
     */
    public List<LogEntry> getBrowserConsoleLogs() {
        List<LogEntry> browserConsoleLogs = driver.manage().logs().get(LogType.BROWSER).getAll();
        return browserConsoleLogs;
    }

    /**
     * Returns the current title in the active window for the given driver.
     * 
     * @return currentTitle
     */
    public String getCurrentTitle() {
        String currentTitle = driver.getTitle();
        ExtentReportListener.extent_test.get().info(CURRENT_TITLE + currentTitle);
        return currentTitle;
    }

    /**
     * Returns the current page source in the active window for the given driver.
     * 
     * @return currentPageSource
     */
    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    /**
     * Switches to window with the specified title when there are multiple windows.
     * 
     * @param windowTitle
     */
    public BrowserAction switchToWindowUsingTitle(String windowTitle) {
        Set<String> handles = getWindowHandles();
        boolean switched = false;
        if (handles.size() >= 1) {
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (driver.getTitle().contains(windowTitle)) {
                    ExtentReportListener.extent_test.get().info(SWITCHED_TO_WINDOW_TITLE + windowTitle);
                    switched = true;
                    break;
                }
            }
        }
        if (!switched) {
            throw new RuntimeException("Unable to find handles with title containing " + windowTitle);
        }
        return this;
    }

    /**
     * Switches to window with the specified url (whole url should match) when there are multiple
     * windows.
     * 
     * @param url
     */
    public BrowserAction switchToWindowContainingUrl(String url) {
        Set<String> handles = getWindowHandles();
        boolean switched = false;
        if (handles.size() >= 1) {
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (driver.getCurrentUrl().equals(url)) {
                    ExtentReportListener.extent_test.get().info(SWITCHED_TO_WINDOW_URL + url);
                    switched = true;
                    break;
                }
            }
        }
        if (!switched) {
            throw new RuntimeException("Unable to find handles with url " + url);
        }
        return this;
    }

    /**
     * Switches to window whose URL contains the specified url when there are multiple windows.
     * 
     * @param partOfURLToBePresentInWindow
     */
    public BrowserAction switchToWindowContainingPartUrl(String partOfURLToBePresentInWindow) {
        Set<String> handles = getWindowHandles();
        boolean switched = false;
        if (handles.size() >= 1) {
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (driver.getCurrentUrl().contains(partOfURLToBePresentInWindow)) {
                    ExtentReportListener.extent_test.get()
                                                    .info(SWITCHED_TO_WINDOW_PART_URL + partOfURLToBePresentInWindow);
                    switched = true;
                    break;
                }
            }
        }
        if (!switched) {
            throw new RuntimeException(
                                       "Unable to find handles with url that contains '" +
                                       partOfURLToBePresentInWindow + "'");
        }
        return this;
    }

    /**
     * Switches to window with the specified locator when there are multiple windows.
     * 
     * @param locator
     */
    public BrowserAction switchToWindowUsingLocator(By locator) {
        Set<String> handles = getWindowHandles();
        boolean switched = false;
        if (handles.size() >= 1) {
            for (String handle : handles) {
                driver.switchTo().window(handle);
                if (elementPresent.now(locator)) {
                    ExtentReportListener.extent_test.get().info(SWITCHED_TO_WINDOW_LOCATOR + locator);
                    switched = true;
                    break;
                }
            }
        }
        if (!switched) {
            throw new RuntimeException("Unable to find handles with locator '" + locator + "'");
        }

        return this;
    }

    public Set<String> getWindowHandles() {
        Set<String> handles = driver.getWindowHandles();
        return handles;
    }

    public ArrayList<String> openNewTabAndGetWindowHandles() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        return new ArrayList<String>(driver.getWindowHandles());
    }

    /**
     * Switches to iframe identified with the specified locator.
     * 
     *
     */
    public BrowserAction switchToFrame(By locatorForFrame) {
        driver.switchTo().frame(wait.waitUntilElementFound(locatorForFrame, 5));
        ExtentReportListener.extent_test.get().info(SWITCHED_TO_IFRAME + locatorForFrame);
        return this;
    }

    /**
     * Switches to window with the specified handle
     * 
     * @param handle
     */
    public BrowserAction switchToWindowHandle(String handle) {
        // adding polling to take care of cases where handles take a bit to load
        // after trigger actions like click.
        // if the switch was requested to current handle there is no need to switch.
        boolean switched = false;
        if (!driver.getWindowHandle().equals(handle)) {
            driver.switchTo().window(handle);
            switched = true;
            ExtentReportListener.extent_test.get().info(SWITCHED_TO_HANDLE + handle);
        }
        if (!switched) {
            throw new RuntimeException("Did not find handle to switch");
        }
        return this;
    }

    /**
     * Switches to parent frame content.Can be used this to get out of a iframe.
     */
    public BrowserAction switchToParentFrame() {
        driver.switchTo().parentFrame();
        ExtentReportListener.extent_test.get().info("Switched to parent frame.");
        return this;
    }

    /**
     * Switches to idefault content.Use this to get out of a iframe or to original window.
     */
    public BrowserAction switchToDefault() {
        driver.switchTo().defaultContent();
        ExtentReportListener.extent_test.get().info("Switched to default");
        return this;
    }

    /**
     * Returns the size of the current browser used by the test.
     * 
     * @return {@link String} browser size as eg:"W:1600 H:900"
     */
    public String getSizeString() {
        return "W: " + driver.manage().window().getSize().getWidth() + " H: " + driver.manage()
                                                                                      .window()
                                                                                      .getSize()
                                                                                      .getHeight();
    }

    /**
     * Returns the size of the current browser used by the test.
     * 
     * @return {@link Dimension}
     */
    public Dimension getSize() {
        return driver.manage().window().getSize();
    }

    /**
     * Resizes the browser to the size specified and refreshes the page.
     * 
     * <p>
     * Use in cases where a refresh is needed after resizing the browser for the UI to adjust.
     * <p>
     * 
     * @param windowWidth
     * @param windowHeight
     */
    public BrowserAction resizeAndRefresh(int windowWidth, int windowHeight) {
        resize(windowWidth, windowHeight);
        refresh();
        return this;
    }

    /**
     * Refreshes the browser.
     */
    public BrowserAction refresh() {
        driver.navigate().refresh();
        ExtentReportListener.extent_test.get().info(REFRESHED_PAGE);
        return this;
    }

    /**
     * Resizes the browser to test on various resolutions.
     * <p>
     * If you need the app to refresh after resizing, use {@code resizeBrowserAndRefresh(int, int)}
     * </p>
     * 
     * @param windowWidth
     * @param windowHeight
     */
    public BrowserAction resize(int windowWidth, int windowHeight) {
        ExtentReportListener.extent_test.get().info("<b>Resize Browser To</b> W:" + windowWidth + " H:" + windowHeight);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(windowWidth, windowHeight));
        ExtentReportListener.extent_test.get().info("<b>Actual Browser Size</b> " + getSizeString());
        return this;
    }

    /**
     * Browser Back.
     */
    public BrowserAction back() {
        driver.navigate().back();
        ExtentReportListener.extent_test.get().info("Clicked browser back");
        return this;
    }

    /**
     * Maximizes the window to the available screen width.
     * 
     */
    public BrowserAction maximize() {
        driver.manage().window().maximize();
        ExtentReportListener.extent_test.get().info("Maximized browser");
        return this;
    }

    /**
     * return screen resolution width
     * 
     * @return {@link Long}
     */
    public Long getScreenResolutionWidth() {
        return (Long) executeJavaScriptAndGetResult("return screen.width");
    }

    /**
     * return screen resolution height
     * 
     * @return {@link Long}
     */
    public Long getScreenResolutionHeight() {
        return (Long) executeJavaScriptAndGetResult("return screen.height");
    }

    /**
     * Executes JavaScript in the context of the currently selected frame or window. The script
     * fragment provided will be executed as the body of an anonymous function.
     * 
     * <p>
     * Within the script, use <code>document</code> to refer to the current document. Note that
     * local variables will not be available once the script has finished executing, though global
     * variables will persist.
     * 
     * <p>
     * If the script has a return value (i.e. if the script contains a <code>return</code>
     * statement), then the following steps will be taken:
     * 
     * <ul>
     * <li>For an HTML element, this method returns a WebElement</li>
     * <li>For a decimal, a Double is returned</li>
     * <li>For a non-decimal number, a Long is returned</li>
     * <li>For a boolean, a Boolean is returned</li>
     * <li>For all other cases, a String is returned.</li>
     * <li>For an array, return a List&lt;Object&gt; with each object following the rules above. We
     * support nested lists.</li>
     * <li>Unless the value is null or there is no return value, in which null is returned</li>
     * </ul>
     * 
     * <p>
     * Arguments must be a number, a boolean, a String, WebElement, or a List of any combination of
     * the above. An exception will be thrown if the arguments do not meet these criteria. The
     * arguments will be made available to the JavaScript via the "arguments" magic variable, as if
     * the function were called via "Function.apply"
     * 
     * @param script The JavaScript to execute
     * @param args The arguments to the script. May be empty
     * @return One of Boolean, Long, String, List or WebElement. Or null.
     */
    public Object executeJavaScriptAndGetResult(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    /**
     * Executes JavaScript in the context of the currently selected frame or window and returns
     * {@link BrowserAction} to permit chaining. The script fragment provided will be executed as
     * the body of an anonymous function.
     * <p>
     * If your script returns use executeJavaScriptAndGetResult instead of this method.
     * 
     * Within the script, use <code>document</code> to refer to the current document. Note that
     * local variables will not be available once the script has finished executing, though global
     * variables will persist.
     * 
     * <p>
     * Arguments must be a number, a boolean, a String, WebElement, or a List of any combination of
     * the above. An exception will be thrown if the arguments do not meet these criteria. The
     * arguments will be made available to the JavaScript via the "arguments" magic variable, as if
     * the function were called via "Function.apply"
     * 
     * @param script The JavaScript to execute
     * @param args The arguments to the script. May be empty
     * @return {@link BrowserAction} to enable chaining.
     */
    public BrowserAction executeJavaScript(String script, Object... args) {
        executeJavaScriptAndGetResult(script, args);
        return this;
    }

}
