package footprints.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by luoquan on 14-4-25.
 */
public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress(9999));
            System.out.println("going to invoke accept...");
            while(true) {
                SocketChannel sc = ssc.accept();
                System.out.println("accept invoke successfully");

                ByteBuffer buffer = ByteBuffer.allocate(40);
                buffer.clear();
                sc.read(buffer);

                System.out.println(new String(buffer.array()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
