package com.shadou.learn_spring_aop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut - When>
    @Before("execution(* com.shadou.learn_spring_aop.aop.business.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        // Logic - What?
        logger.info("Before aspect - Method is called - {}", joinPoint);
    }





}
