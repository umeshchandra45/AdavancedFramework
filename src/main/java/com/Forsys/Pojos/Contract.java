package com.Forsys.Pojos;

public class Contract {
    public String Id;
    public String AccountId;
    public String CurrencyIsoCode;
    public String Pricebook2Id;
    public String OwnerExpirationNotice;
    public String StartDate;
    public String EndDate;
    public String BillingStreet;
    public String BillingCity;
    public String BillingState;
    public String BillingPostalCode;
    public String BillingCountry;
    public double BillingLatitude;
    public double BillingLongitude;
    public String BillingGeocodeAccuracy;
    public String BillingAddress;
    public int ContractTerm;
    public String OwnerId;
    public String Status;
    public String CompanySignedId;
    public String CompanySignedDate;
    public String CustomerSignedId;
    public String CustomerSignedTitle;
    public String CustomerSignedDate;
    public String SpecialTerms;
    public String ActivatedById;
    public String ActivatedDate;
    public String StatusCode;
    public String Description;
    public String RecordTypeId;
    public String Name;
    public boolean IsDeleted;
    public String ContractNumber;
    public String LastApprovedDate;
    public String CreatedDate;
    public String CreatedById;
    public String LastModifiedDate;
    public String LastModifiedById;
    public String SystemModstamp;
    public String LastActivityDate;
    public String LastViewedDate;
    public String LastReferencedDate;
    public double Po1_Contracts__c;
    public double Renewal_Percentage__c;
    public String Upcoming_Renewal_Contract__c;
    public String Doc_Labeling_Requirement__c;
    public String Reasonable_Understanding_Exception__c;
    public String Oral_Disclosure_Follow_up_in_Writing__c;
    public String Template_Source__c;
    public String DocuSign_Status_to_add_to_Contract__c;
    public double Company_Signer_Count__c;
    public double Customer_Signer_Count__c;
    public String pw_ccpro__BillingAddressStatus__c;
    public String pw_ccpro__BillingCountryLookup__c;
    public String pw_ccpro__BillingStateLookup__c;
    public String pw_ccpro__BillingZipCodeLookup__c;
    public double pw_ccpro__UtcTimeOffset__c;
    public String pw_ccpro__BillingCounty__c;
    public String pw_ccpro__BillingLocationAccuracy__c;
    public String pw_ccpro__BillingLocationSource__c;
    public String pw_ccpro__ShippingAddressStatus__c;
    public String pw_ccpro__ShippingCountryLookup__c;
    public String pw_ccpro__ShippingCounty__c;
    public String pw_ccpro__ShippingLocationAccuracy__c;
    public String pw_ccpro__ShippingLocationSource__c;
    public String pw_ccpro__ShippingStateLookup__c;
    public String pw_ccpro__ShippingZipCodeLookup__c;
    public String Type__c;
    public double SBQQ__ActiveContract__c;
    public String SBQQ__AmendmentOpportunityRecordTypeId__c;
    public String SBQQ__AmendmentOpportunityStage__c;
    public String SBQQ__AmendmentOwner__c;
    public String SBQQ__AmendmentPricebookId__c;
    public String SBQQ__AmendmentRenewalBehavior__c;
    public String SBQQ__AmendmentStartDate__c;
    public boolean SBQQ__DefaultRenewalContactRoles__c;
    public boolean SBQQ__DefaultRenewalPartners__c;
    public boolean SBQQ__DisableAmendmentCoTerm__c;
    public String SBQQ__Evergreen__c;
    public String SBQQ__ExpirationDate__c;
    public String SBQQ__MDQRenewalBehavior__c;
    public boolean SBQQ__MasterContract__c;
    public String SBQQ__OpportunityPricebookId__c;
    public String SBQQ__Opportunity__c;
    public String SBQQ__Order__c;
    public boolean SBQQ__PreserveBundleStructureUponRenewals__c;
    public String SBQQ__Quote__c;
    public boolean SBQQ__RenewalForecast__c;
    public String SBQQ__RenewalOpportunityRecordTypeId__c;
    public String SBQQ__RenewalOpportunityStage__c;
    public String SBQQ__RenewalOpportunity__c;
    public String SBQQ__RenewalOwner__c;
    public String SBQQ__RenewalPricebookId__c;
    public boolean SBQQ__RenewalQuoted__c;
    public double SBQQ__RenewalTerm__c;
    public double SBQQ__RenewalUpliftRate__c;
    public boolean SBQQ__SubscriptionQuantitiesCombined__c;
    public String Billing_Subscription__c;

