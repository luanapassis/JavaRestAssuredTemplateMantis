package com.javarestassuredtemplate.tests.project;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.project.GetAllProjectRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GetAllProjectTests extends TestBase {

    GetAllProjectRequest getAllProjectRequest;

    @Test
    public void retornaTodosOsProjetos()
    {
        String nomeProjetoEsperado = "Teste";
        String idProjetoEsperado = "1";

        getAllProjectRequest = new GetAllProjectRequest();

        Response response = getAllProjectRequest.executeRequest();

        List<Map<String, String>> projects = response.jsonPath().getList("projects");
        String nomeRetornado = projects.get(0).get("name");
        String idRetornado = String.valueOf(projects.get(0).get("id"));

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(nomeRetornado, nomeProjetoEsperado);
        Assert.assertEquals(idProjetoEsperado, idRetornado);
    }
    @Test
    public void retornaTodosOsProjetosVerificaSubProjeto()
    {
        String nomeProjetoEsperado = "Teste SubProjeto";
        String idProjetoEsperado = "2";

        getAllProjectRequest = new GetAllProjectRequest();

        Response response = getAllProjectRequest.executeRequest();

        List<Map<String, String>> projects = response.jsonPath().getList("projects");
        String nomeRetornado = projects.get(1).get("name");
        String idRetornado = String.valueOf(projects.get(1).get("id"));

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(nomeRetornado, nomeProjetoEsperado);
        Assert.assertEquals(idProjetoEsperado, idRetornado);
    }
}
