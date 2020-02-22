package com.service.imp;

import com.entity.Budongzichan;
import com.entity.Marriage;
import com.entity.Traffic;
import com.entity.Visa;
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
    public List<Visa> huzhaoqianzheng() throws Exception {
        return (gerenfuwuMapper.huzhaoqianzheng());
    }

    @Override
    public List<Budongzichan> budongzichan() throws Exception {
        return (gerenfuwuMapper.budongzichan());
    }

    @Override
    public List<Marriage> marriage() throws Exception {
        return (gerenfuwuMapper.marriage());
    }

    @Override
    public List<Traffic> traffic() throws Exception {
        return (gerenfuwuMapper.traffic());
    }
}
