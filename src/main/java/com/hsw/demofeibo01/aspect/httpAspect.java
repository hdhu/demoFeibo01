package com.hsw.demofeibo01.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class httpAspect {

    private final static org.slf4j.Logger LOGGER=  LoggerFactory.getLogger(httpAspect.class);

//    @Before("execution(public * com.boot.demo02.controller.helloController.stuAdd(..))")
    @Pointcut("execution(public * com.hsw.demofeibo01.controller.helloController.*(..))")
    public void log(){
    }
    @Pointcut("execution(public * com.hsw.demofeibo01.controller.UserController.*(..))")
    public void log1(){
    }
    @Pointcut("execution(public * com.hsw.demofeibo01.controller.demoController.*(..))")
    public void demo(){}

    @Before("log1()")
    public void dobefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        LOGGER.info("URL={}",request.getRequestURL());
        LOGGER.info("method={}",request.getMethod());
        LOGGER.info("ip={}",request.getRemoteAddr());
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        LOGGER.info("args={}",joinPoint.getArgs());
        LOGGER.info("SADASD={}",joinPoint.getArgs(),joinPoint.getArgs(),joinPoint.getArgs());
        System.out.println("21423543244");
        LOGGER.info("sadsa");
    }

    @After("log1()")
    public void after(){
        System.out.println("zuihou" );
        LOGGER.info("fsafsff");
    }
    @AfterReturning(returning ="obeject",pointcut = "log1()")
    public void afterReturning(Object obeject){
      LOGGER.info("response={}",obeject.toString());
    }
}
