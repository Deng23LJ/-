package com.controller;


import com.entity.News;
import com.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;
    //首页新闻展示方法
    @RequestMapping("/HomeNewsDisplay.do")
    public List<News> displayNews(String type){
//        System.out.println(type);
        List<News> newsList = homeService.displayNews(type);
//        System.out.println(newsList);

        return newsList;
    }




}
