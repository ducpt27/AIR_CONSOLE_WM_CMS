package com.airconsole.wm_cms.listener.request.question;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

public class QuestionReq {
    @NotBlank
    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String info;

    private Integer next_id;

    private Integer mile_stone;

    @NotBlank
    private Byte status;

    private Collection<AnswerReq> answers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getNext_id() {
        return next_id;
    }

    public void setNext_id(Integer next_id) {
        this.next_id = next_id;
    }

    public Integer getMile_stone() {
        return mile_stone;
    }

    public void setMile_stone(Integer mile_stone) {
        this.mile_stone = mile_stone;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Collection<AnswerReq> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<AnswerReq> answers) {
        this.answers = answers;
    }
}
