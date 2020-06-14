package com.esapplication.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class Log {
    private final static Logger logger = LoggerFactory.getLogger(Log.class);

    @Pointcut("execution(* com.esapplication.Controller.ArticleController.*(..))")
    public void log() {
    }

    @Pointcut("execution(* com.esapplication.Handle.ExceptionHandle.*(..))")
    public void exceptionlog() {
    }

    @Before("log()")
    public void beforedone(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void aftersuccessreturning(Object object) {
        logger.info("response={}", object.toString());
    }

    @AfterReturning(returning = "object", pointcut = "exceptionlog()")
    public void afterexceptionreturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
