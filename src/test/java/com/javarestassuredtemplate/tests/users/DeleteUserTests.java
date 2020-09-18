package com.javarestassuredtemplate.tests.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.DataBaseSteps;
import com.javarestassuredtemplate.requests.users.DeleteUserRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTests extends TestBase {
    DeleteUserRequest deleteUserRequest;
    DataBaseSteps dataBaseSteps;

    @Test
    public void deletaUsuarioSucesso ()
    {

        dataBaseSteps = new DataBaseSteps();

        String usuarioDeletar = "testeAPIDeletar";
        String idUsuarioDeletar = dataBaseSteps.retornaidUsuario(usuarioDeletar);

        deleteUserRequest = new DeleteUserRequest(idUsuarioDeletar);
        Response response = deleteUserRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NO_CONTENT);
    }
    @Test
    public void deletaUsuarioInexistente()
    {

        dataBaseSteps = new DataBaseSteps();

        String idUsuarioDeletar = "99999";

        deleteUserRequest = new DeleteUserRequest(idUsuarioDeletar);
        Response response = deleteUserRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
