package footprints.customtag.sample2;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午2:50
 */
public class Sample2TagsNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("parent", new Sample2ParentTagParser());
        registerBeanDefinitionParser("child", new Sample2ChildTagParser());
    }
}
