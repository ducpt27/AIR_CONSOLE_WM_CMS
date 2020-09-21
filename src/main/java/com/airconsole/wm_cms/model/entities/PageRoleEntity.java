package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "page_role", schema = "ai_la_trieu_phu", catalog = "")
@IdClass(PageRoleEntityPK.class)
public class PageRoleEntity {
    private int pageId;
    private int roleId;
    private PagesEntity pagesByPageId;
    private RolesEntity rolesByRoleId;

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
        PageRoleEntity that = (PageRoleEntity) o;
        return pageId == that.pageId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "page_id", referencedColumnName = "id", nullable = false)
    public PagesEntity getPagesByPageId() {
        return pagesByPageId;
    }

    public void setPagesByPageId(PagesEntity pagesByPageId) {
        this.pagesByPageId = pagesByPageId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public RolesEntity getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(RolesEntity rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}
