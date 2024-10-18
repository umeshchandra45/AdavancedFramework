package com.Forsys.utils.Pom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.api.report.ExtentReportUtil;
import com.Forsys.exceptions.DriverNotCreatedException;
import com.Forsys.ui.actions.ScreenShot;
import com.Forsys.ui.actions.Waits;
import com.Forsys.ui.actions.WebActions;
import com.Forsys.utils.ExcelUtils;
import com.Forsys.utils.RandomUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class QuoteCreation1 {
    private WebDriver driver;
    WebActions webaction;
    Waits wait;
    ScreenShot s;
    RandomUtils randam;
    // String filepath;
    String sheetName;
    String accountLocation;
    String locationName;
    String account;
    String referenceAccount;
    String billto;
    String shipto;
    String priceList;
    String countryProductsDeployed;
    String primaryProductLine;
    String partnerIncentiveAmt;
    ExtentTest extent = ExtentReportListener.extent_test.get();

    By createQuote = By.xpath("//button[text()= 'Create Quote/Proposal']");
    By accountLocationSearch = By.xpath("//input[@placeholder='Search Account Locations...']");
    By newAccountLocationSearch = By.xpath("//span[@title='New Account Location']");
    By locationNameInput = By.xpath("//label[span='Location Name']/..//input");
    By accountSearch = By.xpath("//label[span='Account']/..//input");
    By accountDropdownSelect = By.xpath("(//label[span='Account']/..//div[@title='COX COMMUNICATIONS'])[2]");
    By referenceaccountDropdownSelect = By
                                          .xpath("//label[span='Reference Account']/..//div[@title='COX COMMUNICATIONS']");
    By referenceAccountSearch1 = By.xpath("(//label[span='Reference Account']/..//input)[2]");
    By referenceAccountSearch = By.xpath("//label[span='Reference Account']/..//input");
    By billtoSearch = By.xpath("//label[contains(text(),'Bill To')]/..//input");
    By shiptoSearch = By.xpath("//label[contains(text(),'Ship To')]/..//input");
    By priceListSearch = By.xpath("//label[contains(text(),'Price List')]/..//input");
    By cancelButton = By
                        .xpath("//label[contains(text(),'Price List')]/..//*[local-name()='svg' and @data-key='close']");
    By primaryProductLineInput = By.xpath("//*[text()='Primary Product Line Type']/..//button");
    By countryProductDeployedInput = By.xpath("//*[text()='Country Products Deployed']/..//button");
    By contactSelection = By.xpath("//div[@title='COX COMMUNICATIONS']");
    By billtoSelection = By.xpath("//a[@data-recordid='0017000000QyyINAAZ']");
    By priceListSelection = By.xpath("//a[contains(text(), 'Global Euro')]");
    By referenceAccountSelection = By.xpath("(//a[@title='COX COMMUNICATIONS'])[13]");
    By Save = By.xpath("//button[@title= 'Save']");
    By Save2 = By.xpath("//button[text()= 'Save']");
    By prepaycheckbox = By.xpath("//span[contains(text(),'Is Prepay Quote')]/../..//input");
    By partnerIncentivecheckbox = By.xpath("//input[@name='APTS_PartnerFunds__c']");
    By partnerIncentiveAmount = By.xpath("//label[text()='Partner incentive amount']/..//input");

    public QuoteCreation1(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        } else
            this.driver = driver;
        this.webaction = new WebActions(driver);
        this.wait = new Waits(driver);
        this.s = new ScreenShot(driver);
        this.randam = new RandomUtils();
    }

    public WebElement countryProductDeployedSelect(String countryProductsDeployed) {
        String xpath = "//span[@title='" + countryProductsDeployed + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement primaryProductLineSelect(String primaryProductLine) {
        String xpath = "//span[@title='" + primaryProductLine + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectLocation(String locationName) {
        String xpath = "(//a[@title='" + locationName + "'])";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement accountLocationDropdownSelect(String accountLocationtype, String accountLocationname) {
        String xpath = "//label[span='" + accountLocationtype + "']/..//div[@title='" + accountLocationname + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement locationDropDownSelect(String accounttype, String locationname) {
        String xpath = "//label[text()='" + accounttype +
                       "']/following::lightning-base-combobox-formatted-text[@title='" + locationname + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement billtoDropDownSelect(String billtotype, String billtoname) {
        String xpath = "(//label[text()='" + billtotype +
                       "']/following::lightning-base-combobox-formatted-text[@title='" + billtoname + "'])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement priceListDropDownSelect(String pricelisttype, String pricelistname) {
        String xpath = "//label[text()='" + pricelisttype +
                       "']/following::lightning-base-combobox-formatted-text[@title='" + pricelistname + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement shiptoDropDownSelect(String shiptotype, String shiptoname) {
        String xpath = "(//label[text()='" + shiptotype +
                       "']/following::lightning-base-combobox-formatted-text[@title='" + shiptoname + "'])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement accountDropdownSelect(String accounttype, String accountname) {
        String xpath = "//label[span='" + accounttype + "']/..//div[@title='" + accountname + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement referenceaccountDropdownSelect(String referenceaccounttype, String referenceaccountname) {
        String xpath = "//label[span='" + referenceaccounttype + "']/..//div[@title='" + referenceaccountname + "']";
        return driver.findElement(By.xpath(xpath));
    }

    private void accountSelect(String accounttype, String accountname) throws InterruptedException {
        try {
            try {
                wait.waituntilElementIsDisplayedAndClick(accountSearch);
                webaction.element().textBox().sendKeys(accountSearch, account);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(accountDropdownSelect(accounttype, accountname));
            } catch (Exception e) {
                webaction.element().textBox().sendKeys(accountSearch, Keys.ENTER);
                wait.waitForPageLoaded();
                wait.waituntilElementIsDisplayedAndClick(selectLocation(locationName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void billtoSelect(String billtotype, String billtoname) throws InterruptedException {
        try {
            try {
                webaction.browser().scroll().scrollintoview(billtoSearch);
                wait.waituntilElementIsDisplayedAndClick(billtoSearch);
                webaction.element().textBox().sendKeys(billtoSearch, billto);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(billtoDropDownSelect(billtotype, billtoname));
            } catch (Exception e) {
                webaction.element().textBox().sendKeys(billtoSearch, Keys.ENTER);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(billtoSelection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shiptoSelect(String shiptotype, String shiptoname) throws InterruptedException {
        try {
            try {
                wait.waituntilElementIsDisplayedAndClick(shiptoSearch);
                webaction.element().textBox().sendKeys(shiptoSearch, shipto);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(shiptoDropDownSelect(shiptotype, shiptoname));
            } catch (Exception e) {
                webaction.element().textBox().sendKeys(shiptoSearch, Keys.ENTER);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(billtoSelection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void priceListSelect(String pricelisttype, String pricelistname) throws InterruptedException {
        try {
            try {
                webaction.browser().scroll().scrollintoview(priceListSearch);
                wait.waituntilElementIsDisplayedAndClick(priceListSearch);
                wait.waituntilElementIsDisplayedAndClick(cancelButton);
                webaction.element().textBox().sendKeys(priceListSearch, priceList);
                Thread.sleep(10000);
                wait.waituntilElementIsDisplayedAndClick(priceListDropDownSelect(pricelisttype, pricelistname));
            } catch (Exception e) {
                webaction.element().textBox().sendKeys(priceListSearch, Keys.ENTER);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(priceListSelection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prepayCheckbox() {
        try {
            wait.waitUntilElementFound(prepaycheckbox, 20);
            webaction.element().click().jsClick(prepaycheckbox);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void referenceaccountSelect(String referenceaccounttype, String referenceaccountname)
        throws InterruptedException {
        try {
            try {
                wait.waituntilElementIsDisplayedAndClick(referenceAccountSearch);
                webaction.element().textBox().sendKeys(referenceAccountSearch, referenceAccount);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(
                                                         referenceaccountDropdownSelect(referenceaccounttype,
                                                                                        referenceaccountname));
            } catch (Exception e) {
                wait.waituntilElementIsDisplayedAndClick(referenceAccountSearch1);
                webaction.element().textBox().sendKeys(referenceAccountSearch1, referenceAccount);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(
                                                         referenceaccountDropdownSelect(referenceaccounttype,
                                                                                        referenceaccountname));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void partnerIncentive() {
        try {
            webaction.browser().scroll().scrollintoview(partnerIncentivecheckbox);
            wait.waitUntilElementFound(partnerIncentivecheckbox, 10);
            webaction.element().click().jsClick(partnerIncentivecheckbox);
            wait.waituntilElementIsDisplayedAndClick(partnerIncentiveAmount);
            webaction.element().textBox().sendKeys(partnerIncentiveAmount, partnerIncentiveAmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void accountLocationSelect(String accountLocationtype, String accountLocationname)
        throws InterruptedException {
        try {
            try {
                wait.waituntilElementIsDisplayedAndClick(accountLocationSearch);
                webaction.element().textBox().sendKeys(accountLocationSearch, locationName);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(
                                                         accountLocationDropdownSelect(accountLocationtype,
                                                                                       accountLocationname));
            } catch (Exception e) {
                webaction.element().textBox().sendKeys(accountLocationSearch, Keys.ENTER);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(selectLocation(locationName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String quoteCreations(String sceName,
                                 HashMap<String, String> quoteCreation,
                                 int i,
                                 String filepath,
                                 int statuscol,
                                 int commentcol,
                                 int idcol) throws IOException {
        List<Boolean> tcResult = new ArrayList<Boolean>();
        boolean tcIsCompleted = false;
        String status = "";
        String comment = "";
        // filepath = System.getProperty("user.dir") + "/ExcelData/HarmonicTestCase1.xlsx";
        sheetName = "Quote_Creation";
        try {
            basicDetailsofQuote(sceName, quoteCreation, i, filepath);
            webaction.browser().scroll().scrollintoview(Save2);
            webaction.element().click().by(Save2);
            try {
                wait.waitUntilElementDisappear(Save2, 60);
                int index = driver.getCurrentUrl().split("/").length - 2;
                String[] quote = driver.getCurrentUrl().split("/");
                String quoteId = quote[index];
                System.out.println("quote= " + quoteId);
                ExcelUtils.writeData(sheetName, filepath, quoteId, idcol, i);
            } catch (Exception e) {
                extent.info("Target frame detach" + e.getMessage());
            }
            status = "Pass";
            comment = "Quote created";
            tcIsCompleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = "Fail";
            comment = "Exception Occurred";

            extent.info("Exception occured in Opportunity",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
            tcResult.add(false);
        } finally {
            ExcelUtils.writeData(sheetName, filepath, status, statuscol, i);
            ExcelUtils.writeData(sheetName, filepath, comment, commentcol, i);

        }
        String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
        return exeStatus;
    }

    public String basicDetailsofQuote(String sceName, HashMap<String, String> quotecreation, int i, String filepath)
        throws IOException {
        List<Boolean> tcResult = new ArrayList<Boolean>();
        boolean tcIsCompleted = false;
        Random r = new Random();
        int no = r.nextInt(10000);
        String locationName = "New_Location";

        try {
            this.locationName = quotecreation.get("Account Location");
            String locname = no + "_" + locationName;
            this.account = quotecreation.get("Account");
            this.referenceAccount = quotecreation.get("Reference Account");
            this.billto = quotecreation.get("Bill To");
            this.shipto = quotecreation.get("Ship To");
            this.priceList = quotecreation.get("Price List");
            this.countryProductsDeployed = quotecreation.get("Country Products Deployed");
            this.primaryProductLine = quotecreation.get("Primary Product Line");
            if (sceName.equalsIgnoreCase("partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                         "PartnerIncentive_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "Multipath_partnerIncentice_MRR_TermDiscounts")) {
                this.partnerIncentiveAmt = quotecreation.get("Partner incentive amount");
            }
            // wait.waitForPageLoaded();
            Thread.sleep(7000);
            wait.waitUntilElementReliableFound(createQuote, 180);
            webaction.element().click().jsClick(createQuote);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            if (sceName.equalsIgnoreCase("prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                  "VOS360_PC_prepay_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts")) {
                prepayCheckbox();
            }
            if (sceName.equalsIgnoreCase("Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                           "VOS360_PC_Approvals_APACEMEA") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_APACEMEA")) {
                accountLocationSelect("Account Location", locationName);
            } else {
                wait.waitUntilElementFound(accountLocationSearch, 20);
                webaction.element().click().jsClick(accountLocationSearch);
                wait.waitForPageLoaded();
                wait.waitUntilElementFound(newAccountLocationSearch, 10);
                wait.waituntilElementIsDisplayedAndClick(newAccountLocationSearch);
                wait.waitForPageLoaded();
                wait.waitUntilElementFound(locationNameInput, 15);
                webaction.element().textBox().sendKeys(locationNameInput, locname);
                accountSelect("Account", account);
                referenceaccountSelect("Reference Account", referenceAccount);
                wait.waituntilElementIsDisplayedAndClick(Save);
                ExcelUtils.writeData(sheetName, filepath, locname, 2, i);
            }
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            billtoSelect("Bill To", billto);
            shiptoSelect("Ship To", shipto);
            if (!priceList.equals("NA")) {
                priceListSelect("Price List", priceList);
            }
            webaction.browser().scroll().scrollPage("0", "100");
            webaction.browser().scroll().scrollintoview(countryProductDeployedInput);
            wait.waituntilElementIsDisplayedAndClick(countryProductDeployedInput);
            wait.waituntilElementIsDisplayedAndClick(countryProductDeployedSelect(countryProductsDeployed));
            webaction.browser().scroll().scrollintoview(primaryProductLineInput);
            wait.waituntilElementIsDisplayedAndClick(primaryProductLineInput);
            wait.waituntilElementIsDisplayedAndClick(primaryProductLineSelect(primaryProductLine));
            if (sceName.equalsIgnoreCase("partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                         "PartnerIncentive_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "Multipath_partnerIncentice_MRR_TermDiscounts")) {
                partnerIncentive();
            }
            tcIsCompleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Exception occured in Quote",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
        }

        String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
        return exeStatus;
    }
}
