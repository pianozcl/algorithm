package other.spring.ioc.factorybean.demo1.factorybeantest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 指定要扫描的包
 * @author : chenliangzhou
 * create at:  2021/7/4  6:01 PM
 * @description:
 **/

@Configuration
@ComponentScan("other.spring.ioc.factorybean.demo1.factorybeantest")
public class AppConfig {
}
