package com.service.imp;

import com.entity.Bike;
import com.entity.CarViolation;
import com.entity.Insurances;
import com.mapper.CityServiceMapper;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityServiceMapper cityServiceMapper;

    @Override
    public List<Bike> show() throws Exception {
        return cityServiceMapper.show();
    }

    @Override
    public void insure(Insurances insurances) throws Exception {
        cityServiceMapper.insure(insurances);
    }

    @Override
    public List<CarViolation> violation() throws Exception {
        return cityServiceMapper.violation();
    }

    @Override
    public List<Insurances> showInsurance() throws Exception {
        return cityServiceMapper.showInsurance();
    }

    @Override
    public void ride(String exist,int id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("exist",exist);
        map.put("id",id);
        cityServiceMapper.ride(map);
    }

    @Override
    public void returnBike(String exist, int id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("exist",exist);
        map.put("id",id);
        cityServiceMapper.returnBike(map);
    }

    @Override
    public void quitInsurance(String effective, int id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("effective",effective);
        map.put("id",id);
        cityServiceMapper.quitInsurance(map);

    }

    @Override
    public void continueInsurance(int id, String effective, String time) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("effective",effective);
        map.put("time",time);
        cityServiceMapper.continueInsurance(map);
    }


}
