package com.javarestassuredtemplate.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.tests.DTO.DtoPet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.Method;
import net.minidev.json.JSONObject;

public class PostPetRequest extends RequestRestBase {
    public PostPetRequest(){
        requestService = "/pet";
        method = Method.POST;
        url = "https://petstore.swagger.io/v2";
    }

    public void setJsonBody(JSONObject request) throws JsonProcessingException {

        /*
        String id,
                            String categoryId,
                            String categoryName,
                            String name,
                            String photoUrl,
                            String tagId,
                            String tagName,
                            String status

        jsonBody = GeneralUtils.readFileToAString("src/test/java/com/javarestassuredtemplate/jsons/PostPetJson.json");

        jsonBody = jsonBody.replace("$id", id)
                           .replace("$categoryId", categoryId)
                           .replace("$categoryName", categoryName)
                           .replace("$name", name)
                           .replace("$photoUrl", photoUrl)
                           .replace("$tagId", tagId)
                           .replace("$tagName", tagName)
                           .replace("$status", status);

         */


        // create the mapper
        ObjectMapper mapper = new ObjectMapper();
        // enable pretty printing
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        jsonBody = mapper.writeValueAsString(request);
    }
}
