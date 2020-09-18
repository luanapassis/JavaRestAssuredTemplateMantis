package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.GetIssueUnassignedRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetIssueUnassignedTests extends TestBase {

    @Test
    public void retornaTarefasSemUsuarioAssiciado()
    {
        GetIssueUnassignedRequest getIssueUnassignedRequest = new GetIssueUnassignedRequest();

        Response response = getIssueUnassignedRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }
}
