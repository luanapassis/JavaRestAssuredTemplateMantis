package com.javarestassuredtemplate.requests.lang;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class LangMultipleLocalizedRequest extends RequestRestBase {

    public LangMultipleLocalizedRequest(String string1)
    {
        requestService = "/api/rest/lang?string[]="+string1;
        method = Method.GET;
    }
}
