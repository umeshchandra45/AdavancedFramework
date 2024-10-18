package com.Forsys.sfdc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.*;

import com.Forsys.Pojos.Account;
import com.Forsys.Pojos.Address;
import com.Forsys.Pojos.Contact;
import com.Forsys.Pojos.Opportunity;
import com.Forsys.SFDCEnum.AccountIndustry;
import com.Forsys.SFDCEnum.Locale;
import com.Forsys.SFDCEnum.SalesforceAccountType;
import com.Forsys.utils.RandomUtils;

public class SFDCHelper {
    private SfdcClient client;
    Locale SalesforceLocale;
    public String OwnerEmail = "";

    public SFDCHelper(SfdcClient client, Locale locale) {
        this.client = client;
        SalesforceLocale = locale;
    }

    public Account setAccount(SalesforceAccountType accountType, String ownerEmailId) {
        Address address = setAddress();
        if (ownerEmailId == null || ownerEmailId.trim().isEmpty()) {
            ownerEmailId = OwnerEmail;
        }
        Account account = new Account();

        account.Name = address.Name + "-Account";
        account.BillingStreet = address.BillingStreet;
        account.BillingCity = address.BillingCity;
        account.BillingState = address.BillingState;
        account.BillingPostalCode = address.BillingZip;
        account.BillingCountry = address.BillingCountry;
        account.Phone = address.BillingPhone;
        account.ShippingStreet = address.ShippingStreet;
        account.ShippingCity = address.ShippingCity;
        account.ShippingState = address.ShippingState;
        account.ShippingPostalCode = address.ShippingPostalCode;
        account.ShippingCountry = address.ShippingCountry;
        account.CurrencyIsoCode = address.CurrencyCode;
        account.DocuSign_Account_Type__c = accountType.toString();
        account.Payment_Method__c = "";
        account.Type = accountType.toString();
        account.DS_AccountPlanName__c = "";
        account.DS_AcctPlanStart__c = getDates(1);
        account.DS_Status__c = "Active";
        account.Account_Plan_Payment_Cycle__c = "Annual";
        account.OwnerId = getObjectId("user", "username", ownerEmailId);
        // account.DocuSignEnvironment__c = getObjectId("DOSS_AccountConfiguration__c",
        // "DocuSignEnvironmentName__c", environment);
        account.Site_Id__c = null;
        account.DS_AccountID__c = null;
        account.Industry = AccountIndustry.Manufacturing.toString();
        return account;
    }

    public Address setAddress() {
        Address address = new Address();
        address.Name = "";
        address.BillingPhone = "206-555-1212";
        address.ShippingPhone = "202-762-1401";

        switch (SalesforceLocale) {
            case UnitedStates:
                address.BillingStreet = "1632 N Texana St";
                address.BillingCity = "Hallettsville";
                address.BillingState = "TX";
                address.BillingZip = "77964";
                address.BillingCountry = "United States";
                address.ShippingStreet = "221 Main";
                address.ShippingCity = "San Francisco";
                address.ShippingState = "CA";
                address.ShippingPostalCode = "94105";
                address.ShippingCountry = "United States";
                address.CurrencyCode = "USD";
                // OwnerEmail = "nainappa.illi@docusign.com";
                OwnerEmail = "ryan.vandersloot@docusign.com.qa";
                break;
            case Brazil:
                address.BillingStreet = "Rua Gomes de Carvalho 1306";
                address.BillingCity = "S�o Paulo";
                address.BillingState = "S�o Paulo";
                address.BillingZip = "CEP: 04547-005";
                address.BillingCountry = "Brazil";
                address.ShippingStreet = "Quadra Quadra 211 910";
                address.ShippingCity = "Luzi�nia";
                address.ShippingState = "Goi�s";
                address.ShippingPostalCode = "72855-211";
                address.ShippingCountry = "Brazil";
                address.CurrencyCode = "BRL";
                address.BillingPhone = "011-55-123-456-7890";
                break;
            default:
                break;
        }
        address.Name = "QEAutomationTest_" + address.CurrencyCode + "_" + RandomUtils.randomString(7);
        return address;
    }

