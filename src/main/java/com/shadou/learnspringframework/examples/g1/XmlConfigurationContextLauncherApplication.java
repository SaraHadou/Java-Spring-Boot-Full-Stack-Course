package com.shadou.learnspringframework.examples.g1;

import com.shadou.learnspringframework.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


public class XmlConfigurationContextLauncherApplication {
    public static void main(String[] args) {

        try (var context =
                     new ClassPathXmlApplicationContext("/contextConfiguration.xml")) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("game"));
            context.getBean(GameRunner.class).run();

        }

    }
}
