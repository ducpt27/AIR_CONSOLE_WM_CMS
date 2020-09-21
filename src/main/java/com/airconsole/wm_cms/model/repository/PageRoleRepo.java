package com.airconsole.wm_cms.model.repository;

import com.airconsole.wm_cms.model.entities.PageRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRoleRepo extends JpaRepository<PageRoleEntity, Long> {
}
