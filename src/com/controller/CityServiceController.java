package com.controller;


import com.entity.Bike;
import com.entity.CarViolation;
import com.entity.Insurances;
import com.entity.JsonResult;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityServiceController {

    @Autowired
    private CityService cityService;

    //自行车展示业务
    @RequestMapping("bikeSharing.do")
    public List<Bike> show() throws Exception{
        List<Bike> showBike = cityService.show();
        return showBike;
    }
    //骑车业务
    @RequestMapping("/ride.do")
    public JsonResult ride(String exist,int id) {
        try {
            cityService.ride(exist,id);
            return new JsonResult(true, "借车成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JsonResult(false, "借车失败");
    }
    //还车业务
    @RequestMapping("/return.do")
    public JsonResult returnBike(String exist,int id) {
        try {
            cityService.returnBike(exist,id);
            return new JsonResult(true,"还车成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult(false,"还车失败");
    }

    //个人保险展示
    @RequestMapping("showInsurance.do")
    public List<Insurances> showInsurance() throws Exception{
        List<Insurances> result = cityService.showInsurance();
        return result;
    }
    //退保服务
    @GetMapping("quitInsurance.do")
    public JsonResult quitInsurance(String effective,int id){
        try{
            cityService.quitInsurance(effective,id);
            return new JsonResult(true,"退保成功！");

        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult(false,"退保失败，请重试");
    }
    //续保服务
    @GetMapping("continueInsurance.do")
    public JsonResult continueInsurance(int id,String effective,String time){
        try {
            cityService.continueInsurance(id,effective,time);
            return new JsonResult(true,"续保成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult(false,"续保失败");

    }
    //办理保险服务
    @RequestMapping("/insure.do")
    public JsonResult insure(Insurances insurances) throws Exception{
        try{
            cityService.insure(insurances);
            return new JsonResult(true,"办理成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JsonResult(false,"办理失败，请重试");
    }
    //汽车违章
    @RequestMapping("vehicleViolation.do")
    public List<CarViolation> violation() throws Exception{
        List<CarViolation> violations = cityService.violation();
        return violations;
    }



}
