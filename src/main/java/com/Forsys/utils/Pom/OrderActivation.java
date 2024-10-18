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
import com.Forsys.utils.DateUtils;
import com.Forsys.utils.ExcelUtils;
import com.Forsys.utils.RandomUtils;
import com.Forsys.utils.ReadPropertyFile;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class OrderActivation {

    private WebDriver driver;
    WebActions webaction;
    Waits wait;
    ScreenShot s;
    RandomUtils randam;
    PomClasses p;
    OpportunityCreation1 account;
    QuoteCreation1 quote;
    ExcelUtils excelUtils;
    DateUtils dateUtils;
    String orderSheetName;
    String invoiceSheetName;
    // String filepath;
    String sheetName;
    String oracleOpportunityType;
    String POnumber;
    String shippingTerms;
    String salesOrdernunber;
    String oracleBillto;
    String oracleShipto;
    String paymentTerms;
    String freightTerms;
    String readyforFullfillementdate;
    boolean flag;
    int a;
    ExtentTest extent = ExtentReportListener.extent_test.get();
    String file = System.getProperty("propertyFile");
    By userlogout = By.xpath("//a[@class='action-link']");
    By generateButton = By
                          .xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//img[@alt='Generate']");
    By previewbutton = By.xpath(
                                "//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//img[@alt='Preview version']");
    By quoteGenerateFrame = By
                              .xpath("//div[contains(@class,'windowViewMode-normal')]//iframe[@allowfullscreen='true']");
    // By quoteRadioButton = By.xpath("//tr[@class='dataRow
    // odd']//td[contains(@class,'dataCell')]/span/input");
    By quoteGenerateButton = By.xpath("//div[@class='pbBottomButtons']//input[@value='Generate']");
    By quoteSuccessfullFrame = By.xpath("//div[@class='iframe-parent slds-template_iframe slds-card']/iframe");
    By quoteSuccessfullReturn = By.xpath("//input[@value='Return']");
    By logoutUser = By.xpath("//a[@class='action-link']");
    By createOrder = By
                       .xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//img[@alt='Create Order']");
    By presentButton = By
                         .xpath("//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//img[@alt='Present']");
    By relatedtab = By.xpath("//a[@data-label='Related']");
    By viewAll = By.xpath("(//span[contains(text(), 'View All')])[2]");
    By editButton = By.xpath("//button[@title='Edit Oracle Opportunity Type']");
    By oracleOpportunityTypeInput = By.xpath("//label[text()='Oracle Opportunity Type']/..//button");
    By POnumberInput = By.xpath("//label[text()='PO Number']/../..//input");
    By paymentTermInput = By.xpath("(//label[text()='Payment Terms']/..//button)[2]");
    By freightTermsInput = By.xpath("//label[text()='Freight Terms']/..//button");
    By shippingTermInput = By.xpath("//label[text()='Shipping terms (FOB)']/..//button");
    By fullfillmentDateInput = By.xpath("(//input[@name='Apttus_Config2__FulfilledDate__c'])[1]");
    By salesOrderNoInput = By.xpath("//label[text()='Sales Order No']/../..//input");
    By Save = By.xpath("//button[@name='SaveEdit']");
    By activateOrder = By.xpath(
                                "//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//img[@alt='Activate Order']");
    By viewLable = By.xpath("(//span[@class='view-all-label'])[1]");
    By configuration = By.xpath("//span[@title='Configurations']");
    By oracleBillToSearch = By.xpath("//label[contains(text(),'Oracle Bill To')]/..//input");
    By oracleShipToSearch = By.xpath("//label[contains(text(),'Oracle Ship To')]/..//input");
    By billtoSelection = By.xpath("//a[@data-recordid='0017000000QyyINAAZ']");
    By approverName = By.xpath("//span/div[2]/div/div[2]/table/tbody/tr[1]//td[5]");
    By previewButton = By.xpath(
                                "//lightning-formatted-rich-text[@class='slds-rich-text-editor__output']//img[@alt='Preview & Submit Approvals']");
    By configureFrame = By.xpath("//div[contains(@class,'active lafPageHost')]//iframe[@title='accessibility title']");
    By submit = By.xpath("//div[@class='slds-page-header__control']//input[@type='button' and @value='Submit']");
    By submit2 = By.xpath("//div[@class='slds-page-header__control']//input[@type='submit' and @value='Submit']");
    By Return = By.xpath("//div[@class='slds-page-header__col-actions']//input[@type='submit' and @value='Return']");
    By quoteRadioButton1 = By
                             .xpath("//span[text()= 'VOS360 Template - MRR']/../..//td[contains(@class,'dataCell')]/span/input");
    By quoteRadioButtonforPC = By
                                 .xpath("//span[text()= 'VOS 360 PC Template - MRR']/../..//td[contains(@class,'dataCell')]/span/input");
    By quoteRadioButtonforMultipath = By.xpath(
                                               "//span[text()= 'VOS 360 Delivery Capacity Template - MRR']/../..//td[contains(@class,'dataCell')]/span/input");
    By approvalStage = By.xpath(
                                "//span[normalize-space()='Approval Stage']/parent::div/following-sibling::div//lightning-formatted-text");
    By orderStatus = By
                       .xpath("//span[normalize-space()='Status']/parent::div/following-sibling::div//lightning-formatted-text");
    By activateStatus = By.xpath(
                                 "//span[normalize-space()='Activate status']/parent::div/following-sibling::div//lightning-formatted-text");
    By orderNumber = By.xpath("(//span[@title='Order Number']/following::a[@class='flex-wrap-ie11 slds-truncate'])[1]");
    By saveButton = By.xpath("//input[@value='Save' and @type='submit']");
    By returnButton = By.xpath("//input[@type='button' and @value='Return']");
    By approveIframe = By.xpath("//div[contains(@class,'active lafPageHost')]//iframe[@title='accessibility title']");
    By down = By.xpath("//button[@class='slds-button slds-button_icon-border-filled']");
    By allApprovals = By.xpath("//a[contains(@aria-controls, 'allApprovalsTab')]");
    By myQueueTab = By.xpath("//a[contains(@aria-controls, 'queueApprovalsTab')]");
    By approvalsTab1 = By.xpath("//span/div[2]/div/div[2]/table/tbody/tr");
    By takeOwnershipTab = By.xpath("//input[@value='Take Ownership' and @type='button']");
    By myApprovalsTab = By.xpath("//a[contains(@aria-controls, 'myApprovalsTab')]");
    By approveButton = By.xpath("//input[@value='Approve' and @type='button']");
    By myPrepayApprovals = By.xpath("//span[contains(text(),'My Prepay Approvals')]");

    public OrderActivation(WebDriver driver) {
        if (driver == null) {
            throw new DriverNotCreatedException();
        } else
            this.driver = driver;
        this.webaction = new WebActions(driver);
        this.wait = new Waits(driver);
        this.s = new ScreenShot(driver);
        this.p = new PomClasses(driver);
        this.randam = new RandomUtils();
        account = new OpportunityCreation1(driver);
        quote = new QuoteCreation1(driver);
        excelUtils = new ExcelUtils();
        dateUtils = new DateUtils();

    }

    public WebElement selectUser(String username) {
        String xpath = "//span[@title='" + username + "']//div";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement oracleBilltoDropDownSelect(String oracleBilltotype, String oracleBilltoname) {
        String xpath = "(//label[text()='" + oracleBilltotype +
                       "']/following::lightning-base-combobox-formatted-text[@title='" + oracleBilltoname + "'])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement oracleShiptoDropDownSelect(String oracleShiptotype, String oracleShiptoname) {
        String xpath = "(//label[text()='" + oracleShiptotype +
                       "']/following::lightning-base-combobox-formatted-text[@title='" + oracleShiptoname + "'])[1]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement oracleOpportunitySelect(String oracleOpportunityType) {
        String xpath = "//span[@title='" + oracleOpportunityType + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement shippingTermSelect(String shippingTerms) {
        String xpath = "//span[@title='" + shippingTerms + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement paymentTermSelect(String paymentTerms) {
        String xpath = "//span[@title='" + paymentTerms + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement freightTermSelect(String freightTerms) {
        String xpath = "//span[@title='" + freightTerms + "']";
        return driver.findElement(By.xpath(xpath));
    }

    public void oracleBilltoSelect(String oracleBilltotype, String oracleBilltoname) throws InterruptedException {
        try {
            try {
                wait.waituntilElementIsDisplayedAndClick(oracleBillToSearch);
                webaction.element().textBox().sendKeys(oracleBillToSearch, oracleBillto);
                Thread.sleep(5000);
                wait.waitUntilElementDisappear(oracleBillToSearch, 10);
                wait.waituntilElementIsDisplayedAndClick(
                                                         oracleBilltoDropDownSelect(oracleBilltotype,
                                                                                    oracleBilltoname));
            } catch (Exception e) {
                webaction.element().textBox().sendKeys(oracleBillToSearch, Keys.ENTER);
                wait.waitForPageLoaded();
                wait.waituntilElementIsDisplayedAndClick(billtoSelection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oracleShiptoSelect(String oracleShiptotype, String oracleShiptoname) throws InterruptedException {
        try {
            try {
                wait.waituntilElementIsDisplayedAndClick(oracleShipToSearch);
                webaction.element().textBox().sendKeys(oracleShipToSearch, oracleShipto);
                Thread.sleep(5000);
                wait.waitUntilElementDisappear(oracleShipToSearch, 10);
                wait.waituntilElementIsDisplayedAndClick(
                                                         oracleShiptoDropDownSelect(oracleShiptotype,
                                                                                    oracleShiptoname));
            } catch (Exception e) {
                webaction.element().textBox().sendKeys(oracleShipToSearch, Keys.ENTER);
                wait.waitForPageLoaded();
                wait.waituntilElementIsDisplayedAndClick(billtoSelection);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prepayApprovals() {
        try {
            webaction.browser().scroll().scrollPage("0", "-1000");
            webaction.browser().scroll().scrollToElement(previewButton);
            wait.waitUntilElementFound(previewButton, 5);
            wait.waituntilElementIsDisplayedAndClick(previewButton);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.elementWait(configureFrame, 20);
            webaction.browser().switchToFrame(configureFrame);
            try {
                String appName = wait.waitUntilElementFound(approverName, 10).getText();
                System.out.println("Approver Name=" + appName);
                if (!appName.equalsIgnoreCase(null) || !appName.isEmpty() || !appName.equals("")) {
                    flag = true;
                }
            } catch (Exception e) {
                flag = false;
            }
            wait.waitUntilElementReliableFound(submit, 30);
            wait.waituntilElementIsDisplayedAndClick(submit);
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(20000);
            wait.elementWait(configureFrame, 20);
            webaction.browser().switchToFrame(configureFrame);
            wait.waitUntilElementReliableFound(submit2, 30);
            wait.waituntilElementIsDisplayedAndClick(submit2);
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(20000);
            wait.elementWait(configureFrame, 20);
            webaction.browser().switchToFrame(configureFrame);
            wait.waitUntilElementReliableFound(Return, 30);
            wait.waituntilElementIsDisplayedAndClick(Return);
            webaction.browser().switchToDefault();
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            if (flag) {
                approvalRequest();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> prepayApprovalflow() throws InterruptedException {
        List<String> approvList = new ArrayList<String>();
        try {
            List<WebElement> appList1 = driver.findElements(approvalsTab1);
            int approvaltab1size = appList1.size();
            System.out.println("Approval table1 size ==" + approvaltab1size);
            for (int k = 0; k < approvaltab1size; k++) {
                try {
                    WebElement status = driver
                                              .findElement(By.xpath("//span/div[2]/div/div[2]/table/tbody/tr[" + (k +
                                                                                                                  1) +
                                                                    "]//td[4]"));
                    String appStatus = status.getText();
                    System.out.println("Approval status ==" + appStatus);
                    if (appStatus.contains("Assigned") || appStatus.contains("Not Submitted")) {
                        WebElement approvalName = driver.findElement(
                                                                     By.xpath("//span/div[2]/div/div[2]/table/tbody/tr[" +
                                                                              (k + 1) + "]//td[5]"));
                        String approver1 = approvalName.getText();
                        approvList.add(a++, approver1);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            wait.waitUntilElementFound(returnButton, 20);
            wait.waituntilElementIsDisplayedAndClick(returnButton);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            webaction.browser().switchToDefault();
        }
        return approvList;
    }

    public void approverQueue(String apprQueue) {
        try {
            String quoteurl = driver.getCurrentUrl();
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(account.userlogout, 30);
            wait.waituntilElementIsDisplayedAndClick(account.userlogout);
            if (apprQueue.equalsIgnoreCase("Prepay approval queue")) {
                account.userLogin(ReadPropertyFile.readPropertyFile(file, "PrepayApprovalQueue"));
            }
            wait.waitUntilElementReliableFound(account.userlogout, 20);
            webaction.browser().goToUrl(quoteurl);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.waitUntilElementReliableFound(down, 20);
            wait.waituntilElementIsDisplayedAndClick(down);
            wait.waituntilElementIsDisplayedAndClick(myPrepayApprovals);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
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

    public void approvalRequest() throws IOException {
        try {
            webaction.browser().scroll().scrollPage("0", "500");
            webaction.browser().scroll().scrollToElement(previewButton);
            wait.waitUntilElementFound(previewButton, 5);
            wait.waituntilElementIsDisplayedAndClick(previewButton);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            wait.elementWait(configureFrame, 20);
            webaction.browser().switchToFrame(configureFrame);
            List<String> approvalList = prepayApprovalflow();
            int approversNum = approvalList.size();
            System.out.println("Approvers size & Aprrovers ==" + approversNum + approvalList);
            String quoteurl = driver.getCurrentUrl();
            for (int x = 0; x < approversNum; x++) {
                String approver = approvalList.get(x);
                if (approver.equalsIgnoreCase("Prepay approval queue")) {
                    approverQueue(approver);
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
                webaction.browser().switchToDefault();
                wait.waitForPageLoaded();
                Thread.sleep(10000);
            }
            String quoteurl1 = driver.getCurrentUrl();
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(account.userlogout, 30);
            wait.waituntilElementIsDisplayedAndClick(account.userlogout);
            account.userLogin(ReadPropertyFile.readPropertyFile(file, "SalesOps"));
            wait.waitUntilElementReliableFound(account.userlogout, 20);
            webaction.browser().goToUrl(quoteurl1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void quoteGenerate(String sceName) throws IOException {

        try {
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(15000);
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(15000);
            wait.waitUntilElementFound(relatedtab, 30);
            webaction.browser().scroll().scrollPage("0", "3000");

            for (int m = 0; m < 10; m++) {
                try {
                    webaction.browser().refresh();
                    wait.waitForPageLoaded();
                    Thread.sleep(15000);
                    wait.waitUntilElementFound(relatedtab, 30);
                    webaction.browser().scroll().scrollPage("0", "1500");
                    webaction.browser().scroll().scrollToElement(generateButton);
                    wait.elementWait(previewbutton, 10);
                    wait.waitUntilElementFound(generateButton, 20);
                    wait.waituntilElementIsDisplayedAndClick(generateButton);
                    break;
                } catch (Exception e) {
                    continue;
                }
            }
            try {
                wait.waitForPageLoaded();
                Thread.sleep(3000);
                webaction.browser().switchToFrame(quoteGenerateFrame);
                Thread.sleep(10000);
                webaction.browser().scroll().scrollPage("0", "200");
                if (sceName.equalsIgnoreCase("VOS360_PC_WithoutDiscounts") || sceName.equalsIgnoreCase(
                                                                                                       "VOS360_PC_MRRDiscount") ||
                    sceName.equalsIgnoreCase("VOS360_PC_netprice_MRRdiscount_MonthlycommitOverride") || sceName
                                                                                                               .equalsIgnoreCase("VOS360_PC_prepay_MRRDiscounts") ||
                    sceName.equalsIgnoreCase("VOS360_PC_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                       "VOS360_PC_partnerIncentice_MRRDiscounts") ||
                    sceName.equalsIgnoreCase("VOS360_PC_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                         "VOS360_PC_Approvals_APACEMEA")) {
                    wait.waituntilElementIsDisplayedAndClick(quoteRadioButtonforPC);
                } else if (sceName.equalsIgnoreCase("VOS360_Multipath_WithoutDiscounts") || sceName.equalsIgnoreCase(
                                                                                                                     "Multipath_Approvals_APACEMEA") ||
                           sceName.equalsIgnoreCase("Multipath_Approvals_NAMLATAM") || sceName.equalsIgnoreCase(
                                                                                                                "Multipath_netprice_MRRdiscount_MonthlycommitOverride_AddSubscriptionProd") ||
                           sceName.equalsIgnoreCase("Multipath_partnerIncentive") || sceName.equalsIgnoreCase(
                                                                                                              "Multipath_partnerIncentice_MRR_TermDiscounts") ||
                           sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                                       "Multipath_termDiscountAndMRRDiscount")) {
                    wait.waituntilElementIsDisplayedAndClick(quoteRadioButtonforMultipath);
                } else {
                    wait.waituntilElementIsDisplayedAndClick(quoteRadioButton1);
                }
                extent.info("Order form visibility",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
                wait.waituntilElementIsDisplayedAndClick(quoteGenerateButton);
                webaction.browser().switchToDefault();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                webaction.browser().switchToDefault();
            }
            try {
                webaction.browser().switchToFrame(quoteSuccessfullFrame);
                try {
                    wait.waituntilElementIsDisplayedAndClick(quoteSuccessfullReturn);
                } catch (Exception e) {
                    try {
                        driver.switchTo().alert().accept();
                        wait.waituntilElementIsDisplayedAndClick(quoteSuccessfullReturn);
                    } catch (Exception exp) {
                        extent.info("Alert popup displayed in Order form generation" + e.getMessage());
                    }
                }
                try {
                    wait.waitUntilElementDisappear(quoteSuccessfullReturn);
                } catch (Exception e) {
                }
                webaction.browser().switchToDefault();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                webaction.browser().switchToDefault();
            }
        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Quote not generated " + e.getMessage(),
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
        }
    }

    public void orderCreation(String sceName) throws IOException {
        try {
            // quoteGenerate(sceName);
            wait.waitForPageLoaded();
            String quoteurl = driver.getCurrentUrl();
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.waitUntilElementFound(account.userlogout, 30);
            wait.waituntilElementIsDisplayedAndClick(account.userlogout);
            account.userLogin(ReadPropertyFile.readPropertyFile(file, "SalesOps"));
            wait.waitUntilElementReliableFound(account.userlogout, 20);
            webaction.browser().goToUrl(quoteurl);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            webaction.browser().scroll().scrollPage("0", "3000");
            webaction.browser().scroll().scrollToElement(createOrder);
            wait.elementWait(presentButton, 20);
            wait.waitUntilElementReliableFound(createOrder, 20);
            wait.waituntilElementIsDisplayedAndClick(createOrder);
            wait.waitForPageLoaded();
            Thread.sleep(25000);
            wait.waitUntilElementFound(relatedtab, 50);
            for (int m = 0; m < 50; m++) {

                webaction.browser().scroll().scrollPage("0", "500");
                try {
                    System.out.println(wait.waitUntilElementFound(approvalStage, 10).getText());
                } catch (Exception e) {
                    webaction.browser().refresh();
                    wait.waitForPageLoaded();
                    Thread.sleep(15000);
                    wait.waitUntilElementFound(relatedtab, 50);
                    continue;
                }
                if (wait.waitUntilElementFound(approvalStage, 10).getText().equals("Accepted")) {
                    System.out.println(wait.waitUntilElementFound(approvalStage, 10).getText());
                    break;
                } else {
                    webaction.browser().refresh();
                    wait.waitForPageLoaded();
                    Thread.sleep(15000);
                    wait.waitUntilElementFound(relatedtab, 50);
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            extent.info("Order not generated " + e.getMessage(),
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
        }
    }

    public String orderActivation(String sceName,
                                  HashMap<String, String> activeorder,
                                  int i,
                                  String filepath,
                                  int statuscol,
                                  int commentcol,
                                  int idcol,
                                  int invOrdIdcol) throws Exception {
        List<Boolean> tcResult = new ArrayList<Boolean>();
        boolean tcIsCompleted = false;
        String status = "";
        String comment = "";
        Random r = new Random();
        int no = r.nextInt(100000);
        String ponumber = "10";
        String sonumber = "10";
        // filepath = System.getProperty("user.dir") +
        // "/ExcelData/HarmonicTestCase1.xlsx";
        orderSheetName = "Activation_Order";
        invoiceSheetName = "Invoice_Creation";

        try {
            this.oracleOpportunityType = activeorder.get("Oracle Opportunity Type");
            this.POnumber = activeorder.get("PO Number");
            String POnumber = no + "_" + ponumber;
            this.shippingTerms = activeorder.get("Shipping terms (FOB)");
            this.salesOrdernunber = activeorder.get("Sales Order No");
            String SOnumber = no + "_" + sonumber;
            this.oracleBillto = activeorder.get("Oracle Bill To");
            this.oracleShipto = activeorder.get("Oracle Ship To");
            this.paymentTerms = activeorder.get("Payment Terms");
            this.freightTerms = activeorder.get("Freight Terms");
            this.readyforFullfillementdate = activeorder.get("Ready For Fulfillment Date");
            webaction.browser().refresh();
            wait.waitForPageLoaded();
            orderCreation(sceName);
            wait.waitForPageLoaded();
            webaction.browser().scroll().scrollToElement(relatedtab);
            wait.waitUntilElementFound(relatedtab, 20);
            wait.waituntilElementIsDisplayedAndClick(relatedtab);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            wait.elementWait(configuration, 10);
            webaction.browser().scroll().scrollPage("0", "700");
            webaction.browser().scroll().scrollToElement(orderNumber);
            wait.waitUntilElementReliableFound(orderNumber, 120);
            webaction.element().click().jsClick(orderNumber);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            webaction.browser().scroll().scrollPage("0", "1500");
            webaction.browser().scroll().scrollToElement(editButton);
            wait.waituntilElementIsDisplayedAndClick(editButton);
            webaction.browser().scroll().scrollPage("0", "-100");
            wait.waituntilElementIsDisplayedAndClick(paymentTermInput);
            webaction.browser().scroll().scrollintoview(paymentTermSelect(paymentTerms));
            wait.waituntilElementIsDisplayedAndClick(paymentTermSelect(paymentTerms));
            webaction.browser().scroll().scrollPage("0", "-100");
            wait.waituntilElementIsDisplayedAndClick(freightTermsInput);
            wait.waituntilElementIsDisplayedAndClick(freightTermSelect(freightTerms));
            webaction.browser().scroll().scrollPage("0", "70");
            wait.waitUntilElementFound(oracleOpportunityTypeInput, 5);
            wait.waituntilElementIsDisplayedAndClick(oracleOpportunityTypeInput);
            wait.waituntilElementIsDisplayedAndClick(oracleOpportunitySelect(oracleOpportunityType));
            webaction.browser().scroll().scrollToElement(POnumberInput);
            webaction.element().textBox().sendKeys(POnumberInput, POnumber);
            webaction.browser().scroll().scrollToElement(shippingTermInput);
            webaction.element().click().jsClick(shippingTermInput);
            wait.waituntilElementIsDisplayedAndClick(shippingTermSelect(shippingTerms));
            webaction.browser().scroll().scrollToElement(salesOrderNoInput);
            webaction.element().textBox().sendKeys(salesOrderNoInput, SOnumber);
            webaction.browser().scroll().scrollPage("0", "200");
            oracleBilltoSelect("Oracle Bill To", oracleBillto);
            oracleShiptoSelect("Oracle Ship To", oracleShipto);
            webaction.browser().scroll().scrollPage("0", "500");
            wait.waituntilElementIsDisplayedAndClick(fullfillmentDateInput);
            webaction.element().textBox().sendKeys(fullfillmentDateInput, dateUtils.prevMonthCurrDate());
            try {
                wait.waitUntilElementFound(Save, 20);
                webaction.element().click().by(Save);
                wait.waitForPageLoaded();
                wait.waitUntilElementDisappear(Save, 10);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
                webaction.element().click().by(Save);
                wait.waitForPageLoaded();
                wait.waitUntilElementDisappear(Save, 10);
                wait.waitForPageLoaded();
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("Save block");
            }
            wait.waitForPageLoaded();
            if (sceName.equalsIgnoreCase("prepay_Term_MRR_Discounts") || sceName.equalsIgnoreCase(
                                                                                                  "VOS360_PC_prepay_MRRDiscounts") ||
                sceName.equalsIgnoreCase("Multipath_prepay_Term_MRR_Discounts")) {
                prepayApprovals();
            }
            webaction.browser().scroll().scrollToElement(activateOrder);
            wait.waituntilElementIsDisplayedAndClick(activateOrder);
            wait.waitUntilElementDisappear(activateOrder, 50);
            Thread.sleep(10000);
            for (int m = 0; m < 20; m++) {
                webaction.browser().refresh();
                wait.waitForPageLoaded();
                Thread.sleep(7000);
                wait.waitUntilElementFound(relatedtab, 30);
                if (wait.waitUntilElementFound(orderStatus, 10).getText().equals("Activated")) {
                    break;
                } else {
                    continue;
                }

            }
            wait.waitUntilElementFound(orderStatus, 10).getText();
            if (!(wait.waitUntilElementFound(orderStatus, 10).getText().equals("Activated"))) {

                extent.info("Order is not in Activated state",
                            MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                                   ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                              .build());
            }

            int index = driver.getCurrentUrl().split("/").length - 2;
            String[] order = driver.getCurrentUrl().split("/");
            String orderID = order[index];
            System.out.println("Order= " + orderID);
            excelUtils.setCellData(orderSheetName, filepath, "OrderID", i, orderID);
            excelUtils.setCellData(invoiceSheetName, filepath, "OrderId", i, orderID);
            wait.waitForPageLoaded();
            Thread.sleep(10000);
            status = "Pass";
            comment = "Order Activated";
            tcIsCompleted = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = "Fail";
            comment = "Exception Occurred";
            extent.fail("Exception occured in Order Activation",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(
                                                                               ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver)))
                                          .build());
            extent.fail(e.getMessage());
            tcResult.add(false);
        } finally {

            ExcelUtils.writeData(orderSheetName, filepath, status, statuscol, i);
            ExcelUtils.writeData(orderSheetName, filepath, comment, commentcol, i);

        }
        {
            String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
            return exeStatus;
        }
    }

}
