package com.airconsole.wm_cms.listener.service;

import com.airconsole.wm_cms.listener.request.user.UserReq;
import com.airconsole.wm_cms.listener.response.user.UserInfoResp;

import java.util.List;

public interface UserService {

    List<UserInfoResp> getAllUser();

    UserInfoResp getUser(int id);

    UserInfoResp updateUser(String username, int id, UserReq UserReq);

    void deleteUser(int id);
}
