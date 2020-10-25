package com.airconsole.wm_cms.listener.service.impl;

import com.airconsole.wm_cms.listener.request.user.UserReq;
import com.airconsole.wm_cms.listener.response.user.UserInfoResp;
import com.airconsole.wm_cms.listener.service.UserService;
import com.airconsole.wm_cms.model.entities.GroupUser;
import com.airconsole.wm_cms.model.entities.User;
import com.airconsole.wm_cms.model.mapper.user.UserMapper;
import com.airconsole.wm_cms.model.repository.GroupUserRepository;
import com.airconsole.wm_cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupUserRepository groupUserRepository;

    @Override
    public List<UserInfoResp> getAllUser() {
        List<User> questions = userRepository
                .findAll(new Sort(Sort.Direction.DESC, "createAt"));

        return questions.stream()
                .map(UserMapper::getResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserInfoResp getUser(int id) {
        User user = userRepository.getOne(id);
        return UserMapper.getResponse(user);
    }

    @Override
    public UserInfoResp updateUser(String username, int id, UserReq userReq) {
        User user = userRepository.getOne(id);

        user.getGroupUsersById().stream().map(e -> {
            groupUserRepository.deleteById(e.getGroupId());
            return false;
        });

        userReq.getGroups().stream().map(groupId -> {
            return groupUserRepository.save(new GroupUser(groupId, id, username));
        });

        UserMapper.getEntity(userReq, id, user);

        user.setUpdateBy(username);

        System.out.println("=========================================");
        System.out.println(userReq.getIsAdmin());
        System.out.println(user.getIsAdmin());
        System.out.println("=========================================");

        User result = userRepository.save(user);

        return UserMapper.getResponse(result);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
