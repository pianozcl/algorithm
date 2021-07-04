package other.spring.ioc.factorybean.demo1.factorybeantest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import other.spring.ioc.factorybean.demo1.commonbean.UserService;

/**
 * @author : chenliangzhou
 * create at:  2021/4/3  1:19 PM
 * @description:
 *
 * 普通bean，定义什么类型就得到什么类型
 * 工厂bean，需要实现FactoryBean接口，通过泛型指定返回bean类型
 * BeanFactory只是个接口，并不是IOC容器的具体实现，但是Spring容器给出了很多种实现，
 * 如 DefaultListableBeanFactory、XmlBeanFactory、ApplicationContext等，
 * 其中XmlBeanFactory就是常用的一个，该实现将以XML方式描述组成应用的对象及对象间的依赖关系。
 *
 **/
@Component
public class MyBean implements FactoryBean<UserService> {

    @Override
    public UserService getObject() throws Exception {
        //可以返回任意一个对象，不是必须为MyBean
        return new UserService();
    }

    @Override
    public Class<?> getObjectType() {
        return UserService.class;
    }

}


