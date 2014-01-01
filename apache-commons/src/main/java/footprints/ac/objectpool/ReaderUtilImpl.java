package footprints.ac.objectpool;

import java.io.IOException;
import java.io.Reader;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-1
 * Time: 下午2:12
 */
public class ReaderUtilImpl implements ReaderUtil {
    public String readerToString(Reader reader) {
        StringBuffer sb = new StringBuffer();

        try {
            int r = reader.read();
            while (-1 != r) {
                sb.append((char)r);
                r = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
