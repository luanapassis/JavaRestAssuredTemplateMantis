package com.javarestassuredtemplate.tests.users;

import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.requests.users.UserInfoRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class UserInfoTests extends TestBase {
    UserInfoRequest userInfoRequest;


    public void userInforTest()
    {
        userInfoRequest = new UserInfoRequest();

        Response response = userInfoRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

    }


}
