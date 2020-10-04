package com.airconsole.wm_cms.listener.response.question;

import java.sql.Timestamp;
import java.util.Collection;

public class QuestionInfoResp {

    private int id;
    private String name;
    private String info;
    private Integer nextId;
    private Integer mileStone;
    private Byte status;
    private Timestamp createAt;
    private String createBy;
    private Timestamp updateAt;
    private String updateBy;
    private Collection<AnswerInfoResp> answers;

    public QuestionInfoResp() {
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    public Integer getMileStone() {
        return mileStone;
    }

    public void setMileStone(Integer mileStone) {
        this.mileStone = mileStone;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Collection<AnswerInfoResp> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<AnswerInfoResp> answers) {
        this.answers = answers;
    }
}