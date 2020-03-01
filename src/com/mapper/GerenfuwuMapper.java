package com.mapper;

import com.entity.*;
import com.sun.org.omg.CORBA.ExcDescriptionSeqHelper;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface GerenfuwuMapper {


    void dealAffairs(PersonAffairs personAffairs) throws Exception;

    List<Affairs> affairsShow(String type) throws Exception;
}
