package footprints.customtag.sample1;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 上午11:08
 */
public class JdbcTagsNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("template" , new JdbcTemlateParser());
    }
}
