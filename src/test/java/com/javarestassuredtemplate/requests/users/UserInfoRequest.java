package com.javarestassuredtemplate.requests.users;

import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class UserInfoRequest extends RequestRestBase {
    public UserInfoRequest(){
        //url = "http://127.0.0.1/mantis";
        requestService = "/api/rest/users/me";
        method = Method.GET;
    }
}
