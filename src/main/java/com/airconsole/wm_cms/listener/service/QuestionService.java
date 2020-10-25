package com.airconsole.wm_cms.listener.service;

import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.listener.response.base.PagedResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;

import java.util.List;

public interface QuestionService {
    List<QuestionInfoResp> getAllQuestion();

    PagedResp<QuestionInfoResp> getAllQuestion(int page, int size);

    QuestionInfoResp getQuestion(int id);

    QuestionInfoResp addQuestion(String username, QuestionReq questionReq);

    QuestionInfoResp updateQuestion(String username, int id, QuestionReq questionReq);

    void deleteQuestion(int id);
}
