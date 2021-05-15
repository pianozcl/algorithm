package other.spring;

import org.springframework.context.annotation.*;
import other.spring.configuration_annotation.TestBean;
import other.spring.import_annotation.DogBean;

/**
 * @author : chenliangzhou
 * create at:  2021/4/3  11:42 PM
 * @description:
 **/
@Configuration  //作为配置类，替代xml
@ComponentScan(basePackages = "other.spring")   //指定扫描的包
@EnableAspectJAutoProxy //开启AspectJ
public class AppConfig {


    public AppConfig() {
        System.out.println("AppConfig初始化");
    }

    @Bean(initMethod = "start", destroyMethod = "cleanUp")
    @Scope("prototype")
    public TestBean testBean() {        //TestBean初始化指定bean加载到IOC容器，效果等同于TestBean上加@Component
        return new TestBean();
    }
}
