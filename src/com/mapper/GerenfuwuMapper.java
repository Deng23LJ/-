package com.mapper;

import com.entity.Budongzichan;
import com.entity.Marriage;
import com.entity.Traffic;
import com.entity.Visa;

import java.util.List;

public interface GerenfuwuMapper {

    List<Budongzichan> budongzichan() throws Exception;

    List<Visa> huzhaoqianzheng() throws Exception;

    List<Marriage> marriage() throws Exception;

    List<Traffic> traffic() throws Exception;
}
