package com.example.news.mapper;

import com.example.news.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//表示是一个mybatis的mapper类
@Mapper
@Repository
public interface NewsMapper {
    //    物理删除
    boolean delete(@Param("id") Integer id);
    //    逻辑删除 设置状态为0//需要前端传状态,参数为id，状态修改了实际没有删除数据
    boolean setDelete(Integer id);
    // 回复到数据库
    boolean restore(Integer id);
    //添加可以不用加上时间，即使现在的默认时间，符合当前业务
//也可以用日历组件选择日期，反正我是Date类型，我只是修改了获得值类型，没有修改设置值类型
    boolean insert(News news);

    //    修改
    boolean update(News news);

    //    查询一条新闻
    News selectOne(Integer id);

    //    查询全部新闻?这里传入状态参数可以查有效和无效数据status=1有效，status=0无效，
    //    上面恢复也可以这样做，要那种功能，在接口层直接换成对应的参数
//    前端做好了就算了，再写一个方法
    List<News> select();//后面用分页插件分页

    // 回收站数据   ，就是没有删除的数据，只是改变状态的数据
    List<News> selectRecycling();
//    搜索页面
    List<News> selectNewsName(@Param("author") String author);
//    ECharts图数据,来源数据
    Integer selectNewsCounts(@Param("source")String source);
//    ECharts图饼状图数据,来源数据
    Integer selectNewsCounts1(@Param("title")String title);
}
