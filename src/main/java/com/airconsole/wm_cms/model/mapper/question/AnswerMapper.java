package com.airconsole.wm_cms.model.mapper.question;

import com.airconsole.wm_cms.listener.request.question.QuestionReq;
import com.airconsole.wm_cms.model.entities.Answer;

import java.util.stream.Collectors;
import java.util.List;

public class AnswerMapper {

    public static List<Answer> getEntities(QuestionReq req) {
        List<Answer> answers = null;
        if (req.getAnswers() != null) {
            answers = req.getAnswers().stream().map(answerReq -> {
                Answer answer = new Answer();
                answer.setName(answerReq.getName());
                answer.setTrue(answerReq.getTrue());
                return answer;
            }).collect(Collectors.toList());
        }
        return answers;
    }
}
