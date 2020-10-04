package com.airconsole.wm_cms.listener.response.base;

public enum  ErrorCode {
    SUCCESS(0, "Success."),
    SYSTEM_EROR(999, "System error."),
    USER_EXIST(1000, "Username is already taken."),
    EMAIL_EXIST(1001, "Email address already in use.");

    int code;
    String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
