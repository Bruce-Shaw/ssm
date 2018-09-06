package com.ssm.dao;

import com.ssm.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    User getUserById(long id);

    List<User> getUsersByPage(HashMap<String,Object> map);

    Integer getTotalCount();

    Long createUser(User user);

    Long updateUser(User user);
}