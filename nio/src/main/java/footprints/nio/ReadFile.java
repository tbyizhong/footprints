package footprints.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by luoquan on 14-4-23.
 */
public class ReadFile {
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());
//        RandomAccessFile aFile = new RandomAccessFile("D:\\MyProjects\\bookmarks.xml", "rw");
//        RandomAccessFile bFile = new RandomAccessFile("D:\\MyProjects\\bookmarks2.xml", "rw");
//        FileChannel inChannel = aFile.getChannel();
//        FileChannel outChannel = aFile.getChannel();
//
//        long size = inChannel.size();
//        System.out.println(outChannel.transferFrom(inChannel, 0, size));
//        System.out.println(inChannel.transferTo(0, size, outChannel));
//
//        outChannel.close();;
    }
}
