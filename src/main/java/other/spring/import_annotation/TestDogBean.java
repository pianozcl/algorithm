//package other.spring.import_annotation;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import other.spring.AppConfig;
//
///**
// * @author : chenliangzhou
// * create at:  2021/4/10  10:24 PM
// * @description:
// **/
//
//@Import(AppConfig.class)
//@Configuration
//public class TestDogBean {
//    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(TestDogBean.class,args);
//        DogBean bean = context.getBean(DogBean.class);
//        bean.say();
//    }
//}
