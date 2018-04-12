package com.lance.demo.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResponseProcessor {
    //构造线程池
    private static ExecutorService executorService  = Executors.newFixedThreadPool(10);

    public static void processorResponse(final SelectionKey key) {
        //获得线程并执行
        executorService.submit(() -> {
            try {
                System.out.println("ready... ");
                // 写操作
                SocketChannel writeChannel = (SocketChannel) key.channel();
                //拿到客户端传递的数据
                //ByteArrayOutputStream attachment = (ByteArrayOutputStream)key.attachment();

                //System.out.println("客户端发送来的数据："+new String(attachment.toByteArray()));

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                String message = "hello world!";
                buffer.put(message.getBytes());
                buffer.flip();
                writeChannel.write(buffer);
                writeChannel.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
