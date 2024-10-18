package com.Forsys.Pojos;

import java.util.Date;

public class Lead {
    public String Id;
    public String FirstName;
    public String LastName;
    public String Name;
    public String RecordTypeId;
    public String Lead_Source_Most_Recent_Picklist__c;
    public String Title;
    public String Company;
    public String Street;
    public String City;
    public String State;
    public String Country;
    public String PostalCode;
    public String Address;
    public String OwnerId;
    public String Phone;
    public String MobilePhone;
    public String Email;
    public String Description;
    public String LeadSource;
    public String Status;
    public String CurrencyIsoCode;
    public int NumberOfEmployees;
    public boolean IsConverted;
    public Date ConvertedDate;
    public String ConvertedAccountId;
    public String ConvertedContactId;
    public String ConvertedOpportunityId;
    public boolean DoNotCall;
    public String PartnerAccountId;
    public String Rejection_Reason__c;
    public String Last_Routed_Date__c;
    public String Rejection_Sub_reason__c;
    public String MQL_Date_Time__c;
    public boolean Hard_Opt_In__c;
    public boolean HasOptedOutOfEmail;
    public String Partner_Solutions__c;
    public String Use_Case_Industry__c;
    public String Use_Case_Sub_Industry__c;
    public String Use_Case_Department__c;

    public Lead() {

    }

    public String getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getName() {
        return Name;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public String getLead_Source_Most_Recent_Picklist__c() {
        return Lead_Source_Most_Recent_Picklist__c;
    }

    public String getTitle() {
        return Title;
    }

    public String getCompany() {
        return Company;
    }

    public String getStreet() {
        return Street;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getCountry() {
        return Country;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public String getAddress() {
        return Address;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public String getPhone() {
        return Phone;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public String getEmail() {
        return Email;
    }

    public String getDescription() {
        return Description;
    }

    public String getLeadSource() {
        return LeadSource;
    }

    public String getStatus() {
        return Status;
    }

    public String getCurrencyIsoCode() {
        return CurrencyIsoCode;
    }

    public int getNumberOfEmployees() {
        return NumberOfEmployees;
    }

    public boolean isIsConverted() {
        return IsConverted;
    }

    public Date getConvertedDate() {
        return ConvertedDate;
    }

    public String getConvertedAccountId() {
        return ConvertedAccountId;
    }

    public String getConvertedContactId() {
        return ConvertedContactId;
    }

    public String getConvertedOpportunityId() {
        return ConvertedOpportunityId;
    }

    public boolean isDoNotCall() {
        return DoNotCall;
    }

    public String getPartnerAccountId() {
        return PartnerAccountId;
    }

    public String getRejection_Reason__c() {
        return Rejection_Reason__c;
    }

    public String getLast_Routed_Date__c() {
        return Last_Routed_Date__c;
    }

    public String getRejection_Sub_reason__c() {
        return Rejection_Sub_reason__c;
    }

    public String getMQL_Date_Time__c() {
        return MQL_Date_Time__c;
    }

    public boolean isHard_Opt_In__c() {
        return Hard_Opt_In__c;
    }

    public boolean isHasOptedOutOfEmail() {
        return HasOptedOutOfEmail;
    }

    public String getPartner_Solutions__c() {
        return Partner_Solutions__c;
    }

    public String getUse_Case_Industry__c() {
        return Use_Case_Industry__c;
    }

    public String getUse_Case_Sub_Industry__c() {
        return Use_Case_Sub_Industry__c;
    }

    public String getUse_Case_Department__c() {
        return Use_Case_Department__c;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setRecordTypeId(String recordTypeId) {
        RecordTypeId = recordTypeId;
    }

    public void setLead_Source_Most_Recent_Picklist__c(String lead_Source_Most_Recent_Picklist__c) {
        Lead_Source_Most_Recent_Picklist__c = lead_Source_Most_Recent_Picklist__c;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setState(String state) {
        State = state;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setLeadSource(String leadSource) {
        LeadSource = leadSource;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        CurrencyIsoCode = currencyIsoCode;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        NumberOfEmployees = numberOfEmployees;
    }

    public void setIsConverted(boolean isConverted) {
        IsConverted = isConverted;
    }

    public void setConvertedDate(Date convertedDate) {
        ConvertedDate = convertedDate;
    }

    public void setConvertedAccountId(String convertedAccountId) {
        ConvertedAccountId = convertedAccountId;
    }

    public void setConvertedContactId(String convertedContactId) {
        ConvertedContactId = convertedContactId;
    }

    public void setConvertedOpportunityId(String convertedOpportunityId) {
        ConvertedOpportunityId = convertedOpportunityId;
    }

    public void setDoNotCall(boolean doNotCall) {
        DoNotCall = doNotCall;
    }

    public void setPartnerAccountId(String partnerAccountId) {
        PartnerAccountId = partnerAccountId;
    }

    public void setRejection_Reason__c(String rejection_Reason__c) {
        Rejection_Reason__c = rejection_Reason__c;
    }

    public void setLast_Routed_Date__c(String last_Routed_Date__c) {
        Last_Routed_Date__c = last_Routed_Date__c;
    }

    public void setRejection_Sub_reason__c(String rejection_Sub_reason__c) {
        Rejection_Sub_reason__c = rejection_Sub_reason__c;
    }

    public void setMQL_Date_Time__c(String mQL_Date_Time__c) {
        MQL_Date_Time__c = mQL_Date_Time__c;
    }

    public void setHard_Opt_In__c(boolean hard_Opt_In__c) {
        Hard_Opt_In__c = hard_Opt_In__c;
    }

    public void setHasOptedOutOfEmail(boolean hasOptedOutOfEmail) {
        HasOptedOutOfEmail = hasOptedOutOfEmail;
    }

    public void setPartner_Solutions__c(String partner_Solutions__c) {
        Partner_Solutions__c = partner_Solutions__c;
    }

    public void setUse_Case_Industry__c(String use_Case_Industry__c) {
        Use_Case_Industry__c = use_Case_Industry__c;
    }

    public void setUse_Case_Sub_Industry__c(String use_Case_Sub_Industry__c) {
        Use_Case_Sub_Industry__c = use_Case_Sub_Industry__c;
    }

    public void setUse_Case_Department__c(String use_Case_Department__c) {
        Use_Case_Department__c = use_Case_Department__c;
    }

}
