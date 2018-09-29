package com.ssm.controller;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getUserById.json")
    @ResponseBody
    public User getUserById(long id) throws IOException {
        User user = this.userService.getUserById(id);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(user.getBorn());
        user.setBornStr(format);
        return  user;
    }

    @RequestMapping("/getUsersByPage.json")
    @ResponseBody
    public HashMap getUsersByPage(Integer pageNow, Integer pageSize) throws IOException {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("start",(pageNow-1)*pageSize);
        map.put("end", pageSize);
        HashMap<String,Object> result = userService.getUsersByPage(map);
        return  result;
    }

    @RequestMapping(value="/createUser.json", method={RequestMethod.POST})
    @ResponseBody
    public Map createUser(User user) throws IOException {
        Map resultMap = userService.createUser(user);
        return  resultMap;
    }

    @RequestMapping(value="/updateUser.json", method={RequestMethod.POST})
    @ResponseBody
    public Map updateUser(User user) throws IOException {
        Map resultMap = userService.updateUser(user);
        return  resultMap;
    }

    @RequestMapping(value="/deleteUserById.json", method={RequestMethod.GET})
    @ResponseBody
    public Map deleteUserById(Long id) throws IOException {
        Map resultMap = userService.deleteUserById(id);
        return  resultMap;
    }

    @RequestMapping(value="/searchUsers.json", method={RequestMethod.GET})
    @ResponseBody
    public HashMap searchUsers(String value) throws IOException {
        HashMap<String,Object> result = userService.searchUsers(value);
        return  result;
    }

    @RequestMapping(value="/login.json", method={RequestMethod.POST})
    @ResponseBody
    public HashMap login(String uid, String psw) throws IOException {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("uid", uid);
        map.put("psw", psw);
        HashMap<String,Object> map2 = userService.login(map);
        return map2;
    }
}