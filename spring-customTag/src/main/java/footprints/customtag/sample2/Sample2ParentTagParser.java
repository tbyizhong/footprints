package footprints.customtag.sample2;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午2:51
 */
public class Sample2ParentTagParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        super.doParse(element, parserContext, builder);
//        builder.addPropertyValue("child",
//                parserContext.getDelegate().parseCustomElement(
//                        DomUtils.getChildElementByTagName(element, "child"),
//                        builder.getRawBeanDefinition()));

        ManagedMap map = new ManagedMap();

        List<Element> children = DomUtils.getChildElementsByTagName(element, "child");
        for (Element child : children) {

            String name = child.getAttribute("name");
            BeanDefinition bean = parserContext.getDelegate().parseCustomElement(
                    child, builder.getRawBeanDefinition());

            map.put(name, bean);
        }

        System.out.println(map);

        builder.addPropertyValue("children", map);
    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Parent.class;
    }
}
