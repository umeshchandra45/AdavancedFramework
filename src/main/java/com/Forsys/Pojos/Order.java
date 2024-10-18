package com.Forsys.Pojos;

public class Order {

    public String Id;
    public String OwnerId;
    public String ContractId;
    public String AccountId;
    public String Pricebook2Id;
    public String OriginalOrderId;
    public String EffectiveDate;
    public String EndDate;
    public boolean IsReductionOrder;
    public String Status;
    public String Description;
    public String CustomerAuthorizedById;
    public String CustomerAuthorizedDate;
    public String CompanyAuthorizedById;
    public String CompanyAuthorizedDate;
    public String Type;
    public String BillingStreet;
    public String BillingCity;
    public String BillingState;
    public String BillingPostalCode;
    public String BillingCountry;
    public String ShippingStreet;
    public String ShippingCity;
    public String ShippingState;
    public String ShippingPostalCode;
    public String ShippingCountry;
    public String Name;
    public String PoDate;
    public String PoNumber;
    public String OrderReferenceNumber;
    public String BillToContactId;
    public String ShipToContactId;
    public String ActivatedDate;
    public String ActivatedById;
    public String StatusCode;
    public String CurrencyIsoCode;
    public String OrderNumber;
    public float TotalAmount;
    public String CreatedDate;
    public String CreatedById;
    public String LastModifiedDate;
    public boolean IsDeleted;
    public String SystemModstamp;
    public String LastViewedDate;
    public boolean SBQQ__Contracted__c;
    public String SBQQ__ContractingMethod__c;
    public String SBQQ__PaymentTerm__c;
    public String SBQQ__PriceCalcStatusMessage__c;
    public String SBQQ__PriceCalcStatus__c;
    public String SBQQ__Quote__c;
    public String SBQQ__RenewalTerm__c;
    public String SBQQ__RenewalUpliftRate__c;
    public double SBQQ__OrderBookings__c;
    public double SBQQ__TaxAmount__c;
    public String Contracting_Entity__c;
    public String Billing_Integration_Message__c;
    public String Billing_Stage__c;
    public String SFCPQ_Account_Configuration_ID__c;
    public String SFCPQ_Apttus_Orig_Order_Date__c;
    public String SFCPQ_DM_QP_ID__c;
    public String SFCPQ_DS_Enrollment_Distributor__c;
    public boolean SFCPQ_DS_Enrollment_Inherit_Features__c;
    public String SFCPQ_DS_Enrollment_Stage__c;
    public double SFCPQ_Estimated_Envelopes__c;
    public double SFCPQ_Estimates_Seats__c;
    public String SFCPQ_Order_Type__c;
    public String SFCPQ_Payment_Method__c;
    public String SFCPQ_Provision_Date__c;
    public String SFCPQ_SCM_Provisoning_Stage__c;
    public String SFCPQ_SpringCM_Account_Id__c;
    public String Zuora_Order_Callout_Result__c;
    public String Apttus_Orig_Order_Id__c;
    public String SFCPQ_DocuSign_Enrollment_Message__c;
    public boolean Order_Synced__c;
    public boolean Order_Provisioned__c;
    public String Order_Sync_Status__c;
    public String Order_Provision_Status__c;
    public String Order_Provision_Stage__c;
    public String Order_Sync_Stage__c;

    public Order() {

    }

