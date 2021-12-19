package com.example.news.mapper;

import com.example.news.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//表示是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {
    List<User> queryAllUser();
    User login(String account, String password);
    boolean deleteUser(Integer id);
    boolean updateUser(User user);
    boolean addUser(User user);
    User queryOneUser(Integer id);
//    搜索模糊查询
//    用INSTR关键字进行模糊匹配，功能跟like一样 ,等同于："like '%#{nickname}%'"
//    模糊查询出来不止一条数据
   List<User> queryLikeUser(@Param("nickname") String nickname);
}
