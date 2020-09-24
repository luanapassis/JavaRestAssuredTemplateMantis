package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetIssueReportedByMeRequest extends RequestRestBase {

    public GetIssueReportedByMeRequest()
    {
        requestService = "/api/rest/issues?filter_id=reported";
        method = Method.GET;
    }
}
