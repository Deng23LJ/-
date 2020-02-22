package com.service.imp;

import com.entity.News;
import com.mapper.HomeNewsMapper;
import com.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeNewsMapper homeNewsMapper;

    @Override
    public List<News> displayNews(String type) {
        return homeNewsMapper.displayNews(type);
    }
}
