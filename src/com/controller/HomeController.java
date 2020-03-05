package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.entity.News;
import com.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;
    //首页新闻展示
    @RequestMapping("homeNewsDisplay.do")
    public JSONObject homeNewsDisplay(String type , @RequestParam(defaultValue="1")int page, @RequestParam(defaultValue="5") int limit) throws Exception {
        String name = new String(type.getBytes("ISO-8859-1"),"UTF-8");
        List<News> newsList = homeService.displayNews(name,page,limit);
        int count = homeService.homeNewsCount(name);
        JSONObject json = new JSONObject() ;
        json.put("data", newsList);
        json.put("count", count);
        json.put("code",0);
        return json;
    }
//    ===========================================





}
