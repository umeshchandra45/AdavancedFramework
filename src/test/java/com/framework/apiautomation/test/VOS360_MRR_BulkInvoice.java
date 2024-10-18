package com.framework.apiautomation.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Forsys.hub.HubUsage;
import com.Forsys.ui.actions.WebActions;
import com.Forsys.utils.ExcelUtils;
import com.Forsys.utils.ReadPropertyFile;
import com.Forsys.utils.Pom.BulkInvoice;
import com.Forsys.utils.Pom.PomClasses;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VOS360_MRR_BulkInvoice {

    BulkInvoice bulkInvoice;
    ExcelUtils excelUtilities;
    private WebDriver driver;
    WebActions webaction;
    FileInputStream fis;
    FileOutputStream fos;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    File srcFile;
    String filepath;
    String scenarioName;
    int i;
    String invSheetName;
    String result;
    String file = System.getProperty("propertyFile");

    @Test
    public void bulkInvoice_Generation_VOS360MRR() {

        try {
            String date1 = ReadPropertyFile.readPropertyFile(file, "strDate");
            String date2 = ReadPropertyFile.readPropertyFile(file, "endDate");
            java.sql.Date strDate = Date.valueOf(date1);
            java.sql.Date endDate = Date.valueOf(date2);
            filepath = System.getProperty("user.dir") + "/ExcelData/Bulk Invoice Generation.xlsx";
            invSheetName = "Bulk_Invoicing_VOS360_MRR";
            srcFile = new File(filepath);
            fis = new FileInputStream(srcFile);
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(invSheetName);
            scenarioName = "Bulk_Invoice_VOS360_MRR";
            System.out.println(System.getProperty("os.name"));
            int bulkColumns = 28;
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                options.addArguments("--no-sandbox");
                options.addArguments("--remote-debugging-port=9222");
                options.setBinary("/usr/bin/google-chrome");
                driver = new ChromeDriver(options);
                driver.manage().deleteAllCookies();
            }
            PomClasses p = new PomClasses(driver);
            bulkInvoice = new BulkInvoice(driver);
            excelUtilities = new ExcelUtils();
            HubUsage hubUsage = new HubUsage();
            int totalRows = sheet.getPhysicalNumberOfRows();
            System.out.println("Total number of Excel rows are :" + totalRows);

            for (i = 1; i < totalRows; i++) {
                p.loginuser().launchURl();
                HashMap<String, String> bulkInvCreation = excelUtilities.readData(filepath,
                                                                                  invSheetName,
                                                                                  i,
                                                                                  bulkColumns);

                List<String> quoteList = bulkInvoice.quoteIdList(bulkInvCreation, i, filepath, scenarioName);
                result = hubUsage.generateUsageInputInBatch(quoteList,
                                                            strDate,
                                                            endDate,
                                                            31);
                Assert.assertEquals(result, "Pass");
                result = bulkInvoice.bulkRating();
                Assert.assertEquals(result, "Pass");
                result = bulkInvoice.bulkInvoicingGeneration(i, filepath, scenarioName);
                Assert.assertEquals(result, "Pass");
                bulkInvoice.getUsages(quoteList, filepath, scenarioName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

    }

}
