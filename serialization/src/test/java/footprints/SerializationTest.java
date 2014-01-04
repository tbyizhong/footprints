package footprints;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Test;

import java.io.*;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-4
 * Time: 下午9:13
 */
public class SerializationTest {
    public static final int OBJECT_NUMBER = 100000;

    @Test
    public void testJavaSerialization() throws IOException {
        File file = new File("/tmp/serialization_java");
        FileOutputStream fos = new FileOutputStream(file, false);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        long start = System.currentTimeMillis();
        for (int i = 0; i < OBJECT_NUMBER; i++) {
            oos.writeObject(new Data());
        }
        System.out.println("java takes " + (System.currentTimeMillis()-start) + "ms");
        oos.close();
        fos.close();
    }

    @Test
    public void testKryoSerialization() throws IOException  {
        File file = new File("/tmp/serialization_kryo");
        FileOutputStream fos = new FileOutputStream(file, false);

        Output output = new Output(fos);

        Kryo kryo = new Kryo();

        long start = System.currentTimeMillis();
        for (int i = 0; i < OBJECT_NUMBER; i++) {
            kryo.writeObject(output, new Data());
        }
        System.out.println("kryo takes " + (System.currentTimeMillis()-start) + "ms");
        fos.close();
    }
}

class Data implements Serializable {
    private static final long serialVersionUID = 776471000219975560L;
    private static AtomicInteger count = new AtomicInteger(0);
    private int number;
    private long time;
    private String uniqueId;

    public Data() {
        number = count.incrementAndGet();
        time = System.currentTimeMillis();
        uniqueId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Data number " + number + " created at " + time + " uniqueId:" + uniqueId;
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    long getTime() {
        return time;
    }

    void setTime(long time) {
        this.time = time;
    }

    String getUniqueId() {
        return uniqueId;
    }

    void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}