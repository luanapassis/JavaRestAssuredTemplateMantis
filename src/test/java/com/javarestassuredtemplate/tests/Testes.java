package com.javarestassuredtemplate.tests;
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

public class Testes {
    @Test
    public void teste1()
    {
        RestAssured.baseURI = "http://localhost/mantis";

        given().headers("Authorization", "t4VJIkRw6SsgcGY1ZaDjFKe6kp9jcOty")
                .when().get("/api/rest/issues/10");
    }
    @Test
    public void teste11()
    {
        RestAssured.baseURI = "http://localhost/mantis";

        Response response = given().headers("Authorization", "t4VJIkRw6SsgcGY1ZaDjFKe6kp9jcOty")
                .when().get("/api/rest/issues/10");

        System.out.println("Response Body is =>  " + response.getBody().asString());
    }

    @Test
    public void teste2()
    {
        RestAssured.baseURI = "http://localhost/mantis";

        RequestSpecification httpRequest = RestAssured.given().header("Authorization","t4VJIkRw6SsgcGY1ZaDjFKe6kp9jcOty");

        Response response = httpRequest.get("/api/rest/issues/10");
        response.getBody();

        System.out.println("Response Body is =>  " + response.asString());
    }

    @Test
    public void teste3()
    {
        RestAssured.baseURI = "http://localhost/mantis";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.auth().preemptive().basic("Authorization", "t4VJIkRw6SsgcGY1ZaDjFKe6kp9jcOty");


        Response response = httpRequest.get("/api/rest/issues/10");
        response.getBody();

        System.out.println("Response Body is =>  " + response.asString());
    }
    @Test
    public void teste4()
    {
        RestAssured.baseURI = "http://localhost/mantis";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.auth().digest("Authorization","t4VJIkRw6SsgcGY1ZaDjFKe6kp9jcOty");


        Response response = httpRequest.get("/api/rest/issues/10");
        response.getBody();

        System.out.println("Response Body is =>  " + response.asString());
    }
}
