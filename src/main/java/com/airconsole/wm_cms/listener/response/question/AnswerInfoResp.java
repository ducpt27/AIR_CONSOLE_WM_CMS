package com.airconsole.wm_cms.listener.response.question;

public class AnswerInfoResp {
    private int id;
    private String name;
    private boolean isTrue;

    public AnswerInfoResp() {
    }

    public AnswerInfoResp(int id, String name, boolean isTrue) {
        this.id = id;
        this.name = name;
        this.isTrue = isTrue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
