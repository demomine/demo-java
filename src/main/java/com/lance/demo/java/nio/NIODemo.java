package com.lance.demo.java.nio;

import java.io.ByteArrayOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIODemo {
    public void server() throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(1055));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int select = selector.select();
            if (select > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = channel.accept();
                        System.out.println("remote address : " + channel.getLocalAddress());
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        RequestProcessor.processorRequest(key,selector);
                    } else if (key.isWritable()) {
                        ResponseProcessor.processorResponse(key);
                    }
                }
            }
        }
    }

    public void client() throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(1055));

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("hello world".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        socketChannel.shutdownOutput();

        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        while (true) {
            byteBuffer.clear();
            int read = socketChannel.read(byteBuffer);
            byteBuffer.flip();
            if (read <= 0 ) {
                break;
            }
            while (byteBuffer.hasRemaining()) {
                byteOutputStream.write(byteBuffer.get());
            }
        }
        System.out.println("receive message: " + new String(byteOutputStream.toByteArray()));
        byteOutputStream.close();
        socketChannel.close();

    }

}
