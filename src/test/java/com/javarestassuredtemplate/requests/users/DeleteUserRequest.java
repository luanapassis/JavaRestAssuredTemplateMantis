package com.javarestassuredtemplate.requests.users;


import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;

public class DeleteUserRequest extends RequestRestBase {

    public DeleteUserRequest(String userId){
        requestService = "/api/rest/users/"+userId;
        method = Method.DELETE;

    }
}
