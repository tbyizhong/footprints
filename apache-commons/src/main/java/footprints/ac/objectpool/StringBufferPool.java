package footprints.ac.objectpool;

import org.apache.commons.pool.BaseObjectPool;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-1
 * Time: 下午2:28
 */
public class StringBufferPool extends BaseObjectPool<StringBuffer> {
    StringBuffer sb = new StringBuffer();
    @Override
    public StringBuffer borrowObject() throws Exception {
        return  sb;
    }

    @Override
    public void returnObject(StringBuffer obj) throws Exception {
        sb.setLength(0);
    }

    @Override
    public void invalidateObject(StringBuffer obj) throws Exception {
        sb = new StringBuffer();
    }
}
