package com.Forsys.utils.Pom;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Forsys.api.report.ExtentReportListener;
import com.Forsys.api.report.ExtentReportUtil;
import com.Forsys.exceptions.DriverNotCreatedException;
import com.Forsys.hub.HubUsage;
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

public class BulkInvoice {
	private WebDriver driver;
	WebActions webaction;
	Waits wait;
	ScreenShot s;
	RandomUtils randam;
	InvoiceCreation invCreation;
	KeyboardActions action;
	OpportunityCreation1 account;
	OrderActivation order;
	DateUtils dateUtils;
	ExcelUtils excelUtils;
	HubUsage usage;
	String sheetName;
	String invSheetName;
	String usagesSheetName;
	String usagesSheetName1;
	String invoiceName;
	String query;
	String invoiceRunName;
	String invoiceOverrideTemplate;
	String accountField1;
	String accountOperator1;
	String accountValue1;
	String accountField2;
	String accountOperator2;
	String accountValue2;
	String billingScheduleField1;
	String billingScheduleOperator1;
	String billingScheduleValue1;
	String billingScheduleField2;
	String billingScheduleOperator2;
	String billingScheduleValue2;
	String billingScheduleField3;
	String billingScheduleOperator3;
	String billingScheduleValue3;
	String billingScheduleField4;
	String billingScheduleOperator4;
	String billingScheduleValue4;
	String billingScheduleField5;
	String billingScheduleOperator5;
	String billingScheduleValue5;
	String invoiceRun;
	String invoiceDataType;
	String firstWindow;
	String accountLocation;
	String OrdEndDate;
	String actualtotalForInvoice;
	String expectedtotalForInvoice;
	String sourceMnthUsagesQuery;
	String targetMnthUsagesQuery;
	int a;
	int b;
	int c;
	int d;
	int x = 1;
	String invrunName;
	double dexpTotInvAmt;
	double dactTotInvAmt;
	double adjustmentAmt;

	List<String> locationList = new ArrayList<String>();
	List<String> amountList = new ArrayList<String>();
	List<String> adjustmt = new ArrayList<String>();
	ExtentTest extent = ExtentReportListener.extent_test.get();
	String file = System.getProperty("propertyFile");
	By searchIcon = By.xpath("//div[@class='slds-icon-waffle']");
	By searchInput = By.xpath("//input[@class='slds-input']");
	By invoiceRuns = By.xpath("//a[@data-label='Invoice Runs']");
	By clearInv = By.xpath("//button[text()='Clear']");
	By applyBtn = By.xpath("//button[text()='Apply']");
	By downButton = By.xpath("//span[contains(text(),'Recently Viewed')]/../../..//*[local-name()='svg' and @data-key='down' and @class='slds-button__icon']");
    By allButton = By.xpath("(//span[contains(text(), 'All') and @title='All'])[1]");
    By searchInputButton = By.xpath("//input[@placeholder='Search this list...' ]");
	By viewAll = By.xpath("//span[contains(text(), 'View All') and @class='view-all-label']");
	By cancelButton = By.xpath("//div[contains(@class,'active lafPageHost')]//button[text()='Cancel Invoice(s)']");
	By selectAll = By.xpath("//div[contains(@class,'active lafPageHost')]//span[contains(text(),'Select All')]");
	By selectOne = By.xpath("(//span[contains(@class, 'forceVirtualCheckbox')])[2]");
	By confirmButton = By.xpath("(//input[@Value='Confirm' and @class='btn'])[1]");
	By invTabSize = By.xpath("//*[@id=\"brandBand_2\"]/div/div/div[2]//table/tbody/tr");
	By developerConsole = By
			.xpath("//div[starts-with(@class,'popupTargetContainer menu--nubbin-top uiPopupTarget')]//li[5]");
	By debug = By.xpath("//span[contains(text(),'Debug')]/../..//button");
	By openWindow = By.xpath("//div[contains(text(), 'Open Execute Anonymous Window')]");
	By queryInput = By.xpath("//div[@id='window-1182']//div[@class='CodeMirror-lines']");
	By execute = By.xpath("(//span[contains(text(), 'Execute') ])[1]");
	By executeforqueryeditor = By.xpath("(//span[contains(text(), 'Execute')])[2]");
	By queryEditor = By.xpath("//span[contains(text(), 'Query Editor')]/../..//button");
	By queryEditorInput = By.xpath("//textarea[@name='queryEditorText-inputEl']");
	By noofRows = By.xpath("(//span[contains(text(), 'Query Results - ')])[1]");
	By noofRows2 = By.xpath("(//span[contains(text(), 'Query Results - ')])[2]");
	By button = By.xpath("//img[@data-qtip='Open in new window']");
	By okButton = By.xpath("//span[text()='OK']");
	By closeButton = By.xpath("//a[contains(@class, 'x-tab-close-btn')]");
	By add = By.xpath("(//a[contains(text(), 'Add')])[2]");
	By accountTab = By.xpath("//a[@data-label='Account']");
	By cancelTable = By.xpath("//*[@id='brandBand_2']//div[1]/div/div/table/tbody/tr");
	By timeOut = By.xpath("//span[text()='Apex CPU time limit exceeded']");
	By configureFrame = By.xpath("//div[contains(@class,'active lafPageHost')]//iframe[@title='accessibility title']");
	By invRunRes = By.xpath("//span[contains(text(), 'Invoice Run Results')]");
	By accField1 = By
			.xpath("((//div[@title='Operator'])[1]/../../../../..//button[contains(@id, 'combobox-button')])[1]");
	By accOperator1 = By
			.xpath("((//div[@title='Operator'])[1]/../../../../..//button[contains(@id, 'combobox-button')])[2]");
	By accValue1 = By.xpath("((//div[@title='Value'])[1]/../../../../..//input[@class='slds-input'])[1]");
	By accField2 = By
			.xpath("((//div[@title='Operator'])[1]/../../../../..//button[contains(@id, 'combobox-button')])[3]");
	By accOperator2 = By
			.xpath("((//div[@title='Operator'])[1]/../../../../..//button[contains(@id, 'combobox-button')])[4]");
	By accValue2 = By.xpath("((//div[@title='Value'])[1]/../../../../..//input[@class='slds-input'])[2]");
	By accField3 = By
			.xpath("((//div[@title='Operator'])[1]/../../../../..//button[contains(@id, 'combobox-button')])[5]");
	By accOperator3 = By
			.xpath("((//div[@title='Operator'])[1]/../../../../..//button[contains(@id, 'combobox-button')])[6]");
	By accValue3 = By.xpath("((//div[@title='Value'])[1]/../../../../..//input[@class='slds-input'])[3]");

	By billingschField1 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[1]");
	By billingschOperator1 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[2]");
	By billingschValue1 = By.xpath("((//div[@title='Value'])[2]/../../../../..//input[@class='slds-input'])[1]");
	By billingschField2 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[3]");
	By billingschOperator2 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[4]");
	By billingschValue2 = By.xpath("((//div[@title='Value'])[2]/../../../../..//input[@class='slds-input'])[2]");
	By billingschField3 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[5]");
	By billingschOperator3 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[6]");
	By billingschValue3 = By.xpath("((//div[@title='Value'])[2]/../../../../..//input[@class='slds-input'])[3]");
	By billingschField4 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[7]");
	By billingschOperator4 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[8]");
	By billingschValue4 = By.xpath("((//div[@title='Value'])[2]/../../../../..//input[@class='slds-input'])[4]");
	By billingschField5 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[9]");
	By billingschOperator5 = By
			.xpath("((//div[@title='Operator'])[2]/../../../../..//button[contains(@id, 'combobox-button')])[10]");
	By billingschValue5 = By.xpath("((//div[@title='Value'])[2]/../../../../..//input[@class='slds-input'])[5]");
	By status = By
			.xpath("(//th[contains(text(), 'Total Invoices Generated')]/../../..//div[@class='slds-truncate'])[3]");
	By locationName = By.xpath("//label[text()='Location']/..//input");
	By cancel = By.xpath("//*[local-name()='svg' and @data-key='close']");
	By canceldownbutton= By.xpath("//div[contains(@class,'active lafPageHost')]//span[text()='Show more actions']");
	

