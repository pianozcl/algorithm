package other.design_pattern.proxy.dynamic_proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : chenliangzhou
 * create at:  2021/3/28  11:36 PM
 * @description:
 *
 * 动态代理本质，类加载 接口，以及实现类到堆内存空间，而代理类，则是通过反射，动态创建。这根静态代理的区别是，静态代理在类加载之前已经定义好了
 **/
public class AirplaneProxy {
    public static void main(String[] args) throws Exception {
        //参数：Airplane类加载器    Airplane接口（代理类和被代理类共同实现的接口）
        //通过接口到Class，生成代理类到Class
        Class<?> proxyClass = Proxy.getProxyClass(Airplane.class.getClassLoader(), Airplane.class);

        //得到构造器
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);

        //反射创建代理类（提取接口信息）
        //constructor.newInstance用于生成动态代理类，而动态代理类又是什么样到功能呢？由InvocationHandler来定义
        Airplane airplane = (Airplane) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理.........");
                method.invoke(new AirplaneImpl(), args);
                return null;
            }
        });

        //代理类到对象
        airplane.fly();

        byte[] dynamicClasses = ProxyGenerator.generateProxyClass("DynamicClass", airplane.getClass().getInterfaces());
        FileOutputStream outputStream = new FileOutputStream("/Users/chenliangzhou/Desktop/personal-notes/algorithm/src/main/java/other/design_pattern/proxy/dynamic_proxy/DynamicClass.class");
        outputStream.write(dynamicClasses);
        outputStream.flush();
    }
}
