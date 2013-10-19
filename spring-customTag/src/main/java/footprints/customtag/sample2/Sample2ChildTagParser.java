package footprints.customtag.sample2;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 下午2:51
 */
public class Sample2ChildTagParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        int age = Integer.parseInt(element.getAttribute("age"));

        builder.addPropertyValue("name", name);
        builder.addPropertyValue("age", age);
        System.out.println("Sample2ChildTagParser building Child:" + name + "-" + age);
    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Child.class;
    }
}
