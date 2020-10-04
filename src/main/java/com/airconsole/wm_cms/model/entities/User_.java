package com.airconsole.wm_cms.model.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;

@StaticMetamodel(User.class)
public abstract class User_ {
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<Group, Integer> groupUsersById;
    public static volatile SingularAttribute<User, Byte> isAdmin;

    public static volatile SingularAttribute<User, String> createBy;
    public static volatile SingularAttribute<User, String> updateBy;
    public static volatile SingularAttribute<User, Timestamp> createAt;
    public static volatile SingularAttribute<User, Timestamp> updateAt;

}
