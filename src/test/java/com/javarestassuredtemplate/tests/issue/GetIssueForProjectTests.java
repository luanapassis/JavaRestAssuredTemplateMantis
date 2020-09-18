package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.GetIssueFileRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetIssueForProjectTests extends TestBase {

    GetIssueFileRequest getIssueFileRequest;

    @Test
    public void retornaTodasTarefasPorProjeto()
    {
        String projectId = "1";

        getIssueFileRequest = new GetIssueFileRequest(projectId);

        Response response = getIssueFileRequest.executeRequest();

        Assert.assertEquals(response.getStatusCode() , HttpStatus.SC_OK);
    }
}
