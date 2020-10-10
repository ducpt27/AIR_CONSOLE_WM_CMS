package com.airconsole.wm_cms.listener.service;

import com.airconsole.wm_cms.listener.request.group.GroupReq;
import com.airconsole.wm_cms.listener.response.group.GroupResp;

import java.util.Collection;

public interface GroupUserService {
    void updateGroupUsers(String username, Collection<Integer> userId, int groupId);

    GroupResp addGroup(String username, GroupReq groupReq);

    GroupResp updateGroup(String username, int id, GroupReq groupReq);

    void deleteGroup(int id);
}
