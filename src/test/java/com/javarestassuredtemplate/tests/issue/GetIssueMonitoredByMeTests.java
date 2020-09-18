package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.GetIssueMonitoredByMeRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;



public class GetIssueMonitoredByMeTests extends TestBase {

    GetIssueMonitoredByMeRequest getIssueMonitoredByMeRequest;

    @Test
    public void retornaTarefasMonitoradasPorMim()
    {
        getIssueMonitoredByMeRequest = new GetIssueMonitoredByMeRequest();

        Response response = getIssueMonitoredByMeRequest.executeRequest();

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
}
