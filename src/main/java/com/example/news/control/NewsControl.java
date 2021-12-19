package com.example.news.control;

import com.example.news.pojo.Message;
import com.example.news.pojo.News;
import com.example.news.service.NewsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jirong")
public class NewsControl {
    @Autowired
    private NewsService newsService;

    //    @GetMapping("/news/newsList")
//    public List<News> newsList() {
//        return newsService.select();
//    }
    @GetMapping("/news/newsList")
    public List<Object> newsList(HttpServletResponse httpServletResponse) {
        int status = httpServletResponse.getStatus();
//        响应的状态码
//        相当于一个容器往里放数据
        ArrayList<Object> list = new ArrayList<>();
        List<News> newsList = newsService.select();
        list.add(newsList);//建立一个放很多数据的容器list，就直接拿，不用map
//        查到的状态码、,可以去数据库取值，添加到这个集合，这里省代码就算了，直接建一个类
        if (status == 200) {
            Message message = new Message(200, "获取成功");
            list.add(message);
        }
        return list;
    }

    @GetMapping("/news/listPage/{pageNum}/{pageSize}")
    public List<News> newsListPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return newsService.findAllUserByPageF(pageNum, pageSize);
    }

    @GetMapping("/news/listInfo/{pageNum}/{pageSize}")
    public PageInfo<News> newsListInfo(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return newsService.findAllUserByPageS(pageNum, pageSize);
    }

    //    回收站数据
    @GetMapping("/news/recyclingList")
    public List<News> recyclingList() {
        return newsService.selectRecycling();
    }

    @GetMapping("/news/recyclingInfo/{pageNum}/{pageSize}")
    public PageInfo<News> recyclingInfo(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return newsService.findAllRecyclingByPageS(pageNum, pageSize);
    }

    //分页可以重新写个接口，与获取列表分开
    @GetMapping("/news/one/{id}")//restFUL风格,还可以请求参数
    public News oneNew(@PathVariable("id") Integer id) {
        return newsService.selectOne(id);
    }

    @GetMapping("/news/delete/{id}")
    public boolean deleteNew(@PathVariable("id") Integer id) {
        return newsService.setDelete(id);
    }

    //    物理删除
    @DeleteMapping("/news/deletePhysical/{id}")
    public boolean deletePhysical(@PathVariable("id") Integer id) {
        return newsService.delete(id);
    }

    //    恢复数据
    @GetMapping("/news/restore/{id}")
    public boolean restore(@PathVariable("id") Integer id) {
        return newsService.restore(id);
    }

    @PostMapping("/news/update")
    public boolean updateNews(@RequestBody News news) {
        return newsService.update(news);
    }
//写个方法只修改状态

    //    @GetMapping("/news/add")
//   接口正确，参数正确，结果死活不成功，就是没转换成请求的json数据@RequestBody 浪费30分钟草
    @PostMapping("/news/add")
    public boolean insertNews(@RequestBody News news) {
//        1.接口先成功，再写前端
//        走这个类就必须每个字段都有才能添加成功
//        有默认值的不知道，可不可以只添加一些字段
//        必须要每个字段的话我就用map类型来添加数据
//        mybatis功能还可以，按照自己的数据库编写的字段,在实体类找到，然后添加，有默认值的一般不做修改
//        News news1 = new News(24,10,"社会","122","122",new Date(),"12333",5,1);
        return newsService.insert(news);
    }

    //    搜索一定要仔细啊,就因为对应类没写还，又浪费20分钟，要看每一个对应好了没
    @GetMapping("/newsLike/{author}")
    public List<News> selectNewsName(@PathVariable("author") String author) {
        return newsService.selectNewsName(author);
    }

    //    同一个类型的值，用类，字段少的用restFul风格，字段多的用请求参数吧
    //    下次开发用日志功能吧,又一个拼装报错
    @GetMapping("/newsLike")
    public PageInfo<News> selectNewsNamePage(@RequestParam("author") String author, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return newsService.selectNewsNamePage(pageNum, pageSize, author);
    }

    //%E5%86%B0%E5%86%B0前端传的参数乱码了
//    @SneakyThrows
    @GetMapping("/newsLike1/{author}/{pageNum}/{pageSize}")
    public PageInfo<News> selectNewsNamePage1(@PathVariable("author") String author, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
//        调错借口了，无语,调用上面去了
        return newsService.selectNewsNamePage(pageNum, pageSize, author);
    }

    @GetMapping("/news/count/{source}")
    public Integer selectNewsCounts(@PathVariable("source") String source) {
        return newsService.selectNewsCounts(source);
    }
    @GetMapping("/news/count1/{title}")
    public Integer selectNewsCounts1(@PathVariable("title") String title) {
        return newsService.selectNewsCounts1(title);
    }
}
