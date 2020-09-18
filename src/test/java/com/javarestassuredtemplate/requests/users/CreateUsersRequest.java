package com.javarestassuredtemplate.requests.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.models.createUsersDTO.CreateUsersDTO;
import io.restassured.http.Method;
import io.restassured.internal.mapping.JsonbMapper;

public class CreateUsersRequest extends RequestRestBase {

    public CreateUsersRequest(){
        requestService = "/api/rest/users/";
        method = Method.POST;
    }

    public void setJsonBody(CreateUsersDTO request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        jsonBody = mapper.writeValueAsString(request);
    }
}
