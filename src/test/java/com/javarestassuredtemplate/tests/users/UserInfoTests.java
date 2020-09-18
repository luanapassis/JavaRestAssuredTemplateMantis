package com.javarestassuredtemplate.tests.users;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.users.UserInfoRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserInfoTests extends TestBase {
    UserInfoRequest userInfoRequest;


    public void userInforTest()
    {
        userInfoRequest = new UserInfoRequest();

        Response response = userInfoRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

    }


}
