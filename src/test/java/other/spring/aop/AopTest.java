package other.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import other.spring.AppConfig;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  8:24 PM
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)  //单元测试需要引入spring-test依赖
@ContextConfiguration(classes = AppConfig.class)    //这里指定Configuration配置类，也可以指定xml
public class AopTest {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() {
        User user = applicationContext.getBean("user", User.class);
        user.add();
    }
}
