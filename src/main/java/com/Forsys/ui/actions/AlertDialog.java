package com.Forsys.ui.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.exceptions.DriverNotCreatedException;

/**
 * Handles interactions with alert dialogs throw by application. Does not help with dialogs thrown
 * by OS level since Webdriver/selenium does not help in this case. Can be accessed via
 * {@link WebActions} --&gt; {@link BrowserAction}
 * 
 * 
 */
public class AlertDialog {
    private WebDriver driver;
    private static final String PROMPT_TEXT = "<b>Typed</b> %s <b>On prompt</b> %s";

    // Prevents instantiation outside package.
    AlertDialog(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new DriverNotCreatedException();
        }
        this.driver = driverInstance;

    }

    /**
     * Enters text on a prompt box and accepts it.
     * 
     * @param textToBeTyped
     */
    public void enterTextOnPromptAndAccept(String textToBeTyped) {
        Alert prompt = driver.switchTo().alert();
        sendKeys(prompt, textToBeTyped);
        prompt.accept();
        ExtentReportListener.extent_test.get().info(" and accepted.");
    }

    /**
     * Enters text on a prompt box and accepts it.
     * 
     * @param textToBeTyped
     */
    public void enterTextOnPrompt(String textToBeTyped) {
        Alert prompt = driver.switchTo().alert();
        sendKeys(prompt, textToBeTyped);
    }

    /**
     * Types the 'textToBeTyped' in the specified alert.
     * 
     * @param alert
     * @param textToBeTyped
     */
    private void sendKeys(final Alert alert, final String textToBeTyped) {
        String text = alert.getText();
        alert.sendKeys(textToBeTyped);
        ExtentReportListener.extent_test.get().info(String.format(PROMPT_TEXT, textToBeTyped, text));
    }

    /**
     * Switches to alert and returns the alert text.
     */
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    /**
     * Switches to Alert and Returns {@link Alert}
     */
    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    /**
     * Accepts/Dismisses the confirmation alert.
     * 
     * @param choice accepts the alert if ACCEPT and dismisses the alert if DISMISS.
     */
    public void actOnConfirmationBox(Choice choice) {
        Alert confirm = driver.switchTo().alert();
        String text = confirm.getText();
        if (choice.equals(Choice.ACCEPT)) {
            confirm.accept();
            ExtentReportListener.extent_test.get().info("<b>Accepted</b> " + text);
        } else {
            confirm.dismiss();
            ExtentReportListener.extent_test.get().info("<b>Dismissed</b> " + text);
        }
    }

    public enum Choice {
        ACCEPT, DISMISS;
    }
}
