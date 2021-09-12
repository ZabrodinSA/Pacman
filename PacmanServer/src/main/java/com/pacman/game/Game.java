package com.pacman.game;

import com.pacman.server.MainHandler;

import java.util.List;

public class Game extends Thread {
    public static MainHandler mh;
    public static List<PlayerClass> playerClasses;
    public static int moveTimeMS = 100;
    private static long timer = moveTimeMS;
    private static long lastMoveTime;


    public Game(List<PlayerClass> playerClasses, MainHandler mh) {
        Game.mh = mh;
        Game.playerClasses = playerClasses;
        start();
    }

    public void run () {
        while (true) {
            if (timer >= moveTimeMS) {
//                System.out.println("frame");
                MovePlayers();
                timer = 0;
                lastMoveTime = System.currentTimeMillis();
            } else {
                timer =  System.currentTimeMillis() - lastMoveTime;
            }
        }
    }

    private void MovePlayers () {
         for(PlayerClass playerClass: playerClasses) {
             playerClass.MovePlayer();
        }
        mh.UpdatePlayers();
        mh.SendMessage();
    }
}
