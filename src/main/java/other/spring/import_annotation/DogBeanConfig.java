package other.spring.import_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : chenliangzhou
 * create at:  2021/5/10  2:47 AM
 * @description:
 **/
@Configuration
@ComponentScan(basePackages = "other.spring.import_annotation")
@Import(DogBean.class)  //DogBean没有加任何IOC注解，通过import也可加入IOC容器
public class DogBeanConfig {

}
