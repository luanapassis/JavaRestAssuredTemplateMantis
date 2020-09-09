package com.javarestassuredtemplate.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.RequestRestBase;
import com.javarestassuredtemplate.tests.DTO.DtoPet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.Method;

public class PostPetRequest extends RequestRestBase {
    public PostPetRequest(){
        requestService = "/pet";
        method = Method.POST;
    }

    public void setJsonBody(DtoPet request) throws JsonProcessingException {
        DtoPet request2 = new DtoPet();
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
