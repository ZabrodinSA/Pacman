package com.pacman.game;

import com.pacman.protobuf.Map;
import com.pacman.protobuf.Message;
import com.pacman.protobuf.Players;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Game extends Thread {
    public static Map map;
    public static List<PlayerClass> playerClasses;
    public static int moveTimeMS = 100;
    private static long timer = moveTimeMS;
    private static long lastMoveTime;


    public Game() throws FileNotFoundException {
        MapLoader loader = new MapLoader("D:\\Unity\\Pacman\\PacmanServer\\src\\main\\java\\com\\pacman\\game\\pacman_field.txt");
        Game.map = loader.LoadMap();
        Game.playerClasses = new ArrayList<>();
        start();
    }

    public void run () {
        while (true) {
            if (timer >= moveTimeMS) {
                if (playerClasses.size() != 0) MovePlayers();
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
    }

    public static void SendMessage () {
        Message.Builder builderMes = Message.newBuilder();
        Players.Builder builderPlayers = Players.newBuilder();
        for (PlayerClass playerClass: Game.playerClasses) {
            builderPlayers.addPlayers(playerClass.player);
        }
        builderMes.setPlayers(builderPlayers.build());
        builderMes.setMap(Game.map);
        Message message = builderMes.build();
        for (PlayerClass playerClass: Game.playerClasses) {
            playerClass.channel.writeAndFlush(message);
        }
    }
}
