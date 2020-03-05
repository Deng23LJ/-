package com.controller;


import com.alibaba.fastjson.JSONObject;
import com.entity.*;
import com.service.AffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class AffairsController {

    @Autowired
    private AffairsService affairsService;

//    =====================个人事务===============

    //可办理个人服务清单
    @RequestMapping("personAffairsShow.do")
    public List<Affairs> personAffairsShow(String type) throws Exception {
        List<Affairs> personAffairsShowList = affairsService.personAffairsShow(type);
        return personAffairsShowList;
    }

    //用户名展示
    @RequestMapping("usernameShow.do")
    public JSONObject usernameShow(HttpSession session) {
        String username = (String) session.getAttribute("name");
        JSONObject json = new JSONObject();
        json.put("name", username);
        return json;
    }

    //    办理个人服务
    @RequestMapping("personAffairsDeal.do")
    public int personAffairsDeal(HttpSession session, PersonAffairs personAffairs) throws Exception {
        String userName = (String) session.getAttribute("name");
        personAffairs.setUsername(userName);
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String DealDate = date.format(new Date());
        personAffairs.setTransactionDate(DealDate);
        int result = affairsService.personAffairsDeal(personAffairs);
        if (result == 1) {
            return 1;
        } else {
            return 0;
        }
    }


//    ======================法人服务======================

//    可办理法人服务清单

    //    法人服务的办理
    @RequestMapping("CorperateAffairsDeal.do")
    public int CorperateAffairsDeal(CorperateAffairs corperateAffairs) throws Exception {
        int result = affairsService.corperateAffairsDeal(corperateAffairs);
        if (result == 1) {
            return 1;
        } else {
            return 0;
        }
    }

}
