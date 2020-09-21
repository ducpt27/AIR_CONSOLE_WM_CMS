package com.airconsole.wm_cms.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PageRoleEntityPK implements Serializable {
    private int pageId;
    private int roleId;

    @Column(name = "page_id")
    @Id
    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    @Column(name = "role_id")
    @Id
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
        PageRoleEntityPK that = (PageRoleEntityPK) o;
        return pageId == that.pageId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageId, roleId);
    }
}
