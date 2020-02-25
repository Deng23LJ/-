package com.service;

import com.entity.Bike;
import com.entity.Bus;
import com.entity.CarViolation;
import com.entity.Insurances;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.List;
import java.util.Map;

public interface CityService {

    List<Bike> show() throws Exception;

    void insure(Insurances insurances) throws Exception;

    List<CarViolation> violation() throws Exception;

    List<Insurances> showInsurance() throws Exception;

    void ride(String exist,int id) throws Exception;

    void returnBike(String exist, int id) throws Exception;

    void quitInsurance(String effective, int id) throws Exception;

    void continueInsurance(int id, String effective, String time) throws Exception;

    Bus searchBus(int busId) throws Exception;

    List<Bus> findAllBus() throws Exception;
}
