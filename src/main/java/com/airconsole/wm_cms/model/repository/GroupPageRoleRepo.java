package com.airconsole.wm_cms.model.repository;

import com.airconsole.wm_cms.model.entities.GroupPageRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPageRoleRepo extends JpaRepository<GroupPageRoleEntity, Long> {
}
