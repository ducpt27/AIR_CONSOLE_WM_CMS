package com.airconsole.wm_cms.model.repository;

import com.airconsole.wm_cms.model.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question> {
}
