package com.javarestassuredtemplate.tests.issue;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.issue.GetAllIssueRequest;
import com.javarestassuredtemplate.utils.ReadExcelFile;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetAllIssuesTests extends TestBase {

    GetAllIssueRequest getAllIssueRequest;

    @Test(dataProvider="testdata")
    public void verificaQuantidadeRegistroPorPaginaDataDriven(String pageSize, String page) throws InterruptedException
    {
        getAllIssueRequest = new GetAllIssueRequest(pageSize, page);

        Response response = getAllIssueRequest.executeRequest();

        String content = response.body().jsonPath().get().toString();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("description").matcher(content);
        while (m.find())
        {
            allMatches.add(m.group());
        }

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(allMatches.size()== Integer.parseInt(pageSize));

    }


    @DataProvider(name="testdata")
    public Object[][] testDataExample()
    {

        ReadExcelFile configuration = new ReadExcelFile("C:\\Users\\Base2\\Desktop\\Ole\\javarestassuredtemplate-master JAVA COM DTO MEXENDO\\javarestassuredtemplate-master\\src\\test\\resources\\testdata.xlsx");
        int rows = configuration.getRowCount(0);

        //2 é a quantidade de valores que será preenchido no for
        Object[][]value = new Object[rows][2];

        for(int i=0;i<rows;i++)
        {
            value[i][0] = configuration.getData(0, i, 0);
            value[i][1] = configuration.getData(0, i, 1);
        }
        return value;
    }
}