    public String getId() {
        return Id;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public String getContractId() {
        return ContractId;
    }

    public String getAccountId() {
        return AccountId;
    }

    public String getPricebook2Id() {
        return Pricebook2Id;
    }

    public String getOriginalOrderId() {
        return OriginalOrderId;
    }

    public String getEffectiveDate() {
        return EffectiveDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public boolean isIsReductionOrder() {
        return IsReductionOrder;
    }

    public String getStatus() {
        return Status;
    }

    public String getDescription() {
        return Description;
    }

    public String getCustomerAuthorizedById() {
        return CustomerAuthorizedById;
    }

    public String getCustomerAuthorizedDate() {
        return CustomerAuthorizedDate;
    }

    public String getCompanyAuthorizedById() {
        return CompanyAuthorizedById;
    }

    public String getCompanyAuthorizedDate() {
        return CompanyAuthorizedDate;
    }

    public String getType() {
        return Type;
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

    public String getShippingStreet() {
        return ShippingStreet;
    }

    public String getShippingCity() {
        return ShippingCity;
    }

    public String getShippingState() {
        return ShippingState;
    }

    public String getShippingPostalCode() {
        return ShippingPostalCode;
    }

    public String getShippingCountry() {
        return ShippingCountry;
    }

    public String getName() {
        return Name;
    }

    public String getPoDate() {
        return PoDate;
    }

    public String getPoNumber() {
        return PoNumber;
    }

    public String getOrderReferenceNumber() {
        return OrderReferenceNumber;
    }

    public String getBillToContactId() {
        return BillToContactId;
    }

    public String getShipToContactId() {
        return ShipToContactId;
    }

    public String getActivatedDate() {
        return ActivatedDate;
    }

    public String getActivatedById() {
        return ActivatedById;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    public String getCurrencyIsoCode() {
        return CurrencyIsoCode;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public float getTotalAmount() {
        return TotalAmount;
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

    public boolean isIsDeleted() {
        return IsDeleted;
    }

    public String getSystemModstamp() {
        return SystemModstamp;
    }

    public String getLastViewedDate() {
        return LastViewedDate;
    }

    public boolean isSBQQ__Contracted__c() {
        return SBQQ__Contracted__c;
    }

    public String getSBQQ__ContractingMethod__c() {
        return SBQQ__ContractingMethod__c;
    }

    public String getSBQQ__PaymentTerm__c() {
        return SBQQ__PaymentTerm__c;
    }

    public String getSBQQ__PriceCalcStatusMessage__c() {
        return SBQQ__PriceCalcStatusMessage__c;
    }

    public String getSBQQ__PriceCalcStatus__c() {
        return SBQQ__PriceCalcStatus__c;
    }

    public String getSBQQ__Quote__c() {
        return SBQQ__Quote__c;
    }

    public String getSBQQ__RenewalTerm__c() {
        return SBQQ__RenewalTerm__c;
    }

    public String getSBQQ__RenewalUpliftRate__c() {
        return SBQQ__RenewalUpliftRate__c;
    }

    public double getSBQQ__OrderBookings__c() {
        return SBQQ__OrderBookings__c;
    }

    public double getSBQQ__TaxAmount__c() {
        return SBQQ__TaxAmount__c;
    }

    public String getContracting_Entity__c() {
        return Contracting_Entity__c;
    }

    public String getBilling_Integration_Message__c() {
        return Billing_Integration_Message__c;
    }

    public String getBilling_Stage__c() {
        return Billing_Stage__c;
    }

    public String getSFCPQ_Account_Configuration_ID__c() {
        return SFCPQ_Account_Configuration_ID__c;
    }

    public String getSFCPQ_Apttus_Orig_Order_Date__c() {
        return SFCPQ_Apttus_Orig_Order_Date__c;
    }

    public String getSFCPQ_DM_QP_ID__c() {
        return SFCPQ_DM_QP_ID__c;
    }

    public String getSFCPQ_DS_Enrollment_Distributor__c() {
        return SFCPQ_DS_Enrollment_Distributor__c;
    }

    public boolean isSFCPQ_DS_Enrollment_Inherit_Features__c() {
        return SFCPQ_DS_Enrollment_Inherit_Features__c;
    }

    public String getSFCPQ_DS_Enrollment_Stage__c() {
        return SFCPQ_DS_Enrollment_Stage__c;
    }

    public double getSFCPQ_Estimated_Envelopes__c() {
        return SFCPQ_Estimated_Envelopes__c;
    }

    public double getSFCPQ_Estimates_Seats__c() {
        return SFCPQ_Estimates_Seats__c;
    }

    public String getSFCPQ_Order_Type__c() {
        return SFCPQ_Order_Type__c;
    }

    public String getSFCPQ_Payment_Method__c() {
        return SFCPQ_Payment_Method__c;
    }

    public String getSFCPQ_Provision_Date__c() {
        return SFCPQ_Provision_Date__c;
    }

    public String getSFCPQ_SCM_Provisoning_Stage__c() {
        return SFCPQ_SCM_Provisoning_Stage__c;
    }

    public String getSFCPQ_SpringCM_Account_Id__c() {
        return SFCPQ_SpringCM_Account_Id__c;
    }

    public String getZuora_Order_Callout_Result__c() {
        return Zuora_Order_Callout_Result__c;
    }

    public String getApttus_Orig_Order_Id__c() {
        return Apttus_Orig_Order_Id__c;
    }

    public String getSFCPQ_DocuSign_Enrollment_Message__c() {
        return SFCPQ_DocuSign_Enrollment_Message__c;
    }

    public boolean isOrder_Synced__c() {
        return Order_Synced__c;
    }

    public boolean isOrder_Provisioned__c() {
        return Order_Provisioned__c;
    }

    public String getOrder_Sync_Status__c() {
        return Order_Sync_Status__c;
    }

    public String getOrder_Provision_Status__c() {
        return Order_Provision_Status__c;
    }

    public String getOrder_Provision_Stage__c() {
        return Order_Provision_Stage__c;
    }

    public String getOrder_Sync_Stage__c() {
        return Order_Sync_Stage__c;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public void setContractId(String contractId) {
        ContractId = contractId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public void setPricebook2Id(String pricebook2Id) {
        Pricebook2Id = pricebook2Id;
    }

    public void setOriginalOrderId(String originalOrderId) {
        OriginalOrderId = originalOrderId;
    }

    public void setEffectiveDate(String effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public void setIsReductionOrder(boolean isReductionOrder) {
        IsReductionOrder = isReductionOrder;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setCustomerAuthorizedById(String customerAuthorizedById) {
        CustomerAuthorizedById = customerAuthorizedById;
    }

    public void setCustomerAuthorizedDate(String customerAuthorizedDate) {
        CustomerAuthorizedDate = customerAuthorizedDate;
    }

    public void setCompanyAuthorizedById(String companyAuthorizedById) {
        CompanyAuthorizedById = companyAuthorizedById;
    }

    public void setCompanyAuthorizedDate(String companyAuthorizedDate) {
        CompanyAuthorizedDate = companyAuthorizedDate;
    }

    public void setType(String type) {
        Type = type;
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

    public void setShippingStreet(String shippingStreet) {
        ShippingStreet = shippingStreet;
    }

    public void setShippingCity(String shippingCity) {
        ShippingCity = shippingCity;
    }

    public void setShippingState(String shippingState) {
        ShippingState = shippingState;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        ShippingPostalCode = shippingPostalCode;
    }

    public void setShippingCountry(String shippingCountry) {
        ShippingCountry = shippingCountry;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPoDate(String poDate) {
        PoDate = poDate;
    }

    public void setPoNumber(String poNumber) {
        PoNumber = poNumber;
    }

    public void setOrderReferenceNumber(String orderReferenceNumber) {
        OrderReferenceNumber = orderReferenceNumber;
    }

    public void setBillToContactId(String billToContactId) {
        BillToContactId = billToContactId;
    }

    public void setShipToContactId(String shipToContactId) {
        ShipToContactId = shipToContactId;
    }

    public void setActivatedDate(String activatedDate) {
        ActivatedDate = activatedDate;
    }

    public void setActivatedById(String activatedById) {
        ActivatedById = activatedById;
    }

    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        CurrencyIsoCode = currencyIsoCode;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public void setTotalAmount(float totalAmount) {
        TotalAmount = totalAmount;
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

    public void setIsDeleted(boolean isDeleted) {
        IsDeleted = isDeleted;
    }

    public void setSystemModstamp(String systemModstamp) {
        SystemModstamp = systemModstamp;
    }

    public void setLastViewedDate(String lastViewedDate) {
        LastViewedDate = lastViewedDate;
    }

    public void setSBQQ__Contracted__c(boolean sBQQ__Contracted__c) {
        SBQQ__Contracted__c = sBQQ__Contracted__c;
    }

    public void setSBQQ__ContractingMethod__c(String sBQQ__ContractingMethod__c) {
        SBQQ__ContractingMethod__c = sBQQ__ContractingMethod__c;
    }

    public void setSBQQ__PaymentTerm__c(String sBQQ__PaymentTerm__c) {
        SBQQ__PaymentTerm__c = sBQQ__PaymentTerm__c;
    }

    public void setSBQQ__PriceCalcStatusMessage__c(String sBQQ__PriceCalcStatusMessage__c) {
        SBQQ__PriceCalcStatusMessage__c = sBQQ__PriceCalcStatusMessage__c;
    }

    public void setSBQQ__PriceCalcStatus__c(String sBQQ__PriceCalcStatus__c) {
        SBQQ__PriceCalcStatus__c = sBQQ__PriceCalcStatus__c;
    }

    public void setSBQQ__Quote__c(String sBQQ__Quote__c) {
        SBQQ__Quote__c = sBQQ__Quote__c;
    }

    public void setSBQQ__RenewalTerm__c(String sBQQ__RenewalTerm__c) {
        SBQQ__RenewalTerm__c = sBQQ__RenewalTerm__c;
    }

    public void setSBQQ__RenewalUpliftRate__c(String sBQQ__RenewalUpliftRate__c) {
        SBQQ__RenewalUpliftRate__c = sBQQ__RenewalUpliftRate__c;
    }

    public void setSBQQ__OrderBookings__c(double sBQQ__OrderBookings__c) {
        SBQQ__OrderBookings__c = sBQQ__OrderBookings__c;
    }

    public void setSBQQ__TaxAmount__c(double sBQQ__TaxAmount__c) {
        SBQQ__TaxAmount__c = sBQQ__TaxAmount__c;
    }

    public void setContracting_Entity__c(String contracting_Entity__c) {
        Contracting_Entity__c = contracting_Entity__c;
    }

    public void setBilling_Integration_Message__c(String billing_Integration_Message__c) {
        Billing_Integration_Message__c = billing_Integration_Message__c;
    }

    public void setBilling_Stage__c(String billing_Stage__c) {
        Billing_Stage__c = billing_Stage__c;
    }

    public void setSFCPQ_Account_Configuration_ID__c(String sFCPQ_Account_Configuration_ID__c) {
        SFCPQ_Account_Configuration_ID__c = sFCPQ_Account_Configuration_ID__c;
    }

    public void setSFCPQ_Apttus_Orig_Order_Date__c(String sFCPQ_Apttus_Orig_Order_Date__c) {
        SFCPQ_Apttus_Orig_Order_Date__c = sFCPQ_Apttus_Orig_Order_Date__c;
    }

    public void setSFCPQ_DM_QP_ID__c(String sFCPQ_DM_QP_ID__c) {
        SFCPQ_DM_QP_ID__c = sFCPQ_DM_QP_ID__c;
    }

    public void setSFCPQ_DS_Enrollment_Distributor__c(String sFCPQ_DS_Enrollment_Distributor__c) {
        SFCPQ_DS_Enrollment_Distributor__c = sFCPQ_DS_Enrollment_Distributor__c;
    }

    public void setSFCPQ_DS_Enrollment_Inherit_Features__c(boolean sFCPQ_DS_Enrollment_Inherit_Features__c) {
        SFCPQ_DS_Enrollment_Inherit_Features__c = sFCPQ_DS_Enrollment_Inherit_Features__c;
    }

    public void setSFCPQ_DS_Enrollment_Stage__c(String sFCPQ_DS_Enrollment_Stage__c) {
        SFCPQ_DS_Enrollment_Stage__c = sFCPQ_DS_Enrollment_Stage__c;
    }

    public void setSFCPQ_Estimated_Envelopes__c(double sFCPQ_Estimated_Envelopes__c) {
        SFCPQ_Estimated_Envelopes__c = sFCPQ_Estimated_Envelopes__c;
    }

    public void setSFCPQ_Estimates_Seats__c(double sFCPQ_Estimates_Seats__c) {
        SFCPQ_Estimates_Seats__c = sFCPQ_Estimates_Seats__c;
    }

    public void setSFCPQ_Order_Type__c(String sFCPQ_Order_Type__c) {
        SFCPQ_Order_Type__c = sFCPQ_Order_Type__c;
    }

    public void setSFCPQ_Payment_Method__c(String sFCPQ_Payment_Method__c) {
        SFCPQ_Payment_Method__c = sFCPQ_Payment_Method__c;
    }

    public void setSFCPQ_Provision_Date__c(String sFCPQ_Provision_Date__c) {
        SFCPQ_Provision_Date__c = sFCPQ_Provision_Date__c;
    }

    public void setSFCPQ_SCM_Provisoning_Stage__c(String sFCPQ_SCM_Provisoning_Stage__c) {
        SFCPQ_SCM_Provisoning_Stage__c = sFCPQ_SCM_Provisoning_Stage__c;
    }

    public void setSFCPQ_SpringCM_Account_Id__c(String sFCPQ_SpringCM_Account_Id__c) {
        SFCPQ_SpringCM_Account_Id__c = sFCPQ_SpringCM_Account_Id__c;
    }

    public void setZuora_Order_Callout_Result__c(String zuora_Order_Callout_Result__c) {
        Zuora_Order_Callout_Result__c = zuora_Order_Callout_Result__c;
    }

    public void setApttus_Orig_Order_Id__c(String apttus_Orig_Order_Id__c) {
        Apttus_Orig_Order_Id__c = apttus_Orig_Order_Id__c;
    }

    public void setSFCPQ_DocuSign_Enrollment_Message__c(String sFCPQ_DocuSign_Enrollment_Message__c) {
        SFCPQ_DocuSign_Enrollment_Message__c = sFCPQ_DocuSign_Enrollment_Message__c;
    }

    public void setOrder_Synced__c(boolean order_Synced__c) {
        Order_Synced__c = order_Synced__c;
    }

    public void setOrder_Provisioned__c(boolean order_Provisioned__c) {
        Order_Provisioned__c = order_Provisioned__c;
    }

    public void setOrder_Sync_Status__c(String order_Sync_Status__c) {
        Order_Sync_Status__c = order_Sync_Status__c;
    }

    public void setOrder_Provision_Status__c(String order_Provision_Status__c) {
        Order_Provision_Status__c = order_Provision_Status__c;
    }

    public void setOrder_Provision_Stage__c(String order_Provision_Stage__c) {
        Order_Provision_Stage__c = order_Provision_Stage__c;
    }

    public void setOrder_Sync_Stage__c(String order_Sync_Stage__c) {
        Order_Sync_Stage__c = order_Sync_Stage__c;
    }

}
