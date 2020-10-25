package com.airconsole.wm_cms.listener.request.question;

import javax.validation.constraints.NotBlank;

public class AnswerReq {

    private Integer id;

    @NotBlank
    private String name;

    private boolean isTrue;

    public AnswerReq() {
    }

    public AnswerReq(Integer id, @NotBlank String name, boolean isTrue) {
        this.id = id;
        this.name = name;
        this.isTrue = isTrue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isTrue() {
        return isTrue;
    }

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