package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.listener.exception.ResourceNotFoundException;
import com.airconsole.wm_cms.listener.request.user.UserReq;
import com.airconsole.wm_cms.listener.response.UserIdentityAvailabilityResp;
import com.airconsole.wm_cms.listener.response.UserSummaryResp;
import com.airconsole.wm_cms.listener.response.base.BaseResp;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.user.UserInfoResp;
import com.airconsole.wm_cms.listener.service.UserService;
import com.airconsole.wm_cms.model.entities.User;
import com.airconsole.wm_cms.model.repository.UserRepository;
import com.airconsole.wm_cms.security.CurrentUser;
import com.airconsole.wm_cms.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    @PreAuthorize("hasRole('SHOW_USER')")
    public ResponseEntity<?> getList(
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId
    ) {
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS, userService.getAllUser()));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('UPDATE_USER')")
    public ResponseEntity<?> update(
            @CurrentUser UserPrincipal currentUser,
            @PathVariable final int id,
            @Valid @RequestBody final UserReq userReq
    ) {
        UserInfoResp result = userService.updateUser(currentUser.getUsername(), id, userReq);
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS, result));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('DELETE_USER')")
    public ResponseEntity<?> delete(
            @PathVariable final int id,
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId
    ) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS));
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('SHOW_DETAIL_USER')")
    public UserSummaryResp getUserProfile(
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId,
            @PathVariable(value = "username") final String username
    ) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new ResourceNotFoundException("User", "username", username)
        );
        return new UserSummaryResp(user.getId(), user.getUsername(), user.getName());
    }

    @GetMapping("/checkUsernameAvailability")
    public ResponseEntity<?> checkUsernameAvailability(
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId,
            @RequestParam(value = "username") final String username
    ) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return ResponseEntity.ok(new UserIdentityAvailabilityResp(ErrorCode.SUCCESS, isAvailable));
    }

    @GetMapping("/checkEmailAvailability")
    public ResponseEntity<?> checkEmailAvailability(
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId,
            @RequestParam(value = "email") final String email
    ) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return ResponseEntity.ok(new UserIdentityAvailabilityResp(ErrorCode.SUCCESS, isAvailable));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(
            @CurrentUser final UserPrincipal currentUser,
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId
    ) {
        return ResponseEntity.ok(
                new BaseResp(ErrorCode.SUCCESS, new UserSummaryResp(
                        currentUser.getId(),
                        currentUser.getName(),
                        currentUser.getUsername(),
                        currentUser.getAuthorities()
                                .stream()
                                .map(GrantedAuthority::getAuthority).collect(Collectors.toList())
                ))
        );
    }
}
