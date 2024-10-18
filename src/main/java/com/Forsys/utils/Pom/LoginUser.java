package com.Forsys.utils.Pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.api.report.ExtentReportUtil;
import com.Forsys.exceptions.DriverNotCreatedException;
import com.Forsys.ui.actions.ScreenShot;
import com.Forsys.ui.actions.Waits;
import com.Forsys.ui.actions.WebActions;
import com.Forsys.utils.ReadPropertyFile;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class LoginUser {
    private WebDriver driver;
    WebActions webaction;
    Waits wait;
    ScreenShot screenshot;

    ExtentTest extent = ExtentReportListener.extent_test.get();
    By Login = By.xpath("//input[@id='Login']");
    By Username = By.xpath("//input[@id='username']");
    By Password = By.xpath("//input[@id='password']");
    By Hometab = By.xpath("//a[@title='Home']");

    public LoginUser(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        } else
            this.driver = driver;
        this.webaction = new WebActions(driver);
        this.wait = new Waits(driver);
        this.screenshot = new ScreenShot(driver);
    }

    public void launchURl() throws Exception {
        try {
            String file = System.getProperty("propertyFile");
            webaction.browser().goToUrl(ReadPropertyFile.readPropertyFile(file, "URL"));
            wait.waitUntilElementReliableFound(Login, 10);
            webaction.element()
                     .textBox()
                     .sendKeys(Username, ReadPropertyFile.readPropertyFile(file, "UserName"));
            webaction.element()
                     .textBox()
                     .sendKeys(Password, ReadPropertyFile.readPropertyFile(file, "Password"));
            wait.waitUntilElementsFound(Login);
            extent.pass("Login pass ",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ExtentReportUtil.encodeFileToBase64Binary(screenshot.saveScreenShot(driver)))
                                          .build());
            webaction.element().click().by(Login);
            wait.waitForPageLoaded();
            try {
                wait.waitUntilElementFound(Hometab, 40);
            } catch (Exception e) {
            }
            extent.info("User Login successfully");
        } catch (IOException e) {
            e.printStackTrace();
            extent.log(Status.FAIL, e.getMessage());

        }
    }

}
