package com.service.imp;

import com.entity.*;
import com.mapper.AffairsMapper;
import com.service.AffairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffairsServiceImpl implements AffairsService {

    @Autowired
    private AffairsMapper affairsMapper;


    @Override
    public int personAffairsDeal(PersonAffairs personAffairs) throws Exception {
        try{
            affairsMapper.personAffairsDeal(personAffairs);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Affairs> personAffairsShow(String type) throws Exception {
        return affairsMapper.personAffairsShow(type);
    }

    @Override
    public int corperateAffairsDeal(CorperateAffairs corperateAffairs) throws Exception {

        try{
            affairsMapper.corperateAffairsDeal(corperateAffairs);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
