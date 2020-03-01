package com.service;

import com.entity.User;

public interface UserService {

    User login(String username,String password) throws Exception;
    int regist(User user) throws Exception;
    User usernameCheck(String username) throws Exception;

    User updateResume(String username) throws Exception;

    int update(User user) throws Exception;
}
