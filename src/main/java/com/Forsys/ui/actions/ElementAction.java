
package com.Forsys.ui.actions;

import org.openqa.selenium.WebDriver;

import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Provides methods to interact with elements.
 * 
 */
public class ElementAction {
    private WebDriver driver;
    private SelectBox selectBoxElement;
    private TextBox textBoxElement;
    private ElementPresenceChecker present;
    private ElementPresentOnDOMChecker found;
    private ElementEnabledChecker enabled;
    private Click click;
    private Highlight highlight;
    private HTMLAttributes hTMLAttributes;
    private ScreenShot screenShot;

    ElementAction(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;
        this.screenShot = new ScreenShot(driver);
    }

    /**
     * Contains methods to help with select box interactions.
     */
    public SelectBox selectBox() {
        if (selectBoxElement == null) {
            selectBoxElement = new SelectBox(driver);
        }
        return selectBoxElement;
    }

    /**
     * Contains methods to help with text box interactions.
     */
    public TextBox textBox() {
        if (textBoxElement == null) {
            textBoxElement = new TextBox(driver);
        }
        return textBoxElement;
    }

    /**
     * Helps get attributes from elements including ways to build Collections of page data.
     * 
     */
    public HTMLAttributes htmlAttributes() {
        if (hTMLAttributes == null) {
            hTMLAttributes = new HTMLAttributes(driver);
        }
        return hTMLAttributes;
    }

    /**
     * Has different ways to check for presence(isDisplayed).
     */
    public ElementPresenceChecker present() {
        if (present == null) {
            present = new ElementPresenceChecker(driver);
        }
        return present;
    }

    /**
     * Handles various scenarios of element presence on DOM but, may not be displayed yet.
     */
    public ElementPresentOnDOMChecker found() {
        if (found == null) {
            found = new ElementPresentOnDOMChecker(driver);
        }
        return found;
    }

    /**
     * Has different ways to check for isSelected.
     */
    public ElementEnabledChecker isEnabled() {
        if (enabled == null) {
            enabled = new ElementEnabledChecker(driver);
        }
        return enabled;
    }

    /**
     * Provides various ways to locate and click.
     */
    public Click click() {
        if (click == null) {
            click = new Click(driver, screenShot);
        }
        return click;
    }

    /**
     * Use if you want to draw a border around a element on the webpage and highlight it.
     */
    public Highlight highlight() {
        if (highlight == null) {
            highlight = new Highlight(driver);
        }
        return highlight;
    }

}
