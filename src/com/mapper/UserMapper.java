package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    User login(Map<String ,Object> map) throws Exception;

    void regist(User user) throws Exception;

    User usernameCheck(String username) throws Exception;
}
