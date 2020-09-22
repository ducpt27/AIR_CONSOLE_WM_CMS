package com.airconsole.wm_cms.payload.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class BaseResponse {
    private int code;
    private String message;
}
