package com.javarestassuredtemplate.tests.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.models.AccessLevel;
import com.javarestassuredtemplate.models.CreateUsersDTO;
import com.javarestassuredtemplate.requests.PostPetRequest;
import com.javarestassuredtemplate.requests.users.CreatUsersRequest;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.response.Response;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.HttpCookie;

public class CreatUsersTests extends TestBase {

    CreatUsersRequest creatUsersRequest;
    CreateUsersDTO createUsersDTO;

    @Test
    public void criaUsuarioSucesso ()throws JsonProcessingException
    {
        creatUsersRequest = new CreatUsersRequest();
        createUsersDTO = new CreateUsersDTO();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = true;
        boolean protectedd = false;

        //criando objeto
        createUsersDTO.setUsername(userName);
        createUsersDTO.setPassword(password);
        createUsersDTO.setReal_name(realName);
        createUsersDTO.setEmail(email);
        AccessLevel accessLevel1 = new AccessLevel();
        accessLevel1.setName(accessLevel);
        createUsersDTO.setAccess_level(accessLevel1);
        createUsersDTO.setEnabled(enabled);
        createUsersDTO.setProtectedd(protectedd);


        creatUsersRequest.setJsonBody(createUsersDTO);

        Response response = creatUsersRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);

    }

}
