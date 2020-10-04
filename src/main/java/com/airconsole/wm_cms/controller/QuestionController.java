package com.airconsole.wm_cms.controller;

import com.airconsole.wm_cms.common.AppConstants;
import com.airconsole.wm_cms.listener.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/questions")
    @PreAuthorize("hasRole('SHOW_QUESTION')")
    public ResponseEntity<?> getListQuestion(
            @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size
    ) {
        return ResponseEntity.ok(questionService.getAllQuestion(page, size));
    }
}