    public Contact setContact(Account account, String accountId, boolean isShipping) {
        Address address = setAddress();
        String firstName = isShipping ? address.Name + "-STC-" + RandomUtils.randomString(6)
            : address.Name + "-BTC-" + RandomUtils.randomString(6);
        Contact contact = new Contact();
        contact.FirstName = firstName.substring(0, 40);
        contact.LastName = "Last" + RandomUtils.randomString(10);
        contact.MailingStreet = isShipping ? account.ShippingStreet : account.BillingStreet;
        contact.MailingCity = isShipping ? account.ShippingCity : account.BillingCity;
        contact.MailingState = isShipping ? account.ShippingState : account.BillingState;
        contact.MailingPostalCode = isShipping ? account.ShippingPostalCode : account.BillingPostalCode;
        contact.MailingCountry = isShipping ? account.ShippingCountry : account.BillingCountry;
        contact.Phone = isShipping ? address.ShippingPhone : account.Phone;
        contact.Is_Billing_Contact__c = isShipping ? false : true;
        contact.AccountId = accountId;
        contact.RecordTypeId = getObjectId("RecordType", "name", "Standard Contact");
        contact.OwnerId = account.OwnerId;
        contact.Email = contact.FirstName.substring(0, 8) + "_" + contact.LastName.substring(0, 8) + "@geemail.com";
        return contact;
    }

    public Opportunity setOpportunity(Account account, String accountId, String contactId) {
        Address address = setAddress();
        Opportunity opportunity = new Opportunity();
        opportunity.AccountId = accountId;
        opportunity.Name = address.Name + "-Opportunity " + RandomUtils.randomString(6);
        opportunity.CloseDate = getDates(0);
        opportunity.StageName = "Qualify";
        opportunity.CurrencyIsoCode = account.CurrencyIsoCode;
        opportunity.RecordTypeId = getObjectId("RecordType", "name", "Standard Opportunity");
        opportunity.Order_Type__c = "New Customer";
        opportunity.OwnerId = account.OwnerId;
        opportunity.Competitor_Lost_To__c = "Adobe";
        opportunity.Product_Interest__c = "Gen";
        opportunity.Use_Case_Implementation_Contact__c = contactId;
        opportunity.Use_Case_Description__c = "Use Case Description: " + RandomUtils.randomString(50);
        opportunity.Use_Case_Department__c = "IT/Operations";
        return opportunity;
    }

    public String createObject(SfdcClient client, String objectName, Object obj) {
        return client.createSalesforceObject(objectName, obj);
    }

    public String getObjectId(String objectname, String field, String value) {
        String query = String.format("select id from %1$s where %2$s = '%3$s'", objectname, field, value);
        long t = System.currentTimeMillis();
        long end = t + 30000;

        while (System.currentTimeMillis() < end) {
            String json = client.submitSOQLQuery(query);
            JSONObject jsonResponseObject = new JSONObject(json);
            JSONArray jarr = jsonResponseObject.getJSONArray("records");
            jsonResponseObject = jarr.getJSONObject(0);
            try {
                return jsonResponseObject.get("Id").toString();
            } catch (Exception e) {
                // gulp the exception
            }
        }
        return null;
    }

    public String getDates(int days) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 1);
        Date currentDatePlusOne = c.getTime();
        return dateFormat.format(currentDatePlusOne);
    }

    public static void main(String[] args) {
        // Credentials creds = new Credentials("https://docusign--qa.my.salesforce.com", userName,
        // passWord,
        // userToken,clientId,clientSecret);
        // SfdcClient sfdcClient = new SfdcClient(creds);
        // SFDCHelper helper = new SFDCHelper(sfdcClient,
        // com.EA.ApttUp.SFDCEnum.Locale.UnitedStates);
        // Account account = helper.setAccount(SalesforceAccountType.Corporate, null);
        // System.out.println(sfdcClient.createSalesforceObject("account", account));
        // sfdcClient.createSalesforceObject("account", account);
        // sfdcClient.createSalesforceObject("contact", account);
    }

}
