package com.mapper;

import com.entity.News;

import java.util.List;

public interface HomeNewsMapper {
    List<News> displayNews(String type);
}
