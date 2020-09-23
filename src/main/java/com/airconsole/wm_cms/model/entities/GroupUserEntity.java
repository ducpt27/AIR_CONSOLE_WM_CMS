package com.airconsole.wm_cms.model.entities;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@Entity
@Table(name = "group_user")
public class GroupUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected GroupUserEntityPK groupUserEntityPK;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "create_by")
    private String createBy;

    @Size(max = 32)
    @Column(name = "update_by")
    private String updateBy;

    @Basic(optional = false)
    @NotNull
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Column(name = "update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupEntity groupEntity;

    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity userEntity;

    public GroupUserEntity() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupUserEntityPK != null ? groupUserEntityPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GroupUserEntity)) {
            return false;
        }
        GroupUserEntity other = (GroupUserEntity) object;
        if ((this.groupUserEntityPK == null && other.groupUserEntityPK != null) || (this.groupUserEntityPK != null && !this.groupUserEntityPK.equals(other.groupUserEntityPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airconsole.wm_cms.model.entities.GroupUserEntity[ groupUserEntityPK=" + groupUserEntityPK + " ]";
    }
    
}
