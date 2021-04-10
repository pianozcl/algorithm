package other.design_pattern.proxy.dynamic_proxy;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : chenliangzhou
 * create at:  2021/3/29  12:28 AM
 * @description: newProxyInstance参数分别是，类加载器，这个类实现的接口，InvocationHandler类增强的逻辑
 **/
public class AirplaneProxyUpgrated {
    public static void main(String[] args) throws Exception{
        AirplaneImpl airplane = new AirplaneImpl();
        Airplane o = (Airplane) Proxy.newProxyInstance(airplane.getClass().getClassLoader(),
                airplane.getClass().getInterfaces(), //让代理类，和被代理类实现相同的接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("动态代理........");
                        System.out.println(method.getName());
                        System.out.println(JSON.toJSONString(args));
                        method.invoke(airplane, args);
                        return null;
                    }
                });

        o.fly();
        o.land("beijing");
    }
}
