package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.common.AppConstants;
import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.listener.response.base.BaseResp;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoAddResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.listener.service.*;
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
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    @PreAuthorize("hasRole('SHOW_QUESTION')")
    public ResponseEntity<?> getList(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) final int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) final int size
    ) {
        return ResponseEntity.ok(questionService.getAllQuestion(page, size));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SHOW_DETAIL_QUESTION')")
    public ResponseEntity<?> get(@PathVariable final int id) {
        return ResponseEntity.ok(questionService.getQuestion(id));
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADD_QUESTION')")
    public ResponseEntity<?> addList(
            @CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody final Collection<QuestionReq> questionsReq
    ) {
        QuestionInfoAddResp result = questionService.addQuestion(currentUser.getUsername(), questionsReq);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(new BaseResp(ErrorCode.SUCCESS));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('UPDATE_QUESTION')")
    public ResponseEntity<?> update(
            @CurrentUser UserPrincipal currentUser,
            @PathVariable final int id,
            @Valid @RequestBody final QuestionReq questionReq
    ) {
        QuestionInfoResp result = questionService.updateQuestion(currentUser.getUsername(), id, questionReq);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{id}")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location).body(new BaseResp(ErrorCode.SUCCESS));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('DELETE_QUESTION')")
    public ResponseEntity<?> delete(
            @PathVariable final int id
    ) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS));
    }
}