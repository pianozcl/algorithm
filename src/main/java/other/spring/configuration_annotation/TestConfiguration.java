package other.spring.configuration_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import other.spring.AppConfig;

/**
 * @author : chenliangzhou
 * create at:  2021/4/10  9:41 PM
 * @description:
 **/
public class TestConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        //如果AppConfig不指定scope，默认单例，则初始化一次，hashcode相同。如果指定scope为prototype，会初始化两次，且hashcode不同
        TestBean testBean = (TestBean)context.getBean("testBean");
        testBean.hello();
        System.out.println(testBean.hashCode());

        System.out.println("*******************************");

        TestBean testBean2 = (TestBean)context.getBean("testBean");
        testBean2.hello();
        System.out.println(testBean2.hashCode());
    }
}
