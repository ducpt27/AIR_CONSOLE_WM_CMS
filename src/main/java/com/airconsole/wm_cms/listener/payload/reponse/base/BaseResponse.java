package com.airconsole.wm_cms.listener.payload.reponse.base;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseResponse {
    private Boolean success;
    private String message;

    public BaseResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
