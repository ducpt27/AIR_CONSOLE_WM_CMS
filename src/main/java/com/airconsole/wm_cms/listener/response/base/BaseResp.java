package com.airconsole.wm_cms.listener.response.base;

public class BaseResp {
    private int code;
    private String message;

    public BaseResp(ErrorCode errorCode) {
        this.code = errorCode.code;
        this.message = errorCode.message;
    }

    public BaseResp(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
