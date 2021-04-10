package other.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : chenliangzhou
 * create at:  2021/4/3  11:42 PM
 * @description:
 **/
@Configuration  //作为配置类，替代xml
@ComponentScan(basePackages = "other.spring")   //指定扫描的包
@EnableAspectJAutoProxy //开启AspectJ
public class AppConfig {

}
