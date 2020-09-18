package com.javarestassuredtemplate.requests.issue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.JsonObject;
import com.javarestassuredtemplate.bases.RequestRestBase;
import io.restassured.http.Method;
import net.minidev.json.JSONObject;

public class PostCreateIssueMinimalRequest extends RequestRestBase {

    public PostCreateIssueMinimalRequest()
    {
        method = Method.POST;
        requestService = "/api/rest/issues/";
    }
    public void setJsonBody(JSONObject request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        jsonBody = mapper.writeValueAsString(request);
    }
}
