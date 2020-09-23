package com.airconsole.wm_cms.model.entities;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Data
@ToString
@Embeddable
public class GroupPageRoleEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private int groupId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "page_id")
    private int pageId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private int roleId;

    public GroupPageRoleEntityPK() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += groupId;
        hash += pageId;
        hash += roleId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GroupPageRoleEntityPK)) {
            return false;
        }
        GroupPageRoleEntityPK other = (GroupPageRoleEntityPK) object;
        if (this.groupId != other.groupId) {
            return false;
        }
        if (this.pageId != other.pageId) {
            return false;
        }
        return this.roleId == other.roleId;
    }

    @Override
    public String toString() {
        return "com.airconsole.wm_cms.model.entities.GroupPageRoleEntityPK[ groupId=" + groupId + ", pageId=" + pageId + ", roleId=" + roleId + " ]";
    }
    
}
