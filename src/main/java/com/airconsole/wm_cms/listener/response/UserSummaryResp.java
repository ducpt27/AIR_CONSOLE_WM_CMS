package com.airconsole.wm_cms.listener.response;

import lombok.Data;
import lombok.ToString;

import java.util.Collection;

@Data
@ToString
public class UserSummaryResp {
    private Integer id;
    private String name;
    private String username;
    private Collection<String> roles;

    public UserSummaryResp(Integer id, String name, String username) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public UserSummaryResp(Integer id, String name, String username, Collection<String> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.roles = roles;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
