package other.spring.ioc.filed_inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import other.spring.ioc.filed_inject.dao.Dao;

import javax.annotation.Resource;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  12:43 AM
 * @description:    可以根据名称注入，也可以根据属性注入
 **/
@Component
public class TestResource implements Dao {

    //@Resource    不加参数默认按类型注入，如果有多个实现类会抛异常
    @Resource(name = "oneDao")
    private Dao dao;

    @Value(value = "属性注入")
    private String name;

    @Override
    public void print() {
        dao.print();
        System.out.println(name);
    }
}
