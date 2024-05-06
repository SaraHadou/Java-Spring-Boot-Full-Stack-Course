package com.shadou.learnspringframework.examples.b1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(
                             RealWorldSpringContextLauncherApplication.class)) {

            System.out.println(context
                    .getBean(BusinessCalculationService.class)
                    .findMax());
        }
    }

}
