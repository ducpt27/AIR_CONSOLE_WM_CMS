package com.airconsole.wm_cms.model.repository;

import com.airconsole.wm_cms.model.entities.PagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepo extends JpaRepository<PagesEntity, Long> {
}
