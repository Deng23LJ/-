package com.service.imp;

import com.entity.Chat;
import com.mapper.GovernmentAndPeopleConversationMapper;
import com.service.GovernmentAndPeopConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class GovernmentAndPeopleConversationServiceImpl implements GovernmentAndPeopConversationService {

    @Autowired
    private GovernmentAndPeopleConversationMapper zhengminhudongMapper;

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

    @Override
    public List<Chat> question() throws Exception {
        return zhengminhudongMapper.question();
    }

    @Override
    public void chat(String time,String send, String receive, String chatContent) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("time",time);
        map.put("send", send);
        map.put("receive", receive);
        map.put("chatContent", chatContent);
        zhengminhudongMapper.chat(map);
    }
}
