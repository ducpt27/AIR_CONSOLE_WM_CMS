package com.airconsole.wm_cms.model.entities;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Data
@ToString
@Entity
@Table(name = "group_page_role")
@NamedQueries({
    @NamedQuery(name = "GroupPageRoleEntity.findAll", query = "SELECT g FROM GroupPageRoleEntity g")})
public class GroupPageRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected GroupPageRoleEntityPK groupPageRoleEntityPK;

    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupEntity groupEntity;

    @JoinColumn(name = "page_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PageEntity pageEntity;

    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RoleEntity roleEntity;

    public GroupPageRoleEntity() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupPageRoleEntityPK != null ? groupPageRoleEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GroupPageRoleEntity)) {
            return false;
        }
        GroupPageRoleEntity other = (GroupPageRoleEntity) object;
        if ((this.groupPageRoleEntityPK == null && other.groupPageRoleEntityPK != null) || (this.groupPageRoleEntityPK != null && !this.groupPageRoleEntityPK.equals(other.groupPageRoleEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airconsole.wm_cms.model.entities.GroupPageRoleEntity[ groupPageRoleEntityPK=" + groupPageRoleEntityPK + " ]";
    }
    
}
