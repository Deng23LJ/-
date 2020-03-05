package com.service;

import com.entity.Chat;
import com.entity.JsonResult;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.List;
import java.util.Map;

public interface GovernmentAndPeopConversationService {


    void suggestion(String username,String content) throws Exception;

    void complaint(String username, String content) throws Exception;

    List<Chat> question() throws Exception;

    void chat(String time,String send, String receive, String chatContent) throws Exception;
}
