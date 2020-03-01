package com.service;

import com.entity.*;

import java.util.List;

public interface GerenfuwuService {


    List<Visa> huzhaoqianzheng () throws Exception;

    List<Budongzichan> budongzichan () throws Exception;

    List<Marriage> marriage() throws Exception;

    List<Traffic> traffic() throws Exception;

    int applyVisa(PersonAffairs personAffairs) throws Exception;
}
