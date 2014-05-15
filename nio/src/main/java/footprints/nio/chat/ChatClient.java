package footprints.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by luoquan on 14-4-25.
 */
public class ChatClient {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            boolean connect = sc.connect(new InetSocketAddress(9999));

            ByteBuffer buffer = ByteBuffer.allocate(100);
            buffer.clear();
            buffer.put("hahaha".getBytes());
            while(buffer.hasRemaining()) {
                sc.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
