package com.javarestassuredtemplate.tests.issue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.PostCreateIssueMinimalRequest;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class PostCreatIssueMinimalTests extends TestBase {

    @Test
    public void criaTarefaSucesso() throws JsonProcessingException {
        String summary = "SummaryAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "Teste";

        String statusLineEsperado = "Issue Created";

        JSONObject issue = new JSONObject();
        JSONObject category = new JSONObject();
        JSONObject project = new JSONObject();

        issue.put("summary", summary);
        issue.put("description", description);
        category.put("name", categoryName);
        issue.put("category", category);
        project.put("name", projectName);
        issue.put("project", project);

        PostCreateIssueMinimalRequest postCreateIssueMinimalRequest = new PostCreateIssueMinimalRequest();

        postCreateIssueMinimalRequest.setJsonBody(issue);

        Response response = postCreateIssueMinimalRequest.executeRequest();

        Map <String, String> responseBodyIssue = response.getBody().jsonPath().get("issue");
        String idResponse = String.valueOf (responseBodyIssue.get("id"));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains(statusLineEsperado));
        Assert.assertTrue(response.getStatusLine().contains(idResponse));
    }
    @Test
    public void criaTarefaSemNome() throws JsonProcessingException {
        String summary = "";
        String description = "DescriptionAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "Teste";

        String mensagemEsperada = "Summary not specified";

        JSONObject issue = new JSONObject();
        JSONObject category = new JSONObject();
        JSONObject project = new JSONObject();

        issue.put("summary", summary);
        issue.put("description", description);
        category.put("name", categoryName);
        issue.put("category", category);
        project.put("name", projectName);
        issue.put("project", project);

        PostCreateIssueMinimalRequest postCreateIssueMinimalRequest = new PostCreateIssueMinimalRequest();

        postCreateIssueMinimalRequest.setJsonBody(issue);

        Response response = postCreateIssueMinimalRequest.executeRequest();

        String mensagemRetornada = response.getBody().jsonPath().get("message");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals( mensagemRetornada, mensagemEsperada);

    }
   @Test
   public void criaTarefaSemDescricao() throws JsonProcessingException {
       String summary = "SummaryAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
       String description = "";
       String categoryName = "General";
       String projectName = "Teste";

       String mensagemEsperada = "Description not specified";
       JSONObject issue = new JSONObject();
       JSONObject category = new JSONObject();
       JSONObject project = new JSONObject();

       issue.put("summary", summary);
       issue.put("description", description);
       category.put("name", categoryName);
       issue.put("category", category);
       project.put("name", projectName);
       issue.put("project", project);

       PostCreateIssueMinimalRequest postCreateIssueMinimalRequest = new PostCreateIssueMinimalRequest();

       postCreateIssueMinimalRequest.setJsonBody(issue);

       Response response = postCreateIssueMinimalRequest.executeRequest();

       String mensagemRetornada = response.getBody().jsonPath().get("message");

       Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
       Assert.assertEquals( mensagemRetornada, mensagemEsperada);
   }
    @Test
    public void criaTarefaSemProjeto() throws JsonProcessingException {
        String summary = "SummaryAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "";

        String mensagemEsperada = "Project not specified";
        JSONObject issue = new JSONObject();
        JSONObject category = new JSONObject();
        JSONObject project = new JSONObject();

        issue.put("summary", summary);
        issue.put("description", description);
        category.put("name", categoryName);
        issue.put("category", category);
        project.put("name", projectName);
        issue.put("project", project);

        PostCreateIssueMinimalRequest postCreateIssueMinimalRequest = new PostCreateIssueMinimalRequest();

        postCreateIssueMinimalRequest.setJsonBody(issue);

        Response response = postCreateIssueMinimalRequest.executeRequest();

        String mensagemRetornada = response.getBody().jsonPath().get("message");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals( mensagemRetornada, mensagemEsperada);
    }
     @Test
    public void CriaTarefaProjetoInvalido() throws JsonProcessingException {
        String summary = "SummaryAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "sfsadfafadasfsdafa";

        String mensagemEsperada = "Project not specified";

        JSONObject issue = new JSONObject();
        JSONObject category = new JSONObject();
        JSONObject project = new JSONObject();

        issue.put("summary", summary);
        issue.put("description", description);
        category.put("name", categoryName);
        issue.put("category", category);
        project.put("name", projectName);
        issue.put("project", project);

        PostCreateIssueMinimalRequest postCreateIssueMinimalRequest = new PostCreateIssueMinimalRequest();

        postCreateIssueMinimalRequest.setJsonBody(issue);

        Response response = postCreateIssueMinimalRequest.executeRequest();

        String mensagemRetornada = response.getBody().jsonPath().get("message");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals( mensagemRetornada, mensagemEsperada);
    }
}
