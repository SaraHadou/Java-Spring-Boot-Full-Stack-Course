package com.shadou.learn_spring_aop.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
        logger.info("Before aspect - {} is called with arguments: {}",
                joinPoint, joinPoint.getArgs()); // What ?
    }

    @After("execution(* com.shadou.learn_spring_aop.aop.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After aspect - {} has executed ", joinPoint);
    }

    @AfterThrowing (
            pointcut = "execution(* com.shadou.learn_spring_aop.aop.*.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing aspect - {} has thrown exception {}", joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.shadou.learn_spring_aop.aop.*.*.*(..))",
            returning = "result"
    )
    public void logMethodCallAfterSuccessExecution(JoinPoint joinPoint, Object result) {
        logger.info("AfterReturning aspect - {} has returned {}", joinPoint, result);
    }

}
