package com.javarestassuredtemplate.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.PostPetRequest;
import com.javarestassuredtemplate.tests.DTO.Category;
import com.javarestassuredtemplate.tests.DTO.DtoPet;
import com.javarestassuredtemplate.tests.DTO.Tag;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;


public class PostPetTests extends TestBase {
    PostPetRequest postPetRequest;

    @Test
    public void inserirPetComTodosDadosValidos() throws JsonProcessingException {
        SoftAssert softAssert = new SoftAssert();

        DtoPet dtoPet = new DtoPet();

        //Parâmetros
        String id = "9999";
        String categoryId = "9998";
        String categoryName = "felinos";
        String name = "Shepherd";
        String photoUrl = "http://photodogatito.com/image123.png";
        String tagId = "9999";
        String tagName = "macho";
        String status = "available";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //montando request
        dtoPet.setId(id);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        dtoPet.setCategory(category);

        dtoPet.setName(name);

        List<String> l1 = new ArrayList<String>();
        l1.add(photoUrl);
        l1.add("teste photo");
        dtoPet.setPhotoUrls(new ArrayList<String>(l1));

        Tag tag = new Tag(tagId, tagName);
        List<Tag> l2 = new ArrayList<Tag>();
        tag.setId(tagId);
        tag.setName(tagName);
        l2.add(tag);
        dtoPet.setTags(l2);

        dtoPet.setStatus(status);

        //Fluxo
        postPetRequest = new PostPetRequest();
        //postPetRequest.setJsonBody(id, categoryId, categoryName, name, photoUrl, tagId, tagName, status);
        postPetRequest.setJsonBody(dtoPet);
        Response response = postPetRequest.executeRequest();

        //Asserções
        Assert.assertEquals(response.statusCode(), statusCodeEsperado);
        softAssert.assertEquals(response.body().jsonPath().get("id").toString(), id, "Validação id");
        softAssert.assertEquals(response.body().jsonPath().get("category.id").toString(), categoryId, "Validação categoryId");
        softAssert.assertEquals(response.body().jsonPath().get("category.name").toString(), categoryName, "Validação categoryName");
        softAssert.assertEquals(response.body().jsonPath().get("name").toString(), name, "Validação name");
        softAssert.assertEquals(response.body().jsonPath().get("photoUrls[0]").toString(), photoUrl, "Validação photoUrl");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].id").toString(), tagId, "Validação tagId");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].name").toString(), tagName, "Validação tagName");
        softAssert.assertEquals(response.body().jsonPath().get("status").toString(), status, "Validação status");
        softAssert.assertAll();
    }
}



