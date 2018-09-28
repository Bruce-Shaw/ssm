package com.ssm.service;

import com.ssm.entity.User;

import java.util.HashMap;
import java.util.Map;

public interface UserService {

    public User getUserById(long id);

    public HashMap<String,Object> getUsersByPage(HashMap<String,Object> map);

    public Integer getTotalCount();

    public Map createUser(User user);

    public Map updateUser(User user);

    public Map deleteUserById(long id);

    public HashMap<String,Object> searchUsers(String value);

    public User login(HashMap<String, Object> map);

}