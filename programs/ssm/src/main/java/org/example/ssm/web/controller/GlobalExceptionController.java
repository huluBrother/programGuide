package org.example.ssm.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({org.example.ssm.exception.UserNotFoundException.class})
    public String userNotFoundExceptionHandler(Exception e, Model model){
        //e.printStackTrace();
        System.out.println("我想证明一下,其实userNotFoundExceptionHandler方法执行了 exceptionHandler,异常正常抓到，但是....");
        model.addAttribute("msg",e.getMessage());
        return "login";
    }

    @ExceptionHandler({java.lang.Exception.class})
    public String exceptionHandler(Exception e){
        //e.printStackTrace();
        System.out.println("我想证明一下,其实方法执行了 exceptionHandler,异常正常抓到，但是....");
        return "redirect:/page/error";
    }
}
