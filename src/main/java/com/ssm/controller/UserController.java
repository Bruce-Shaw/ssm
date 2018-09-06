package com.ssm.controller;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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
    public HashMap selectUsersByPage(Integer pageNow, Integer pageSize) throws IOException {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("start",(pageNow-1)*pageSize);
        map.put("end", pageSize);
        List<User> users = userService.selectUsersByPage(map);
        List<User> list = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for(int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String format = df.format(user.getBorn());
            user.setBornStr(format);
        }
        int totalCount = userService.getTotalCount();
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("data", users);
        result.put("totalCount", totalCount);
        return  result;
    }
}