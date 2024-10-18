package com.Forsys.utils.Pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.api.report.ExtentReportUtil;
import com.Forsys.exceptions.DriverNotCreatedException;
import com.Forsys.ui.actions.KeyboardActions;
import com.Forsys.ui.actions.ScreenShot;
import com.Forsys.ui.actions.Waits;
import com.Forsys.ui.actions.WebActions;
import com.Forsys.utils.DateUtils;
import com.Forsys.utils.ExcelUtils;
import com.Forsys.utils.RandomUtils;
import com.Forsys.utils.ReadPropertyFile;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class InvoiceCreation {

    private WebDriver driver;
    WebActions webaction;
    Waits wait;
    ScreenShot s;
    RandomUtils randam;
    PomClasses p;
    KeyboardActions action;
    OpportunityCreation1 account;
    OrderActivation order;
    DateUtils dateUtils;
    ExcelUtils excelUtils;
    // String filepath;
    String sheetName;
    String invSheetName;
    String assetNum1;
    String assetNum2;
    String assetNum3;
    String assetNum4;
    String qnty1;
    String qnty2;
    String qnty3;
    String qnty4;
    String usageStatus;
    String qty;
    String productUom;
    String invoiceOverrideTemplate;
    String field;
    String operator;
    String invoiceDataType;
    String startDate;
    String endDate;
    String usageDate;
    String invoiceruns;
    String processthrudate;
    String adjustment;
    String adjReason;
    String orderId;
    String termDisct;
    String orderNum;
    String quoteUrl;
    double price;
    double totMPUsage;
    double totPMMUsage;
    double totPCKGUsage;
    double totMPUsageRound;
    double totPMMUsageRound;
    double totPCKGUsageRound;
    double totalSC;
    double actualTotalForThisInvoice;
    String totalinvoiceamount;
    String totalforInvoiceUI;
    String podusgamount;
    String podprocommit;
    String podsrvcharge;
    String podmnthcommit;
    double podUsageAmount;
    String usageqnty;
    String sfusgamount;
    double appliedPartnerIncentiveAmount;
    double AppliedTermDiscount;

    ExtentTest extent = ExtentReportListener.extent_test.get();
    String file = System.getProperty("propertyFile");
    By assetNumber = By.xpath(
                              "//span[normalize-space()='Asset Number']/parent::div/following-sibling::div//lightning-formatted-text");
    By relatedtab = By.xpath("(//a[@data-label='Related'])[2]");
    By viewallLabel = By.xpath("//span[contains(text(), 'Asset Line Items')]/../..//span[@class='view-all-label']");
    By productName = By.xpath("(//a[contains(text(), 'VOS360-ENC-AVC-HD-EXTRA-RES')])[1]");
    By productName2 = By.xpath("(//a[contains(text(), 'VOS360-SSADI')])[1]");
    By productName3 = By.xpath("(//a[contains(text(), 'VOS360-EGRESS-PACKAGING-ORIGIN')])[1]");
    By productName4 = By.xpath("(//a[contains(text(), 'SCHEDULER-360-SUBSCRIPTION')])[1]");
    By assetNo = By.xpath("//input[contains(@name, 'AssetNumber')]");
    By usageState = By.xpath("//label[text()='Usage Status']/..//button");
    By startdate = By.xpath("//input[@name='Apttus_Billing__StartDate__c']");
    By enddate = By.xpath("//input[@name='Apttus_Billing__EndDate__c']");
    By usagedate = By.xpath("//input[@name='Apttus_Billing__UsageDate__c']");
    By quantity = By.xpath("//label[text()='Quantity']/../..//input");
    By productUOM = By.xpath("(//label[text()='Product Uom']/..//button)[2]");
    By save = By.xpath("//button[@name='SaveEdit' and  @type='button']");
    By inputID = By.xpath("(//span[@title='Usage Inputs']/following::a[@class='flex-wrap-ie11 slds-truncate'])[1]");
    By downInput = By.xpath(
                            "//div[contains(@class,'active lafPageHost')]//button[@class='slds-button slds-button_icon-border-filled']");
    By processUsageInput = By.xpath("//span[contains(text(),'Process Usage Input')]");
    By processButton = By.xpath("(//input[@value='Process' and @type='submit'])[1]");
    By searchIcon = By.xpath("//div[@class='slds-icon-waffle']");
    By searchInput = By.xpath("//input[@class='slds-input']");
    By invoiceRuns = By.xpath("//a[@data-label='Invoice Runs']");
    By newButton = By.xpath("//div[contains(@class,'active lafPageHost')]//a[@title='New']");
    By invoiceRunName = By.xpath("//label[text()='Invoice Run Name']/../..//input");
    By invoiceOverridetemp = By.xpath("//label[text()='Invoice Override Template']/..//button");
    By billingSchedule = By.xpath("//a[@data-label='Billing Schedule']");
    By none = By.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[1]");
    By none1 = By.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[2]");
    By textValue = By.xpath("((//div[@title='Value'])[2]/../../../../..//input[@class='slds-input'])[1]");
    By invoiceDatetype = By.xpath("//label[text()='Invoice Date Type']/..//button");
    By processthroDate = By.xpath("//label[text()='Process thru Date']/../..//input");
    By runButton = By.xpath("//button[@name='update' and  @type='submit']");
    By relatedtab1 = By.xpath("//a[contains(text(),'Related')]");
    By usageInputs = By.xpath("//a[@name='APTS_UIOvverRide']");
    By accountName = By.xpath("//span[text()='Account']/parent::div/following-sibling::div//a//span");
    By orderNumber = By.xpath(
                              "//span[text()='Order Number']/parent::div/following-sibling::div//lightning-formatted-text");
    By orderNumInput = By.xpath("//p[text()='Enter Order Number :']/../../..//input");
    By mnthYear = By.xpath("//input[contains(@id, 'event_start_date')]");
    By validate = By.xpath("(//input[@type='submit' and @value='Validate'])[1]");
    By saveUsage = By.xpath("(//input[@type='submit' and @value='Save'])[1]");
    By done = By.xpath("//button[text()='Done']");
    By qntyUpdate = By.xpath("//div[contains(text(), 'VOS360-ENC-HEVC-HD-EXTRA-RES')]/../..//input");
    By qntyUpdatePC = By.xpath("//div[contains(text(), 'VOS360-PC-ENC-AVC-OTT-HD-PLUS-STD')]/../..//input");
    By currentUsage = By.xpath(
                               "//div[contains(text(), 'VOS360-ENC-HEVC-HD-EXTRA-RES')]/../..//td[contains(@data-label, 'Quantity')]");
    By currentUsagePC = By.xpath(
                                 "//div[contains(text(), 'VOS360-PC-ENC-AVC-OTT-HD-PLUS-STD')]/../..//td[contains(@data-label, 'Quantity')]");
    By relatedtab2 = By.xpath("//div[contains(@class,'active lafPageHost')]//a[contains(text(),'Related')]");

    By quotenumber = By.xpath("(//span[contains(text(),'Quote/Proposal')]/following::a[@class='flex-wrap-ie11'])[1]");
    By newtab = By.xpath("//span[@title='Usage Inputs']/../../../../../..//button[@name='New']");
    By proposalID = By.xpath(
                             "//span[normalize-space()='Proposal ID']/parent::div/following-sibling::div//lightning-formatted-text");
    By proposalnumber = By.xpath(
                                 "//a[contains(text(),'Proposals')]/following::li[@class='slds-breadcrumb__item slds-line-height--reset']");
    By invIframe = By.xpath("//Iframe[starts-with(@name,'vfFrameId')]");
    By salesforceInsIframe = By.xpath("//Iframe[@class='insext-popup']");
    By runIframe = By.xpath("//div[contains(@class,'active lafPageHost')]//Iframe[starts-with(@name,'vfFrameId')]");
    By relatedforinv = By.xpath("//a[@class='slds-tabs_default__link' and normalize-space(.)='Related']");
    By invoiceNumlink = By
                          .xpath("(//th[contains(text(),'Invoice Run Result Name')]/following::div[@class='slds-truncate'])[1]");
    By invoiceStatus = By.xpath("(//th[contains(text(),'Status')]/following::div[@class='slds-truncate'])[2]");
    By invoiceNumber = By.xpath("(//span[@title='Invoice Number']/following::div[@class='slds-truncate'])[2]");
    By invoiceNO = By.xpath(
                            "//span[normalize-space()='Invoice Number']/parent::div/following-sibling::div//lightning-formatted-text");
    By filterButton = By.xpath("//button[@title='Show quick filters']");
    By clearButton = By.xpath("//button[@title='Clear']");
    By assetName = By.xpath("//label[text()='Asset Name']/..//input");
    By apply = By.xpath("//button[@title='Apply']");
    By invoiceEdit = By.xpath("//button[@title='Edit Adjustment Reason']");
    By adjustmt = By.xpath("//label[text()='Adjustments']/following-sibling::div//input");
    By adjReasn = By.xpath(
                           "//label[text()='Adjustment Reason']/following-sibling::div//textarea[contains(@class, 'slds-textarea')]");
    By totalInvoice = By.xpath(
                               "//span[normalize-space()='Total for this invoice']/parent::div/following-sibling::div//lightning-formatted-text");
    By masterWallet = By.xpath("(//span[contains(text(),'Master Wallet')]/following::a[@class='flex-wrap-ie11'])[1]");
    By totalTermDiscount = By.xpath(
                                    "//span[normalize-space()='Total Term Discount Amount']/parent::div/following-sibling::div//lightning-formatted-number");
    By appliedTermDiscount = By.xpath(
                                      "//span[normalize-space()='Applied Term Discount Amount']/parent::div/following-sibling::div//lightning-formatted-number");
    By applicableTermDiscount = By.xpath(
                                         "//span[normalize-space()='Applicable Term Discount Amt']/parent::div/following-sibling::div//lightning-formatted-number");
    By balanceTermDiscount = By.xpath(
                                      "//span[normalize-space()='Balance Term Discount Amount']/parent::div/following-sibling::div//lightning-formatted-number");
    By applyTermDiscount = By.xpath(
                                    "//span[normalize-space()='Applied Term Discount']/parent::div/following-sibling::div//lightning-formatted-text");
    By prepayAmount = By.xpath(
                               "//span[normalize-space()='Prepay Amount']/parent::div/following-sibling::div//lightning-formatted-number");
    By prepaybalance = By.xpath(
                                "//span[normalize-space()='Prepay Balance']/parent::div/following-sibling::div//lightning-formatted-number");
    By prepayUsage = By.xpath(
                              "//span[normalize-space()='Prepay Usage']/parent::div/following-sibling::div//lightning-formatted-number");
    By prepayCredit = By.xpath(
                               "//span[normalize-space()='Prepay Credit']/parent::div/following-sibling::div//lightning-formatted-number");
    By appliedIncentiveAmt = By.xpath(
                                      "//span[normalize-space()='Applied Incentive Funds']/parent::div/following-sibling::div//lightning-formatted-number");
    By totalPartnerIncentiveAmt = By.xpath(
                                           "//span[normalize-space()='Total Partner Incentive funds']/parent::div/following-sibling::div//lightning-formatted-number");
    By availableIncentiveAmt = By.xpath(
                                        "//span[normalize-space()='Partner Incentive Balance Funds']/parent::div/following-sibling::div//lightning-formatted-number");
    By appliedPartnerIncentiveAmt = By.xpath(
                                             "//span[normalize-space()='Applied VAR funds']/parent::div/following-sibling::div//lightning-formatted-number");
    By roundedNetUnitPrice = By.xpath(
                                      "//div[contains(@class,'active lafPageHost')]//span[text()= 'Rounded Net Unit Price']/parent::div/following-sibling::div//lightning-formatted-number");
    By inBillingSchedule = By.xpath("//span[contains(@title, 'Billing Schedules')]");
    By scheduleId = By.xpath("(//span[contains(text(), 'BS-')])[1]");
    By mPProrationCommitment = By.xpath(
                                        "//span[normalize-space()='Proration Commitment ( MP)']/parent::div/following-sibling::div//lightning-formatted-text");
    By mPServiceCharge = By.xpath(
                                  "//span[normalize-space()='Service Charge ( MP)']/parent::div/following-sibling::div//lightning-formatted-text");
    By mPMonthlyCommitment = By.xpath(
                                      "//span[normalize-space()='Monthly Commitment ( MP)']/parent::div/following-sibling::div//lightning-formatted-text");
    By mPTotUsage = By.xpath(
                             "//span[text()='Total Usage (MP)']/parent::div/following-sibling::div//lightning-formatted-text");
    By pODTotUsage = By.xpath(
                              "//span[text()='Total Usage (POD)']/parent::div/following-sibling::div//lightning-formatted-text");
    By pODProrationCommitment = By.xpath(
                                         "//span[normalize-space()='Proration Commitment ( POD)']/parent::div/following-sibling::div//lightning-formatted-text");
    By pODServiceCharge = By.xpath(
                                   "//span[normalize-space()='Service Charge (POD)']/parent::div/following-sibling::div//lightning-formatted-text");
    By pODMonthlyCommitment = By.xpath(
                                       "//span[normalize-space()='Monthly Commitment ( POD)']/parent::div/following-sibling::div//lightning-formatted-text");
    By pMMTotUsage = By.xpath(
                              "//span[normalize-space()='Total Usage (PMM)']/parent::div/following-sibling::div//lightning-formatted-text");
    By pMMMonthlyCommitment = By.xpath(
                                       "//span[normalize-space()='Monthly Commitment (PMM)']/parent::div/following-sibling::div//lightning-formatted-number");
    By pMMProrationCommitment = By.xpath(
                                         "//span[normalize-space()='Proration Commitment (PMM)']/parent::div/following-sibling::div//lightning-formatted-number");
    By pMMServiceCharge = By.xpath(
                                   "//span[normalize-space()='Service Charge (PMM)']/parent::div/following-sibling::div//lightning-formatted-text");
    By sFTotUsage = By.xpath(
                             "//span[text()='Sub Total (SF)']/parent::div/following-sibling::div//lightning-formatted-text");
    By totalforthisInvoice = By.xpath(
                                      "//span[normalize-space()='Total for this invoice']/parent::div/following-sibling::div//lightning-formatted-text");
    By sFServiceCharge = By.xpath(
                                  "//span[normalize-space()='Service Charge (SF)']/parent::div/following-sibling::div//lightning-formatted-text");
    By salesforceInsArrow = By.xpath("//div[contains(@title, 'Show Salesforce details')]");
    By showAllData = By.xpath("//span[text()='Show ']");
    By salesforceFilter = By.xpath("//input[contains(@placeholder, 'Filter')]");
    By apptusProdType = By.xpath(
                                 "//span[normalize-space()= 'Apttus Product Type']/parent::div/following-sibling::div//lightning-formatted-text");
    By invoiceLines = By.xpath(
                               "//span[starts-with(text(), 'Invoice Line Items')]");
    By invoiceLineNumber = By.xpath(
                                    "(//span[contains(text(), 'VOS360-EGRESS-PACKAGING-ORIGIN-CDN')]/../../..//a[@data-aura-class='forceOutputLookup'])");
    By usageQty = By.xpath("//legend[contains(text(), 'Usage Quantity')]/..//label[text()='Min']/..//input");
    By multipathTotalValue = By.xpath(
                                      "//span[normalize-space()='Multipath Total Volume']/parent::div/following-sibling::div//lightning-formatted-number");
    By multipathTotalUsed = By.xpath(
                                     "//span[normalize-space()='Multipath Total Used Volume']/parent::div/following-sibling::div//lightning-formatted-number");
    By multipathbalanceValue = By.xpath(
                                        "//span[normalize-space()='Multipath Balance Volume']/parent::div/following-sibling::div//lightning-formatted-number");
    By assetLineItem = By.xpath("//label[text()='Asset Line Item']/..//input");
    By billingschedule1 = By.xpath(
                                   "//span[contains(text(), 'Billing Schedule')]/../..//a[@class='flex-wrap-ie11']");
    By committedQty = By.xpath(
                               "//span[normalize-space()='Committed quantity']/parent::div/following-sibling::div//lightning-formatted-number");
    By invoiceLineNum = By.xpath(
                                 "(//a[contains(text(), 'VOS360-EGRESS-PACKAGING-ORIGIN-CDN')]/../../..//a[@data-aura-class='forceOutputLookup'])[3]");

    public InvoiceCreation(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        } else
            this.driver = driver;
        this.webaction = new WebActions(driver);
        this.wait = new Waits(driver);
        this.s = new ScreenShot(driver);
        this.randam = new RandomUtils();
        this.action = new KeyboardActions(driver);
        account = new OpportunityCreation1(driver);
        order = new OrderActivation(driver);
        dateUtils = new DateUtils();
        excelUtils = new ExcelUtils();
    }

    public WebElement assetnumberInput(String assetNo) {
        String xpath = "//span[normalize-space()='" + assetNo + "']" +
                       "/parent::div/following-sibling::div//lightning-formatted-text";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement invoiceOverrideSelect(String invoiceOverride) {
        String xpath = "//span[@title='" + invoiceOverride + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement assetNumberSelect(String assetNumber) {
        String xpath = "(//a[text()='" + assetNumber + "'])[2]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement billingScheduleSelect(String billingSchedule) {
        String xpath = "//span[@title='" + billingSchedule + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement eqaltoSelect(String eqalto) {
        String xpath = "(//span[@title='" + eqalto + "'])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement invoiceDateTypeSelect(String invoiceDateType) {
        String xpath = "//span[@title='" + invoiceDateType + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement usageStatusSelect(String usageStatus) {
        String xpath = "//span[@title='" + usageStatus + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement productUomSelect(String productUom) {
        String xpath = "//span[@title='" + productUom + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement prodQuntyPick(String product) {
        String xpath = "//div[contains(text(), '" + product + "')]/../..//td[contains(@data-label, 'Quantity')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement prodQuntyUpdate(String product) {
        String xpath = "//div[contains(text(), '" + product + "')]/../..//input";
        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public String invoiceCreation(String sceName,
                                  HashMap<String, String> invoicecreation,
                                  int i,
                                  String filepath,
                                  int statuscol,
                                  int commentcol,
                                  int idcol,
                                  int urlcol) throws IOException {
        List<Boolean> tcResult = new ArrayList<Boolean>();

        boolean tcIsCompleted = false;
        String status = "";
        String comment = "";

        // filepath = System.getProperty("user.dir") +
        // "/ExcelData/HarmonicTestCase1.xlsx";
        sheetName = "Invoice_Creation";
        invSheetName = "Invoice_Validations";
        try {
            this.assetNum1 = invoicecreation.get("Asset Num1");
            this.assetNum2 = invoicecreation.get("Asset Num2");
            this.assetNum3 = invoicecreation.get("Asset Num3");
            this.assetNum4 = invoicecreation.get("Asset Num4");
            this.qnty1 = invoicecreation.get("Qnty1");
            this.qnty2 = invoicecreation.get("Qnty2");
            this.qnty3 = invoicecreation.get("Qnty3");
            this.qnty4 = invoicecreation.get("Qnty4");
            this.usageStatus = invoicecreation.get("Usage Status");
            this.qty = invoicecreation.get("Quantity");
            this.productUom = invoicecreation.get("Product Uom");
            this.invoiceOverrideTemplate = invoicecreation.get("Invoice Override Template");
            this.field = invoicecreation.get("Field");
            this.operator = invoicecreation.get("Operator");
            this.invoiceDataType = invoicecreation.get("Invoice Date Type");
            this.startDate = invoicecreation.get("Start Date");
            this.endDate = invoicecreation.get("End Date");
            this.usageDate = invoicecreation.get("Usage Date");
            this.invoiceruns = invoicecreation.get("Title Name");
            this.processthrudate = invoicecreation.get("Process thru Date");
            this.orderId = invoicecreation.get("OrderId");
            if (sceName.equalsIgnoreCase("invoiceAdjustment") || sceName.equalsIgnoreCase(
                                                                                          "VOS360_PC_invoiceAdjustment") ||
                sceName.equalsIgnoreCase("Multipath_invoiceAdjustment")) {
                this.adjustment = invoicecreation.get("Adjustments");
                this.adjReason = invoicecreation.get("Adjustment Reason");
            }
            if (sceName.equalsIgnoreCase("termDiscountAndMRRDiscount")) {
                this.termDisct = invoicecreation.get("termDiscount");
            }

            Thread.sleep(5000);
            wait.waitUntilElementFound(account.setup, 15);
            wait.waituntilElementIsDisplayedAndClick(account.setup);
            wait.waituntilElementIsDisplayedAndClick(account.setupgear);
            wait.waitForPageLoaded();
            Set<String> windows = webaction.browser().getWindowHandles();
            webaction.browser().switchToWindowHandle((String) windows.toArray()[1]);
            Thread.sleep(5000);
            account.userLogin(ReadPropertyFile.readPropertyFile(file, "SalesOpsUser"));
            wait.waitUntilElementReliableFound(account.userlogout, 20);
            String invurl = ReadPropertyFile.readPropertyFile(file, "OrderUrl") + orderId + "/view";
            webaction.browser().goToUrl(invurl);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            orderNum = wait.waitUntilElementFound(orderNumber, 20).getText();
            System.out.println("ordernum=" + orderNum);
            wait.waitUntilElementFound(quotenumber, 20);
            webaction.browser().scroll().scrollPage("0", "500");
            webaction.element().click().jsClick(quotenumber);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(relatedtab, 20);

            quoteUrl = driver.getCurrentUrl();
            pushHubUsages(filepath);
            wait.waitUntilElementFound(relatedtab, 20);
            priceCalculations(filepath);
            generateInvoice(i, filepath, idcol, urlcol);
            if (sceName.equalsIgnoreCase("invoiceAdjustment") && !adjustment.equals("NA") || sceName.equalsIgnoreCase(
                                                                                                                      "Multipath_invoiceAdjustment") &&
                                                                                             !adjustment.equals("NA") ||
                sceName.equalsIgnoreCase(
                                         "VOS360_PC_invoiceAdjustment") &&
                                                                                                                         !adjustment.equals("NA")) {
                invoiceOverride();
            }
            priceValidations(sceName, filepath, i);
            if (sceName.equalsIgnoreCase("VOS360_Multipath_WithoutDiscounts") || sceName.equalsIgnoreCase(
                                                                                                          "Multipath_Approvals_APACEMEA") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                     "Multipath_partnerIncentive") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentice_MRR_TermDiscounts") || sceName.equalsIgnoreCase(
                                                                                                                     "Multipath_prepay_Term_MRR_Discounts") ||
                sceName.equalsIgnoreCase("Multipath_termDiscountAndMRRDiscount") || sceName.equalsIgnoreCase(
                                                                                                             "Multipath_invoiceAdjustment")) {
                VOS360MultipathValidation(sceName, invoicecreation, i, filepath);
            }
            if (sceName.equalsIgnoreCase("termDiscountAndMRRDiscount") || sceName.equalsIgnoreCase(
                                                                                                   "prepay_Term_MRR_Discounts") ||
                sceName.equalsIgnoreCase("PartnerIncentive_MRR_TermDiscounts") || sceName.equalsIgnoreCase(
                                                                                                           "Approvals_NAMLATAM") ||
                sceName.equalsIgnoreCase(
                                         "Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                           "Multipath_Approvals_APACEMEA") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                     "Multipath_partnerIncentice_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                            "Multipath_termDiscountAndMRRDiscount")) {
                termDiscountsValidations(filepath, i, sceName);
            }
            if (sceName.equalsIgnoreCase("prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                  "VOS360_PC_prepay_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts")) {
                prepayValidations(filepath, i, sceName);
            }
            if (sceName.equalsIgnoreCase("partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                         "partnerIncentice_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "Multipath_partnerIncentice_MRR_TermDiscounts")) {
                partnerIncentiveValidations(filepath, i, sceName);
            }
            status = "Pass";
            comment = "Invoice Created";
            tcIsCompleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = "Fail";
            comment = "Exception Occurred";
            extent.fail("Exception occured in invoice generation",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
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

    public void createUsageInput(String qnty) {
        try {
            String asetNum = wait.waitUntilElementFound(assetNumber, 10).getText();
            System.out.println("asetNum=" + asetNum);
            wait.waituntilElementIsDisplayedAndClick(relatedtab2);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            webaction.browser().scroll().scrollPage("0", "200");
            Thread.sleep(4000);
            webaction.browser().scroll().scrollintoview(newtab);
            webaction.browser().scroll().scrollPage("0", "-200");
            wait.waitUntilElementFound(newtab, 20);
            wait.waituntilElementIsDisplayedAndClick(newtab);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            webaction.browser().scroll().scrollintoview(usageState);
            wait.waituntilElementIsDisplayedAndClick(usageState);
            wait.waituntilElementIsDisplayedAndClick(usageStatusSelect(usageStatus));
            wait.waituntilElementIsDisplayedAndClick(startdate);
            webaction.element().textBox().sendKeys(startdate, dateUtils.currentMnthFstDate());
            wait.waituntilElementIsDisplayedAndClick(productUOM);
            wait.waituntilElementIsDisplayedAndClick(productUomSelect(productUom));
            wait.waituntilElementIsDisplayedAndClick(enddate);
            webaction.element().textBox().sendKeys(enddate, dateUtils.currentMnthLstDate());
            wait.waituntilElementIsDisplayedAndClick(usagedate);
            webaction.element().textBox().sendKeys(usagedate, dateUtils.currentMnthLstDate());
            webaction.browser().scroll().scrollintoview(assetNo);
            wait.waitUntilElementReliableFound(assetNo, 10);
            wait.waituntilElementIsDisplayedAndClick(assetNo);
            wait.waituntilElementwritable(assetNo, asetNum);
            wait.waituntilElementIsDisplayedAndClick(quantity);
            webaction.element().textBox().sendKeys(quantity, qnty);
            webaction.browser().scroll().scrollintoview(save);
            webaction.element().click().by(save);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            webaction.browser().scroll().scrollintoview(inputID);
            webaction.element().click().jsClick(inputID);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.waitUntilElementFound(downInput, 10);
            wait.waituntilElementIsDisplayedAndClick(downInput);
            wait.waituntilElementIsDisplayedAndClick(processUsageInput);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.elementWait(invIframe, 20);
            webaction.browser().switchToFrame(invIframe);
            Thread.sleep(4000);
            try {
                wait.waitUntilElementFound(processButton, 10);
                wait.waituntilElementIsDisplayedAndClick(processButton);
            } catch (Exception e) {
            }
            try {
                webaction.browser().switchToDefault();
            } catch (Exception e) {
                extent.info("Target frame detach" + e.getMessage());
            }
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            try {
                wait.waitForPageLoaded();
            } catch (Exception e) {

            }

            extent.info("Invoice has been Rated",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prodSelect(String assetNum,
                           String filepath,
                           String unitPriceCol,
                           int i,
                           String qnty,
                           String usagPriceCol,
                           String totUsage,
                           String prodType) throws InterruptedException {
        try {
            String orderurl = driver.getCurrentUrl();
            System.out.println("orderurl =" + orderurl);
            wait.waituntilElementIsDisplayedAndClick(filterButton);
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(assetName, 10);
            wait.waituntilElementIsDisplayedAndClick(assetName);
            webaction.element().textBox().clear(assetName);
            wait.waituntilElementwritable(assetName, assetNum);
            wait.waituntilElementIsDisplayedAndClick(apply);
            wait.waitForPageLoaded();
            Thread.sleep(5000);

            wait.waituntilElementIsDisplayedAndClick(assetNumberSelect(assetNum));
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            String asetNum = wait.waitUntilElementFound(assetNumber, 10).getText();
            System.out.println("asetNum=" + asetNum);
            String appProdTyp = wait.waitUntilElementFound(apptusProdType, 10).getText();
            System.out.println("appProdTyp=" + appProdTyp);
            wait.waituntilElementIsDisplayedAndClick(relatedtab2);
            String BSurl = driver.getCurrentUrl();
            webaction.browser().scroll().scrollToElement(inBillingSchedule);
            wait.waituntilElementIsDisplayedAndClick(scheduleId);
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(roundedNetUnitPrice, 10);
            webaction.browser().scroll().scrollToElement(roundedNetUnitPrice);
            String unitPrice = wait.waitUntilElementFound(roundedNetUnitPrice, 10).getText();
            System.out.println("unitPrice for" + assetNum + unitPrice);
            if (appProdTyp.contains("Subscription")) {
                // String[] usagePrc = unitPrice.split(" ");
                // String usagePart1 = usagePrc[1];
                String usgepart = unitPrice.replace(",", "");
                price = Double.parseDouble(usgepart);
            } else if (unitPrice.contains(",")) {
                String usgepart = unitPrice.replace(",", "");
                price = Double.parseDouble(usgepart);
            } else {
                price = Double.parseDouble(unitPrice);
            }
            double qntity = Double.parseDouble(qnty);
            double usagePrice = price * qntity;
            String usePrice = String.valueOf(usagePrice);
            excelUtils.setCellData(sheetName, filepath, unitPriceCol, i, unitPrice);
            excelUtils.setCellData(sheetName, filepath, usagPriceCol, i, usePrice);
            excelUtils.setCellData(sheetName, filepath, prodType, i, appProdTyp);
            excelUtils.setCellData(invSheetName, filepath, totUsage, i, usePrice);
            webaction.browser().goToUrl(BSurl);
            wait.waitForPageLoaded();
            createUsageInput(qnty);
            try {
                webaction.browser().goToUrl(orderurl);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateInvoice(int i, String filepath, int idcol, int urlcol) throws InterruptedException {
        try {
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(proposalnumber, 5);
            // wait.waituntilElementIsDisplayedAndClick(proposalnumber);
            String qutnum = wait.waitUntilElementFound(proposalID, 10).getText();
            System.out.println("qutnum=" + qutnum);
            wait.waitUntilElementFound(searchIcon, 5);
            wait.waituntilElementIsDisplayedAndClick(searchIcon);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(searchInput, 10);
            // wait.waituntilElementIsDisplayedAndClick(searchInput);
            webaction.element().textBox().sendKeys(searchInput, invoiceruns);
            Thread.sleep(5000);
            webaction.element().textBox().sendKeys(searchInput, Keys.ENTER);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            wait.waitUntilElementFound(newButton, 5);
            wait.waituntilElementIsDisplayedAndClick(newButton);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.elementWait(runIframe, 20);
            webaction.browser().switchToFrame(runIframe);
            Thread.sleep(7000);
            wait.waitUntilElementFound(invoiceRunName, 5);
            wait.waituntilElementIsDisplayedAndClick(invoiceRunName);
            webaction.element().textBox().sendKeys(invoiceRunName, qutnum);
            wait.waituntilElementIsDisplayedAndClick(invoiceOverridetemp);
            webaction.browser().scroll().scrollintoview(invoiceOverrideSelect(invoiceOverrideTemplate));
            wait.waituntilElementIsDisplayedAndClick(invoiceOverrideSelect(invoiceOverrideTemplate));
            webaction.browser().scroll().scrollintoview(billingSchedule);
            wait.waituntilElementIsDisplayedAndClick(billingSchedule);
            Thread.sleep(5000);
            wait.waituntilElementIsDisplayedAndClick(none);
            webaction.browser().scroll().scrollintoview(billingScheduleSelect(field));
            wait.waituntilElementIsDisplayedAndClick(billingScheduleSelect(field));
            wait.waituntilElementIsDisplayedAndClick(none1);
            wait.waituntilElementIsDisplayedAndClick(eqaltoSelect(operator));
            wait.waituntilElementIsDisplayedAndClick(textValue);
            webaction.element().textBox().sendKeys(textValue, qutnum);
            webaction.browser().scroll().scrollintoview(invoiceDatetype);
            wait.waituntilElementIsDisplayedAndClick(invoiceDatetype);
            wait.waituntilElementIsDisplayedAndClick(invoiceDateTypeSelect(invoiceDataType));
            wait.waituntilElementIsDisplayedAndClick(processthroDate);
            webaction.element().textBox().sendKeys(processthroDate, dateUtils.currentMnthFstDate());
            webaction.element().click().by(runButton);
            wait.waitForPageLoaded();
            Thread.sleep(20000);
            try {
                webaction.browser().switchToDefault();
            } catch (Exception e) {
                extent.info("Target frame detach" + e.getMessage());
            }
            try {
                wait.waitUntilElementFound(runIframe, 20);
                webaction.browser().switchToFrame(runIframe);
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            try {
                wait.waitUntilElementFound(relatedforinv, 15);
                wait.waituntilElementIsDisplayedAndClick(relatedforinv);
                Thread.sleep(5000);
            } catch (Exception e) {
                webaction.browser().refresh();
                wait.waitForPageLoaded();
                Thread.sleep(20000);
                webaction.browser().switchToFrame(runIframe);
                wait.waitUntilElementFound(relatedforinv, 15);
                wait.waituntilElementIsDisplayedAndClick(relatedforinv);

            }
            try {
                webaction.browser().switchToDefault();
            } catch (Exception e) {
                extent.info("Target frame detach" + e.getMessage());
            }
            try {
                wait.waitUntilElementFound(runIframe, 20);
                webaction.browser().switchToFrame(runIframe);
                webaction.element().click().by(invoiceNumlink);
            } catch (Exception e) {
                webaction.browser().refresh();
                wait.waitForPageLoaded();
                Thread.sleep(20000);
                wait.waitUntilElementFound(runIframe, 20);
                webaction.browser().switchToFrame(runIframe);
                wait.waituntilElementIsDisplayedAndClick(relatedforinv);
                wait.waituntilElementIsDisplayedAndClick(invoiceNumlink);
            }
            try {
                webaction.browser().switchToDefault();
            } catch (Exception e) {
                extent.info("Target frame detach" + e.getMessage());
            }
            wait.waitUntilElementFound(invoiceNumber, 30);
            try {
                webaction.browser().scroll().scrollToBottom();
                try {
                    wait.waituntilElementIsDisplayedAndClick(invoiceNumber);
                } catch (Exception e) {
                    webaction.browser().refresh();
                    wait.waitForPageLoaded();
                    Thread.sleep(20000);
                    webaction.browser().scroll().scrollToBottom();
                    wait.waitUntilElementFound(invoiceNumber, 30);
                    wait.waituntilElementIsDisplayedAndClick(invoiceNumber);
                }
                wait.waitForPageLoaded();
                Thread.sleep(20000);
                String invnumber = wait.waitUntilElementFound(invoiceNO, 10).getText();
                System.out.println("invoicenumber=" + invnumber);
                extent.info("Invoice Number Generated",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("catch statement");
            }
            int index = driver.getCurrentUrl().split("/").length - 2;
            String[] invoice = driver.getCurrentUrl().split("/");
            String invoiceID = invoice[index];
            System.out.println("Invoice= " + invoiceID);
            ExcelUtils.writeData(sheetName, filepath, invoiceID, idcol, i);
            String invoiceurl = driver.getCurrentUrl();
            System.out.println("Invoice URL= " + invoiceurl);
            ExcelUtils.writeData(sheetName, filepath, invoiceurl, urlcol, i);
            extent.info("inoiceurl==" + invoiceurl);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            webaction.browser().switchToDefault();
            Thread.sleep(500);
        }
    }

    public void priceValidations(String sceName, String filepath, int i) {
        try {
            webaction.browser().scroll().scrollintoview(mPProrationCommitment);
            String mpusgamount = wait.waitUntilElementFound(mPTotUsage, 10).getText();
            if (!sceName.contains("VOS360_PC"))
                podusgamount = wait.waitUntilElementFound(pODTotUsage, 10).getText();
            String pmmusgamount = wait.waitUntilElementFound(pMMTotUsage, 10).getText();
            if (!sceName.contains("VOS360_PC"))
                sfusgamount = wait.waitUntilElementFound(sFServiceCharge, 10).getText();
            String[] usage = mpusgamount.split(" ");
            String usagepart = usage[1];
            String usgamtpart = usagepart.replace(",", "");
            double UsageAmount = Double.parseDouble(usgamtpart);
            String[] pmmusage = pmmusgamount.split(" ");
            String pmmusagepart = pmmusage[1];
            String pmmusgamtpart = pmmusagepart.replace(",", "");
            double pmmUsageAmount = Double.parseDouble(pmmusgamtpart);
            if (!sceName.contains("VOS360_PC")) {
                String[] podusage = podusgamount.split(" ");
                String podusagepart = podusage[1];
                String podusgamtpart = podusagepart.replace(",", "");
                podUsageAmount = Double.parseDouble(podusgamtpart);
            }
            System.out.println("MPUsageAmount=" + UsageAmount);
            excelUtils.setCellData(invSheetName, filepath, "Actual Total usage on invoice of MP", i, usgamtpart);
            excelUtils.setCellData(invSheetName, filepath, "Actual Total usage on invoice of PMM", i, pmmusgamount);
            if (!sceName.contains("VOS360_PC")) {
                excelUtils.setCellData(invSheetName, filepath, "Actual Total usage on invoice of POD", i, podusgamount);
                excelUtils.setCellData(invSheetName, filepath, "Total usage on invoice for Sub", i, sfusgamount);
            }
            String mpprocommit = wait.waitUntilElementFound(mPProrationCommitment, 10).getText();
            if (!sceName.contains("VOS360_PC"))
                podprocommit = wait.waitUntilElementFound(pODProrationCommitment, 10).getText();
            String pmmprocommit = wait.waitUntilElementFound(pMMProrationCommitment, 10).getText();
            String[] prcommit = mpprocommit.split(" ");
            String prpart = prcommit[1];
            String prorationpart = prpart.replace(",", "");
            double ProrationCommit = Double.parseDouble(prorationpart);
            System.out.println("MPProrationCommitment=" + ProrationCommit);
            excelUtils.setCellData(invSheetName, filepath, "Prorated commitment(MP)", i, prorationpart);
            excelUtils.setCellData(invSheetName, filepath, "Prorated commitment(PMM)", i, pmmprocommit);
            if (!sceName.contains("VOS360_PC"))
                excelUtils.setCellData(invSheetName, filepath, "Prorated commitment(POD)", i, podprocommit);

            String mpsrvcharge = wait.waitUntilElementFound(mPServiceCharge, 10).getText();
            if (!sceName.contains("VOS360_PC"))
                podsrvcharge = wait.waitUntilElementFound(pODServiceCharge, 10).getText();
            String pmmsrvcharge = wait.waitUntilElementFound(pMMServiceCharge, 10).getText();
            String[] service = mpsrvcharge.split(" ");
            String servicepart = service[1];
            String servicechargepart = servicepart.replace(",", "");
            double ServiceCharge = Double.parseDouble(servicechargepart);
            System.out.println("MPServiceCharge=" + ServiceCharge);
            excelUtils.setCellData(invSheetName, filepath, "Service Charge(MP)", i, servicechargepart);
            excelUtils.setCellData(invSheetName, filepath, "Service Charge(PMM)", i, pmmsrvcharge);
            if (!sceName.contains("VOS360_PC"))
                excelUtils.setCellData(invSheetName, filepath, "Service Charge(POD)", i, podsrvcharge);

            String mpmnthcommit = wait.waitUntilElementFound(mPMonthlyCommitment, 10).getText();
            if (!sceName.contains("VOS360_PC"))
                podmnthcommit = wait.waitUntilElementFound(pODMonthlyCommitment, 10).getText();
            String pmmmnthcommit = wait.waitUntilElementFound(pMMMonthlyCommitment, 10).getText();
            String[] mtcommit = mpmnthcommit.split(" ");
            String mtpart = mtcommit[1];
            String monthlypart = mtpart.replace(",", "");
            double MonthlyCommitment = Double.parseDouble(monthlypart);
            System.out.println("MPMonthlyCommitment=" + MonthlyCommitment);
            excelUtils.setCellData(invSheetName, filepath, "Minimum commitment(MP)", i, monthlypart);
            excelUtils.setCellData(invSheetName, filepath, "Minimum commitment(PMM)", i, pmmmnthcommit);
            if (!sceName.contains("VOS360_PC"))
                excelUtils.setCellData(invSheetName, filepath, "Minimum commitment(POD)", i, podmnthcommit);

            // validationsForPMM(filepath, i);
            if ((ProrationCommit != 0) && (ProrationCommit > UsageAmount)) {
                ServiceCharge = ProrationCommit;
                System.out.println("prorated amount is greaterthan usage amount");
                extent.info("prorated amount is greaterthan usage amount",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } else if ((ProrationCommit != 0) && (UsageAmount > ProrationCommit)) {
                ServiceCharge = UsageAmount;
                System.out.println("usage amount is greaterthan prorated amount");
                extent.info("usage amount is greaterthan prorated amount",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } else {
                if ((ProrationCommit == 0) && (MonthlyCommitment > UsageAmount)) {
                    ServiceCharge = MonthlyCommitment;
                    System.out.println("monthly amount is greaterthan usage amount");
                    extent.info("monthly amount is greaterthan usage amount",
                                MediaEntityBuilder
                                                  .createScreenCaptureFromBase64String(
                                                                                       ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                                  .build());
                } else if ((ProrationCommit == 0) && (UsageAmount > MonthlyCommitment)) {
                    ServiceCharge = UsageAmount;
                    System.out.println("usage amount is greaterthan monthly amount");
                    extent.info("usage amount is greaterthan monthly amount",
                                MediaEntityBuilder
                                                  .createScreenCaptureFromBase64String(
                                                                                       ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                                  .build());
                }
            }
            if (sceName.contains("VOS360_PC")) {
                if (totMPUsageRound == UsageAmount && totPMMUsageRound == pmmUsageAmount) {
                    excelUtils.setCellData("Invoice_Validations", filepath, "Status", i, "Pass");
                    excelUtils.setCellData("Invoice_Validations",
                                           filepath,
                                           "Comments",
                                           i,
                                           "Invoice Validation success");
                } else {
                    excelUtils.setCellData("Invoice_Validations", filepath, "Status", i, "Fail");
                    excelUtils.setCellData("Invoice_Validations", filepath, "Comments", i, "Invoice Validation Fail");
                }
            } else {
                if (totMPUsageRound == UsageAmount && totPMMUsageRound == pmmUsageAmount &&
                    totPCKGUsageRound == podUsageAmount) {
                    excelUtils.setCellData("Invoice_Validations", filepath, "Status", i, "Pass");
                    excelUtils.setCellData("Invoice_Validations",
                                           filepath,
                                           "Comments",
                                           i,
                                           "Invoice Validation success");
                } else {
                    excelUtils.setCellData("Invoice_Validations", filepath, "Status", i, "Fail");
                    excelUtils.setCellData("Invoice_Validations", filepath, "Comments", i, "Invoice Validation Fail");
                }
            }
            if (sceName.equalsIgnoreCase("termDiscountAndMRRDiscount") || sceName.equalsIgnoreCase(
                                                                                                   "prepay_Term_MRR_Discounts") ||
                sceName.equalsIgnoreCase("PartnerIncentive_MRR_TermDiscounts") || sceName.equalsIgnoreCase(
                                                                                                           "Approvals_NAMLATAM") ||
                sceName.equalsIgnoreCase("Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                           "Multipath_Approvals_APACEMEA") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                     "Multipath_partnerIncentice_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                            "Multipath_termDiscountAndMRRDiscount")) {
                webaction.browser().scroll().scrollToElement(applyTermDiscount);
                String ApplyTermDiscount = (wait.waitUntilElementFound(applyTermDiscount, 10).getText());
                System.out.println("Applied Term Discount in Invoice Page=" + ApplyTermDiscount);
                String[] tDiscount = ApplyTermDiscount.split(" ");
                String termDiscount = tDiscount[1];
                String applyTD = termDiscount.replace(",", "");
                AppliedTermDiscount = Double.parseDouble(applyTD);
                totalforthisInvoiceCalculation();
                double ExptotalforthisInvoice = totalSC - AppliedTermDiscount - appliedPartnerIncentiveAmount;
                String totalforInvoice = String.format("%.2f", ExptotalforthisInvoice);
                if (actualTotalForThisInvoice == ExptotalforthisInvoice) {
                    System.out.println("Term Discount has been Applied successfully");
                    excelUtils.setCellData("Invoice_Creation", filepath, "Term Discount Status", i, "Pass");
                } else {
                    System.out.println("Term Discount has not been Applied successfully");
                    excelUtils.setCellData("Invoice_Creation", filepath, "Term Discount Status", i, "Fail");
                }
                excelUtils.setCellData(sheetName, filepath, "Actual Total Invoice Amount", i, totalforInvoiceUI);
                excelUtils.setCellData(sheetName, filepath, "Expected Total Invoice Amount", i, totalforInvoice);
            }
            if (sceName.equalsIgnoreCase("partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                         "partnerIncentice_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                   "Multipath_partnerIncentice_MRR_TermDiscounts")) {
                webaction.browser().scroll().scrollToElement(appliedIncentiveAmt);
                String appliedPartnerIncentive = (wait.waitUntilElementFound(appliedIncentiveAmt, 10).getText());
                System.out.println("Applied Incentive Amount in Invoice page=" + appliedPartnerIncentive);
                String appliedPrtInceAmount = appliedPartnerIncentive.replace(",", "");
                appliedPartnerIncentiveAmount = Double.parseDouble(appliedPrtInceAmount);
                totalforthisInvoiceCalculation();
                double ExptotalforthisInvoice = totalSC - appliedPartnerIncentiveAmount - AppliedTermDiscount;
                String ExptotalforInvoiceAmt = String.format("%.2f", ExptotalforthisInvoice);
                if (actualTotalForThisInvoice == ExptotalforthisInvoice) {
                    System.out.println("Partner Incentive has been Applied successfully");
                    excelUtils.setCellData("Invoice_Creation", filepath, "Partner Incentive Status", i, "Pass");
                } else {
                    System.out.println("Partner Incentive has not been Applied successfully");
                    excelUtils.setCellData("Invoice_Creation", filepath, "Partner Incentive Status", i, "Fail");
                }
                excelUtils.setCellData(sheetName, filepath, "Actual Total Invoice Amount", i, totalforInvoiceUI);
                excelUtils.setCellData(sheetName, filepath, "Expected Total Invoice Amount", i, ExptotalforInvoiceAmt);
            }
            if (sceName.equalsIgnoreCase("prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                  "VOS360_PC_prepay_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts")) {
                webaction.browser().scroll().scrollToElement(prepayCredit);
                String prepaycr = (wait.waitUntilElementFound(prepayCredit, 10).getText());
                System.out.println("Prepay Credit Amount in Invoice Page=" + prepaycr);
                String[] prepaycrd = prepaycr.split(" ");
                String prepayCredit = prepaycrd[1];
                String PrepayCredit = prepayCredit.replace(",", "");
                double appliedPrepayCredit = Double.parseDouble(PrepayCredit);
                totalforthisInvoiceCalculation();
                double ExptotalforthisInvoice = totalSC - appliedPrepayCredit - AppliedTermDiscount;
                String ExptotalforInvoice = String.format("%.2f", ExptotalforthisInvoice);
                double expTotalForThisInv = Double.parseDouble(ExptotalforInvoice);
                if (actualTotalForThisInvoice == expTotalForThisInv) {
                    System.out.println("Term Discount has been Applied successfully");
                    excelUtils.setCellData("Invoice_Creation", filepath, "Prepay Status", i, "Pass");
                } else {
                    System.out.println("Term Discount has not been Applied successfully");
                    excelUtils.setCellData("Invoice_Creation", filepath, "Prepay Status", i, "Fail");
                }
                excelUtils.setCellData(sheetName, filepath, "Actual Total Invoice Amount", i, totalforInvoiceUI);
                excelUtils.setCellData(sheetName, filepath, "Expected Total Invoice Amount", i, ExptotalforInvoice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void priceCalculations(String filepath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filepath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Hub_Usages");
        int productRows = sheet.getPhysicalNumberOfRows();
        int x;
        try {
            wait.waituntilElementIsDisplayedAndClick(relatedtab2);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            webaction.browser().scroll().scrollPage("0", "600");
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            webaction.browser().scroll().scrollToElement(order.orderNumber);
            webaction.browser().scroll().scrollPage("0", "-100");
            wait.waitUntilElementFound(viewallLabel, 20);
            webaction.element().click().jsClick(viewallLabel);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            String orderurl = driver.getCurrentUrl();
            System.out.println("orderurl =" + orderurl);
            for (x = 1; x < productRows; x++) {
                HashMap<String, String> data = excelUtils.readData(filepath,
                                                                   "Hub_Usages",
                                                                   x,
                                                                   3);
                String product = data.get("Sub Product1");
                String productQty = data.get("Sub Product qty1");

                wait.waituntilElementIsDisplayedAndClick(filterButton);
                wait.waitForPageLoaded();
                wait.waitUntilElementFound(assetName, 10);
                wait.waituntilElementIsDisplayedAndClick(assetName);
                webaction.element().textBox().clear(assetName);
                wait.waituntilElementwritable(assetName, product);
                wait.waituntilElementIsDisplayedAndClick(apply);
                wait.waitForPageLoaded();
                Thread.sleep(5000);

                wait.waituntilElementIsDisplayedAndClick(assetNumberSelect(product));
                wait.waitForPageLoaded();
                Thread.sleep(5000);
                String asetNum = wait.waitUntilElementFound(assetNumber, 10).getText();
                System.out.println("asetNum=" + asetNum);
                String appProdTyp = wait.waitUntilElementFound(apptusProdType, 10).getText();
                System.out.println("appProdTyp=" + appProdTyp);
                wait.waituntilElementIsDisplayedAndClick(relatedtab2);
                Thread.sleep(4000);
                wait.waitUntilElementFound(inBillingSchedule, 20);
                webaction.browser().scroll().scrollToElement(inBillingSchedule);
                wait.waituntilElementIsDisplayedAndClick(scheduleId);
                wait.waitForPageLoaded();
                wait.waitUntilElementFound(roundedNetUnitPrice, 10);
                webaction.browser().scroll().scrollToElement(roundedNetUnitPrice);
                String unitPrice = wait.waitUntilElementFound(roundedNetUnitPrice, 10).getText();
                System.out.println("unitPrice for" + product + unitPrice);
                if (appProdTyp.contains("Subscription")) {
                    String usgepart = unitPrice.replace(",", "");
                    price = Double.parseDouble(usgepart);
                } else if (unitPrice.contains(",")) {
                    String usgepart = unitPrice.replace(",", "");
                    price = Double.parseDouble(usgepart);
                } else {
                    price = Double.parseDouble(unitPrice);
                }
                double qntity = Double.parseDouble(productQty);
                double usagePrice = price * qntity;
                String usePrice = String.format("%.2f", usagePrice);
                double dusagePrice = Double.parseDouble(usePrice);
                if (appProdTyp.equalsIgnoreCase("VOS360 License")) {
                    totMPUsage = totMPUsage + dusagePrice;
                } else if (appProdTyp.equalsIgnoreCase("VOS360-PMM")) {
                    totPMMUsage = totPMMUsage + dusagePrice;
                } else if (appProdTyp.equalsIgnoreCase("VOS 360 PC-PMM")) {
                    totPMMUsage = totPMMUsage + dusagePrice;
                } else if (appProdTyp.equalsIgnoreCase("VOS360-LIC-PCKG")) {
                    totPCKGUsage = totPCKGUsage + dusagePrice;
                }
                excelUtils.setCellData("Hub_Usages", filepath, "Rounded Net unit price", x, unitPrice);
                excelUtils.setCellData("Hub_Usages", filepath, "Usage Price", x, usePrice);
                excelUtils.setCellData("Hub_Usages", filepath, "Apptus Product Type", x, appProdTyp);
                webaction.browser().goToUrl(orderurl);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
            }
            String totMPUsageAmt = String.format("%.2f", totMPUsage);
            String totPMMUsageAmt = String.format("%.2f", totPMMUsage);
            String totPCKGUsageAmt = String.format("%.2f", totPCKGUsage);
            totMPUsageRound = Double.parseDouble(totMPUsageAmt);
            totPMMUsageRound = Double.parseDouble(totPMMUsageAmt);
            totPCKGUsageRound = Double.parseDouble(totPCKGUsageAmt);
            excelUtils.setCellData("Invoice_Validations", filepath, "Expected Total usage (MP)", 1, totMPUsageAmt);
            if (!filepath.contains("VOS360_PC"))
                excelUtils.setCellData("Invoice_Validations",
                                       filepath,
                                       "Expected Total usage (POD)",
                                       1,
                                       totPCKGUsageAmt);
            excelUtils.setCellData("Invoice_Validations", filepath, "Expected Total usage (PMM)", 1, totPMMUsageAmt);
        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Exception occured in Price Calculations",
                        MediaEntityBuilder
                                          .createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
        } finally {
            wb.close();
            fis.close();

        }
    }

    public void pushHubUsages(String filepath) {
        try {
            wait.waitUntilElementFound(accountName, 20);
            wait.waituntilElementIsDisplayedAndClick(accountName);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(downInput, 20);
            wait.waituntilElementIsDisplayedAndClick(downInput);
            wait.waituntilElementIsDisplayedAndClick(usageInputs);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.elementWait(order.configureFrame, 20);
            webaction.browser().switchToFrame(order.configureFrame);
            wait.waitUntilElementFound(orderNumInput, 20);
            webaction.element().textBox().sendKeys(orderNumInput, orderNum);
            wait.waituntilElementIsDisplayedAndClick(mnthYear);
            WebElement mnth = driver.findElement(By.xpath("//select[contains(@class, 'datepicker-month')]"));
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");
            Select curr = new Select(mnth);
            String monthformat = dateFormat.format(dateUtils.hubPrevMnthCurrDate());
            curr.selectByVisibleText(monthformat);
            wait.waituntilElementIsDisplayedAndClick(validate);
            Thread.sleep(7000);
            webaction.browser().scroll().scrollPage("0", "300");
            HashMap<String, String> data = excelUtils.readData(filepath,
                                                               "Hub_Usages",
                                                               1,
                                                               3);
            String product = data.get("Sub Product1");
            usageqnty = wait.waitUntilElementFound(prodQuntyPick(product), 20).getText();
            webaction.element().textBox().sendKeys(prodQuntyUpdate(product), usageqnty);
            wait.waituntilElementIsDisplayedAndClick(saveUsage);
            Thread.sleep(7000);
            wait.waituntilElementIsDisplayedAndClick(mnthYear);
            WebElement mnth1 = driver.findElement(By.xpath("//select[contains(@class, 'datepicker-month')]"));
            Select curr1 = new Select(mnth1);
            String monthformat1 = dateFormat.format(dateUtils.hubPrevMnthCurrDate());
            curr1.selectByVisibleText(monthformat1);
            wait.waituntilElementIsDisplayedAndClick(validate);
            Thread.sleep(7000);
            webaction.browser().goToUrl(quoteUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void totalforthisInvoiceCalculation() {
        try {
            String mpsrvcharge = wait.waitUntilElementFound(mPServiceCharge, 10).getText();
            String podsrvcharge = wait.waitUntilElementFound(pODServiceCharge, 10).getText();
            String pmmsrvcharge = wait.waitUntilElementFound(pMMServiceCharge, 10).getText();
            String sfsrvcharge = wait.waitUntilElementFound(sFServiceCharge, 10).getText();
            String[] mpcharge = mpsrvcharge.split(" ");
            String mpscharge = mpcharge[1];
            String mpservicecharge = mpscharge.replace(",", "");
            double mpServiceCharge = Double.parseDouble(mpservicecharge);
            String[] podcharge = podsrvcharge.split(" ");
            String podscharge = podcharge[1];
            String podservicecharge = podscharge.replace(",", "");
            double podServiceCharge = Double.parseDouble(podservicecharge);
            String[] pmmcharge = pmmsrvcharge.split(" ");
            String pmmscharge = pmmcharge[1];
            String pmmservicecharge = pmmscharge.replace(",", "");
            double pmmServiceCharge = Double.parseDouble(pmmservicecharge);
            String[] sfcharge = sfsrvcharge.split(" ");
            String sfscharge = sfcharge[1];
            String sfservicecharge = sfscharge.replace(",", "");
            double sfServiceCharge = Double.parseDouble(sfservicecharge);
            totalSC = mpServiceCharge + podServiceCharge + pmmServiceCharge + sfServiceCharge;
            String totalInvoiceamount = wait.waitUntilElementFound(totalforthisInvoice, 10).getText();
            String[] totalamount = totalInvoiceamount.split(" ");
            String totalinvamount = totalamount[1];
            String totalinvoiceamount = totalinvamount.replace(",", "");
            actualTotalForThisInvoice = Double.parseDouble(totalinvoiceamount);
            totalforInvoiceUI = String.valueOf(actualTotalForThisInvoice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void invoiceOverride() {
        try {
            double beforeInvoiceAdj = invoiceValidation();
            System.out.println("Before invoice adjustment=" + beforeInvoiceAdj);
            extent.info("Before adjustment total invoice",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            wait.waitUntilElementFound(invoiceEdit, 20);
            webaction.browser().scroll().scrollToElement(invoiceEdit);
            webaction.browser().scroll().scrollPage("0", "100");
            wait.waituntilElementIsDisplayedAndClick(invoiceEdit);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            webaction.element().textBox().sendKeys(adjReasn, adjReason);
            webaction.element().textBox().sendKeys(adjustmt, adjustment);
            wait.waituntilElementIsDisplayedAndClick(save);
            wait.waitForPageLoaded();
            Thread.sleep(8000);
            double afterInvoiceAdj = invoiceValidation();
            System.out.println("After invoice adjustment=" + afterInvoiceAdj);
            extent.info("After adjustment total invoice",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            double adjust = Double.parseDouble(adjustment);
            BigDecimal validInvoice = BigDecimal.valueOf(beforeInvoiceAdj).subtract(BigDecimal.valueOf(adjust));
            BigDecimal aftInvAdj = BigDecimal.valueOf(afterInvoiceAdj);
            System.out.println("validInvoice=" + validInvoice);
            if (validInvoice.compareTo(aftInvAdj) == 0) {
                System.out.println("Invoice adjustment validation success");
                extent.pass("Invoice adjustment validation success");
            } else if (validInvoice.compareTo(aftInvAdj) != 0) {
                System.out.println("Invoice adjustment validation fail");
                extent.info("Invoice adjustment validation fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double invoiceValidation() throws IOException {
        wait.waitUntilElementFound(totalInvoice, 20);
        webaction.browser().scroll().scrollToElement(totalInvoice);
        String totInvoice = wait.waitUntilElementFound(totalInvoice, 10).getText();
        String[] invoice = totInvoice.split(" ");
        String invoicepart = invoice[1];
        String totinv = invoicepart.replace(",", "");
        double totInvoiceAmount = Double.parseDouble(totinv);
        return totInvoiceAmount;
    }

    public void termDiscountsValidations(String filepath, int i, String sceName) {
        try {
            String invurl = driver.getCurrentUrl();
            webaction.browser().scroll().scrollToElement(masterWallet);
            wait.waitUntilElementReliableFound(masterWallet, 20);
            webaction.element().click().jsClick(masterWallet);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            webaction.browser().scroll().scrollToElement(totalTermDiscount);
            String totalDiscount = (wait.waitUntilElementFound(totalTermDiscount, 10).getText());
            String totalTD = totalDiscount.replace(",", "");
            System.out.println("Total Term Discount=" + totalTD);
            String appliedDiscount = (wait.waitUntilElementFound(appliedTermDiscount, 10).getText());
            String appliedTD = appliedDiscount.replace(",", "");
            System.out.println("Applied Term Discount=" + appliedTD);
            String applicableDiscount = (wait.waitUntilElementFound(applicableTermDiscount, 10).getText());
            String applicableTD = applicableDiscount.replace(",", "");
            System.out.println("Applicable Term Discount=" + applicableTD);
            String balanceDiscount = (wait.waitUntilElementFound(balanceTermDiscount, 10).getText());
            String balanceTD = balanceDiscount.replace(",", "");
            System.out.println("Balance Term Discount=" + balanceTD);
            double totalTermDiscount = Double.parseDouble(totalTD);
            double appliedTermDiscount = Double.parseDouble(appliedTD);
            double balanceTermDiscountUI = Double.parseDouble(balanceTD);
            double balanceTermDiscount = totalTermDiscount - appliedTermDiscount;
            String balanceTermDiscountvalue = String.valueOf(balanceTermDiscount);
            if (balanceTermDiscountUI == balanceTermDiscount) {
                System.out.println("Term Discount has been Applied successfully");
                extent.info("Term Discount has been Applied successfully",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } else {
                System.out.println("Term Discount has not been Applied successfully");
                extent.error("Term Discount has not been Applied successfully",
                             MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                    ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                               .build());
            }
            excelUtils.setCellData(sheetName, filepath, "Total Term Discount", i, totalTD);
            excelUtils.setCellData(sheetName, filepath, "Applied Term Discount", i, appliedTD);
            excelUtils.setCellData(sheetName, filepath, "Balance Term Discount", i, balanceTermDiscountvalue);
            webaction.browser().goToUrl(invurl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prepayValidations(String filepath, int i, String sceName) {
        try {
            String invurl = driver.getCurrentUrl();
            webaction.browser().scroll().scrollToElement(masterWallet);
            wait.waitUntilElementReliableFound(masterWallet, 20);
            webaction.element().click().jsClick(masterWallet);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            webaction.browser().scroll().scrollToElement(prepayAmount);
            String prepayamount = (wait.waitUntilElementFound(prepayAmount, 10).getText());
            String prepayAmount = prepayamount.replace(",", "");
            System.out.println("Total Prepay Amount=" + prepayAmount);
            String prepaybalanceamt = (wait.waitUntilElementFound(prepaybalance, 10).getText());
            String prepayBalance = prepaybalanceamt.replace(",", "");
            System.out.println("Prepay Balance Amount=" + prepayBalance);
            String prepayusageamt = (wait.waitUntilElementFound(prepayUsage, 10).getText());
            String prepayusage = prepayusageamt.replace(",", "");
            System.out.println("Prepay Usage Amount=" + prepayusage);
            double totalPrepayAmount = Double.parseDouble(prepayAmount);
            double totalPrepayBalanaceUI = Double.parseDouble(prepayBalance);
            double totalPrepayUsage = Double.parseDouble(prepayusage);
            double balancePrepayAmount = totalPrepayAmount - totalPrepayUsage;
            String balancePrepayValue = String.valueOf(balancePrepayAmount);
            if (totalPrepayBalanaceUI == balancePrepayAmount) {
                System.out.println("Prepay Amount has been Applied successfully");
                extent.info("Prepay Amount has been Applied successfully",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } else {
                System.out.println("Prepay Amount has not been Applied successfully");
                extent.error("Prepay Balance has not been Applied successfully",
                             MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                    ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                               .build());
            }
            excelUtils.setCellData(sheetName, filepath, "Total Prepay Amount", i, prepayAmount);
            excelUtils.setCellData(sheetName, filepath, "Prepay Usage Amount", i, prepayusage);
            excelUtils.setCellData(sheetName, filepath, "Prepay Balance Amount", i, balancePrepayValue);
            webaction.browser().goToUrl(invurl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void partnerIncentiveValidations(String filepath, int i, String sceName) {
        try {
            String invurl = driver.getCurrentUrl();
            webaction.browser().scroll().scrollToElement(masterWallet);
            wait.waitUntilElementReliableFound(masterWallet, 20);
            webaction.element().click().jsClick(masterWallet);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            webaction.browser().scroll().scrollToElement(totalPartnerIncentiveAmt);
            String totalIncentiveFunds = (wait.waitUntilElementFound(totalPartnerIncentiveAmt, 10).getText());
            String totalPartnerIncentiveFunds = totalIncentiveFunds.replace(",", "");
            System.out.println("Total Partner Incentive Amount=" + totalPartnerIncentiveFunds);
            String availablePartnerIncentiveamt = (wait.waitUntilElementFound(availableIncentiveAmt, 10).getText());
            String availablePartnerIncentiveAmount = availablePartnerIncentiveamt.replace(",", "");
            System.out.println("Available Partner Incentive Amount=" + availablePartnerIncentiveAmount);
            String applyIncentiveFunds = (wait.waitUntilElementFound(appliedPartnerIncentiveAmt, 10).getText());
            String appliedIncentiveFunds = applyIncentiveFunds.replace(",", "");
            System.out.println("Applied Partner Incentive Amount=" + appliedIncentiveFunds);
            double totalPartnerIncentive = Double.parseDouble(totalPartnerIncentiveFunds);
            double appliedPartnerIncentiveAmt = Double.parseDouble(appliedIncentiveFunds);
            double actualavailablePartnerIncentiveamt = Double.parseDouble(availablePartnerIncentiveAmount);
            double expectedavailablePartnerIncentive = totalPartnerIncentive - appliedPartnerIncentiveAmt;
            String expectedavailablePartnerIncentiveamt = String.valueOf(expectedavailablePartnerIncentive);
            if (actualavailablePartnerIncentiveamt == expectedavailablePartnerIncentive) {
                System.out.println("Partner Incentive Amount has been Applied successfully");
                extent.info("Partner Incentive Amount has been Applied successfully",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } else {
                System.out.println("Partner Incentive Amount has not been Applied successfully");
                extent.error("Partner Incentive Amount has not been Applied successfully",
                             MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                    ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                               .build());
            }
            excelUtils.setCellData(sheetName, filepath, "Total Partner Incentive", i, totalPartnerIncentiveFunds);
            excelUtils.setCellData(sheetName, filepath, "Applied Partner Incentive", i, appliedIncentiveFunds);
            excelUtils.setCellData(sheetName,
                                   filepath,
                                   "Balance Partner Incentive",
                                   i,
                                   expectedavailablePartnerIncentiveamt);
            webaction.browser().goToUrl(invurl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void VOS360MultipathValidation(String sceName,
                                          HashMap<String, String> invoicecreation,
                                          int i,
                                          String filepath) {
        try {

            String cdnProduct = "VOS360-EGRESS-PACKAGING-ORIGIN-CDN";
            String invurl = driver.getCurrentUrl();
            webaction.browser().scroll().scrollToTop();
            wait.waitUntilElementReliableFound(invoiceLines, 10);
            webaction.element().click().jsClick(invoiceLines);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waituntilElementIsDisplayedAndClick(filterButton);
            wait.waitForPageLoaded();
            Thread.sleep(3000);
            wait.waitUntilElementFound(assetLineItem, 10);
            wait.waituntilElementIsDisplayedAndClick(assetLineItem);
            webaction.element().textBox().clear(assetLineItem);
            wait.waituntilElementwritable(assetLineItem, cdnProduct);
            wait.waituntilElementIsDisplayedAndClick(apply);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(invoiceLineNum, 30);
            wait.waituntilElementIsDisplayedAndClick(invoiceLineNum);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            wait.waitUntilElementFound(billingschedule1, 30);
            String invurl1 = driver.getCurrentUrl();
            webaction.element().click().jsClick(billingschedule1);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            webaction.browser().scroll().scrollToElement(committedQty);
            wait.waitUntilElementFound(committedQty, 30);
            String commitqty = (wait.waitUntilElementFound(committedQty, 10).getText());
            String commitedqty = commitqty.replace(",", "");
            System.out.println("Commited Quantity=" + commitedqty);
            double commitedqunatity = Double.parseDouble(commitedqty);
            excelUtils.setCellData(sheetName, filepath, "Committed Qty", i, commitedqty);
            webaction.browser().goToUrl(invurl1);
            webaction.browser().scroll().scrollToElement(multipathTotalValue);
            String totalValue = (wait.waitUntilElementFound(multipathTotalValue, 10).getText());
            String MultipathTotalVal = totalValue.replace(",", "");
            System.out.println("Multipath Total Value=" + MultipathTotalVal);
            double MultipathTotalValue = Double.parseDouble(MultipathTotalVal);
            String totalUsed = (wait.waitUntilElementFound(multipathTotalUsed, 10).getText());
            String MultipathTotalUsed = totalUsed.replace(",", "");
            System.out.println("Multipath Total Used=" + MultipathTotalUsed);
            String balanceValue = (wait.waitUntilElementFound(multipathbalanceValue, 10).getText());
            String MultipathBalanceValue = balanceValue.replace(",", "");
            System.out.println("Multipath Balance Value=" + MultipathBalanceValue);
            double MultiTotalValue = Double.parseDouble(MultipathTotalVal);
            double MultiTotalUsed = Double.parseDouble(MultipathTotalUsed);
            double MultibalanceValueUI = Double.parseDouble(MultipathBalanceValue);
            double MultiBalanceValue = MultiTotalValue - MultiTotalUsed;
            String BalanceValue = String.valueOf(MultiBalanceValue);
            if (MultibalanceValueUI == MultiBalanceValue && MultipathTotalValue == commitedqunatity) {
                System.out.println("Multipath has been Applied successfully");
                excelUtils.setCellData("Invoice_Creation", filepath, "Multipath Status", i, "Pass");
                extent.info("Multipath has been Configured successfully",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } else {
                System.out.println("Multipath has not been Applied successfully");
                excelUtils.setCellData("Invoice_Creation", filepath, "Multipath Status", i, "Fail");
                extent.error("Multipath has not been Configured successfully",
                             MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                    ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                               .build());
            }
            excelUtils.setCellData(sheetName, filepath, "Multipath Total Value", i, MultipathTotalVal);
            excelUtils.setCellData(sheetName, filepath, "Multipath Total Used", i, MultipathTotalUsed);
            excelUtils.setCellData(sheetName, filepath, "Multipath Balance Value", i, BalanceValue);
            webaction.browser().goToUrl(invurl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
