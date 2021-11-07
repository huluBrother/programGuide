package org.example.ssm.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/page/{page}")
    public String showPage(@PathVariable(name = "page") String page){
        System.out.println("请求跳转的页面:" + page);
        return page;
    }
}
