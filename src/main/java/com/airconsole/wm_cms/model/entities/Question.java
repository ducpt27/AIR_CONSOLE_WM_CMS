package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Question {
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
    private Collection<Answer> answersById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "next_id")
    public Integer getNextId() {
        return nextId;
    }

    public void setNextId(Integer nextId) {
        this.nextId = nextId;
    }

    @Basic
    @Column(name = "mile_stone")
    public Integer getMileStone() {
        return mileStone;
    }

    public void setMileStone(Integer mileStone) {
        this.mileStone = mileStone;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_at")
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id &&
                Objects.equals(name, question.name) &&
                Objects.equals(info, question.info) &&
                Objects.equals(nextId, question.nextId) &&
                Objects.equals(mileStone, question.mileStone) &&
                Objects.equals(status, question.status) &&
                Objects.equals(createAt, question.createAt) &&
                Objects.equals(createBy, question.createBy) &&
                Objects.equals(updateAt, question.updateAt) &&
                Objects.equals(updateBy, question.updateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info, nextId, mileStone, status, createAt, createBy, updateAt, updateBy);
    }

    @OneToMany(mappedBy = "questionByIdQuestion")
    public Collection<Answer> getAnswersById() {
        return answersById;
    }

    public void setAnswersById(Collection<Answer> answersById) {
        this.answersById = answersById;
    }
}
