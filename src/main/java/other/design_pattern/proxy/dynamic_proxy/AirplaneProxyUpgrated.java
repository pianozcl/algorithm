package other.design_pattern.proxy.dynamic_proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : chenliangzhou
 * create at:  2021/3/29  12:28 AM
 * @description:
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
                        method.invoke(airplane, args);
                        return null;
                    }
                });

        o.fly();
    }
}
