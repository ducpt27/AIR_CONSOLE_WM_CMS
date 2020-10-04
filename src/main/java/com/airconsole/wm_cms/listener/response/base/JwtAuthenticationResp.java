package com.airconsole.wm_cms.listener.response.base;

public class JwtAuthenticationResp extends BaseResp {
    private String accessToken;

    public JwtAuthenticationResp(String accessToken) {
        super(ErrorCode.SUCCESS);
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
