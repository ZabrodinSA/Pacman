package com.pacman.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class ServerApp {
     public  static  void  main (String[] args) {
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


