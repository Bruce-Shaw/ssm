package com.ssm.dao;

import com.ssm.entity.User;

public interface UserDao {

    User selectUser(long id);

}