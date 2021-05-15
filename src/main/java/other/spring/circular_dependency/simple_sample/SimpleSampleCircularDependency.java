package other.spring.circular_dependency.simple_sample;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : chenliangzhou
 * create at:  2021/5/10  3:11 AM
 * @description: 自己代码实现，解决循环依赖
 **/
public class SimpleSampleCircularDependency {
    public static void main(String[] args) throws Exception{
        Class[] classes = {A.class, B.class};
        for (Class c : classes) {
            getBean(c);
        }

        A a = (A) cacheMap.get("a");
        a.print();
        a.getB().print();
    }

    private static Map<String, Object> cacheMap = new HashMap<>(2);


    /**
     * 初始化一个bean，通过反射填充属性。解决循环依赖问题
     * @author zhouchenliang
     * @date 3:41 AM 2021/5/10
     * @param
     * @return
     * @throws
     **/
    private static <T> T getBean(Class<T> beanClass) throws Exception {
        //bean名称定义为类小写
        String beanName = beanClass.getSimpleName().toLowerCase();

        //如果已经存在bean直接返回
        if (cacheMap.containsKey(beanName)) {
            return (T) cacheMap.get(beanName);
        }

        //通过反射创建当前bean
        Object object = beanClass.getDeclaredConstructor().newInstance();

        //加入缓存
        cacheMap.put(beanName, object);

        //获取当前对象中到属性
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();

            //将属性注入到bean中，假如存在直接注入，不存在则创建并注入
            field.set(object, cacheMap.containsKey(fieldBeanName) ? cacheMap.get(fieldBeanName) : getBean(fieldClass));
        }

        return (T) object;
    }
}
