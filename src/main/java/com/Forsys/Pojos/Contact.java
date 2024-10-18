package com.Forsys.Pojos;

public class Contact {
    public String Id;
    public String AccountId;
    public String FirstName;
    public String LastName;
    public String MailingStreet;
    public String MailingCity;
    public String MailingCountry;
    public String MailingState;
    public String MailingPostalCode;
    public String Phone;
    public String Email;
    public String RecordTypeId;
    public boolean Is_Billing_Contact__c;
    public boolean DS_Admin__c;
    public String OwnerId;
    public String salutation;

    public String getId() {
        return Id;
    }

    public String getAccountId() {
        return AccountId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMailingStreet() {
        return MailingStreet;
    }

    public String getMailingCity() {
        return MailingCity;
    }

    public String getMailingCountry() {
        return MailingCountry;
    }

    public String getMailingState() {
        return MailingState;
    }

    public String getMailingPostalCode() {
        return MailingPostalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public boolean isIs_Billing_Contact__c() {
        return Is_Billing_Contact__c;
    }

    public boolean isDS_Admin__c() {
        return DS_Admin__c;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setMailingStreet(String mailingStreet) {
        MailingStreet = mailingStreet;
    }

    public void setMailingCity(String mailingCity) {
        MailingCity = mailingCity;
    }

    public void setMailingCountry(String mailingCountry) {
        MailingCountry = mailingCountry;
    }

    public void setMailingState(String mailingState) {
        MailingState = mailingState;
    }

    public void setMailingPostalCode(String mailingPostalCode) {
        MailingPostalCode = mailingPostalCode;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setRecordTypeId(String recordTypeId) {
        RecordTypeId = recordTypeId;
    }

    public void setIs_Billing_Contact__c(boolean is_Billing_Contact__c) {
        Is_Billing_Contact__c = is_Billing_Contact__c;
    }

    public void setDS_Admin__c(boolean dS_Admin__c) {
        DS_Admin__c = dS_Admin__c;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

}
