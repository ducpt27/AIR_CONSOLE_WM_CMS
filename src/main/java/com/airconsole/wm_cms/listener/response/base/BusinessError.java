package com.airconsole.wm_cms.listener.response.base;

public class BusinessError {

    private String errorCode;
    private Object params;

    public BusinessError(String errorCode, Object params) {
        this.errorCode = errorCode;
        this.params = params;
    }

    public BusinessError(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
