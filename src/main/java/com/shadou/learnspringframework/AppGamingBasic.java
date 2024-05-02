package com.shadou.learnspringframework;

import com.shadou.learnspringframework.game.GameRunner;
import com.shadou.learnspringframework.game.MarioGame;
import com.shadou.learnspringframework.game.PacmanGame;
import com.shadou.learnspringframework.game.SuperContraGame;

public class AppGamingBasic {

    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var pacmanGame = new PacmanGame();
        var superContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(superContraGame);
        gameRunner.run();
    }

    public static class AppGamingSpringBeans {
    }
}
