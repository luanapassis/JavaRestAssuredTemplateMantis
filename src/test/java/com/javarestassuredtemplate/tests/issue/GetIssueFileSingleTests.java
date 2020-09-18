package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.DataBaseSteps;
import com.javarestassuredtemplate.requests.issue.GetIssueFileSingleRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GetIssueFileSingleTests extends TestBase {

    GetIssueFileSingleRequest getIssueFileSingleRequest;
    DataBaseSteps dataBaseSteps;

    @Test
    public void retornaTarefaSemDocumentoPorIdDocumento()
    {
        dataBaseSteps = new DataBaseSteps();

        ArrayList<String> tarefa = dataBaseSteps.retornaTarefaAleatoria();

        String issueId = tarefa.get(0);
        String fileId = "99";

        getIssueFileSingleRequest = new GetIssueFileSingleRequest(issueId, fileId);

        Response response = getIssueFileSingleRequest.executeRequest();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertFalse(response.getBody().jsonPath().get().toString().contains("id"));
    }
}
