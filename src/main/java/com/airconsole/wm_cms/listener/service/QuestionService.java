package com.airconsole.wm_cms.listener.service;

import com.airconsole.wm_cms.listener.response.base.PagedResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;

public interface QuestionService {
    PagedResp<QuestionInfoResp> getAllQuestion(int page, int size);

    QuestionInfoResp createQuestion();
}
