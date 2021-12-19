package com.example.news.control;

import com.example.news.pojo.Message;
import com.example.news.pojo.User;
import com.example.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jirong")//主连接localhost:8001/jirong
public class userControl {
    @Autowired
    private UserService userService;

    @GetMapping("/user/list")//用户localhost:8001/jirong/user/*
    public List<Object> userList(HttpServletResponse httpServletResponse) {
        int status = httpServletResponse.getStatus();
        ArrayList<Object> list = new ArrayList<>();
//        list.size()集合中元素的个数
        List<User> users = userService.queryAllUser();
        list.add(users);
        if (status == 200) {
            com.example.news.pojo.Message message = new Message(200, "获取成功");
            list.add(message);
        }
        return list;
    }

    //登陆页面测试只能用get请求，没有post表单
    @PostMapping("/login/{account}/{password}")
//    @GetMapping("/login/{account}/{password}")
    public User login(@PathVariable("account") String account, @PathVariable("password") String password) {
//        这里可以上传一个session,方便判断登录状态，后期用token;
        return userService.login(account, password);
    }

    @PostMapping("/user/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/One/{id}")
    public User queryOneUser(@PathVariable("id") Integer id) {
        return userService.queryOneUser(id);
    }

    @PostMapping("/user/update")
    public boolean update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    //    差点上当。。。
    @DeleteMapping("/user/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
//        根据参数修改
        return userService.deleteUser(id);
    }

    //    查询数据这里可能调错方法了,一直查不到，算了重写
    @GetMapping("/userLike/{nickname}")
    public List<User> selectById(@PathVariable("nickname") String nickname) {
//        userService.queryLikeUser('%'+nickname+'%')拼接查询
        return userService.queryLikeUser(nickname);
    }
}
