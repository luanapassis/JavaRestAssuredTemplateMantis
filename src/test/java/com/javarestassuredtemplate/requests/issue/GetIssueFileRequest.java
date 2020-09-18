package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetIssueFileRequest extends RequestRestBase {

    public GetIssueFileRequest(String issueId)
    {
        method = Method.GET;
        requestService = "/api/rest/issues/"+issueId+"/files";
    }
}
