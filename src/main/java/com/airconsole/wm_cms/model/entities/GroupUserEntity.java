package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "group_user", schema = "ai_la_trieu_phu", catalog = "")
public class GroupUserEntity {
    private int id;
    private int userId;
    private Collection<GroupPageRoleEntity> groupPageRolesById;
    private UsersEntity usersByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupUserEntity that = (GroupUserEntity) o;
        return id == that.id &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }

    @OneToMany(mappedBy = "groupUserByGroupId")
    public Collection<GroupPageRoleEntity> getGroupPageRolesById() {
        return groupPageRolesById;
    }

    public void setGroupPageRolesById(Collection<GroupPageRoleEntity> groupPageRolesById) {
        this.groupPageRolesById = groupPageRolesById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }
}