    public Contract() {

    }

    public String getId() {
        return Id;
    }

    public String getAccountId() {
        return AccountId;
    }

    public String getCurrencyIsoCode() {
        return CurrencyIsoCode;
    }

    public String getPricebook2Id() {
        return Pricebook2Id;
    }

    public String getOwnerExpirationNotice() {
        return OwnerExpirationNotice;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public String getBillingStreet() {
        return BillingStreet;
    }

    public String getBillingCity() {
        return BillingCity;
    }

    public String getBillingState() {
        return BillingState;
    }

    public String getBillingPostalCode() {
        return BillingPostalCode;
    }

    public String getBillingCountry() {
        return BillingCountry;
    }

    public double getBillingLatitude() {
        return BillingLatitude;
    }

    public double getBillingLongitude() {
        return BillingLongitude;
    }

    public String getBillingGeocodeAccuracy() {
        return BillingGeocodeAccuracy;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }

    public int getContractTerm() {
        return ContractTerm;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public String getStatus() {
        return Status;
    }

    public String getCompanySignedId() {
        return CompanySignedId;
    }

    public String getCompanySignedDate() {
        return CompanySignedDate;
    }

    public String getCustomerSignedId() {
        return CustomerSignedId;
    }

    public String getCustomerSignedTitle() {
        return CustomerSignedTitle;
    }

    public String getCustomerSignedDate() {
        return CustomerSignedDate;
    }

    public String getSpecialTerms() {
        return SpecialTerms;
    }

    public String getActivatedById() {
        return ActivatedById;
    }

    public String getActivatedDate() {
        return ActivatedDate;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public String getDescription() {
        return Description;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public String getName() {
        return Name;
    }

    public boolean isIsDeleted() {
        return IsDeleted;
    }

    public String getContractNumber() {
        return ContractNumber;
    }

    public String getLastApprovedDate() {
        return LastApprovedDate;
    }

    public String getCreatedDate() {
        return CreatedDate;
    }

    public String getCreatedById() {
        return CreatedById;
    }

    public String getLastModifiedDate() {
        return LastModifiedDate;
    }

    public String getLastModifiedById() {
        return LastModifiedById;
    }

    public String getSystemModstamp() {
        return SystemModstamp;
    }

    public String getLastActivityDate() {
        return LastActivityDate;
    }

    public String getLastViewedDate() {
        return LastViewedDate;
    }

    public String getLastReferencedDate() {
        return LastReferencedDate;
    }

    public double getPo1_Contracts__c() {
        return Po1_Contracts__c;
    }

    public double getRenewal_Percentage__c() {
        return Renewal_Percentage__c;
    }

    public String getUpcoming_Renewal_Contract__c() {
        return Upcoming_Renewal_Contract__c;
    }

    public String getDoc_Labeling_Requirement__c() {
        return Doc_Labeling_Requirement__c;
    }

    public String getReasonable_Understanding_Exception__c() {
        return Reasonable_Understanding_Exception__c;
    }

    public String getOral_Disclosure_Follow_up_in_Writing__c() {
        return Oral_Disclosure_Follow_up_in_Writing__c;
    }

    public String getTemplate_Source__c() {
        return Template_Source__c;
    }

    public String getDocuSign_Status_to_add_to_Contract__c() {
        return DocuSign_Status_to_add_to_Contract__c;
    }

    public double getCompany_Signer_Count__c() {
        return Company_Signer_Count__c;
    }

    public double getCustomer_Signer_Count__c() {
        return Customer_Signer_Count__c;
    }

    public String getPw_ccpro__BillingAddressStatus__c() {
        return pw_ccpro__BillingAddressStatus__c;
    }

    public String getPw_ccpro__BillingCountryLookup__c() {
        return pw_ccpro__BillingCountryLookup__c;
    }

    public String getPw_ccpro__BillingStateLookup__c() {
        return pw_ccpro__BillingStateLookup__c;
    }

    public String getPw_ccpro__BillingZipCodeLookup__c() {
        return pw_ccpro__BillingZipCodeLookup__c;
    }

    public double getPw_ccpro__UtcTimeOffset__c() {
        return pw_ccpro__UtcTimeOffset__c;
    }

    public String getPw_ccpro__BillingCounty__c() {
        return pw_ccpro__BillingCounty__c;
    }

    public String getPw_ccpro__BillingLocationAccuracy__c() {
        return pw_ccpro__BillingLocationAccuracy__c;
    }

    public String getPw_ccpro__BillingLocationSource__c() {
        return pw_ccpro__BillingLocationSource__c;
    }

    public String getPw_ccpro__ShippingAddressStatus__c() {
        return pw_ccpro__ShippingAddressStatus__c;
    }

    public String getPw_ccpro__ShippingCountryLookup__c() {
        return pw_ccpro__ShippingCountryLookup__c;
    }

    public String getPw_ccpro__ShippingCounty__c() {
        return pw_ccpro__ShippingCounty__c;
    }

    public String getPw_ccpro__ShippingLocationAccuracy__c() {
        return pw_ccpro__ShippingLocationAccuracy__c;
    }

    public String getPw_ccpro__ShippingLocationSource__c() {
        return pw_ccpro__ShippingLocationSource__c;
    }

    public String getPw_ccpro__ShippingStateLookup__c() {
        return pw_ccpro__ShippingStateLookup__c;
    }

    public String getPw_ccpro__ShippingZipCodeLookup__c() {
        return pw_ccpro__ShippingZipCodeLookup__c;
    }

    public String getType__c() {
        return Type__c;
    }

    public double getSBQQ__ActiveContract__c() {
        return SBQQ__ActiveContract__c;
    }

    public String getSBQQ__AmendmentOpportunityRecordTypeId__c() {
        return SBQQ__AmendmentOpportunityRecordTypeId__c;
    }

    public String getSBQQ__AmendmentOpportunityStage__c() {
        return SBQQ__AmendmentOpportunityStage__c;
    }

    public String getSBQQ__AmendmentOwner__c() {
        return SBQQ__AmendmentOwner__c;
    }

    public String getSBQQ__AmendmentPricebookId__c() {
        return SBQQ__AmendmentPricebookId__c;
    }

    public String getSBQQ__AmendmentRenewalBehavior__c() {
        return SBQQ__AmendmentRenewalBehavior__c;
    }

    public String getSBQQ__AmendmentStartDate__c() {
        return SBQQ__AmendmentStartDate__c;
    }

    public boolean isSBQQ__DefaultRenewalContactRoles__c() {
        return SBQQ__DefaultRenewalContactRoles__c;
    }

    public boolean isSBQQ__DefaultRenewalPartners__c() {
        return SBQQ__DefaultRenewalPartners__c;
    }

    public boolean isSBQQ__DisableAmendmentCoTerm__c() {
        return SBQQ__DisableAmendmentCoTerm__c;
    }

    public String getSBQQ__Evergreen__c() {
        return SBQQ__Evergreen__c;
    }

    public String getSBQQ__ExpirationDate__c() {
        return SBQQ__ExpirationDate__c;
    }

    public String getSBQQ__MDQRenewalBehavior__c() {
        return SBQQ__MDQRenewalBehavior__c;
    }

    public boolean isSBQQ__MasterContract__c() {
        return SBQQ__MasterContract__c;
    }

    public String getSBQQ__OpportunityPricebookId__c() {
        return SBQQ__OpportunityPricebookId__c;
    }

    public String getSBQQ__Opportunity__c() {
        return SBQQ__Opportunity__c;
    }

    public String getSBQQ__Order__c() {
        return SBQQ__Order__c;
    }

    public boolean isSBQQ__PreserveBundleStructureUponRenewals__c() {
        return SBQQ__PreserveBundleStructureUponRenewals__c;
    }

    public String getSBQQ__Quote__c() {
        return SBQQ__Quote__c;
    }

    public boolean isSBQQ__RenewalForecast__c() {
        return SBQQ__RenewalForecast__c;
    }

    public String getSBQQ__RenewalOpportunityRecordTypeId__c() {
        return SBQQ__RenewalOpportunityRecordTypeId__c;
    }

    public String getSBQQ__RenewalOpportunityStage__c() {
        return SBQQ__RenewalOpportunityStage__c;
    }

    public String getSBQQ__RenewalOpportunity__c() {
        return SBQQ__RenewalOpportunity__c;
    }

    public String getSBQQ__RenewalOwner__c() {
        return SBQQ__RenewalOwner__c;
    }

    public String getSBQQ__RenewalPricebookId__c() {
        return SBQQ__RenewalPricebookId__c;
    }

    public boolean isSBQQ__RenewalQuoted__c() {
        return SBQQ__RenewalQuoted__c;
    }

    public double getSBQQ__RenewalTerm__c() {
        return SBQQ__RenewalTerm__c;
    }

    public double getSBQQ__RenewalUpliftRate__c() {
        return SBQQ__RenewalUpliftRate__c;
    }

    public boolean isSBQQ__SubscriptionQuantitiesCombined__c() {
        return SBQQ__SubscriptionQuantitiesCombined__c;
    }

    public String getBilling_Subscription__c() {
        return Billing_Subscription__c;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        CurrencyIsoCode = currencyIsoCode;
    }

    public void setPricebook2Id(String pricebook2Id) {
        Pricebook2Id = pricebook2Id;
    }

    public void setOwnerExpirationNotice(String ownerExpirationNotice) {
        OwnerExpirationNotice = ownerExpirationNotice;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public void setBillingStreet(String billingStreet) {
        BillingStreet = billingStreet;
    }

    public void setBillingCity(String billingCity) {
        BillingCity = billingCity;
    }

    public void setBillingState(String billingState) {
        BillingState = billingState;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        BillingPostalCode = billingPostalCode;
    }

    public void setBillingCountry(String billingCountry) {
        BillingCountry = billingCountry;
    }

    public void setBillingLatitude(double billingLatitude) {
        BillingLatitude = billingLatitude;
    }

    public void setBillingLongitude(double billingLongitude) {
        BillingLongitude = billingLongitude;
    }

    public void setBillingGeocodeAccuracy(String billingGeocodeAccuracy) {
        BillingGeocodeAccuracy = billingGeocodeAccuracy;
    }

    public void setBillingAddress(String billingAddress) {
        BillingAddress = billingAddress;
    }

    public void setContractTerm(int contractTerm) {
        ContractTerm = contractTerm;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setCompanySignedId(String companySignedId) {
        CompanySignedId = companySignedId;
    }

    public void setCompanySignedDate(String companySignedDate) {
        CompanySignedDate = companySignedDate;
    }

    public void setCustomerSignedId(String customerSignedId) {
        CustomerSignedId = customerSignedId;
    }

    public void setCustomerSignedTitle(String customerSignedTitle) {
        CustomerSignedTitle = customerSignedTitle;
    }

    public void setCustomerSignedDate(String customerSignedDate) {
        CustomerSignedDate = customerSignedDate;
    }

    public void setSpecialTerms(String specialTerms) {
        SpecialTerms = specialTerms;
    }

    public void setActivatedById(String activatedById) {
        ActivatedById = activatedById;
    }

    public void setActivatedDate(String activatedDate) {
        ActivatedDate = activatedDate;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setRecordTypeId(String recordTypeId) {
        RecordTypeId = recordTypeId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setIsDeleted(boolean isDeleted) {
        IsDeleted = isDeleted;
    }

    public void setContractNumber(String contractNumber) {
        ContractNumber = contractNumber;
    }

    public void setLastApprovedDate(String lastApprovedDate) {
        LastApprovedDate = lastApprovedDate;
    }

    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    public void setCreatedById(String createdById) {
        CreatedById = createdById;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }

    public void setLastModifiedById(String lastModifiedById) {
        LastModifiedById = lastModifiedById;
    }

    public void setSystemModstamp(String systemModstamp) {
        SystemModstamp = systemModstamp;
    }

    public void setLastActivityDate(String lastActivityDate) {
        LastActivityDate = lastActivityDate;
    }

    public void setLastViewedDate(String lastViewedDate) {
        LastViewedDate = lastViewedDate;
    }

    public void setLastReferencedDate(String lastReferencedDate) {
        LastReferencedDate = lastReferencedDate;
    }

    public void setPo1_Contracts__c(double po1_Contracts__c) {
        Po1_Contracts__c = po1_Contracts__c;
    }

    public void setRenewal_Percentage__c(double renewal_Percentage__c) {
        Renewal_Percentage__c = renewal_Percentage__c;
    }

    public void setUpcoming_Renewal_Contract__c(String upcoming_Renewal_Contract__c) {
        Upcoming_Renewal_Contract__c = upcoming_Renewal_Contract__c;
    }

    public void setDoc_Labeling_Requirement__c(String doc_Labeling_Requirement__c) {
        Doc_Labeling_Requirement__c = doc_Labeling_Requirement__c;
    }

    public void setReasonable_Understanding_Exception__c(String reasonable_Understanding_Exception__c) {
        Reasonable_Understanding_Exception__c = reasonable_Understanding_Exception__c;
    }

    public void setOral_Disclosure_Follow_up_in_Writing__c(String oral_Disclosure_Follow_up_in_Writing__c) {
        Oral_Disclosure_Follow_up_in_Writing__c = oral_Disclosure_Follow_up_in_Writing__c;
    }

    public void setTemplate_Source__c(String template_Source__c) {
        Template_Source__c = template_Source__c;
    }

    public void setDocuSign_Status_to_add_to_Contract__c(String docuSign_Status_to_add_to_Contract__c) {
        DocuSign_Status_to_add_to_Contract__c = docuSign_Status_to_add_to_Contract__c;
    }

    public void setCompany_Signer_Count__c(double company_Signer_Count__c) {
        Company_Signer_Count__c = company_Signer_Count__c;
    }

    public void setCustomer_Signer_Count__c(double customer_Signer_Count__c) {
        Customer_Signer_Count__c = customer_Signer_Count__c;
    }

    public void setPw_ccpro__BillingAddressStatus__c(String pw_ccpro__BillingAddressStatus__c) {
        this.pw_ccpro__BillingAddressStatus__c = pw_ccpro__BillingAddressStatus__c;
    }

    public void setPw_ccpro__BillingCountryLookup__c(String pw_ccpro__BillingCountryLookup__c) {
        this.pw_ccpro__BillingCountryLookup__c = pw_ccpro__BillingCountryLookup__c;
    }

    public void setPw_ccpro__BillingStateLookup__c(String pw_ccpro__BillingStateLookup__c) {
        this.pw_ccpro__BillingStateLookup__c = pw_ccpro__BillingStateLookup__c;
    }

    public void setPw_ccpro__BillingZipCodeLookup__c(String pw_ccpro__BillingZipCodeLookup__c) {
        this.pw_ccpro__BillingZipCodeLookup__c = pw_ccpro__BillingZipCodeLookup__c;
    }

    public void setPw_ccpro__UtcTimeOffset__c(double pw_ccpro__UtcTimeOffset__c) {
        this.pw_ccpro__UtcTimeOffset__c = pw_ccpro__UtcTimeOffset__c;
    }

    public void setPw_ccpro__BillingCounty__c(String pw_ccpro__BillingCounty__c) {
        this.pw_ccpro__BillingCounty__c = pw_ccpro__BillingCounty__c;
    }

    public void setPw_ccpro__BillingLocationAccuracy__c(String pw_ccpro__BillingLocationAccuracy__c) {
        this.pw_ccpro__BillingLocationAccuracy__c = pw_ccpro__BillingLocationAccuracy__c;
    }

    public void setPw_ccpro__BillingLocationSource__c(String pw_ccpro__BillingLocationSource__c) {
        this.pw_ccpro__BillingLocationSource__c = pw_ccpro__BillingLocationSource__c;
    }

    public void setPw_ccpro__ShippingAddressStatus__c(String pw_ccpro__ShippingAddressStatus__c) {
        this.pw_ccpro__ShippingAddressStatus__c = pw_ccpro__ShippingAddressStatus__c;
    }

    public void setPw_ccpro__ShippingCountryLookup__c(String pw_ccpro__ShippingCountryLookup__c) {
        this.pw_ccpro__ShippingCountryLookup__c = pw_ccpro__ShippingCountryLookup__c;
    }

    public void setPw_ccpro__ShippingCounty__c(String pw_ccpro__ShippingCounty__c) {
        this.pw_ccpro__ShippingCounty__c = pw_ccpro__ShippingCounty__c;
    }

    public void setPw_ccpro__ShippingLocationAccuracy__c(String pw_ccpro__ShippingLocationAccuracy__c) {
        this.pw_ccpro__ShippingLocationAccuracy__c = pw_ccpro__ShippingLocationAccuracy__c;
    }

    public void setPw_ccpro__ShippingLocationSource__c(String pw_ccpro__ShippingLocationSource__c) {
        this.pw_ccpro__ShippingLocationSource__c = pw_ccpro__ShippingLocationSource__c;
    }

    public void setPw_ccpro__ShippingStateLookup__c(String pw_ccpro__ShippingStateLookup__c) {
        this.pw_ccpro__ShippingStateLookup__c = pw_ccpro__ShippingStateLookup__c;
    }

    public void setPw_ccpro__ShippingZipCodeLookup__c(String pw_ccpro__ShippingZipCodeLookup__c) {
        this.pw_ccpro__ShippingZipCodeLookup__c = pw_ccpro__ShippingZipCodeLookup__c;
    }

    public void setType__c(String type__c) {
        Type__c = type__c;
    }

    public void setSBQQ__ActiveContract__c(double sBQQ__ActiveContract__c) {
        SBQQ__ActiveContract__c = sBQQ__ActiveContract__c;
    }

    public void setSBQQ__AmendmentOpportunityRecordTypeId__c(String sBQQ__AmendmentOpportunityRecordTypeId__c) {
        SBQQ__AmendmentOpportunityRecordTypeId__c = sBQQ__AmendmentOpportunityRecordTypeId__c;
    }

    public void setSBQQ__AmendmentOpportunityStage__c(String sBQQ__AmendmentOpportunityStage__c) {
        SBQQ__AmendmentOpportunityStage__c = sBQQ__AmendmentOpportunityStage__c;
    }

    public void setSBQQ__AmendmentOwner__c(String sBQQ__AmendmentOwner__c) {
        SBQQ__AmendmentOwner__c = sBQQ__AmendmentOwner__c;
    }

    public void setSBQQ__AmendmentPricebookId__c(String sBQQ__AmendmentPricebookId__c) {
        SBQQ__AmendmentPricebookId__c = sBQQ__AmendmentPricebookId__c;
    }

    public void setSBQQ__AmendmentRenewalBehavior__c(String sBQQ__AmendmentRenewalBehavior__c) {
        SBQQ__AmendmentRenewalBehavior__c = sBQQ__AmendmentRenewalBehavior__c;
    }

    public void setSBQQ__AmendmentStartDate__c(String sBQQ__AmendmentStartDate__c) {
        SBQQ__AmendmentStartDate__c = sBQQ__AmendmentStartDate__c;
    }

    public void setSBQQ__DefaultRenewalContactRoles__c(boolean sBQQ__DefaultRenewalContactRoles__c) {
        SBQQ__DefaultRenewalContactRoles__c = sBQQ__DefaultRenewalContactRoles__c;
    }

    public void setSBQQ__DefaultRenewalPartners__c(boolean sBQQ__DefaultRenewalPartners__c) {
        SBQQ__DefaultRenewalPartners__c = sBQQ__DefaultRenewalPartners__c;
    }

    public void setSBQQ__DisableAmendmentCoTerm__c(boolean sBQQ__DisableAmendmentCoTerm__c) {
        SBQQ__DisableAmendmentCoTerm__c = sBQQ__DisableAmendmentCoTerm__c;
    }

    public void setSBQQ__Evergreen__c(String sBQQ__Evergreen__c) {
        SBQQ__Evergreen__c = sBQQ__Evergreen__c;
    }

    public void setSBQQ__ExpirationDate__c(String sBQQ__ExpirationDate__c) {
        SBQQ__ExpirationDate__c = sBQQ__ExpirationDate__c;
    }

    public void setSBQQ__MDQRenewalBehavior__c(String sBQQ__MDQRenewalBehavior__c) {
        SBQQ__MDQRenewalBehavior__c = sBQQ__MDQRenewalBehavior__c;
    }

    public void setSBQQ__MasterContract__c(boolean sBQQ__MasterContract__c) {
        SBQQ__MasterContract__c = sBQQ__MasterContract__c;
    }

    public void setSBQQ__OpportunityPricebookId__c(String sBQQ__OpportunityPricebookId__c) {
        SBQQ__OpportunityPricebookId__c = sBQQ__OpportunityPricebookId__c;
    }

    public void setSBQQ__Opportunity__c(String sBQQ__Opportunity__c) {
        SBQQ__Opportunity__c = sBQQ__Opportunity__c;
    }

    public void setSBQQ__Order__c(String sBQQ__Order__c) {
        SBQQ__Order__c = sBQQ__Order__c;
    }

    public void setSBQQ__PreserveBundleStructureUponRenewals__c(boolean sBQQ__PreserveBundleStructureUponRenewals__c) {
        SBQQ__PreserveBundleStructureUponRenewals__c = sBQQ__PreserveBundleStructureUponRenewals__c;
    }

    public void setSBQQ__Quote__c(String sBQQ__Quote__c) {
        SBQQ__Quote__c = sBQQ__Quote__c;
    }

    public void setSBQQ__RenewalForecast__c(boolean sBQQ__RenewalForecast__c) {
        SBQQ__RenewalForecast__c = sBQQ__RenewalForecast__c;
    }

    public void setSBQQ__RenewalOpportunityRecordTypeId__c(String sBQQ__RenewalOpportunityRecordTypeId__c) {
        SBQQ__RenewalOpportunityRecordTypeId__c = sBQQ__RenewalOpportunityRecordTypeId__c;
    }

    public void setSBQQ__RenewalOpportunityStage__c(String sBQQ__RenewalOpportunityStage__c) {
        SBQQ__RenewalOpportunityStage__c = sBQQ__RenewalOpportunityStage__c;
    }

    public void setSBQQ__RenewalOpportunity__c(String sBQQ__RenewalOpportunity__c) {
        SBQQ__RenewalOpportunity__c = sBQQ__RenewalOpportunity__c;
    }

    public void setSBQQ__RenewalOwner__c(String sBQQ__RenewalOwner__c) {
        SBQQ__RenewalOwner__c = sBQQ__RenewalOwner__c;
    }

    public void setSBQQ__RenewalPricebookId__c(String sBQQ__RenewalPricebookId__c) {
        SBQQ__RenewalPricebookId__c = sBQQ__RenewalPricebookId__c;
    }

    public void setSBQQ__RenewalQuoted__c(boolean sBQQ__RenewalQuoted__c) {
        SBQQ__RenewalQuoted__c = sBQQ__RenewalQuoted__c;
    }

    public void setSBQQ__RenewalTerm__c(double sBQQ__RenewalTerm__c) {
        SBQQ__RenewalTerm__c = sBQQ__RenewalTerm__c;
    }

    public void setSBQQ__RenewalUpliftRate__c(double sBQQ__RenewalUpliftRate__c) {
        SBQQ__RenewalUpliftRate__c = sBQQ__RenewalUpliftRate__c;
    }

    public void setSBQQ__SubscriptionQuantitiesCombined__c(boolean sBQQ__SubscriptionQuantitiesCombined__c) {
        SBQQ__SubscriptionQuantitiesCombined__c = sBQQ__SubscriptionQuantitiesCombined__c;
    }

    public void setBilling_Subscription__c(String billing_Subscription__c) {
        Billing_Subscription__c = billing_Subscription__c;
    }

}
