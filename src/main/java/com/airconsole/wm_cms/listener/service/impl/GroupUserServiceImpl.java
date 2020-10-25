package com.airconsole.wm_cms.listener.service.impl;

import com.airconsole.wm_cms.listener.request.group.GroupReq;
import com.airconsole.wm_cms.listener.response.group.GroupResp;
import com.airconsole.wm_cms.listener.service.GroupUserService;
import com.airconsole.wm_cms.model.entities.Group;
import com.airconsole.wm_cms.model.entities.GroupUser;
import com.airconsole.wm_cms.model.repository.GroupRepository;
import com.airconsole.wm_cms.model.repository.GroupUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class GroupUserServiceImpl implements GroupUserService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupUserRepository groupUserRepository;

    @Override
    public void updateGroupUsers(String username, Collection<Integer> userIds, int groupId) {
        Group group = groupRepository.getOne(groupId);
        groupUserRepository.deleteAll(group.getGroupUsersById());
        List<GroupUser> groupUserList = new ArrayList<>();
        if (userIds != null) {
            userIds.forEach(id -> {
                GroupUser groupUser = new GroupUser();
                groupUser.setCreateBy(username);
                groupUser.setGroupId(groupId);
                groupUser.setUserId(id);
                groupUserList.add(groupUser);
            });
        }
        groupUserRepository.saveAll(groupUserList);
    }

    @Override
    public GroupResp addGroup(String username, GroupReq groupReq) {
        return null;
    }

    @Override
    public GroupResp updateGroup(String username, int id, GroupReq groupReq) {
        return null;
    }

    @Override
    public void deleteGroup(int id) {
        groupUserRepository.deleteById(id);
    }
}
