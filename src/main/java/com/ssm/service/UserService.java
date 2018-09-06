package com.ssm.service;

import com.ssm.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    public User selectUser(long userId);

    public List<User> selectUsersByPage(HashMap<String,Object> map);

    public Integer getTotalCount();

}