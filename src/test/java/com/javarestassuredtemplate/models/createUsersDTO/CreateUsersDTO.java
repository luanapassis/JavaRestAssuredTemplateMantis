package com.javarestassuredtemplate.models.createUsersDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CreateUsersDTO {
    private String username;
    private String password;
    private String real_name;
    private String email;
    private AccessLevel access_level;
    private boolean enabled;
    @JsonProperty("protected")
    private boolean protectedd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccessLevel getAccess_level() {
        return access_level;
    }

    public void setAccess_level(AccessLevel access_level) {
        this.access_level = access_level;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getProtectedd() {
        return protectedd;
    }

    public void setProtectedd(Boolean protectedd) {
        this.protectedd = protectedd;
    }
}
