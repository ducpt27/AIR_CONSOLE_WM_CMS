package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.listener.request.group.GroupReq;
import com.airconsole.wm_cms.listener.response.base.BaseResp;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.group.GroupResp;
import com.airconsole.wm_cms.listener.service.GroupUserService;
import com.airconsole.wm_cms.security.CurrentUser;
import com.airconsole.wm_cms.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired()
    GroupUserService groupUserService;

    @PutMapping("/assign/{groupId}")
    @PreAuthorize("hasRole('UPDATE_GROUP_USER')")
    public ResponseEntity<?> updateGroupUsers(
            @CurrentUser UserPrincipal currentUser,
            @PathVariable final int groupId,
            @RequestBody final Collection<Integer> userIds
    ) {
        groupUserService.updateGroupUsers(currentUser.getUsername(), userIds, groupId);

        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS));
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADD_GROUP')")
    public ResponseEntity<?> add(
            @CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody final GroupReq groupReq
    ) {
        GroupResp result = groupUserService.addGroup(currentUser.getUsername(), groupReq);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(new BaseResp(ErrorCode.SUCCESS));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('UPDATE_GROUP')")
    public ResponseEntity<?> update(
            @CurrentUser UserPrincipal currentUser,
            @PathVariable final int id,
            @Valid @RequestBody final GroupReq groupReq
    ) {
        GroupResp result = groupUserService.updateGroup(currentUser.getUsername(), id, groupReq);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(new BaseResp(ErrorCode.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('DELETE_GROUP')")
    public ResponseEntity<?> delete(
            @PathVariable final int id
    ) {
        groupUserService.deleteGroup(id);
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS));
    }
}
