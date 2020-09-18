package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetIssueForProjectRequest extends RequestRestBase {

    public GetIssueForProjectRequest(String idProject)
    {
        method = Method.GET;
        requestService = "/api/rest/issues?project_id="+idProject;
    }
}
