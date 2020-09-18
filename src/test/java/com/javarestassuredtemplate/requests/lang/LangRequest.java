package com.javarestassuredtemplate.requests.lang;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class LangRequest extends RequestRestBase {

    public LangRequest(){
        method = Method.GET;
        requestService = "/api/rest/lang?string=all_projects";
    }
}
