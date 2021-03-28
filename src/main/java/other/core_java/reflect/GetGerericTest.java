package other.core_java.reflect;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  2:51 PM
 * @description: 通过反射获取范型信息
 **/
public class GetGerericTest {

    public void test(Map<String,String> map) {
        System.out.println("test");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GetGerericTest.class.getMethod("test", Map.class);

        Type[] genericExceptionTypes = method.getGenericParameterTypes();
        for (Type genericExceptionType : genericExceptionTypes) {
            System.out.println(genericExceptionType);
        }
    }
}
