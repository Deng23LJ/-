package com.service.imp;

import com.entity.PersonAffairs;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {



    //进行注入（依赖注入）
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username,String password) throws Exception{
        Map<String ,Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        return (userMapper.login(map));
    }

    @Override
    public int regist(User user) throws Exception {
        try{
            userMapper.regist(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
           return  0;
    }


    @Override
    public User usernameCheck(String username) throws Exception{
      return (userMapper.usernameCheck(username));
    }

    @Override
    public User updateResume(String username) throws Exception {
        return userMapper.updateResume(username);
    }

    @Override
    public int update(User user) throws Exception {
        try {
            userMapper.update(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PersonAffairs> findMyAffair(HttpSession session,int page, int limit) throws Exception {
        String name = (String) session.getAttribute("name");
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        map.put("limit",limit);
        map.put("name",name);
        return userMapper.findMyAffair(map);
    }

    @Override
    public int findMyAffairCount(HttpSession session) throws Exception {
        String name = (String) session.getAttribute("name");
        return userMapper.findMyAffairCount(name);
    }

    @Override
    public void updatePicture(String pictureAddress,String username) throws Exception {
        System.out.println("impl+"+pictureAddress);
        System.out.println("impl+"+username);
        Map<String,Object> map = new HashMap<>();
        map.put("pictureAddress",pictureAddress);
        map.put("username",username);
        userMapper.updatePicture(map);
    }
}
