package com.javarestassuredtemplate.tests.lang;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.lang.LangMultipleLocalizedRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LangMultipleLocalizedTests extends TestBase {

    @Test
    public void retornaStringsBackToBugLink()
    {
        String string1 = "back_to_bug_link";

        LangMultipleLocalizedRequest langMultipleLocalizedRequest = new LangMultipleLocalizedRequest(string1);

        Response response = langMultipleLocalizedRequest.executeRequest();

        String content = response.body().jsonPath().get().toString();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("(.*?)name=back_to_bug_link(.*?)localized=Back To Issue(.*?)").matcher(content);
        while (m.find())
        {
            allMatches.add(m.group());
        }

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(allMatches.size()== 1);
    }
    @Test
    public void retornaStringUpdateSimpleLink()
    {
        String string1 = "update_simple_link";

        LangMultipleLocalizedRequest langMultipleLocalizedRequest = new LangMultipleLocalizedRequest(string1);

        Response response = langMultipleLocalizedRequest.executeRequest();

        String content = response.body().jsonPath().get().toString();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("(.*?)name=update_simple_link(.*?)localized=Update Simple(.*?)").matcher(content);
        while (m.find())
        {
            allMatches.add(m.group());
        }

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(allMatches.size()== 1);
    }
    @Test
    public void retornaStringCategory()
    {
        String string1 = "category";

        LangMultipleLocalizedRequest langMultipleLocalizedRequest = new LangMultipleLocalizedRequest(string1);

        Response response = langMultipleLocalizedRequest.executeRequest();

        String content = response.body().jsonPath().get().toString();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("(.*?)name=category(.*?)localized=Category(.*?)").matcher(content);
        while (m.find())
        {
            allMatches.add(m.group());
        }

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(allMatches.size()== 1);
    }
    @Test
    public void retornaStringReproducibility()
    {
        String string1 = "reproducibility";

        LangMultipleLocalizedRequest langMultipleLocalizedRequest = new LangMultipleLocalizedRequest(string1);

        Response response = langMultipleLocalizedRequest.executeRequest();

        String content = response.body().jsonPath().get().toString();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("(.*?)name=reproducibility(.*?)localized=Reproducibility(.*?)").matcher(content);
        while (m.find())
        {
            allMatches.add(m.group());
        }

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        Assert.assertTrue(allMatches.size()== 1);
    }
}
