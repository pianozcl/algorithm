package other.spring.ioc.filed_inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import other.spring.ioc.filed_inject.dao.Dao;

/**
 * @author : chenliangzhou
 * create at:  2021/4/4  12:27 AM
 * @description: 按类型注入的autowired
 **/
@Component
public class TestAutowired {

    //@Autowired       由于实现类有多个，这里使用Autowired会有异常
    private Dao dao;

    public void print() {
        dao.print();
    }
}
