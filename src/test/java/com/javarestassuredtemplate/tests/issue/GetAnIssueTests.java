package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.DataBaseSteps;
import com.javarestassuredtemplate.requests.issue.GetAnIssueRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class GetAnIssueTests extends TestBase {

    GetAnIssueRequest getAnIssueRequest;
    DataBaseSteps dataBaseSteps;

    @Test
    public void retornaTarefaInvalida()
    {
        String issueIdInvalida = "9999";

        getAnIssueRequest = new GetAnIssueRequest(issueIdInvalida);

        Response response = getAnIssueRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NOT_FOUND);
        Assert.assertTrue(response.getBody().jsonPath().get("message").toString().contains("Issue #"+issueIdInvalida+" not found") );
    }

    @Test
    public void retornaTarefaValida()
    {
        dataBaseSteps = new DataBaseSteps();

        ArrayList<String> tarefa = dataBaseSteps.retornaTarefaAleatoria();
        String issueId = tarefa.get(0);

        getAnIssueRequest = new GetAnIssueRequest(issueId);

        Response response = getAnIssueRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(response.getBody().jsonPath().get().toString().contains("description="+tarefa.get(30)));

    }
}
