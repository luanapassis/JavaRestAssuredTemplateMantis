package com.javarestassuredtemplate.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.PostPetRequest;
import com.javarestassuredtemplate.tests.DTO.Category;
import com.javarestassuredtemplate.tests.DTO.DtoPet;
import com.javarestassuredtemplate.tests.DTO.Tag;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class PostPetTests extends TestBase {
    PostPetRequest postPetRequest;


    public void inserirPetComTodosDadosValidos() throws JsonProcessingException {
        SoftAssert softAssert = new SoftAssert();



        //Parâmetros de entrada
        String id = "9999";
        String categoryId = "9998";
        String categoryName = "felinos";
        String name = "Shepherd";
        String photoUrl = "http://photodogatito.com/image123.png";
        String tagId = "9999";
        String tagName = "macho";
        String status = "available";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //Contruindo Objeto
        JSONObject pet = new JSONObject();
        JSONObject category = new JSONObject();
        JSONObject tag1 = new JSONObject();
        JSONObject tag2 = new JSONObject();
        JSONArray tags = new JSONArray();
        JSONArray photoURLs = new JSONArray();

        pet.put("id", 99998);
        pet.put("name", "Shepherd");
        pet.put("status", "available");
        category.put("id", 99998);
        category.put("name", "felino");
        pet.put("category", category);
        tag1.put("id", 99998);
        tag1.put("name", "Sem raça definida");
        tag2.put("id", 99999);
        tag2.put("name", "Amarelo");
        tags.add(tag1);
        tags.add(tag2);
        pet.put("tags", tags);
        photoURLs.add("fotosdegato.com.br/foto1.png");
        photoURLs.add("fotosdegato.com.br/foto2.png");
        pet.put("photoUrls", photoURLs);

        /*
        //Contruindo Objeto
        DtoPet dtoPet = new DtoPet();

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

         */

        //Fluxo
        postPetRequest = new PostPetRequest();
        //postPetRequest.setJsonBody(id, categoryId, categoryName, name, photoUrl, tagId, tagName, status);
        postPetRequest.setJsonBody(pet);
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



