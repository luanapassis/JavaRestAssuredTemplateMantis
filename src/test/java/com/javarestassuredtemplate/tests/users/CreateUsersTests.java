package com.javarestassuredtemplate.tests.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.dbsteps.DataBaseSteps;
import com.javarestassuredtemplate.models.createUsersDTO.AccessLevel;
import com.javarestassuredtemplate.models.createUsersDTO.CreateUsersDTO;
import com.javarestassuredtemplate.requests.users.CreateUsersRequest;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUsersTests extends TestBase {

    CreateUsersRequest createUsersRequest;
    CreateUsersDTO createUsersDTO;
    DataBaseSteps dataBaseSteps;

    @Test
    public void criaUsuarioSucesso ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
    }
    @Test
    public void criaUsuarioSemNome ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();

        String userName = "";
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = true;
        boolean protectedd = false;

        String mensagemEsperada = "Invalid username ''";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response.body().jsonPath().get("message").toString(), mensagemEsperada);
    }
    @Test
    public void criaUsuarioNivelDeAcessoInvalido ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();

        String userName = "";
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "sdfasfda";
        boolean enabled = true;
        boolean protectedd = false;

        String mensagemEsperada = "Invalid access level";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response.body().jsonPath().get("message").toString(), mensagemEsperada);
    }
    @Test
    public void criaUsuarioJaExistente ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();

        String userName = "Teste";
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = true;
        boolean protectedd = false;

        String mensagemEsperada = "Username '"+userName+"' already used.";

        //criando objeto
        createUsersDTO = new CreateUsersDTO();

        createUsersDTO.setUsername(userName);
        createUsersDTO.setPassword(password);
        createUsersDTO.setReal_name(realName);
        createUsersDTO.setEmail(email);
        AccessLevel accessLevel1 = new AccessLevel();
        accessLevel1.setName(accessLevel);
        createUsersDTO.setAccess_level(accessLevel1);
        createUsersDTO.setEnabled(enabled);
        createUsersDTO.setProtectedd(protectedd);

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response.body().jsonPath().get("message").toString(), mensagemEsperada);
    }
    @Test
    public void criaUsuarioEmailJaExistente ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "luana.assis1@gmail.com";
        String accessLevel = "updater";
        boolean enabled = true;
        boolean protectedd = false;

        String mensagemEsperada = "Email '"+email+"' already used.";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(response.body().jsonPath().get("message").toString(), mensagemEsperada);
    }
    @Test
    public void criaUsuarioEnabledTrue ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "1";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(5), retornoEsperado);
    }
    @Test
    public void criaUsuarioEnabledFalse ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = false;
        boolean protectedd = false;

        String retornoEsperado = "0";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(5), retornoEsperado);
    }
    @Test
    public void criaUsuarioProtectedTrue ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = false;
        boolean protectedd = true;

        String retornoEsperado = "1";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(6), retornoEsperado);
    }
    @Test
    public void criaUsuarioProtectedFalse ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = false;
        boolean protectedd = false;

        String retornoEsperado = "0";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(6), retornoEsperado);
    }
    @Test
    public void criaUsuarioVisualizador ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "viewer";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "10";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(7), retornoEsperado);
    }
    @Test
    public void criaUsuarioRelator ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "reporter";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "25";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(7), retornoEsperado);
    }
    @Test
    public void criaUsuarioAtualizador ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "updater";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "40";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(7), retornoEsperado);
    }
    @Test
    public void criaUsuarioDesenvolvedor ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "developer";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "55";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(7), retornoEsperado);
    }
    @Test
    public void criaUsuarioGerente ()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "manager";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "70";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(7), retornoEsperado);
    }
    @Test
    public void criaUsuarioAdministrador()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "administrator";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "90";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        ArrayList<String> resultado = dataBaseSteps.retornaUsuario(userName);

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("User created"));
        Assert.assertEquals(resultado.get(7), retornoEsperado);
    }
    @Test
    public void criaUsuarioPerfilInvalido()throws JsonProcessingException
    {
        createUsersRequest = new CreateUsersRequest();
        createUsersDTO = new CreateUsersDTO();
        dataBaseSteps = new DataBaseSteps();

        String userName = "usuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String password = "p@ssw0rd";
        String realName = "RealNameusuAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String email = "";
        String accessLevel = "teste";
        boolean enabled = true;
        boolean protectedd = false;

        String retornoEsperado = "90";

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

        createUsersRequest.setJsonBody(createUsersDTO);

        Response response = createUsersRequest.executeRequest();

        String content = response.body().jsonPath().get().toString();
        List<String> allMatches = new ArrayList<String>();
        Matcher m = Pattern.compile("message(.*?)Invalid access level").matcher(content);
        while (m.find())
        {
            allMatches.add(m.group());
        }
        Assert.assertTrue(allMatches.size()>=1);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getStatusLine().contains("Invalid access level"));
    }

}
