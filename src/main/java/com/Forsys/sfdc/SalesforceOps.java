package com.Forsys.sfdc;

import com.Forsys.api.core.Responses;

public interface SalesforceOps {

    public String createSalesforceObject(String objectName, Object obj);

    public String deleteSalesforceObject(String objectName, String id);

    public String getSalesforceObject(String objectName, String id);

    public String submitSOQLQuery(String query);

    public String updateSalesforceObject(String objectName, String id, Object o);

    public Responses createSalesforceObjectResponse(String objectName, Object obj);
}
