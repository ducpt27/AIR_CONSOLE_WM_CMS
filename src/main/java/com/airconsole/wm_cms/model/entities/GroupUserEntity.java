package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group_user", schema = "ai_la_trieu_phu", catalog = "")
@IdClass(GroupUserEntityPK.class)
public class GroupUserEntity {
    private int groupId;
    private int userId;
    private GroupEntity groupByGroupId;
    private UserEntity userByUserId;

    @Id
    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Id
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
        return groupId == that.groupId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, userId);
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    public GroupEntity getGroupByGroupId() {
        return groupByGroupId;
    }

    public void setGroupByGroupId(GroupEntity groupByGroupId) {
        this.groupByGroupId = groupByGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
