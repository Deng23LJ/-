package com.service.imp;

import com.entity.*;
import com.mapper.GerenfuwuMapper;
import com.service.GerenfuwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GerenfuwuServiceImpl implements GerenfuwuService {

    @Autowired
    private GerenfuwuMapper gerenfuwuMapper;


    @Override
    public int dealAffairs(PersonAffairs personAffairs) throws Exception {
        try{
            gerenfuwuMapper.dealAffairs(personAffairs);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Affairs> affairsShow(String type) throws Exception {
        return gerenfuwuMapper.affairsShow(type);
    }
}
