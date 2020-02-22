package com.service;


import com.entity.News;

import java.util.List;

public interface HomeService {
    List<News> displayNews(String type);
}
