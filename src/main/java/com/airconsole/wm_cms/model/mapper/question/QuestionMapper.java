package com.airconsole.wm_cms.model.mapper.question;

import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.listener.response.question.AnswerInfoResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.model.entities.Answer;
import com.airconsole.wm_cms.model.entities.Question;

import java.util.stream.Collectors;

public class QuestionMapper {

    public static QuestionInfoResp getResponse(Question entity) {

        if (entity == null) {
            return null;
        }

        QuestionInfoResp questionInfoResp = new QuestionInfoResp();

        questionInfoResp.setId(entity.getId());
        questionInfoResp.setName(entity.getName());
        questionInfoResp.setInfo(entity.getInfo());
        questionInfoResp.setMile_stone(entity.getMileStone());
        questionInfoResp.setStatus(entity.getStatus());

        questionInfoResp.setUpdate_at(entity.getUpdateAt());
        questionInfoResp.setUpdate_by(entity.getUpdateBy());
        questionInfoResp.setCreate_at(entity.getCreateAt());
        questionInfoResp.setCreate_by(entity.getCreateBy());

        if (entity.getAnswersById() != null) {
            questionInfoResp.setAnswers(entity.getAnswersById().stream().map(answer -> {
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
        entity.setStatus(req.getStatus() ? Byte.valueOf("1") : Byte.valueOf("0"));

        return entity;
    }
}
