package com.airconsole.wm_cms.security;

import com.airconsole.wm_cms.model.entities.GroupUser;
import com.airconsole.wm_cms.model.entities.Role;
import com.airconsole.wm_cms.model.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
public class UserPrincipal implements UserDetails {

    private Integer id;

    private String name;

    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Integer id, String name, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (user.getGroupUsersById() != null) {
            for (GroupUser groupUser : user.getGroupUsersById()) {
                authorities.addAll(groupUser.getGroupByGroupId().getGroupPageRolesById()
                        .stream()
                        .map(e -> {
                            if (e.getRoleByRoleId() != null) {
                                Role role = e.getRoleByRoleId();
                                if (!StringUtils.isEmpty(role.getCode()) && role.isStatus()) {
                                    return new SimpleGrantedAuthority("ROLE_" + role.getCode().trim().toUpperCase());
                                }
                            }
                            return null;
                        })
                        .collect(Collectors.toList()));
            };
        }

        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
