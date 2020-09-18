package com.javarestassuredtemplate.tests.issue;


import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.GetIssueMonitoredByMeRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetIssueReportedByMeTests extends TestBase {

    @Test
    public void retornaTarefasReportadasPorMim()
    {
        GetIssueMonitoredByMeRequest getIssueMonitoredByMeRequest = new GetIssueMonitoredByMeRequest();

        Response response = getIssueMonitoredByMeRequest.executeRequest();

        Assert.assertEquals(response.statusCode() , HttpStatus.SC_OK);
    }
}
