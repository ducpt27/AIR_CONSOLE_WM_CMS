package com.airconsole.wm_cms.security;

import com.airconsole.wm_cms.model.entities.GroupUserEntity;
import com.airconsole.wm_cms.model.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private Integer id;

    private String fullName;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer id, String fullName, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UserEntity user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (GroupUserEntity entity : user.getGroupUsersById()) {
            authorities = entity.getGroupByGroupId()
                    .getGroupPageRolesById()
                    .stream().map(e -> new SimpleGrantedAuthority(e.getRoleByRoleId().getName())).collect(Collectors.toList());
        }

        return new UserPrincipal(
                user.getId(),
                user.getFullName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
