package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.listener.response.UserIdentityAvailabilityResp;
import com.airconsole.wm_cms.listener.response.UserSummaryResp;
import com.airconsole.wm_cms.security.CurrentUser;
import com.airconsole.wm_cms.security.UserPrincipal;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.airconsole.wm_cms.model.repository.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    public ResponseEntity<?> getCurrentUser(@CurrentUser final UserPrincipal currentUser) {
        return ResponseEntity.ok(new UserSummaryResp(currentUser.getId(), currentUser.getUsername(), currentUser.getName()));
    }

    @GetMapping("/user/checkUsernameAvailability")
    public ResponseEntity<?> checkUsernameAvailability(@RequestParam(value = "username") final String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return ResponseEntity.ok(new UserIdentityAvailabilityResp(ErrorCode.SUCCESS, isAvailable));
    }

    @GetMapping("/user/checkEmailAvailability")
    public ResponseEntity<?> checkEmailAvailability(@RequestParam(value = "email") final String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return ResponseEntity.ok(new UserIdentityAvailabilityResp(ErrorCode.SUCCESS, isAvailable));
    }

    @GetMapping("/users/{username}")
    @PreAuthorize("hasRole('SHOW_DETAIL_USER')")
    public UserSummaryResp getUserProfile(@PathVariable(value = "username") final String username) {

//        User user = userRepository.findByUsername(username).orElseThrow(() ->
//                        new ResourceNotFoundException(new ApiValidationError("User", "username", username))
//        );

//        return new UserSummaryResp(user.getId(), user.getUsername(), user.getName());
        return null;
    }

}
