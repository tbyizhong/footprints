package footprints.customtag.sample1;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Element;

/**
 * Created with IntelliJ IDEA.
 * User: luoquan
 * Date: 13-10-19
 * Time: 上午11:09
 */
public class JdbcTemlateParser extends AbstractSimpleBeanDefinitionParser {
    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {

        // 从标签中取出对应的属性值
        String dataSource = element.getAttribute("dataSource");

        builder.addPropertyReference("dataSource", dataSource);
        System.out.println("JdbcTemlateParser:dataSource name is " + dataSource);
    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return JdbcTemplate.class;
    }
}
