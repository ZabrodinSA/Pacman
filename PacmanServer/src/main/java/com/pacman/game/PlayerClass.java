package com.pacman.game;

import com.pacman.protobuf.*;
import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerClass {
    public Channel channel;
//    public Map map;
    public Player player;
    private List<MoveDirection> directions = new ArrayList<>();


    public PlayerClass (String ID,  Channel channel) {
//        this.map = map;
        this.channel = channel;
        Player.Builder playerBuilder = Player.newBuilder();
        playerBuilder.setID(ID);
        playerBuilder.setMoveTimeMS(Game.moveTimeMS);
        playerBuilder.setDirection(MoveDirection.NON);
        Random random = new Random();
        int randomInt = random.nextInt(3);
        switch (randomInt) {
            case (0):
                playerBuilder.setPosX(1);
                playerBuilder.setPosY(1);
                break;
            case (1):
                playerBuilder.setPosX(1);
                playerBuilder.setPosY(Game.map.getSizeY() - 2);
                break;
            case (2):
                playerBuilder.setPosX(Game.map.getSizeX() - 2);
                playerBuilder.setPosY(Game.map.getSizeY() - 2);
                break;
            case (3):
                playerBuilder.setPosX(Game.map.getSizeX() - 2);
                playerBuilder.setPosY(1);
                break;
        }
        player = playerBuilder.build();
    }

    public void SetDirections (List<MoveDirection> directions) {
        this.directions = directions;
        SetDirection ();
    }

    private void SetDirection () {
        MoveDirection direction = null;
        for (int i = 0; i < directions.size(); i++) {
            switch (directions.get(i)) {
                case UP:
                    direction = CheckPos(player.getPosX(), player.getPosY() + 1)?MoveDirection.UP:null;
                    break;
                case  DOWN:
                    direction = CheckPos(player.getPosX(), player.getPosY() - 1)?MoveDirection.DOWN:null;
                    break;
                case LEFT:
                    direction = CheckPos(player.getPosX() - 1, player.getPosY())?MoveDirection.LEFT:null;
                    break;
                case RIGHT:
                    direction = CheckPos(player.getPosX() + 1, player.getPosY())?MoveDirection.RIGHT:null;
                    break;
            }
            if (direction != null)  {
                break;
            }
        }
        Player.Builder builder = Player.newBuilder(player);
        if (direction == null) {
            builder.setDirection(MoveDirection.NON);
        } else {
            builder.setDirection(direction);
        }
        player = builder.build();
    }

    private boolean CheckPos (int x, int y) {
        int indexNew = x * Game.map.getSizeY() + y;
        if (Game.map.getCells(indexNew).getState() == Map.CellState.WALL) {
            return false;
        } else {
            return  true;
        }
    }

    public void MovePlayer () {
        switch (player.getDirection()) {
            case UP:
                SetPos(player.getPosX(), player.getPosY() + 1);
                break;
            case  DOWN:
                SetPos(player.getPosX(), player.getPosY() - 1);
                break;
            case LEFT:
                SetPos(player.getPosX() - 1, player.getPosY());
                break;
            case RIGHT:
                SetPos(player.getPosX() + 1, player.getPosY());
                break;
            case NON:
                break;
        }
    }

    private void SetPos (int x, int y) {
        int indexNew = x * Game.map.getSizeY() + y;
        int indexOld = player.getPosX() * Game.map.getSizeY()+ player.getPosY();

        if (x >= Game.map.getSizeX() || y >= Game.map.getSizeY()) {
            System.out.println("Невозможно разместить игрока за пределами поля");
        } else if (Game.map.getCells(indexNew).getState() == Map.CellState.WALL) {
           SetDirection();
        } else {
            Map.Builder mapBuilder = Map.newBuilder(Game.map);
            Player.Builder playerBuilder = Player.newBuilder(player);
            Map.Cell.Builder cellBuilder = Map.Cell.newBuilder();

            cellBuilder.setState(Map.CellState.EMPTY);
            mapBuilder.setCells(indexOld, cellBuilder.build());

            playerBuilder.setPosX(x);
            playerBuilder.setPosY(y);

            player = playerBuilder.build();
            Game.map = mapBuilder.build();
            Game.SendMessage();
        }
    }
}


