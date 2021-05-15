package other.spring.import_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import other.spring.AppConfig;

/**
 * @author : chenliangzhou
 * create at:  2021/4/10  10:24 PM
 * @description:
 **/
public class TestDogBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DogBeanConfig.class);
        DogBean bean = context.getBean(DogBean.class);
        bean.say();
    }
}
