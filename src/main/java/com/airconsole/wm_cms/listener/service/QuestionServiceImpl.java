package com.airconsole.wm_cms.listener.service;

import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.listener.response.base.ErrorCode;
import com.airconsole.wm_cms.listener.response.base.PagedResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoAddResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.model.entities.Question;
import com.airconsole.wm_cms.model.mapper.question.QuestionMapper;
import com.airconsole.wm_cms.model.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createAt");
        Page<Question> questions = questionRepository.findAll(pageable);

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
    public QuestionInfoResp getQuestion(int id) {
        Question question = questionRepository.getOne(id);
        return QuestionMapper.getResponse(question);
    }

    @Override
    public QuestionInfoAddResp addQuestion(String username, Collection<QuestionReq> questionReq) {
        List<Question> questions = new ArrayList<>();

        for (QuestionReq req : questionReq) {
            Question entity = QuestionMapper.getEntity(req);
            entity.setUpdateBy(username);
            questions.add(entity);
        }

        List<Question> result = questionRepository.saveAll(questions);

        QuestionInfoAddResp questionInfoAddResp = new QuestionInfoAddResp();

        if (result.size() == 1) {
            questionInfoAddResp.setId(result.get(0).getId());
        }

        questionInfoAddResp.setTotal_record(result.size());

        return questionInfoAddResp;
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
