package com.shadou.learnspringframework.examples.f1;

import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


//@Component
@Named
class BusinessClass {
    private DataSource dataSource;

//    @Autowired
    @Inject
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        System.out.println("Setter Injection!");
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}

//@Component
@Named
class DataSource {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext(
                             CdiContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessClass.class).getDataSource());
        }

    }
}
