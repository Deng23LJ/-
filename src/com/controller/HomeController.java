package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.entity.News;
import com.service.HomeService;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    //首页新闻展示
    @RequestMapping("homeNewsDisplay.do")
    public JSONObject homeNewsDisplay(String type, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) throws Exception {
        String name = new String(type.getBytes("ISO-8859-1"), "UTF-8");
        List<News> newsList = homeService.displayNews(name, page, limit);
        int count = homeService.homeNewsCount(name);
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg","");
        json.put("count", count);
        json.put("data", newsList);
        return json;
    }


   @RequestMapping( "findNewsDetail.do")
    public News findNewsDetail(int id) throws Exception {
        News newsList =  homeService.findNewsDetail(id);
        return newsList;
   }

}
