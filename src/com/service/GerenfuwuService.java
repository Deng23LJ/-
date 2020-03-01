package com.service;

import com.entity.*;

import java.util.List;

public interface GerenfuwuService {

    int dealAffairs(PersonAffairs personAffairs) throws Exception;

    List<Affairs> affairsShow(String type) throws Exception;
}
