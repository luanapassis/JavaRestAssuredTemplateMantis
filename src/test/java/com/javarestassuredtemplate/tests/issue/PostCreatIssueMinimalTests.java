package com.javarestassuredtemplate.tests.issue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.PostCreateIssueMinimalRequest;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.response.Response;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;

public class PostCreatIssueMinimalTests extends TestBase {

    @Test
    public void criaTarefaSucesso() throws JsonProcessingException {
        String summary = "SummaryAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "Teste";

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

    }
    @Test
    public void criaTarefaSemNome()
    {
        String summary = "";
        String description = "DescriptionAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "Teste";

        String mensagemEsperada = "Summary not specified";
    }
   @Test
   public void criaTarefaSemDescricao()
   {
       String summary = "SummaryAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
       String description = "";
       String categoryName = "General";
       String projectName = "Teste";

       String mensagemEsperada = "Description not specified";

   }
    @Test
    public void criaTarefaSemProjeto()
    {
        String summary = "SummaryAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "";

        String mensagemEsperada = "Project not specified";
    }
     @Test
    public void CriaTarefaProjetoInvalido()
    {
        String summary = "SummaryAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPI_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String categoryName = "General";
        String projectName = "sfsadfafadasfsdafa";

        String mensagemEsperada = "Project not specified";
    }
}
