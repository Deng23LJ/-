package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.JsonResult;
import com.entity.PersonAffairs;
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
import java.util.List;

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
           session.setAttribute("picture",login.getPicture());
           return 1;
        }
    }

    //退出登录
    @RequestMapping("exit.do")
    public String exit(HttpSession session){
       try {
           session.removeAttribute("name");
           return "退出成功！";

       }catch (Exception e){
           e.printStackTrace();
       }
           return "退出失败！";
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

    @RequestMapping("showUsername.do")
    public JSONObject showUsername(HttpSession session) throws IOException {
        String username = (String)session.getAttribute("name");
        String picture = (String)session.getAttribute("picture");
        JSONObject json = new JSONObject();
        json.put("name",username);
        json.put("picture",picture);
        return json;
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

    //用户办理事务展示
    @RequestMapping("findMyAffair.do")
    public JSONObject findMyAffair(HttpSession session,int page,int limit) throws Exception{
        List<PersonAffairs> personAffairsList = userService.findMyAffair(session,page,limit);
        int count = userService.findMyAffairCount(session);
        JSONObject json = new JSONObject();
        json.put("code",0);
        json.put("msg","我的事务");
        json.put("count",count);
        json.put("data",personAffairsList);
        return json;
    }
}
