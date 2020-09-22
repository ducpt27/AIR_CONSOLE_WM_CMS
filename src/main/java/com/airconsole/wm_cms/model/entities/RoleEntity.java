package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "role", schema = "ai_la_trieu_phu", catalog = "")
public class RoleEntity {
    private int id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updateAt;
    private String createBy;
    private String updateBy;
    private boolean status;
    private Collection<GroupPageRoleEntity> groupPageRolesById;
    private Collection<PageRoleEntity> pageRolesById;

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
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "status")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return id == that.id &&
                status == that.status &&
                Objects.equals(name, that.name) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updateAt, that.updateAt) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateBy, that.updateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, updateAt, createBy, updateBy, status);
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<GroupPageRoleEntity> getGroupPageRolesById() {
        return groupPageRolesById;
    }

    public void setGroupPageRolesById(Collection<GroupPageRoleEntity> groupPageRolesById) {
        this.groupPageRolesById = groupPageRolesById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<PageRoleEntity> getPageRolesById() {
        return pageRolesById;
    }

    public void setPageRolesById(Collection<PageRoleEntity> pageRolesById) {
        this.pageRolesById = pageRolesById;
    }
}
