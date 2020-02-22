package com.service;

import com.entity.Budongzichan;
import com.entity.Marriage;
import com.entity.Traffic;
import com.entity.Visa;

import java.util.List;

public interface GerenfuwuService {


    List<Visa> huzhaoqianzheng () throws Exception;

    List<Budongzichan> budongzichan () throws Exception;

    List<Marriage> marriage() throws Exception;

    List<Traffic> traffic() throws Exception;
}
