package com.service;


import com.entity.News;

import java.util.List;

public interface HomeService {
    List<News> displayNews(String name, int page, int limit) throws Exception;

    int homeNewsCount(String type) throws Exception;

    List<News> findTypeNews(String type) throws Exception;

    News findNewsDetail(int id) throws Exception;

    int findCount(String type) throws Exception;
}
