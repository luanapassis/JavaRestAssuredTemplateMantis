package com.javarestassuredtemplate.models.createIssueDTO;

import java.util.ArrayList;
import java.util.List;

public class CreateIssueDTO {
    private String summary;
    private String description;
    private String additionalInformation;
    Project ProjectObject;
    Category CategoryObject;
    Handler HandlerObject;
    ViewState ViewStateObject;
    Priority PriorityObject;
    Severity SeverityObject;
    Reproducibility ReproducibilityObject;
    private String sticky;
    private List<Tags> tags;

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    // Getter Methods

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public Project getProject() {
        return ProjectObject;
    }

    public Category getCategory() {
        return CategoryObject;
    }

    public Handler getHandler() {
        return HandlerObject;
    }

    public ViewState getView_state() {
        return ViewStateObject;
    }

    public Priority getPriority() {
        return PriorityObject;
    }

    public Severity getSeverity() {
        return SeverityObject;
    }

    public Reproducibility getReproducibility() {
        return ReproducibilityObject;
    }

    public String getSticky() {
        return sticky;
    }

    // Setter Methods

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public void setProject(Project projectObject) {
        this.ProjectObject = projectObject;
    }

    public void setCategory(Category categoryObject) {
        this.CategoryObject = categoryObject;
    }

    public void setHandler(Handler handlerObject) {
        this.HandlerObject = handlerObject;
    }

    public void setViewState(ViewState viewStateObject) {
        this.ViewStateObject = viewStateObject;
    }

    public void setPriority(Priority priorityObject) {
        this.PriorityObject = priorityObject;
    }

    public void setSeverity(Severity severityObject) {
        this.SeverityObject = severityObject;
    }

    public void setReproducibility(Reproducibility reproducibilityObject) {
        this.ReproducibilityObject = reproducibilityObject;
    }

    public void setSticky(String sticky) {
        this.sticky = sticky;
    }
}
