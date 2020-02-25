package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.entity.News;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ZixunzhuantiController {
    @Autowired
    private InformationService informationService;

    //热门资讯
    @RequestMapping("hotNews.do")
    public Map<String,Object> hotNews(String type , @RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="5") int limit) throws Exception {
        String name = new String(type.getBytes("ISO-8859-1"),"UTF-8");
        List<News> newsList = informationService.hotNews(name,page,limit);
        int count = informationService.newsCount(name);
        Map<String,Object> map=new HashMap<>();		//装填回调数据
        map.put("code", 0);
        map.put("msg", "随便写啥");
        map.put("count", count);//获得数据的总数
        map.put("data", newsList);//本次分页查询的数据
        return map;
    }


    @RequestMapping("businessNews.do")
    public JSONObject businessNews(String type,int page,int limit) throws Exception {
        String name = new String(type.getBytes("ISO-8859-1"),"UTF-8");
        List<News> newsList = informationService.businessNews(name,page,limit);
        int count = informationService.newsCount(name);
        JSONObject json = new JSONObject() ;
        json.put("data", newsList);
        json.put("count", count);
        json.put("code",0);
        return json;

    }

    @RequestMapping("socialNews.do")
    public JSONObject socialNews(String type, int page, int limit) throws Exception {
        String name = new String(type.getBytes("ISO-8859-1"),"UTF-8");
        List<News> newsList = informationService.socialNews(name,page,limit);
        int count = informationService.newsCount(name);
        JSONObject json = new JSONObject();
        json.put("data", newsList);
        json.put("count", count);
        json.put("code",0);
        return json;

    }
}
