package com.Forsys.ui.actions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Helps in getting values of various html attributes from elements in DOM.
 * 
 */
public class HTMLAttributes {

    private Waits wait;

    HTMLAttributes(WebDriver driver) {
        this.wait = new Waits(driver);
    }

    /**
     * Returns the attribute value from the element located by 'locator'
     * 
     * @param locator
     * @param attribute
     * @return value of attribute
     */
    public String getAttributeFromElement(final By locator, String attribute) {
        return wait.waitUntilElementFound(locator, 5).getAttribute(attribute);
    }

    /**
     * Gets attribute value from {@link WebElement}
     * 
     * @param element
     * @param attrbt
     * @return value of attribute
     */
    public String getAttributeFromElement(WebElement element, String attrbt) {
        return element.getAttribute(attrbt);
    }

    /**
     * Gets the values for all 'attributesWhoseValuesAreNeeded' from element located by 'locator' as
     * a attrVsValueMap with key: attrbuteName value:attrbuteValue<br>
     * 
     * @param locator
     * @param attributesWhoseValuesAreNeeded
     * @return map
     */
    public Map<String, String> getAttributesMapForElement(By locator, List<String> attributesWhoseValuesAreNeeded) {
        Map<String, String> attrVsValueMap = new LinkedHashMap<String, String>();
        WebElement element = wait.waitUntilElementFound(locator, 5);
        for (String attr : attributesWhoseValuesAreNeeded) {
            attrVsValueMap.put(attr, getAttributeFromElement(element, attr));
        }
        return attrVsValueMap;
    }

    /**
     * Returns a the values of the css property 'css' from the element located by 'locator'.
     * 
     * @param locator
     * @param css
     * @return String
     */
    public String getCssValue(final By locator, String css) {
        WebElement element = wait.waitUntilElementFound(locator, 5);
        return element.getCssValue(css);
    }

    /**
     * Returns the width of the image located by specified imageLocator.
     * 
     * @param imageLocator
     * @return String width of the image(eg:300px)
     */
    public String getWidthOfImage(final By imageLocator) {
        WebElement element = wait.waitUntilElementFound(imageLocator, 5);
        final String style = element.getAttribute("style");
        if (!style.equals("") && style != null && !style.isEmpty()) {
            for (String string : StringHelper.getStringAsList(style, ";")) {
                if (string.contains("width:"))
                    return string.replace("width:", "").trim();
            }

        }
        String width = element.getAttribute("width");
        if (width != null) {
            return width;
        }
        throw new RuntimeException("Width not set for image located by: " + imageLocator);
    }

    /**
     * Returns the height of the image located by specified imageLocator.
     * 
     * @param imageLocator
     * @return String height of the image(eg:225px)
     */
    public String getHeightOfImage(final By imageLocator) {
        WebElement element = wait.waitUntilElementFound(imageLocator, 5);
        final String style = element.getAttribute("style");
        if (!style.equals("") && style != null && !style.isEmpty()) {
            for (String string : StringHelper.getStringAsList(style, ";")) {
                if (string.contains("height:"))
                    return string.replace("height:", "").trim();
            }
        }
        String height = element.getAttribute("height");
        if (height != null) {
            return height;
        }
        throw new RuntimeException("Height of image not set in UI for " + imageLocator);
    }
}
