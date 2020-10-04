package com.airconsole.wm_cms.listener.response;

import com.airconsole.wm_cms.listener.response.base.BaseResp;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;

public class UserIdentityAvailabilityResp extends BaseResp {
    Boolean isAvailable;

    public UserIdentityAvailabilityResp(ErrorCode errorCode, Boolean isAvailable) {
        super(errorCode);
        this.isAvailable = isAvailable;
    }
}
