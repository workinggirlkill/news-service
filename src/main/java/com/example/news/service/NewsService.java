package com.example.news.service;

import com.example.news.pojo.News;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    //    物理删除
    boolean delete(Integer id);

    //    逻辑删除 设置状态为0//需要前端传状态
    boolean setDelete(Integer id);

    //     恢复
    boolean restore(Integer id);
    boolean insert(News news);

    //    修改
    boolean update(News news);

    //    查询一条新闻
    News selectOne(Integer id);

    //    查询全部新闻
    List<News> select();//后面用分页插件分页

    List<News> findAllUserByPageF(int pageNum, int pageSize);

    PageInfo<News> findAllUserByPageS(int pageNum, int pageSize);

    //    回收站新闻
    List<News> selectRecycling();

    PageInfo<News> findAllRecyclingByPageS(int pageNum, int pageSize);

    List<News> selectNewsName(String author);
    //    搜索过多也要分页
    PageInfo<News> selectNewsNamePage(int pageNum, int pageSize,String author);

    Integer selectNewsCounts(@Param("source")String source);
    Integer selectNewsCounts1(@Param("title")String title);
}
