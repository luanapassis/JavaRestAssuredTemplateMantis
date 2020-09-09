package com.javarestassuredtemplate.tests.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.models.AccessLevel;
import com.javarestassuredtemplate.models.CreateUsersDTO;
import com.javarestassuredtemplate.requests.users.CreatUsersRequest;
import com.javarestassuredtemplate.requests.users.UserInfoRequest;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.*;
import io.restassured.response.Response;

public class UserInfoTests extends TestBase {
    UserInfoRequest userInfoRequest;

    @Test
    public void userInforTest()
    {
        userInfoRequest = new UserInfoRequest();

        Response response = userInfoRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);

    }

    @Test
    public void response ()
    {
        RestAssured.baseURI = "http://localhost/mantis";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.auth()
            .preemptive()
            .basic("required_username", "required_password")
            .header("Accept", ContentType.JSON.getAcceptHeader());


        Response response = httpRequest.get("/api/rest/users/me");
        response.getBody();

        System.out.println("Response Body is =>  " + response.asString());
    }
}
