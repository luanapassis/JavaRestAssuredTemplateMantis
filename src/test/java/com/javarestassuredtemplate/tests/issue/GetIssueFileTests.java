package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.DataBaseSteps;
import com.javarestassuredtemplate.requests.issue.GetIssueFileRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;

public class GetIssueFileTests extends TestBase {

    GetIssueFileRequest getIssueFileRequest;
    DataBaseSteps dataBaseSteps;

    @Test
    public void retornaTarefaSemDocumento()
    {
        dataBaseSteps = new DataBaseSteps();

        ArrayList<String> tarefa = dataBaseSteps.retornaTarefaSemDocumento();

        String issueId = tarefa.get(0);

        getIssueFileRequest = new GetIssueFileRequest(issueId);

        Response response = getIssueFileRequest.executeRequest();

        Assert.assertEquals(response.getStatusCode() , HttpStatus.SC_OK);
        Assert.assertFalse(response.getBody().jsonPath().toString().contains("id"));
    }
}
