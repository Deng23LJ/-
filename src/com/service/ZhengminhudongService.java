package com.service;

import com.entity.JsonResult;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.Map;

public interface ZhengminhudongService {


    void suggestion(String username,String content) throws Exception;

    void complaint(String username, String content) throws Exception;
}
