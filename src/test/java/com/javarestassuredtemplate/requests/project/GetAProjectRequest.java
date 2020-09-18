package com.javarestassuredtemplate.requests.project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetAProjectRequest extends RequestRestBase {

    public  GetAProjectRequest(String projectId)
    {
        requestService = "/api/rest/projects/"+projectId;
        method = Method.GET;
    }
}
