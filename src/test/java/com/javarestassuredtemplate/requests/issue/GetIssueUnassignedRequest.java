package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetIssueUnassignedRequest extends RequestRestBase {

    public GetIssueUnassignedRequest()
    {
        requestService = "/api/rest/issues?filter_id=unassigned";
        method = Method.GET;
    }
}
