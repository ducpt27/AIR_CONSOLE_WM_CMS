package com.airconsole.wm_cms.listener.service;

import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.model.entities.Question;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.base.PagedResp;
import com.airconsole.wm_cms.model.mapper.question.QuestionMapper;
import com.airconsole.wm_cms.model.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceImpl extends PagingService implements QuestionService {

    private static final QuestionMapper QUESTION_MAPPER = new QuestionMapper();

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public PagedResp<QuestionInfoResp> getAllQuestion(int page, int size) {
        validatePageNumberAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createAt");
        Page<Question> questions = questionRepository.findAll(pageable);

        if (questions.getNumberOfElements() == 0) {
            return new PagedResp<>(ErrorCode.SUCCESS, Collections.emptyList(), questions.getNumber(),
                    questions.getSize(), questions.getTotalElements(), questions.getTotalPages(), questions.isLast());
        }

        List<QuestionInfoResp> questionResps = questions
                .map(e -> QUESTION_MAPPER.getResponse(e))
                .getContent();

        return new PagedResp<>(ErrorCode.SUCCESS, questionResps, questions.getNumber(),
                questions.getSize(), questions.getTotalElements(), questions.getTotalPages(), questions.isLast());
    }

    @Override
    public QuestionInfoResp createQuestion() {
        return null;
    }
}
