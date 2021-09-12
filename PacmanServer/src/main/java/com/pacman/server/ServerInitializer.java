package com.pacman.server;

import com.pacman.protobuf.MoveCommands;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline ph = ch.pipeline();

        ph.addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
        ph.addLast("protobufDecoder", new ProtobufDecoder(MoveCommands.getDefaultInstance()));
        ph.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
        ph.addLast("protobufEncoder", new ProtobufEncoder());
        ph.addLast("mainHandler", new MainHandler());
    }
}
