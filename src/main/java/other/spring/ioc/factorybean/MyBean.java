package other.spring.ioc.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : chenliangzhou
 * create at:  2021/4/3  1:19 PM
 * @description:
 *
 * 普通bean，定义什么类型就得到什么类型
 * 工厂bean，需要实现FactoryBean接口，通过泛型指定返回bean类型
 **/
@Component(value = "myBean")
public class MyBean implements FactoryBean<String> {

    @Override
    public String getObject() throws Exception {
        return "可以返回任意一个对象，不是必须为MyBean";
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

}