	public WebElement selectBulkInvoiceName(String bulkInvoiceName) {
		String xpath = "//div[contains(@class,'active lafPageHost')]//a[@title='" + bulkInvoiceName + "']";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement selectBulkInvoiceName1(String bulkInvoiceName) {
		String xpath = "//div[contains(@class,'active lafPageHost')]//a[contains(@title, '" + bulkInvoiceName + "')]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement accountSelect(String accountselect) {
		String xpath = "//span[@title='" + accountselect + "']";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement accountSelect1(String accountselect1) {
		String xpath = "(//span[@title='" + accountselect1 + "'])[2]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement eqaltoSelect1(String eqalto1) {
		String xpath = "(//span[@title='" + eqalto1 + "'])[2]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement eqaltoSelect2(String eqalto2) {
		String xpath = "(//span[contains(text(),'" + eqalto2 + "')])[3]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement periodEndDateSelect(String eqalto3) {
		String xpath = "(//span[contains(text(),'" + eqalto3 + "')])[2]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement eqaltoSelect4(String eqalto4) {
		String xpath = "(//span[contains(text(),'" + eqalto4 + "')])[4]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement MRRSelect(String eqalto5) {
		String xpath = "(//span[contains(text(),'" + eqalto5 + "')])[3]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement eqaltoSelect6(String eqalto6) {
		String xpath = "(//span[contains(text(),'" + eqalto6 + "')])[21]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement productLineSelect(String productLine) {
		String xpath = "(//span[contains(text(),'" + productLine + "')])[4]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement eqaltoSelect7(String eqalto7) {
		String xpath = "(//span[contains(text(),'" + eqalto7 + "')])[26]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement eqaltoSelect8(String eqalto8) {
		String xpath = "(//span[contains(text(),'" + eqalto8 + "')])[31]";
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement orderTerminateSelect(String orderTerminate) {
		String xpath = "(//span[contains(text(),'" + orderTerminate + "')])[5]";
		return driver.findElement(By.xpath(xpath));
	}

	public BulkInvoice(WebDriver driver) {
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
		invCreation = new InvoiceCreation(driver);
		usage = new HubUsage();
	}

	public void bulkInvoiceCancellation(int i, String filepath, String sceName) throws IOException {
		try {
			wait.waitUntilElementFound(searchIcon, 5);
			wait.waituntilElementIsDisplayedAndClick(clearInv);
			wait.waituntilElementIsDisplayedAndClick(applyBtn);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			wait.waitUntilElementFound(selectAll, 15);
			String url = driver.getCurrentUrl();
			// if (sceName.equalsIgnoreCase("Bulk_Invoicing_VOS360_NonMRR")) {
			WebElement element = driver.findElement(By
					.xpath("//div[@id='brandBand_2']//table[@data-aura-class='uiVirtualDataTable']/tbody/tr[1]/td[5]"));
			element.click();
			Actions act = new Actions(driver);
			for (int x = 0; x < 20; x++) {
				act.sendKeys(Keys.ARROW_DOWN);
			}
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			List<WebElement> cancelInvTab = driver.findElements(cancelTable);
			int cancelInvTabSize = cancelInvTab.size();
			System.out.println("Cancel table size=" + cancelInvTabSize);
			while (x <= cancelInvTabSize) {

				for (int n = 1; n <= 5; n++) {
					if (x <= cancelInvTabSize) {
						wait.waituntilElementIsDisplayedAndClick(
								By.xpath("//*[@id='brandBand_2']//div[1]/div/div/table/tbody/tr[" + x + "]/td[2]"));
						x++;
					} else
						continue;
				}
				wait.waitUntilElementFound(cancelButton, 15);
				wait.waituntilElementIsDisplayedAndClick(cancelButton);
				wait.waitForPageLoaded();
				Thread.sleep(5000);
				webaction.browser().switchToFrame(configureFrame);
				wait.waituntilElementIsDisplayedAndClick(confirmButton);
				wait.waitForPageLoaded();
				Thread.sleep(20000);
				webaction.browser().goToUrl(url);
				Thread.sleep(10000);

			}

			System.out.println("Bulk Invoice has been Cancelled Successfully");
			extent.info("Bulk Invoice cancellation", MediaEntityBuilder.createScreenCaptureFromBase64String(
					ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver))).build());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Bulk Invoice cancellation failed");
			extent.info("Bulk Invoice cancellation failed", MediaEntityBuilder.createScreenCaptureFromBase64String(
					ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver))).build());
		}
	}

	public void bulkInvoiceCancellation1(int i, String filepath, String sceName) throws IOException {
		try {
			String value1=null;
			
			wait.waitUntilElementFound(searchIcon, 5);
			try {
			wait.waituntilElementIsDisplayedAndClick(clearInv);
			wait.waituntilElementIsDisplayedAndClick(applyBtn);
			}catch(Exception e) {
				
			}
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			wait.waitUntilElementFound(selectAll, 15);
			String url = driver.getCurrentUrl();
			
			for(int s=0;s<20;s++)
			{	
				for(int a=0;a<2;a++)
				{
					webaction.element().click().jsClick(By.xpath("//div[contains(@class,'active lafPageHost')]//span[@title='Status']"));
					wait.waitForPageLoaded();
					Thread.sleep(5000);
					value1=driver.findElement(By.xpath("//div[@id='brandBand_2']//table/tbody/tr[1]/td[3]")).getText();
					if(value1.equals("Approved")||value1.equals("Draft"))
					{
						break;
					}
					else
						continue;
				}
				
				String value=driver.findElement(By.xpath("//div[@id='brandBand_2']//table/tbody/tr[1]/td[3]")).getText();
				if(value.equals("Approved")||value.equals("Draft")||value.equals("Credited")||
						value.equals("Draft Obsolete"))
				{
					for (int n = 1; n <= 5; n++)
					{
						wait.waituntilElementIsDisplayedAndClick(By.xpath("//*[@id='brandBand_2']//div[1]/div/div[contains(@class,'active lafPageHost')]//table/tbody/tr[" + n +"]/td[2]"));
					} 
						
					try
					{
						wait.waitUntilElementFound(cancelButton, 15);
						wait.waituntilElementIsDisplayedAndClick(cancelButton);
					}
					catch(Exception e)
					{
						wait.waitUntilElementFound(canceldownbutton, 10);
						webaction.element().click().jsClick(canceldownbutton);
						wait.waitUntilElementFound(cancelButton, 15);
						wait.waituntilElementIsDisplayedAndClick(cancelButton);
					}	
					wait.waitForPageLoaded();
					Thread.sleep(5000);
					webaction.browser().switchToFrame(configureFrame);
					wait.waituntilElementIsDisplayedAndClick(confirmButton);
					wait.waitForPageLoaded();
					Thread.sleep(20000);
					webaction.browser().goToUrl(url);
					Thread.sleep(10000);
				}
				else
				{
					System.out.println("Bulk Invoice has been Cancelled Successfully");
					break;
				}
				
			}
				
		}
		
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Bulk Invoice cancellation failed");
				extent.info("Bulk Invoice cancellation failed", MediaEntityBuilder.createScreenCaptureFromBase64String(
						ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver))).build());
			}
		}

	public List<String> quoteIdList(HashMap<String, String> bulkInvCreation, int i, String filepath, String sceName) {
		List<String> quoteList = new ArrayList<String>();

		try {
			if (sceName.equalsIgnoreCase("Bulk_Invoice_VOS360PC_MRR")) {
				invSheetName = "Validations_VOS360PC_MRR";
				usagesSheetName = "VOS360PC_MRR_Usages";
				usagesSheetName1 = "VOS360PC_MRR_Usages1";
			} else if (sceName.equalsIgnoreCase("Bulk_Invoice_VOS360_MRR")) {
				invSheetName = "Validations_VOS360_MRR";
				usagesSheetName = "VOS360_MRR_Usages";
				usagesSheetName1 = "VOS360_MRR_Usages1";
			} else if (sceName.equalsIgnoreCase("Bulk_Invoice_SW_Capacity")) {
				invSheetName = "Validations_SW_Capacity";
				usagesSheetName = "SW_Capacity_Usages";
				usagesSheetName1 = "SW_Capacity_Usages1";
			} else if (sceName.equalsIgnoreCase("Bulk_Invoicing_VOS360_NonMRR")) {
				invSheetName = "Validations_VOS360_NonMRR";
				usagesSheetName = "VOS360_NonMRR_Usages";
				usagesSheetName1="VOS360_NonMRR_Usages1";
			} else if (sceName.equalsIgnoreCase("Bulk_Invoice_VOS360PC_NonMRR")) {
				invSheetName = "Validations_VOS360_PC_NonMRR";
				usagesSheetName = "VOS360PC_NonMRR_Usages";
				usagesSheetName1 = "VOS360PC_NonMRR_Usages1";
			}  else if (sceName.equalsIgnoreCase("Bulk_Invoice_SW-Sub_MRR")) {
                invSheetName = "Validations_SW-Sub_MRR";
                usagesSheetName = "SW-Sub_MRR_Usages";
                usagesSheetName1 = "SW-Sub_MRR_Usages1";
            } else if (sceName.equalsIgnoreCase("Bulk_Invoice_SW-Sub_NonMRR")) {
                invSheetName = "Validations_SW-Sub_NonMRR";
                usagesSheetName = "SW-Sub_NonMRR_Usages";
                usagesSheetName1 = "SW-Sub_NonMRR_Usages1";
			} else if (sceName.equalsIgnoreCase("Bulk_Invoice_ServiceMRR")) {
				invSheetName = "Validations_ServiceMRR";
				usagesSheetName = "ServiceMRR_Usages";
				usagesSheetName1 = "ServiceMRR_Usages1";
			}
			this.invoiceName = bulkInvCreation.get("Invoice Name").trim();
			this.query = bulkInvCreation.get("Query").trim();
			this.invoiceRunName = bulkInvCreation.get("Invoice Run Name ").trim();
			this.invoiceOverrideTemplate = bulkInvCreation.get("Invoice Override Template").trim();
			this.accountField1 = bulkInvCreation.get("Account Field1").trim();
			this.accountOperator1 = bulkInvCreation.get("Account Operator1").trim();
			this.accountValue1 = bulkInvCreation.get("Account Value1").trim();
			this.invoiceRun = bulkInvCreation.get("Title Name").trim();
			this.accountField2 = bulkInvCreation.get("Account Field2").trim();
			this.accountOperator2 = bulkInvCreation.get("Account Operator2").trim();
			this.accountValue2 = bulkInvCreation.get("Account Value2").trim();
			this.billingScheduleField1 = bulkInvCreation.get("Billing Scedule Field1").trim();
			this.billingScheduleOperator1 = bulkInvCreation.get("Billing Schedule Operator1").trim();
			this.billingScheduleValue1 = bulkInvCreation.get("Billing schedule Value1").trim();
			this.billingScheduleField2 = bulkInvCreation.get("Billing Scedule Field2").trim();
			this.billingScheduleOperator2 = bulkInvCreation.get("Billing Schedule Operator2").trim();
			this.billingScheduleValue2 = bulkInvCreation.get("Billing schedule Value2").trim();
			this.billingScheduleField3 = bulkInvCreation.get("Billing Scedule Field3").trim();
			this.billingScheduleOperator3 = bulkInvCreation.get("Billing Schedule Operator3").trim();
			this.billingScheduleValue3 = bulkInvCreation.get("Billing schedule Value3").trim();
			this.billingScheduleField4 = bulkInvCreation.get("Billing Scedule Field4").trim();
			this.billingScheduleOperator4 = bulkInvCreation.get("Billing Schedule Operator4").trim();
			this.billingScheduleValue4 = bulkInvCreation.get("Billing schedule Value4").trim();
			if (!sceName.equalsIgnoreCase("Bulk_Invoice_SW_Capacity")
					&& !sceName.equalsIgnoreCase("Bulk_Invoice_ServiceMRR")) {
				this.billingScheduleField5 = bulkInvCreation.get("Billing Scedule Field5").trim();
				this.billingScheduleOperator5 = bulkInvCreation.get("Billing Schedule Operator5").trim();
				this.billingScheduleValue5 = bulkInvCreation.get("Billing schedule Value5").trim();
			}
			this.invoiceDataType = bulkInvCreation.get("Invoice Date Type").trim();

			Thread.sleep(5000);
			wait.waitUntilElementFound(account.setup, 15);
			wait.waituntilElementIsDisplayedAndClick(account.setup);
			wait.waituntilElementIsDisplayedAndClick(account.setupgear);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			Set<String> windows = webaction.browser().getWindowHandles();
			webaction.browser().switchToWindowHandle((String) windows.toArray()[1]);
			firstWindow = driver.getWindowHandle();
			Thread.sleep(5000);
			account.userLogin(ReadPropertyFile.readPropertyFile(file, "SalesOpsUser"));
			wait.waitUntilElementFound(account.userlogout, 30);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			wait.waitUntilElementFound(searchIcon, 15);
			wait.waituntilElementIsDisplayedAndClick(searchIcon);
			wait.waitUntilElementFound(searchInput, 10);
			webaction.element().textBox().sendKeys(searchInput, invoiceRun);
			Thread.sleep(3000);
			webaction.element().textBox().sendKeys(searchInput, Keys.ENTER);
			wait.waitForPageLoaded();
			Thread.sleep(7000);
			wait.waitUntilElementFound(downButton, 5);
			wait.waituntilElementIsDisplayedAndClick(downButton);
			wait.waituntilElementIsDisplayedAndClick(allButton);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			wait.waitUntilElementFound(searchInputButton, 10);
			webaction.element().textBox().sendKeys(searchInputButton, invoiceName);
			Thread.sleep(5000);
			webaction.element().textBox().sendKeys(searchInputButton, Keys.ENTER);
			wait.waitForPageLoaded();
			Thread.sleep(7000);
			if (invoiceName.contains("'")) {
				String[] invName = invoiceName.split("'");
				invoiceName = invName[0];
				wait.waituntilElementIsDisplayedAndClick(selectBulkInvoiceName1(invoiceName));
			} else {
				wait.waituntilElementIsDisplayedAndClick(selectBulkInvoiceName(invoiceName));
			}
			wait.waitForPageLoaded();
			Thread.sleep(7000);
			try {
				wait.waitUntilElementFound(invCreation.runIframe, 20);
				webaction.browser().switchToFrame(invCreation.runIframe);
				Thread.sleep(5000);
			} catch (Exception e) {
			}
			try {
				wait.waitUntilElementFound(invCreation.relatedforinv, 15);
				wait.waituntilElementIsDisplayedAndClick(invCreation.relatedforinv);
				Thread.sleep(5000);

			} catch (Exception e) {
			}
			try {
				webaction.browser().switchToDefault();
			} catch (Exception e) {
				extent.info("Target frame detach" + e.getMessage());
			}
			try {
				wait.waitUntilElementFound(invCreation.runIframe, 20);
				webaction.browser().switchToFrame(invCreation.runIframe);
				webaction.element().click().by(invCreation.invoiceNumlink);
			} catch (Exception e) {

			}
			try {
				webaction.browser().switchToDefault();
			} catch (Exception e) {
				extent.info("Target frame detach" + e.getMessage());
			}
			Thread.sleep(7000);
			webaction.browser().scroll().scrollToBottom();
			Thread.sleep(5000);
			wait.waitUntilElementFound(viewAll, 15);
			webaction.element().click().jsClick(viewAll);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			WebElement element = driver.findElement(By
					.xpath("//*[@id=\"brandBand_2\"]/div/div/div[2]//table/tbody/tr"));
			element.click();
			Actions act = new Actions(driver);
			for (int x = 0; x < 20; x++) {
				act.sendKeys(Keys.ARROW_DOWN);
			}
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			List<WebElement> invTable = driver.findElements(invTabSize);
			int invTableSize = invTable.size();
			System.out.println("Invoice table size=" + invTableSize);
			for (int k = 1; k <= invTableSize; k++) {
				WebElement quoteid;
				WebElement ordEndDt;
				String accountLoc;
				WebElement primaryProduct;
				WebElement adjustment;
				WebElement totalforInv;
				excelUtils.setCellData(invSheetName, filepath, "Sno", k, String.valueOf(k));
				try {
					if (k <= 10)
						quoteid = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[5])[2]"));

					else
						quoteid = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[5])[1]"));
					String quote = quoteid.getText();
					System.out.println("quote id ==" + quote);
					quoteList.add(a++, quote);
					if (k <= 10)
						ordEndDt = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[8])[2]"));
					else
						ordEndDt = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[8])[1]"));
					OrdEndDate = ordEndDt.getText();
					System.out.println("Order end date" + OrdEndDate);
					excelUtils.setCellData(invSheetName, filepath, "Order End Date", k, OrdEndDate);
					if (k <= 10)
                        accountLoc = driver.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[4])[2]//a")).getAttribute("title");
                    else
                        accountLoc = driver.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[4])[1]//a")).getAttribute("title");
                    System.out.println("Account Location ==" + accountLoc);
                    locationList.add(b++, accountLoc);
                    excelUtils.setCellData(invSheetName, filepath, "Actual Account Location", k, accountLoc);
					if (k <= 10)
						primaryProduct = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[6])[2]"));
					else
						primaryProduct = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[6])[1]"));
					String primaryProductLine = primaryProduct.getText();
					System.out.println("Primary Product Line ==" + primaryProductLine);
					excelUtils.setCellData(invSheetName, filepath, "Actual Primar Product Line", k, primaryProductLine);
					if (k <= 10)
						adjustment = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[10])[2]"));
					else
						adjustment = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[10])[1]"));
					String adjust = adjustment.getText();
					if (!adjust.equals("")) {
						adjustmt.add(d++, adjust);
						System.out.println("Adjustments==" + adjust);
						excelUtils.setCellData(invSheetName, filepath, "Adjustments", k, adjust);
					} else
						excelUtils.setCellData(invSheetName, filepath, "Adjustments", k, "NA");
					if (k <= 10)
						totalforInv = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[11])[2]"));
					else
						totalforInv = driver
								.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[" + k + "]/td[11])[1]"));
					actualtotalForInvoice = totalforInv.getText();
					amountList.add(c++, actualtotalForInvoice);
					System.out.println("Total For This Invoice ==" + actualtotalForInvoice);
					excelUtils.setCellData(invSheetName, filepath, "Actual Total for this Invoice", k,
							actualtotalForInvoice);

				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		System.out.println("size of locations==" + locationList.size());
		return quoteList;

	}

	public String bulkRating() throws IOException {
		List<Boolean> tcResult = new ArrayList<Boolean>();
		boolean tcIsCompleted = false;
		@SuppressWarnings("unused")
		String status = "";
		try {
			wait.waituntilElementIsDisplayedAndClick(account.userlogout);
			String loadedQuery = "select Id,Apttus_Billing__Description__c, Apttus_Billing__Status__c, Apttus_Billing__Quantity__c, Apttus_Billing__StartDate__c, Apttus_Billing__EndDate__c, LastModifiedDate, LastModifiedBy.Name from Apttus_Billing__UsageInput__c where Apttus_Billing__Quantity__c >0 and Apttus_Billing__StartDate__c >="
					+ ReadPropertyFile.readPropertyFile(file, "strDate") + "and Apttus_Billing__EndDate__c <= "
					+ ReadPropertyFile.readPropertyFile(file, "endDate")
					+ " and Apttus_Billing__Status__c ='Loaded' and APTS_B_Usage_Status__c ='Completed'";
			String ratedQuery = "select Id,Apttus_Billing__Description__c, Apttus_Billing__Status__c, Apttus_Billing__Quantity__c, Apttus_Billing__StartDate__c, Apttus_Billing__EndDate__c, LastModifiedDate, LastModifiedBy.Name from Apttus_Billing__UsageInput__c where Apttus_Billing__Quantity__c >0 and Apttus_Billing__StartDate__c >= "
					+ ReadPropertyFile.readPropertyFile(file, "strDate") + " and Apttus_Billing__EndDate__c <="
					+ ReadPropertyFile.readPropertyFile(file, "endDate")
					+ " and Apttus_Billing__Status__c ='Rated' and APTS_B_Usage_Status__c ='Completed'";
			String runQuery = "List<Apttus_Billing__UsageInput__c> usageList = [select Id,Apttus_Billing__Description__c, Apttus_Billing__Status__c, Apttus_Billing__Quantity__c, Apttus_Billing__StartDate__c, Apttus_Billing__EndDate__c, LastModifiedDate, LastModifiedBy.Name from Apttus_Billing__UsageInput__c where Apttus_Billing__Quantity__c >0 and Apttus_Billing__StartDate__c >= "
					+ ReadPropertyFile.readPropertyFile(file, "strDate") + " and Apttus_Billing__EndDate__c <= "
					+ ReadPropertyFile.readPropertyFile(file, "endDate")
					+ " and Apttus_Billing__Status__c ='Loaded' and APTS_B_Usage_Status__c ='Completed'];APTS_B_UsageInputBatchHelper.processUsageInputRun(usageList);";
			Thread.sleep(5000);
			wait.waitUntilElementDisappear(account.userlogout, 20);
			wait.waitUntilElementFound(account.setup, 30);
			wait.waituntilElementIsDisplayedAndClick(account.setup);
			Thread.sleep(5000);
			wait.waituntilElementIsDisplayedAndClick(developerConsole);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			Set<String> windows = webaction.browser().getWindowHandles();
			System.out.println("Size of windows=" + windows.size());
			webaction.browser().switchToWindowHandle((String) windows.toArray()[windows.size() - 1]);
			wait.waitUntilElementFound(queryEditor, 50);
			driver.manage().window().maximize();
			try {
				wait.waituntilElementIsDisplayedAndClick(okButton);
				Thread.sleep(5000);
			} catch (Exception e) {

			}
			List<WebElement> openedWindows = driver.findElements(closeButton);
			int openedWindowsSize = openedWindows.size();
			System.out.println("Developer console opened windows==" + openedWindowsSize);
			int r = openedWindowsSize;
			for (int k = 1; k <= openedWindowsSize; k++) {
				try {
					driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[1]")).click();
				} catch (Exception e) {
					try {
						wait.waituntilElementIsDisplayedAndClick(okButton);
						Thread.sleep(3000);
						driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[1]")).click();
					} catch (Exception e1) {
						driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[" + r-- + "]")).click();
					}
				}
			}
			try {
				wait.waituntilElementIsDisplayedAndClick(queryEditor);
			} catch (Exception e) {
				wait.waituntilElementIsDisplayedAndClick(okButton);
				Thread.sleep(5000);
				wait.waituntilElementIsDisplayedAndClick(queryEditor);
			}
			try {
				wait.waituntilElementIsDisplayedAndClick(queryEditorInput);
				webaction.element().textBox().clear(queryEditorInput);
			} catch (Exception e) {
				wait.waituntilElementIsDisplayedAndClick(okButton);
				Thread.sleep(5000);
				wait.waituntilElementIsDisplayedAndClick(queryEditorInput);
				webaction.element().textBox().clear(queryEditorInput);
			}
			webaction.element().textBox().sendKeys(queryEditorInput, loadedQuery);
			wait.waituntilElementIsDisplayedAndClick(executeforqueryeditor);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			String numofRows = wait.waitUntilElementFound(noofRows, 10).getText();
			System.out.println("No of Rows=" + numofRows);
			wait.waitUntilElementFound(debug, 30);
			// wait.waituntilElementIsDisplayedAndClick(debug);
			// wait.waituntilElementIsDisplayedAndClick(openWindow);
			// wait.waitForPageLoaded();
			// wait.waitUntilElementFound(queryInput, 10);
			// wait.waituntilElementIsDisplayedAndClick(button);
			// wait.waitForPageLoaded();
			// Thread.sleep(5000);
			// Actions action = new Actions(driver);
			// Set<String> windows1 = webaction.browser().getWindowHandles();
			// System.out.println("No of windows size=" + windows1.size());
			// webaction.browser().switchToWindowHandle((String)
			// windows1.toArray()[windows1.size()
			// - 1]);
			// String title = driver.getTitle();
			// System.out.println("Title=" + title);
			// WebElement ele =
			// driver.findElement(By.xpath("//div[@class='CodeMirror-lines']"));
			// action.moveToElement(ele);
			// action.click();
			// Thread.sleep(5000);
			// action.sendKeys(runQuery);
			// action.build().perform();
			// wait.waituntilElementIsDisplayedAndClick(execute);
			// wait.waitForPageLoaded();
			// Thread.sleep(15000);
			// wait.waitUntilElementDisappear(execute, 10);
			// driver.close();
			// driver.switchTo().window(mainwindow);
			for (int i = 1; i <= 10; i++) {
				usage.ratingUsages(ReadPropertyFile.readPropertyFile(file, "strDate"),
						ReadPropertyFile.readPropertyFile(file, "endDate"));
			}
			wait.waitUntilElementFound(queryEditor, 15);
			try {
				wait.waituntilElementIsDisplayedAndClick(queryEditor);
				webaction.element().textBox().clear(queryEditorInput);
			} catch (Exception e) {
				wait.waituntilElementIsDisplayedAndClick(okButton);
				Thread.sleep(5000);
				wait.waituntilElementIsDisplayedAndClick(queryEditor);
				webaction.element().textBox().clear(queryEditorInput);
			}
			wait.waituntilElementIsDisplayedAndClick(queryEditorInput);
			webaction.element().textBox().sendKeys(queryEditorInput, ratedQuery);
			wait.waituntilElementIsDisplayedAndClick(executeforqueryeditor);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			String numofRowsafterexecute = wait.waitUntilElementFound(noofRows2, 10).getText();
			System.out.println("No of Rows After Execute=" + numofRowsafterexecute);
			driver.close();
			driver.switchTo().window(firstWindow);
			status = "Pass";
			tcIsCompleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = "Fail";
			extent.info("Rating was not done", MediaEntityBuilder.createScreenCaptureFromBase64String(
					ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver))).build());
		}
		String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
		return exeStatus;
	}

	@SuppressWarnings("deprecation")
	public String bulkInvoicingGeneration(int i, String filepath, String sceName) throws IOException {
		List<Boolean> tcResult = new ArrayList<Boolean>();
		boolean tcIsCompleted = false;
		@SuppressWarnings("unused")
		String status1 = "";
		By LocScroll = By.xpath("//label[text()='Quote Id']/..//input");
		try {
			Random r = new Random();
			int no = r.nextInt(1000);
			// String invRunName = "Bulk Invoice Run VOS 360-NonMRR";
			String date1 = ReadPropertyFile.readPropertyFile(file, "strDate");
			java.sql.Date strDate = Date.valueOf(date1);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMM");
			String monthformat = dateFormat.format(strDate);
			int year = (strDate).getYear();
			int year1 = year + 1900;
			invrunName = no + "-" + invoiceRunName + "-" + monthformat + "-" + year1;
			account.userLogin(ReadPropertyFile.readPropertyFile(file, "SalesOpsUser"));
			wait.waitUntilElementFound(account.userlogout, 30);
			Thread.sleep(5000);
			wait.waitUntilElementFound(searchIcon, 15);
			wait.waituntilElementIsDisplayedAndClick(searchIcon);
			wait.waitUntilElementFound(searchInput, 10);
			webaction.element().textBox().sendKeys(searchInput, invoiceRun);
			Thread.sleep(3000);
			webaction.element().textBox().sendKeys(searchInput, Keys.ENTER);
			wait.waitForPageLoaded();
			Thread.sleep(7000);
			wait.waitUntilElementFound(invCreation.newButton, 5);
			wait.waituntilElementIsDisplayedAndClick(invCreation.newButton);
			wait.waitForPageLoaded();
			Thread.sleep(10000);
			wait.elementWait(invCreation.runIframe, 20);
			webaction.browser().switchToFrame(invCreation.runIframe);
			Thread.sleep(7000);
			wait.waitUntilElementFound(invCreation.invoiceRunName, 5);
			wait.waituntilElementIsDisplayedAndClick(invCreation.invoiceRunName);
			webaction.element().textBox().sendKeys(invCreation.invoiceRunName, invrunName);
			wait.waituntilElementIsDisplayedAndClick(invCreation.invoiceOverridetemp);
			webaction.browser().scroll().scrollintoview(invCreation.invoiceOverrideSelect(invoiceOverrideTemplate));
			wait.waituntilElementIsDisplayedAndClick(invCreation.invoiceOverrideSelect(invoiceOverrideTemplate));
			webaction.browser().scroll().scrollintoview(accountTab);
			wait.waituntilElementIsDisplayedAndClick(accountTab);
			wait.waituntilElementIsDisplayedAndClick(accField1);
			webaction.browser().scroll().scrollintoview(accountSelect(accountField1));
			wait.waituntilElementIsDisplayedAndClick(accountSelect(accountField1));
			wait.waituntilElementIsDisplayedAndClick(accOperator1);
			wait.waituntilElementIsDisplayedAndClick(invCreation.eqaltoSelect(accountOperator1));
			wait.waituntilElementIsDisplayedAndClick(accValue1);
			webaction.element().textBox().sendKeys(accValue1, accountValue1);
			wait.waituntilElementIsDisplayedAndClick(accField2);
			webaction.browser().scroll().scrollintoview(accountSelect1(accountField2));
			wait.waituntilElementIsDisplayedAndClick(accountSelect1(accountField2));
			wait.waituntilElementIsDisplayedAndClick(accOperator2);
			wait.waituntilElementIsDisplayedAndClick(eqaltoSelect1(accountOperator2));
			wait.waituntilElementIsDisplayedAndClick(accValue2);
			webaction.element().textBox().sendKeys(accValue2, accountValue2);
			wait.waituntilElementIsDisplayedAndClick(invCreation.billingSchedule);
			wait.waituntilElementIsDisplayedAndClick(billingschField1);
			webaction.browser().scroll().scrollintoview(accountSelect(billingScheduleField1));
			wait.waituntilElementIsDisplayedAndClick(accountSelect(billingScheduleField1));
			wait.waituntilElementIsDisplayedAndClick(billingschOperator1);
			webaction.browser().scroll().scrollintoview(eqaltoSelect2(billingScheduleOperator1));
			wait.waituntilElementIsDisplayedAndClick(eqaltoSelect2(billingScheduleOperator1));
			wait.waituntilElementIsDisplayedAndClick(billingschValue1);
			webaction.element().textBox().sendKeys(billingschValue1,
			ReadPropertyFile.readPropertyFile(file, "strDate"));
			wait.waituntilElementIsDisplayedAndClick(billingschField2);
			webaction.browser().scroll().scrollintoview(periodEndDateSelect(billingScheduleField2));
			wait.waituntilElementIsDisplayedAndClick(periodEndDateSelect(billingScheduleField2));
			wait.waituntilElementIsDisplayedAndClick(billingschOperator2);
			webaction.browser().scroll().scrollintoview(eqaltoSelect4(billingScheduleOperator2));
			wait.waituntilElementIsDisplayedAndClick(eqaltoSelect4(billingScheduleOperator2));
			wait.waituntilElementIsDisplayedAndClick(billingschValue2);
			webaction.element().textBox().sendKeys(billingschValue2,
			ReadPropertyFile.readPropertyFile(file, "endDate"));
			wait.waituntilElementIsDisplayedAndClick(billingschField3);
			webaction.browser().scroll().scrollintoview(MRRSelect(billingScheduleField3));
			wait.waituntilElementIsDisplayedAndClick(MRRSelect(billingScheduleField3));
			wait.waituntilElementIsDisplayedAndClick(billingschOperator3);
			wait.waituntilElementIsDisplayedAndClick(eqaltoSelect6(billingScheduleOperator3));
			wait.waituntilElementIsDisplayedAndClick(billingschValue3);
			webaction.element().textBox().sendKeys(billingschValue3, billingScheduleValue3);
			wait.waituntilElementIsDisplayedAndClick(add);
			wait.waituntilElementIsDisplayedAndClick(billingschField4);
			webaction.browser().scroll().scrollintoview(productLineSelect(billingScheduleField4));
			wait.waituntilElementIsDisplayedAndClick(productLineSelect(billingScheduleField4));
			wait.waituntilElementIsDisplayedAndClick(billingschOperator4);
			wait.waituntilElementIsDisplayedAndClick(eqaltoSelect7(billingScheduleOperator4));
			wait.waituntilElementIsDisplayedAndClick(billingschValue4);
			webaction.element().textBox().sendKeys(billingschValue4, billingScheduleValue4);
			if (!sceName.equalsIgnoreCase("Bulk_Invoice_SW_Capacity")
					&& !sceName.equalsIgnoreCase("Bulk_Invoice_ServiceMRR")) {
				wait.waituntilElementIsDisplayedAndClick(add);
				wait.waituntilElementIsDisplayedAndClick(billingschField5);
				webaction.browser().scroll().scrollintoview(orderTerminateSelect(billingScheduleField5));
				wait.waituntilElementIsDisplayedAndClick(orderTerminateSelect(billingScheduleField5));
				wait.waituntilElementIsDisplayedAndClick(billingschOperator5);
				wait.waituntilElementIsDisplayedAndClick(eqaltoSelect8(billingScheduleOperator5));
				wait.waituntilElementIsDisplayedAndClick(billingschValue5);
				webaction.element().textBox().sendKeys(billingschValue5, billingScheduleValue5);
			}
			webaction.browser().scroll().scrollintoview(invCreation.invoiceDatetype);
			wait.waituntilElementIsDisplayedAndClick(invCreation.invoiceDatetype);
			wait.waituntilElementIsDisplayedAndClick(invCreation.invoiceDateTypeSelect(invoiceDataType));
			wait.waituntilElementIsDisplayedAndClick(invCreation.processthroDate);
			webaction.element().textBox().sendKeys(invCreation.processthroDate,
					ReadPropertyFile.readPropertyFile(file, "processThroughDate"));
			webaction.element().click().by(invCreation.runButton);
			wait.waitForPageLoaded();
			Thread.sleep(20000);
			try {
				wait.waitUntilElementFound(invCreation.runIframe, 20);
				webaction.browser().switchToFrame(invCreation.runIframe);
				Thread.sleep(5000);
			} catch (Exception e) {
			}
			try {
				wait.waitUntilElementFound(invCreation.relatedforinv, 15);
				wait.waituntilElementIsDisplayedAndClick(invCreation.relatedforinv);
				Thread.sleep(5000);

			} catch (Exception e) {
			}
			try {
				webaction.browser().switchToDefault();
			} catch (Exception e) {
				extent.info("Target frame detach" + e.getMessage());
			}
			for (int m = 0; m < 60; m++) {
				webaction.browser().refresh();
				wait.waitForPageLoaded();
				Thread.sleep(7000);

				try {
					wait.waitUntilElementFound(invCreation.runIframe, 20);
					webaction.browser().switchToFrame(invCreation.runIframe);
					Thread.sleep(5000);
				} catch (Exception e) {
				}
				try {
					wait.waitUntilElementFound(invCreation.relatedforinv, 15);
					wait.waituntilElementIsDisplayedAndClick(invCreation.relatedforinv);
					Thread.sleep(5000);

				} catch (Exception e) {
				}
				try {
					webaction.browser().switchToDefault();
				} catch (Exception e) {
					extent.info("Target frame detach" + e.getMessage());
				}
				webaction.browser().switchToFrame(invCreation.runIframe);
				Thread.sleep(5000);
				String runResult = wait.waitUntilElementFound(invRunRes, 10).getText();
				if (runResult.equalsIgnoreCase("Invoice Run Results (0)"))
					continue;
				String totalInvNum = wait.waitUntilElementFound(status, 10).getText();
				int totalInvNumber = Integer.parseInt(totalInvNum);
				System.out.println("Total Invoice Number=" + totalInvNumber);
				if (totalInvNumber != 0) {
					break;
				} else {
					continue;
				}
			}
			try {
				webaction.browser().switchToDefault();
				wait.waitUntilElementFound(invCreation.runIframe, 20);
				webaction.browser().switchToFrame(invCreation.runIframe);
				webaction.element().click().by(invCreation.invoiceNumlink);
			} catch (Exception e) {

			}
			try {
				webaction.browser().switchToDefault();
			} catch (Exception e) {
				extent.info("Target frame detach" + e.getMessage());
			}
			Thread.sleep(10000);
			webaction.browser().scroll().scrollToBottom();
			wait.waitUntilElementFound(viewAll, 55);
			webaction.element().click().jsClick(viewAll);
			wait.waitForPageLoaded();
			Thread.sleep(5000);
			wait.waituntilElementIsDisplayedAndClick(invCreation.filterButton);

			for (int x = 0; x < locationList.size(); x++) {
				HashMap<String, String> data = excelUtils.readData(filepath, invSheetName, x + 1, 5);
				String adjst = data.get("Adjustments");
				adjustmentAmt = 0.0;
				if (!adjst.equals("NA")) {
					String[] adj = adjst.split(" ");
					String adjt = adj[1];
					if (adjt.contains(",")) {
						adjt = adjt.replace(",", "");
					}
					if (adjt.contains("-")) {
						adjt = adjt.replace("-", "");
					}
					adjustmentAmt = Double.parseDouble(adjt);
				}
				try {
					String accLoc = locationList.get(x);
					String amount = amountList.get(x);
					String[] amt = amount.split(" ");
					String actAmt = amt[1];
					if (actAmt.contains(",")) {
						actAmt = actAmt.replace(",", "");
					}
					dactTotInvAmt = Double.parseDouble(actAmt);
					// wait.waitForPageLoaded();
					try {
					wait.waituntilElementIsDisplayedAndClick(locationName);
					}catch(Exception e) {
						webaction.browser().scroll().scrollintoview(locationName);
					}
					try {
						webaction.element().textBox().clear(locationName);
					}catch(Exception e) {
						webaction.browser().scroll().scrollintoview(LocScroll);
						webaction.element().textBox().clear(locationName);
					}
					wait.waituntilElementwritable(locationName, accLoc);
					wait.waituntilElementIsDisplayedAndClick(invCreation.apply);
					wait.waitForPageLoaded();
					Thread.sleep(5000);
					wait.waitUntilElementFound(cancel, 15);
					String accountLoc = driver
                            .findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[1]/td[4])[2]//a")).getAttribute("title");
                    System.out.println("Account Location ==" + accountLoc);
                    excelUtils.setCellData(invSheetName, filepath, "Expected Account Location", x + 1,
                            accountLoc);
					WebElement primaryProduct = driver
							.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[1]/td[6])[2]"));
					String primaryProductLine1 = primaryProduct.getText();
					System.out.println("Primary Product Line ==" + primaryProductLine1);
					excelUtils.setCellData(invSheetName, filepath, "Expected Primary Product line", x + 1,
							primaryProductLine1);
					WebElement totalforInv = driver
							.findElement(By.xpath("(//*[@id='brandBand_2']//table/tbody/tr[1]/td[11])[2]"));
					expectedtotalForInvoice = totalforInv.getText();
					System.out.println("Total For This Invoice ==" + expectedtotalForInvoice);
					excelUtils.setCellData(invSheetName, filepath, "Expected Total for this Invoice", x + 1,
							expectedtotalForInvoice);
					String[] expAmount = expectedtotalForInvoice.split(" ");
					String expAmt = expAmount[1];
					if (expAmt.contains(",")) {
						expAmt = expAmt.replace(",", "");
					}
					dexpTotInvAmt = Double.parseDouble(expAmt);
					if (adjustmentAmt != 0.0) {
						dexpTotInvAmt = +adjustmentAmt;
					}
					if (dactTotInvAmt == dexpTotInvAmt) {
						System.out.println("Validation success");
						excelUtils.setCellData(invSheetName, filepath, "Status", x + 1, "Pass");
					} else {
						System.out.println("Validation failed");
						excelUtils.setCellData(invSheetName, filepath, "Status", x + 1, "Fail");
					}

				} catch (Exception e) {
					e.printStackTrace();
					excelUtils.setCellData(invSheetName, filepath, "Status", x + 1,
							"Order end date was completed or Ever green order billing schedules created for 2 months only");
					continue;
				}

			}
			bulkInvoiceCancellation1(i, filepath, sceName);
			for (int j = 1; j <= 6; j++) {
				usage.unRateUsages(ReadPropertyFile.readPropertyFile(file, "strDate"),
						ReadPropertyFile.readPropertyFile(file, "endDate"));
				Thread.sleep(5000);
			}
			status1 = "Pass";
			tcIsCompleted = true;
		} catch (Exception e) {
			e.printStackTrace();
			status1 = "Fail";
			extent.fail("invoice generation failed", MediaEntityBuilder.createScreenCaptureFromBase64String(
					ExtentReportUtil.encodeFileToBase64Binary(s.saveScreenShot(driver))).build());
		}
		String exeStatus = (!(tcResult.contains(false) || tcIsCompleted == false)) ? "Pass" : "Fail";
		return exeStatus;
	}

	public void getUsages(List<String> quoteIds, String filepath, String sceName) {
        try {
        	By userLogout = By.xpath("//a[contains(text(),'Log out as Sales Ops 2')]");
            StringBuilder sb = new StringBuilder();
            wait.waituntilElementIsDisplayedAndClick(userLogout);
            Thread.sleep(5000);
            wait.waitUntilElementDisappear(userLogout, 20);
            for (int p = 0; p < quoteIds.size(); p++) {

                String quoteIdList = "'" + quoteIds.get(p) + "'" + ",";
                sb.append(quoteIdList);

            }
            sb.deleteCharAt(sb.length() - 1);
            String quotes = sb.toString();
            sourceMnthUsagesQuery =
                "select Id,Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__c,Apttus_Billing__Description__c,Apttus_Billing__Status__c, Apttus_Billing__Quantity__c, Apttus_Billing__StartDate__c, Apttus_Billing__EndDate__c, LastModifiedDate, LastModifiedBy.Name, Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__r.Apttus_QPConfig__LocationId__r.name, Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__r.APTS_B_Reference_Account__r.name from Apttus_Billing__UsageInput__c where Apttus_Billing__Quantity__c >0 and Apttus_Billing__StartDate__c >= " +
                					ReadPropertyFile.readPropertyFile(file, "SourcestrDate") +
                					" and Apttus_Billing__EndDate__c <= "+ ReadPropertyFile.readPropertyFile(file,"SourceendDate") + 
                					" and APTS_B_Usage_Status__c ='Completed' and Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__c in (" +
                                    quotes + ")";
            targetMnthUsagesQuery =
                "select Id,Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__c,Apttus_Billing__Description__c,Apttus_Billing__Status__c, Apttus_Billing__Quantity__c, Apttus_Billing__StartDate__c, Apttus_Billing__EndDate__c, LastModifiedDate, LastModifiedBy.Name, Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__r.Apttus_QPConfig__LocationId__r.name, Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__r.APTS_B_Reference_Account__r.name from Apttus_Billing__UsageInput__c where Apttus_Billing__Quantity__c >0 and Apttus_Billing__StartDate__c >= " +
                                    ReadPropertyFile.readPropertyFile(file, "strDate") +
                                    " and Apttus_Billing__EndDate__c <= " + ReadPropertyFile.readPropertyFile(file,
                                                                                                              "endDate") +
                                    "and APTS_B_Usage_Status__c ='Completed' and Apttus_Billing__AssetLineItemId__r.Apttus_QPConfig__ProposalId__c in (" +
                                    quotes + ")";

            wait.waitUntilElementFound(account.setup, 30);
            wait.waituntilElementIsDisplayedAndClick(account.setup);
            Thread.sleep(5000);
            wait.waituntilElementIsDisplayedAndClick(developerConsole);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            Set<String> windows = webaction.browser().getWindowHandles();
            System.out.println("Size of windows=" + windows.size());
            webaction.browser().switchToWindowHandle((String) windows.toArray()[windows.size() - 1]);
            String mainwindow = driver.getWindowHandle();
            wait.waitUntilElementFound(queryEditor, 50);
            driver.manage().window().maximize();
            try {
                wait.waituntilElementIsDisplayedAndClick(okButton);
                Thread.sleep(5000);
            } catch (Exception e) {

            }
            List<WebElement> openedWindows = driver.findElements(closeButton);
            int openedWindowsSize = openedWindows.size();
            System.out.println("Developer console opened windows==" + openedWindowsSize);
            int r = openedWindowsSize;
            for (int k = 1; k <= openedWindowsSize; k++) {

                try {
                    driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[1]")).click();
                } catch (Exception e) {
                    try {
                        wait.waituntilElementIsDisplayedAndClick(okButton);
                        Thread.sleep(3000);
                        driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[1]")).click();
                    } catch (Exception e1) {
                        driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[" + r-- + "]")).click();
                    }

                }
            }
            try {
                wait.waituntilElementIsDisplayedAndClick(queryEditor);
            } catch (Exception e) {
                wait.waituntilElementIsDisplayedAndClick(okButton);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(queryEditor);
            }
            try {
                wait.waituntilElementIsDisplayedAndClick(queryEditorInput);
                webaction.element().textBox().clear(queryEditorInput);
            } catch (Exception e) {
                wait.waituntilElementIsDisplayedAndClick(okButton);
                Thread.sleep(5000);
                wait.waituntilElementIsDisplayedAndClick(queryEditorInput);
                webaction.element().textBox().clear(queryEditorInput);
            }
            webaction.element().textBox().sendKeys(queryEditorInput, targetMnthUsagesQuery);
            // webaction.element().textBox().sendKeys(queryEditorInput, usagesQuery);
            wait.waituntilElementIsDisplayedAndClick(executeforqueryeditor);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
            List<WebElement> tables = driver.findElements(By.xpath("//div[@id='editors-body']/div"));
            int x=tables.size();
            System.out.println(x);
            String que="(//div[@id='editors-body']/div)";
            String que1=  "//span[contains(text(), 'Query Results - ')]";
            By noofRows4=By.xpath(que + "["+x+"]" + que1 );
              String numofRows = wait.waitUntilElementFound(noofRows4, 10).getText();
              System.out.println("No of Rows=" + noofRows4);
              String usages = numofRows.replaceAll("Query Results - Total Rows:", "").trim();
              int usagesRows = Integer.parseInt(usages);
             wait.waitUntilElementFound(debug, 30);
              for (int n = 2; n <= usagesRows + 1; n++) {
                for (int f = 1; f <= 10; f++) {
                    String data = driver.findElement(By.xpath(
                                                              "//div[@id='editors-body']//table[@class='x-grid-table x-grid-table-resizer']//tr[" +
                                                              n + "]//td[" + f + "]")).getText();
                    System.out.println("Usages data==" + data);
                    ExcelUtils.writeData(usagesSheetName, filepath, data, f - 1, n - 1);
                }

             }
              List<WebElement> openedWindows1 = driver.findElements(closeButton);
              int openedWindowsSize1 = openedWindows1.size();
              System.out.println("Developer console opened windows==" + openedWindowsSize1);
              int r1 = openedWindowsSize1;
              for (int k = 1; k <= openedWindowsSize1; k++) {

                  try {
                      driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[1]")).click();
                  } catch (Exception e) {
                      try {
                          wait.waituntilElementIsDisplayedAndClick(okButton);
                          Thread.sleep(3000);
                          driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[1]")).click();
                      } catch (Exception e1) {
                          driver.findElement(By.xpath("(//a[contains(@class, 'x-tab-close-btn')])[" + r1-- + "]")).click();
                      }

                  }
              }
              try {
                  wait.waituntilElementIsDisplayedAndClick(queryEditor);
              } catch (Exception e) {
                  wait.waituntilElementIsDisplayedAndClick(okButton);
                  Thread.sleep(5000);
                  wait.waituntilElementIsDisplayedAndClick(queryEditor);
              }
              try {
                  wait.waituntilElementIsDisplayedAndClick(queryEditorInput);
                  webaction.element().textBox().clear(queryEditorInput);
              } catch (Exception e) {
                  wait.waituntilElementIsDisplayedAndClick(okButton);
                  Thread.sleep(5000);
                  wait.waituntilElementIsDisplayedAndClick(queryEditorInput);
                  webaction.element().textBox().clear(queryEditorInput);
              }
            webaction.element().textBox().sendKeys(queryEditorInput, sourceMnthUsagesQuery);
            wait.waituntilElementIsDisplayedAndClick(executeforqueryeditor);
            wait.waitForPageLoaded();
            Thread.sleep(5000);
       
        List<WebElement> tables1 = driver.findElements(By.xpath("//div[@id='editors-body']/div"));
            int y=tables1.size();
            System.out.println(y);
            String que2="(//div[@id='editors-body']/div)";
            String que3=  "//span[contains(text(), 'Query Results - ')]";
            By noofRows3=By.xpath(que2 + "["+y+"]" + que3 );
            System.out.println(noofRows3);
            String numofRows1 = wait.waitUntilElementFound(noofRows3, 10).getText();
            System.out.println("No of Rows=" + numofRows1);
            String usages1 = numofRows1.replaceAll("Query Results - Total Rows:", "").trim();
            int usagesRows1 = Integer.parseInt(usages1);
            wait.waitUntilElementFound(debug, 30);
            for (int n = 2; n <= usagesRows1 + 1; n++) {
              for (int f = 1; f <= 10; f++) {
                  String data = driver.findElement(By.xpath(
                                                            "//div[@id='editors-body']//table[@class='x-grid-table x-grid-table-resizer']//tr[" +
                                                            n + "]//td[" + f + "]")).getText();
                  System.out.println("Usages data==" + data);
                  ExcelUtils.writeData(usagesSheetName1, filepath, data, f - 1, n - 1);
              }

          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void trial() throws InterruptedException
	{
		
		Thread.sleep(5000);
		wait.waitUntilElementFound(account.setup, 15);
		wait.waituntilElementIsDisplayedAndClick(account.setup);
		wait.waituntilElementIsDisplayedAndClick(account.setupgear);
		wait.waitForPageLoaded();
		//MAIN OUTSIDE UI
		Set<String> windows = webaction.browser().getWindowHandles();
		webaction.browser().switchToWindowHandle((String) windows.toArray()[1]);
		String mainwindow = driver.getWindowHandle();
		Thread.sleep(5000);
		wait.waitUntilElementFound(account.setup, 30);
        wait.waituntilElementIsDisplayedAndClick(account.setup);
        Thread.sleep(5000);
        wait.waituntilElementIsDisplayedAndClick(developerConsole);
        wait.waitForPageLoaded();
        Thread.sleep(5000);
        //DEVELOPER CONSOLE UI
        Set<String> windows1 = webaction.browser().getWindowHandles();
        System.out.println("Size of windows=" + windows1.size());
        webaction.browser().switchToWindowHandle((String) windows1.toArray()[windows1.size() - 1]);
        wait.waituntilElementIsDisplayedAndClick(debug);
		 wait.waituntilElementIsDisplayedAndClick(openWindow);
		 wait.waitForPageLoaded();
		 wait.waitUntilElementFound(queryInput, 10);
		 wait.waituntilElementIsDisplayedAndClick(button);
		 wait.waitForPageLoaded();
		 Thread.sleep(5000);
		 Actions action = new Actions(driver);
			 String title = driver.getTitle();
			 System.out.println("Title=" + title);
			 WebElement ele =
			 driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']"));
			 wait.waitUntilElementFound(ele, 5);
			 webaction.element().click().jsClick(By.xpath("//div[@class='CodeMirror-scroll']"));
			//	wait.waituntilElementIsDisplayedAndClick(ele);
			//	webaction.element().textBox().clear(ele);
				wait.waituntilElementwritable(ele, "123145");
			 //action.moveToElement(ele);
			// action.click();
			// wait.waitUntilElementFound(ele, 5).clear();
			 Thread.sleep(5000);
//			 action.sendKeys("asdnkjbnksadasd");
//			 action.build().perform();
//			 action.
			// wait.waituntilElementIsDisplayedAndClick(execute);
			 wait.waitForPageLoaded();
			 Thread.sleep(15000);
			 wait.waitUntilElementDisappear(execute, 10);
			 driver.close();
			 driver.switchTo().window(mainwindow);
		 Set<String> windows2 = webaction.browser().getWindowHandles();
		 webaction.browser().switchToWindowHandle((String)windows2.toArray()[windows2.size()- 1]);
		 driver.close();
		 driver.switchTo().window(mainwindow);
		 
		 
        
	}
	
}
