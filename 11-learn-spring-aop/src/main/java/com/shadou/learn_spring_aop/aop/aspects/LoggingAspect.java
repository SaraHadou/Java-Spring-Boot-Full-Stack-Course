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
    @Before("com.shadou.learn_spring_aop.aop.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before aspect - {} is called with arguments: {}",
                joinPoint, joinPoint.getArgs()); // Advice - What ?
    }

    @After("com.shadou.learn_spring_aop.aop.aspects.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After aspect - {} has executed ", joinPoint);
    }

    @AfterThrowing (
            pointcut = "com.shadou.learn_spring_aop.aop.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing aspect - {} has thrown exception {}", joinPoint, exception);
    }

    @AfterReturning(
            pointcut = "com.shadou.learn_spring_aop.aop.aspects.CommonPointcutConfig.dataPackageConfig()",
            returning = "result"
    )
    public void logMethodCallAfterSuccessExecution(JoinPoint joinPoint, Object result) {
        logger.info("AfterReturning aspect - {} has returned {}", joinPoint, result);
    }

}
