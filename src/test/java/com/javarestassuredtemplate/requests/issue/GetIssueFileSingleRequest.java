package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetIssueFileSingleRequest extends RequestRestBase {

    public GetIssueFileSingleRequest(String issueId, String fileId )
    {
        method = Method.GET;
        requestService = "/api/rest/issues/"+issueId+"/files/"+fileId+"";
    }
}
