package com.airconsole.wm_cms.model.entities;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;

    @ManyToMany(mappedBy = "roleEntityCollection", fetch = FetchType.LAZY)
    private Collection<PageEntity> pageEntityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleEntity", fetch = FetchType.LAZY)
    private Collection<GroupPageRoleEntity> groupPageRoleEntityCollection;

    public RoleEntity() {
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RoleEntity)) {
            return false;
        }
        RoleEntity other = (RoleEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airconsole.wm_cms.model.entities.RoleEntity[ id=" + id + " ]";
    }
    
}
