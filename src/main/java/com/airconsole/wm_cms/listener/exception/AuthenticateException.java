package com.airconsole.wm_cms.listener.exception;

import com.airconsole.wm_cms.listener.response.base.AuthenErrorResponse;
import com.airconsole.wm_cms.listener.response.base.BusinessError;

import java.util.Date;

public class AuthenticateException extends RuntimeException {

    private BusinessError error;
    private Date timestamp;

    public AuthenticateException(BusinessError error) {
        super(error.getErrorCode());
        this.timestamp = new Date();
        this.error = error;
    }

    public AuthenErrorResponse getResponse() {
        return new AuthenErrorResponse(timestamp, error.getErrorCode(), error.getErrorCode());
    }
}
