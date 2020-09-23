package com.airconsole.wm_cms.model.repository;

import com.airconsole.wm_cms.model.entities.GroupUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepo extends JpaRepository<GroupUserEntity, Integer> {
}
