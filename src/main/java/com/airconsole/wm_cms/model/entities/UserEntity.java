package com.airconsole.wm_cms.model.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "ai_la_trieu_phu", catalog = "")
public class UserEntity {
    private int id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String createBy;
    private String updateBy;
    private Collection<GroupUserEntity> groupUsersById;

    public UserEntity() {
    }

    public UserEntity(String fullName, String username, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "create_at")
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "create_by")
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(createAt, that.createAt) &&
                Objects.equals(updateAt, that.updateAt) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateBy, that.updateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, username, password, email, createAt, updateAt, createBy, updateBy);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<GroupUserEntity> getGroupUsersById() {
        return groupUsersById;
    }

    public void setGroupUsersById(Collection<GroupUserEntity> groupUsersById) {
        this.groupUsersById = groupUsersById;
    }
}
