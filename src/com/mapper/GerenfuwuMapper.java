package com.mapper;

import com.entity.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface GerenfuwuMapper {

    List<Budongzichan> budongzichan() throws Exception;

    List<Visa> huzhaoqianzheng() throws Exception;

    List<Marriage> marriage() throws Exception;

    List<Traffic> traffic() throws Exception;

    void applyVisa(PersonAffairs personAffairs) throws Exception;
}
