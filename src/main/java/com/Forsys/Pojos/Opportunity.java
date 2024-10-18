package com.Forsys.Pojos;

public class Opportunity {
    public String Id;
    public String AccountId;
    public String Name;
    public String Order_Type__c = "New Customer";
    public String RecordTypeId;
    public String CurrencyIsoCode = "USD";
    public String StageName;
    public String CloseDate;
    public String Product_Interest__c;
    public String OwnerId;
    public String Incumbent__c;
    public String Competitor_Lost_To__c;
    public String Use_Case__c;
    public String Use_Case_Industry__c;
    public String Use_Case_Sub_Industry__c;
    public String Use_Case_Department__c;
    public String Use_Case_Implementation_Contact__c;
    public String Use_Case_Description__c;

    public String Description;
    public double Amount;
    public double Probability;
    public double ExpectedRevenue;
    public String NextStep;
    public String LeadSource;
    public boolean IsClosed;
    public boolean IsWon;
    public String ForecastCategory;
    public String ForecastCategoryName;
    public String CampaignId;
    public boolean HasOpportunityLineItem;
    public String Pricebook2Id;
    public String Territory2Id;
    public boolean IsExcludedFromTerritory2Filter;
    public int FiscalQuarter;
    public int FiscalYear;
    public String Fiscal;
    public boolean HasOpenActivity;
    public boolean HasOverdueTask;
    public boolean Partner_Influence_None__c;
    public double Support_Plan_Direct__c;
    public String Payment_Period__c;
    public boolean Estimated_Volume_Show_on_Order_Form__c;
    public boolean IsQualified__c;
    public String IsQualified_Date__c;
    public double Product_Count_Platform__c;
    public String Use_Case_Detail__c;
    public boolean SFDC_Envelope_Deal__c;
    public String Competitors__c;
    public String Payment_Type__c;
    public String Payment_Terms__c;
    public double Contract_Length_months__c;
    public String Product_Count_Just_Module__c;
    public double Product_Count_Appliance__c;
    public boolean Product_Count_Appliance_Alert_Sent__c;
    public double Product_Count_Cartavi_new__c;
    public String SFDC_Deal__c;
    public boolean DocuSign_Enrollment_Inherit_Features__c;
    public double Support_Plan_Premier__c;
    public String Primary_Quote__c;
    public String Zuora_Billing_Stage__c;
    public boolean Zuora_Renewal__c;
    public boolean Zuora_Submitted__c;
    public String Zuora_Subscription_ID__c;
    public double Support_Plan_Cost__c;
    public String Partner_Go_To_Market__c;
    public String Owner_ID__c;
    public String Stage_Group__c;
    public double Product_Count_Rate_Plan_Envelopes__c;
    public String Support_PlanStatus__c;
    public String Lead_Notes__c;
    public boolean Referred_to_Partner__c;
    public boolean Payment_Type_Override__c;
    public String Account_Owner__c;
    public String Enable_NDSE__c;
    public boolean Current_User__c;
    public double Original_Authorized_Seats__c;
    public double Original_Contract_Length__c;
    public double Conversion_Rate__c;
    public double Product_Count_Rate_Plan_Seats__c;
    public double ConvertGNCMRR__c;
    public double ConvertACV__c;
    public double ConvertBaseReorderCMRR__c;
    public double Estimated_Seats__c;
    public String Reason_Lost__c;
    public double Original_Envelope_Allowance__c;
    public double Original_Opportunity_Amount__c;
    public boolean Pilot__c;
    public String DocuSign_Enrollment_Distributor__c;
    public String Order_Start_Date__c;
    public String Quote_Valid_Until__c;
    public double Envelope_Allowance__c;
    public double Overage_Charge_per_Envelope__c;
    public boolean DocuSign_Enrollment_Keep_Plan__c;
    public String Sales_Program__c;
    public double Original_Opportunity_MRR__c;
    public double FinanceGNCMRR__c;
    public boolean NeedsFinanceAttn__c;
    public String Deal_Comments__c;
    public double Seat_Allowance__c;
    public String Owner_Role__c;
    public String Original_Start_Date__c;
    public String Account_Site_IDOpp__c;
    public String SF_Referral_Org_ID__c;
    public double SFDC_Product_Count__c;
    public String SFDC_Provisioning_Status__c;
    public String Reason_Lost_to_Competitor__c;
    public String Subscription_Type__c;
    public double FinanceNonrecurring__c;
    public boolean One_Time_Purchase__c;
    public double Product_Count_RSA__c;
    public boolean Revenue_on_Hold__c;
    public double FinanceACV__c;
    public double FinanceBaseReorderCMRR__c;
    public double FinanceReorderCMRR__c;
    public double FinanceLossCMRR__c;
    public boolean Opportunity_Record_Type_Closed__c;
    public double API_Product_Total__c;
    public double ConvertNonRecurring__c;
    public String Referral_Company__c;
    public boolean At_Risk__c;
    public double Base_Line_Amount__c;
    public String Contract_End_Date__c;
    public String Contract_Start_Date__c;
    public String Contract__c;
    public String Renewal_Opportunity__c;
    public String Renewal_Period__c;
    public String Order_End_Date__c;
    public String DocuSign_Account_Type__c;
    public String Opp_ID__c;
    public double FinanceRecurringRollup__c;
    public double FinanceCMRR__c;
    public boolean Finance_Approved__c;
    public double FinanceAddedYearsTCV__c;
    public String FinanceType__c;
    public String CPQ_OrderEndDate__c;
    public String CPQ_Primary_Quote__c;
    public double CPQ_TotalRecurringDiscount__c;
    public double Product_Count__c;
    public double FinanceNetCMRR__c;
    public double CPQ_Total_Non_Recurring_Revenue__c;
    public double CPQ_Total_Recurring_Revenue__c;
    public double Product_Count_Unlimited__c;
    public double Estimated_Envelopes__c;
    public boolean CPQ_Closed_Won__c;
    public boolean CPQ_Closed_for_Approval__c;
    public boolean Closed_for_Approval_GNCMRR2__c;
    public String Prior_Stage_Value__c;
    public boolean Closed_for_Approval_GNCMRR1__c;
    public String Account_NA_Territory__c;
    public String DocuSign_Enrollment_Message__c;
    public String DocuSign_Enrollment_Stage__c;
    public boolean QuoteIsCurrent__c;
    public String Partner_Referring_Account2__c;
    public double Payment_Period_Number__c;
    public String QuoteLastModifiedDate__c;
    public String DocuSignEnvironment__c;
    public String Sales_Channel__c;
    public String Finance_Status__c;
    public String Stage_Summary__c;
    public double Num_of_Opps__c;
    public String Opportunity_ID_18__c;
    public boolean Closed_Won_Email_Sent__c;
    public String Platform_Extn_Document_Name__c;
    public String Envelopes_Seats__c;
    public double Days_Past_Due__c;
    public double Po1_Opportunities__c;
    public String SBQQ__AmendedContract__c;
    public boolean SBQQ__Contracted__c;
    public boolean SBQQ__CreateContractedPrices__c;
    public String SBQQ__OrderGroupID__c;
    public boolean SBQQ__Ordered__c;
    public String SBQQ__PrimaryQuote__c;
    public String SBQQ__QuotePricebookId__c;
    public String SBQQ__Renewal__c;
    public String SBQQ__RenewedContract__c;
    public double SFCPQ_Envelope_Count__c;
    public double SFCPQ_Seat_Count__c;
    public double SFCPQ_Total_NRR_Net_Price__c;
    public boolean Standard_Terms_ALL__c;
    public String Back_Dated_Renewal__c;
    public String Billable__c;
    public String Future_Free_Discounted__c;
    public String Negotiating_another_quote_for_Customer__c;
    public String Price_Cap_Concessions_Holds__c;
    public String Rights_to_Future_Functionality__c;
    public String TFC_Clause__c;
    public String TFC_Expiration_Date__c;
    public String TFC_Notice_Period_for_Termination__c;
    public String Refund_Right_Included_in_Order_Form__c;
    public String Opt_Out_Clause__c;
    public String Opt_Out_Expiration_End_Date__c;
    public String Contracting_Entity__c;
    public String Non_standard_Acceptance_Clause_in_SOW__c;
    public String Refund_Right_included_in_MSA__c;
    public String TFC_Clause_included_in_MSA__c;
    public String Rights_of_Return_beyond_Standard__c;
    public String Service_Level_Agreements__c;

