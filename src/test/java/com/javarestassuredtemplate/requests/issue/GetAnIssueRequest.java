package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetAnIssueRequest extends RequestRestBase {

    public GetAnIssueRequest(String issueId)
    {
        method = Method.GET;
        requestService = "/api/rest/issues/"+issueId;
    }
}
