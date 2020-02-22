package com.controller;



import com.service.ZhengminhudongService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;


@RestController
public class ZhengminhudongController {
    @Autowired
    private ZhengminhudongService zhengminhudongService;


    //咨询服务
    public void email(){

        }

    //民众建议
    @RequestMapping("suggestion.do")
    public int suggestion(HttpSession session, String content) throws Exception {
        String username = (String) session.getAttribute("name");
        if (username == null) {
            return 0;
        } else {
            zhengminhudongService.suggestion(username,content);
            return 1;
        }
    }

    //民众投诉
    @RequestMapping("complaint.do")
    public int complaint(HttpSession session, String content) throws Exception {
        String username = (String) session.getAttribute("name");
        if (username == null) {
            return 0;
        } else {
            zhengminhudongService.complaint(username,content);
            return 1;
        }
    }

    }




