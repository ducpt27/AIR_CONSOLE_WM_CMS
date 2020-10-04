package com.airconsole.wm_cms.listener.exception;

import com.airconsole.wm_cms.listener.response.base.BusinessError;
import com.airconsole.wm_cms.listener.response.base.BusinessErrorResponse;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BusinessErrorException extends RuntimeException {

    private List<BusinessError> errors;
    private Date timestamp;

    public BusinessErrorException(BusinessError error) {
        this.timestamp = new Date();
        this.errors = Collections.singletonList(error);
    }

    public BusinessErrorException(List<BusinessError> errors) {
        this.timestamp = new Date();
        this.errors = errors;
    }

    public List<BusinessError> getErrors() {
        return errors;
    }

    public void setErrors(List<BusinessError> errors) {
        this.errors = errors;
    }

    public BusinessErrorResponse getResponse(String path) {
        return new BusinessErrorResponse(errors, timestamp, path);
    }
}