package com.service.imp;

import com.entity.News;
import com.mapper.InformationMapper;
import com.service.InformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public List<News> hotNews(String type,int page,int limit) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return (informationMapper.hotNews(map));
}

    @Override
    public List<News> businessNews(String type,int page,int limit) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return (informationMapper.businessNews(map));
    }

    @Override
    public List<News> socialNews(String type,int page,int limit) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return (informationMapper.socialNews(map));
    }

    @Override
    public int newsCount(String type) throws Exception {
        return (informationMapper.newsCount(type));
    }
}
