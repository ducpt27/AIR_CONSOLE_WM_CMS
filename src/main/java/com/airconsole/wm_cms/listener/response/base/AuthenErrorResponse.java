package com.airconsole.wm_cms.listener.response.base;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class AuthenErrorResponse implements ErrorResponse {

    private Date timestamp;
    private Integer httpStatus = HttpStatus.UNAUTHORIZED.value();
    private String error;
    private String message;

    public AuthenErrorResponse(Date timestamp, String error, String message) {
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
    }

    public AuthenErrorResponse(String error) {
        this.timestamp = new Date();
        this.error = this.message = error;
    }

    @Override
    public List<BusinessError> getErrors() {
        return null;
    }

    @Override
    public void setErrors(List<BusinessError> errors) {
        return;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int getHttpStatus() {
        return httpStatus;
    }

    @Override
    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getError() {
        return error;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
