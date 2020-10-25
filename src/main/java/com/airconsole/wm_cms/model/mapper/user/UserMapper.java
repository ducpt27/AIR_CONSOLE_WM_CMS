package com.airconsole.wm_cms.model.mapper.user;

import com.airconsole.wm_cms.listener.request.user.UserReq;
import com.airconsole.wm_cms.listener.response.user.UserInfoResp;
import com.airconsole.wm_cms.model.entities.User;
import com.airconsole.wm_cms.model.mapper.group.GroupMapper;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserInfoResp getResponse(User entity) {
        if (entity == null) {
            return null;
        }

        UserInfoResp userInfoResp = new UserInfoResp();
        userInfoResp.setId(entity.getId());
        userInfoResp.setEmail(entity.getEmail());
        userInfoResp.setIsAdmin(entity.getIsAdmin().equals(Byte.valueOf("1")));
        userInfoResp.setUsername(entity.getUsername());
        userInfoResp.setName(entity.getName());
        userInfoResp.setCreateAt(entity.getCreateAt());
        userInfoResp.setCreateBy(entity.getCreateBy());
        userInfoResp.setUpdateAt(entity.getUpdateAt());
        userInfoResp.setUpdateBy(entity.getUpdateBy());
        userInfoResp.setGroups(entity.getGroupUsersById().stream().map(
                e -> GroupMapper.getResponse(e.getGroupByGroupId())
        ).collect(Collectors.toList()));

        return userInfoResp;
    }

    public static User getEntity(UserReq req) {
        return getEntity(req, null, null);
    }

    public static User getEntity(UserReq req, Integer id, User entityOld) {
        if (req == null) {
            return null;
        }

        User entity;

        if (id != null && id > 0
                && entityOld != null
        ) {
            entity = entityOld;
        } else {
            entity = new User();
        }

        entity.setName(req.getName());
        entity.setIsAdmin(req.isAdmin() ? Byte.valueOf("1") : Byte.valueOf("0"));
        entity.setEmail(req.getEmail());

        return entity;
    }
}
