package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.listener.payload.reponse.user.UserIdentityAvailabilityResp;
import com.airconsole.wm_cms.listener.payload.reponse.user.UserProfileResp;
import com.airconsole.wm_cms.model.repository.*;
import com.airconsole.wm_cms.listener.payload.exception.ResourceNotFoundException;
import com.airconsole.wm_cms.model.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepo userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users/{username}")
    public UserProfileResp getUserProfile(@PathVariable(value = "username") String username) {
        System.out.println("AA");
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfileResp userProfile = new UserProfileResp(user.getId(), user.getUsername(), user.getFullName());

        return userProfile;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailabilityResp checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailabilityResp(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailabilityResp checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailabilityResp(isAvailable);
    }
}
