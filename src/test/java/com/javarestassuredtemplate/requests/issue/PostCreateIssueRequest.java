package com.javarestassuredtemplate.requests.issue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.models.createIssueDTO.CreateIssueDTO;
import com.javarestassuredtemplate.models.createUsersDTO.CreateUsersDTO;
import io.restassured.http.Method;

public class PostCreateIssueRequest extends RequestRestBase {
    public PostCreateIssueRequest()
    {
        requestService = "/api/rest/issues";
        method = Method.POST;
    }
    public void setJsonBody(CreateIssueDTO request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        jsonBody = mapper.writeValueAsString(request);
    }
}
