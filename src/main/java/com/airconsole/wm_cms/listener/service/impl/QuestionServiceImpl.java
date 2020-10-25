package com.airconsole.wm_cms.listener.service.impl;

import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.base.PagedResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.listener.service.PagingService;
import com.airconsole.wm_cms.listener.service.QuestionService;
import com.airconsole.wm_cms.model.entities.Question;
import com.airconsole.wm_cms.model.mapper.question.QuestionMapper;
import com.airconsole.wm_cms.model.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl extends PagingService implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public PagedResp<QuestionInfoResp> getAllQuestion(int page, int size) {
        validatePageNumberAndSize(page, size);
        Page<Question> questions = questionRepository
                .findAll(PageRequest.of(page, size, Sort.Direction.DESC, "createAt"));


        if (questions.getNumberOfElements() == 0) {
            return new PagedResp<>(ErrorCode.SUCCESS, Collections.emptyList(), questions.getNumber(),
                    questions.getSize(), questions.getTotalElements(), questions.getTotalPages(), questions.isLast());
        }

        List<QuestionInfoResp> questionResps = questions
                .map(QuestionMapper::getResponse)
                .getContent();

        return new PagedResp<>(ErrorCode.SUCCESS, questionResps, questions.getNumber(),
                questions.getSize(), questions.getTotalElements(), questions.getTotalPages(), questions.isLast());
    }

    @Override
    public List<QuestionInfoResp> getAllQuestion() {
        List<Question> questions = questionRepository
                .findAll(new Sort(Sort.Direction.DESC, "createAt"));

        return questions.stream()
                .map(QuestionMapper::getResponse)
                .collect(Collectors.toList());
    }

    @Override
    public QuestionInfoResp getQuestion(int id) {
        Question question = questionRepository.getOne(id);
        return QuestionMapper.getResponse(question);
    }

    @Override
    public QuestionInfoResp addQuestion(String username, QuestionReq questionReq) {

        Question entity = QuestionMapper.getEntity(questionReq);
        entity.setUpdateBy(username);

        Question result = questionRepository.save(entity);

        return QuestionMapper.getResponse(result);
    }

    @Override
    public QuestionInfoResp updateQuestion(String username, int id, QuestionReq questionReq) {
        Question question = questionRepository.getOne(id);

        QuestionMapper.getEntity(questionReq, id, question);

        question.setUpdateBy(username);

        Question result = questionRepository.save(question);

        return QuestionMapper.getResponse(result);
    }

    @Override
    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }
}
