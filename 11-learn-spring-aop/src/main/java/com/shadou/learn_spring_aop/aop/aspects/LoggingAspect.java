package com.shadou.learn_spring_aop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // Pointcut - When?
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.shadou.learn_spring_aop.aop.*.*.*(..))")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        // Logic - What?
        logger.info("Before aspect - {} is called with arguments: {}",
                joinPoint, joinPoint.getArgs());
    }

    @After("execution(* com.shadou.learn_spring_aop.aop.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        // Logic - What?
        logger.info("After aspect - {} has executed ", joinPoint);
    }





}
