package com.javarestassuredtemplate.tests.project;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.project.GetAProjectRequest;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class GetAProjectTests extends TestBase {

    GetAProjectRequest getAProjectRequest;

    @Test
    public void retornaProjetoPrincipal()
    {
        String nomeProjetoEsperado = "Teste";
        String idProjetoEsperado = "1";

        getAProjectRequest = new GetAProjectRequest(idProjetoEsperado);

        Response response = getAProjectRequest.executeRequest();

        List<Map<String, String>> projects = response.jsonPath().getList("projects");
        String nomeRetornado = projects.get(0).get("name");
        String idRetornado = String.valueOf(projects.get(0).get("id"));

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(nomeRetornado, nomeProjetoEsperado);
        Assert.assertEquals(idProjetoEsperado, idRetornado);
    }
    @Test
    public void retornaSubProjeto()
    {
        String nomeProjetoEsperado = "Teste SubProjeto";
        String idProjetoEsperado = "2";

        getAProjectRequest = new GetAProjectRequest(idProjetoEsperado);

        Response response = getAProjectRequest.executeRequest();

        List<Map<String, String>> projects = response.jsonPath().getList("projects");
        String nomeRetornado = projects.get(0).get("name");
        String idRetornado = String.valueOf(projects.get(0).get("id"));

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(nomeRetornado, nomeProjetoEsperado);
        Assert.assertEquals(idProjetoEsperado, idRetornado);
    }
    @Test
    public void retornaProjetoInvalido()
    {
        String idProjetoEsperado = "99";
        String mensagemEsperada = "Project #99 not found";

        getAProjectRequest = new GetAProjectRequest(idProjetoEsperado);

        Response response = getAProjectRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(response.body().jsonPath().get("message").toString(), mensagemEsperada);
    }
    @Test
    public void verificaStatusProjeto()
    {
        String statusEsperado = "true";
        String idProjetoEsperado = "2";

        getAProjectRequest = new GetAProjectRequest(idProjetoEsperado);

        Response response = getAProjectRequest.executeRequest();

        List<Map<String, String>> projects = response.jsonPath().getList("projects");
        String statusRetornado = String.valueOf (projects.get(0).get("enabled"));

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertEquals(statusRetornado, statusEsperado);
    }
}
