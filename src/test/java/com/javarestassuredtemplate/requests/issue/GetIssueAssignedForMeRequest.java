package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetIssueAssignedForMeRequest extends RequestRestBase {

    public GetIssueAssignedForMeRequest()
    {
        method = Method.GET;
        requestService = "/api/rest/issues?filter_id=assigned";
    }
}
