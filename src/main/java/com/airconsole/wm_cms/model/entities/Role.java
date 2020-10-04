package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Role {
    private int id;
    private String name;
    private String code;
    private boolean status;
    private Collection<GroupPageRole> groupPageRolesById;
    private Collection<PageRole> pageRolesById;

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
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        Role role = (Role) o;
        return id == role.id &&
                status == role.status &&
                Objects.equals(name, role.name) &&
                Objects.equals(code, role.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, status);
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<GroupPageRole> getGroupPageRolesById() {
        return groupPageRolesById;
    }

    public void setGroupPageRolesById(Collection<GroupPageRole> groupPageRolesById) {
        this.groupPageRolesById = groupPageRolesById;
    }

    @OneToMany(mappedBy = "roleByRoleId")
    public Collection<PageRole> getPageRolesById() {
        return pageRolesById;
    }

    public void setPageRolesById(Collection<PageRole> pageRolesById) {
        this.pageRolesById = pageRolesById;
    }
}
