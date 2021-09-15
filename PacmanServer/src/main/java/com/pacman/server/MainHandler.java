package com.pacman.server;

import com.pacman.game.Game;
import com.pacman.game.PlayerClass;
import com.pacman.protobuf.MoveCommands;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class MainHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        PlayerClass player = new PlayerClass(ctx.channel().id().asShortText(), ctx.channel());
        Game.playerClasses.add(player);
        Game.SendMessage();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        MoveCommands commands = (MoveCommands) msg;
        for (int  i = 0; i < Game.playerClasses.size(); i++) {
            if (Game.playerClasses.get(i).player.getID().equals(commands.getID())) {
                Game.playerClasses.get(i).SetDirections(commands.getDirectionsList());
            }
        }
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < Game.playerClasses.size(); i++){
            if (Game.playerClasses.get(i).player.getID().equals(ctx.channel().id().asShortText())) {
                Game.playerClasses.remove(i);
            }
        }
        Game.SendMessage();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }


}
