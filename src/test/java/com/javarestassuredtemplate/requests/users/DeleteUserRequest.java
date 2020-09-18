package com.javarestassuredtemplate.requests.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.models.createUsersDTO.CreateUsersDTO;
import io.restassured.http.Method;

public class DeleteUserRequest extends RequestRestBase {

    public DeleteUserRequest(String userId){
        requestService = "/api/rest/users/"+userId;
        method = Method.DELETE;

    }
}
