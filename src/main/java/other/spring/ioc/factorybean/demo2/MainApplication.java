package other.spring.ioc.factorybean.demo2;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import other.spring.ioc.factorybean.demo2.commonbean.Car;

/**
 * @author : chenliangzhou
 * create at:  2021/7/4  6:02 PM
 * @description:
 **/
public class MainApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Car bean = applicationContext.getBean(Car.class);
        System.out.println(JSON.toJSONString(bean));    //{"brand":"tesla","price":"50000$","speed":"200km/h"}


    }
}