    public Opportunity() {

    }

    public String getId() {
        return Id;
    }

    public String getAccountId() {
        return AccountId;
    }

    public String getName() {
        return Name;
    }

    public String getOrder_Type__c() {
        return Order_Type__c;
    }

    public String getRecordTypeId() {
        return RecordTypeId;
    }

    public String getCurrencyIsoCode() {
        return CurrencyIsoCode;
    }

    public String getStageName() {
        return StageName;
    }

    public String getCloseDate() {
        return CloseDate;
    }

    public String getProduct_Interest__c() {
        return Product_Interest__c;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public String getIncumbent__c() {
        return Incumbent__c;
    }

    public String getCompetitor_Lost_To__c() {
        return Competitor_Lost_To__c;
    }

    public String getUse_Case__c() {
        return Use_Case__c;
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

    public String getUse_Case_Implementation_Contact__c() {
        return Use_Case_Implementation_Contact__c;
    }

    public String getUse_Case_Description__c() {
        return Use_Case_Description__c;
    }

    public String getDescription() {
        return Description;
    }

    public double getAmount() {
        return Amount;
    }

    public double getProbability() {
        return Probability;
    }

    public double getExpectedRevenue() {
        return ExpectedRevenue;
    }

    public String getNextStep() {
        return NextStep;
    }

    public String getLeadSource() {
        return LeadSource;
    }

    public boolean isIsClosed() {
        return IsClosed;
    }

    public boolean isIsWon() {
        return IsWon;
    }

    public String getForecastCategory() {
        return ForecastCategory;
    }

    public String getForecastCategoryName() {
        return ForecastCategoryName;
    }

    public String getCampaignId() {
        return CampaignId;
    }

    public boolean isHasOpportunityLineItem() {
        return HasOpportunityLineItem;
    }

    public String getPricebook2Id() {
        return Pricebook2Id;
    }

    public String getTerritory2Id() {
        return Territory2Id;
    }

    public boolean isIsExcludedFromTerritory2Filter() {
        return IsExcludedFromTerritory2Filter;
    }

    public int getFiscalQuarter() {
        return FiscalQuarter;
    }

    public int getFiscalYear() {
        return FiscalYear;
    }

    public String getFiscal() {
        return Fiscal;
    }

    public boolean isHasOpenActivity() {
        return HasOpenActivity;
    }

    public boolean isHasOverdueTask() {
        return HasOverdueTask;
    }

    public boolean isPartner_Influence_None__c() {
        return Partner_Influence_None__c;
    }

    public double getSupport_Plan_Direct__c() {
        return Support_Plan_Direct__c;
    }

    public String getPayment_Period__c() {
        return Payment_Period__c;
    }

    public boolean isEstimated_Volume_Show_on_Order_Form__c() {
        return Estimated_Volume_Show_on_Order_Form__c;
    }

    public boolean isIsQualified__c() {
        return IsQualified__c;
    }

    public String getIsQualified_Date__c() {
        return IsQualified_Date__c;
    }

    public double getProduct_Count_Platform__c() {
        return Product_Count_Platform__c;
    }

    public String getUse_Case_Detail__c() {
        return Use_Case_Detail__c;
    }

    public boolean isSFDC_Envelope_Deal__c() {
        return SFDC_Envelope_Deal__c;
    }

    public String getCompetitors__c() {
        return Competitors__c;
    }

    public String getPayment_Type__c() {
        return Payment_Type__c;
    }

    public String getPayment_Terms__c() {
        return Payment_Terms__c;
    }

    public double getContract_Length_months__c() {
        return Contract_Length_months__c;
    }

    public String getProduct_Count_Just_Module__c() {
        return Product_Count_Just_Module__c;
    }

    public double getProduct_Count_Appliance__c() {
        return Product_Count_Appliance__c;
    }

    public boolean isProduct_Count_Appliance_Alert_Sent__c() {
        return Product_Count_Appliance_Alert_Sent__c;
    }

    public double getProduct_Count_Cartavi_new__c() {
        return Product_Count_Cartavi_new__c;
    }

    public String getSFDC_Deal__c() {
        return SFDC_Deal__c;
    }

    public boolean isDocuSign_Enrollment_Inherit_Features__c() {
        return DocuSign_Enrollment_Inherit_Features__c;
    }

    public double getSupport_Plan_Premier__c() {
        return Support_Plan_Premier__c;
    }

    public String getPrimary_Quote__c() {
        return Primary_Quote__c;
    }

    public String getZuora_Billing_Stage__c() {
        return Zuora_Billing_Stage__c;
    }

    public boolean isZuora_Renewal__c() {
        return Zuora_Renewal__c;
    }

    public boolean isZuora_Submitted__c() {
        return Zuora_Submitted__c;
    }

    public String getZuora_Subscription_ID__c() {
        return Zuora_Subscription_ID__c;
    }

    public double getSupport_Plan_Cost__c() {
        return Support_Plan_Cost__c;
    }

    public String getPartner_Go_To_Market__c() {
        return Partner_Go_To_Market__c;
    }

    public String getOwner_ID__c() {
        return Owner_ID__c;
    }

    public String getStage_Group__c() {
        return Stage_Group__c;
    }

    public double getProduct_Count_Rate_Plan_Envelopes__c() {
        return Product_Count_Rate_Plan_Envelopes__c;
    }

    public String getSupport_PlanStatus__c() {
        return Support_PlanStatus__c;
    }

    public String getLead_Notes__c() {
        return Lead_Notes__c;
    }

    public boolean isReferred_to_Partner__c() {
        return Referred_to_Partner__c;
    }

    public boolean isPayment_Type_Override__c() {
        return Payment_Type_Override__c;
    }

    public String getAccount_Owner__c() {
        return Account_Owner__c;
    }

    public String getEnable_NDSE__c() {
        return Enable_NDSE__c;
    }

    public boolean isCurrent_User__c() {
        return Current_User__c;
    }

    public double getOriginal_Authorized_Seats__c() {
        return Original_Authorized_Seats__c;
    }

    public double getOriginal_Contract_Length__c() {
        return Original_Contract_Length__c;
    }

    public double getConversion_Rate__c() {
        return Conversion_Rate__c;
    }

    public double getProduct_Count_Rate_Plan_Seats__c() {
        return Product_Count_Rate_Plan_Seats__c;
    }

    public double getConvertGNCMRR__c() {
        return ConvertGNCMRR__c;
    }

    public double getConvertACV__c() {
        return ConvertACV__c;
    }

    public double getConvertBaseReorderCMRR__c() {
        return ConvertBaseReorderCMRR__c;
    }

    public double getEstimated_Seats__c() {
        return Estimated_Seats__c;
    }

    public String getReason_Lost__c() {
        return Reason_Lost__c;
    }

    public double getOriginal_Envelope_Allowance__c() {
        return Original_Envelope_Allowance__c;
    }

    public double getOriginal_Opportunity_Amount__c() {
        return Original_Opportunity_Amount__c;
    }

    public boolean isPilot__c() {
        return Pilot__c;
    }

    public String getDocuSign_Enrollment_Distributor__c() {
        return DocuSign_Enrollment_Distributor__c;
    }

    public String getOrder_Start_Date__c() {
        return Order_Start_Date__c;
    }

    public String getQuote_Valid_Until__c() {
        return Quote_Valid_Until__c;
    }

    public double getEnvelope_Allowance__c() {
        return Envelope_Allowance__c;
    }

    public double getOverage_Charge_per_Envelope__c() {
        return Overage_Charge_per_Envelope__c;
    }

    public boolean isDocuSign_Enrollment_Keep_Plan__c() {
        return DocuSign_Enrollment_Keep_Plan__c;
    }

    public String getSales_Program__c() {
        return Sales_Program__c;
    }

    public double getOriginal_Opportunity_MRR__c() {
        return Original_Opportunity_MRR__c;
    }

    public double getFinanceGNCMRR__c() {
        return FinanceGNCMRR__c;
    }

    public boolean isNeedsFinanceAttn__c() {
        return NeedsFinanceAttn__c;
    }

    public String getDeal_Comments__c() {
        return Deal_Comments__c;
    }

    public double getSeat_Allowance__c() {
        return Seat_Allowance__c;
    }

    public String getOwner_Role__c() {
        return Owner_Role__c;
    }

    public String getOriginal_Start_Date__c() {
        return Original_Start_Date__c;
    }

    public String getAccount_Site_IDOpp__c() {
        return Account_Site_IDOpp__c;
    }

    public String getSF_Referral_Org_ID__c() {
        return SF_Referral_Org_ID__c;
    }

    public double getSFDC_Product_Count__c() {
        return SFDC_Product_Count__c;
    }

    public String getSFDC_Provisioning_Status__c() {
        return SFDC_Provisioning_Status__c;
    }

    public String getReason_Lost_to_Competitor__c() {
        return Reason_Lost_to_Competitor__c;
    }

    public String getSubscription_Type__c() {
        return Subscription_Type__c;
    }

    public double getFinanceNonrecurring__c() {
        return FinanceNonrecurring__c;
    }

    public boolean isOne_Time_Purchase__c() {
        return One_Time_Purchase__c;
    }

    public double getProduct_Count_RSA__c() {
        return Product_Count_RSA__c;
    }

    public boolean isRevenue_on_Hold__c() {
        return Revenue_on_Hold__c;
    }

    public double getFinanceACV__c() {
        return FinanceACV__c;
    }

    public double getFinanceBaseReorderCMRR__c() {
        return FinanceBaseReorderCMRR__c;
    }

    public double getFinanceReorderCMRR__c() {
        return FinanceReorderCMRR__c;
    }

    public double getFinanceLossCMRR__c() {
        return FinanceLossCMRR__c;
    }

    public boolean isOpportunity_Record_Type_Closed__c() {
        return Opportunity_Record_Type_Closed__c;
    }

    public double getAPI_Product_Total__c() {
        return API_Product_Total__c;
    }

    public double getConvertNonRecurring__c() {
        return ConvertNonRecurring__c;
    }

    public String getReferral_Company__c() {
        return Referral_Company__c;
    }

    public boolean isAt_Risk__c() {
        return At_Risk__c;
    }

    public double getBase_Line_Amount__c() {
        return Base_Line_Amount__c;
    }

    public String getContract_End_Date__c() {
        return Contract_End_Date__c;
    }

    public String getContract_Start_Date__c() {
        return Contract_Start_Date__c;
    }

    public String getContract__c() {
        return Contract__c;
    }

    public String getRenewal_Opportunity__c() {
        return Renewal_Opportunity__c;
    }

    public String getRenewal_Period__c() {
        return Renewal_Period__c;
    }

    public String getOrder_End_Date__c() {
        return Order_End_Date__c;
    }

    public String getDocuSign_Account_Type__c() {
        return DocuSign_Account_Type__c;
    }

    public String getOpp_ID__c() {
        return Opp_ID__c;
    }

    public double getFinanceRecurringRollup__c() {
        return FinanceRecurringRollup__c;
    }

    public double getFinanceCMRR__c() {
        return FinanceCMRR__c;
    }

    public boolean isFinance_Approved__c() {
        return Finance_Approved__c;
    }

    public double getFinanceAddedYearsTCV__c() {
        return FinanceAddedYearsTCV__c;
    }

    public String getFinanceType__c() {
        return FinanceType__c;
    }

    public String getCPQ_OrderEndDate__c() {
        return CPQ_OrderEndDate__c;
    }

    public String getCPQ_Primary_Quote__c() {
        return CPQ_Primary_Quote__c;
    }

    public double getCPQ_TotalRecurringDiscount__c() {
        return CPQ_TotalRecurringDiscount__c;
    }

    public double getProduct_Count__c() {
        return Product_Count__c;
    }

    public double getFinanceNetCMRR__c() {
        return FinanceNetCMRR__c;
    }

    public double getCPQ_Total_Non_Recurring_Revenue__c() {
        return CPQ_Total_Non_Recurring_Revenue__c;
    }

    public double getCPQ_Total_Recurring_Revenue__c() {
        return CPQ_Total_Recurring_Revenue__c;
    }

    public double getProduct_Count_Unlimited__c() {
        return Product_Count_Unlimited__c;
    }

    public double getEstimated_Envelopes__c() {
        return Estimated_Envelopes__c;
    }

    public boolean isCPQ_Closed_Won__c() {
        return CPQ_Closed_Won__c;
    }

    public boolean isCPQ_Closed_for_Approval__c() {
        return CPQ_Closed_for_Approval__c;
    }

    public boolean isClosed_for_Approval_GNCMRR2__c() {
        return Closed_for_Approval_GNCMRR2__c;
    }

    public String getPrior_Stage_Value__c() {
        return Prior_Stage_Value__c;
    }

    public boolean isClosed_for_Approval_GNCMRR1__c() {
        return Closed_for_Approval_GNCMRR1__c;
    }

    public String getAccount_NA_Territory__c() {
        return Account_NA_Territory__c;
    }

    public String getDocuSign_Enrollment_Message__c() {
        return DocuSign_Enrollment_Message__c;
    }

    public String getDocuSign_Enrollment_Stage__c() {
        return DocuSign_Enrollment_Stage__c;
    }

    public boolean isQuoteIsCurrent__c() {
        return QuoteIsCurrent__c;
    }

    public String getPartner_Referring_Account2__c() {
        return Partner_Referring_Account2__c;
    }

    public double getPayment_Period_Number__c() {
        return Payment_Period_Number__c;
    }

    public String getQuoteLastModifiedDate__c() {
        return QuoteLastModifiedDate__c;
    }

    public String getDocuSignEnvironment__c() {
        return DocuSignEnvironment__c;
    }

    public String getSales_Channel__c() {
        return Sales_Channel__c;
    }

    public String getFinance_Status__c() {
        return Finance_Status__c;
    }

    public String getStage_Summary__c() {
        return Stage_Summary__c;
    }

    public double getNum_of_Opps__c() {
        return Num_of_Opps__c;
    }

    public String getOpportunity_ID_18__c() {
        return Opportunity_ID_18__c;
    }

    public boolean isClosed_Won_Email_Sent__c() {
        return Closed_Won_Email_Sent__c;
    }

    public String getPlatform_Extn_Document_Name__c() {
        return Platform_Extn_Document_Name__c;
    }

    public String getEnvelopes_Seats__c() {
        return Envelopes_Seats__c;
    }

    public double getDays_Past_Due__c() {
        return Days_Past_Due__c;
    }

    public double getPo1_Opportunities__c() {
        return Po1_Opportunities__c;
    }

    public String getSBQQ__AmendedContract__c() {
        return SBQQ__AmendedContract__c;
    }

    public boolean isSBQQ__Contracted__c() {
        return SBQQ__Contracted__c;
    }

    public boolean isSBQQ__CreateContractedPrices__c() {
        return SBQQ__CreateContractedPrices__c;
    }

    public String getSBQQ__OrderGroupID__c() {
        return SBQQ__OrderGroupID__c;
    }

    public boolean isSBQQ__Ordered__c() {
        return SBQQ__Ordered__c;
    }

    public String getSBQQ__PrimaryQuote__c() {
        return SBQQ__PrimaryQuote__c;
    }

    public String getSBQQ__QuotePricebookId__c() {
        return SBQQ__QuotePricebookId__c;
    }

    public String getSBQQ__Renewal__c() {
        return SBQQ__Renewal__c;
    }

    public String getSBQQ__RenewedContract__c() {
        return SBQQ__RenewedContract__c;
    }

    public double getSFCPQ_Envelope_Count__c() {
        return SFCPQ_Envelope_Count__c;
    }

    public double getSFCPQ_Seat_Count__c() {
        return SFCPQ_Seat_Count__c;
    }

    public double getSFCPQ_Total_NRR_Net_Price__c() {
        return SFCPQ_Total_NRR_Net_Price__c;
    }

    public boolean isStandard_Terms_ALL__c() {
        return Standard_Terms_ALL__c;
    }

    public String getBack_Dated_Renewal__c() {
        return Back_Dated_Renewal__c;
    }

    public String getBillable__c() {
        return Billable__c;
    }

    public String getFuture_Free_Discounted__c() {
        return Future_Free_Discounted__c;
    }

    public String getNegotiating_another_quote_for_Customer__c() {
        return Negotiating_another_quote_for_Customer__c;
    }

    public String getPrice_Cap_Concessions_Holds__c() {
        return Price_Cap_Concessions_Holds__c;
    }

    public String getRights_to_Future_Functionality__c() {
        return Rights_to_Future_Functionality__c;
    }

    public String getTFC_Clause__c() {
        return TFC_Clause__c;
    }

    public String getTFC_Expiration_Date__c() {
        return TFC_Expiration_Date__c;
    }

    public String getTFC_Notice_Period_for_Termination__c() {
        return TFC_Notice_Period_for_Termination__c;
    }

    public String getRefund_Right_Included_in_Order_Form__c() {
        return Refund_Right_Included_in_Order_Form__c;
    }

    public String getOpt_Out_Clause__c() {
        return Opt_Out_Clause__c;
    }

    public String getOpt_Out_Expiration_End_Date__c() {
        return Opt_Out_Expiration_End_Date__c;
    }

    public String getContracting_Entity__c() {
        return Contracting_Entity__c;
    }

    public String getNon_standard_Acceptance_Clause_in_SOW__c() {
        return Non_standard_Acceptance_Clause_in_SOW__c;
    }

    public String getRefund_Right_included_in_MSA__c() {
        return Refund_Right_included_in_MSA__c;
    }

    public String getTFC_Clause_included_in_MSA__c() {
        return TFC_Clause_included_in_MSA__c;
    }

    public String getRights_of_Return_beyond_Standard__c() {
        return Rights_of_Return_beyond_Standard__c;
    }

    public String getService_Level_Agreements__c() {
        return Service_Level_Agreements__c;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setOrder_Type__c(String order_Type__c) {
        Order_Type__c = order_Type__c;
    }

    public void setRecordTypeId(String recordTypeId) {
        RecordTypeId = recordTypeId;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        CurrencyIsoCode = currencyIsoCode;
    }

    public void setStageName(String stageName) {
        StageName = stageName;
    }

    public void setCloseDate(String closeDate) {
        CloseDate = closeDate;
    }

    public void setProduct_Interest__c(String product_Interest__c) {
        Product_Interest__c = product_Interest__c;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public void setIncumbent__c(String incumbent__c) {
        Incumbent__c = incumbent__c;
    }

    public void setCompetitor_Lost_To__c(String competitor_Lost_To__c) {
        Competitor_Lost_To__c = competitor_Lost_To__c;
    }

    public void setUse_Case__c(String use_Case__c) {
        Use_Case__c = use_Case__c;
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

    public void setUse_Case_Implementation_Contact__c(String use_Case_Implementation_Contact__c) {
        Use_Case_Implementation_Contact__c = use_Case_Implementation_Contact__c;
    }

    public void setUse_Case_Description__c(String use_Case_Description__c) {
        Use_Case_Description__c = use_Case_Description__c;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public void setProbability(double probability) {
        Probability = probability;
    }

    public void setExpectedRevenue(double expectedRevenue) {
        ExpectedRevenue = expectedRevenue;
    }

    public void setNextStep(String nextStep) {
        NextStep = nextStep;
    }

    public void setLeadSource(String leadSource) {
        LeadSource = leadSource;
    }

    public void setIsClosed(boolean isClosed) {
        IsClosed = isClosed;
    }

    public void setIsWon(boolean isWon) {
        IsWon = isWon;
    }

    public void setForecastCategory(String forecastCategory) {
        ForecastCategory = forecastCategory;
    }

    public void setForecastCategoryName(String forecastCategoryName) {
        ForecastCategoryName = forecastCategoryName;
    }

    public void setCampaignId(String campaignId) {
        CampaignId = campaignId;
    }

    public void setHasOpportunityLineItem(boolean hasOpportunityLineItem) {
        HasOpportunityLineItem = hasOpportunityLineItem;
    }

    public void setPricebook2Id(String pricebook2Id) {
        Pricebook2Id = pricebook2Id;
    }

    public void setTerritory2Id(String territory2Id) {
        Territory2Id = territory2Id;
    }

    public void setIsExcludedFromTerritory2Filter(boolean isExcludedFromTerritory2Filter) {
        IsExcludedFromTerritory2Filter = isExcludedFromTerritory2Filter;
    }

    public void setFiscalQuarter(int fiscalQuarter) {
        FiscalQuarter = fiscalQuarter;
    }

    public void setFiscalYear(int fiscalYear) {
        FiscalYear = fiscalYear;
    }

    public void setFiscal(String fiscal) {
        Fiscal = fiscal;
    }

    public void setHasOpenActivity(boolean hasOpenActivity) {
        HasOpenActivity = hasOpenActivity;
    }

    public void setHasOverdueTask(boolean hasOverdueTask) {
        HasOverdueTask = hasOverdueTask;
    }

    public void setPartner_Influence_None__c(boolean partner_Influence_None__c) {
        Partner_Influence_None__c = partner_Influence_None__c;
    }

    public void setSupport_Plan_Direct__c(double support_Plan_Direct__c) {
        Support_Plan_Direct__c = support_Plan_Direct__c;
    }

    public void setPayment_Period__c(String payment_Period__c) {
        Payment_Period__c = payment_Period__c;
    }

    public void setEstimated_Volume_Show_on_Order_Form__c(boolean estimated_Volume_Show_on_Order_Form__c) {
        Estimated_Volume_Show_on_Order_Form__c = estimated_Volume_Show_on_Order_Form__c;
    }

    public void setIsQualified__c(boolean isQualified__c) {
        IsQualified__c = isQualified__c;
    }

    public void setIsQualified_Date__c(String isQualified_Date__c) {
        IsQualified_Date__c = isQualified_Date__c;
    }

    public void setProduct_Count_Platform__c(double product_Count_Platform__c) {
        Product_Count_Platform__c = product_Count_Platform__c;
    }

    public void setUse_Case_Detail__c(String use_Case_Detail__c) {
        Use_Case_Detail__c = use_Case_Detail__c;
    }

    public void setSFDC_Envelope_Deal__c(boolean sFDC_Envelope_Deal__c) {
        SFDC_Envelope_Deal__c = sFDC_Envelope_Deal__c;
    }

    public void setCompetitors__c(String competitors__c) {
        Competitors__c = competitors__c;
    }

    public void setPayment_Type__c(String payment_Type__c) {
        Payment_Type__c = payment_Type__c;
    }

    public void setPayment_Terms__c(String payment_Terms__c) {
        Payment_Terms__c = payment_Terms__c;
    }

    public void setContract_Length_months__c(double contract_Length_months__c) {
        Contract_Length_months__c = contract_Length_months__c;
    }

    public void setProduct_Count_Just_Module__c(String product_Count_Just_Module__c) {
        Product_Count_Just_Module__c = product_Count_Just_Module__c;
    }

    public void setProduct_Count_Appliance__c(double product_Count_Appliance__c) {
        Product_Count_Appliance__c = product_Count_Appliance__c;
    }

    public void setProduct_Count_Appliance_Alert_Sent__c(boolean product_Count_Appliance_Alert_Sent__c) {
        Product_Count_Appliance_Alert_Sent__c = product_Count_Appliance_Alert_Sent__c;
    }

    public void setProduct_Count_Cartavi_new__c(double product_Count_Cartavi_new__c) {
        Product_Count_Cartavi_new__c = product_Count_Cartavi_new__c;
    }

    public void setSFDC_Deal__c(String sFDC_Deal__c) {
        SFDC_Deal__c = sFDC_Deal__c;
    }

    public void setDocuSign_Enrollment_Inherit_Features__c(boolean docuSign_Enrollment_Inherit_Features__c) {
        DocuSign_Enrollment_Inherit_Features__c = docuSign_Enrollment_Inherit_Features__c;
    }

    public void setSupport_Plan_Premier__c(double support_Plan_Premier__c) {
        Support_Plan_Premier__c = support_Plan_Premier__c;
    }

    public void setPrimary_Quote__c(String primary_Quote__c) {
        Primary_Quote__c = primary_Quote__c;
    }

    public void setZuora_Billing_Stage__c(String zuora_Billing_Stage__c) {
        Zuora_Billing_Stage__c = zuora_Billing_Stage__c;
    }

    public void setZuora_Renewal__c(boolean zuora_Renewal__c) {
        Zuora_Renewal__c = zuora_Renewal__c;
    }

    public void setZuora_Submitted__c(boolean zuora_Submitted__c) {
        Zuora_Submitted__c = zuora_Submitted__c;
    }

    public void setZuora_Subscription_ID__c(String zuora_Subscription_ID__c) {
        Zuora_Subscription_ID__c = zuora_Subscription_ID__c;
    }

    public void setSupport_Plan_Cost__c(double support_Plan_Cost__c) {
        Support_Plan_Cost__c = support_Plan_Cost__c;
    }

    public void setPartner_Go_To_Market__c(String partner_Go_To_Market__c) {
        Partner_Go_To_Market__c = partner_Go_To_Market__c;
    }

    public void setOwner_ID__c(String owner_ID__c) {
        Owner_ID__c = owner_ID__c;
    }

    public void setStage_Group__c(String stage_Group__c) {
        Stage_Group__c = stage_Group__c;
    }

    public void setProduct_Count_Rate_Plan_Envelopes__c(double product_Count_Rate_Plan_Envelopes__c) {
        Product_Count_Rate_Plan_Envelopes__c = product_Count_Rate_Plan_Envelopes__c;
    }

    public void setSupport_PlanStatus__c(String support_PlanStatus__c) {
        Support_PlanStatus__c = support_PlanStatus__c;
    }

    public void setLead_Notes__c(String lead_Notes__c) {
        Lead_Notes__c = lead_Notes__c;
    }

    public void setReferred_to_Partner__c(boolean referred_to_Partner__c) {
        Referred_to_Partner__c = referred_to_Partner__c;
    }

    public void setPayment_Type_Override__c(boolean payment_Type_Override__c) {
        Payment_Type_Override__c = payment_Type_Override__c;
    }

    public void setAccount_Owner__c(String account_Owner__c) {
        Account_Owner__c = account_Owner__c;
    }

    public void setEnable_NDSE__c(String enable_NDSE__c) {
        Enable_NDSE__c = enable_NDSE__c;
    }

    public void setCurrent_User__c(boolean current_User__c) {
        Current_User__c = current_User__c;
    }

    public void setOriginal_Authorized_Seats__c(double original_Authorized_Seats__c) {
        Original_Authorized_Seats__c = original_Authorized_Seats__c;
    }

    public void setOriginal_Contract_Length__c(double original_Contract_Length__c) {
        Original_Contract_Length__c = original_Contract_Length__c;
    }

    public void setConversion_Rate__c(double conversion_Rate__c) {
        Conversion_Rate__c = conversion_Rate__c;
    }

    public void setProduct_Count_Rate_Plan_Seats__c(double product_Count_Rate_Plan_Seats__c) {
        Product_Count_Rate_Plan_Seats__c = product_Count_Rate_Plan_Seats__c;
    }

    public void setConvertGNCMRR__c(double convertGNCMRR__c) {
        ConvertGNCMRR__c = convertGNCMRR__c;
    }

    public void setConvertACV__c(double convertACV__c) {
        ConvertACV__c = convertACV__c;
    }

    public void setConvertBaseReorderCMRR__c(double convertBaseReorderCMRR__c) {
        ConvertBaseReorderCMRR__c = convertBaseReorderCMRR__c;
    }

    public void setEstimated_Seats__c(double estimated_Seats__c) {
        Estimated_Seats__c = estimated_Seats__c;
    }

    public void setReason_Lost__c(String reason_Lost__c) {
        Reason_Lost__c = reason_Lost__c;
    }

    public void setOriginal_Envelope_Allowance__c(double original_Envelope_Allowance__c) {
        Original_Envelope_Allowance__c = original_Envelope_Allowance__c;
    }

    public void setOriginal_Opportunity_Amount__c(double original_Opportunity_Amount__c) {
        Original_Opportunity_Amount__c = original_Opportunity_Amount__c;
    }

    public void setPilot__c(boolean pilot__c) {
        Pilot__c = pilot__c;
    }

    public void setDocuSign_Enrollment_Distributor__c(String docuSign_Enrollment_Distributor__c) {
        DocuSign_Enrollment_Distributor__c = docuSign_Enrollment_Distributor__c;
    }

    public void setOrder_Start_Date__c(String order_Start_Date__c) {
        Order_Start_Date__c = order_Start_Date__c;
    }

    public void setQuote_Valid_Until__c(String quote_Valid_Until__c) {
        Quote_Valid_Until__c = quote_Valid_Until__c;
    }

    public void setEnvelope_Allowance__c(double envelope_Allowance__c) {
        Envelope_Allowance__c = envelope_Allowance__c;
    }

    public void setOverage_Charge_per_Envelope__c(double overage_Charge_per_Envelope__c) {
        Overage_Charge_per_Envelope__c = overage_Charge_per_Envelope__c;
    }

    public void setDocuSign_Enrollment_Keep_Plan__c(boolean docuSign_Enrollment_Keep_Plan__c) {
        DocuSign_Enrollment_Keep_Plan__c = docuSign_Enrollment_Keep_Plan__c;
    }

    public void setSales_Program__c(String sales_Program__c) {
        Sales_Program__c = sales_Program__c;
    }

    public void setOriginal_Opportunity_MRR__c(double original_Opportunity_MRR__c) {
        Original_Opportunity_MRR__c = original_Opportunity_MRR__c;
    }

    public void setFinanceGNCMRR__c(double financeGNCMRR__c) {
        FinanceGNCMRR__c = financeGNCMRR__c;
    }

    public void setNeedsFinanceAttn__c(boolean needsFinanceAttn__c) {
        NeedsFinanceAttn__c = needsFinanceAttn__c;
    }

    public void setDeal_Comments__c(String deal_Comments__c) {
        Deal_Comments__c = deal_Comments__c;
    }

    public void setSeat_Allowance__c(double seat_Allowance__c) {
        Seat_Allowance__c = seat_Allowance__c;
    }

    public void setOwner_Role__c(String owner_Role__c) {
        Owner_Role__c = owner_Role__c;
    }

    public void setOriginal_Start_Date__c(String original_Start_Date__c) {
        Original_Start_Date__c = original_Start_Date__c;
    }

    public void setAccount_Site_IDOpp__c(String account_Site_IDOpp__c) {
        Account_Site_IDOpp__c = account_Site_IDOpp__c;
    }

    public void setSF_Referral_Org_ID__c(String sF_Referral_Org_ID__c) {
        SF_Referral_Org_ID__c = sF_Referral_Org_ID__c;
    }

    public void setSFDC_Product_Count__c(double sFDC_Product_Count__c) {
        SFDC_Product_Count__c = sFDC_Product_Count__c;
    }

    public void setSFDC_Provisioning_Status__c(String sFDC_Provisioning_Status__c) {
        SFDC_Provisioning_Status__c = sFDC_Provisioning_Status__c;
    }

    public void setReason_Lost_to_Competitor__c(String reason_Lost_to_Competitor__c) {
        Reason_Lost_to_Competitor__c = reason_Lost_to_Competitor__c;
    }

    public void setSubscription_Type__c(String subscription_Type__c) {
        Subscription_Type__c = subscription_Type__c;
    }

    public void setFinanceNonrecurring__c(double financeNonrecurring__c) {
        FinanceNonrecurring__c = financeNonrecurring__c;
    }

    public void setOne_Time_Purchase__c(boolean one_Time_Purchase__c) {
        One_Time_Purchase__c = one_Time_Purchase__c;
    }

    public void setProduct_Count_RSA__c(double product_Count_RSA__c) {
        Product_Count_RSA__c = product_Count_RSA__c;
    }

    public void setRevenue_on_Hold__c(boolean revenue_on_Hold__c) {
        Revenue_on_Hold__c = revenue_on_Hold__c;
    }

    public void setFinanceACV__c(double financeACV__c) {
        FinanceACV__c = financeACV__c;
    }

    public void setFinanceBaseReorderCMRR__c(double financeBaseReorderCMRR__c) {
        FinanceBaseReorderCMRR__c = financeBaseReorderCMRR__c;
    }

    public void setFinanceReorderCMRR__c(double financeReorderCMRR__c) {
        FinanceReorderCMRR__c = financeReorderCMRR__c;
    }

    public void setFinanceLossCMRR__c(double financeLossCMRR__c) {
        FinanceLossCMRR__c = financeLossCMRR__c;
    }

    public void setOpportunity_Record_Type_Closed__c(boolean opportunity_Record_Type_Closed__c) {
        Opportunity_Record_Type_Closed__c = opportunity_Record_Type_Closed__c;
    }

    public void setAPI_Product_Total__c(double aPI_Product_Total__c) {
        API_Product_Total__c = aPI_Product_Total__c;
    }

    public void setConvertNonRecurring__c(double convertNonRecurring__c) {
        ConvertNonRecurring__c = convertNonRecurring__c;
    }

    public void setReferral_Company__c(String referral_Company__c) {
        Referral_Company__c = referral_Company__c;
    }

    public void setAt_Risk__c(boolean at_Risk__c) {
        At_Risk__c = at_Risk__c;
    }

    public void setBase_Line_Amount__c(double base_Line_Amount__c) {
        Base_Line_Amount__c = base_Line_Amount__c;
    }

    public void setContract_End_Date__c(String contract_End_Date__c) {
        Contract_End_Date__c = contract_End_Date__c;
    }

    public void setContract_Start_Date__c(String contract_Start_Date__c) {
        Contract_Start_Date__c = contract_Start_Date__c;
    }

    public void setContract__c(String contract__c) {
        Contract__c = contract__c;
    }

    public void setRenewal_Opportunity__c(String renewal_Opportunity__c) {
        Renewal_Opportunity__c = renewal_Opportunity__c;
    }

    public void setRenewal_Period__c(String renewal_Period__c) {
        Renewal_Period__c = renewal_Period__c;
    }

    public void setOrder_End_Date__c(String order_End_Date__c) {
        Order_End_Date__c = order_End_Date__c;
    }

    public void setDocuSign_Account_Type__c(String docuSign_Account_Type__c) {
        DocuSign_Account_Type__c = docuSign_Account_Type__c;
    }

    public void setOpp_ID__c(String opp_ID__c) {
        Opp_ID__c = opp_ID__c;
    }

    public void setFinanceRecurringRollup__c(double financeRecurringRollup__c) {
        FinanceRecurringRollup__c = financeRecurringRollup__c;
    }

    public void setFinanceCMRR__c(double financeCMRR__c) {
        FinanceCMRR__c = financeCMRR__c;
    }

    public void setFinance_Approved__c(boolean finance_Approved__c) {
        Finance_Approved__c = finance_Approved__c;
    }

    public void setFinanceAddedYearsTCV__c(double financeAddedYearsTCV__c) {
        FinanceAddedYearsTCV__c = financeAddedYearsTCV__c;
    }

    public void setFinanceType__c(String financeType__c) {
        FinanceType__c = financeType__c;
    }

    public void setCPQ_OrderEndDate__c(String cPQ_OrderEndDate__c) {
        CPQ_OrderEndDate__c = cPQ_OrderEndDate__c;
    }

    public void setCPQ_Primary_Quote__c(String cPQ_Primary_Quote__c) {
        CPQ_Primary_Quote__c = cPQ_Primary_Quote__c;
    }

    public void setCPQ_TotalRecurringDiscount__c(double cPQ_TotalRecurringDiscount__c) {
        CPQ_TotalRecurringDiscount__c = cPQ_TotalRecurringDiscount__c;
    }

    public void setProduct_Count__c(double product_Count__c) {
        Product_Count__c = product_Count__c;
    }

    public void setFinanceNetCMRR__c(double financeNetCMRR__c) {
        FinanceNetCMRR__c = financeNetCMRR__c;
    }

    public void setCPQ_Total_Non_Recurring_Revenue__c(double cPQ_Total_Non_Recurring_Revenue__c) {
        CPQ_Total_Non_Recurring_Revenue__c = cPQ_Total_Non_Recurring_Revenue__c;
    }

    public void setCPQ_Total_Recurring_Revenue__c(double cPQ_Total_Recurring_Revenue__c) {
        CPQ_Total_Recurring_Revenue__c = cPQ_Total_Recurring_Revenue__c;
    }

    public void setProduct_Count_Unlimited__c(double product_Count_Unlimited__c) {
        Product_Count_Unlimited__c = product_Count_Unlimited__c;
    }

    public void setEstimated_Envelopes__c(double estimated_Envelopes__c) {
        Estimated_Envelopes__c = estimated_Envelopes__c;
    }

    public void setCPQ_Closed_Won__c(boolean cPQ_Closed_Won__c) {
        CPQ_Closed_Won__c = cPQ_Closed_Won__c;
    }

    public void setCPQ_Closed_for_Approval__c(boolean cPQ_Closed_for_Approval__c) {
        CPQ_Closed_for_Approval__c = cPQ_Closed_for_Approval__c;
    }

    public void setClosed_for_Approval_GNCMRR2__c(boolean closed_for_Approval_GNCMRR2__c) {
        Closed_for_Approval_GNCMRR2__c = closed_for_Approval_GNCMRR2__c;
    }

    public void setPrior_Stage_Value__c(String prior_Stage_Value__c) {
        Prior_Stage_Value__c = prior_Stage_Value__c;
    }

    public void setClosed_for_Approval_GNCMRR1__c(boolean closed_for_Approval_GNCMRR1__c) {
        Closed_for_Approval_GNCMRR1__c = closed_for_Approval_GNCMRR1__c;
    }

    public void setAccount_NA_Territory__c(String account_NA_Territory__c) {
        Account_NA_Territory__c = account_NA_Territory__c;
    }

    public void setDocuSign_Enrollment_Message__c(String docuSign_Enrollment_Message__c) {
        DocuSign_Enrollment_Message__c = docuSign_Enrollment_Message__c;
    }

    public void setDocuSign_Enrollment_Stage__c(String docuSign_Enrollment_Stage__c) {
        DocuSign_Enrollment_Stage__c = docuSign_Enrollment_Stage__c;
    }

    public void setQuoteIsCurrent__c(boolean quoteIsCurrent__c) {
        QuoteIsCurrent__c = quoteIsCurrent__c;
    }

    public void setPartner_Referring_Account2__c(String partner_Referring_Account2__c) {
        Partner_Referring_Account2__c = partner_Referring_Account2__c;
    }

    public void setPayment_Period_Number__c(double payment_Period_Number__c) {
        Payment_Period_Number__c = payment_Period_Number__c;
    }

    public void setQuoteLastModifiedDate__c(String quoteLastModifiedDate__c) {
        QuoteLastModifiedDate__c = quoteLastModifiedDate__c;
    }

    public void setDocuSignEnvironment__c(String docuSignEnvironment__c) {
        DocuSignEnvironment__c = docuSignEnvironment__c;
    }

    public void setSales_Channel__c(String sales_Channel__c) {
        Sales_Channel__c = sales_Channel__c;
    }

    public void setFinance_Status__c(String finance_Status__c) {
        Finance_Status__c = finance_Status__c;
    }

    public void setStage_Summary__c(String stage_Summary__c) {
        Stage_Summary__c = stage_Summary__c;
    }

    public void setNum_of_Opps__c(double num_of_Opps__c) {
        Num_of_Opps__c = num_of_Opps__c;
    }

    public void setOpportunity_ID_18__c(String opportunity_ID_18__c) {
        Opportunity_ID_18__c = opportunity_ID_18__c;
    }

    public void setClosed_Won_Email_Sent__c(boolean closed_Won_Email_Sent__c) {
        Closed_Won_Email_Sent__c = closed_Won_Email_Sent__c;
    }

    public void setPlatform_Extn_Document_Name__c(String platform_Extn_Document_Name__c) {
        Platform_Extn_Document_Name__c = platform_Extn_Document_Name__c;
    }

    public void setEnvelopes_Seats__c(String envelopes_Seats__c) {
        Envelopes_Seats__c = envelopes_Seats__c;
    }

    public void setDays_Past_Due__c(double days_Past_Due__c) {
        Days_Past_Due__c = days_Past_Due__c;
    }

    public void setPo1_Opportunities__c(double po1_Opportunities__c) {
        Po1_Opportunities__c = po1_Opportunities__c;
    }

    public void setSBQQ__AmendedContract__c(String sBQQ__AmendedContract__c) {
        SBQQ__AmendedContract__c = sBQQ__AmendedContract__c;
    }

    public void setSBQQ__Contracted__c(boolean sBQQ__Contracted__c) {
        SBQQ__Contracted__c = sBQQ__Contracted__c;
    }

    public void setSBQQ__CreateContractedPrices__c(boolean sBQQ__CreateContractedPrices__c) {
        SBQQ__CreateContractedPrices__c = sBQQ__CreateContractedPrices__c;
    }

    public void setSBQQ__OrderGroupID__c(String sBQQ__OrderGroupID__c) {
        SBQQ__OrderGroupID__c = sBQQ__OrderGroupID__c;
    }

    public void setSBQQ__Ordered__c(boolean sBQQ__Ordered__c) {
        SBQQ__Ordered__c = sBQQ__Ordered__c;
    }

    public void setSBQQ__PrimaryQuote__c(String sBQQ__PrimaryQuote__c) {
        SBQQ__PrimaryQuote__c = sBQQ__PrimaryQuote__c;
    }

    public void setSBQQ__QuotePricebookId__c(String sBQQ__QuotePricebookId__c) {
        SBQQ__QuotePricebookId__c = sBQQ__QuotePricebookId__c;
    }

    public void setSBQQ__Renewal__c(String sBQQ__Renewal__c) {
        SBQQ__Renewal__c = sBQQ__Renewal__c;
    }

    public void setSBQQ__RenewedContract__c(String sBQQ__RenewedContract__c) {
        SBQQ__RenewedContract__c = sBQQ__RenewedContract__c;
    }

    public void setSFCPQ_Envelope_Count__c(double sFCPQ_Envelope_Count__c) {
        SFCPQ_Envelope_Count__c = sFCPQ_Envelope_Count__c;
    }

    public void setSFCPQ_Seat_Count__c(double sFCPQ_Seat_Count__c) {
        SFCPQ_Seat_Count__c = sFCPQ_Seat_Count__c;
    }

    public void setSFCPQ_Total_NRR_Net_Price__c(double sFCPQ_Total_NRR_Net_Price__c) {
        SFCPQ_Total_NRR_Net_Price__c = sFCPQ_Total_NRR_Net_Price__c;
    }

    public void setStandard_Terms_ALL__c(boolean standard_Terms_ALL__c) {
        Standard_Terms_ALL__c = standard_Terms_ALL__c;
    }

    public void setBack_Dated_Renewal__c(String back_Dated_Renewal__c) {
        Back_Dated_Renewal__c = back_Dated_Renewal__c;
    }

    public void setBillable__c(String billable__c) {
        Billable__c = billable__c;
    }

    public void setFuture_Free_Discounted__c(String future_Free_Discounted__c) {
        Future_Free_Discounted__c = future_Free_Discounted__c;
    }

    public void setNegotiating_another_quote_for_Customer__c(String negotiating_another_quote_for_Customer__c) {
        Negotiating_another_quote_for_Customer__c = negotiating_another_quote_for_Customer__c;
    }

    public void setPrice_Cap_Concessions_Holds__c(String price_Cap_Concessions_Holds__c) {
        Price_Cap_Concessions_Holds__c = price_Cap_Concessions_Holds__c;
    }

    public void setRights_to_Future_Functionality__c(String rights_to_Future_Functionality__c) {
        Rights_to_Future_Functionality__c = rights_to_Future_Functionality__c;
    }

    public void setTFC_Clause__c(String tFC_Clause__c) {
        TFC_Clause__c = tFC_Clause__c;
    }

    public void setTFC_Expiration_Date__c(String tFC_Expiration_Date__c) {
        TFC_Expiration_Date__c = tFC_Expiration_Date__c;
    }

    public void setTFC_Notice_Period_for_Termination__c(String tFC_Notice_Period_for_Termination__c) {
        TFC_Notice_Period_for_Termination__c = tFC_Notice_Period_for_Termination__c;
    }

    public void setRefund_Right_Included_in_Order_Form__c(String refund_Right_Included_in_Order_Form__c) {
        Refund_Right_Included_in_Order_Form__c = refund_Right_Included_in_Order_Form__c;
    }

    public void setOpt_Out_Clause__c(String opt_Out_Clause__c) {
        Opt_Out_Clause__c = opt_Out_Clause__c;
    }

    public void setOpt_Out_Expiration_End_Date__c(String opt_Out_Expiration_End_Date__c) {
        Opt_Out_Expiration_End_Date__c = opt_Out_Expiration_End_Date__c;
    }

    public void setContracting_Entity__c(String contracting_Entity__c) {
        Contracting_Entity__c = contracting_Entity__c;
    }

    public void setNon_standard_Acceptance_Clause_in_SOW__c(String non_standard_Acceptance_Clause_in_SOW__c) {
        Non_standard_Acceptance_Clause_in_SOW__c = non_standard_Acceptance_Clause_in_SOW__c;
    }

    public void setRefund_Right_included_in_MSA__c(String refund_Right_included_in_MSA__c) {
        Refund_Right_included_in_MSA__c = refund_Right_included_in_MSA__c;
    }

    public void setTFC_Clause_included_in_MSA__c(String tFC_Clause_included_in_MSA__c) {
        TFC_Clause_included_in_MSA__c = tFC_Clause_included_in_MSA__c;
    }

    public void setRights_of_Return_beyond_Standard__c(String rights_of_Return_beyond_Standard__c) {
        Rights_of_Return_beyond_Standard__c = rights_of_Return_beyond_Standard__c;
    }

    public void setService_Level_Agreements__c(String service_Level_Agreements__c) {
        Service_Level_Agreements__c = service_Level_Agreements__c;
    }
}
