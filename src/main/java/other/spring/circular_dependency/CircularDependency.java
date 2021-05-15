package other.spring.circular_dependency;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import other.spring.AppConfig;

/**
 * @author : chenliangzhou
 * create at:  2021/5/10  1:52 AM
 * @description: 循环依赖
 **/

@Component
public class CircularDependency {

    public static void main(String[] args) {
        //三级缓存源码
        new DefaultSingletonBeanRegistry();


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        A a = context.getBean(A.class);
        a.print();
    }
}
