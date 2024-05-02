package com.shadou.learnspringframework;

import com.shadou.learnspringframework.game.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfig {

    @Bean
    public GameConsole game() {
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunner(GameConsole game) {
        return new GameRunner(game);
    }

}
