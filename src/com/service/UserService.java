package com.service;

import com.entity.User;

public interface UserService {

    User login(String username,String password) throws Exception;
    void regist(User user) throws Exception;
    User usernameCheck(String username) throws Exception;
}
