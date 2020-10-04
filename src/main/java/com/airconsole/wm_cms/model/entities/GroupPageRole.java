package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_page_role", schema = "ai_la_trieu_phu", catalog = "")
@IdClass(GroupPageRolePK.class)
public class GroupPageRole {
    private int groupId;
    private int pageId;
    private int roleId;
    private Group groupByGroupId;
    private Page pageByPageId;
    private Role roleByRoleId;

    @Id
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

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
        GroupPageRole that = (GroupPageRole) o;
        return groupId == that.groupId &&
                pageId == that.pageId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, pageId, roleId);
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false, updatable = false, insertable = false)
    public Group getGroupByGroupId() {
        return groupByGroupId;
    }

    public void setGroupByGroupId(Group groupByGroupId) {
        this.groupByGroupId = groupByGroupId;
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
