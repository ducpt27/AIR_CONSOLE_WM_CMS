package com.airconsole.wm_cms.listener.response.base;

public class BaseResp {
    protected Integer code;
    protected String message;
    protected Object data;

    public BaseResp(ErrorCode errorCode, Object data) {
        this(errorCode);
        this.data = data;
    }

    public BaseResp(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResp() {
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
