package footprints.customtag.sample2;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午2:38
 */
public class Parent {
    private Map<String, Child> children;

    public Map<String, Child> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Child> children) {
        this.children = children;
    }
}
