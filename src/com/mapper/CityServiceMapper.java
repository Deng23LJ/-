package com.mapper;

import com.entity.Bike;
import com.entity.CarViolation;
import com.entity.Insurances;

import java.util.List;
import java.util.Map;

public interface CityServiceMapper {

    List<Bike> show () throws Exception;

    void insure(Insurances insurances) throws Exception;

    List<CarViolation> violation() throws Exception;

    List<Insurances> showInsurance() throws Exception;

    void ride(Map<String,Object> map) throws Exception;

    void returnBike(Map<String, Object> map) throws Exception;

    void quitInsurance(Map<String, Object> map) throws Exception;

    void continueInsurance(Map<String, Object> map) throws Exception;
}
