package com.Forsys.Pojos;

public class Address {
    public String Name;
    public String BillingStreet;
    public String BillingCity;
    public String BillingState;
    public String BillingZip;
    public String BillingCountry;
    public String BillingPhone;
    public String ShippingStreet;
    public String ShippingCity;
    public String ShippingCountry;
    public String ShippingState;
    public String ShippingPostalCode;
    public String ShippingPhone;
    public String CurrencyCode;

    public Address() {

    }

    public Address(String name,
                   String billingStreet,
                   String billingCity,
                   String billingState,
                   String billingZip,
                   String billingCountry,
                   String billingPhone,
                   String shippingStreet,
                   String shippingCity,
                   String shippingCountry,
                   String shippingState,
                   String shippingPostalCode,
                   String shippingPhone,
                   String currencyCode) {
        Name = name;
        BillingStreet = billingStreet;
        BillingCity = billingCity;
        BillingState = billingState;
        BillingZip = billingZip;
        BillingCountry = billingCountry;
        BillingPhone = billingPhone;
        ShippingStreet = shippingStreet;
        ShippingCity = shippingCity;
        ShippingCountry = shippingCountry;
        ShippingState = shippingState;
        ShippingPostalCode = shippingPostalCode;
        ShippingPhone = shippingPhone;
        CurrencyCode = currencyCode;
    }

    public String getName() {
        return Name;
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

    public String getBillingZip() {
        return BillingZip;
    }

    public String getBillingCountry() {
        return BillingCountry;
    }

    public String getBillingPhone() {
        return BillingPhone;
    }

    public String getShippingStreet() {
        return ShippingStreet;
    }

    public String getShippingCity() {
        return ShippingCity;
    }

    public String getShippingCountry() {
        return ShippingCountry;
    }

    public String getShippingState() {
        return ShippingState;
    }

    public String getShippingPostalCode() {
        return ShippingPostalCode;
    }

    public String getShippingPhone() {
        return ShippingPhone;
    }

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public void setName(String name) {
        Name = name;
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

    public void setBillingZip(String billingZip) {
        BillingZip = billingZip;
    }

    public void setBillingCountry(String billingCountry) {
        BillingCountry = billingCountry;
    }

    public void setBillingPhone(String billingPhone) {
        BillingPhone = billingPhone;
    }

    public void setShippingStreet(String shippingStreet) {
        ShippingStreet = shippingStreet;
    }

    public void setShippingCity(String shippingCity) {
        ShippingCity = shippingCity;
    }

    public void setShippingCountry(String shippingCountry) {
        ShippingCountry = shippingCountry;
    }

    public void setShippingState(String shippingState) {
        ShippingState = shippingState;
    }

    public void setShippingPostalCode(String shippingPostalCode) {
        ShippingPostalCode = shippingPostalCode;
    }

    public void setShippingPhone(String shippingPhone) {
        ShippingPhone = shippingPhone;
    }

    public void setCurrencyCode(String currencyCode) {
        CurrencyCode = currencyCode;
    }

}
