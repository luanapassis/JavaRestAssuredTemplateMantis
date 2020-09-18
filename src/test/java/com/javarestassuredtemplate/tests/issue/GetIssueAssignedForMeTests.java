package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.GetIssueAssignedForMeRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetIssueAssignedForMeTests extends TestBase {

    GetIssueAssignedForMeRequest getIssueAssignedForMeRequest;

    @Test
    public void retornaTarefaAssociadaUsuario()
    {
        getIssueAssignedForMeRequest = new GetIssueAssignedForMeRequest();

        Response response = getIssueAssignedForMeRequest.executeRequest();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
}
