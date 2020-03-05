package com.mapper;

import com.entity.*;
import com.sun.org.omg.CORBA.ExcDescriptionSeqHelper;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface AffairsMapper {


    void personAffairsDeal(PersonAffairs personAffairs) throws Exception;

    List<Affairs> personAffairsShow(String type) throws Exception;

    void corperateAffairsDeal(CorperateAffairs corperateAffairs)  throws Exception;
}
