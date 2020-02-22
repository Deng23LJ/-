package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.entity.News;
import com.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZixunzhuantiController {
    @Autowired
    private InformationService informationService;

    //热门资讯
    @RequestMapping("hotNews.do")
    public JSONObject hotNews(String type ,int page,int limit) throws Exception {
        System.out.println(type);
        System.out.println(page);
        System.out.println(limit);
//        String name = new String(type.getBytes("ISO-8859-1"),"UTF-8");
        List<News> newsList = informationService.hotNews(type,page,limit);
        int count = informationService.newsCount(type);
        JSONObject json = new JSONObject();
        json.put("data", newsList);
        json.put("total", count);
        json.put("code",0);
        return json;
    }


    @RequestMapping("businessNews.do")
    public List<News> businessNews(String type) throws Exception {
        List<News> newsList = informationService.businessNews(type);
        return newsList;
    }

    @RequestMapping("socialNews.do")
    public List<News> socialNews(String type) throws Exception {
        List<News> newsList = informationService.socialNews(type);
        return newsList;

    }
}
