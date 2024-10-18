package com.Forsys.ui.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class AdditionalConditions {

    public static ExpectedCondition<Boolean> pageloadingFinished() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState == \"complete\"")
                                                                    .toString());
            }
        };
    }

}
