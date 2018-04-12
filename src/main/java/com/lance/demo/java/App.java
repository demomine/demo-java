package com.lance.demo.java;

import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by perdonare on 2017/5/27.
 */
public class App {
    public static void main(String[] args) throws Exception{
        //1.创建SocketChannel
        SocketChannel socketChannel=SocketChannel.open();
        //2.连接服务器
        socketChannel.connect(new InetSocketAddress("192.168.4.228",1055));

        //写数据
        String msg="我是客户端~";
        ByteBuffer buffer= ByteBuffer.allocate(1024);
        buffer.put(msg.getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        socketChannel.shutdownOutput();

        //读数据
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len = 0;
        while (true) {
            buffer.clear();
            len = socketChannel.read(buffer);
            if (len == -1)
                break;
            buffer.flip();
            while (buffer.hasRemaining()) {
                bos.write(buffer.get());
            }
        }

        System.out.println("客户端收到:"+new String(bos.toByteArray()));

        socketChannel.close();
    }
}
