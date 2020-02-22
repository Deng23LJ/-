package com.mapper;

import com.entity.News;

import java.util.List;
import java.util.Map;

public interface InformationMapper {
    List<News> hotNews(Map<String, Object> map) throws Exception;

    List<News> businessNews(String type) throws Exception;

    List<News> socialNews(String type) throws Exception;

    int newsCount(String type) throws Exception;
}
