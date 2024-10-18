package com.framework.apiautomation.test;

import java.io.File;
import com.Forsys.utils.ReadPropertyFile;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Forsys.ui.actions.Waits;
import com.Forsys.ui.actions.WebActions;
import com.Forsys.uidriver.UIBaseTest;
import com.Forsys.utils.ExcelUtils;
import com.Forsys.utils.Pom.OpportunityCreation1;
import com.Forsys.utils.Pom.OrderActivation;
import com.Forsys.utils.Pom.PomClasses;
import com.Forsys.utils.Pom.QuoteCreation1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VOS360_CancellingInvoices extends UIBaseTest {
	WebActions webaction;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFSheet sheet1;
	Waits wait;
	File srcFile;
	WebDriver driver;
	String filepath;
	String InvoicesSheetName;
	String invoicenumber;
	int i;
	int j;
	ExcelUtils excelUtilities;
	String file = System.getProperty("propertyFile");

	@Test
	public void VOS360_45days_Logic_CRM_5605_StageOne() {
		try {
			filepath = System.getProperty("user.dir") + "/ExcelData/Invoice.xlsx";
			InvoicesSheetName = "INVOICES";
			srcFile = new File(filepath);
			fis = new FileInputStream(srcFile);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheet(InvoicesSheetName);
			int invcolumns = 1;
			
			
			By cancelInvoice=By.xpath("//span[contains(text(),'Cancel Invoice')]//parent::div//following-sibling::div//a");
			By cancelInvoiceButton=By.xpath("//input[@value='Cancel Invoice'][1]");
			By configureFrame = By.xpath("//div[contains(@class,'active lafPageHost')]//iframe[@title='accessibility title']");
			
			
			if (System.getProperty("os.name").toLowerCase().contains("win")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-notifications");
				options.addArguments("--no-sandbox");
				options.addArguments("--remote-debugging-port=9222");
				options.setBinary("/usr/bin/google-chrome");
				driver = new ChromeDriver(options);
			}
			PomClasses p = new PomClasses(driver);
			this.webaction = new WebActions(driver);
			this.wait = new Waits(driver);
			excelUtilities = new ExcelUtils();
			int totalRows = sheet.getPhysicalNumberOfRows();
			System.out.println("Total number of Excel rows are :" + totalRows);
			
			
			p.loginuser().launchURl();
			sheet = wb.getSheet(InvoicesSheetName);
			for (i = 1; i < totalRows; i++) {
				
	
				HashMap<String, String> invoiceCancelation = excelUtilities.readData(filepath, InvoicesSheetName, i, invcolumns);
				this.invoicenumber=invoiceCancelation.get("Id");
				String invurl = ReadPropertyFile.readPropertyFile(file, "InvoiceUrl") + invoicenumber + "/view";
				webaction.browser().goToUrl(invurl);
				wait.waitForPageLoaded();
				Thread.sleep(2000);
				webaction.browser().scroll().scrollPage("0", "600");
				wait.waituntilElementIsDisplayedAndClick(cancelInvoice);
				wait.waitForPageLoaded();
				Thread.sleep(1000);
				webaction.browser().switchToFrame(configureFrame);
				wait.waituntilElementIsDisplayedAndClick(cancelInvoiceButton);
				wait.waitForPageLoaded();
				Thread.sleep(1000);
				}
				
			
			
		} catch (Exception e) {
			System.out.println("VOS360_StageOne test failed: " + e.getMessage());
			e.printStackTrace(System.out);
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}
