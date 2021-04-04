package other.spring.ioc.factorybean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import other.spring.AppConfig;
import other.spring.ioc.filed_inject.TestAutowired;
import other.spring.ioc.filed_inject.TestQualifier;
import other.spring.ioc.filed_inject.TestResource;

/**
 * @author : chenliangzhou
 * create at:  2021/4/3  1:32 PM
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)  //单元测试需要引入spring-test依赖
@ContextConfiguration(classes = AppConfig.class)    //这里指定Configuration配置类，也可以指定xml
public class MyBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test () {
        String myBean = applicationContext.getBean("myBean", String.class);
        System.out.println(myBean);
    }

    /**
     * 假如@Autowired注入的属性，有多个实现类，则会抛出NoUniqueBeanDefinitionException异常
     */
//    @Test
//    public void testAutowired() {
//        TestAutowired testAutowired = applicationContext.getBean("testAutowired", TestAutowired.class);
//        testAutowired.print();
//    }

    /**
     * 由于通过Qualifier指定了bean名称，不会报错
     */
    @Test
    public void testQualifier() {
        TestQualifier testQualifier = applicationContext.getBean("testQualifier", TestQualifier.class);
        testQualifier.print();
    }

    @Test
    public void testResource() {
        TestResource testResource = applicationContext.getBean("testResource", TestResource.class);
        testResource.print();
    }
}
