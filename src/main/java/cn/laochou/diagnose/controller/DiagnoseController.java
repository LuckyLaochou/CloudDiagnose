package cn.laochou.diagnose.controller;


import cn.laochou.diagnose.pojo.Article;
import cn.laochou.diagnose.service.ArticleService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * 这个控制器，主要负责项目的一些页面跳转
 */
@Controller
@RequestMapping("/diagnose")
@Slf4j
public class DiagnoseController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }


    @RequestMapping("/about")
    public String toAbout() {
        return "about";
    }

    @RequestMapping("/hall")
    public String toService() {
        return "hall";
    }


    @RequestMapping("/detail")
    public String toDetail() {
        return "detail";
    }


    @RequestMapping("/appointment")
    public String toAppointment() {
        return "appointment";
    }


    @RequestMapping("/blog")
    public ModelAndView toBlog() {
        ModelAndView modelAndView = new ModelAndView();
        List<Article> articles = articleService.getAllArticle();
        log.info(JSON.toJSONString(articles));
        modelAndView.setViewName("blog");
        modelAndView.addObject("articles", articles);
        return modelAndView;
    }


    @RequestMapping("/publish")
    public String toContact() {
        return "publish";
    }


    @RequestMapping("/my")
    public String toMy() {
        return "my";
    }


    @RequestMapping("/blog/single")
    public String toBlogSingle() {
        return "singleblog";
    }
}
