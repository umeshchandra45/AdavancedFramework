package com.Forsys.hub.model;

public class BillingInformation {
    private String accountId;
    private String billingAccountId;
    private String accountLocationId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountLocationId() {
        return accountLocationId;
    }

    public void setAccountLocationId(String accountLocationId) {
        this.accountLocationId = accountLocationId;
    }

    public String getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(String billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

}
