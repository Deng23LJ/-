package com.service.imp;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
