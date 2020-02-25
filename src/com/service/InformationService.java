package com.service;

import com.entity.News;

import java.util.List;


public interface InformationService {
    List<News> hotNews(String type,int page,int limit) throws Exception;

    List<News> businessNews(String type,int page,int limit) throws Exception;

    List<News> socialNews(String type,int page,int limit) throws Exception;

    int newsCount(String type) throws Exception;
}
