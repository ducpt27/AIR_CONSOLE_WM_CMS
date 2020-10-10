package com.airconsole.wm_cms.listener.response.question;

import com.airconsole.wm_cms.listener.response.base.BaseResp;

import java.sql.Timestamp;
import java.util.Collection;

public class QuestionInfoResp extends BaseResp {

    private Integer id;
    private String name;
    private String info;
    private Integer next_id;
    private Integer mile_stone;
    private Byte status;
    private Timestamp create_at;
    private String create_by;
    private Timestamp update_at;
    private String update_by;
    private Collection<AnswerInfoResp> answers;

    public QuestionInfoResp() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Timestamp getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Timestamp create_at) {
        this.create_at = create_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Collection<AnswerInfoResp> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<AnswerInfoResp> answers) {
        this.answers = answers;
    }
}