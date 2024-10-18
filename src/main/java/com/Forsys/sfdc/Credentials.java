package com.Forsys.sfdc;

public class Credentials {

    public String userName;
    public String password;
    public String baseUrl;
    public String userToken;
    public String sfdcClientId;
    public String sfdcClientSecret;

    public Credentials(String baseUrl,
                       String userName,
                       String passWord,
                       String userToken,
                       String sfdcClientId,
                       String sfdcClientSecret) {
        this.userName = userName;
        this.password = passWord;
        this.baseUrl = baseUrl;
        this.userToken = userToken;
        this.sfdcClientId = sfdcClientId;
        this.sfdcClientSecret = sfdcClientSecret;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getSfdcClientId() {
        return sfdcClientId;
    }

    public void setSfdcClientId(String sfdcClientId) {
        this.sfdcClientId = sfdcClientId;
    }

    public String getSfdcClientSecret() {
        return sfdcClientSecret;
    }

    public void setSfdcClientSecret(String sfdcClientSecret) {
        this.sfdcClientSecret = sfdcClientSecret;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
