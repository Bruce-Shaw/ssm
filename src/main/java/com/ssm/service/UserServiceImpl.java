package com.ssm.service;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    public List<User> selectUsersByPage(HashMap<String,Object> map) {
        return this.userDao.selectUsersByPage(map);
    }

    public Integer getTotalCount() {
        return this.userDao.getTotalCount();
    }
}