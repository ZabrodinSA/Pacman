package com.pacman.server;

import com.pacman.game.Game;
import com.pacman.game.MapLoader;
import com.pacman.game.PlayerClass;
import com.pacman.protobuf.Map;
import com.pacman.protobuf.Message;
import com.pacman.protobuf.MoveCommands;
import com.pacman.protobuf.Players;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class MainHandler extends ChannelInboundHandlerAdapter {
    private static List<PlayerClass> playerClasses = new ArrayList<>();
    private static Players players = Players.newBuilder().build();
    private static MapLoader loader = new MapLoader("D:\\Unity\\Pacman\\PacmanServer\\src\\main\\java\\com\\pacman\\game\\pacman_field.txt");
    private static Map map;
    private static Message message = Message.newBuilder().build();
    private Game game = new Game(playerClasses, this);

    static {
        try {
            map = loader.LoadMap();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        PlayerClass player = new PlayerClass(map, ctx.channel().id().asShortText(), ctx.channel());
        playerClasses.add(player);
        UpdatePlayers();
        SendMessage();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MoveCommands commands = (MoveCommands) msg;
        for (int  i = 0; i < players.getPlayersCount(); i++) {
            if (players.getPlayers(i).getID().equals(commands.getID())) {
                playerClasses.get(i).SetDirections(commands.getDirectionsList());
                UpdatePlayers();
                UpdateMap(playerClasses.get(i).map);
            }
        }
//        SendMessage();
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < playerClasses.size(); i++){
            if (playerClasses.get(i).player.getID().equals(ctx.channel().id().asShortText())) {
                playerClasses.remove(i);
            }
        }
        UpdatePlayers();
        SendMessage();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public void SendMessage () {
        Message.Builder builder = Message.newBuilder(message);
        builder.setMap(map);
        builder.setPlayers(players);
        message = builder.build();
        for (int i = 0; i < playerClasses.size(); i++) {
            playerClasses.get(i).channel.writeAndFlush(message);
        }
    }
    public void UpdateMap (Map map) {
        Map.Builder builder = Map.newBuilder(map);
        for (PlayerClass playerClass: playerClasses) {
            playerClass.map = map;
        }
        MainHandler.map = builder.build();
    }
    public void UpdatePlayers () {
        Players.Builder builder = Players.newBuilder();
        for (int i = 0; i < playerClasses.size(); i++) {
            builder.addPlayers( playerClasses.get(i).player);
        }
        MainHandler.players = builder.build();
        Game.playerClasses = playerClasses;
    }
}
