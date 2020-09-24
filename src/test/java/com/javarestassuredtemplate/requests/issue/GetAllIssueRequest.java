package com.javarestassuredtemplate.requests.issue;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetAllIssueRequest extends RequestRestBase {

    public GetAllIssueRequest(String pageSize , String page)
    {
        method = Method.GET;
        requestService = "/api/rest/issues?page_size="+pageSize+"&page="+page;


    }
}
