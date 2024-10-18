package com.Forsys.utils;

import java.net.URL;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class JqueryUtil {
    private JavascriptExecutor js;
    private WebDriver driver;

    public JqueryUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void runjQuery(String str_query) throws Exception {
        enablejQuery();
        js = (JavascriptExecutor) driver;
        js.executeScript(str_query);
    }

    public void enablejQuery() throws Exception {
        js = (JavascriptExecutor) driver;
        String readyState = js.executeScript("return document.readyState").toString();
        System.out.println("Ready State: " + readyState);
        System.out.println("Is Jquery loaded......" + isjQueryLoaded());
        if (!isjQueryLoaded()) {
            URL jqueryUrl = Resources.getResource("jquery-3.6.0.min.js");
            System.out.println(jqueryUrl.getPath());
            String jqueryText = Resources.toString(jqueryUrl, Charsets.UTF_8);
            js.executeScript(jqueryText);
        }
        System.out.println("Is Jquery loaded......" + isjQueryLoaded());
    }

    public Boolean isjQueryLoaded() throws Exception {
        return (Boolean) js.executeScript("return !!window.jQuery;");
    }

}
