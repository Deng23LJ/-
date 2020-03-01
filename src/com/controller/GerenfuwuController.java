package com.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.*;
import com.service.GerenfuwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class GerenfuwuController {

    @Autowired
    private GerenfuwuService gerenfuwuService;


    //    用户名展示
    @RequestMapping("visaName.do")
    public JSONObject visaUserName(HttpSession session) {
        String userName = (String) session.getAttribute("name");
        JSONObject json = new JSONObject();
        json.put("name", userName);
        return json;
    }

    //护照办理
    @RequestMapping("dealAffairs.do")
    public int dealAffairs(HttpSession session, PersonAffairs personAffairs) throws Exception {
        String userName = (String) session.getAttribute("name");
        personAffairs.setUsername(userName);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String DealDate = date.format(new Date());
        personAffairs.setTransactionDate(DealDate);
        int visa = gerenfuwuService.dealAffairs(personAffairs);
        if (visa == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    //事务办理
    @RequestMapping("affairs.do")
    public List<Affairs> affairsShow(String type) throws Exception {
        List<Affairs> affairsList = gerenfuwuService.affairsShow(type);
        return affairsList;
    }




}
