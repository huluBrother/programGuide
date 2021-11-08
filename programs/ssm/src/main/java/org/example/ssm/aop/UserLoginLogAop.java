package org.example.ssm.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.example.ssm.mapper.LogsMapper;
import org.example.ssm.pojo.Logs;
import org.example.ssm.pojo.UsersExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class UserLoginLogAop {

    @Autowired
    private LogsMapper logsMapper;


    /**
     * 配置切点
     */
    @Pointcut("execution(* org.example.ssm.service.UsersService.userLogin(..))")
    public void myPointcut(){
    }

    /**
     * 在后置通知中记录登录日志
     */
    @AfterReturning("myPointcut()")
    public void userLoginLog(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        UsersExt users = (UsersExt)objects[0];
        Logs logs = new Logs();
        logs.setLogtime(new Date());
        logs.setUsername(users.getUsername());
        logs.setIp(users.getIp());
        this.logsMapper.insertSelective(logs);
    }

}
