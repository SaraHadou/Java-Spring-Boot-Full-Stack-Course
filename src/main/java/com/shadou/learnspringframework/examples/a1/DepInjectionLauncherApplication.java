package com.shadou.learnspringframework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class Dependency01 {

}

@Component
class Dependency02 {

}

@Component
class BusinessClass {

    // 1.  Field Injection
    // @Autowired
    Dependency01 dependency01;
    // @Autowired
    Dependency02 dependency02;

    // 2. Constructor Injection - preferred by Spring Users and exist by default
    // @Autowired
    public BusinessClass(Dependency01 dependency01, Dependency02 dependency02) {
        this.dependency01 = dependency01;
        this.dependency02 = dependency02;
    }

    // 3. Setter Injection
    // @Autowired
    public void setDependency01(Dependency01 dependency01) {
        this.dependency01 = dependency01;
    }
    // @Autowired
    public void setDependency02(Dependency02 dependency02) {
        this.dependency02 = dependency02;
    }

    @Override
    public String toString() {
        return "BusinessInjection{" +
                "dependency01=" + dependency01 +
                ", dependency02=" + dependency02 +
                '}';
    }
}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext(
                             DepInjectionLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).
                    forEach(System.out::println);

            System.out.println(context.getBean(BusinessClass.class));

        }

    }

}
