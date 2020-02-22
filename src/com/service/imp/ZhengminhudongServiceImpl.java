package com.service.imp;

import com.entity.JsonResult;
import com.mapper.ZhengminhudongMapper;
import com.service.ZhengminhudongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class ZhengminhudongServiceImpl implements ZhengminhudongService {

    @Autowired
    private ZhengminhudongMapper zhengminhudongMapper;

    @Override
    public void suggestion(String username,String content) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("content", content);
        map.put("username", username);
        zhengminhudongMapper.suggestion(map);
    }

    @Override
    public void complaint(String username, String content) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("content", content);
        map.put("username", username);
        zhengminhudongMapper.complaint(map);
    }
}
