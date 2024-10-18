package com.Forsys.sfdc;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.json.JSONObject;

import com.Forsys.api.core.Executor;
import com.Forsys.api.core.Responses;
import com.Forsys.api.report.ExtentReportListener;

public class SfdcClient
    implements
    SalesforceOps {
    private final String QueryUri = "/services/data/v45.0/query/";
    private final String DataObjectUri = "/services/data/v45.0/sobjects/";
    private final Credentials credentials;
    private String Token;
    private String APIBaseUrl;

    public SfdcClient(Credentials credentials) {
        this.credentials = credentials;
        GetToken();
    }

    private void GetToken() {
        String url = credentials.getBaseUrl() + "/services/oauth2/token";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Accept", "*/*");

        String body = String.format(
                                    "?grant_type=password&client_id=%1$s&client_secret=%2$s&username=%3$s&password=%4$s%5$s",
                                    credentials.getSfdcClientId(),
                                    credentials.getSfdcClientSecret(),
                                    credentials.getUserName(),
                                    credentials.getPassword(),
                                    credentials.getUserToken());
        try {
            Responses response = Executor.doPostCall(url + body, "", headers);
            JSONObject jsonResponseObject = new JSONObject(response.getBody().getBodyString());
            Token = jsonResponseObject.get("access_token").toString();
            APIBaseUrl = jsonResponseObject.get("instance_url").toString();
            if (Token == null || !response.getResponseCode().equals("200")) {
                ExtentReportListener.extent_test.get()
                                                .error("Error requesting token from Salesforce: " + jsonResponseObject
                                                                                                                      .toString());
                throw new RuntimeException("Request for Salesforce Token failed. " + jsonResponseObject.toString());
            }
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info("Exception while receiving sfdc access_token" + e.getMessage());
            throw new RuntimeException("Exception while receiving sfdc access_token" + e.getMessage());
        }
    }

    @Override
    public String createSalesforceObject(String objectName, Object obj) {
        String result = null;
        String url = APIBaseUrl + DataObjectUri + objectName;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Inclusion.NON_NULL);
        mapper.setSerializationInclusion(Inclusion.NON_DEFAULT);
        try {
            String jsonBody = mapper.writeValueAsString(obj);
            Responses response = Executor.doPostCall(url, jsonBody, getHeaders());
            result = response.getBody().getBodyString();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info("Unable to Create the salesforce object:" + e.getMessage());
            throw new RuntimeException("Exception while creating salesfoce object");
        }
        return result;
    }

    @Override
    public Responses createSalesforceObjectResponse(String objectName, Object obj) {
        Responses response;
        String url = APIBaseUrl + DataObjectUri + objectName;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Inclusion.NON_NULL);
        mapper.setSerializationInclusion(Inclusion.NON_DEFAULT);
        try {
            String jsonBody = mapper.writeValueAsString(obj);
            response = Executor.doPostCall(url, jsonBody, getHeaders());
            // result = response.getBody().getBodyString();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info("Unable to Create the salesforce object:" + e.getMessage());
            throw new RuntimeException("Exception while creating salesfoce object");
        }
        return response;
    }

    @Override
    public String deleteSalesforceObject(String objectName, String id) {
        String result = null;
        String url = APIBaseUrl + DataObjectUri + objectName + "/" + id;
        try {
            Responses response = Executor.doDeleteCall(url, null, getHeaders());
            result = response.getBody().getBodyString();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info("Unable to Delete the salesforce object:" + e.getMessage());
            throw new RuntimeException("Exception while Deleting salesforce object");
        }
        return result;
    }

    @Override
    public String getSalesforceObject(String objectName, String id) {
        String result = null;
        String url = APIBaseUrl + DataObjectUri + objectName + "/" + id;
        try {
            Responses response = Executor.doGetCall(url, getHeaders());
            result = response.getBody().getBodyString();
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info("Unable to GET the salesforce object:" + e.getMessage());
            throw new RuntimeException("Exception while Getting salesforce object");
        }
        return result;
    }

    @Override
    public String submitSOQLQuery(String query) {
        String result = null;
        String url = APIBaseUrl + QueryUri;
        List<NameValuePair> nvPairList = new ArrayList<NameValuePair>();
        NameValuePair nv2 = new BasicNameValuePair("q", query);
        nvPairList.add(nv2);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        Map<String, String> headers = getHeaders();
        for (String s : headers.keySet()) {
            request.addHeader(s, headers.get(s));
        }
        try {
            URI uri = new URIBuilder(request.getURI()).addParameters(nvPairList).build();
            request.setURI(uri);

            HttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() != 200) {
                ExtentReportListener.extent_test.get()
                                                .info("Unable to find expected records array in SOQL response. The Response code: " +
                                                      response.getStatusLine().getStatusCode());
                throw new RuntimeException("Exception while querying for the given SOQL query. The Response code: " +
                                           response.getStatusLine().getStatusCode());
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            ExtentReportListener.extent_test.get()
                                            .info("Unable to find expected records array in SOQL response:" + e
                                                                                                               .getMessage());
            throw new RuntimeException("Exception while querying for the given SOQL query");
        }
        return result;
    }

    @Override
    public String updateSalesforceObject(String objectName, String id, Object o) {
        String result = null;
        String url = APIBaseUrl + DataObjectUri + objectName + "/" + id;
        HttpClient client = HttpClientBuilder.create().build();
        HttpPatch request = new HttpPatch(url);
        Map<String, String> headers = getHeaders();
        for (String s : headers.keySet()) {
            request.addHeader(s, headers.get(s));
        }
        try {
            URI uri = new URIBuilder(request.getURI()).build();
            request.setURI(uri);
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            ExtentReportListener.extent_test.get().info("Unable to Update Sfdc record" + e.getMessage());
            throw new RuntimeException("Exception while updating sfdc record");
        }
        return result;
    }

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>() {
            /**
             * 
             */
            private static final long serialVersionUID = 2381515173015022286L;

            {
                // put("Content-Type", "application/json");
                put("Accept", "*/*");
                put("Authorization", "OAuth " + Token);
            }
        };
        return headers;
    }

    public static void main(String[] args) throws IOException {}

}
