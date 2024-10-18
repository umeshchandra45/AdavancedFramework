package com.Forsys.Pojos;

import java.util.ArrayList;
import java.util.List;

public class Installed {
    private String client_id;
    private String project_id;
    private String auth_uri;
    private String token_uri;
    private String auth_provider_x509_cert_url;
    private String client_secret;

    public Installed(String client_id,
                     String project_id,
                     String auth_uri,
                     String token_uri,
                     String auth_provider_x509_cert_url,
                     String client_secret,
                     List<String> redirect_uris) {
        this.client_id = client_id;
        this.project_id = project_id;
        this.auth_uri = auth_uri;
        this.token_uri = token_uri;
        this.auth_provider_x509_cert_url = auth_provider_x509_cert_url;
        this.client_secret = client_secret;
        this.redirect_uris = redirect_uris;
    }

    private List<String> redirect_uris = new ArrayList<String>();

    public String getclient_id() {
        return client_id;
    }

    public void setclient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getproject_id() {
        return project_id;
    }

    public void setproject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getauth_uri() {
        return auth_uri;
    }

    public void setauth_uri(String auth_uri) {
        this.auth_uri = auth_uri;
    }

    public String gettoken_uri() {
        return token_uri;
    }

    public void settoken_uri(String token_uri) {
        this.token_uri = token_uri;
    }

    public String getauth_provider_x509_cert_url() {
        return auth_provider_x509_cert_url;
    }

    public void setauth_provider_x509_cert_url(String auth_provider_x509_cert_url) {
        this.auth_provider_x509_cert_url = auth_provider_x509_cert_url;
    }

    public String getclient_secret() {
        return client_secret;
    }

    public void setclient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public List<String> getredirect_uris() {
        return redirect_uris;
    }

    public void setredirect_uris(List<String> redirect_uris) {
        this.redirect_uris = redirect_uris;
    }
}
