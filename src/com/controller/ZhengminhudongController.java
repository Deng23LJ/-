package com.controller;


import com.entity.Chat;
import com.service.ZhengminhudongService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;


@RestController
public class ZhengminhudongController {
    @Autowired
    private ZhengminhudongService zhengminhudongService;


    //咨询服务
//    历史记录展示
    @RequestMapping("findAllMessage.do")
    public List<Chat> questionShow(HttpSession session) throws Exception {
        String username = (String) session.getAttribute("name");
        if (username == null) {
            return null;
        } else {
            List<Chat> chatHistory = zhengminhudongService.question();
            return chatHistory;

        }
    }

    //聊天服务
    @RequestMapping("chat.do")
    public int chat(HttpSession session, String receive, String chatContent) throws Exception {
        String send = (String) session.getAttribute("name");
        if (send == null) {
            return 1;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = simpleDateFormat.format(new Date());
            System.out.println(time);
            zhengminhudongService.chat(time, send, receive, chatContent);
            return 0;
        }
    }


    //民众建议
    @RequestMapping("suggestion.do")
    public int suggestion(HttpSession session, String content) throws Exception {
        String username = (String) session.getAttribute("name");
        if (username == null) {
            return 0;
        } else {
            zhengminhudongService.suggestion(username, content);
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
            zhengminhudongService.complaint(username, content);
            return 1;
        }
    }

}




