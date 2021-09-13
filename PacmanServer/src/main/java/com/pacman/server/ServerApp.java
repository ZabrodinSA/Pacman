package com.pacman.server;

import com.pacman.game.Game;
import com.pacman.protobuf.Players;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.FileNotFoundException;

public class ServerApp {
     public  static  void  main (String[] args) throws FileNotFoundException {
         Players players = Players.newBuilder().build();
         Game game = new Game();

         EventLoopGroup bossGroup = new NioEventLoopGroup(1);
         EventLoopGroup workerGroup = new NioEventLoopGroup();
         try {
             ServerBootstrap b = new ServerBootstrap();
             b.group(bossGroup, workerGroup)
                     .channel(NioServerSocketChannel.class)
                     .childHandler(new ServerInitializer());
             ChannelFuture future = b.bind(8080).sync();
             future.channel().closeFuture().sync();
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             bossGroup.shutdownGracefully();
             workerGroup.shutdownGracefully();
         }
     }
}


