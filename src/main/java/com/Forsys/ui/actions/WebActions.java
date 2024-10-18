package com.Forsys.ui.actions;

import org.openqa.selenium.WebDriver;

import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Contains methods that allow to perform most of the actions on a web page.
 * 
 */
public class WebActions {

    private WebDriver driver;
    private BrowserAction browser;

    public WebActions(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driver;
    }

    /**
     * Allows performing chainable actions on browser.
     * 
     * @return {@link BrowserAction}
     */
    public BrowserAction browser() {
        if (browser == null) {
            browser = new BrowserAction(driver);
        }
        return browser;
    }

    /**
     * Allows performing chainable actions on keyboard.
     * 
     * @return {@link KeyboardActions}
     */
    public KeyboardActions keyboard() {
        return new KeyboardActions(driver);
    }

    public MouseAction mouse() {
        return new MouseAction(driver);
    }

    /**
     * Allows performing chainable actions on element.
     * 
     * @return {@link BrowserAction}
     */
    public ElementAction element() {
        // returns new instance everytime since the state of this instance has to be
        // new to support withinParent and oneFromMany
        return new ElementAction(driver);
    }

}
