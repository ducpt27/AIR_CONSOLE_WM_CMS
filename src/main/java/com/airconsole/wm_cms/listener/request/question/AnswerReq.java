package com.airconsole.wm_cms.listener.request.question;

import javax.validation.constraints.NotBlank;

public class AnswerReq {
    @NotBlank
    private String name;

    private boolean isTrue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}