package com.ssm.controller;

import com.ssm.entity.User;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getUserById.do")
    @ResponseBody
    public User getUserById(long id) throws IOException {
        User user = this.userService.getUserById(id);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String format = df.format(user.getBorn());
        user.setBornStr(format);
        return  user;
    }

    @RequestMapping("/getUsersByPage.do")
    @ResponseBody
    public HashMap getUsersByPage(Integer pageNow, Integer pageSize) throws IOException {
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("start",(pageNow-1)*pageSize);
        map.put("end", pageSize);
        HashMap<String,Object> result = userService.getUsersByPage(map);
        return  result;
    }

    @RequestMapping(value="/createUser.do", method={RequestMethod.POST})
    @ResponseBody
    public Map createUser(User user) throws IOException {
        Map resultMap = userService.createUser(user);
        return  resultMap;
    }
}