package com.ssm.controller;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/showUser.do")
    public User selectUser(long userId) throws IOException {
        User user = this.userService.selectUser(userId);
        return  user;
    }

    @RequestMapping("/showUsers.do")
    @ResponseBody
    public List<User> selectUsersByPage(Integer pageNow, Integer pageSize) throws IOException {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("start",(pageNow-1)*pageSize);
        map.put("end", pageSize);
        List<User> users = userService.selectUsersByPage(map);
        return  users;
    }
}