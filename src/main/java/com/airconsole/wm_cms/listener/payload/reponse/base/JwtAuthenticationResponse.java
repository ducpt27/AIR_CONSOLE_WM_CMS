package com.airconsole.wm_cms.listener.payload.reponse.base;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}