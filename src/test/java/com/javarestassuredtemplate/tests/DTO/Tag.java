package com.javarestassuredtemplate.tests.DTO;

import java.io.Serializable;

public class Tag  {
    private String id;
    private String name;

    public Tag(String tagId, String tagName) {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
