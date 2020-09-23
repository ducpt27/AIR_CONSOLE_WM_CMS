package com.airconsole.wm_cms.listener.payload.reponse.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class UserIdentityAvailabilityResp {
    private Boolean available;
}
