package com.mapper;

import com.entity.Chat;

import java.util.List;
import java.util.Map;

public interface GovernmentAndPeopleConversationMapper {
    void suggestion(Map<String, Object> map) throws Exception;

    void complaint(Map<String, Object> map) throws Exception;

    List<Chat> question() throws Exception;

    void chat(Map<String, Object> map) throws Exception;
}
