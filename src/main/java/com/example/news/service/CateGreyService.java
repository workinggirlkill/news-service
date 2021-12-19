package com.example.news.service;
import com.example.news.mapper.CateGeryMapper;
import com.example.news.pojo.NewsCategory;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface CateGreyService {
    List<NewsCategory> selectAll();
    Integer selectById(String cateName);
    boolean addCate(NewsCategory category);
    //
    boolean delete(Integer id);
    //
    boolean update(NewsCategory category);
    // 多了根据选择框选择，查出信息
    NewsCategory check(@Param("id") Integer id);
    PageInfo<NewsCategory> findAllCateByPageS(int pageNum, int pageSize);
}
