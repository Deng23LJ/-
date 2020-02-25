package com.mapper;

import com.entity.News;

import java.util.List;
import java.util.Map;

public interface HomeNewsMapper {
    List<News> displayNews(Map<String, Object> map) throws Exception;

    int homeNewsCount(String type) throws Exception;
}
