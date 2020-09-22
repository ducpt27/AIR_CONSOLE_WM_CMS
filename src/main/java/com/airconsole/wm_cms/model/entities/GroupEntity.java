package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "_group", schema = "ai_la_trieu_phu", catalog = "")
public class GroupEntity {
    private int id;
    private String name;
    private String description;
    private boolean status;
    private Timestamp updateAt;
    private String updateBy;
    private Collection<GroupPageRoleEntity> groupPageRolesById;
    private Collection<GroupUserEntity> groupUsersById;
    private Timestamp createAt;
    private String createBy;

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
        GroupEntity that = (GroupEntity) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(updateAt, that.updateAt) &&
                Objects.equals(updateBy, that.updateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, updateAt, updateBy);
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<GroupPageRoleEntity> getGroupPageRolesById() {
        return groupPageRolesById;
    }

    public void setGroupPageRolesById(Collection<GroupPageRoleEntity> groupPageRolesById) {
        this.groupPageRolesById = groupPageRolesById;
    }

    @OneToMany(mappedBy = "groupByGroupId")
    public Collection<GroupUserEntity> getGroupUsersById() {
        return groupUsersById;
    }

    public void setGroupUsersById(Collection<GroupUserEntity> groupUsersById) {
        this.groupUsersById = groupUsersById;
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
}
