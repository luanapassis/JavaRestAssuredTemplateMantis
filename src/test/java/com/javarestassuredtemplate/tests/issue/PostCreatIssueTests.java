package com.javarestassuredtemplate.tests.issue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.javarestassuredtemplate.bases.TestBase;
import com.javarestassuredtemplate.models.createIssueDTO.*;
import com.javarestassuredtemplate.requests.issue.PostCreateIssueRequest;
import com.javarestassuredtemplate.utils.GeneralUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PostCreatIssueTests extends TestBase {

    @Test
    public void criaTarefaCompletaSucesso() throws JsonProcessingException {
        String summary = "SummaryAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String additionalInformation = "Aditional Information APi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String projectId = "1";
        String projectName = "Teste";
        String categoryId = "1";
        String categoryName = "General";
        String handlerName = "teste";
        String viewStateId = "10";
        String viewStateName = "public";
        String priorityName = "normal";
        String severityName = "trivial";
        String reproducibilityName = "always";
        String sticky = "false";
        String tagName = "mantishub";

        //construindo objeto
        CreateIssueDTO createIssueDTO = new CreateIssueDTO();

        createIssueDTO.setSummary(summary);
        createIssueDTO.setDescription(description);
        createIssueDTO.setAdditionalInformation(additionalInformation);

        Project project = new Project();
        project.setId(projectId);
        project.setName(projectName);
        createIssueDTO.setProject(project);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        createIssueDTO.setCategory(category);

        Handler handler = new Handler();
        handler.setName(handlerName);
        createIssueDTO.setHandler(handler);

        ViewState viewState = new ViewState();
        viewState.setId(viewStateId);
        viewState.setName(viewStateName);
        createIssueDTO.setViewState(viewState);

        Priority priority = new Priority();
        priority.setName(priorityName);
        createIssueDTO.setPriority(priority);

        Severity severity = new Severity();
        severity.setName(severityName);
        createIssueDTO.setSeverity(severity);

        Reproducibility reproducibility = new Reproducibility();
        reproducibility.setName(reproducibilityName);
        createIssueDTO.setReproducibility(reproducibility);

        createIssueDTO.setSticky(sticky);

        Tags tags = new Tags(tagName);
        List<Tags> listaTags = new ArrayList<Tags>();
        tags.setName(tagName);
        listaTags.add(tags);
        createIssueDTO.setTags(listaTags);

        PostCreateIssueRequest postCreateIssueRequest = new PostCreateIssueRequest();
        postCreateIssueRequest.setJsonBody(createIssueDTO);

        Response response = postCreateIssueRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("Issue Created"));
    }

    @Test
    public void criaTarefaCompletaSubProjetoSucesso() throws JsonProcessingException {
        String summary = "SummaryAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String additionalInformation = "Aditional Information APi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String projectId = "2";
        String projectName = "";
        String categoryId = "1";
        String categoryName = "General";
        String handlerName = "teste";
        String viewStateId = "10";
        String viewStateName = "public";
        String priorityName = "normal";
        String severityName = "trivial";
        String reproducibilityName = "always";
        String sticky = "false";
        String tagName = "mantishub";

        //construindo objeto
        CreateIssueDTO createIssueDTO = new CreateIssueDTO();

        createIssueDTO.setSummary(summary);
        createIssueDTO.setDescription(description);
        createIssueDTO.setAdditionalInformation(additionalInformation);

        Project project = new Project();
        project.setId(projectId);
        project.setName(projectName);
        createIssueDTO.setProject(project);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        createIssueDTO.setCategory(category);

        Handler handler = new Handler();
        handler.setName(handlerName);
        createIssueDTO.setHandler(handler);

        ViewState viewState = new ViewState();
        viewState.setId(viewStateId);
        viewState.setName(viewStateName);
        createIssueDTO.setViewState(viewState);

        Priority priority = new Priority();
        priority.setName(priorityName);
        createIssueDTO.setPriority(priority);

        Severity severity = new Severity();
        severity.setName(severityName);
        createIssueDTO.setSeverity(severity);

        Reproducibility reproducibility = new Reproducibility();
        reproducibility.setName(reproducibilityName);
        createIssueDTO.setReproducibility(reproducibility);

        createIssueDTO.setSticky(sticky);

        Tags tags = new Tags(tagName);
        List<Tags> listaTags = new ArrayList<Tags>();
        tags.setName(tagName);
        listaTags.add(tags);
        createIssueDTO.setTags(listaTags);

        PostCreateIssueRequest postCreateIssueRequest = new PostCreateIssueRequest();
        postCreateIssueRequest.setJsonBody(createIssueDTO);

        Response response = postCreateIssueRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getStatusLine().contains("Issue Created"));
    }
    @Test
    public void criaTarefaCompletaSemNome() throws JsonProcessingException {
        String summary = "";
        String description = "DescriptionAPi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String additionalInformation = "Aditional Information APi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String projectId = "1";
        String projectName = "Teste";
        String categoryId = "1";
        String categoryName = "General";
        String handlerName = "teste";
        String viewStateId = "10";
        String viewStateName = "public";
        String priorityName = "normal";
        String severityName = "trivial";
        String reproducibilityName = "always";
        String sticky = "false";
        String tagName = "mantishub";

        String mensagemEsperada = "Summary not specified";

        //construindo objeto
        CreateIssueDTO createIssueDTO = new CreateIssueDTO();

        createIssueDTO.setSummary(summary);
        createIssueDTO.setDescription(description);
        createIssueDTO.setAdditionalInformation(additionalInformation);

        Project project = new Project();
        project.setId(projectId);
        project.setName(projectName);
        createIssueDTO.setProject(project);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        createIssueDTO.setCategory(category);

        Handler handler = new Handler();
        handler.setName(handlerName);
        createIssueDTO.setHandler(handler);

        ViewState viewState = new ViewState();
        viewState.setId(viewStateId);
        viewState.setName(viewStateName);
        createIssueDTO.setViewState(viewState);

        Priority priority = new Priority();
        priority.setName(priorityName);
        createIssueDTO.setPriority(priority);

        Severity severity = new Severity();
        severity.setName(severityName);
        createIssueDTO.setSeverity(severity);

        Reproducibility reproducibility = new Reproducibility();
        reproducibility.setName(reproducibilityName);
        createIssueDTO.setReproducibility(reproducibility);

        createIssueDTO.setSticky(sticky);

        Tags tags = new Tags(tagName);
        List<Tags> listaTags = new ArrayList<Tags>();
        tags.setName(tagName);
        listaTags.add(tags);
        createIssueDTO.setTags(listaTags);

        PostCreateIssueRequest postCreateIssueRequest = new PostCreateIssueRequest();
        postCreateIssueRequest.setJsonBody(createIssueDTO);

        Response response = postCreateIssueRequest.executeRequest();

        String mensagemRecebida = response.getBody().jsonPath().get("message");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(mensagemRecebida, mensagemEsperada);
    }
    @Test
    public void criaTarefaCompletaSemDescricao() throws JsonProcessingException {
        String summary = "SummaryAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "" ;
        String additionalInformation = "Aditional Information APi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String projectId = "1";
        String projectName = "Teste";
        String categoryId = "1";
        String categoryName = "General";
        String handlerName = "teste";
        String viewStateId = "10";
        String viewStateName = "public";
        String priorityName = "normal";
        String severityName = "trivial";
        String reproducibilityName = "always";
        String sticky = "false";
        String tagName = "mantishub";

        String mensagemEsperada = "Description not specified";

        //construindo objeto
        CreateIssueDTO createIssueDTO = new CreateIssueDTO();

        createIssueDTO.setSummary(summary);
        createIssueDTO.setDescription(description);
        createIssueDTO.setAdditionalInformation(additionalInformation);

        Project project = new Project();
        project.setId(projectId);
        project.setName(projectName);
        createIssueDTO.setProject(project);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        createIssueDTO.setCategory(category);

        Handler handler = new Handler();
        handler.setName(handlerName);
        createIssueDTO.setHandler(handler);

        ViewState viewState = new ViewState();
        viewState.setId(viewStateId);
        viewState.setName(viewStateName);
        createIssueDTO.setViewState(viewState);

        Priority priority = new Priority();
        priority.setName(priorityName);
        createIssueDTO.setPriority(priority);

        Severity severity = new Severity();
        severity.setName(severityName);
        createIssueDTO.setSeverity(severity);

        Reproducibility reproducibility = new Reproducibility();
        reproducibility.setName(reproducibilityName);
        createIssueDTO.setReproducibility(reproducibility);

        createIssueDTO.setSticky(sticky);

        Tags tags = new Tags(tagName);
        List<Tags> listaTags = new ArrayList<Tags>();
        tags.setName(tagName);
        listaTags.add(tags);
        createIssueDTO.setTags(listaTags);

        PostCreateIssueRequest postCreateIssueRequest = new PostCreateIssueRequest();
        postCreateIssueRequest.setJsonBody(createIssueDTO);

        Response response = postCreateIssueRequest.executeRequest();

        String mensagemRecebida = response.getBody().jsonPath().get("message");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(mensagemRecebida, mensagemEsperada);
    }
    @Test
    public void criaTarefaCompletaSemProjeto() throws JsonProcessingException {
        String summary = "SummaryAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String additionalInformation = "Aditional Information APi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String projectId = "0";
        String projectName = "";
        String categoryId = "1";
        String categoryName = "General";
        String handlerName = "teste";
        String viewStateId = "10";
        String viewStateName = "public";
        String priorityName = "normal";
        String severityName = "trivial";
        String reproducibilityName = "always";
        String sticky = "false";
        String tagName = "mantishub";

        String mensagemEsperada = "Project not specified";

        //construindo objeto
        CreateIssueDTO createIssueDTO = new CreateIssueDTO();

        createIssueDTO.setSummary(summary);
        createIssueDTO.setDescription(description);
        createIssueDTO.setAdditionalInformation(additionalInformation);

        Project project = new Project();
        project.setId(projectId);
        project.setName(projectName);
        createIssueDTO.setProject(project);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        createIssueDTO.setCategory(category);

        Handler handler = new Handler();
        handler.setName(handlerName);
        createIssueDTO.setHandler(handler);

        ViewState viewState = new ViewState();
        viewState.setId(viewStateId);
        viewState.setName(viewStateName);
        createIssueDTO.setViewState(viewState);

        Priority priority = new Priority();
        priority.setName(priorityName);
        createIssueDTO.setPriority(priority);

        Severity severity = new Severity();
        severity.setName(severityName);
        createIssueDTO.setSeverity(severity);

        Reproducibility reproducibility = new Reproducibility();
        reproducibility.setName(reproducibilityName);
        createIssueDTO.setReproducibility(reproducibility);

        createIssueDTO.setSticky(sticky);

        Tags tags = new Tags(tagName);
        List<Tags> listaTags = new ArrayList<Tags>();
        tags.setName(tagName);
        listaTags.add(tags);
        createIssueDTO.setTags(listaTags);

        PostCreateIssueRequest postCreateIssueRequest = new PostCreateIssueRequest();
        postCreateIssueRequest.setJsonBody(createIssueDTO);

        Response response = postCreateIssueRequest.executeRequest();

        String mensagemRecebida = response.getBody().jsonPath().get("message");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertEquals(mensagemRecebida, mensagemEsperada);
    }
    @Test
    public void criaTarefaCompletaProjetoIncorreto() throws JsonProcessingException {
        String summary = "SummaryAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String description = "DescriptionAPi_" + GeneralUtils.returnStringWithRandomCharacters(3);
        String additionalInformation = "Aditional Information APi_" + GeneralUtils.returnStringWithRandomCharacters(3); ;
        String projectId = "99";
        String projectName = "Nao Existe";
        String categoryId = "1";
        String categoryName = "General";
        String handlerName = "teste";
        String viewStateId = "10";
        String viewStateName = "public";
        String priorityName = "normal";
        String severityName = "trivial";
        String reproducibilityName = "always";
        String sticky = "false";
        String tagName = "mantishub";

        String mensagemEsperada = "Project '"+ projectId + "' not found";

        //construindo objeto
        CreateIssueDTO createIssueDTO = new CreateIssueDTO();

        createIssueDTO.setSummary(summary);
        createIssueDTO.setDescription(description);
        createIssueDTO.setAdditionalInformation(additionalInformation);

        Project project = new Project();
        project.setId(projectId);
        project.setName(projectName);
        createIssueDTO.setProject(project);

        Category category = new Category();
        category.setId(categoryId);
        category.setName(categoryName);
        createIssueDTO.setCategory(category);

        Handler handler = new Handler();
        handler.setName(handlerName);
        createIssueDTO.setHandler(handler);

        ViewState viewState = new ViewState();
        viewState.setId(viewStateId);
        viewState.setName(viewStateName);
        createIssueDTO.setViewState(viewState);

        Priority priority = new Priority();
        priority.setName(priorityName);
        createIssueDTO.setPriority(priority);

        Severity severity = new Severity();
        severity.setName(severityName);
        createIssueDTO.setSeverity(severity);

        Reproducibility reproducibility = new Reproducibility();
        reproducibility.setName(reproducibilityName);
        createIssueDTO.setReproducibility(reproducibility);

        createIssueDTO.setSticky(sticky);

        Tags tags = new Tags(tagName);
        List<Tags> listaTags = new ArrayList<Tags>();
        tags.setName(tagName);
        listaTags.add(tags);
        createIssueDTO.setTags(listaTags);

        PostCreateIssueRequest postCreateIssueRequest = new PostCreateIssueRequest();
        postCreateIssueRequest.setJsonBody(createIssueDTO);

        Response response = postCreateIssueRequest.executeRequest();

        String mensagemRecebida = response.getBody().jsonPath().get("message");

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
        Assert.assertEquals(mensagemRecebida, mensagemEsperada);
    }
}
