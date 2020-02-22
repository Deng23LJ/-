package com.controller;


import com.entity.Budongzichan;
import com.entity.Marriage;
import com.entity.Traffic;
import com.entity.Visa;
import com.service.GerenfuwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class GerenfuwuController {

    @Autowired
    private GerenfuwuService gerenfuwuService;

    @RequestMapping("huzhaoqianzheng.do")
    public List<Visa> huzhaoqianzheng() throws Exception {
        List<Visa> huzhaoqianzheng = gerenfuwuService.huzhaoqianzheng();
        return huzhaoqianzheng;
    }

    @RequestMapping("budongzichan.do")
    public List<Budongzichan> budongzichan() throws Exception {
        List<Budongzichan> budongzichan = gerenfuwuService.budongzichan();
        return budongzichan;
    }

    @RequestMapping("marriage.do")
    public List<Marriage> marriage() throws Exception {
        List<Marriage> marriage = gerenfuwuService.marriage();
        return marriage;
    }

    @RequestMapping("traffic.do")
    public List<Traffic> traffic() throws Exception {
        List<Traffic> traffic = gerenfuwuService.traffic();
        return traffic;
    }


    //护照办理







}
