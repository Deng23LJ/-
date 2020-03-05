package com.service;

import com.entity.*;

import java.util.List;

public interface AffairsService {

    int personAffairsDeal(PersonAffairs personAffairs) throws Exception;

    List<Affairs> personAffairsShow(String type) throws Exception;

    int corperateAffairsDeal(CorperateAffairs corperateAffairs) throws Exception;
}
