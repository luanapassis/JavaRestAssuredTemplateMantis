package com.javarestassuredtemplate.tests.lang;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.lang.LangRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LangTests extends TestBase {

    @Test
    public void retornaLinguagemUsuarioLogado()
    {
        LangRequest langRequest = new LangRequest();

        Response response = langRequest.executeRequest();

        String content = response.body().jsonPath().get().toString();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("(.*?)language=english(.*?)").matcher(content);
        while (m.find())
        {
            allMatches.add(m.group());
        }

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(allMatches.size()== 1);
    }
}
