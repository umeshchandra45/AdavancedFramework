package com.Forsys.utils.Pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.api.report.ExtentReportUtil;
import com.Forsys.exceptions.DriverNotCreatedException;
import com.Forsys.ui.actions.ScreenShot;
import com.Forsys.ui.actions.Waits;
import com.Forsys.ui.actions.WebActions;
import com.Forsys.utils.ExcelUtils;
import com.Forsys.utils.RandomUtils;
import com.Forsys.utils.ReadPropertyFile;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class OpportunityCreation1 {
    private WebDriver driver;
    WebActions webaction;
    Waits wait;
    ScreenShot s;
    RandomUtils randam;
    PomClasses p;
    // String filepath;
    String oppSheetName;
    String quoteSheetName;
    String testCaseNo;
    String accountName;
    String opportunityName;
    String primaryCont;
    String customerType;
    String businessType;
    String stage;
    String poexpectedcloseDate;
    String Req1stShiporGoLiveDate;
    String industryType;
    String primaryProduct;
    String opportunitySolutionType;
    String agentCommissions;
    String primaryProductLine;
    String locationName;
    String accounts;
    String partnerServiceLevel;
    String customerforSalesComp;

    String file = System.getProperty("propertyFile");
    ExtentTest extent = ExtentReportListener.extent_test.get();
    By setup = By.xpath("//*[local-name()='svg' and @data-key='setup']");
    By setupgear = By.xpath("//div[starts-with(@class,'popupTargetContainer menu--nubbin-top uiPopupTarget')]//li[1]");
    By searchSetup = By.xpath("//input[@title='Search Setup']");
    By hometab = By.xpath("(//a[@title='Home'])[1]");
    By login = By.xpath("//td[@class='pbButton']//input[@title='Login']");
    By accountSearchbtn = By.xpath("//button[contains(text(), 'Search...')]");
    By accountSearchinp = By.xpath("//input[contains(@placeholder, 'Search...')]");
    By accountname = By
                       .xpath("//span[text()='Parent Account']/parent::div/following-sibling::div//span[@id= 'window']");
    By searchIcon = By.xpath("//div[@class='slds-icon-waffle']");
    By searchInput = By.xpath("//input[@class='slds-input']");
    By Accounts = By.xpath("//a[@data-label='Accounts']");
    By Opportunity = By.xpath("//a[@title='Opportunities']");
    By downButton = By.xpath("//button[@title='Select a List View']");
    By allOpportunities = By.xpath("(//span[contains(text(), 'All Open Opportunities')])[1]");
    By Allaccounts = By.xpath("//span[contains(text(), 'All Accounts')]");
    By opportunitySearchInput = By.xpath(
                                         "//div[@class='slds-col slds-no-flex slds-grid slds-align-bottom slds-shrink']//input[@name='Opportunity-search-input']");
    By accountSearchInput = By.xpath(
                                     "//div[@class='slds-col slds-no-flex slds-grid slds-align-bottom slds-shrink']//input[@name='Account-search-input']");
    By accountNameInput = By.xpath("(//a[@title='COX COMMUNICATIONS'])[1]");
    By newOpportunity = By.xpath(
                                 "//div[contains(@class,'active lafPageHost')]//button[contains(text(), 'New Opportunity')]");
    By nextButton = By.xpath("//span[normalize-space(text())='Next']");
    By opportunityNameText = By.xpath("//label[text()='Opportunity Name']/..//input");
    By primaryContactSearch = By.xpath("//label[contains(text(),'Primary Contact')]/..//input");
    By selectContact = By.xpath("//a[@title='Adam Hall']");
    By stageInput = By.xpath("(//*[text()='Stage']/..//button)[2]");
    By customerTypeInput = By.xpath("(//*[text()='Customer Type']/..//button)[2]");
    By businessTypeInput = By.xpath("(//*[text()='Business Type']/..//button)[2]");
    By closeDate = By.xpath("//input[@name='CloseDate']");
    By shipDate = By.xpath("//input[@name='Requested_1st_ship_date__c']");
    By industryTypeInput = By.xpath("(//*[text()='Industry Type']/..//button)[2]");
    By opportunitySolutionInput = By.xpath("(//*[text()='Opportunity Solution Type']/..//button)[2]");
    By primaryProductLineInput = By.xpath("(//*[text()='Primary Product Line']/..//button)[2]");
    By agentCommission = By.xpath("(//*[text()='Agent Commissions']/..//button)[2]");
    By save = By.xpath("//button[text()= 'Save']");
    By accoName = By.xpath("//span[text()='Parent Account']/parent::div/following-sibling::div//a//span");
    By userIframe = By.xpath("//Iframe[starts-with(@name,'vfFrameId')]");
    By iframe = By.xpath(
                         "//div[@class='iframe-parent slds-template_iframe slds-card']//Iframe[starts-with(@name,'vfFrameId')]");
    By nonStandardTerm = By.xpath("//span[@title='None']");
    By nonStandardSelection = By.xpath("//button[@title='Move selection to Chosen']");
    By down = By.xpath(
                       "//div[contains(@class,'active lafPageHost')]//button[@class='slds-button slds-button_icon-border-filled']");
    By newAccountLocation = By.xpath("//button[text()= 'Create Account Location']");
    By newAccountLocation1 = By.xpath("//a[@name='APTS_B_Create_Account_Location']");
    By Save1 = By.xpath("//input[@value='Save']");
    By locationnameinput = By.xpath("(//label[text()='Location Name']/../..//input)[1]");
    By accountNameClick = By.xpath("//span[text()='Reference Account']/../..//span[text()='COX COMMUNICATIONS']");
    By userlogout = By.xpath("//a[@class='action-link']");
    By resellerButton = By
                          .xpath("//span[contains(text(), 'Opportunity - Reseller')]/../..//span[@class='slds-radio--faux']");
    By partnerService = By.xpath("//*[text()='Partner Service Level']/..//button");
    By salesComp = By.xpath("//*[text()='Type of Customers for Sales Comp']/..//button");

    public OpportunityCreation1(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        } else
            this.driver = driver;
        this.webaction = new WebActions(driver);
        this.wait = new Waits(driver);
        this.s = new ScreenShot(driver);
        this.p = new PomClasses(driver);
        this.randam = new RandomUtils();
    }

    public WebElement selectUser(String username) {
        String xpath = "(//span[@title='" + username + "'])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement accountSelect(String accountName) {
        String xpath = "(//a[@title='" + accountName + "'])[3]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement primaryContactSearch(String primaryContact) {
        String xpath = "//label[text()='" + primaryContact + "']/following-sibling::div//input";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement stageSelect(String stage) {
        String xpath = "//span[@title='" + stage + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement customerTypeSelect(String customerType) {
        String xpath = "//span[@title='" + customerType + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement businessTypeSelect(String businessType) {
        String xpath = "//span[@title='" + businessType + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement industryTypeSelect(String industryType) {
        String xpath = "//span[@title='" + industryType + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement primaryProductLineSelect(String primaryProductLine) {
        String xpath = "//span[@title='" + primaryProductLine + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement opportunitySolutionTypeSelect(String opportunitySolutionType) {
        String xpath = "//span[@title='" + opportunitySolutionType + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement agentCommissionsSelect(String agentCommissions) {
        String xpath = "//span[@title='" + agentCommissions + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement partnerServiceSelect(String partnerService) {
        String xpath = "//span[@title='" + partnerService + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement salesCompSelect(String SalesComp) {
        String xpath = "//span[@title='" + SalesComp + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public void accountLocationCreation(HashMap<String, String> newopp, int i, String filepath) throws Exception {
        Random r = new Random();
        int no = r.nextInt(1000);
        String locationName = "New Location";
        quoteSheetName = "Quote_Creation";
        try {
            this.locationName = newopp.get("Location Name");
            String locname = no + "_" + locationName;
            try {
                wait.waitUntilElementFound(newAccountLocation, 30);
                webaction.element().click().jsClick(newAccountLocation);
            } catch (Exception e) {
                wait.waituntilElementIsDisplayedAndClick(down);
                wait.waitUntilElementFound(newAccountLocation1, 30);
                webaction.element().click().jsClick(newAccountLocation1);
            }
            Thread.sleep(7000);
            wait.elementWait(iframe, 20);
            webaction.browser().switchToFrame(iframe);
            Thread.sleep(5000);
            webaction.element().textBox().sendKeys(locationnameinput, locname);
            wait.waituntilElementIsDisplayedAndClick(Save1);
            try {
                webaction.browser().switchToDefault();
            } catch (Exception e) {

            }
            try {
                wait.waitUntilElementReliableFound(accountNameClick, 5);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
            } catch (Exception e) {

            }
            Thread.sleep(5000);
            webaction.element().click().jsClick(accountNameClick);
            System.out.println(locname);
            ExcelUtils.writeData(quoteSheetName, filepath, locname, 2, i);

        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Account location not created",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
        }

    }

    public String opportunityCreation(String sceName,
                                      HashMap<String, String> newopp,
                                      int i,
                                      String filepath,
                                      int statuscol,
                                      int commentcol,
                                      int idcol) throws Exception {
        List<Boolean> tcResult = new ArrayList<Boolean>();
        boolean tcIsCompleted = false;
        String status = "";
        String comment = "";
        // filepath = System.getProperty("user.dir") +
        // "/ExcelData/HarmonicTestCase1.xlsx";
        oppSheetName = "Opportunity_Creation";

        try {
            basicOpportunityDetails(sceName, newopp, i, filepath);
            wait.waituntilElementIsDisplayedAndClick(save);
            wait.waitForPageLoaded();
            wait.waitUntilElementDisappear(save, 50);
            int index = driver.getCurrentUrl().split("/").length - 2;
            String[] opportunity = driver.getCurrentUrl().split("/");
            String opportunityId = opportunity[index];
            System.out.println("Opportunity= " + opportunityId);
            ExcelUtils.writeData(oppSheetName, filepath, opportunityId, idcol, i);
            status = "Pass";
            comment = "Opportunity Created";
            tcIsCompleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = "Fail";
            comment = "Exception Occurred";
            extent.info("Exception occured in Opportunity",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
            tcResult.add(false);
        } finally {

            ExcelUtils.writeData(oppSheetName, filepath, status, statuscol, i);
            ExcelUtils.writeData(oppSheetName, filepath, comment, commentcol, i);

        }
        String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
        return exeStatus;
    }

    public void basicOpportunityDetails(String sceName, HashMap<String, String> newopp, int i, String filepath)
        throws Exception {
        Random r = new Random();
        int no = r.nextInt(10000);
        if (sceName.contains("VOS360_PC")) {
            opportunityName = "VOS360_PC New_Opp";
        } else if (sceName.contains("Multipath")) {
            opportunityName = "VOS360_Multipath New_Oppr";
        } else {
            opportunityName = "VOS360 New_Oppr";
        }

        // filepath = System.getProperty("user.dir") +
        // "/ExcelData/HarmonicTestCase1.xlsx";
        oppSheetName = "Opportunity_Creation";

        try {
            testCaseNo = newopp.get("Test case no");
            this.accountName = newopp.get("Account Name");
            String oppname = no + "_" + opportunityName;
            this.primaryCont = newopp.get("Primary Contact");
            this.stage = newopp.get("Stage");
            this.customerType = newopp.get("Customer Type");
            this.businessType = newopp.get("Business Type");
            this.industryType = newopp.get("Industry type ");
            this.opportunitySolutionType = newopp.get("Opportunity Solution Type");
            this.primaryProductLine = newopp.get("Primary Product");
            this.agentCommissions = newopp.get("Agent Commissions");
            this.accounts = newopp.get("Title Name");
            if (sceName.equalsIgnoreCase("partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                         "PartnerIncentive_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "Multipath_partnerIncentice_MRR_TermDiscounts")) {
                this.partnerServiceLevel = newopp.get("Partner Service Level");
                this.customerforSalesComp = newopp.get("Type of Customers for Sales Comp");
            }
            Thread.sleep(5000);
            wait.waitUntilElementFound(setup, 5);
            wait.waituntilElementIsDisplayedAndClick(setup);
            wait.waituntilElementIsDisplayedAndClick(setupgear);
            wait.waitForPageLoaded();
            Set<String> windows = webaction.browser().getWindowHandles();
            webaction.browser().switchToWindowHandle((String) windows.toArray()[1]);
            Thread.sleep(5000);
            if (sceName.equalsIgnoreCase("Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                           "VOS360_PC_Approvals_NAMLATAM") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM")) {
                wait.waituntilElementwritable(searchSetup,
                                              ReadPropertyFile.readPropertyFile(file, "NAMLATAMSalesPerson"));
                wait.elementWait(login, 15);
                wait.waituntilElementIsDisplayedAndClick(
                                                         selectUser(ReadPropertyFile.readPropertyFile(file,
                                                                                                      "NAMLATAMSalesPerson")));

            } else if (sceName.equalsIgnoreCase("Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                                  "VOS360_PC_Approvals_APACEMEA") ||
                       sceName.equalsIgnoreCase("Multipath_Approvals_APACEMEA")) {
                wait.waituntilElementwritable(searchSetup,
                                              ReadPropertyFile.readPropertyFile(file, "APACEMEASalesPerson"));
                wait.elementWait(login, 15);
                wait.waituntilElementIsDisplayedAndClick(
                                                         selectUser(ReadPropertyFile.readPropertyFile(file,
                                                                                                      "APACEMEASalesPerson")));

            } else {
                wait.waituntilElementwritable(searchSetup, ReadPropertyFile.readPropertyFile(file, "SalesPerson"));
                wait.elementWait(login, 15);
                wait.waituntilElementIsDisplayedAndClick(
                                                         selectUser(ReadPropertyFile.readPropertyFile(file,
                                                                                                      "SalesPerson")));
            }
            wait.elementWait(userIframe, 20);
            webaction.browser().switchToFrame(userIframe);
            Thread.sleep(7000);
            wait.waituntilElementIsDisplayedAndClick(login);
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.waitUntilElementFound(accountSearchbtn, 15);
            webaction.element().click().jsClick(accountSearchbtn);
            Thread.sleep(5000);
            wait.waitUntilElementFound(accountSearchinp, 15);
            try {
                webaction.element().textBox().sendKeys(accountSearchinp, accountName);
                webaction.element().textBox().sendKeys(accountSearchinp, Keys.ENTER);
            } catch (Exception e) {
                webaction.element().click().by(accountSearchbtn);
                Thread.sleep(5000);
                wait.waitUntilElementFound(accountSearchinp, 15);
                webaction.element().textBox().sendKeys(accountSearchinp, accountName);
                webaction.element().textBox().sendKeys(accountSearchinp, Keys.ENTER);
            }
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.waitUntilElementReliableFound(accountSelect(accountName), 30);
            webaction.browser().scroll().scrollPage("0", "500");
            wait.waituntilElementIsDisplayedAndClick(accountSelect(accountName));
            wait.waitForPageLoaded();
            Thread.sleep(15000);
            wait.waitUntilElementFound(accoName, 15);
            String accName = wait.waitUntilElementFound(accoName, 10).getText();
            System.out.println("accName=" + accName);
            if (!accName.equalsIgnoreCase("") && accName.equalsIgnoreCase(accountName)) {
                wait.waituntilElementIsDisplayedAndClick(accoName);
            }
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            if (sceName.equalsIgnoreCase("Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                           "VOS360_PC_Approvals_APACEMEA") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_APACEMEA")) {
                accountLocationCreation(newopp, i, filepath);
            }
            wait.waitUntilElementReliableFound(newOpportunity, 20);
            webaction.element().click().jsClick(newOpportunity);
            if (sceName.equalsIgnoreCase("partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                         "PartnerIncentive_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "Multipath_partnerIncentice_MRR_TermDiscounts")) {
                wait.waitUntilElementReliableFound(resellerButton, 20);
                webaction.element().click().jsClick(resellerButton);
            }
            wait.waituntilElementIsDisplayedAndClick(nextButton);
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(opportunityNameText, 5);
            webaction.element().textBox().sendKeys(opportunityNameText, oppname);
            webaction.element().textBox().sendKeys(primaryContactSearch, primaryCont);
            Thread.sleep(5000);
            webaction.element().textBox().sendKeys(primaryContactSearch, Keys.ENTER);
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(selectContact, 10);
            wait.waituntilElementIsDisplayedAndClick(selectContact);
            wait.waituntilElementIsDisplayedAndClick(stageInput);
            wait.waituntilElementIsDisplayedAndClick(stageSelect(stage));
            wait.waituntilElementIsDisplayedAndClick(customerTypeInput);
            wait.waituntilElementIsDisplayedAndClick(customerTypeSelect(customerType));
            wait.waitUntilElementDisappear(customerTypeSelect(customerType), 30);
            webaction.browser().scroll().scrollintoview(businessTypeInput);
            wait.waituntilElementIsDisplayedAndClick(businessTypeInput);
            wait.waituntilElementIsDisplayedAndClick(businessTypeSelect(businessType));
            wait.waitUntilElementDisappear(customerTypeSelect(businessType), 30);
            webaction.browser().scroll().scrollPage("0", "50");
            webaction.element().textBox().sendKeys(closeDate, randam.todayDate("MM/dd/yyyy"));
            webaction.element().textBox().sendKeys(shipDate, randam.todayDate("MM/dd/yyyy"));
            webaction.browser().scroll().scrollintoview(industryTypeInput);
            wait.waitUntilElementFound(industryTypeInput, 10);
            wait.waituntilElementIsDisplayedAndClick(industryTypeInput);
            wait.waituntilElementIsDisplayedAndClick(industryTypeSelect(industryType));
            wait.waitUntilElementFound(primaryProductLineInput, 10);
            webaction.browser().scroll().scrollintoview(primaryProductLineInput);
            wait.waituntilElementIsDisplayedAndClick(primaryProductLineInput);
            webaction.browser().scroll().scrollintoview(primaryProductLineSelect(primaryProductLine));
            wait.waituntilElementIsDisplayedAndClick(primaryProductLineSelect(primaryProductLine));
            wait.waitUntilElementFound(opportunitySolutionInput, 10);
            wait.waituntilElementIsDisplayedAndClick(opportunitySolutionInput);
            wait.waituntilElementIsDisplayedAndClick(opportunitySolutionTypeSelect(opportunitySolutionType));
            webaction.browser().scroll().scrollintoview(nonStandardTerm);
            wait.waituntilElementIsDisplayedAndClick(nonStandardTerm);
            wait.waituntilElementIsDisplayedAndClick(nonStandardSelection);
            webaction.browser().scroll().scrollintoview(agentCommission);
            wait.waituntilElementIsDisplayedAndClick(agentCommission);
            wait.waituntilElementIsDisplayedAndClick(agentCommissionsSelect(agentCommissions));
            if (sceName.equalsIgnoreCase("partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                         "PartnerIncentive_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "Multipath_partnerIncentice_MRR_TermDiscounts")) {
                webaction.browser().scroll().scrollintoview(partnerService);
                wait.waituntilElementIsDisplayedAndClick(partnerService);
                wait.waituntilElementIsDisplayedAndClick(partnerServiceSelect(partnerServiceLevel));
                webaction.browser().scroll().scrollintoview(salesComp);
                wait.waituntilElementIsDisplayedAndClick(salesComp);
                wait.waituntilElementIsDisplayedAndClick(salesCompSelect(customerforSalesComp));
            }
            ExcelUtils.writeData(oppSheetName, filepath, oppname, 3, i);
        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Exception occured in Opportunity",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
        }
    }

    public void userLogin(String username) throws IOException, InterruptedException {
        try {
            wait.elementWait(setup, 10);
            webaction.element().textBox().sendKeys(searchSetup, username);
            Thread.sleep(7000);
            wait.elementWait(login, 13);
            wait.waituntilElementIsDisplayedAndClick(selectUser(username));
            wait.elementWait(setup, 10);
            for (int i = 0; i < 3; i++) {
                try {
                    WebDriverWait waitframe = new WebDriverWait(driver, 10);
                    waitframe.until(ExpectedConditions
                                                      .frameToBeAvailableAndSwitchToIt(wait.waitUntilElementFound(userIframe,
                                                                                                                  5)));
                    try {
                        webaction.browser().switchToFrame(userIframe);
                    } catch (Exception e) {
                    }
                    wait.waituntilElementIsDisplayedAndClick(login);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    // Thread.sleep(500);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            extent.log(Status.INFO, "Account " + e.getMessage());
            extent.info(e.getMessage(),
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
        } finally {
            webaction.browser().switchToDefault();
            wait.waitUntilElementTobeDisplayed(Opportunity);
            wait.waitUntilElementFound(Opportunity, 30);
        }
    }

}
