package other.spring.ioc.factorybean.demo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import other.spring.ioc.factorybean.demo2.factorybeantest.CarFactoryBean;

/**
 * 指定要扫描的包
 * @author : chenliangzhou
 * create at:  2021/7/4  6:01 PM
 * @description:
 **/

@Configuration
@ComponentScan("other.spring.ioc.factorybean.demo2")
public class AppConfig {

    @Bean
    public CarFactoryBean carFactoryBean() {
        CarFactoryBean carFactoryBean = new CarFactoryBean();
        carFactoryBean.setCarInfo("tesla,200km/h,50000$");
        return  carFactoryBean;
    }
}
