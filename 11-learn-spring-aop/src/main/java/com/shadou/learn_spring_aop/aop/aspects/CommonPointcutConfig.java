package com.shadou.learn_spring_aop.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.shadou.learn_spring_aop.aop.*.*.*(..))")
    public void businessAndDataPackageConfig() {}

    @Pointcut("execution(* com.shadou.learn_spring_aop.aop.business.*.*(..))")
    public void businessPackageConfig() {}

    @Pointcut("execution(* com.shadou.learn_spring_aop.aop.data.*.*(..))")
    public void dataPackageConfig() {}

    @Pointcut("bean(*Service*)")
    public void allPackageConfigUsingBean() {}

    @Pointcut("@annotation(com.shadou.learn_spring_aop.aop.annotations.TrackTime)")
    public void trackTimeAnnotation() {}

}
