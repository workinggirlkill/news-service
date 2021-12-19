package com.example.news.service;

import com.example.news.mapper.NewsMapper;
import com.example.news.pojo.News;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImp implements NewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public PageInfo<News> selectNewsNamePage(int pageNum, int pageSize, String author) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsList = newsMapper.selectNewsName(author);
//        System.out.println(newsList);
        return new PageInfo<>(newsList);
    }

    @Override
    public List<News> selectNewsName(String author) {
        return newsMapper.selectNewsName(author);
    }

    @Override
    public boolean delete(Integer id) {
        return newsMapper.delete(id);
    }

    @Override
    public boolean restore(Integer id) {
        return newsMapper.restore(id);
    }

    @Override
    public boolean setDelete(Integer id) {
        return newsMapper.setDelete(id);
    }

    @Override
    public boolean insert(News news) {
        boolean insert = false;
        try {
            insert = newsMapper.insert(news);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("请填写内容");
        }

        return insert;
    }

    @Override
    public boolean update(News news) {
        return newsMapper.update(news);
    }

    @Override
    public News selectOne(Integer id) {
        return newsMapper.selectOne(id);
    }

    @Override
    public List<News> select() {
        return newsMapper.select();
    }

    //分页插件省去了从底层查数据过程，直接从获取所有数据的方法进行操作即可
    @Override
    public List<News> findAllUserByPageF(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return newsMapper.select();
    }

    @Override
    public PageInfo<News> findAllUserByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> newsLists = newsMapper.select();
        return new PageInfo<>(newsLists);
    }

    @Override
    public PageInfo<News> findAllRecyclingByPageS(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> recycling = newsMapper.selectRecycling();
        return new PageInfo<>(recycling);
    }

    @Override
    public List<News> selectRecycling() {
        return newsMapper.selectRecycling();
    }

    @Override
    public Integer selectNewsCounts(String source) {
        return newsMapper.selectNewsCounts(source);
    }

    @Override
    public Integer selectNewsCounts1(String title) {
        return newsMapper.selectNewsCounts1(title);
    }
}
