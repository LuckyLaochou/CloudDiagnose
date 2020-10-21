package cn.laochou.diagnose.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 这个控制器，主要负责项目的一些页面跳转
 */
@Controller
@RequestMapping("/diagnose")
public class DiagnoseController {

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "index";
    }


    @RequestMapping("/about")
    public String toAbout() {
        return "about";
    }

    @RequestMapping("/service")
    public String toService() {
        return "service";
    }


    @RequestMapping("/appointment")
    public String toAppointment() {
        return "appointment";
    }


    @RequestMapping("/blog")
    public String toBlog() {
        return "blog";
    }

    @RequestMapping("/contact")
    public String toContact() {
        return "contact";
    }

    @RequestMapping("/blog/single")
    public String toBlogSingle() {
        return "singleblog";
    }
}
