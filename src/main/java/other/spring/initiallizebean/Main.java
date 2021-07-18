package other.spring.initiallizebean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : chenliangzhou
 * create at:  2021/7/11  11:00 PM
 * @description:
 **/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User)applicationContext.getBean("user");
        System.out.println(user.getName());
    }
}
