package com.airconsole.wm_cms.model.mapper.group;

import com.airconsole.wm_cms.listener.response.group.GroupResp;
import com.airconsole.wm_cms.model.entities.Group;

public class GroupMapper {

    public static GroupResp getResponse(Group entity) {
        if (entity == null) {
            return null;
        }
        GroupResp response = new GroupResp();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());

        return response;
    }
}
