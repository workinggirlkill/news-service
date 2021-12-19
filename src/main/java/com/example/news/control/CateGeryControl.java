package com.example.news.control;
import com.example.news.pojo.NewsCategory;
import com.example.news.service.CateGreyService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jirong")
public class CateGeryControl {
    @Autowired
    private CateGreyService cateGreyService;

    @GetMapping("/cateGery")
    public List<NewsCategory> categories() {
        return cateGreyService.selectAll();
    }

    @GetMapping("/cateGery/{cateName}")
    public Integer selectById(@PathVariable("cateName") String cateName) {
        return cateGreyService.selectById(cateName);
    }

    @PostMapping("/cate/add")
    public boolean addCate(@RequestBody NewsCategory category) {
        return cateGreyService.addCate(category);
    }

    @DeleteMapping("/cate/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id) {
        return cateGreyService.delete(id);
    }

    @PostMapping("/cate/update")
    public boolean update(@RequestBody NewsCategory category) {
        return cateGreyService.update(category);
    }

    // 多了根据选择框选择，查出信息
    @GetMapping("/cate/check/{id}")
    public NewsCategory check(@PathVariable("id") Integer id ) {
        return cateGreyService.check(id);
    }
//这种没有拿到数据,前端解析错了
    @GetMapping("/cate/pageList")
    public PageInfo<NewsCategory> findAllCateByPageS(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return cateGreyService.findAllCateByPageS(pageNum, pageSize);
    }
    @GetMapping("/cate/pageList1/{pageNum}/{pageSize}")
    public PageInfo<NewsCategory> findAllCateByPageS1(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return cateGreyService.findAllCateByPageS(pageNum, pageSize);
    }

}
