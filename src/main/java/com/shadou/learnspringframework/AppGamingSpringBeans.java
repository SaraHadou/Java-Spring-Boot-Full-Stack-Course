package com.shadou.learnspringframework;

import com.shadou.learnspringframework.game.GameConsole;
import com.shadou.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGamingSpringBeans {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingConfig.class);
        context.getBean(GameConsole.class).up();
        context.getBean(GameRunner.class).run();

    }
}
