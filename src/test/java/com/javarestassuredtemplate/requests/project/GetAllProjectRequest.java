package com.javarestassuredtemplate.requests.project;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetAllProjectRequest extends RequestRestBase {

    public GetAllProjectRequest()
    {
        requestService = "/api/rest/projects/";
        method = Method.GET;
    }
}
