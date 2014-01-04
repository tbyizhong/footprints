package footprints.serialization;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 14-1-4
 * Time: 下午8:53
 */
public interface ObjectStorage {
    void storeObject(Object obj);
    void storeObject(List<Object> objList);
}
