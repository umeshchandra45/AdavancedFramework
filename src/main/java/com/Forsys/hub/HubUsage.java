package com.Forsys.hub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Forsys.hub.model.BillingInformation;
import com.Forsys.utils.ReadPropertyFile;
import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class HubUsage {
    private static final String PROPERTY_PATH = System.getProperty("propertyFile");

    private static final String HUB_USERNAME = "HubUserName";
    private static final String HUB_PASSWORD = "HubUserPassword";

    private static final String SFDC_QUOTE_SOQL = "SELECT %s, %s, %s FROM Apttus_Proposal__Proposal__c WHERE Id = '%s'";

    private static final String ACCOUNT_LOCATION = "APTS_B_Account_Location__c";
    private static final String BILLING_ACCOUNT_ID = "APTS_B_Reference_Account__c";
    private static final String ACCOUNT_ID = "Apttus_Proposal__Account__c";

    private static final String SEPARATOR = "================================";

    private Map<String, String> specialLicenses;

    private String userDir;
    private String username;
    private String password;
    private String result;

    private DateFormat dateFormat;

    private PartnerConnection partnerConnection;

    public HubUsage() {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            userDir = System.getProperty("user.dir");
            username = ReadPropertyFile.readPropertyFile(PROPERTY_PATH, HUB_USERNAME);
            password = ReadPropertyFile.readPropertyFile(PROPERTY_PATH, HUB_PASSWORD);

            ConnectorConfig config = new ConnectorConfig();
            config.setUsername(username);
            config.setPassword(password);
            partnerConnection = Connector.newConnection(config);

            specialLicenses = new HashMap<String, String>();
            specialLicenses.put("VOS360-ENC-AVC-OTT-HD-PLUS-PREM", "VOS360-ENC-AVC-OTT-HD-PLUS-PREMIUM");
            specialLicenses.put("VOS360-SSDAI", "VOS360-SSADI");
        } catch (IOException | ConnectionException e) {
            e.printStackTrace(System.out);
        }
    }

    public String generateUsageInputInBatch(List<String> quoteIds,
                                            Date startDate,
                                            Date endDate,
                                            int numOfDays) {
        try {
            for (String quoteId : quoteIds) {
                BillingInformation information = getBillingInformation(quoteId);
                triggerUsageInputUpdate(information,
                                        dateFormat.format(startDate),
                                        dateFormat.format(endDate),
                                        numOfDays);
            }
            result = "Pass";
        } catch (Exception e) {
            e.printStackTrace();
            result = "Fail";
        }
        return result;
    }

    private BillingInformation getBillingInformation(String quoteId) throws IOException, ConnectionException {
        QueryResult result = partnerConnection.query(String.format(SFDC_QUOTE_SOQL,
                                                                   ACCOUNT_LOCATION,
                                                                   ACCOUNT_ID,
                                                                   BILLING_ACCOUNT_ID,
                                                                   quoteId));
        BillingInformation information = new BillingInformation();
        information.setAccountId((String) result.getRecords()[0].getField(ACCOUNT_ID));
        information.setBillingAccountId((String) result.getRecords()[0].getField(BILLING_ACCOUNT_ID));
        information.setAccountLocationId((String) result.getRecords()[0].getField(ACCOUNT_LOCATION));
        return information;
    }

    private void triggerUsageInputUpdate(BillingInformation information,
                                         String startDate,
                                         String endDate,
                                         int numOfDays)
        throws IOException,
        InterruptedException {
        String command = "node \"" + userDir + String.format(
                                                             "/src/main/resources/hub/generateUsageInput.js\" %s %s %s %s %s %s %s %d",
                                                             username,
                                                             password,
                                                             information.getAccountId(),
                                                             information.getBillingAccountId(),
                                                             information.getAccountLocationId(),
                                                             startDate,
                                                             endDate,
                                                             numOfDays);

        System.out.println("Running command: " + command);

        ProcessBuilder processBuilder = new ProcessBuilder();
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            processBuilder.command("cmd.exe", "/c", command);
        } else {
            processBuilder.command("bash", "-c", command);
        }

        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        System.out.println(SEPARATOR + " RESULT " + SEPARATOR);
        if (process.waitFor() == 0) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
        System.out.println(SEPARATOR + " START OF LOG " + SEPARATOR);
        System.out.println(output);
        System.out.println(SEPARATOR + " END OF LOG " + SEPARATOR);
    }

    public void unRateUsages(String startDate, String endDate)
        throws IOException,
        InterruptedException {
        String command = "node \"" + userDir + String.format(
                                                             "/src/main/resources/hub/unRate.js\" %s %s",
                                                             startDate,
                                                             endDate);

        System.out.println("Running command line: " + command);

        ProcessBuilder processBuilder = new ProcessBuilder();
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            processBuilder.command("cmd.exe", "/c", command);
        } else {
            processBuilder.command("bash", "-c", command);
        }

        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        System.out.println(SEPARATOR + " RESULT " + SEPARATOR);
        if (process.waitFor() == 0) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
        System.out.println(SEPARATOR + " START OF LOG " + SEPARATOR);
        System.out.println(output);
        System.out.println(SEPARATOR + " END OF LOG " + SEPARATOR);
    }

    public void ratingUsages(String startDate, String endDate)
        throws IOException,
        InterruptedException {
        String command = "node \"" + userDir + String.format(
                                                             "/src/main/resources/hub/Rating.js\" %s %s",
                                                             startDate,
                                                             endDate);

        System.out.println("Running command line: " + command);

        ProcessBuilder processBuilder = new ProcessBuilder();
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            processBuilder.command("cmd.exe", "/c", command);
        } else {
            processBuilder.command("bash", "-c", command);
        }

        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        System.out.println(SEPARATOR + " RESULT " + SEPARATOR);
        if (process.waitFor() == 0) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
        System.out.println(SEPARATOR + " START OF LOG " + SEPARATOR);
        System.out.println(output);
        System.out.println(SEPARATOR + " END OF LOG " + SEPARATOR);
    }
}
