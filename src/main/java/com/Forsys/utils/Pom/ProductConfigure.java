package com.Forsys.utils.Pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.Forsys.utils.ReadPropertyFile;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ProductConfigure {

    private WebDriver driver;
    WebActions webaction;
    Waits wait;
    ScreenShot s;
    RandomUtils randam;
    PomClasses p;
    OpportunityCreation1 account;
    OrderActivation order;
    ExcelUtils excelUtils;
    // String filepath;
    String productSheetName;
    String baseProduct;
    String subProduct1;
    String subProduct2;
    String subProduct3;
    String subProduct4;
    String subProdqnt1;
    String subProdqnt2;
    String subProdqnt3;
    String subProdqnt4;
    String cdnsubProd;
    String cdnsubProdqnt;
    String term;
    String netpriceoverride1;
    String netpriceoverride2;
    String netpriceoverride3;
    String monthlycommitoverride1;
    String monthlycommitoverride2;
    String monthlycommitoverride3;
    String MRRdiscountoverride1;
    String MRRdiscountoverride2;
    String MRRdiscountoverride3;
    String termDiscountAmount;
    String appName;
    String mPMonthlyCommitDiscount;
    String quoteStatus = "Approved";
    String quoteStatus1 = "Finalized";
    String quoteStatus2 = "Generated";
    boolean flag;
    int a;
    ExtentTest extent = ExtentReportListener.extent_test.get();
    String file = System.getProperty("propertyFile");

    By setup = By.xpath("//*[local-name()='svg' and @data-key='setup']");
    By setupgear = By.xpath("//div[starts-with(@class,'popupTargetContainer menu--nubbin-top uiPopupTarget')]//li[1]");
    By searchSetup = By.xpath("//input[@title='Search Setup']");
    By hometab = By.xpath("(//a[@title='Home'])[1]");
    By login = By.xpath("//td[@class='pbButton']//input[@title='Login']");
    By userIframe = By.xpath("//Iframe[starts-with(@name,'vfFrameId')]");

    public WebElement selectUser(String username) {
        String xpath = "(//span[@title='" + username + "']//div)[1]";
        return driver.findElement(By.xpath(xpath));
    }

    By configureProduct = By.xpath(
                                   "//span[contains(text(), 'Configure Product (VOS)')]/parent::div/following-sibling::div//img[@alt='Configure Products']");
    By configureProductforReseller = By.xpath("//span[contains(text(), 'Configure Products')]/parent::div/following-sibling::div//img[@alt='Configure Products']");
    By productSearch = By.xpath("//input[@placeholder='Find Products']");
    By gotoPricing = By.xpath("//button[@class='ands-btn ands-secondary GoToPricing active-true md-button']");
    By configureButton = By.xpath("(//button[@class='ands-btn ands-secondary md-button md-ink-ripple'])[3]");
    By configureFrame = By.xpath("//div[contains(@class,'active lafPageHost')]//iframe[@title='accessibility title']");
    By subProd1 = By
                    .xpath("//span[contains(text(), 'VOS360-ENC-AVC-HD-EXTRA-RES')]/../../div[@class='checkbox-override']");
    By subprod1qty = By.xpath(
                              "(//div[@class='option-content']//dynamic-field[@line-item='ctrl.lineItem']//input[contains(@class,'field--dynamic')])[1]");
    By mouseover = By.xpath("//i[contains(@class, 'fa fa-chevron-down')]");
    By pinned = By.xpath("//i[@class='fa fa-thumb-tack thumb-tack ng-hide']");
    By Personilzation = By.xpath("//md-tab-item[contains(text(), 'Personalization')]");
    By serviceTerms = By.xpath("//md-tab-item[contains(text(), 'Service Terms')]");
    By subprod2 = By.xpath("//span[contains(text(), 'VOS360-SSADI')]/../../div[@class='checkbox-override']");
    By subprod2qty = By.xpath(
                              "(//div[@class='main-configure-product__product-option is--open']//dynamic-field[@line-item='ctrl.lineItem']//input[contains(@class,'field--dynamic field')])[2]");
    By packagingandOrigin = By.xpath("//md-tab-item[contains(text(), 'Packaging, Origin and Delivery')]");
    By subprod3 = By.xpath(
                           "//span[contains(text(), 'VOS360-EGRESS-PACKAGING-ORIGIN-CDN')]/../../div[@class='checkbox-override']");
    By subprod3qty = By.xpath(
                              "(//div[@class='main-configure-product__product-option is--open']//dynamic-field[@line-item='ctrl.lineItem']//input[contains(@class,'field--dynamic field')])[1]");
    By commitment = By.xpath("//md-tab-item[contains(text(), 'Commitment')]");
    By termInput = By.xpath(
                            "(//div[@class='main-configure-product__product-option is--open']//dynamic-field[@line-item='ctrl.lineItem']//input[contains(@class,'field--dynamic field')])[1]");
    By verifybutton = By.xpath("//button[contains(@class, 'primary ValidateBundle')]");
    By pricingbutton = By.xpath("//button[@class='ands-btn ands-secondary GoToPricing active-true md-button']");
    By existingQnty = By.xpath("//div[contains(@class, 'quantity__readonly')]");
    By subprodqty4 = By.xpath(
                              "//input[@class='field--dynamic field-background ng-pristine ng-valid ng-not-empty ng-valid-required ng-touched']");
    By subprod4qty = By.xpath(
                              "(//div[contains(@class,'product-option__quantity')]//dynamic-field[@field-type='QUANTITY']//input[contains(@class,'field--dynamic')])[5]");
    By progressbar = By.xpath("//div[@id='progress-bar-container']");
    By submitforApproval = By.xpath("//button[contains(text(), 'Submit for Approval')]");
    By finalize = By.xpath("//button[contains(text(),'Finalize')]");
    By ok = By.xpath("//button[contains(text(),'OK')]");
    By submitForApproval = By.xpath("//button[contains(text(),'Submit for Approval')]");
    By reprice = By.xpath("//button[contains(text(),'Reprice')]");
    By submit = By.xpath("//div[@class='slds-page-header__control']//input[@type='button' and @value='Submit']");
    By submit2 = By.xpath("//div[@class='slds-page-header__control']//input[@type='submit' and @value='Submit']");
    By Return = By.xpath("//div[@class='slds-page-header__col-actions']//input[@type='submit' and @value='Return']");
    By subprod4qty1 = By.xpath(
                               "(//div[contains(@class,'product-option__quantity')]//dynamic-field[@field-type='QUANTITY']//input[contains(@class,'field--dynamic')])[5]");
    By netPriceOverride = By
                            .xpath("(//span[contains(text(), 'Net Unit Price Override')]/../../../../../../../../../..//input)[9]");
    By netPriceOverride1 = By
                             .xpath("(//span[contains(text(), 'Net Unit Price Override')]/../../../../../../../../../..//input)[3]");
    By MCOverride = By.xpath(
                             "//span[normalize-space(.)='Media Processing']/ancestor::option-group//label[normalize-space(.)='Overwrite Monthly Commit (Net Price)']/../..//input");
    By MCOverrideforPC = By.xpath(
                                  "//span[normalize-space(.)='VOS 360-PC Commit']/ancestor::option-group//label[normalize-space(.)='Overwrite Monthly Commit (Net Price)']/../..//input");
    By MRROverride = By.xpath(
                              "//span[normalize-space(.)='Personalization']/ancestor::option-group//label[normalize-space(.)='Overwrite MRR Discount Rate']/../..//input");
    By Save = By.xpath("//button[contains(text(), 'Save') and @ng-disabled='displayAction.isActionDisabled(action)']");
    By approverName = By.xpath("(//td[contains(@id, 'idStepRequestsTable')])[12]");
    By saveButton = By.xpath("//input[@value='Save' and @type='submit']");
    By returnButton = By.xpath("//input[@type='button' and @value='Return']");
    By approveIframe = By.xpath("//div[contains(@class,'active lafPageHost')]//iframe[@title='accessibility title']");
    By myApprovals = By.xpath("//button[contains(text(), 'My Approvals')]");
    By allApprovals = By.xpath("//a[contains(@aria-controls, 'allApprovalsTab')]");
    By approvalsTab1 = By.xpath("//span/div[3]/div/div[2]/table/tbody/tr");
    By approvalsTab2 = By.xpath("//span/div[4]/div/div[2]/table/tbody/tr");
    By approvalsTab3 = By.xpath("//span/div[5]/div/div[2]/table/tbody/tr");
    By approvalsTab4 = By.xpath("//span/div[6]/div/div[2]/table/tbody/tr");
    By approveButton = By.xpath("//input[@value='Approve' and @type='button']");
    By termCheckBox = By.xpath("//div[@class='md-container']");
    By cartButton = By.xpath("//md-icon[contains(text(), 'shopping_cart')]");
    By broadcastTranscode = By.xpath("//md-tab-item[contains(text(), 'Broadcast Transcode')]");
    By liveAddOn = By.xpath("//md-tab-item[contains(text(), 'Live Add-On')]");
    By storage = By.xpath("//md-tab-item[contains(text(), 'Storage')]");
    By afterSaveButton = By.xpath("//button[contains(@ng-model,'displayAction.primaryAction')]");
    By termInputButton = By
                           .xpath("//span[contains(text(),'TERM-DISCOUNT')]/..//i[contains(@class, 'mini-cart__items')]");
    By termDiscountAmt = By.xpath(
                                  "//div[contains(@class,'container-tooltip')]//dynamic-field[@line-item='ctrl.lineItem']//input[contains(@class,'field--dynamic field')]");
    By myQueueTab = By.xpath("//a[contains(@aria-controls, 'queueApprovalsTab')]");
    By takeOwnershipTab = By.xpath("//input[@value='Take Ownership' and @type='button']");
    By myApprovalsTab = By.xpath("//a[contains(@aria-controls, 'myApprovalsTab')]");
    By sharing = By.xpath("//button[@name='Share' and @type='button']");
    By sharingInput = By.xpath("//input[contains(@class,'default input uiInput')]");
    By optionName = By.xpath("(//span[text()='Line Item Id'])[2]");
    By save = By.xpath("//button[contains(text(), 'Save')]");
    By downButton = By.xpath("//span[@class='select2-arrow ui-select-toggle']");
    By clicktab = By.xpath(
                           "(//span[text()='VOS360-ENC-HEVC-HD-EXTRA-RES']/../../..//span[contains(@class, 'forceOutputCurrency')])[1]");
    By capacityModel = By.xpath("//div[contains(text(), 'Capacity Model')]");
    By relatedtab = By.xpath("//div[contains(@class,'active lafPageHost')]//a[contains(text(),'Related')]");
    By viewAll = By.xpath("//span[contains(text(), 'Line Items')]/../..//span[@class='view-all-label']");
    By defaultMRRDiscountforPMM = By.xpath(
                                           "//span[normalize-space()='Monthly Commit Discount Rate (PMM)']/parent::div/following-sibling::div//lightning-formatted-number");
    By defaultMRRDiscountforMP = By.xpath(
                                          "//span[normalize-space()='Monthly Commit Discount Rate (MP)']/parent::div/following-sibling::div//lightning-formatted-number");
    By defaultMRRDiscountforMP_PC = By.xpath(
                                             "//span[normalize-space()='Monthly Commit Discount Rate MP (PC)']/parent::div/following-sibling::div//lightning-formatted-number");
    By defaultMRRDiscountforPOD = By.xpath(
                                           "//span[normalize-space()='Monthly Commit Discount Rate (Origin)']/parent::div/following-sibling::div//lightning-formatted-number");
    By defaultMRRDiscountforCDN = By.xpath(
                                           "//span[normalize-space()='Monthly Commit Discount Rate (CDN)']/parent::div/following-sibling::div//lightning-formatted-number");
    By cdnCheckbox = By.xpath(
                              "(//div[@class='main-configure-product__product-option is--open']//dynamic-field[@line-item='ctrl.lineItem']//input[contains(@class,'field--dynamic field')])[2]");
    By quotenum = By.xpath("//a[@title='Proposals']/../..//a[contains(text(), 'Q-')]");
    By configurator = By.xpath(
                               "(//span[@title='Configuration Name']/following::a[@class='flex-wrap-ie11 slds-truncate'])[1]");
    By editPage = By.xpath("//span[contains(text(), 'Edit Status')]/../../..//button");
    By approvalStatus = By.xpath("//button[contains(@aria-label,'Approval Status')]");
    By status = By.xpath("(//button[contains(@aria-label,'Status')])[2]");
    By savebutton = By.xpath("//button[@name='SaveEdit' and @type='button']");
    By quoteNumber = By.xpath("(//span[text()='Quote/Proposal']/../..//span[contains(text(), 'Q-')])[1]");
    By quoteEdit = By.xpath("//span[contains(text(), 'Edit Approval Stage')]/../../..//button");
    By approvalStage = By.xpath("//button[contains(@aria-label,'Approval Stage')]");

    public WebElement selectPerson(String personName) {
        String xpath = "//div[@title='" + personName + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectStatus(String status) {
        String xpath = "//span[@title='" + status + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectStatus1(String status1) {
        String xpath = "//span[@title='" + status1 + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selListPrc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'forceOutputCurrency')])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selSecListPrc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'forceOutputCurrency')])[4]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selNetUnitPrc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'forceOutputCurrency')])[2]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selSecNetUnitPrc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'forceOutputCurrency')])[5]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selPartnerDisc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'uiOutputPercent')])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selSecPartnerDisc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'uiOutputPercent')])[2]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selQunty(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'uiOutputNumber')])[2]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selSecQunty(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'uiOutputNumber')])[5]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selRNUPrice(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'uiOutputNumber')])[3]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selSecRNUPrice(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'uiOutputNumber')])[6]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selExtNetPrc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'forceOutputCurrency')])[3]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selSecExtNetPrc(String product) {
        String xpath = "(//span[text()='" + product + "']/../../..//span[contains(@class, 'forceOutputCurrency')])[6]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement selectBucket(String bucketName) {
        String xpath = "//md-tab-item[contains(text(), '" + bucketName + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement configureSelect(String baseProduct) {
        String xpath = "//a[text()='" + baseProduct + "']/../../../..//button[contains(text(), 'Configure')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement subproductSelect(String subProduct) {
        String xpath = "//span[contains(text(), '" + subProduct + "')]/../../div[@class='checkbox-override']";
        return driver.findElement(By.xpath(xpath));
    }

    public ProductConfigure(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        } else
            this.driver = driver;
        this.webaction = new WebActions(driver);
        this.wait = new Waits(driver);
        this.s = new ScreenShot(driver);
        this.randam = new RandomUtils();
        account = new OpportunityCreation1(driver);
        order = new OrderActivation(driver);
        excelUtils = new ExcelUtils();
    }

    public void clickonConfigureProductButton() {
        webaction.browser().scroll().scrollPage("0", "200");
//        webaction.browser().scroll().scrollToElement(configureProduct);
        try {
            try {
                wait.waitUntilElementFound(configureProduct, 5);
                wait.waituntilElementIsDisplayedAndClick(configureProduct);
                wait.waitUntilElementDisappear(configureProduct, 30);
            } catch (Exception e) {
            wait.waitUntilElementFound(configureProductforReseller, 5);
            wait.waituntilElementIsDisplayedAndClick(configureProductforReseller);
            wait.waitUntilElementDisappear(configureProductforReseller, 30);
            Thread.sleep(7000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void configBaseproduct(HashMap<String, String> configureproduct) {
        try {
            String baseProduct = configureproduct.get("Base Product");
            clickonConfigureProductButton();
            wait.waitForPageLoaded();
            Thread.sleep(20000);
            wait.elementWait(configureFrame, 20);
            try {
                webaction.browser().switchToFrame(configureFrame);
                Thread.sleep(5000);
            } catch (Exception e) {

            }

            for (int i = 0; i < 3; i++) {
                try {
                    wait.elementWait(gotoPricing, 15);
                    wait.waitUntilElementFound(productSearch, 180);
                    wait.waituntilElementIsDisplayedAndClick(productSearch);
                    webaction.element().textBox().sendKeys(productSearch, baseProduct);
                    webaction.element().textBox().sendKeys(productSearch, Keys.ENTER);
                    break;
                } catch (Exception e) {
                    webaction.browser().refresh();
                    wait.waitForPageLoaded();
                    Thread.sleep(15000);
                    wait.elementWait(gotoPricing, 15);
                    webaction.browser().switchToFrame(configureFrame);
                    continue;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            extent.log(Status.INFO, "Not able to added base product to the cart");
            extent.log(Status.FAIL, e.getMessage());
        }
    }

    public void monthlyCommitOverride() {
        try {
            // webaction.browser().scroll().scrollPage("0", "200");
            webaction.browser().scroll().scrollToElement(MCOverride);
            webaction.browser().scroll().scrollPage("0", "100");
            wait.waitUntilElementFound(MCOverride, 30);
            wait.waituntilElementIsDisplayedAndClick(MCOverride);
            webaction.element().textBox().sendKeys(MCOverride, monthlycommitoverride1);
            extent.info("Monthly commit override",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            wait.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void monthlyCommitOverrideforPC() {
        try {
            // webaction.browser().scroll().scrollPage("0", "200");
            webaction.browser().scroll().scrollToElement(MCOverrideforPC);
            webaction.browser().scroll().scrollPage("0", "100");
            wait.waitUntilElementFound(MCOverrideforPC, 30);
            wait.waituntilElementIsDisplayedAndClick(MCOverrideforPC);
            webaction.element().textBox().sendKeys(MCOverrideforPC, monthlycommitoverride1);
            extent.info("Monthly commit override",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            wait.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void MRRDiscountOverride() {
        try {
            webaction.browser().scroll().scrollToTop();
            webaction.browser().scroll().scrollToElement(MRROverride);
            webaction.browser().scroll().scrollPage("0", "100");
            wait.waitUntilElementFound(MRROverride, 30);
            wait.waituntilElementIsDisplayedAndClick(MRROverride);
            webaction.element().textBox().sendKeys(MRROverride, MRRdiscountoverride1);
            extent.info("MRR discount override",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(verifybutton, 5);
            wait.waituntilElementIsDisplayedAndClick(verifybutton);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void netPriceOverride() {
        try {
            By netPriceOverride = By
                                    .xpath("(//span[contains(text(), 'Net Unit Price Override')]/../../../../../../../../../..//input)[10]");
            extent.info("Values of Before Net Price Override",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            wait.waitUntilElementFound(netPriceOverride, 30);
            wait.waituntilElementIsDisplayedAndClick(netPriceOverride);
            webaction.element().textBox().sendKeys(netPriceOverride, netpriceoverride1);
            wait.waituntilElementIsDisplayedAndClick(netPriceOverride1);
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(reprice, 30);
            wait.waituntilElementIsDisplayedAndClick(reprice);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.waitUntilElementDisappear(progressbar, 30);
            extent.info("Values of After Net Price Override",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void subscriptionPartsSelect() {
        try {
            try {
                webaction.browser().scroll().scrollToElement(mouseover);
                Thread.sleep(3000);
                wait.waitUntilElementReliableFound(serviceTerms, 5);
                wait.waituntilElementIsDisplayedAndClick(serviceTerms);
            } catch (Exception e) {
                wait.waituntilElementIsDisplayedAndClick(mouseover);
                Thread.sleep(3000);
                wait.waitUntilElementReliableFound(serviceTerms, 5);
                wait.waituntilElementIsDisplayedAndClick(serviceTerms);
            }
            // webaction.browser().scroll().scrollToBottom();
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(subprod4qty1, 10);
            webaction.browser().scroll().scrollToTop();
            Thread.sleep(3000);
            webaction.browser().scroll().scrollToElement(subprod4qty1);
            webaction.browser().scroll().scrollPage("0", "100");
            wait.waituntilElementIsDisplayedAndClick(subproductSelect(subProduct4));
            wait.waituntilElementIsDisplayedAndClick(subprod4qty1);
            webaction.element().textBox().clear(subprod4qty1);
            webaction.element().textBox().sendKeys(subprod4qty1, subProdqnt4);
            extent.info("Added subscription part",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            wait.waitForPageLoaded();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void approvalRequest(String sceName) throws IOException {
        try {

            List<String> approvalList = approvalFlow();
            int approversNum = approvalList.size();
            System.out.println("Approvers size & Aprrovers ==" + approversNum + approvalList);
            String quoteurl = driver.getCurrentUrl();
            for (int x = 0; x < approversNum; x++) {
                String approver = approvalList.get(x);
                if (approver.equalsIgnoreCase("EDD VOS") || approver.equalsIgnoreCase("EDD") || approver
                                                                                                        .equalsIgnoreCase("Partner Incentive Queue")) {
                    approverQueue(approver);
                } else {
                    if (sceName.equalsIgnoreCase("Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                   "VOS360_PC_Approvals_NAMLATAM") ||
                        sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM")) {
                        quoteShare(approver);
                    }
                    if (!sceName.equalsIgnoreCase("Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                                    "VOS360_PC_Approvals_APACEMEA") ||
                        sceName.equalsIgnoreCase("Multipath_Approvals_APACEMEA")) {
                        webaction.browser().refresh();
                        wait.waitForPageLoaded();
                        Thread.sleep(5000);
                        wait.waitUntilElementFound(account.userlogout, 30);
                    }
                    wait.waituntilElementIsDisplayedAndClick(account.userlogout);
                    account.userLogin(approver);
                    wait.waitUntilElementReliableFound(account.userlogout, 20);
                    webaction.browser().goToUrl(quoteurl);
                    wait.waitForPageLoaded();
                    Thread.sleep(20000);
                    wait.waitUntilElementFound(myApprovals, 30);
                    wait.waituntilElementIsDisplayedAndClick(myApprovals);
                    wait.waitForPageLoaded();
                    Thread.sleep(20000);
                }
                wait.elementWait(approveIframe, 20);
                webaction.browser().switchToFrame(approveIframe);
                wait.waitUntilElementFound(approveButton, 20);
                wait.waituntilElementIsDisplayedAndClick(approveButton);
                wait.waitForPageLoaded();
                Thread.sleep(10000);
                wait.waitUntilElementFound(saveButton, 20);
                wait.waituntilElementIsDisplayedAndClick(saveButton);
                wait.waitForPageLoaded();
                Thread.sleep(10000);
                webaction.browser().switchToDefault();
                wait.waitForPageLoaded();
                wait.elementWait(approveIframe, 20);
                webaction.browser().switchToFrame(approveIframe);
                wait.waitUntilElementFound(returnButton, 20);
                wait.waituntilElementIsDisplayedAndClick(returnButton);
                wait.waitForPageLoaded();
                webaction.browser().switchToDefault();
                Thread.sleep(10000);
            }
            String quoteurl1 = driver.getCurrentUrl();
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(account.userlogout, 30);
            wait.waituntilElementIsDisplayedAndClick(account.userlogout);
            if (sceName.equalsIgnoreCase("Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                           "VOS360_PC_Approvals_NAMLATAM") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM")) {
                account.userLogin(ReadPropertyFile.readPropertyFile(file, "NAMLATAMSalesPerson"));
            } else if (sceName.equalsIgnoreCase("Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                                  "VOS360_PC_Approvals_APACEMEA") ||
                       sceName.equalsIgnoreCase("Multipath_Approvals_APACEMEA")) {
                account.userLogin(ReadPropertyFile.readPropertyFile(file, "APACEMEASalesPerson"));
            } else {
                account.userLogin(ReadPropertyFile.readPropertyFile(file, "SalesPerson"));
            }
            wait.waitUntilElementReliableFound(account.userlogout, 20);
            webaction.browser().goToUrl(quoteurl1);
        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Approvals page got exception",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
        } finally {
            webaction.browser().switchToDefault();
        }
    }

    public List<String> approvalFlow() throws IOException {
        List<String> approvList = new ArrayList<String>();
        try {
            Thread.sleep(5000);
            wait.waitUntilElementFound(myApprovals, 30);
            try {
                wait.waituntilElementIsDisplayedAndClick(myApprovals);
            } catch (Exception e) {
                webaction.browser().refresh();
                wait.waitForPageLoaded();
                Thread.sleep(10000);
                wait.waitUntilElementFound(account.userlogout, 30);
                wait.waitUntilElementFound(myApprovals, 30);
                wait.waituntilElementIsDisplayedAndClick(myApprovals);
            }
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.elementWait(approveIframe, 20);
            webaction.browser().switchToFrame(approveIframe);
            wait.waitUntilElementFound(allApprovals, 20);
            wait.waituntilElementIsDisplayedAndClick(allApprovals);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            wait.waitUntilElementFound(approvalsTab1, 20);
            List<WebElement> appList1 = driver.findElements(approvalsTab1);
            int approvaltab1size = appList1.size();
            System.out.println("Approval table1 size ==" + approvaltab1size);
            for (int k = 0; k < approvaltab1size; k++) {
                try {
                    WebElement status = driver.findElement(By.xpath("(//span/div[3]/div/div[2]/table/tbody/tr[" + (k +
                                                                                                                   1) +
                                                                    "]//td[contains(@id, 'idMyApprovalsPage')])[6]"));
                    String appStatus = status.getText();
                    System.out.println("Approval status ==" + appStatus);
                    if (appStatus.contains("Assigned") || appStatus.contains("Not Submitted")) {
                        WebElement approvalName = driver.findElement(By.xpath(
                                                                              "(//span/div[3]/div/div[2]/table/tbody/tr[" +
                                                                              (k + 1) +
                                                                              "]//td[contains(@id, 'idMyApprovalsPage')])[7]"));
                        String approver1 = approvalName.getText();
                        approvList.add(a++, approver1);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            List<WebElement> appList2 = driver.findElements(approvalsTab2);
            int approvaltab2size = appList2.size();
            System.out.println("Approval table2 size ==" + approvaltab2size);
            for (int l = 0; l < approvaltab2size; l++) {
                try {
                    WebElement status1 = driver.findElement(By.xpath("(//span/div[4]/div/div[2]/table/tbody/tr[" + (l +
                                                                                                                    1) +
                                                                     "]//td[contains(@id, 'idMyApprovalsPage')])[6]"));
                    String appStatus1 = status1.getText();
                    System.out.println("Approval status ==" + appStatus1);
                    if (appStatus1.contains("Assigned") || appStatus1.contains("Not Submitted")) {
                        WebElement approvalName = driver
                                                        .findElement(By.xpath("(//span/div[4]/div/div[2]/table/tbody/tr[" +
                                                                              (l + 1) +
                                                                              "]//td[contains(@id, 'idMyApprovalsPage')])[7]"));
                        String approver1 = approvalName.getText();
                        approvList.add(a++, approver1);
                    }
                } catch (Exception e) {
                    continue;
                }
            }

            List<WebElement> appList3 = driver.findElements(approvalsTab3);
            int approvaltab3size = appList3.size();
            System.out.println("Approval table3 size ==" + approvaltab3size);
            for (int x = 0; x < approvaltab3size; x++) {
                try {
                    WebElement status2 = driver.findElement(By.xpath("(//span/div[5]/div/div[2]/table/tbody/tr[" + (x +
                                                                                                                    1) +
                                                                     "]//td[contains(@id, 'idMyApprovalsPage')])[6]"));
                    String appStatus2 = status2.getText();
                    System.out.println("Approval status ==" + appStatus2);
                    if (appStatus2.contains("Assigned") || appStatus2.contains("Not Submitted")) {
                        WebElement approvalName = driver
                                                        .findElement(By.xpath("(//span/div[5]/div/div[2]/table/tbody/tr[" +
                                                                              (x + 1) +
                                                                              "]//td[contains(@id, 'idMyApprovalsPage')])[7]"));
                        String approver2 = approvalName.getText();
                        approvList.add(a++, approver2);
                    }
                } catch (Exception e) {
                    continue;
                }
            }

            List<WebElement> appList4 = driver.findElements(approvalsTab4);
            int approvaltab4size = appList4.size();
            System.out.println("Approval table3 size ==" + approvaltab4size);
            for (int x = 0; x < approvaltab4size; x++) {
                try {
                    WebElement status3 = driver.findElement(By.xpath("(//span/div[6]/div/div[2]/table/tbody/tr[" + (x +
                                                                                                                    1) +
                                                                     "]//td[contains(@id, 'idMyApprovalsPage')])[6]"));
                    String appStatus3 = status3.getText();
                    System.out.println("Approval status ==" + appStatus3);
                    if (appStatus3.contains("Assigned") || appStatus3.contains("Not Submitted")) {
                        WebElement approvalName = driver
                                                        .findElement(By.xpath("(//span/div[6]/div/div[2]/table/tbody/tr[" +
                                                                              (x + 1) +
                                                                              "]//td[contains(@id, 'idMyApprovalsPage')])[7]"));
                        String approver3 = approvalName.getText();
                        approvList.add(a++, approver3);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
            wait.waitUntilElementFound(returnButton, 20);
            wait.waituntilElementIsDisplayedAndClick(returnButton);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Approval List not able to get",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());

        } finally {
            webaction.browser().switchToDefault();
        }
        return approvList;
    }

    public void approverQueue(String apprQueue) {
        try {
            Thread.sleep(10000);
            String quoteurl = driver.getCurrentUrl();
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(account.userlogout, 30);
            wait.waituntilElementIsDisplayedAndClick(account.userlogout);
            if (apprQueue.equalsIgnoreCase("EDD VOS") || apprQueue.equalsIgnoreCase("EDD")) {
                account.userLogin(ReadPropertyFile.readPropertyFile(file, "EDDQueue"));
            } else if (apprQueue.equalsIgnoreCase("Partner Incentive Queue")) {
                account.userLogin(ReadPropertyFile.readPropertyFile(file, "PartnerQueue"));
            }
            wait.waitUntilElementReliableFound(account.userlogout, 20);
            webaction.browser().goToUrl(quoteurl);
            wait.waitForPageLoaded();
            Thread.sleep(20000);
            wait.waitUntilElementReliableFound(myApprovals, 20);
            wait.waituntilElementIsDisplayedAndClick(myApprovals);
            wait.waitForPageLoaded();
            Thread.sleep(20000);
            wait.elementWait(approveIframe, 20);
            webaction.browser().switchToFrame(approveIframe);
            wait.waituntilElementIsDisplayedAndClick(myQueueTab);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            wait.waituntilElementIsDisplayedAndClick(takeOwnershipTab);
            wait.waitForPageLoaded();
            Thread.sleep(7000);
            wait.waituntilElementIsDisplayedAndClick(myApprovalsTab);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            webaction.browser().switchToDefault();
        }
    }

    public void quoteShare(String ApproverName) throws IOException {
        try {
            Thread.sleep(7000);
            wait.waitUntilElementReliableFound(sharing, 20);
            wait.waituntilElementIsDisplayedAndClick(sharing);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.waitUntilElementFound(sharingInput, 20);
            wait.waituntilElementIsDisplayedAndClick(sharingInput);
            wait.waitForPageLoaded();
            Thread.sleep(4000);
            webaction.element().textBox().sendKeys(sharingInput, ApproverName);
            Thread.sleep(5000);
            wait.waituntilElementIsDisplayedAndClick(selectPerson(ApproverName));
            wait.waitUntilElementFound(save, 20);
            wait.waituntilElementIsDisplayedAndClick(save);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void termDiscount() {
        try {
            webaction.browser().scroll().scrollToElement(termCheckBox);
            wait.waitUntilElementFound(termCheckBox, 5);
            webaction.browser().scroll().scrollPage("0", "-100");
            try {
                wait.waituntilElementIsDisplayedAndClick(termCheckBox);
            } catch (Exception e) {
                webaction.browser().scroll().scrollPage("0", "180");
                wait.waituntilElementIsDisplayedAndClick(termCheckBox);
            }
            wait.waitUntilElementFound(verifybutton, 5);
            wait.waituntilElementIsDisplayedAndClick(verifybutton);
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(cartButton, 30);
            wait.waituntilElementIsDisplayedAndClick(cartButton);
            wait.waitUntilElementFound(termInputButton, 10);
            wait.waituntilElementIsDisplayedAndClick(termInputButton);
            wait.waitUntilElementFound(termDiscountAmt, 10);
            Thread.sleep(5000);
            wait.waituntilElementIsDisplayedAndClick(termDiscountAmt);
            webaction.element().textBox().sendKeys(termDiscountAmt, termDiscountAmount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String saveAndApproveCart(String sceName,
                                     int i,
                                     String filepath,
                                     int statuscol,
                                     int commentcol) throws IOException {
        List<Boolean> tcResult = new ArrayList<Boolean>();
        boolean tcIsCompleted = false;
        String status = "";
        String comment = "";
        try {
            try {
                webaction.browser().scroll().scrollToElement(mouseover);
                Thread.sleep(3000);
                wait.waitUntilElementReliableFound(commitment, 5);
                wait.waituntilElementIsDisplayedAndClick(commitment);
            } catch (Exception e) {
                webaction.browser().scroll().scrollToTop();
                wait.waituntilElementIsDisplayedAndClick(mouseover);
                Thread.sleep(3000);
                wait.waitUntilElementReliableFound(commitment, 5);
                wait.waituntilElementIsDisplayedAndClick(commitment);
            }
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(gotoPricing, 30);
            webaction.browser().scroll().scrollToTop();
            webaction.browser().scroll().scrollToElement(termInput);
            try {
                wait.waituntilElementIsDisplayedAndClick(termInput);
            } catch (Exception e) {
                webaction.browser().scroll().scrollPage("0", "180");
                wait.waituntilElementIsDisplayedAndClick(termInput);
            }
            webaction.element().textBox().clear(termInput);
            webaction.element().textBox().sendKeys(termInput, term);
            wait.waitUntilElementFound(verifybutton, 5);
            wait.waituntilElementIsDisplayedAndClick(verifybutton);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            if (sceName.equalsIgnoreCase("netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd") || sceName
                                                                                                                     .equalsIgnoreCase("Multipath_netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd")) {
                monthlyCommitOverride();
            }
            if (sceName.equalsIgnoreCase("netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd") || sceName
                                                                                                                     .equalsIgnoreCase("termDiscountAndMRRDiscount") ||
                sceName.equalsIgnoreCase("prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                  "PartnerIncentive_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("VOS360_PC_netprice_MRRdiscount_MonthlycommitOverride") || sceName
                                                                                                           .equalsIgnoreCase("VOS360_PC_MRRDiscount") ||
                sceName.equalsIgnoreCase("VOS360_PC_prepay_MRRDiscounts") || sceName.equalsIgnoreCase(
                                                                                                      "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd") ||
                sceName.equalsIgnoreCase("Multipath_partnerIncentice_MRR_TermDiscounts") || sceName.equalsIgnoreCase(
                                                                                                                     "Multipath_prepay_Term_MRR_Discounts") ||
                sceName.equalsIgnoreCase("Multipath_termDiscountAndMRRDiscount")) {
                MRRDiscountOverride();
            }
            if (sceName.equalsIgnoreCase("VOS360_PC_netprice_MRRdiscount_MonthlycommitOverride")) {
                monthlyCommitOverrideforPC();
            }
            if (sceName.equalsIgnoreCase("termDiscountAndMRRDiscount") || sceName.equalsIgnoreCase(
                                                                                                   "prepay_Term_MRR_Discounts") ||
                sceName.equalsIgnoreCase("PartnerIncentive_MRR_TermDiscounts") || sceName.equalsIgnoreCase(
                                                                                                           "Approvals_APACEMEA") ||
                sceName.equalsIgnoreCase(
                                         "Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                           "Multipath_Approvals_APACEMEA") ||
                sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                     "Multipath_partnerIncentice_MRR_TermDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                            "Multipath_termDiscountAndMRRDiscount")) {
                termDiscount();
            }
            wait.waitUntilElementFound(pricingbutton, 60);
            wait.waituntilElementIsDisplayedAndClick(pricingbutton);
            wait.waitForPageLoaded();
            wait.waitUntilElementDisappear(progressbar, 30);
            if (sceName.equalsIgnoreCase("VOS360_PC_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                     "VOS360_PC_Approvals_APACEMEA")) {
                netPriceOverride();
            }
            try {
                String button;
                wait.waitUntilElementFound(Save, 5);
                wait.waituntilElementIsDisplayedAndClick(Save);
                wait.waitForPageLoaded();
                Thread.sleep(20000);
                wait.waitUntilElementDisappear(progressbar, 10);
                wait.waitUntilElementFound(Save, 30);
                try {
                    webaction.browser().switchToDefault();
                    Thread.sleep(10000);
                    button = wait.waitUntilElementFound(afterSaveButton, 5).getText();
                    System.out.println("button==" + button);
                } catch (Exception e) {
                    Thread.sleep(5000);
                    webaction.browser().switchToFrame(configureFrame);
                    button = wait.waitUntilElementFound(afterSaveButton, 5).getText();
                    System.out.println("button==" + button);
                }
                if (button.equalsIgnoreCase("Submit for Approval")) {
                    try {
                        wait.waitUntilElementFound(submitForApproval, 20);
                        wait.waituntilElementIsDisplayedAndClick(submitForApproval);
                        wait.waitUntilElementDisappear(submitForApproval, 30);
                        wait.waitUntilElementFound(submitForApproval, 20);
                        wait.waituntilElementIsDisplayedAndClick(submitForApproval);
                        wait.waitUntilElementDisappear(submitForApproval, 30);
                        wait.waitUntilElementFound(submitForApproval, 20);
                        wait.waituntilElementIsDisplayedAndClick(submitForApproval);
                        wait.waitUntilElementDisappear(submitForApproval, 30);
                    } catch (Exception e) {
                        System.out.println("Submit for approval not exists");
                    }
                    wait.waitForPageLoaded();
                    wait.waitUntilElementFound(reprice, 5);
                    try {
                        webaction.browser().switchToDefault();
                        wait.waituntilElementIsDisplayedAndClick(reprice);
                    } catch (Exception e) {
                        webaction.browser().switchToFrame(configureFrame);
                        wait.waituntilElementIsDisplayedAndClick(reprice);
                    }
                }
                    else if (button.equalsIgnoreCase("Reprice")) {
                        Thread.sleep(7000); 
                        try {
                            webaction.browser().switchToDefault();
                            wait.waituntilElementIsDisplayedAndClick(reprice);
                        }
                        catch(Exception e) {
                        try {
                            webaction.browser().switchToFrame(configureFrame);
                            wait.waitUntilElementFound(reprice, 20);
                            wait.waituntilElementIsDisplayedAndClick(reprice);
                            wait.waitUntilElementDisappear(reprice, 30);
                            wait.waitUntilElementFound(reprice, 20);
                            wait.waituntilElementIsDisplayedAndClick(reprice);
                            wait.waitUntilElementDisappear(reprice, 30);
                            wait.waitUntilElementFound(reprice, 20);
                            wait.waituntilElementIsDisplayedAndClick(reprice);
                            wait.waitUntilElementDisappear(reprice, 30);
                        } catch (Exception e1) {
                            System.out.println("Reprice not exists");
                        }
                        } 
                    }
                wait.waitForPageLoaded();
                Thread.sleep(10000);
                wait.waitUntilElementDisappear(progressbar, 30);
                wait.waitUntilElementFound(submitForApproval, 60);
            } catch (Exception e) {
                System.out.println("Save catch block");
            }
            try {
                wait.waitUntilElementFound(submitForApproval, 20);
                wait.waituntilElementIsDisplayedAndClick(submitForApproval);
                wait.waitUntilElementDisappear(submitForApproval, 30);
                wait.waitUntilElementFound(submitForApproval, 20);
                // wait.waituntilElementIsDisplayedAndClick(submitForApproval);
                // wait.waitUntilElementDisappear(submitForApproval, 30);
                // wait.waitUntilElementFound(submitForApproval, 20);
                // wait.waituntilElementIsDisplayedAndClick(submitForApproval);
                // wait.waitUntilElementDisappear(submitForApproval, 30);
            } catch (Exception e) {
            }
            wait.waitForPageLoaded();
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            // wait.elementWait(configureFrame, 10);
            webaction.browser().switchToFrame(configureFrame);
            wait.waitUntilElementFound(submit, 30);
            // try {
            // appName = wait.waitUntilElementFound(approverName, 10).getText();
            // System.out.println("Approver Name=" + appName);
            // if (!appName.equals("")) {
            // flag = true;
            // }
            // } catch (Exception e) {
            // flag = false;
            // }
            wait.waituntilElementIsDisplayedAndClick(submit);
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(15000);
            wait.waitUntilElementReliableFound(configureFrame, 10);
            webaction.browser().switchToFrame(configureFrame);
            wait.waitUntilElementFound(submit2, 30);
            wait.waituntilElementIsDisplayedAndClick(submit2);
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(15000);
            wait.waitUntilElementReliableFound(configureFrame, 10);
            webaction.browser().switchToFrame(configureFrame);
            wait.waitUntilElementFound(Return, 30);
            wait.waituntilElementIsDisplayedAndClick(Return);
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(15000);
            cartValidation(filepath);
            approvalStatus();
            // if (flag) {
            // approvalRequest(sceName);
            // }
            status = "Pass";
            comment = "Products are Configured Successfully";
            tcIsCompleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = "Fail";
            comment = "Exception Occured";
            extent.info("Exception occured in ConfigureProduct",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
            tcResult.add(false);
        } finally {

            excelUtils.setCellData("Configure_Products ", filepath, "Comments", i - 1, comment);
        }
        String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
        return exeStatus;
    }

    public void cartValidation(String filepath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filepath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Configure_Products ");
        int productRows = sheet.getPhysicalNumberOfRows();
        try {
            int x;
            String listPrc;
            String netUnitPrc;
            String partnerDisc;
            String qntyity;
            String rnuPrice;
            String extNetPrice;
            double expNetPrice;
            double qnty;
            String extendNetPrice;
            double extendedPrice;
            wait.waitUntilElementFound(relatedtab, 10);
            if (filepath.contains("VOS360_PC")) {
                mPMonthlyCommitDiscount = wait.waitUntilElementFound(defaultMRRDiscountforMP_PC, 5).getText();
                System.out.println("mPMonthlyCommitDiscount==" + mPMonthlyCommitDiscount);
            } else {
                mPMonthlyCommitDiscount = wait.waitUntilElementFound(defaultMRRDiscountforMP, 5).getText();
                System.out.println("mPMonthlyCommitDiscount==" + mPMonthlyCommitDiscount);
            }
            String pMMMonthlyCommitDiscount = wait.waitUntilElementFound(defaultMRRDiscountforPMM, 5).getText();
            System.out.println("pMMMonthlyCommitDiscount==" + pMMMonthlyCommitDiscount);
            String podMonthlyCommitDiscount = wait.waitUntilElementFound(defaultMRRDiscountforPOD, 5).getText();
            System.out.println("podMonthlyCommitDiscount==" + podMonthlyCommitDiscount);
            String cdnMonthlyCommitDiscount = wait.waitUntilElementFound(defaultMRRDiscountforCDN, 5).getText();
            System.out.println("cdnMonthlyCommitDiscount==" + cdnMonthlyCommitDiscount);
            webaction.browser().scroll().scrollToTop();
            wait.waituntilElementIsDisplayedAndClick(relatedtab);
            wait.waitUntilElementFound(viewAll, 60);
            webaction.browser().scroll().scrollToElement(viewAll);
            webaction.element().click().jsClick(viewAll);
            Thread.sleep(5000);
            for (x = 1; x < productRows; x++) {
                try {
                    HashMap<String, String> data = excelUtils.readData(filepath,
                                                                       "Configure_Products ",
                                                                       x,
                                                                       3);
                    String product = data.get("Sub Product1");
                    String bucket = data.get("Bucket");
                    try {
                        listPrc = wait.waitUntilElementFound(selListPrc(product), 5).getText();
                        System.out.println("listPrice==" + listPrc);
                        netUnitPrc = wait.waitUntilElementFound(selNetUnitPrc(product), 5).getText();
                        System.out.println("netUnitPrice==" + netUnitPrc);
                        String nUntPrc = netUnitPrc.replace("USD ", "");
                        double nUPrice = Double.parseDouble(nUntPrc);
                        if (nUPrice == 0.00) {
                            listPrc = wait.waitUntilElementFound(selSecListPrc(product), 15).getText();
                            System.out.println("SeclistPrice==" + listPrc);
                            netUnitPrc = wait.waitUntilElementFound(selSecNetUnitPrc(product), 5).getText();
                            System.out.println("SecnetUnitPrice==" + netUnitPrc);
                            partnerDisc = wait.waitUntilElementFound(selSecPartnerDisc(product), 5).getText();
                            System.out.println("SecpartnerDisc==" + partnerDisc);
                            qntyity = wait.waitUntilElementFound(selSecQunty(product), 5).getText();
                            System.out.println("Secqntyity==" + qntyity);
                            rnuPrice = wait.waitUntilElementFound(selSecRNUPrice(product), 5).getText();
                            System.out.println("SecrnuPrice==" + rnuPrice);
                            extNetPrice = wait.waitUntilElementFound(selSecExtNetPrc(product), 5).getText();
                            System.out.println("SecextNetPrice==" + extNetPrice);
                        } else {
                            partnerDisc = wait.waitUntilElementFound(selPartnerDisc(product), 5).getText();
                            System.out.println("partnerDisc==" + partnerDisc);
                            qntyity = wait.waitUntilElementFound(selQunty(product), 5).getText();
                            System.out.println("qntyity==" + qntyity);
                            rnuPrice = wait.waitUntilElementFound(selRNUPrice(product), 5).getText();
                            System.out.println("rnuPrice==" + rnuPrice);
                            extNetPrice = wait.waitUntilElementFound(selExtNetPrc(product), 5).getText();
                            System.out.println("extNetPrice==" + extNetPrice);
                        }
                    } catch (Exception e) {
                        Thread.sleep(3000);
                        webaction.element().click().jsClick(optionName);
                        wait.waitForPageLoaded();
                        Thread.sleep(7000);
                        listPrc = wait.waitUntilElementFound(selListPrc(product), 15).getText();
                        System.out.println("listPrice==" + listPrc);
                        netUnitPrc = wait.waitUntilElementFound(selNetUnitPrc(product), 5).getText();
                        System.out.println("netUnitPrice==" + netUnitPrc);
                        String nUntPrc = netUnitPrc.replace("USD ", "");
                        double nUPrice = Double.parseDouble(nUntPrc);
                        if (nUPrice == 0.00) {
                            listPrc = wait.waitUntilElementFound(selSecListPrc(product), 15).getText();
                            System.out.println("SeclistPrice==" + listPrc);
                            netUnitPrc = wait.waitUntilElementFound(selSecNetUnitPrc(product), 5).getText();
                            System.out.println("SecnetUnitPrice==" + netUnitPrc);
                            partnerDisc = wait.waitUntilElementFound(selSecPartnerDisc(product), 5).getText();
                            System.out.println("SecpartnerDisc==" + partnerDisc);
                            qntyity = wait.waitUntilElementFound(selSecQunty(product), 5).getText();
                            System.out.println("Secqntyity==" + qntyity);
                            rnuPrice = wait.waitUntilElementFound(selSecRNUPrice(product), 5).getText();
                            System.out.println("SecrnuPrice==" + rnuPrice);
                            extNetPrice = wait.waitUntilElementFound(selSecExtNetPrc(product), 5).getText();
                            System.out.println("SecextNetPrice==" + extNetPrice);
                        } else {
                            partnerDisc = wait.waitUntilElementFound(selPartnerDisc(product), 5).getText();
                            System.out.println("partnerDisc==" + partnerDisc);
                            qntyity = wait.waitUntilElementFound(selQunty(product), 5).getText();
                            System.out.println("qntyity==" + qntyity);
                            rnuPrice = wait.waitUntilElementFound(selRNUPrice(product), 5).getText();
                            System.out.println("rnuPrice==" + rnuPrice);
                            extNetPrice = wait.waitUntilElementFound(selExtNetPrc(product), 5).getText();
                            System.out.println("extNetPrice==" + extNetPrice);
                        }
                    }
                    String lstPrc = listPrc.replace("USD ", "");
                    double lPrice = Double.parseDouble(lstPrc);
                    String netUntPrc = netUnitPrc.replace("USD ", "");
                    double nUnitPrice = Double.parseDouble(netUntPrc);
                    if (qntyity.contains(",")) {
                        String quntit = qntyity.replace(",", "");
                        qnty = Double.parseDouble(quntit);
                    } else
                        qnty = Double.parseDouble(qntyity);
                    double roundedPrice = Double.parseDouble(rnuPrice);
                    String extendedNetPrice = extNetPrice.replace("USD ", "");
                    if (extendedNetPrice.contains(",")) {
                        extendNetPrice = extendedNetPrice.replace(",", "");
                        extendedPrice = Double.parseDouble(extendNetPrice);
                    } else
                        extendedPrice = Double.parseDouble(extendedNetPrice);
                    if (bucket.equalsIgnoreCase("Media Processing")) {
                        excelUtils.setCellData("Configure_Products ",
                                               filepath,
                                               "Monthly Commit Discount Rate",
                                               x,
                                               mPMonthlyCommitDiscount);
                        if (!mPMonthlyCommitDiscount.equals("")) {
                            String mrrDisc = mPMonthlyCommitDiscount.replace("%", "");
                            String partDsc = partnerDisc.replace("%", "");
                            double mrrDiscount = Double.parseDouble(mrrDisc);
                            double partnerDiscount = Double.parseDouble(partDsc);
                            double partDisExpNetUnitPrice = lPrice * (1 - (mrrDiscount / 100));
                            double expNetUnitPrice = partDisExpNetUnitPrice * (1 - (partnerDiscount / 100));
                            String expNetUnitPrc = String.format("%.2f", expNetUnitPrice);
                            double dexpNetUnitPrc = Double.parseDouble(expNetUnitPrc);
                            excelUtils.setCellData("Configure_Products ",
                                                   filepath,
                                                   "Expected Net Unit Price",
                                                   x,
                                                   expNetUnitPrc);
                            if (nUnitPrice == dexpNetUnitPrc)
                                excelUtils.setCellData("Configure_Products ", filepath, "Unit Price Status", x, "Pass");
                            else
                                excelUtils.setCellData("Configure_Products ", filepath, "Unit Price Status", x, "Fail");
                        }
                    } else if (bucket.equalsIgnoreCase("Personalization")) {
                        excelUtils.setCellData("Configure_Products ",
                                               filepath,
                                               "Monthly Commit Discount Rate",
                                               x,
                                               pMMMonthlyCommitDiscount);
                        if (!pMMMonthlyCommitDiscount.equals("")) {
                            String mrrDisc = pMMMonthlyCommitDiscount.replace("%", "");
                            String partDsc = partnerDisc.replace("%", "");
                            double mrrDiscount = Double.parseDouble(mrrDisc);
                            double partnerDiscount = Double.parseDouble(partDsc);
                            double partDisExpNetUnitPrice = lPrice * (1 - (mrrDiscount / 100));
                            double expNetUnitPrice = partDisExpNetUnitPrice * (1 - (partnerDiscount / 100));
                            String expNetUnitPrc = String.format("%.2f", expNetUnitPrice);
                            double dexpNetUnitPrc = Double.parseDouble(expNetUnitPrc);
                            excelUtils.setCellData("Configure_Products ",
                                                   filepath,
                                                   "Expected Net Unit Price",
                                                   x,
                                                   expNetUnitPrc);
                            if (nUnitPrice == dexpNetUnitPrc)
                                excelUtils.setCellData("Configure_Products ", filepath, "Unit Price Status", x, "Pass");
                            else
                                excelUtils.setCellData("Configure_Products ", filepath, "Unit Price Status", x, "Fail");
                        }
                    } else if (bucket.equalsIgnoreCase("Packaging, Origin and Delivery")) {
                        if (product.equalsIgnoreCase("VOS360-EGRESS-PACKAGING-ORIGIN-NET") || product.equalsIgnoreCase(
                                                                                                                       "VOS360-EGRESS-PACKAGING-ORIGIN-CDN")) {
                            excelUtils.setCellData("Configure_Products ",
                                                   filepath,
                                                   "Monthly Commit Discount Rate",
                                                   x,
                                                   cdnMonthlyCommitDiscount);
                            if (!cdnMonthlyCommitDiscount.equals("")) {
                                String mrrDisc = cdnMonthlyCommitDiscount.replace("%", "");
                                String partDsc = partnerDisc.replace("%", "");
                                double mrrDiscount = Double.parseDouble(mrrDisc);
                                double partnerDiscount = Double.parseDouble(partDsc);
                                double partDisExpNetUnitPrice = lPrice * (1 - (mrrDiscount / 100));
                                double expNetUnitPrice = partDisExpNetUnitPrice * (1 - (partnerDiscount / 100));
                                String expNetUnitPrc = String.format("%.2f", expNetUnitPrice);
                                double dexpNetUnitPrc = Double.parseDouble(expNetUnitPrc);
                                excelUtils.setCellData("Configure_Products ",
                                                       filepath,
                                                       "Expected Net Unit Price",
                                                       x,
                                                       expNetUnitPrc);
                                if (nUnitPrice == dexpNetUnitPrc)
                                    excelUtils.setCellData("Configure_Products ",
                                                           filepath,
                                                           "Unit Price Status",
                                                           x,
                                                           "Pass");
                                else
                                    excelUtils.setCellData("Configure_Products ",
                                                           filepath,
                                                           "Unit Price Status",
                                                           x,
                                                           "Fail");
                            }
                        } else {
                            excelUtils.setCellData("Configure_Products ",
                                                   filepath,
                                                   "Monthly Commit Discount Rate",
                                                   x,
                                                   podMonthlyCommitDiscount);

                            if (!podMonthlyCommitDiscount.equals("")) {
                                String mrrDisc = podMonthlyCommitDiscount.replace("%", "");
                                String partDsc = partnerDisc.replace("%", "");
                                double mrrDiscount = Double.parseDouble(mrrDisc);
                                double partnerDiscount = Double.parseDouble(partDsc);
                                double partDisExpNetUnitPrice = lPrice * (1 - (mrrDiscount / 100));
                                double expNetUnitPrice = partDisExpNetUnitPrice * (1 - (partnerDiscount / 100));
                                String expNetUnitPrc = String.format("%.2f", expNetUnitPrice);
                                double dexpNetUnitPrc = Double.parseDouble(expNetUnitPrc);
                                excelUtils.setCellData("Configure_Products ",
                                                       filepath,
                                                       "Expected Net Unit Price",
                                                       x,
                                                       expNetUnitPrc);
                                if (nUnitPrice == dexpNetUnitPrc)
                                    excelUtils.setCellData("Configure_Products ",
                                                           filepath,
                                                           "Unit Price Status",
                                                           x,
                                                           "Pass");
                                else
                                    excelUtils.setCellData("Configure_Products ",
                                                           filepath,
                                                           "Unit Price Status",
                                                           x,
                                                           "Fail");
                            }
                        }
                    } else if (bucket.equalsIgnoreCase("Subscription")) {
                        String partDsc = partnerDisc.replace("%", "");
                        double partnerDiscount = Double.parseDouble(partDsc);
                        double expNetUnitPrice = lPrice * (1 - (partnerDiscount / 100));
                        String expNetUnitPrc = String.format("%.2f", expNetUnitPrice);
                        double dexpNetUnitPrc = Double.parseDouble(expNetUnitPrc);
                        excelUtils.setCellData("Configure_Products ",
                                               filepath,
                                               "Expected Net Unit Price",
                                               x,
                                               expNetUnitPrc);
                        if (nUnitPrice == dexpNetUnitPrc)
                            excelUtils.setCellData("Configure_Products ", filepath, "Unit Price Status", x, "Pass");
                        else
                            excelUtils.setCellData("Configure_Products ", filepath, "Unit Price Status", x, "Fail");

                    }
                    excelUtils.setCellData("Configure_Products ", filepath, "List Price", x, listPrc);
                    excelUtils.setCellData("Configure_Products ", filepath, "Net Unit Price", x, netUnitPrc);
                    excelUtils.setCellData("Configure_Products ", filepath, "Partner Discount", x, partnerDisc);
                    excelUtils.setCellData("Configure_Products ", filepath, "App Quantity", x, qntyity);
                    excelUtils.setCellData("Configure_Products ", filepath, "Rounded Net Unit Price", x, rnuPrice);
                    excelUtils.setCellData("Configure_Products ", filepath, "Extended Net Price", x, extNetPrice);
                    expNetPrice = qnty * roundedPrice * 12;
                    String expNetPrc = String.format("%.2f", expNetPrice);
                    double dexpNetPrice = Double.parseDouble(expNetPrc);
                    excelUtils.setCellData("Configure_Products ", filepath, "Expected Net Price", x, expNetPrc);
                    if (dexpNetPrice == extendedPrice)
                        excelUtils.setCellData("Configure_Products ", filepath, "Net Price Status", x, "Pass");
                    else
                        excelUtils.setCellData("Configure_Products ", filepath, "Net Price Status", x, "Fail");
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            wait.waituntilElementIsDisplayedAndClick(quotenum);
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wb.close();
            fis.close();
        }
    }

    public String productconfiguration(String sceName,
                                       HashMap<String, String> configureproduct,
                                       int i,
                                       String filepath,
                                       int statuscol,
                                       int commentcol) throws InterruptedException, IOException {
        List<Boolean> tcResult = new ArrayList<Boolean>();
        boolean tcIsCompleted = false;
        String status = "";
        String comment = "";

        productSheetName = "Configure_Products ";
        this.baseProduct = configureproduct.get("Base Product");
        this.subProduct1 = configureproduct.get("Sub Product1");
        this.subProdqnt1 = configureproduct.get("Sub Product qty1");
        this.term = configureproduct.get("Term Input");
        if (sceName.equalsIgnoreCase("netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd") || sceName
                                                                                                                 .equalsIgnoreCase("VOS360_PC_netprice_MRRdiscount_MonthlycommitOverride") ||
            sceName.equalsIgnoreCase("VOS360_PC_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                 "VOS360_PC_Approvals_APACEMEA") ||
            sceName.equalsIgnoreCase("Multipath_netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd")) {
            this.netpriceoverride1 = configureproduct.get("Net Price Override1");
            this.monthlycommitoverride1 = configureproduct.get("Monthly Commit Override1");
            this.MRRdiscountoverride1 = configureproduct.get("MRR Discount Override1");
        }
        if (sceName.equalsIgnoreCase("termDiscountAndMRRDiscount") || sceName.equalsIgnoreCase(
                                                                                               "prepay_Term_MRR_Discounts") ||
            sceName.equalsIgnoreCase("PartnerIncentive_MRR_TermDiscounts") || sceName.equalsIgnoreCase(
                                                                                                       "Approvals_NAMLATAM") ||
            sceName.equalsIgnoreCase("Approvals_APACEMEA") || sceName.equalsIgnoreCase(
                                                                                       "VOS360_PC_netprice_MRRdiscount_MonthlycommitOverride") ||
            sceName.equalsIgnoreCase("VOS360_PC_MRRDiscount") || sceName.equalsIgnoreCase(
                                                                                          "VOS360_PC_prepay_MRRDiscounts") ||
            sceName.equalsIgnoreCase("VOS360_PC_partnerIncentice_MRRDiscounts") || sceName.equalsIgnoreCase(
                                                                                                            "Multipath_Approvals_APACEMEA") ||
            sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                 "Multipath_netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd") ||
            sceName.equalsIgnoreCase("Multipath_partnerIncentice_MRR_TermDiscounts") || sceName.equalsIgnoreCase(
                                                                                                                 "Multipath_prepay_Term_MRR_Discounts") ||
            sceName.equalsIgnoreCase("Multipath_termDiscountAndMRRDiscount")) {
            this.termDiscountAmount = configureproduct.get("Term Discount Amount");
            this.MRRdiscountoverride1 = configureproduct.get("MRR Discount Override1");
        }
        if (sceName.equalsIgnoreCase("VOS360_Multipath")) {
            this.cdnsubProd = configureproduct.get("CDN Sub Product");
            this.cdnsubProdqnt = configureproduct.get("CDN Sub Product Qnt");
        }

        try {
            if (baseProduct.contains("VOS 360")) {
                webaction.browser().scroll().scrollPage("0", "2800");
                configBaseproduct(configureproduct);
                wait.elementWait(gotoPricing, 30);
                wait.waitForPageLoaded();
                Thread.sleep(20000);
                wait.waitUntilElementFound(gotoPricing, 30);
                webaction.browser().scroll().scrollToElement(configureSelect(baseProduct));
                wait.waituntilElementIsDisplayedAndClick(configureSelect(baseProduct));
                wait.waitForPageLoaded();
                Thread.sleep(30000);
                wait.waitUntilElementFound(mouseover, 15);
            }

            if (!baseProduct.contains("VOS 360")) {
                try {
                    webaction.browser().scroll().scrollToElement(mouseover);
                    wait.waituntilElementIsDisplayedAndClick(selectBucket(baseProduct));
                } catch (Exception e) {
                    wait.waituntilElementIsDisplayedAndClick(mouseover);
                    wait.waituntilElementIsDisplayedAndClick(selectBucket(baseProduct));
                }
            }
            wait.waitUntilElementTobeDisplayed(gotoPricing, 30);
            webaction.browser().scroll().scrollToTop();
            Thread.sleep(5000);
            if (subProduct1.equalsIgnoreCase("VOS360-EGRESS-PACKAGING-ORIGIN-CDN")) {
                webaction.browser().scroll().scrollPage("0", "500");
                wait.waituntilElementIsDisplayedAndClick(downButton);
                wait.waituntilElementIsDisplayedAndClick(capacityModel);
                webaction.browser().scroll().scrollPage("0", "200");
                wait.waitForPageLoaded();
            }
            try {
                wait.waituntilElementIsDisplayedAndClick(subproductSelect(subProduct1));
            } catch (Exception e) {
                webaction.browser().scroll().scrollPage("0", "200");
                Thread.sleep(4000);
                wait.waituntilElementIsDisplayedAndClick(subproductSelect(subProduct1));
            }
            String qnty = wait.waitUntilElementFound(existingQnty, 5).getText();
            if (qnty.equalsIgnoreCase("1") || qnty.equalsIgnoreCase("0")) {
                webaction.element().textBox().sendKeys(subprod1qty, subProdqnt1);
            } else if (subProduct1.equalsIgnoreCase("VOS360-CUSTOMIZE")) {
                webaction.browser().scroll().scrollToBottom();
                webaction.element().textBox().clear(subprod4qty1);
                webaction.element().textBox().sendKeys(subprod4qty1, subProdqnt1);
                extent.info("Customize Product qnty update",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            } else {
                webaction.element().textBox().sendKeys(subprod2qty, subProdqnt1);
            }
            wait.waitForPageLoaded();
            wait.waitUntilElementFound(gotoPricing, 30);
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Exception occured in ConfigureProduct",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
        }
        String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
        return exeStatus;
    }

    public void approvalStatus() throws IOException {
        try {
            String quoteurl2 = driver.getCurrentUrl();
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(account.userlogout, 30);
            wait.waituntilElementIsDisplayedAndClick(account.userlogout);
            account.userLogin(ReadPropertyFile.readPropertyFile(file, "AdminUser"));
            wait.waitUntilElementReliableFound(account.userlogout, 20);
            webaction.browser().goToUrl(quoteurl2);
            wait.waitUntilElementFound(relatedtab, 30);
            wait.waituntilElementIsDisplayedAndClick(relatedtab);
            wait.waitUntilElementFound(configurator, 60);
            webaction.element().click().jsClick(configurator);
            Thread.sleep(7000);
            wait.waitUntilElementFound(editPage, 60);
            wait.waituntilElementIsDisplayedAndClick(editPage);
            wait.waituntilElementIsDisplayedAndClick(approvalStatus);
            wait.waituntilElementIsDisplayedAndClick(selectStatus(quoteStatus));
            wait.waituntilElementIsDisplayedAndClick(status);
            wait.waituntilElementIsDisplayedAndClick(selectStatus1(quoteStatus1));
            wait.waituntilElementIsDisplayedAndClick(savebutton);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waituntilElementIsDisplayedAndClick(quoteNumber);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            webaction.browser().scroll().scrollToElement(quoteEdit);
            wait.waituntilElementIsDisplayedAndClick(quoteEdit);
            Thread.sleep(3000);
            webaction.element().click().jsClick(approvalStage);
            wait.waituntilElementIsDisplayedAndClick(selectStatus(quoteStatus2));
            wait.waituntilElementIsDisplayedAndClick(savebutton);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
