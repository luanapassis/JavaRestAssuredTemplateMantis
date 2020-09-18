package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetIssueMonitoredByMeRequest extends RequestRestBase {

    public GetIssueMonitoredByMeRequest()
    {
        requestService = "/api/rest/issues?filter_id=monitored";
        method = Method.GET;
    }
}
