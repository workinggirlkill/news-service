package com.example.news.service;

import com.example.news.mapper.CateGeryMapper;
import com.example.news.pojo.NewsCategory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateGeryServiceImp implements CateGreyService {
    @Autowired
    private CateGeryMapper cateGeryMapper;

    @Override
    public List<NewsCategory> selectAll() {
        return cateGeryMapper.selectAll();
    }
//    分页
    @Override
    public PageInfo<NewsCategory> findAllCateByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<NewsCategory> categories = cateGeryMapper.selectAll();
//        System.out.println(newsList);
        return new PageInfo<>(categories);
    }

    @Override
    public Integer selectById(String cateName) {
        return cateGeryMapper.selectById(cateName);
    }

    @Override
    public boolean addCate(NewsCategory category) {
        return cateGeryMapper.addCate(category);
    }

    @Override
    public boolean delete(Integer id) {
        return cateGeryMapper.delete(id);
    }

    @Override
    public boolean update(NewsCategory category) {
        return cateGeryMapper.update(category);
    }

    @Override
    public NewsCategory check(Integer id) {
        return cateGeryMapper.check(id);
    }
}
