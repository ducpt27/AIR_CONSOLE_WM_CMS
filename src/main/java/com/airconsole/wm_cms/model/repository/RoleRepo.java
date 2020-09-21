package com.airconsole.wm_cms.model.repository;

import com.airconsole.wm_cms.model.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RolesEntity, Long> {

}
