package com.airconsole.wm_cms.listener.payload.reponse.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserProfileResp {
    private Integer id;
    private String username;
    private String full_name;

    public UserProfileResp(Integer id, String username, String full_name) {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
    }
}
