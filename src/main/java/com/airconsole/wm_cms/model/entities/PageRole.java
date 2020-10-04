package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "page_role", schema = "ai_la_trieu_phu", catalog = "")
@IdClass(PageRolePK.class)
public class PageRole {
    private int pageId;
    private int roleId;
    private Page pageByPageId;
    private Role roleByRoleId;

    @Id
    @Column(name = "page_id")
    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    @Id
    @Column(name = "role_id")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageRole pageRole = (PageRole) o;
        return pageId == pageRole.pageId &&
                roleId == pageRole.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "page_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Page getPageByPageId() {
        return pageByPageId;
    }

    public void setPageByPageId(Page pageByPageId) {
        this.pageByPageId = pageByPageId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
