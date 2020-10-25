package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.listener.response.base.BaseResp;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.listener.service.QuestionService;
import com.airconsole.wm_cms.security.CurrentUser;
import com.airconsole.wm_cms.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("")
    @PreAuthorize("hasRole('SHOW_QUESTION')")
    public ResponseEntity<?> getList(
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId,
            @RequestParam(value = "page") final Integer page,
            @RequestParam(value = "size") final Integer size
    ) {
        if (page == 0 && size == 0) {
            return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS, questionService.getAllQuestion()));
        }
        return ResponseEntity.ok(questionService.getAllQuestion(page, size));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SHOW_DETAIL_QUESTION')")
    public ResponseEntity<?> get(
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId,
            @PathVariable final int id
    ) {
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS, questionService.getQuestion(id)));
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ADD_QUESTION')")
    public ResponseEntity<?> add(
            @CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody final QuestionReq questionsReq
    ) {
        QuestionInfoResp result = questionService.addQuestion(currentUser.getUsername(), questionsReq);
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS, result));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('UPDATE_QUESTION')")
    public ResponseEntity<?> update(
            @CurrentUser UserPrincipal currentUser,
            @PathVariable final int id,
            @Valid @RequestBody final QuestionReq questionReq
    ) {
        QuestionInfoResp result = questionService.updateQuestion(currentUser.getUsername(), id, questionReq);
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS, result));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('DELETE_QUESTION')")
    public ResponseEntity<?> delete(
            @RequestParam(value = "channel") final String channel,
            @RequestParam(value = "transId") final String transId,
            @PathVariable final int id
    ) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok(new BaseResp(ErrorCode.SUCCESS));
    }
}