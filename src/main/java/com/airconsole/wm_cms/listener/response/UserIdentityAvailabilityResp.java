package com.airconsole.wm_cms.listener.response;

import com.airconsole.wm_cms.listener.response.base.BaseResp;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;

public class UserIdentityAvailabilityResp extends BaseResp {
    private Boolean isAvailable;

    public UserIdentityAvailabilityResp(ErrorCode errorCode, Boolean isAvailable) {
        super(errorCode);
        this.isAvailable = isAvailable;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}
