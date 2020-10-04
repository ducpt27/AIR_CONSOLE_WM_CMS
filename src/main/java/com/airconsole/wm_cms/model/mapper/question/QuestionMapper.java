package com.airconsole.wm_cms.model.mapper.question;

import com.airconsole.wm_cms.listener.response.question.AnswerInfoResp;
import com.airconsole.wm_cms.listener.response.question.QuestionInfoResp;
import com.airconsole.wm_cms.model.entities.Question;

public class QuestionMapper {

    public QuestionInfoResp getResponse(Question obj) {

        QuestionInfoResp questionInfoResp = new QuestionInfoResp();

        questionInfoResp.setId(obj.getId());
        questionInfoResp.setName(obj.getName());
        questionInfoResp.setInfo(obj.getInfo());
        questionInfoResp.setMileStone(obj.getMileStone());
        questionInfoResp.setStatus(obj.getStatus());

        questionInfoResp.setUpdateAt(obj.getUpdateAt());
        questionInfoResp.setUpdateBy(obj.getUpdateBy());
        questionInfoResp.setCreateAt(obj.getCreateAt());
        questionInfoResp.setCreateBy(obj.getCreateBy());

        if (obj.getAnswersById() != null) {
            obj.getAnswersById().stream().map(answer -> {
                AnswerInfoResp answerInfoResp = new AnswerInfoResp();
                answerInfoResp.setId(answer.getId());
                answerInfoResp.setName(answer.getName());
                answerInfoResp.setTrue(answer.isTrue());
               return null;
            });
        }

        return questionInfoResp;
    }
}
