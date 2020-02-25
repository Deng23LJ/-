package com.service.imp;

import com.entity.News;
import com.mapper.HomeNewsMapper;
import com.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeNewsMapper homeNewsMapper;

    @Override
    public List<News> displayNews(String type, int page, int limit) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("type",type);
        map.put("page",(page-1)*limit);
        map.put("limit",limit);
        return (homeNewsMapper.displayNews(map));
    }

    @Override
    public int homeNewsCount(String type) throws Exception {
        return homeNewsMapper.homeNewsCount(type);
    }
}
