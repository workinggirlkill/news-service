package com.example.news.mapper;

import com.example.news.pojo.NewsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CateGeryMapper {
    List<NewsCategory> selectAll();
//    更具名字选中id
    Integer selectById(@Param("ctaeName") String ctaeName);
//
    boolean addCate(NewsCategory category);
//
    boolean delete (Integer id);
//
    boolean update(NewsCategory category);
// 多了根据选择框选择，查出信息
    NewsCategory check(@Param("id") Integer id);
}
