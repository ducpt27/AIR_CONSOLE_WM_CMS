package com.airconsole.wm_cms.listener.request.question;

import javax.validation.constraints.NotBlank;

public class QuestionReq {
    @NotBlank
    private String name;

    private String info;
}
