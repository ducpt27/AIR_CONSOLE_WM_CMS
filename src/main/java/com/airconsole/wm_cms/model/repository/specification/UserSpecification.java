package com.airconsole.wm_cms.model.repository.specification;

import com.airconsole.wm_cms.model.entities.User;
import com.airconsole.wm_cms.model.entities.User_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

public final class UserSpecification {

    public static Specification<User> hasUsername(String username) {
        return (root, query, cb) -> cb.equal(root.get(User_.username), username);
    }

    public static Specification<User> hasId(int userId) {
        return (root, query, cb) -> cb.equal(root.get(User_.id), userId);
    }

    public static Specification<User> hasIdIn(Collection<Integer> userIds) {
        return (root, query, cb) -> root.get(User_.id).in(userIds);
    }
}