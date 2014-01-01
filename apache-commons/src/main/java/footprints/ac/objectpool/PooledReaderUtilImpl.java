package footprints.ac.objectpool;

import org.apache.commons.pool.ObjectPool;

import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-1
 * Time: 下午2:12
 */
public class PooledReaderUtilImpl implements ReaderUtil {
    private ObjectPool<StringBuffer> pool;

    public ObjectPool<StringBuffer> getPool() {
        return pool;
    }

    public void setPool(ObjectPool<StringBuffer> pool) {
        this.pool = pool;
    }

    public String readerToString(Reader reader) {
        char[] buffer = new char[1024];
        StringBuffer sb = null;
        try {
            sb = pool.borrowObject();
            int r = reader.read();
            while (-1 != r) {
                sb.append((char)r);
                r = reader.read();
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                pool.returnObject(sb);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
