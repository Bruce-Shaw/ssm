package com.ssm.service;

import com.ssm.dao.UserDao;
import com.ssm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
        List<User> users2 = new ArrayList();
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if(!user.getLevel().equals(0)) {
                String format = df.format(user.getBorn());
                user.setBornStr(format);
                users2.add(user);
            }
        }
        int totalCount = this.getTotalCount();
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", users2);
        result.put("totalCount", totalCount);
        return result;
    }

    public Integer getTotalCount() {
        return this.userDao.getTotalCount() - 1;
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

    public HashMap<String,Object> login(HashMap<String, Object> map) {
        User user = this.userDao.login(map);
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", user);
        result.put("result", user != null);
        return result;
    }
}