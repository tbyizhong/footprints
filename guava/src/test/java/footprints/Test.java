package footprints;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yizhong
 * Date: 14-2-12
 * Time: 下午1:50
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    @org.junit.Test
    public void testRef() throws Exception {
        Method method = Test.class.getMethod("getStringList", null);


        Type returnType = method.getGenericReturnType();

        if(returnType instanceof ParameterizedType){
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for(Type typeArgument : typeArguments){
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }

    }

    @org.junit.Test
    public void testRef2() throws Exception {
        Field field = Test.class.getField("stringList");

        Type genericFieldType = field.getGenericType();

        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for(Type fieldArgType : fieldArgTypes){
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
    }

    List<String> stringList = new ArrayList<String>();

    public List<String> getStringList(){
        return this.stringList;
    }
}
