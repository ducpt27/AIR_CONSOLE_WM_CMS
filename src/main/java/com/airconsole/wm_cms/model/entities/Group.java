package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "_group", schema = "ai_la_trieu_phu", catalog = "")
public class Group {
    private int id;
    private String name;
    private String description;
    private boolean status;
    private Timestamp createAt;
    private String createBy;
    private Timestamp updateAt;
    private String updateBy;
    private Collection<GroupPageRole> groupPageRolesById;
    private Collection<GroupUser> groupUsersById;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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
        Group group = (Group) o;
        return id == group.id &&
                status == group.status &&
                Objects.equals(name, group.name) &&
                Objects.equals(description, group.description) &&
                Objects.equals(createAt, group.createAt) &&
                Objects.equals(createBy, group.createBy) &&
                Objects.equals(updateAt, group.updateAt) &&
                Objects.equals(updateBy, group.updateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, createAt, createBy, updateAt, updateBy);
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<GroupPageRole> getGroupPageRolesById() {
        return groupPageRolesById;
    }

    public void setGroupPageRolesById(Collection<GroupPageRole> groupPageRolesById) {
        this.groupPageRolesById = groupPageRolesById;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<GroupUser> getGroupUsersById() {
        return groupUsersById;
    }

    public void setGroupUsersById(Collection<GroupUser> groupUsersById) {
        this.groupUsersById = groupUsersById;
    }
}
