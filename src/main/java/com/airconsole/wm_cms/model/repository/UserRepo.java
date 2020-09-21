package com.airconsole.wm_cms.model.repository;

import com.airconsole.wm_cms.model.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByEmail(String email);

    Optional<UsersEntity> findByUsernameOrEmail(String username, String email);

    List<UsersEntity> findByIdIn(Collection<Long> userIds);

    Optional<UsersEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
