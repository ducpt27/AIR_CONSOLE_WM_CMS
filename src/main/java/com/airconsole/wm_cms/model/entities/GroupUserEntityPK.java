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
public class GroupUserEntityPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "group_id")
    private int groupId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    public GroupUserEntityPK() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += groupId;
        hash += userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GroupUserEntityPK)) {
            return false;
        }
        GroupUserEntityPK other = (GroupUserEntityPK) object;
        if (this.groupId != other.groupId) {
            return false;
        }
        return this.userId == other.userId;
    }

    @Override
    public String toString() {
        return "com.airconsole.wm_cms.model.entities.GroupUserEntityPK[ groupId=" + groupId + ", userId=" + userId + " ]";
    }
    
}
