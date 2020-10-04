package com.airconsole.wm_cms.listener.response.base;

import java.util.Date;
import java.util.List;

public interface ErrorResponse {
    List<BusinessError> getErrors();

    void setErrors(List<BusinessError> errors);

    Date getTimestamp();

    void setTimestamp(Date timestamp);

    int getHttpStatus();

    void setHttpStatus(int httpStatus);

    String getError();

    void setError(String error);

    String getMessage();

    void setMessage(String message);
}
