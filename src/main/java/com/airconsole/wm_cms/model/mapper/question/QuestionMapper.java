package com.airconsole.wm_cms.model.mapper.question;

import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.listener.response.question.AnswerInfoResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.model.entities.Answer;
import com.airconsole.wm_cms.model.entities.Question;

import java.util.stream.Collectors;

public class QuestionMapper {

    public static QuestionInfoResp getResponse(Question entities) {

        if (entities == null) {
            return null;
        }

        QuestionInfoResp questionInfoResp = new QuestionInfoResp();

        questionInfoResp.setId(entities.getId());
        questionInfoResp.setName(entities.getName());
        questionInfoResp.setInfo(entities.getInfo());
        questionInfoResp.setMile_stone(entities.getMileStone());
        questionInfoResp.setStatus(entities.getStatus());

        questionInfoResp.setUpdate_at(entities.getUpdateAt());
        questionInfoResp.setUpdate_by(entities.getUpdateBy());
        questionInfoResp.setCreate_at(entities.getCreateAt());
        questionInfoResp.setCreate_by(entities.getCreateBy());

        if (entities.getAnswersById() != null) {
            questionInfoResp.setAnswers(entities.getAnswersById().stream().map(answer -> {
                AnswerInfoResp answerInfoResp = new AnswerInfoResp();
                answerInfoResp.setId(answer.getId());
                answerInfoResp.setName(answer.getName());
                answerInfoResp.setTrue(answer.isTrue());
                return answerInfoResp;
            }).collect(Collectors.toList()));
        }

        return questionInfoResp;
    }

    public static Question getEntity(QuestionReq req) {
        return getEntity(req, null, null);
    }

    public static Question getEntity(QuestionReq req, Integer id, Question entityOld) {

        if (req == null) {
            return null;
        }

        Question entity;

        if (id != null && id > 0
                && entityOld != null
        ) {
            entity = entityOld;
        } else {
            entity = new Question();
        }

        entity.setNextId(req.getNext_id());
        entity.setName(req.getName());
        entity.setInfo(req.getInfo());
        entity.setMileStone(req.getMile_stone());
        entity.setStatus(req.getStatus());

        if (req.getAnswers() != null) {
            entity.setAnswersById(req.getAnswers().stream().map(answerReq -> {
                Answer answer = new Answer();
                answer.setName(answerReq.getName());
                answer.setTrue(answerReq.getTrue());
                return answer;
            }).collect(Collectors.toList()));
        }

        return entity;
    }
}
