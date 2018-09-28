package com.ssm.service;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(long id) {
        return this.userDao.getUserById(id);
    }

    public HashMap<String,Object> getUsersByPage(HashMap<String, Object> map) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<User> users = this.userDao.getUsersByPage(map);
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String format = df.format(user.getBorn());
            user.setBornStr(format);
        }
        int totalCount = this.getTotalCount();
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", users);
        result.put("totalCount", totalCount);
        return result;
    }

    public Integer getTotalCount() {
        return this.userDao.getTotalCount();
    }

    @Override
    @Transactional
    public Map createUser(User user) {
        userDao.createUser(user);
        Long id = user.getId();
        Map resultMap = new HashMap();
        resultMap.put("id", id);
        resultMap.put("result", id > 0);
        return resultMap;
    }

    @Override
    @Transactional
    public Map updateUser(User user) {
        Boolean bool = userDao.updateUser(user);
        Map resultMap = new HashMap();
        resultMap.put("result", bool);
        return resultMap;
    }

    @Override
    @Transactional
    public Map deleteUserById(long id) {
        Boolean bool = userDao.deleteUserById(id);
        Map resultMap = new HashMap();
        resultMap.put("result", bool);
        return resultMap;
    }

    public HashMap<String,Object> searchUsers(String value) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        List<User> users = this.userDao.searchUsers(value);
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user);
            String format = df.format(user.getBorn());
            user.setBornStr(format);
        }
        int totalCount = users.size();
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", users);
        result.put("totalCount", totalCount);
        return result;
    }

    public User login(HashMap<String, Object> map) {
        return this.userDao.login(map);
    }
}