package footprints.ac.objectpool;

import org.apache.commons.pool.impl.SoftReferenceObjectPool;
import org.junit.Test;

import java.io.StringReader;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-1
 * Time: 下午2:16
 */
public class ReaderUtilTest {
    private static final int NUM = 1000000;
    @Test
    public void testReaderUtilImpl() {
        ReaderUtilImpl ru = new ReaderUtilImpl();

        long start = System.currentTimeMillis();
        for(int i =0;i<NUM;i++) {
            StringReader reader = new StringReader("0123456789abcdefghijklmnopqrstuvwxyz");
            String out = ru.readerToString(reader);
            //System.out.println(out);
        }
        System.out.println(System.currentTimeMillis()  - start);
    }

    @Test
    public void testPooledReaderUtilImpl() {
//        SoftReferenceObjectPool<StringBuffer> pool = new SoftReferenceObjectPool<StringBuffer>();
        PooledReaderUtilImpl ru = new PooledReaderUtilImpl();
        ru.setPool(new StringBufferPool());

        long start = System.currentTimeMillis();
        for(int i =0;i<NUM;i++) {
            StringReader reader = new StringReader("0123456789abcdefghijklmnopqrstuvwxyz");
            String out = ru.readerToString(reader);
            //System.out.println(out);
        }
        System.out.println(System.currentTimeMillis()  - start);
    }
}
