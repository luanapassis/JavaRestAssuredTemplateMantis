package com.javarestassuredtemplate.tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.UsuariosDBSteps;
import com.javarestassuredtemplate.requests.GetPetRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

public class GetPetTests extends TestBase {
    GetPetRequest getPetRequest;

    @Test
    public void buscarPetExistente(){
        SoftAssert softAssert = new SoftAssert();

        //Parâmetros
        String petId = "1";
        int statusCodeEsperado = HttpStatus.SC_OK;
        String categoryId = "9999";
        String categoryName = "felinos";
        String name = "Shepherd";
        String photoUrl = "http://photodogatito.com/image123.png";
        String tagId = "9999";
        String tagName = "macho";
        String status = "available";

        //Fluxo
        getPetRequest = new GetPetRequest(petId);
        Response response = getPetRequest.executeRequest();

        String tst = response.body().jsonPath().get().toString();

        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("name(.*?)doggie").matcher(tst);
        while (m.find())
        {
            allMatches.add(m.group());
        }
        Assert.assertTrue(allMatches.size()>=1);

        //Asserções
        Assert.assertEquals(response.statusCode(), statusCodeEsperado);
        softAssert.assertEquals(response.body().jsonPath().get("id").toString(), petId, "Validação id");
        softAssert.assertEquals(response.body().jsonPath().get("category.id").toString(), categoryId, "Validação categoryId");
        softAssert.assertEquals(response.body().jsonPath().get("category.name").toString(), categoryName, "Validação categoryName");
        softAssert.assertEquals(response.body().jsonPath().get("name").toString(), name,  "Validação name");
        softAssert.assertEquals(response.body().jsonPath().get("photoUrls[0]").toString(), photoUrl, "Validação photoUrl");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].id").toString(), tagId, "Validação tagId");
        softAssert.assertEquals(response.body().jsonPath().get("tags[0].name").toString(), tagName, "Validação tagName");
        softAssert.assertEquals(response.body().jsonPath().get("status").toString(), status, "Validação status");
        softAssert.assertAll();
    }
}
