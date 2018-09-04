package com.ssm.dao;

import com.ssm.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {

    User selectUser(long id);

    List<User> selectUsersByPage(HashMap<String,Object> map);

}