package com.airconsole.wm_cms.listener.response.base;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class BusinessErrorResponse implements ErrorResponse {

    private List<BusinessError> errors;
    private Date timestamp;
    private Integer httpStatus = HttpStatus.OK.value();
    private String error = "BusinessErrorException";
    private String message = "BusinessErrorException";
    private String path;

    public BusinessErrorResponse() {
    }

    public BusinessErrorResponse(List<BusinessError> errors, Date timestamp, String path) {
        this.errors = errors;
        this.timestamp = timestamp;
        this.path = path;
    }

    @Override
    public List<BusinessError> getErrors() {
        return errors;
    }

    @Override
    public void setErrors(List<BusinessError> errors) {
        this.errors = errors;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
