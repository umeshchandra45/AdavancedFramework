package com.Forsys.ui.actions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Forsys.api.report.ExtentReportListener;

public class SelectBox {

    private Waits wait;

    SelectBox(WebDriver driver) {
        this.wait = new Waits(driver);
    }

    /**
     * Selects option from drop down if the select box uses select tag and options uses option tags
     * like shown.
     *
     * <pre>
     *   &lt;select&gt;
     *     &lt;option&gt;optionToSelect&lt;/option&gt;
     *   &lt;/select&gt;
     * </pre>
     *
     * @param optionToSelect option to select
     */
    public SelectBox selectOptionFromDropDown(By selectLocator, String optionToSelect) {
        WebElement select = wait.waitUntilElementFound(selectLocator, 5);
        List<WebElement> options = select.findElements(By.tagName("option"));
        boolean isOptionSelected = false;
        List<String> optionTexts = new LinkedList<String>();
        for (WebElement option : options) {
            optionTexts.add(option.getText());
            if (optionToSelect.equals(option.getText())) {
                option.click();
                ExtentReportListener.extent_test.get()
                                                .info("<b>Selected</b> " + option.getText() + " from " + select
                                                                                                               .getAttribute("name"));
                isOptionSelected = true;
                break;
            }
        }
        if (!isOptionSelected) {
            throw new RuntimeException("Option '" + optionToSelect + "' was not found for " + selectLocator + "\n" +
                                       "Options found were:" + optionTexts);
        }
        return this;
    }

    /**
     * Selects option from drop down by value if the select box uses select tag and options uses
     * option tags like shown.
     *
     * <pre>
     *   &lt;select&gt;
     *     &lt;option&gt;optionToSelect&lt;/option&gt;
     *   &lt;/select&gt;
     * </pre>
     *
     * @param valueOfOptionToSelect
     * @return
     */
    public SelectBox selectBox(By selectLocator, String valueOfOptionToSelect) {
        WebElement select = wait.waitUntilElementFound(selectLocator, 5);
        List<WebElement> options = select.findElements(By.tagName("option"));
        boolean isOptionSelected = false;
        List<String> optionValues = new LinkedList<String>();
        for (WebElement option : options) {
            optionValues.add(option.getAttribute("value"));
            if (valueOfOptionToSelect.equals(option.getAttribute("value"))) {
                option.click();
                ExtentReportListener.extent_test.get()
                                                .info(
                                                      "<b>Selected</b> " + option.getAttribute("value") + " from " +
                                                      select.getAttribute("name"));
                isOptionSelected = true;
                break;
            }
        }
        if (!isOptionSelected) {
            throw new RuntimeException("Option '" + valueOfOptionToSelect + "' was not found for " + selectLocator +
                                       "\n" + "Options found were:" + optionValues);
        }
        return this;
    }

    /**
     * Gets all the options from the specified select box as {@link List} of Strings .
     */
    public List<String> getAllOptionsFromDropDown(By selectBoxLocator) {
        WebElement select = wait.waitUntilElementFound(selectBoxLocator, 5);
        List<WebElement> options = select.findElements(By.tagName("option"));
        List<String> optionTexts = new ArrayList<String>();
        for (WebElement option : options) {
            optionTexts.add(option.getText());
        }
        return optionTexts;
    }

    /**
     * Gets all the options from the specified select box as {@link List} of Strings .
     */
    public List<String> getAllOptionsFromDropDownLocatedByName(String selectBoxName) {
        By locator = By.cssSelector("select[name=\"" + selectBoxName.trim() + "\"]>option");
        List<WebElement> selectOptions = wait.waitUntilElementsFound(locator, 5);

        List<String> allOptions = new ArrayList<String>();
        for (WebElement selectOption : selectOptions) {
            allOptions.add(selectOption.getText());
        }
        return allOptions;
    }

    /**
     * Selects option from drop down if the select box uses select tag and options uses option tags
     * and has name associated with the select box.
     *
     * <pre>
     *   &lt;select&gt;
     *     &lt;option&gt;optionToSelect&lt;/option&gt;
     *   &lt;/select&gt;
     * </pre>
     * 
     * @param optionToSelect option to select
     * @throws RuntimeException if the optionToSelect is not available.
     */
    public SelectBox selectOptionByLocatingDropDownWithName(String selectBoxName, String optionToSelect)
        throws RuntimeException {
        By locator = By.cssSelector("select[name=\"" + selectBoxName.trim() + "\"]>option");
        List<WebElement> selectOptions = wait.waitUntilElementsFound(locator, 5);
        String availableOptions = "";
        for (WebElement selectOption : selectOptions) {
            availableOptions = selectOption.getText() + ", " + availableOptions;
            if (selectOption.getText().trim().equals(optionToSelect.trim())) {
                ExtentReportListener.extent_test.get().info("<b>Selecting option</b> " + optionToSelect);
                selectOption.click();
                return this;
            }
        }
        throw new RuntimeException(
                                   "Options: " + optionToSelect + " is not available, Available options are:" +
                                   availableOptions);
    }

    /**
     * Returns selection option from drop down if the select box uses select tag and options uses
     * option tags like shown.
     *
     * <pre>
     *   &lt;select&gt;
     *     &lt;option&gt;optionToSelect&lt;/option&gt;
     *   &lt;/select&gt;
     * </pre>
     *
     * @param selectLocator
     */
    public WebElement getSelectedOptionFromDropDown(By selectLocator) {
        WebElement select = wait.waitUntilElementFound(selectLocator, 5);
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.isSelected()) {
                return option;
            }
        }
        return options.get(0);
    }

}
