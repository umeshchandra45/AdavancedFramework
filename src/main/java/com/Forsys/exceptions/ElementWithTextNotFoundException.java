package com.Forsys.exceptions;

import java.util.List;

import org.openqa.selenium.By;

/**
 * RuntimeException for cases where a element was found with the locator but does not match or
 * contains text. Automatically takes screenshot and logs in the report.
 * 
 */
public class ElementWithTextNotFoundException
    extends
    RuntimeException {

    private static final long serialVersionUID = -1341277587870095320L;

    public enum TextComparisonCriteria {
        MATCH, CONTAIN;
    }

    public ElementWithTextNotFoundException(By locator,
                                            TextComparisonCriteria textComparisonCriteria,
                                            String expectedText,
                                            List<String> foundTexts) {
        super("\n Found " + foundTexts.size() + " elements using " + locator + " which has these texts:" + foundTexts +
              ". But, element did not " + textComparisonCriteria + " text '" + expectedText + "'");
    }

    public ElementWithTextNotFoundException(By locator,
                                            TextComparisonCriteria textComparisonCriteria,
                                            String expectedText) {
        super("\n Could not find element with locator '" + locator + "' that has text '" + expectedText + "'");
    }
}
