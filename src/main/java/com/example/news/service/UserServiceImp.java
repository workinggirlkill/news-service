package com.example.news.service;

import com.example.news.mapper.UserMapper;
import com.example.news.pojo.User;
import com.example.news.untils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User login(String account, String password) {
        User user = userMapper.login(account, password);
        try {
            String token = TokenUtil.sign(user);
            user.setToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            if(user==null){
                System.out.println("账号为空");
//           做个响应消息发送到前端去
            }
        }
        return user;
    }

    @Override
    public User queryOneUser(Integer id) {
        return userMapper.queryOneUser(id);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> queryLikeUser(String nickname) {
        return userMapper.queryLikeUser(nickname);
    }

    @Override
    public boolean addUser(User user) {
//        修理账号相同的异常
        boolean b = false;
        try {
            b = userMapper.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
//            异常处理后就不会报错
            System.out.println("出现了相同账号");
        }

        return b;
    }
}
