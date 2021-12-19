package com.example.news.service;

import com.example.news.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> queryAllUser();
    User login(String account, String password);
    boolean deleteUser(Integer id);
    boolean updateUser(User user);
    boolean addUser(User user);
    User queryOneUser(Integer id);
    List<User> queryLikeUser(String nickname);
}
