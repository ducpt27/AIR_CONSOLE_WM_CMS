package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "page_role", schema = "ai_la_trieu_phu", catalog = "")
@IdClass(PageRoleEntityPK.class)
public class PageRoleEntity {
    private int pageId;
    private int roleId;
    private PageEntity pageByPageId;
    private RoleEntity roleByRoleId;

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
    public PageEntity getPageByPageId() {
        return pageByPageId;
    }

    public void setPageByPageId(PageEntity pageByPageId) {
        this.pageByPageId = pageByPageId;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
