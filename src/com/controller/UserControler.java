package com.controller;

import com.entity.JsonResult;
import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class UserControler {

    @Autowired
    private UserService userService;

    //登录操作
    @RequestMapping("/login.do")
    public int login(HttpSession session, String username, String password) throws Exception {
        User login = userService.login(username,password);
        if (login == null) {
            return 0;
        } else {
           session.setAttribute("name", login.getUsername());
           return 1;
        }
    }

    //注册操作
    @RequestMapping("/regist.do")
    public int regist(User user) throws Exception {
        int result = userService.regist(user);
        if (result == 1){
            return 1;
        }else{
            return 0;
        }
    }

    //注册的ajax用户名查询
    @RequestMapping(value = "check.do", produces = {"application/json;charset=UTF-8"})
    public JsonResult check(String username) throws Exception {
        User usernameCheckResult = userService.usernameCheck(username);
        if (usernameCheckResult != null) {
            return new JsonResult(true, "用户名被被占用");
        } else {
            return new JsonResult(false, "用户名有效");
        }

    }

    @RequestMapping(value = "showUsername.do", produces = {"application/text;charset=UTF-8"})
    public String showUsername(HttpSession session) throws IOException {
        String username = (String)session.getAttribute("name");
        if (username == null) {
            return "未登录";
        }else{
            return username;
        }
    }


    //安全管理
    @RequestMapping("updateResume.do")
    public User updateResume(HttpSession session) throws Exception {
        String username = (String) session.getAttribute("name");
        User userResume = userService.updateResume(username);
        return userResume;

    }

    @RequestMapping("update.do")
    public int update(User user) throws Exception {
        int updateResult = userService.update(user);
        return updateResult;

    }
}
