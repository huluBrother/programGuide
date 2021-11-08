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

    @RequestMapping("/page/{pg}")
    public String showPage(@PathVariable(value = "pg") String pg){
        System.out.println("请求跳转的页面:" + pg);
        return pg;
    }
}
