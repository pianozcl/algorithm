package other.spring.ioc.factorybean.demo1.factorybeantest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import other.spring.ioc.factorybean.demo1.commonbean.UserService;

/**
 * @author : chenliangzhou
 * create at:  2021/7/4  6:02 PM
 * @description:
 **/
public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("容器启动完成");
        UserService bean = applicationContext.getBean(UserService.class);
        System.out.println(bean);

        Object myBean = applicationContext.getBean("myBean");
        System.out.println(myBean);

        Object bean1 = applicationContext.getBean("&myBean");
        System.out.println(bean1);

        /**
         * 容器启动完成
         * user service......
         * other.spring.ioc.factorybean.commonbean.UserService@7334aada
         * other.spring.ioc.factorybean.commonbean.UserService@7334aada
         * other.spring.ioc.factorybean.factorybeantest.MyBean@1d9b7cce
         *
         * 由打印结果引入一些思考
         * 1. AppConfig并没有扫描到commonbean下的类，却可以获取到userservice的实例
         * 2. 直接获取FactoryBean的myBean打印hashcode跟userService一样？（因为如果不加&，默认返回的是getObject方法返回的bean）
         * 3. 获取真正的factorybean实例，前面要加&
         */
    }
}
